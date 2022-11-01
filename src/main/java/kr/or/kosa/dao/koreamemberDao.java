package kr.or.kosa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import kr.or.kosa.dto.koreamemberDto;
import kr.or.kosa.utils.ConnectionHelper;


/*
1. DB연결 POOL
2. insert 작업 
insert into mvcregister(id,pwd,email) values(?,?,?)

*/
public class koreamemberDao {
	
	
	
	
	 //계정 수정 조회
	   public koreamemberDto getUpdateMember(String id){
	    	 koreamemberDto Dto = new koreamemberDto(); 
	    	 Connection conn = null;
	    	 PreparedStatement pstmt = null;
	    	 ResultSet rs = null;
		   try {
	         conn = ConnectionHelper.getConnection("oracle");
	         String sql = "select id, pwd, name, age, trim(gender),email from koreamember where id=?";
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, id);
	         
	         rs= pstmt.executeQuery();
	         
	         if (rs.next()) {
	            Dto = new koreamemberDto();
	            Dto.setId(rs.getString(1));
	            Dto.setPwd(rs.getString(2));
	            Dto.setName(rs.getString(3));
	            Dto.setAge(rs.getInt(4));
	            Dto.setGender(rs.getString(5));
	            Dto.setEmail(rs.getString(6));
	          }
	         
	      } catch (Exception e) {
	         System.out.println(e.getMessage());
	      }finally {
	         ConnectionHelper.close(pstmt);   
	         ConnectionHelper.close(rs);
	         ConnectionHelper.close(conn);
	      }
	      return Dto;
	   }
	  
	   //계정 수정
	   public int update(koreamemberDto dto) {
		   int resultrow = 0;
		   koreamemberDto Dto = new koreamemberDto(); 
		     Connection conn = null;
		     PreparedStatement pstmt = null;
	      try {
	    	 
	         String pwdCheck;
	         
	         conn = ConnectionHelper.getConnection("oracle");
	         String sql="update koreamember set name=? , age=? , email=? , gender=? where id=?";
	         pstmt = conn.prepareStatement(sql);
	         
	         pstmt.setString(1, dto.getName());
	         pstmt.setInt(2, dto.getAge());
	         pstmt.setString(3, dto.getEmail());
	         pstmt.setString(4, dto.getGender());
	         pstmt.setString(5, dto.getId());
	         
	         resultrow = pstmt.executeUpdate(); 
	               
	      } catch (Exception e) {
	         System.out.println(e.getMessage());
	      }finally {
	         ConnectionHelper.close(pstmt);
	         ConnectionHelper.close(conn);
	      }      
	      return resultrow;
	   }
	
	
	
  
   //writeOk ...
   //insert into mvcregister(id,pwd,email) values(?,?,?)
   public int JoinMember(koreamemberDto dto) {
      Connection conn = null;
      PreparedStatement pstmt = null;
      int resultrow=0;
      try {
          conn = ConnectionHelper.getConnection("oracle");
          String sql="insert into koreaMember(id,pwd,name,age,gender,email,ip) values(?,?,?,?,?,?,?)";
          pstmt = conn.prepareStatement(sql);
          
          pstmt.setString(1,dto.getId());
          pstmt.setString(2,dto.getPwd());
          pstmt.setString(3,dto.getName());
          pstmt.setInt(4,dto.getAge());
          pstmt.setString(5,dto.getGender());
          pstmt.setString(6,dto.getEmail());
          pstmt.setString(7,dto.getIp());
          
  
          resultrow = pstmt.executeUpdate();
      } catch (SQLException e) {
      
         e.printStackTrace();
      }finally {
         ConnectionHelper.close(pstmt);
         ConnectionHelper.close(conn);
      }
      return resultrow;
   }
   
	//로그인 체크
	// 여기서 부터 
	public int login(String id, String pwd) { // 어떤 계정에 대한 실제로 로그인을 시도하는 함수, 인자값으로 ID와 Password를 받아 login을 판단함.
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String SQL = "SELECT pwd FROM koreaMember WHERE id = ?"; // 실제로 DB에 입력될 명령어를 SQL 문장으로 만듬.
		
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1,  id);
			rs = pstmt.executeQuery(); // 어떠한 결과를 받아오는 ResultSet 타입의 rs 변수에 쿼리문을 실행한 결과를 넣어줌 
			if (rs.next()) {
				if (rs.getString(1).contentEquals(pwd)) {
					return 1; // 로그인 성공
				}
				else {
					return 0; // 비밀번호 불일치
				}
			}
			return -1; // 아이디가 없음
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -2; // DB 오류 
	}

 //전체조회
 	public List<koreamemberDto> getMemberList() {
 		Connection conn = null;
 	    PreparedStatement pstmt = null;
 	 	conn = ConnectionHelper.getConnection("oracle");
 		String sql="select id, ip from koreaMember";
 		List<koreamemberDto> memberlist = null;
 		ResultSet rs = null;
 		try {
 	 		pstmt = conn.prepareStatement(sql);
 	 		rs = pstmt.executeQuery();
 	 	
 	 		memberlist = new ArrayList<koreamemberDto>(); 
 	 		//[new memo()][new memo()][new memo()][new memo()]
 	 		while(rs.next()) {
 	 			koreamemberDto k = new koreamemberDto();
 	 			k.setId(rs.getString("id"));
 	 			k.setIp(rs.getString("ip"));
 	 			
 	 			
 	 			memberlist.add(k);
			
 	 		}
 	 	}catch (Exception e) {
 	 		System.out.println(e.getMessage());
		}finally {
	         ConnectionHelper.close(pstmt);
	         ConnectionHelper.close(rs);
	         ConnectionHelper.close(conn);
		}
 		
 		
 		return memberlist;
 	}
 	
 	
 	public int deleteMember(String id) {
 		Connection conn = null;
	    PreparedStatement pstmt = null;
		
	 	conn = ConnectionHelper.getConnection("oracle");
		 int rowcount = 0;
		 
		 try {
			// conn = SingletonHelper.getConnection("oracle");
			 String sql="delete from koreaMember where id=?";
			 pstmt = conn.prepareStatement(sql);
			 pstmt.setString(1, id);
			 rowcount = pstmt.executeUpdate();
		 }catch (Exception e) {
			 e.printStackTrace();
			 System.out.println(e.getMessage());
		 }finally {
			 ConnectionHelper.close(pstmt);
		 }
		 
		 return rowcount;
	}
 	
 	public boolean idCheck(String id, String pwd) {	
 		 boolean ischeck = false;
		  Connection conn = null;
	      PreparedStatement pstmt = null;
	      ResultSet rs= null;
 	   try {
 		 
 		
 	 	
 		   
 		   String pwdCheck;
 		   conn = ConnectionHelper.getConnection("oracle");
 		   String sql="select id, pwd from koreaMember where id=?";
 		   pstmt = conn.prepareStatement(sql);
 		   pstmt.setString(1, id);
 		  		   
 		   rs =  pstmt.executeQuery();
 		   		   
 		   if (rs.next()) {

 	            pwdCheck = rs.getString("pwd");
 	
 	            
 	            if(pwdCheck.equals(pwd)){
 	            	ischeck =  true; // 아이디, 비밀번호 일치
 	            }else{
 	            	ischeck = false; // 비밀번호 불일치
 	            }
 	       }
 		   else {
 			   ischeck = false;
 		   }   // 아이디 존재하지 않음
 	   } catch (Exception e) {
 			System.out.println(e.getMessage());
 	   }finally {
 		   ConnectionHelper.close(pstmt);
 		   ConnectionHelper.close(rs);
 		   ConnectionHelper.close(conn);
 	   }	   
 	   return ischeck;
    }



	

}