<%-- 
    Document   : footernew
    Created on : 15-Mar-2021, 22:56:41
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style>
      body {
                /*                background: #fbfbfd;*/
            }

            .new_footer_area {

            }


            .new_footer_top {
                padding: 120px 0px 270px;
                position: relative;
                overflow-x: hidden;
            }
            .new_footer_area .footer_bottom {
                padding-top: 5px;
                padding-bottom: 50px;
            }
            .footer_bottom {
                font-size: 14px;
                font-weight: 300;
                line-height: 20px;
                color: #7f88a6;
                padding: 27px 0px;
            }
            .new_footer_top .company_widget p {
                font-size: 16px;
                font-weight: 300;
                line-height: 28px;
                color: #6a7695;
                margin-bottom: 20px;
            }
            .new_footer_top .company_widget .f_subscribe_two .btn_get {
                border-width: 1px;
                margin-top: 20px;
            }
            .btn_get_two:hover {
                background: transparent;
                color: #5e2ced;
            }
            .btn_get:hover {
                color: #fff;
                background: #6754e2;
                border-color: #6754e2;
                -webkit-box-shadow: none;
                box-shadow: none;
            }
            a:hover, a:focus, .btn:hover, .btn:focus, button:hover, button:focus {
                text-decoration: none;
                outline: none;
            }



            .new_footer_top .f_widget.about-widget .f_list li a:hover {
                color: #5e2ced;
            }
            .new_footer_top .f_widget.about-widget .f_list li {
                margin-bottom: 11px;
            }
            .f_widget.about-widget .f_list li:last-child {
                margin-bottom: 0px;
            }
            .f_widget.about-widget .f_list li {
                margin-bottom: 15px;
            }
            .f_widget.about-widget .f_list {
                margin-bottom: 0px;
            }
            .new_footer_top .f_social_icon a {
                width: 44px;
                height: 44px;
                line-height: 43px;
                background: transparent;
                border: 1px solid #e2e2eb;
                font-size: 24px;
            }
            .f_social_icon a {
                width: 46px;
                height: 46px;
                border-radius: 50%;
                font-size: 14px;
                line-height: 45px;
                color: #858da8;
                display: inline-block;
                background: #ebeef5;
                text-align: center;
                -webkit-transition: all 0.2s linear;
                -o-transition: all 0.2s linear;
                transition: all 0.2s linear;
            }
            .ti-facebook:before {
                content: "\e741";
            }
            .ti-twitter-alt:before {
                content: "\e74b";
            }
            .ti-vimeo-alt:before {
                content: "\e74a";
            }
            .ti-pinterest:before {
                content: "\e731";
            }

            .btn_get_two {
                -webkit-box-shadow: none;
                box-shadow: none;
                background: #5e2ced;
                border-color: #5e2ced;
                color: #fff;
            }

            .btn_get_two:hover {
                background: transparent;
                color: #5e2ced;
            }

            .new_footer_top .f_social_icon a:hover {
                background: #5e2ced;
                border-color: #5e2ced;
                color:white;
            }
            .new_footer_top .f_social_icon a + a {
                margin-left: 4px;
            }
            .new_footer_top .f-title {
                margin-bottom: 30px;
                color: #263b5e;
            }
            .f_600 {
                font-weight: 600;
            }
            .f_size_18 {
                font-size: 18px;
            }
            h1, h2, h3, h4, h5, h6 {
                color: #4b505e;
            }
            .new_footer_top .f_widget.about-widget .f_list li a {
                color: #6a7695;
            }


            .new_footer_top .footer_bg {
                background: #fbfbfd;
                position: absolute;
                bottom: 0;
                background: url("http://droitthemes.com/html/saasland/img/seo/footer_bg.png") no-repeat scroll center 0;
                width: 100%;
                height: 266px;
            }

            .new_footer_top .footer_bg .footer_bg_one {
                background: url("https://1.bp.blogspot.com/-mvKUJFGEc-k/XclCOUSvCnI/AAAAAAAAUAE/jnBSf6Fe5_8tjjlKrunLBXwceSNvPcp3wCLcBGAsYHQ/s1600/volks.gif") no-repeat center center;
                width: 330px;
                height: 105px;
                background-size:100%;
                position: absolute;
                bottom: 0;
                left: 30%;
                -webkit-animation: myfirst 22s linear infinite;
                animation: myfirst 22s linear infinite;
            }
            
            .new_footer_top .footer_bg .footer_bg_thre{
                background: url("https://1.bp.blogspot.com/-mvKUJFGEc-k/XclCOUSvCnI/AAAAAAAAUAE/jnBSf6Fe5_8tjjlKrunLBXwceSNvPcp3wCLcBGAsYHQ/s1600/volks.gif") no-repeat center center;
                width: 330px;
                height: 105px;
                background-size:100%;
                position: absolute;
                bottom: 0;
                left: 30%;
                -webkit-animation: myfirst 25s linear infinite;
                animation: myfirst 25s linear infinite;
            }

            .new_footer_top .footer_bg .footer_bg_two {
                background: url("https://1.bp.blogspot.com/-hjgfxUW1o1g/Xck--XOdlxI/AAAAAAAAT_4/JWYFJl83usgRFMvRfoKkSDGd--_Sv04UQCLcBGAsYHQ/s1600/cyclist.gif") no-repeat center center;
                width: 88px;
                height: 100px;
                background-size:100%;
                bottom: 0;
                left: 38%;
                position: absolute;
                -webkit-animation: myfirst 29s linear infinite;
                animation: myfirst 29s linear infinite;
            }
            

            @-moz-keyframes myfirst {
                0% {
                    left: -25%;
                }
                100% {
                    left: 100%;
                }
            }

            @-webkit-keyframes myfirst {
                0% {
                    left: -25%;
                }
                100% {
                    left: 100%;
                }
            }

            @keyframes myfirst {
                0% {
                    left: -25%;
                }
                100% {
                    left: 100%;
                }
            }

            /*************footer End*****************/
            .back{
                margin-left: 300px;
            }
            .create{
                margin-left: 300px;
            }

            .listc{
                margin-left: 260px; 
            }
        </style>
    </head>
    <!--        <footer class="new_footer_area bg_color">-->
    <div class="new_footer_top">
        <p class="back">
            <a href="#">Back to top</a>
        </p>
        <ul class="listc">
            <i class="fa fa-home mr-2"></i><a href="ControllerProduct   "> Apple Store | </a>
            <i class="fa fa-envelope mr-2"></i><a href="https://www.icloud.com"> iCloud</a> <i>19longdt.fptu@gmail.com </i>| 
            <i class="fa fa-phone mr-2"></i> 1-800-MY-APPLE
            <!--<li><i class="fa fa-print mr-2"></i> + 33 12 14 15 16</li>-->
        </ul>

        <p class="create">created with <i class="fa fa-heart"></i> <a href="https://www.facebook.com/19longdt.fptu/"><i>love</i></a> | <span>v. 1.0</span></p>
        <div class="footer_bg">
            <div class="footer_bg_one"></div>
            <!--<div class="footer_bg_thre"></div>-->
            <div class="footer_bg_two"></div>
            
        </div>
    </div>
    <!--</footer>-->
</html>
