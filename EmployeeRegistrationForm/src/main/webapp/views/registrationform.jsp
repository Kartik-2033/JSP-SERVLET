<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Employee registration form</title>
	<link rel="stylesheet" href="css/register.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.1/jquery.validate.min.js"></script>
	<style type="text/css">
	.validate_cus {
		color: #a94442;
		font-size: small;
	}
	.validate_rem {
		display: none;
	}
	@keyframes shake {
		0% {
			margin-left: 0rem;
		}
		25% {
			margin-left: 0.5rem;
		}
		75% {
			margin-left: -0.5rem;
		}
		100% {
			margin-left: 0rem;
		}
	}
	.ele:invalid {
		animation: shake 0.2s ease-in-out 0s 2;
		box-shadow: 0 0 0.6rem #ff0000;
	}
	</style>
</head>

<body>
	<div class="lgn">
		<div class="container">
			<header>
				<h1 class="heading">Employee registration form</h1>
			</header>
			<div class="form-section">
				<form action="<%= request.getContextPath() %>/register" method="post" name="EmployeeForm" id="EmployeeForm">
						<div class="signup-box">
							<input type="text" class="ele" name="firstName" id="firstName" placeholder="Enter your first name" pattern="[A-Za-z]*" onkeydown="return /[A-Za-z]/i.test(event.key)" autocomplete="off"/>
							<input type="text" class="ele" name="lastName" id="lastName" placeholder="Enter your last name" pattern="[A-Za-z]*" onkeydown="return /[A-Za-z]/i.test(event.key)" autocomplete="off"/>
							<input type="text" class="ele" name="userName" id="userName" placeholder="Enter your user name" pattern="[A-Za-z0-9]*" onkeydown="return /[A-Za-z0-9]/i.test(event.key)" autocomplete="off"/>
							<input type="password" class="ele" name="password" id="emp_pass" placeholder="Enter your password" pattern="(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).{6,30}" autocomplete="off" autocomplete="off"/>
							<input type="text" class="ele" name="address" placeholder="Enter your address" autocomplete="off"/>
							<input type="number" class="ele" name="mobileNumber" id="emp_mobile_number" placeholder="Enter your mobile number" pattern="[0-9]{10}" maxlength="10" autocomplete="off"/>
							<div class="sample">
								<button type="submit" id="submit-btn" class="clkbtn">Register</button>
								<button type="reset" class="clkbtn" id="btnRes">Reset</button>
							</div>
						</div>
				</form>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="js/register.js"></script>
</body>
</html>