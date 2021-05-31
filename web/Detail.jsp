<%-- 
    Document   : Detail
    Created on : Dec 29, 2020, 5:43:04 PM
    Author     : trinh
--%>

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
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <style>
            .gallery-wrap .img-big-wrap img {
                height: 450px;
                width: auto;
                display: inline-block;
                cursor: zoom-in;
            }


            .gallery-wrap .img-small-wrap .item-gallery {
                width: 60px;
                height: 60px;
                border: 1px solid #ddd;
                margin: 7px 2px;
                display: inline-block;
                overflow: hidden;
            }

            .gallery-wrap .img-small-wrap {
                text-align: center;
            }
            .gallery-wrap .img-small-wrap img {
                max-width: 100%;
                max-height: 100%;
                object-fit: cover;
                border-radius: 4px;
                cursor: zoom-in;
            }
            .img-big-wrap img{
                width: 100% !important;
                height: auto !important;
                margin-top: 30%;
            }
            .out2{
                color: red;
                font: bold;
            }
        </style>
    </head>
    <body>
        <jsp:include page="Menu.jsp"></jsp:include>
        <%--<jsp:include page="left.jsp"></jsp:include>--%>
        <div class="container">
            <div class="row">
                <div class="col-sm-3">
                    <div class="card bg-light mb-3">
                        <div class="card-header bg-primary text-white text-uppercase"><i class="fa fa-list"></i> Categories</div>
                        <ul class="list-group category_block">
                            <c:forEach items="${listc}" var="o">
                                <li class="list-group-item text-white ${tag == o.cid ? "active" : ""}"><a href="categoryy?cid=${o.cid}">${o.cname}</a></li>
                                </c:forEach>
                        </ul>
                    </div>
                    <div class="card bg-light mb-3">
                        <div class="card-header bg-success text-white text-uppercase">Last product</div>
                        <div class="card-body">
                            <p class="card-text"><h4>MacBook Pro</h4>
                            All systems Pro.</p>
                            <img class="img-fluid" src="Img/${plast.img}" alt="Image" />
                            <h5 class="card-title"><a href="detail?pid=${plast.pid}" title="View Detail">${plast.pname}</a></h5>
                            <p class="bloc_left_price">$ ${plast.price}</p>
                        </div>
                    </div>
                </div>
                <div class="col-sm-9">
                    <div class="container">
                        <div class="card">
                            <div class="row">
                                <aside class="col-sm-5 border-right">
                                    <article class="gallery-wrap"> 
                                        <div class="img-big-wrap">
                                            <div> <a href="#"><img src="Img/${detail.img}"></a></div>
                                        </div> <!-- slider-product.// -->
                                        <div class="img-small-wrap">
                                        </div> <!-- slider-nav.// -->
                                    </article> <!-- gallery-wrap .end// -->
                                </aside>
                                <aside class="col-sm-7">

                                    <article class="card-body p-5">
                                        <h3 class="title mb-3">${detail.pname}</h3>

                                        <p class="price-detail-wrap"> 
                                            <span class="price h3 text-warning"> 
                                                <span class="currency">US $</span><span class="num">${detail.price}</span>
                                            </span> 
                                        </p> <!-- price-detail-wrap .// -->
                                        <dl class="item-property">
                                            <h4><i>Description</i></h4>
                                            <dd>
                                                <table  cellpadding="10"> 
                                                    <tbody>
                                                        <tr>
                                                            <th>DISPLAY</th>
                                                            <th>${a0}</th>  
                                                        </tr>
                                                        <tr>
                                                            <th>PLATFORM</th>
                                                            <th>${a1}</th>  
                                                        </tr>
                                                        <tr>
                                                            <th>MAIN CAMERA</th>
                                                            <th>${a2} - ${a3}</th>  
                                                        </tr>
                                                        <tr>
                                                            <th>SELFIE CAMERA</th>
                                                            <th>${a4}</th>  
                                                        </tr>
                                                        <tr>
                                                            <th>Chipset</th>
                                                            <th>${a5}</th>  
                                                        </tr>
                                                        <tr>
                                                            <th>Internal</th>
                                                            <th>${a6}</th>  
                                                        </tr>
                                                        <tr>
                                                            <th>BATTERY</th>
                                                            <th>${a7}</th>  
                                                        </tr>
                                                    </tbody>
                                                </table>
                                            </dd>
                                        </dl>

                                        <hr>
                                        <div class="row">
                                            <div class="col-sm-5">
                                                <dl class="param param-inline">
                                                    <!--<form action="addtoCart" method="post">-->
                                                    <c:if test="${amount == 0}">
                                                        <dt><u class="out2">Out of Stock</u></dt>
                                                            </c:if>

                                                    <c:if test="${amount != 0}">
                                                        <dt>Warehouse: ${amount}</dt>


                                                        <dt>Quantity: </dt>
                                                        <dd>
                                                            <select id="quantity" class="form-control form-control-sm" style="width:70px;">
                                                                <c:forEach begin="1" end="${amount}" var="o">
                                                                    <option> ${o} </option>
                                                                </c:forEach>
                                                            </select>
                                                        </dd>
                                                    </c:if>
                                                    <!--</form>-->
                                                </dl>  <!-- item-property .// -->
                                            </div> <!-- col.// -->

                                        </div> <!-- row.// -->
                                        <hr>
                                        <!--<a href="#" class="btn btn-lg btn-primary text-uppercase"> Buy now </a>-->
                                        <c:if test="${amount != 0}">
                                            <a href="#" onclick="checkReceiver()" class="btn btn-lg btn-outline-primary text-uppercase"> <i class="fas fa-shopping-cart"></i> Add to cart </a>
                                        </c:if>
                                    </article> <!-- card-body.// -->

                                </aside> <!-- col.// -->
                            </div> <!-- row.// -->
                        </div> <!-- card.// -->


                    </div>
                </div>
            </div>
        </div>
        <jsp:include page="Footer.jsp"></jsp:include>
        </body>
        <script>
            function checkReceiver() {
                var quantity = document.getElementById("quantity").value;

                window.location = "addtoCart?pid=" + ${detail.pid} + "&quantity=" + quantity;
            }
    </script>
</html>
