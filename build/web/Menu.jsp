<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--begin of menu-->
<style>
    /*    .container{
            width: 1300px;
        }*/
</style>
<nav class="navbar navbar-expand-md navbar-dark bg-dark">
    <div class="container">
        <img src="https://i.pinimg.com/originals/77/c3/66/77c366436d8bd35fe8b3ce5b8c66992e.png" width="60px" height="60px" />
        <a class="navbar-brand" href="ControllerProduct">APPLE STORE</a>
        <c:if test ="${sessionScope.admin != null}">
<!--            <li class="nav-item">-->
                <a class="nav-link" href="#" rel="noopener noreferrer">Hi Admin</a>
            <!--</li>-->
        </c:if>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse justify-content-end" id="navbarsExampleDefault">
            <ul class="navbar-nav m-auto">
                <c:if test ="${sessionScope.acc != null}">
                    <li class="nav-item">
                        <a class="nav-link" href="managermyOrder?id=${sessionScope.acc.account}" target="_blank" rel="noopener noreferrer">Manager Your Order</a>
                    </li>
                </c:if>
                <c:if test ="${sessionScope.admin != null}">
                    <li class="nav-item">
                        <a class="nav-link" href="managerUser" target="_blank" rel="noopener noreferrer">Manager User</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="manager" target="_blank" rel="noopener noreferrer">Manager Product</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="managercategory" target="_blank" rel="noopener noreferrer">Manager Category</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="loadOrder" target="_blank" rel="noopener noreferrer">Manager Bill</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="managerstatistical" target="_blank" rel="noopener noreferrer">Product Statistical</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="logout">Logout</a>
                    </li>
                </c:if>

                <c:if test ="${sessionScope.acc != null}">
                    <li class="nav-item">
                        <a class="nav-link" href="managerInforUser?user=${sessionScope.acc.account}" target="_blank" rel="noopener noreferrer">Hi ${sessionScope.acc.name}</a>
                    </li>
                    <!--                    <li class="nav-item">
                                            <a class="nav-link" href="#" target="_blank" rel="noopener noreferrer">Manager Account</a>
                                        </li>-->
                    <li class="nav-item">
                        <a class="nav-link" href="logout">Logout</a>
                    </li>
                </c:if>
                <c:if test ="${sessionScope.acc == null && sessionScope.admin == null}">
                    <li class="nav-item">
                        <a class="nav-link" href="LoginRegister.jsp">Login</a>
                    </li>
                </c:if>
            </ul>
            <c:if test ="${sessionScope.admin == null}">
                <form action="search" method="post" class="form-inline my-2 my-lg-0">
                    <div class="input-group input-group-sm">
                        <input value="${txtS}" name="txt" type="text" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" placeholder="Search...">



                        <div class="input-group-append">
                            <button type="submit" class="btn btn-secondary btn-number">
                                <i class="fa fa-search"></i>
                            </button>
                        </div>
                    </div>
                        <!--"${pageContext.request.contextPath }/ShoppingCart.jsp"-->
                    <a class="btn btn-success btn-sm ml-3" href="showCart">
                        <i class="fa fa-shopping-cart"></i> Cart
                        <span class="badge badge-light">${sessionScope.count}</span>
                    </a>
                </form>
            </c:if>
        </div>
    </div>
</nav>

<!--end of menu-->
