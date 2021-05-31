<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style>
            @import url("https://fonts.googleapis.com/css?family=Arimo:400,700&display=swap");
            /*            body {
                            font-family: "Arimo", sans-serif;
                        }*/
            .hhh {
                color: #000;
                /*text-align: center;*/
                /*margin: auto;*/
                margin-left: -40px;
                font-size: 2em;
            }
            .warpper1a {
                /*width: 1px;*/
                display: flex;
                flex-direction: column;
                align-items: center;
            }
            /*            .tabsa1{
                            width: 500px;
                            height: 30px;
                        }*/
            .tab1q {
                font-family: "Arimo", sans-serif;
                cursor: pointer;
                padding: 10px 20px;
                margin: 0px 2px;
                background: #000;
                display: inline-block;
                color: #fff;
                border-radius: 3px 3px 0px 0px;
                box-shadow: 0 0.5rem 0.8rem #00000080;
            }
            .panels1 {
                font-family: "Arimo", sans-serif;
                background: #fffffff6;
                box-shadow: 0 2rem 2rem #00000080;
                min-height: 200px;
                width: 100%;
                max-width: 850px;
                height: 350px;
                border-radius: 3px;
                overflow: hidden;
                padding: 20px;
            }
            .panel12 {

                display: none;
                animation: fadein 0.8s;
            }
            @keyframes fadein {
                from {
                    opacity: 0;
                }
                to {
                    opacity: 1;
                }
            }
            /*            .panel1s1-title {
                            font-size: 1.5em;
                            font-weight: bold;
                        }*/
            .radio {
                display: none;
            }
            #one1a:checked ~ .panels1 #one1a-panel12,
            #two1a:checked ~ .panels1 #two1a-panel12,
            #three1a:checked ~ .panels1 #three1a-panel12,
            #four1a:checked ~ .panels1 #four1a-panel12 {
                display: block;
            }
            #one1a:checked ~ .tabsa1 #one1a-tab1q,
            #two1a:checked ~ .tabsa1 #two1a-tab1q,
            #three1a:checked ~ .tabsa1 #three1a-tab1q,
            #four1a:checked ~ .tabsa1 #four1a-tab1q {
                background: #fffffff6;
                color: #000;
                border-top: 3px solid #000;
            }
            .p{
                width: 1000px;
                height: 300px;

            }
            .p1{
                width: 200px;
                height: 350px;
                float: left;
                text-align: center;
            }

            .p2{
                width: 250px;
                height: 280px;
                float: left;
                text-align: center;
            }
            .bo{
                margin-top: 30px;
            }
            #ima{
                margin-right: 30px;
            }
            .blink1 {
                /*margin-top: 20px;*/
                /*padding-bottom: -40px;*/
                animation: blinker 0.5s linear infinite;
                color: #cc561e;
                font-size: 20px;
                font-weight: bold;
                font-family: sans-serif;
                text-align: center;
            }
            #out1{
                width: 80%;
                font-size: 18px;
                color: red;
                margin: auto;
                font-family: sans-serif;
            }
        </style>
    </head><!--/head-->

    <body>
        <div class="warpper1a">
            <p class="blink1"><i>Best Selling Products</i></p>
            <input class="radio" id="one1a" name="group" type="radio" checked>
            <input class="radio" id="two1a" name="group" type="radio">
            <input class="radio" id="three1a" name="group" type="radio">
            <input class="radio" id="four1a" name="group" type="radio">
            <div class="tabsa1">
                <label class="tab1q" id="one1a-tab1q" for="one1a">Iphone</label>
                <label class="tab1q" id="two1a-tab1q" for="two1a">Macbook</label>
                <label class="tab1q" id="three1a-tab1q" for="three1a">Apple Watch</label>
                <label class="tab1q" id="four1a-tab1q" for="four1a">AirPod</label>
            </div>
            <div class="panels1">
                <div class="panel12" id="one1a-panel12">
                    <!--<div class="panel-title">Why Learn CSS?</div>-->
                    <div class="p">
                        <c:forEach items="${listnew}" var="o">
                            <div class="p1">
                                <!--<img class="new1" src="https://cauthangvietuc.vn/Hinh%20CTSP/new.gif" width="50px" height="40px"/>-->
                                <img id="ima" src="Img/${o.img}" alt="image" width="100" height="150" />
                                <h2 class="hhh">${o.pname}</h2>
                                <p>${o.price}</p>
                                <c:if test="${o.amount != 0}">
                                    <a class="bo" href="addtoCart?pid=${o.pid}" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Add to cart</a>
                                </c:if>
                                <c:if test="${o.amount == 0}">
                                    <div id="out1" class="alert alert-dark" role="alert">Out Of Stock</div>
                                </c:if>
                            </div>
                        </c:forEach>
                    </div>

                </div>
                <div class="panel12" id="two1a-panel12">
                    <div class="p">
                        <c:forEach items="${listnew1}" var="o">
                            <div class="p1">
                                <img id="ima" src="Img/${o.img}" alt="image" width="100" height="150" />
                                <h2 class="hhh">${o.pname}</h2>
                                <p>${o.price}</p>
                                <c:if test="${o.amount != 0}">
                                    <a class="bo" href="addtoCart?pid=${o.pid}" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Add to cart</a>
                                </c:if>
                                <c:if test="${o.amount == 0}">
                                    <div id="out1" class="alert alert-dark" role="alert">Out Of Stock</div>
                                </c:if>
                            </div>
                        </c:forEach>
                    </div>
                </div>
                <div class="panel12" id="three1a-panel12">
                    <div class="p">
                        <c:forEach items="${listnew2}" var="o">
                            <div class="p1">
                                <img id="ima" src="Img/${o.img}" alt="image" width="100" height="150" />
                                <h2 class="hhh">${o.pname}</h2>
                                <p>${o.price}</p>
                                <c:if test="${o.amount != 0}">
                                    <a class="bo" href="addtoCart?pid=${o.pid}" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Add to cart</a>
                                </c:if>
                                <c:if test="${o.amount == 0}">
                                    <div id="out1" class="alert alert-dark" role="alert">Out Of Stock</div>
                                </c:if>
                            </div>
                        </c:forEach>
                    </div>
                </div>
                <div class="panel12" id="four1a-panel12">
                    <div class="p">
                        <c:forEach items="${listnew3}" var="o">
                            <div class="p1">
                                <img id="ima" src="Img/${o.img}" alt="image" width="100" height="150" />
                                <h2 class="hhh">${o.pname}</h2>
                                <p>${o.price}</p>
                               <c:if test="${o.amount != 0}">
                                    <a class="bo" href="addtoCart?pid=${o.pid}" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Add to cart</a>
                                </c:if>
                                <c:if test="${o.amount == 0}">
                                    <div id="out1" class="alert alert-dark" role="alert">Out Of Stock</div>
                                </c:if>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>


    </body>
</html>