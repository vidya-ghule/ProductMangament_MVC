<!--<jsp:include page="menu.jsp" />-->

<html>
<title>forgot password</title>
<head>

<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="user.css">

</head>
<body>
	<h4 style="color: brown">${msg}</h4>
	<form action="forgot" method="post" onsubmit="" name="myform">
		<div class="container register">
			<div class="row">
				<div class="col-md-3 register-left">
					<h3>Welcome</h3>
				</div>
				<div class="col-md-9 register-right">
					</ul>
					<div class="tab-content" id="myTabContent">
						<div class="tab-pane fade show active" id="home" role="tabpanel"
							aria-labelledby="home-tab">
							<h3 class="register-heading">Add information</h3>
							<div class="row register-form">
								<div class="col-md-6">
									<div class="form-group">
										<input type="text" class="form-control"
											placeholder="User Name *" value=""
											name="username" />
									</div>
									
										</div>
									</div>
								</div>

								<div class="col-md-6">
									<div class="form-group">
										<select class="form-control" name="role">
											<option class="hidden" selected disabled>Please
												select your Role</option>
											<option>Admin</option>
											<option>user</option>

										</select>
									</div>
									<div class="form-group">
										<select class="form-control" name="question">
											<option>please select question</option>
											<option>What is your Birthdate?</option>
											<option>What is Your old Phone Number</option>
											<option>What is your Pet Name?</option>
										</select>
									</div>

									<div class="form-group">
										<input type="text" class="form-control"
											placeholder="`Enter your Answer *" value=""
											name="answer" />
									</div>
									<input type="submit" class="btnRegister" value="Reset password" />
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

		</div>
	</form>
</body>
</html>