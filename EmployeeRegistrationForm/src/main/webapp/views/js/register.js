$(document).ready(function() {
	$("#btnRes").click(function() {
		history.go(0);
	});
});

$(function() {
	var validator = $("#clearForm").validate({
		focusCleanup: true
	});
	$.validator.addMethod("checkLower", function(value) {
		return /[a-z]/.test(value);
	});
	$.validator.addMethod("checkUpper", function(value) {
		return /[A-Z]/.test(value);
	});
	$.validator.addMethod("checkDigit", function(value) {
		return /[0-9]/.test(value);
	});
	$.validator.addMethod("checkString", function(value) {
		return /[A-Za-z]/.test(value);
	});
	$.validator.addMethod("checkStringNumber", function(value) {
		return /[A-Za-z0-9]/.test(value);
	});
	$.validator.addMethod("noSpace", function(value) {
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
				checkString: true
			},
			lastName: {
				noSpace: true,
				required: true,
				checkString: true
			},
			userName: {
				noSpace: true,
				required: true,
				checkStringNumber: true
			},
			password: {
				minlength: 6,
				maxlength: 30,
				noSpace: true,
				required: true,
				checkLower: true,
				checkUpper: true,
				checkDigit: true
			},
			mobileNumber: {
				noSpace: true,
				required: true,
				checkDigit: true,
				minlength: 10,
				maxlength: 10
			}
		},
		messages: {
			firstName: {
				required: "Please provide first name",
				checkString: "First name field accept only characters"
			},
			lastName: {
				required: "Please provide last name",
				checkString: "Last name field accept only characters"
			},
			userName: {
				required: "Please provide user name",
				checkStringNumber: "User name field accept only characters with number"
			},
			password: {
				pwcheck: "Password is not strong enough",
				checkLower: "Need atleast 1 lowercase alphabet",
				checkUpper: "Need atleast 1 uppercase alphabet",
				checkDigit: "Need atleast 1 digit"
			},
			mobileNumber: {
				required: "Please provide a mobile number",
				checkDigit: "Mobile number field accept only numbers/numeric value",
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