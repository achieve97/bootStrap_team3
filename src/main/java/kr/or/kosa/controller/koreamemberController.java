package kr.or.kosa.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.kosa.dao.koreamemberDao;
import kr.or.kosa.dto.koreamemberDto;

/*
 comnmand 방식
 @WebServlet("/web.do")
 web.do?cmd=login
 web.do?cmd=loginok
 
 
 Url 방식
 주소가 고정되면 안된다.
 @WebServlet("/*.do") // a.do, b.do
 	*.do >> login.do
 	*.do >> loginok.do
 */

@WebServlet("*.do")
public class koreamemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public koreamemberController() {
		super();
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		koreamemberDao dao = new koreamemberDao();
		koreamemberDto dto = new koreamemberDto();
		HttpSession session = request.getSession(); // 세션값
		
		    String id= "";
	        String pwd = "";
	        String name = ""; 
	        int age = 0;
	        String gender = "";
	        String email = "";
	        String ip = request.getRemoteAddr();
	        
	        boolean success =  false;
	         int check = 0;

		// 1. 한글처리
		request.setCharacterEncoding("UTF-8");
		// 2. 데이터 받기 (입력데이터, 판단데이터(command))
		// String command = request.getParameter("cmd");

		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String urlcommand = requestURI.substring(contextPath.length());

		System.out.println("requestURI : " + requestURI);
		System.out.println("contextPath : " + contextPath);
		System.out.println("urlcommand : " + urlcommand);

		/*
		 * http://192.168.0.26:8090/WebServlet/register.do requestURI :
		 * /WebServlet/register.do contextPath : /WebServlet urlcommand : /register.do
		 * 
		 * 
		 * URL 마지막 주소를 추출하기... 판단의 근거 ...
		 * 
		 */

		// 3. 요청 서비스 판단 (command 통해서) 문자열 비교
		// 3.1 판단에 의해서 서비스 동작 (DB작업 , 암호화 , ...)
		String viewpage = "";

		if (urlcommand.equals("/Join.do")) { // 회원가입 페이지
			// 회원가입페이지(VIEW)
			// VIEW만 전달하기
			viewpage = "/WEB-INF/views/register/join.jsp";
			// 필요에 따라서 request 데이터 저장

		} else if (urlcommand.equals("/MemberJoin.do")) { // 회원가입 처리
			// 회원가입 처리 (=DB작업)
			// 입력 데이터 >> DB연결 >> insert >> 여부따라서 >> 처리
			 id = request.getParameter("id");
			 pwd = request.getParameter("pwd");
			 name = request.getParameter("name");
			 age = Integer.parseInt(request.getParameter("age"));
			 gender = request.getParameter("gender");
			 email = request.getParameter("email");

			
			dto.setId(id);
			dto.setPwd(pwd);
			dto.setName(name);
			dto.setAge(age);
			dto.setGender(gender);
			dto.setEmail(email);
			dto.setIp(request.getRemoteAddr().toString());

			int result = dao.JoinMember(dto);

			String resultdata = "";
			if (result > 0) {
				resultdata = "welcome to kosa" + dto.getId() + "님";
			} else {
				resultdata = "Insert Fail.... retry...";
			}

			// 4. 데이터 저장
			request.setAttribute("data", resultdata);
			// view 설정하기
			viewpage = "/pages-login.jsp";

		}else if(urlcommand.equals("/login.do")) { // 로그인 페이지로 이동
        	viewpage="/pages-login.jsp";
        }else if(urlcommand.equals("/loginok.do")) {
 		    id = request.getParameter("id");
 		    pwd = request.getParameter("pwd"); 		   
           dto.setId(id);
           dto.setPwd(pwd);

           success = dao.idCheck(id, pwd);   
            
            if(success==true) {
            	session.setAttribute("id", id);
     	
	            if(id.equals("admin")) {
	            	try {
	    				List<koreamemberDto> memberlist = dao.getMemberList();

	    				// 데이터 저장
	    				request.setAttribute("memberlist", memberlist);
	    				// view 지정
	    				viewpage = "/memberlist.jsp";

	    			} catch (Exception e) {
	    				e.printStackTrace();
	    			}
	            }
	            else {
	                viewpage="/users-profile.jsp";
	            }
            }
            else {
            	viewpage="/pages-error-404.jsp";            
            }
            
	   }else if(urlcommand.equals("/logout.do")) { // 로그아웃
		   viewpage = "/logout.jsp";
	   } else if (urlcommand.equals("/MemberList.do")) { // 회원정보 리스트

			
			try {
				List<koreamemberDto> memberlist = dao.getMemberList();

				// 데이터 저장
				request.setAttribute("memberlist", memberlist);
				// view 지정
				viewpage = "/memberlist.jsp";

			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (urlcommand.equals("/MemberDelete.do")) { // 회원삭제

			

			 id = request.getParameter("id");

			int result = dao.deleteMember(id);

			if (result > 0) {
				try {
					List<koreamemberDto> memberlist = dao.getMemberList();

					// 데이터 저장
					request.setAttribute("memberlist", memberlist);
					// view 지정
					viewpage = "/memberlist.jsp";

				} catch (Exception e) {
					e.printStackTrace();
				}
				
			} else {
				viewpage = "/pages-login.jsp";
			}
		}else if(urlcommand.equals("/edit.do")) {         
	         
	         id = request.getParameter("id");
	         session.setAttribute("id", id);
	         dto = dao.getUpdateMember(id);
	         request.setAttribute("dao", dto);
	         /* System.out.println(); */
	         viewpage="/pages-edit.jsp";
	         
	      }else if(urlcommand.equals("/update.do")) {
	         name = request.getParameter("name");
	         age = Integer.parseInt(request.getParameter("age"));
	         email = request.getParameter("email");
	         gender = request.getParameter("gender");
	         id = request.getParameter("id");
	         dto.setName(name);
	         dto.setAge(age);
	         dto.setEmail(email);
	         dto.setGender(gender);
	         dto.setId(id);
	         
	         check = dao.update(dto);
	         
	         List<koreamemberDto> memberlist = dao.getMemberList();

			// 데이터 저장
			request.setAttribute("memberlist", memberlist);
	         
	         
	         if(check>0) {
	            viewpage="/memberlist.jsp";
	         }else {
	            viewpage="/pages-register.jsp";
	         }
	         
	      }

		// 5. view 설정하기
		RequestDispatcher dis = request.getRequestDispatcher(viewpage);

		// 6. View forward 하기
		dis.forward(request, response);

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

}