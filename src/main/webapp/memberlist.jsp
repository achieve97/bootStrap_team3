<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
	
	<%
	/*  
	 1.관리자만 접근 가능한 페이지
	 2.로그인한 일반 회원이 주소값을 외워서 ... 접근불가 
	 3.그러면  회원에 관련되 모든 페이지 상단에는 아래 코드를 ..... : sessionCheck.jsp >> include 
	*/
	/*  if(session.getAttribute("id") == null || !session.getAttribute("id").equals("admin") ){
		//강제로 페이지 이동
		//out.print("<script>location.href='Ex02_JDBC_Login.jsp'</script>");
		response.sendRedirect("/pages-error-404");
	}  */
%>	
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">

<title>Pages / F.A.Q - NiceAdmin Bootstrap Template</title>
<meta content="" name="description">
<meta content="" name="keywords">

<!-- Favicons -->
<link href="assets/img/favicon.png" rel="icon">
<link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">

<!-- Google Fonts -->
<link href="https://fonts.gstatic.com" rel="preconnect">
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
	rel="stylesheet">

<!-- Vendor CSS Files -->
<link href="assets/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="assets/vendor/bootstrap-icons/bootstrap-icons.css"
	rel="stylesheet">
<link href="assets/vendor/boxicons/css/boxicons.min.css"
	rel="stylesheet">
<link href="assets/vendor/quill/quill.snow.css" rel="stylesheet">
<link href="assets/vendor/quill/quill.bubble.css" rel="stylesheet">
<link href="assets/vendor/remixicon/remixicon.css" rel="stylesheet">
<link href="assets/vendor/simple-datatables/style.css" rel="stylesheet">

<!-- Template Main CSS File -->
<link href="assets/css/style.css" rel="stylesheet">

<!-- =======================================================
  * Template Name: NiceAdmin - v2.4.1
  * Template URL: https://bootstrapmade.com/nice-admin-bootstrap-admin-html-template/
  * Author: BootstrapMade.com
  * License: https://bootstrapmade.com/license/
  ======================================================== -->
</head>

<body>

	<jsp:include page="/commonmodule/header.jsp"></jsp:include>
	<jsp:include page="/commonmodule/sidebaradmin.jsp"></jsp:include>

	<main id="main" class="main">
		<!-- Recent Sales -->
		<div class="col-12">
			<div class="card recent-sales overflow-auto">

				<div class="filter">
					<a class="icon" href="#" data-bs-toggle="dropdown"><i
						class="bi bi-three-dots"></i></a>
					<ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow">
						<li class="dropdown-header text-start">
							<h6>Filter</h6>
						</li>

						<li><a class="dropdown-item" href="#">Today</a></li>
						<li><a class="dropdown-item" href="#">This Month</a></li>
						<li><a class="dropdown-item" href="#">This Year</a></li>
					</ul>
				</div>

				<div class="card-body">
					<h2 class="card-title">
						<b>회원관리 페이지</b> 
					</h2>




					</table>

					<table class="table table-borderless datatable">
						<thead>

							<tr>
								<th scope="col">아이디</th>
								<th scope="col">IP</th>
								<th scope="col">삭제</th>
								<th scope="col">수정</th>

							</tr>
						</thead>
						<tbody>
							<c:forEach var="mem" items="${requestScope.memberlist}">
								<tr>
									<td>${mem.id}</td>
									<td>${mem.ip}</td>
									<td colspan="2">
										<%-- 	<input type="button" value="수정" onclick="location.href='mModiForm?mId=${mem.pwd}'"/>  --%>
										<input type="button" value="삭제"
										onclick="location.href='MemberDelete.do?id=${mem.id}'" />
									</td>
									<td>
										<input type="button" value="수정"
										onclick="location.href='edit.do?id=${mem.id}'" />
									</td>
								</tr>
							</c:forEach>

						</tbody>
					</table>

				</div>

			</div>
		</div>
		<!-- End Recent Sales -->
	</main>
	<!-- End #main -->

	<jsp:include page="/commonmodule/footer.jsp"></jsp:include>

	<a href="#"
		class="back-to-top d-flex align-items-center justify-content-center"><i
		class="bi bi-arrow-up-short"></i></a>

	<!-- Vendor JS Files -->
	<script src="assets/vendor/apexcharts/apexcharts.min.js"></script>
	<script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script src="assets/vendor/chart.js/chart.min.js"></script>
	<script src="assets/vendor/echarts/echarts.min.js"></script>
	<script src="assets/vendor/quill/quill.min.js"></script>
	<script src="assets/vendor/simple-datatables/simple-datatables.js"></script>
	<script src="assets/vendor/tinymce/tinymce.min.js"></script>
	<script src="assets/vendor/php-email-form/validate.js"></script>

	<!-- Template Main JS File -->
	<script src="assets/js/main.js"></script>

</body>

</html>