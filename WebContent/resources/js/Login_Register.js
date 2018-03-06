$(function() {
    $('#login-form-link').click(function(e) {
		$("#login-form").delay(100).fadeIn(100);
 		$("#register-form").fadeOut(100);
		$('#register-form-link').removeClass('active');
		$(this).addClass('active');
		e.preventDefault();
	});
	$('#register-form-link').click(function(e) {
		$("#register-form").delay(100).fadeIn(100);
 		$("#login-form").fadeOut(100);
		$('#login-form-link').removeClass('active');
		$(this).addClass('active');
		e.preventDefault();
	});
	
	$("#user_email").change(function(){
		var email = $(this).val();
//		console.log(email);
		var url = "/OnlineShopping/check_email";
		var result = $.post(url,email,'json').done(function(response){
		    if(response === "false"){
		    	alert("this email is already been used")
		    }
		  });
	});
});

$().ready(function(){
	$("#login-form").validate({
		rules: {
			user_email: {
				required: true,
				email: true
			},
			password: {
				required: true,
				minlength: 4,
				maxlength: 15,
			}	
		},
		messages: {
			user_email:{
				required:" username is required",
				email:" this field must be email address"
			},
			password:{
				required:"password is required",
				minlength:"password should at least have 4 digit",
				maxlength:"password should at most have 15 dight"
			}
		}
	
	});
	
	$("#register-form").validate({
		rules: {
			firstName: {
				required: true,
				minlength:2,
				lettersonly:true
			},
			lastName: {
				required: true,
				minlength:2,
				lettersonly:true
			},
			email: {
				required: true,
				email: true
			},
			password: {
				required: true,
				minlength: 4,
				maxlength: 15
			},
			password1: {
				required: true,
				minlength: 4,
				maxlength: 15,
				equalTo: "#password"
			},
			phone: {
				minlength:10,
				maxlength:10,
				number:true
			}
		},
		messages: {
			firstName: {
				required: "first name is required",
				minlength: "First name should contain  minimum 2 characters",
				lettersonly: "First name can contain only aplphabets "
			},
			lastName: {
				required: "last name is required",
				minlength: "Last name should contain  minimum 2 characters",
				lettersonly: "Last name can contain only aplphabets"
			},
			email:{
				required:" email is required",
				email:"not a valid email address"
			},
			password:{
				required:"password is required",
				minlength:"password should at least have 4 digit",
				maxlength:"password should at most have 15 dight"
			},
			password1:{
				required:"password is required",
				minlength:"password should at least have 4 digits",
				maxlength:"password should at most have 15 digits",
				equalTo: "password didn't match"
			},
			phone:{
				minlength:"you phone number has to be 10 digits",
				maxlength:"you phone number has to be 10 digits",
				number:"you phone number can contain only numeric characters"
			}
		},
//		submitHandler: function(form) {
//			form.submit();
//		}
	});
});

//$("#login-submit").mouseenter(function(){
//	if($("#login-form").valid()){
//		alert('f');
//		$("#register").removeAttr("disabled");		
//	} else {
//		alert('u');
//		$("#register").attr("disabled","disabled");
//	}
//});



