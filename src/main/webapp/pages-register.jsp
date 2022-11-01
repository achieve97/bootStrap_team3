<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">

<title>Pages / Register - NiceAdmin Bootstrap Template</title>
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
	<jsp:include page="/commonmodule/sidebar.jsp"></jsp:include>

	<main>
		<div class="container">

			<section
				class="section register min-vh-100 d-flex flex-column align-items-center justify-content-center py-4">
				<div class="container">
					<div class="row justify-content-center">
						<div
							class="col-lg-4 col-md-6 d-flex flex-column align-items-center justify-content-center">

							<div class="d-flex justify-content-center py-4">
								<a href="index.html"
									class="logo d-flex align-items-center w-auto"> <img
									src="assets/img/logo.png" alt=""> <span
									class="d-none d-lg-block">NiceAdmin</span>
								</a>
							</div>
							<!-- End Logo -->

							<div class="card mb-3">

								<div class="card-body">

									<div class="pt-4 pb-2">
										<h5 class="card-title text-center pb-0 fs-4">Create an
											Account</h5>
										<p class="text-center small">Enter your personal details
											to create account</p>
									</div>

									<form form
										action="${pageContext.request.contextPath}/MemberJoin.do"
										method="post" name="joinForm" id="joinForm"
										class="row g-3 needs-validation" novalidate>
										<div class="col-12">
											<label for="your ID" class="form-label">Your ID</label> <input
												type="text" name="id" class="form-control" id="yourName"
												required>
											<div class="invalid-feedback">Please, enter your ID!</div>
										</div>

										<div class="col-12">
											<label for="yourPassword" class="form-label">Your
												Password</label> <input type="password" name="pwd"
												class="form-control" id="pwd" required>
											<div class="invalid-feedback">Please enter a valid
												Password!</div>
										</div>

										<div class="col-12">
											<label for="your Name" class="form-label">Your Name</label> <input
												type="text" name="name" class="form-control" id="yourName"
												required>
											<div class="invalid-feedback">Please, enter your Name!</div>
										</div>

										<div class="col-12">
											<label for="your Age" class="form-label">Your Age</label> <input
												type="text" name="age" class="form-control" id="age"
												required>
											<div class="invalid-feedback">Please, enter your Age!</div>
										</div>

										<div class="col-12">
											<label for="your Gender" class="form-label">Your
												Gender  </label> <input type="radio" name="gender" id="gender"
												value="여" checked>여자 <input type="radio"
												name="gender" id="gender" value="남">남자

										</div>

										<div class="col-12">
											<label for="yourPassword" class="form-label">Email</label>
											<input type="email" name="email" class="form-control"
												id="email" required>
											<div class="invalid-feedback">Please enter your Email!</div>
										</div>

										<div class="col-12">
											<button class="btn btn-primary w-100" type="submit">회원가입</button>
										</div>
										<div class="col-12">
											<p class="small mb-0">
												아이디가 있으신가요?  <a href="pages-login.html"> Log in</a>
											</p>
										</div>
									</form>

								</div>
							</div>

							<div class="credits">
								<!-- All the links in the footer should remain intact. -->
								<!-- You can delete the links only if you purchased the pro version. -->
								<!-- Licensing information: https://bootstrapmade.com/license/ -->
								<!-- Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/nice-admin-bootstrap-admin-html-template/ -->
								Designed by <a href="https://bootstrapmade.com/">BootstrapMade</a>
							</div>

						</div>
					</div>
				</div>

			</section>

		</div>
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