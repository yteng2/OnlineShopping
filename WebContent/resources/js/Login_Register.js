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
	
	$('[name="user_email"]').change(function(){
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


