<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>

<head>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<link rel="stylesheet" href="../css/hackerstyle.css" type="text/css">

</head>
<body>
<nav class = "homepage-nav">
<div class = "top">&nbsp;</div>
<div style = "max-width: 550px; margin: 0 auto; text-align:center;">

<img src = "../images/hacker.png" width = "200" height = "60">
<p style = "text-align:center; color:red";>${error}</p>
</div>
</nav>
<script src = "../js/validate.js" >

 </script>


<div class="login">

<div id ="formhead">
<!--   <ul id="formhead"> -->
<!--           <li class="but2"><a href="/signup" data-toggle="tab">Sign Up</a></li> -->
<!--           <li class="but2 "><a href="/login" data-toggle="tab">Log In</a></li> -->
<!--       </ul> -->
<label class="but2" for = "form-switch">SignUp</label>
<label class="but2" for = "form-switch">LogIn</label>
</div>
<input type='checkbox' id='form-switch'>
    <form id='login-form' name = "myForm" action="loginController" method='post' onsubmit = " return validateForm()">
    <input type="text"  name = "username" placeholder="Username" id="username">
  <input type="password"  name = "password" placeholder="password" id="password">
  <a href="#" class="forgot">forgot password?</a>
  <input id = "buttons" type="submit" value="Sign In">
  </form>
  <br>
  <form id='registerform' action="Register" method='post' onsubmit = "return validateRegister()">
  <input type="text"  name = "user1" placeholder="Username" id = "register-user">
  <input type="email" name = "email" placeholder="Email"  id = "register-user">
  <input type="password" name = "pass1" placeholder="Password"  id = "register-user">
  <input type="password" name = "conpass" placeholder="Re Password"  id = "register-user">
  <button type="submit" id = "register">Create an Account</button>
</form>
  <hr>
  <p>Or Connect with:</p>
<div id = "buttons" >

  <button class="button button1"><i class="fa fa-google"></i>  Google</button>
<button class="button button2"><i class="fa fa-facebook"></i>  Facebook</button>
<button class="button button3"><i class="fa fa-linkedin"></i>  Linkedin</button>
<button class="button button4"><i class="fa fa-github"></i>  Github</button>
</div>
<br>
<p>By signing up, you agree to our <a href = "#">Terms of Service</a> and <a href = "#">Privacy Policy.</a></p>
</div>
<br>
<br>




</body>


</html>