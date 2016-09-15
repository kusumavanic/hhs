$(function(){
	var name1 = /^[a-zA-Z]{4,16}$/;
	$("#serProviderName").keyup(function(){
		var name=$("#serProviderName").val();
		if(name1.test(name) == true){
			$("#span-name").html("ok").css("color","blue");
		}
		else{
			$("#span-name").html("not ok").css("color","red");
		}
		
	});
	
	$("#serConsumerName").keyup(function(){
		var name=$("#serConsumerName").val();
		if(name1.test(name) == true){
			$("#span-name").html("ok").css("color","blue");
		}
		else{
			$("#span-name").html("not ok").css("color","red");
		}
		
	});
	$("#guestName").keyup(function(){
		var name=$("#guestName").val();
		if(name1.test(name) == true){
			$("#span-name").html("ok").css("color","blue");
		}
		else{
			$("#span-name").html("not ok").css("color","red");
		}
		
	});
	$("#serLocation").keyup(function(){
		var name=$("#serLocation").val();
		if(name1.test(name) == true){
			$("#span-location").html("ok").css("color","blue");
		}
		else{
			$("#span-location").html("not ok").css("color","red");
		}
	});
	$("#serCity").keyup(function(){
		var name=$("#serCity").val();
		if(name1.test(name) == true){
			$("#span-city").html("ok").css("color","blue");
		}
		else{
			$("#span-city").html("not ok").css("color","red");
		}
	});
	var mob = /^[0-9]{10}$/;
	$("#serMobileNumber").keyup(function(){
		var mobile=$("#serMobileNumber").val();
		if(mob.test(mobile) == true){
			$("#span-mobile").html("ok").css("color","blue");
		}
		else{
			$("#span-mobile").html("not ok").css("color","red");
		}
		
	});
	var mail=/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
	$("#serEmail").keyup(function(){
		var email=$("#serEmail").val();
		if(mail.test(email) == true){
			$("#span-email").html("ok").css("color","blue");
		}
		else{
			$("#span-email").html("not ok").css("color","red");
		}
		
	});
	$("#serAltEmail").keyup(function(){
		var email=$("#serEmail").val();
		var altemail=$("#serAltEmail").val();
		if((altemail != email) && (mail.test(altemail)==true) ){
			$("#span-altemail").html("ok").css("color","blue");
		}
		else{
			$("#span-altemail").html("not ok").css("color","red");
		}
		
	});
	var pas = /^[a-zA-Z0-9!@#$%^&*]{6,16}$/;
	$("#serPassword").keyup(function(){
		var password=$("#serPassword").val();
		if(pas.test(password) == true){
			$("#span-password").html("ok").css("color","blue");
		}
		else{
			$("#span-password").html("not ok").css("color","red");
		}
		
	});
	$("#serConfirmPassword").keyup(function(){
		var password=$("#serPassword").val();
		var cpassword=$("#serConfirmPassword").val();
		if(password == cpassword){
			$("#span-cpassword").html("ok").css("color","blue");
		}
		else{
			$("#span-cpassword").html("not ok").css("color","red");
		}
		
	});
});