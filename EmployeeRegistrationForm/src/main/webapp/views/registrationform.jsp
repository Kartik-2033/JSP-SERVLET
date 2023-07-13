<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Employee Register Form</title>
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
				<h1 class="heading">Employee Registration Form</h1>
			</header>
			<div class="form-section">
				<form action="<%= request.getContextPath() %>/register" method="post" name="EmployeeForm" id="EmployeeForm">
						<div class="signup-box">
							<input type="text" class="ele" name="firstName" id="firstName" placeholder="Enter your first name" pattern="[A-Za-z]*" onkeydown="return /[A-Za-z]/i.test(event.key)"/>
							<input type="text" class="ele" name="lastName" id="lastName" placeholder="Enter your last name" pattern="[A-Za-z]*" onkeydown="return /[A-Za-z]/i.test(event.key)"/>
							<input type="text" class="ele" name="userName" id="userName" placeholder="Enter your user name" pattern="[A-Za-z0-9]*" onkeydown="return /[A-Za-z0-9]/i.test(event.key)"/>
							<input type="password" class="ele" name="password" id="emp_pass" placeholder="Enter your password" pattern="(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).{8,30}" autocomplete="off"/>
							<input type="text" class="ele" name="address" placeholder="Enter your address"/>
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
</body>
<script>
$(document).ready(function () {
	$("#btnRes").click(function () {
		history.go(0);
	});
});

$(function() {
	var validator = $("#clearForm").validate({
		focusCleanup: true
	});
	$.validator.addMethod("checklower", function(value) {
		return /[a-z]/.test(value);
	});
	$.validator.addMethod("checkupper", function(value) {
		return /[A-Z]/.test(value);
	});
	$.validator.addMethod("checkdigit", function(value) {
		return /[0-9]/.test(value);
	});
	$.validator.addMethod("checkString", function(value) {
		return /[A-Za-z]/.test(value);
	});
	$.validator.addMethod("checkStringNumber", function(value) {
		return /[A-Za-z0-9]/.test(value);
	});
	$.validator.addMethod("noSpace", function(value, element) { 
		return value.indexOf(" ") < 0 && value != ""; 
	}, "No space please and don't leave it empty");

	$.validator.addMethod("pwcheck", function(value) {
		return /^[A-Za-z0-9\d=!\-@._*]*$/.test(value) && /[a-z]/.test(value) && /\d/.test(value) && /[A-Z]/.test(value);
	});
	$("#EmployeeForm").validate({
		rules: {
			firstName: {
				noSpace: true,
				required: true,
				checkString:true
			},
			lastName: {
				noSpace: true,
				required: true,
				checkString:true
			},
			userName: {
				noSpace: true,
				required: true,
				checkStringNumber:true
			},
			password: {
				minlength: 6,
				maxlength: 30,
				noSpace: true,
				required: true,
				checklower: true,
				checkupper: true,
				checkdigit: true
			},
			mobileNumber: {
				noSpace: true,
				required: true,
				checkdigit: true,
				minlength: 10,
				maxlength:10
			}
		},
		messages: {
				firstName: {
					required : "Please provide first name",
					checkString : "First name field accept only characters"
				},
				lastName : {
					required : "Please provide last name",
					checkString : "Last name field accept only characters"
				},
				userName: {
					required : "Please provide user name",
					checkStringNumber : "User name field accept only characters with number"
				},
				password: {
					pwcheck: "Password is not strong enough",
					checklower: "Need atleast 1 lowercase alphabet",
					checkupper: "Need atleast 1 uppercase alphabet",
					checkdigit: "Need atleast 1 digit"
				},
				mobileNumber: {
					required: "Please provide a mobile number",
					checkdigit: "Mobile number field accept only numbers/numeric value",
					minlength: "Mobile number field accept only 10 number/numeric values.",
					maxlength: "Mobile number field accept only 10 number/numeric values."
				}
			},
			highlight: function(element) {
				var id_attr = "#" + $(element).attr("id") + "-error";
				$(element).closest('.signup-box').removeClass('has-success').addClass('has-error');
				$(id_attr).removeClass('validate_rem').addClass('validate_cus');
			},
			unhighlight: function(element) {
				var id_attr = "#" + $(element).attr("id") + "-error";
				$(element).closest('.signup-box').removeClass('has-error').addClass('has-success');
				$(id_attr).removeClass('validate_cus').addClass('validate_rem');
			},
			errorClass: 'validate_cus',
			errorPlacement: function(error, element) {
				x = element.length;
				if (element.length) {
					error.insertAfter(element);
				} else {
					error.insertAfter(element);
				}
			},
		submitHandler: function(form) {
			form.submit();
		}
	});
});
</script>
</html>