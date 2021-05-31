<%-- 
    Document   : FeedBack
    Created on : 14-Mar-2021, 22:42:10
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--<title>Apple Store</title>-->
<!--        <link rel="icon" href="https://i.pinimg.com/originals/77/c3/66/77c366436d8bd35fe8b3ce5b8c66992e.png"
              type ="image/x-icon">-->
        <style>
            @import "https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css";
            @import url('https://fonts.googleapis.com/css?family=Roboto+Condensed');
            /*            * {
                            box-sizing:border-box;
                            margin:0px;
                            padding:0px;
                            font-family: 'Roboto Condensed', sans-serif;
                        }*/
            body {
                /*height:100vh;*/

            }
            #feedback-form {
                height:100vh;
                /*                display:flex;
                                justify-content:center;
                                align-items:center;
                                overflow:hidden;*/

                position:relative;
                width:50px;
                height:50px;
                border-radius:50%;
                opacity:0;
                z-index:2;
                background:#fff;
                box-shadow:0px 4px 5px 1px rgba(100,100,100,0.6);
            }
            #feedback-form.send {
                animation:sendIt 800ms ease forwards !important;
            }
            #feedback-form #close-btn {
                position:absolute;
                top:-10px;
                right:-10px;
                background:rgba(0,0,0,0.5);
                color:#e7e7e7;
                width:22px;
                height:22px;
                text-align:center;
                line-height:22px;
                border-radius:50%;
                z-index:3;
                cursor:pointer;
            }
            #feedback-form .title {
                padding:12px 15px;
                font-size:18px;
                color:#fff;
                background:#bbbbbb;
            }
            #feedback-form .row1 {
                display:flex;
                width:100%;
                border-bottom:1px solid rgba(100,100,100,0.5);
            }
            #feedback-form .row1 > *{
                flex:1;
                width:100%;
                border-top:none;
                border-bottom:none;
                border-right:1px solid #eee;
                border-left:1px solid #eee;
                outline:none;
                outline:none;
            }
            #feedback-form .row1 > input {
                padding:5px;
            }
            #feedback-form .row1 > textarea {
                padding:5px;
                height:115px;
                resize:none;
            }
            #feedback-form .submit-btn-row1{
                display:flex;
                flex-direction:row1-reverse;
                height:35px;
            }
            #feedback-form .submit-btn-row1 >* {
                height:100%;
                width:100px;
                outline:none;
                border:none;
                color:#fff;
                background: #343a40!important;
            }
            #feedback-form.active {
                transition:all 400ms linear 550ms;
                opacity:1;
                width:350px;
                height:250px;
                border-radius:5px;    
            }
            .edit-btn {
                position:fixed;
                bottom:30px;
                right:30px;
                display:inline-block;
                font: normal normal normal 14px/1 FontAwesome;
                font-size: inherit;
                text-rendering: auto;
                -webkit-font-smoothing: antialiased;  
                width:50px;
                height:50px; 
                background:#343a40!important;
                color:#eee;
                text-align:center;
                line-height:50px;
                font-size:22px;
                border-radius:50%;
                transition:all 500ms linear;
                opacity:1;
                z-index:1;
            }
            .edit-btn.active {   
                animation: slideToCenter 500ms linear forwards;
            }


            @keyframes slideToCenter {
                0% {
                    bottom:50px;
                    opacity:1;
                }
                99% {
                    bottom:calc(50% - 50px);
                    transform:translate(-50%,-50%);
                    opacity:1;
                }
                100% {

                    opacity:0;
                }
            }

            @keyframes sendIt {
                0% {
                    transform:translateY(0px);
                }
                20%{
                    transform:translateY(20px);
                }
                100%{
                    transform:translateY(-500px);
                }
            }
        </style>
        <script>
            function toggleForm(ref) {
                ref.classList.toggle('active');
                document.getElementById('feedback-form').classList.toggle('active');
            }
            function closeForm(ref) {
                document.getElementById('edit-btn').classList.remove('active');
                document.getElementById('feedback-form').classList.remove('active');
            }

            function submitFeedback() {
                //validate form fields
                document.getElementById('feedback-form').classList.add('send');
                setTimeout(function () {
                    document.getElementById('edit-btn').style.display = "none";
                    document.getElementById('feedback-form').style.display = "none";
                }, 500);
            }
        </script>
    </head>
    <body>
        <form action="ControlerFeedBack" method="post">
            <div id="feedback-form">
                <div id="close-btn" onclick="closeForm();">
                    X
                </div>
                <div class="title">
                    Feedback Form
                </div>
                <div class="row1">
                    <input type="text" placeholder="Full Name" value="${sessionScope.acc.name}" readonly>
                    <!--                <input type="text" placeholder="Last Name">    -->
                </div>
                <div class="row1">
                    <input type="text" name="mail" placeholder="Email Address"> 
                </div> 
                <div class="row1">
                    <input type="text" placeholder="Phone number" value="${sessionScope.acc.phone}"> 
                </div>
                <div class="row1">
                    <textarea placeholder="Your feedback" name="detail" required></textarea>   
                </div>  
                <div class="submit-btn-row1">
                    <button type="submit" onclick="submitFeedback();">Submit</button>
                </div>
            </div>
        </form>
        <div class="edit-btn" id="edit-btn" onclick="toggleForm(this)">
            <i class="fa fa-pencil" aria-hidden="true"></i>
        </div>
    </body>
</html>
