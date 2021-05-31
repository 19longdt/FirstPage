<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Apple Store</title>
        <link rel="icon" href="https://i.pinimg.com/originals/77/c3/66/77c366436d8bd35fe8b3ce5b8c66992e.png"
              type ="image/x-icon">
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <!------ Include the above in your HEAD tag ---------->
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <style>
            body{
                background-color:#ddd;
            }
            .test{
                /*            background-image: url(Img/logo.png);
                            background-size: cover;*/
                /*height: 40vh;*/
                width: auto;
                text-align: center;
                margin-top 100px;

            }
            marquee{
                color: #000;
                font-size: 20px;
                font-family: Courier;
            }
            .blink {
                margin-top: 20px;
                padding-bottom: -40px;
                animation: blinker 0.5s linear infinite;
                color: #cc561e;
                font-size: 20px;
                font-weight: bold;
                font-family: sans-serif;
                text-align: center;
            }
            @keyframes blinker {
                50% {
                    opacity: 0;
                }
            }
            .img{
                width: 12px;
                height: 150px;
            }

            #feed{
                margin-right: 45px;
                float: right;
            }
            #ordercheck{
                width: auto;
                display: none;
            }
            .categories{
                font-size: 1.2em;
                color: #FFF;
                padding: 10px 8px;
                background: #343a40!important;
                text-transform: uppercase;
                /*            font-family: 'ambleregular';*/
                width: 100%;

                border-top-left-radius: 5px;
                border-top-right-radius: 5px;
            }
            /*        .categories li{
                        list-style: none;
                    }*/
            .col a{
                background: #343a40!important;
                border-color: #343a40!important;
            }
            .col p{
                background:  #bbbbbb!important;
                border-color: #bbbbbb!important;
            }

            .card-body p{

            }
            .card-text p1{
                color:  #ef8d32!important;
            }

            .feed{
                width: 1200px;

            }
            .new1{
                margin-top: 24px;
            }
            .img-fluid{
                margin-left: 30px;
            }

            #fbcheck{
                display: none;
            }
            #checkproduct{
                display: none;
            }
            .tab1aa{
                /*width: 900px;*/
                margin-bottom:  30px;
            }
            .col-sm-9{
                width: 1200px;
            }
            #out{
                margin: auto;
                color: red;
                font-family: sans-serif;
            }
            /*            h4{
                            margin: auto;
                        }*/
            .alert1 {
                /*padding: 20px;*/
                background-color: #f44336;
                color: white;
            }

            .closebtn {
                margin-left: 15px;
                color: white;
                font-weight: bold;
                float: right;
                font-size: 22px;
                line-height: 20px;
                cursor: pointer;
                transition: 0.3s;
            }

            .closebtn:hover {
                color: black;
            }
        </style>
        <script>
            function check() {
                var link = document.getElementById("link");
                var form = document.getElementById("ordercheck");

                if (link.value === "Check Bills") {
                    form.style.display = "block";
                    link.value = "Close";
                } else {
                    form.style.display = "none";
                    link.value = "Check Bills";
                }
            }
 <input type="button" onclick="check1()" value="Check FeedBack" id="link1">
                        <div class="feed" >  <form id="fbcheck">
                                <c:if test ="${fb != null}">
                                    <div class="alert alert-dark" role="alert">${fb}</div>
                                </c:if>
                                <c:if test ="${fb == null}">
                                    <jsp:include page="ManagerFeedBack.jsp"></jsp:include>
                                </c:if>
                            </form>
                        </div>
            function check1() {
                var link1 = document.getElementById("link1");
                var form1 = document.getElementById("fbcheck");

                if (link1.value === "Check FeedBack") {
                    form1.style.display = "block";
                    link1.value = "Close";
                } else {
                    form1.style.display = "none";
                    link1.value = "Check FeedBack";
                }
            }
            function check2() {
                var link2 = document.getElementById("link2");
                var form2 = document.getElementById("checkproduct");

                if (link2.value === "Check Product") {
                    form2.style.display = "block";
                    link2.value = "Close";
                } else {
                    form2.style.display = "none";
                    link2.value = "Check Product";
                }
            }
        </script>
    </head>
    <body>
        <jsp:include page="Menu.jsp"></jsp:include>

            <div class="test">
                <h1 class="jumbotron-heading">Wellcome to Apple Store</h1>
                <p class="lead text-muted mb-0">Everything you love about our stores is online.</p>
            </div>
            <!--            <div class="stev">
        <%--<jsp:include page="slidershow.jsp"></jsp:include>--%>
        </div>-->

        <c:if test ="${sessionScope.acc != null}">
            <div id="feed">
                <jsp:include page="FeedBack.jsp"></jsp:include>
                </div>
        </c:if>
        <div class="container">
            <div class="row">
                <marquee>
                    <!--                        <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/1/1b/Apple_logo_grey.svg/647px-Apple_logo_grey.svg.png" width="18px"  height="20px" />-->
                    “Think different - Impossible is nothing”  
                    <!--<img src="https://upload.wikimedia.org/wikipedia/commons/thumb/1/1b/Apple_logo_grey.svg/647px-Apple_logo_grey.svg.png" width="18px"  height="20px"/>-->
                </marquee> 
                <!--                    <div class="col">
                                        <nav aria-label="breadcrumb">
                                            <ol class="breadcrumb">
                                                <li class="breadcrumb-item"><a href="Home.jsp">Home</a></li>
                                                <li class="breadcrumb-item"><a href="#">Category</a></li>
                                                <li class="breadcrumb-item active" aria-current="#">Sub-category</li>
                                            </ol>
                                        </nav>
                                    </div>-->
            </div>
        </div>
        <div class="container">

            <div class="row">
                <c:if test ="${sessionScope.admin == null}">
                    <div class="col-sm-3">
                        <div class="card bg-light mb-3">
                            <!--<img src="https://image.freepik.com/free-vector/set-realistic-computer-laptop-tablet-smartphone_52028-21.jpg" width="254"/>-->
                            <div class="categories"> Categories</div>
                            <ul class="list-group category_block">
                                <c:forEach items="${listc}" var="o">
                                    <li class="list-group-item text-white ${tag == o.cid ? "active" : ""}"><a href="categoryy?cid=${o.cid}">${o.cname}</a></li>
                                    </c:forEach>
                            </ul>
                        </div>

                        <div class="card bg-light mb-3">
                            <p class="blink"> <i>New Product</i></p>
                            <!--<div class="card-header bg-success text-white text-uppercase">Last product</div>-->
                            <div class="card-body">
                                <p class="card-text">
                                    <img class="new1" src="https://cauthangvietuc.vn/Hinh%20CTSP/new.gif" width="50px" height="40px"/>

                                <h5 class="card-title"><a href="detail?pid=${plast.pid}" title="View Detail">${plast.pname}</a></h5>
                                <!--<h4>MacBook Pro</h4>-->
                                All systems Pro.

                                <img class="img-fluid" src="Img/${plast.img}" alt="Image" />


                            </div>

