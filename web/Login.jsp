<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <link rel="icon" href="https://i.pinimg.com/originals/77/c3/66/77c366436d8bd35fe8b3ce5b8c66992e.png"
              type ="image/x-icon">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
        <link href="css/login.css" rel="stylesheet" type="text/css"/>
        <title>Login | Apple Store</title>
        <style>
            #admin{
                display: none;
            }
            .gender{
                margin-top: 3px;
                margin-bottom:  3px;
                height: 46px;
            }
        </style>
        <script>
            function check() {
                var link = document.getElementById("link");
                var form = document.getElementById("admin");

                if (link.value === "Login as Administrator") {
                    form.style.display = "block";
                    link.value = "Close";
                } else {
                    form.style.display = "none";
                    link.value = "Login as Administrator";
                }
            }

        </script>
    </head>
    <body>
        <div id="logreg-forms">
            <form class="form-signin" action="login" method="post">
                <p class="text-danger">${messr}</p>
                <h1 class="h3 mb-3 font-weight-normal" style="text-align: center"> Sign in</h1>
                <p class="text-danger">${mess}</p>
                <input name="user"  type="text" id="inputEmail" class="form-control" placeholder="Username" required="" autofocus="">
                <input name="pass"  type="password" id="inputPassword" class="form-control" placeholder="Password" required="">

                <div class="form-group form-check">
                    <input name="remember" value="1" type="checkbox" class="form-check-input" id="exampleCheck1">
                    <label class="form-check-label" for="exampleCheck1">Remember me</label>
                </div>

                <input type="button" onclick="check()" value="Login as Administrator" id="link">
                <div id="admin">
                    <input name="code"  type="password" id="inputEmail" class="form-control" placeholder="Security Code">
                </div> 

                <button class="btn btn-success btn-block" type="submit"><i class="fas fa-sign-in-alt"></i> Sign in</button>
                <hr>
                <button class="btn btn-primary btn-block" type="button" id="btn-signup"><i class="fas fa-user-plus"></i> Sign up New Account</button>
            </form>

            <form action="register" method="post" class="form-signup">
                <p class="text-danger">${messr}</p>
                <h1 class="h3 mb-3 font-weight-normal" style="text-align: center"> Sign up</h1>
                <input name="user" type="text" id="user-name" class="form-control" placeholder="User name" required="" autofocus="">
                <input name="pass" type="password" id="user-pass" class="form-control" placeholder="Password" required autofocus="">
                <input name="repass" type="password" id="user-repeatpass" class="form-control" placeholder="Repeat Password" required autofocus="">
                <input name="name" type="text" id="user-repeatpass" class="form-control" placeholder="Full Name" required autofocus="">
                <!--                <select class="gender" name="gender">Gender
                                    <option value="1"  selected>Male</option>
                                    <option value="0" >FeMale</option>
                                    <option value="2" >Other</option>
                                </select>-->
                <div class="gender">Gender    :
                    <input type="radio" name="gender" value="1" checked/>Male
                    <input type="radio" name="gender" value="0" />Female
                    <input type="radio" name="gender" value="2" />Other
                </div>
                
                <input name="date" type="date" id="user-repeatpass" class="form-control" placeholder="Repeat Password" required autofocus="">
                <input name="address" type="text" id="user-repeatpass" class="form-control" placeholder="Address" required autofocus="">
                <p>What is your dream job?</p>
                <input name="ans" type="text" id="user-repeatpass" class="form-control" placeholder="Your Answer" required autofocus="">
                <button class="btn btn-primary btn-block" type="submit"><i class="fas fa-user-plus"></i> Sign Up</button>
                <a href="#" id="cancel_signup"><i class="fas fa-angle-left"></i> Back</a>
            </form>
            <br>

        </div>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <script>
                    function toggleResetPswd(e) {
                        e.preventDefault();
                        $('#logreg-forms .form-signin').toggle() // display:block or none
                        $('#logreg-forms .form-reset').toggle() // display:block or none
                    }

                    function toggleSignUp(e) {
                        e.preventDefault();
                        $('#logreg-forms .form-signin').toggle(); // display:block or none
                        $('#logreg-forms .form-signup').toggle(); // display:block or none
                    }

                    $(() => {
                        // Login Register Form
                        $('#logreg-forms #forgot_pswd').click(toggleResetPswd);
                        $('#logreg-forms #cancel_reset').click(toggleResetPswd);
                        $('#logreg-forms #btn-signup').click(toggleSignUp);
                        $('#logreg-forms #cancel_signup').click(toggleSignUp);
                    })
        </script>
    </body>
</html>