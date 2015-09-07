
jQuery(document).ready(function() {

    /*
        Background slideshow
    */
    $.backstretch([
      "static/assets/img/backgrounds/1.png"
    , "static/assets/img/backgrounds/2.png"
    , "static/assets/img/backgrounds/3.png"
    ], {duration: 3000, fade: 750});

    /*
        Tooltips
    */
    $('.links a.home').tooltip();
    $('.links a.blog').tooltip();

    /*
        Form validation
    */
    $('.register form').submit(function(){
        $(this).find("label[for='username']").html('用户名');
        $(this).find("label[for='email']").html('Email');
        $(this).find("label[for='password']").html('密码');
		$(this).find("label[for='surePassword']").html('确认密码');
        ////
        var surePassword = $(this).find('input#surePassword').val();
        var username = $(this).find('input#username').val();
        var email = $(this).find('input#email').val();
        var password = $(this).find('input#password').val();
        if(username == '') {
            $(this).find("label[for='username']").append("<span style='display:none' class='red'> - 请输入用户名.</span>");
            $(this).find("label[for='username'] span").fadeIn('medium');
            return false;
        }
        if(email == '') {
            $(this).find("label[for='email']").append("<span style='display:none' class='red'> - 输入正确的邮箱地址.</span>");
            $(this).find("label[for='email'] span").fadeIn('medium');
            return false;
        }
        if(password == '') {
            $(this).find("label[for='password']").append("<span style='display:none' class='red'> - 输入密码哈</span>");
            $(this).find("label[for='password'] span").fadeIn('medium');
            return false;
        }
		if(password!=surePassword){
			 $(this).find("label[for='surePassword']").append("<span style='display:none' class='red'> - 两次密码不一致哈</span>");
            $(this).find("label[for='surePassword'] span").fadeIn('medium');
            return false;
		}
	
    });


});