<!--                                <p class="bloc_left_price">$ ${plast.price}</p>-->
                        </div>

                    </div>
                </c:if>


                <div class="col-sm-9">
                    <c:if test="${sessionScope.admin == null}">
                        <div class="tab1aa">
                            <jsp:include page="test.jsp"></jsp:include>
                            </div>
                    </c:if>
                    <c:if test ="${sessionScope.k != null}">
                        <!--<div class="alert alert-dark" role="alert">${sessionScope.k}</div>-->
                        <div class="alert1">
                            <span class="closebtn" onclick="this.parentElement.style.display = 'none';">&times;</span> 
                            Our shop now doesn't have enough quantity of <strong>${sessionScope.pname}</strong> at your request... 
                            Please buy again later!
                        </div>
                        <%--<jsp:include page="cloud.jsp"></jsp:include>--%>

                    </c:if>
                    <c:if test ="${result != null}">
                        <div class="alert alert-dark" role="alert">${result}</div>
                        <%--<jsp:include page="cloud.jsp"></jsp:include>--%>

                    </c:if>

                    <c:if test ="${sessionScope.admin != null}">
                        <!--/////Order CHECK/////-->  

                        <!--<input type="button" onclick="check()" value="Check Bills" id="link">-->
                        <!--<form id="ordercheck">-->
                            <%--<c:if test ="${od != null}">--%>
                                <!--<div class="alert alert-dark" role="alert">${od}</div>-->
                            <%--</c:if>--%>

                            <%--<c:if test ="${od == null}">--%>
                                <%--<jsp:include page="ManagerOrderDetail.jsp"></jsp:include>--%>
                            <%--</c:if>--%>
                        <!--</form>-->  


                        <!--/////FEEDBACK/////-->
                        <input type="button" onclick="check1()" value="Check FeedBack" id="link1">
                        <div class="feed" >  <form id="fbcheck">
                                <c:if test ="${fb != null}">
                                    <div class="alert alert-dark" role="alert">${fb}</div>
                                </c:if>
                                <c:if test ="${fb == null}">
                                    <jsp:include page="ManagerFeedBack.jsp"></jsp:include>
                                </c:if>
                            </form>
                        </div>
                        <!--/////PRODUCT CHECK/////-->
                        <input type="button" onclick="check2()" value="Check Product" id="link2">
                        <div class="checkproduct" >  <form id="checkproduct">
                                <c:if test ="${amount != null}">
                                    <div class="alert alert-dark" role="alert">${amount}</div>
                                    <div class="alert alert-dark" role="alert">If you want update this, 
                                        <a  href="manager" target="_blank"><i>Click here</i></a></div>
                                    </c:if>
                                    <c:if test ="${amount == null}">
                                    <div class="alert alert-dark" role="alert">Sales : Active</div>
                                </c:if>
                            </form>
                        </div>
                    </c:if>

                    <!--????????????????????-->
                    <c:if test ="${sessionScope.admin == null}">
                        <div class="row">

                            <!--/////////////////////////////////-->

                            <c:forEach items="${listpage}" var="o">              
                                <div class="col-12 col-md-6 col-lg-4">
                                    <div class="card">  
                                        <c:if test="${o.cid == 1}">
                                            <img src="Img/${o.img}" alt="Image" width="150" height="200" vspace="10" hspace="50">
                                        </c:if>
                                        <c:if test="${o.cid != 1}">
                                            <img src="Img/${o.img}" alt="Image" width="220" height="150" >
                                        </c:if>


                                        <div class="card-body">
                                            <h4 class="card-title show_txt"><a href="detail?pid=${o.pid}" title="View Detail">${o.pname}</a></h4>
                                            <p1 class="card-text show_txt"${o.pname}>
                                            </p1>
                                            <c:if test="${o.amount != 0}">
                                                <div class="row">
                                                    <div class="col">
                                                        <p class="btn btn-danger btn-block">${o.price}$</p>
                                                    </div>
                                                    <div class="col">

                                                        <a href="addtoCart?pid=${o.pid}" class="btn btn-success btn-block">Add to cart</a>


                                                    </div>
                                                </div>
                                            </c:if>
                                            <c:if test="${o.amount == 0}">
                                                <div class="row">
                                                    <div id="out" class="alert alert-dark" role="alert">Out Of Stock</div>
                                                </div>
                                            </c:if>

                                        </div>
                                    </div>

                                </div>
                            </c:forEach>
                        </div>
                        <div class="clearfix">
                            <div class="hint-text">Showing <b>6</b> out of <b>${size}</b> entries</div>
                            <ul class="pagination">
                                <!--<li class="page-item"><a href="#" class="page-link">Previous</a></li>-->
                                    <c:forEach begin="1" end="${end}" var="i">
                                    <li class="page-item"><a href="ControllerProduct?i=${i}" class="page-link">${i}</a></li>
                                    </c:forEach>
                                <!--                        <li class="page-item"><a href="#" class="page-link">1</a></li>
                                                        <li class="page-item"><a href="#" class="page-link">2</a></li>
                                                        <li class="page-item active"><a href="#" class="page-link">3</a></li>
                                                        <li class="page-item"><a href="#" class="page-link">4</a></li>
                                                        <li class="page-item"><a href="#" class="page-link">5</a></li>-->
                                <!--<li class="page-item"><a href="#" class="page-link">Next</a></li>-->
                            </ul>
                        </div>

                    </c:if>
                    <!--....................-->
                </div>

            </div>
        </div>
        <c:if test ="${sessionScope.admin == null}">
            <jsp:include page="footernew.jsp"></jsp:include>
        </c:if>
    </body>
</html>

