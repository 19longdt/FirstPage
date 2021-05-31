<%-- 
    Document   : Cart
    Created on : Oct 31, 2020, 9:42:21 PM
    Author     : trinh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="icon" href="https://i.pinimg.com/originals/77/c3/66/77c366436d8bd35fe8b3ce5b8c66992e.png"
              type ="image/x-icon">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cart | Apple Store</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script>
            function checkReceiver() {
                var name = document.getElementById("name").value;
                var phone = document.getElementById("phone").value;
                var address = document.getElementById("address").value;
                var mail = document.getElementById("mail").value;
                if (name === "" || phone === "" || address === "") {
                    alert("Please Login Before Buy!!");
                    return;
                }

                window.location = "buy?name=" + name + "&address=" + address + "&phone=" + phone + "&mail=" +mail;
            }
            function check() {
                var name = document.getElementById("name").value;
                var phone = document.getElementById("phone").value;
                var address = document.getElementById("address").value;
                var authcode = document.getElementById("authcode").value;
//                if (name === "" || phone === "" || address === "") {
//                    alert("Please Login Before Buy!!");
//                    return;
//                }
                if (authcode === "") {
                    alert("Please Input Code!!");
                    return;
                }

                window.location = "addOrder?name=" + name + "&address=" + address + "&phone=" + phone + "&=authcode" + authcode;
            }
        </script>
    </head>

    <body>
        <jsp:include page="Menu.jsp"></jsp:include>


            <div class="shopping-cart">
                <div class="px-4 px-lg-0">

                    <div class="pb-5">
                        <div class="container">
                            <div class="row">
                                <div class="col-lg-12 p-5 bg-white rounded shadow-sm mb-5">

                                    <!-- Shopping cart table -->
                                    <div class="table-responsive">
                                        <table class="table">
                                            <thead>
                                                <tr>
                                                    <th scope="col" class="border-0 bg-light">
                                                        <div class="p-2 px-3 text-uppercase">Product</div>
                                                    </th>
                                                    <th scope="col" class="border-0 bg-light">
                                                        <div class="py-2 text-uppercase">Price</div>
                                                    </th>
                                                    <th scope="col" class="border-0 bg-light">
                                                        <div class="py-2 text-uppercase">Amount</div>
                                                    </th>
                                                    <th scope="col" class="border-0 bg-light">
                                                        <div class="py-2 text-uppercase">Into Money</div>
                                                    </th>
                                                    <th scope="col" class="border-0 bg-light">
                                                        <div class="py-2 text-uppercase">Delete</div>
                                                    </th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                            <c:forEach items="${sessionScope.list}" var="o">
                                                <tr>
                                                    <th scope="row">
                                                        <div class="p-2">
                                                            <img src="Img/${o.img}" alt="Image" width="70" class="img-fluid rounded shadow-sm">
                                                            <div class="ml-3 d-inline-block align-middle">
                                                                <h5 class="mb-0"> <a href="#" class="text-dark d-inline-block">${o.pname}</a></h5><span class="text-muted font-weight-normal font-italic"></span>
                                                            </div>
                                                        </div>
                                                    </th>
                                                    <td class="align-middle"><strong>${o.price}$</strong></td>
                                                    <td class="align-middle">
                                                        <c:if test="${sessionScope.authcode != null}">
                                                            ${o.amount}
                                                        </c:if>
                                                        <c:if test="${sessionScope.authcode == null}">
                                                            <a href="buydown?pid=${o.pid}"><button class="btnSub">-</button></a> 
                                                            <strong>${o.amount}</strong>
                                                            <a href="buyup?pid=${o.pid}"><button class="btnAdd">+</button></a>
                                                        </c:if>
                                                    </td>
                                                    <td class="align-middle"><strong>${o.price * o.amount}$</strong></td>
                                                    <td class="align-middle"><a href="deleteCart?pid=${o.pid}" class="text-dark">
                                                            <button type="button" class="btn btn-danger">Delete</button>
                                                        </a>
                                                    </td>

                                                </tr>
                                                <c:if test="${sessionScope.pup == o.pid}">
                                                    <tr>${sessionScope.result}</tr>
                                                </c:if>

                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                                <!-- End -->
                            </div>
                        </div>
                        <div class="row py-5 p-4 bg-white rounded shadow-sm">
                            <div class="col-lg-6">
                                <div class="bg-light rounded-pill px-4 py-3 text-uppercase font-weight-bold">Check Out</div>
                                <div class="p-4">
                                    <div class="input-group mb-4 border rounded-pill p-2">
                                        <!--                                        <input type="text" placeholder="Nhập Voucher" aria-describedby="button-addon3" class="form-control border-0">
                                                                                <div class="input-group-append border-0">
                                                                                    <button id="button-addon3" type="button" class="btn btn-dark px-4 rounded-pill"><i class="fa fa-gift mr-2"></i>Sử dụng</button>
                                                                                </div>-->
                                        <p>Full Name<input type="text" id="name" aria-describedby="button-addon3" class="form-control border-0" value="${u.name}" readonly ></p>
                                        <p>Phone<input type="text" id="phone" aria-describedby="button-addon3" class="form-control border-0" value="${u.phone}" ${sessionScope.authcode != null ? "readonly":""} ></p>
                                    </div>
                                    <div class="input-group mb-4 border rounded-pill p-2">
                                        <p>Address<input type="text" id="address" aria-describedby="button-addon3" class="form-control border-0" value="${u.address}" ${sessionScope.authcode != null ? "readonly":""} ></p>
                                        <p>Mail<input type="text" id="mail" aria-describedby="button-addon3" class="form-control border-0" value="${u.mail}" ${sessionScope.authcode != null ? "readonly":""} ></p>
                                    </div>
                                    <p class="text-danger">${fail}</p>
                                </div>
                            </div>
                            <c:if test="${sessionScope.authcode == null}">
                                <div class="col-lg-6">
                                    <div class="bg-light rounded-pill px-4 py-3 text-uppercase font-weight-bold">Into Money</div>
                                    <div class="p-4">
                                        <ul class="list-unstyled mb-4">
                                            <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">TOTAL</strong><strong>${allTotal} $</strong></li>
                                            <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">Transport Fee</strong><strong>Free ship</strong></li>
                                            <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">VAT</strong><strong>10 $</strong></li>
                                            <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">TOTAL ALL</strong>
                                                <h5 name ="all" class="font-weight-bold">${allTotal+10} $</h5>
                                            </li>
                                        </ul><a href="#" onclick="checkReceiver()" class="btn btn-dark rounded-pill py-2 btn-block">BUY</a>
                                    </div>
                                </div>
                            </c:if>

                            <c:if test="${sessionScope.authcode != null}">
                                <div class="col-lg-6">
                                    <div class="bg-light rounded-pill px-4 py-3 text-uppercase font-weight-bold">Into Money</div>
                                    <div class="p-4">
                                        <ul class="list-unstyled mb-4">
                                            <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">TOTAL</strong><strong>${allTotal} $</strong></li>
                                            <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">Transport Fee</strong><strong>Free ship</strong></li>
                                            <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">VAT</strong><strong>10 $</strong></li>
                                            <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">TOTAL ALL</strong>
                                                <h5 name ="all" class="font-weight-bold">${allTotal+10} $</h5>
                                            </li>
                                        </ul>
                                        <!--<a href="#" onclick="checkReceiver()" class="btn btn-dark rounded-pill py-2 btn-block">BUY</a>-->
                                    </div>
                                </div>

                                <c:if test="${ver == null}">
                                    <c:if test="${sessionScope.authcode != null}">
                                        <p class="text-danger">${suc}</p>
                                        
                                        <form action="addOrder" method="post">
                                            <input type="text" name="authcode" placeholder="Enter Code">
                                            <!--<a href="#" onclick="check()" class="btn btn-dark">Submit</a>-->
                                            <input type="submit" value="Submit" />
                                        </form>
                                    </c:if>
                                    <%--<c:if test="${sessionScope.authcode == null}">--%>
                                        <!--<p class="text-danger">${fail}</p>-->
                                    <%--</c:if>--%>
                                </c:if>
                                <c:if test="${ver != null}">
                                    <p class="text-danger">${ver}</p>
                                    <!--<a class="nav-link" href="LoginRegister.jsp">Login Now</a>-->
                                </c:if> 
                            </c:if>

                        </div>

                    </div>
                </div>
            </div>
        </div>

        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </body>

</html>
</html>
