    <%-- 
    Document   : UpdateUser
    Created on : 14-Mar-2021, 18:09:31
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Update User | Apple Store</title>
        <link rel="icon" href="https://i.pinimg.com/originals/77/c3/66/77c366436d8bd35fe8b3ce5b8c66992e.png"
              type ="image/x-icon">
        <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700" rel="stylesheet">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
        <style>
            /*????????????????????*/
            html, body {
                min-height: 100%;

                margin: auto;
            }
            body, div, form, input, select, textarea, label { 
                padding: 0;
                margin: 0;
                outline: none;
                font-family: Roboto, Arial, sans-serif;
                font-size: 14px;
                color: #666;
                line-height: 22px;
            }
            img{
                width: 120px;
                height: 150px;
            }
            h1 {
                position: absolute;
                margin:0;
                font-size: 60px;
                color: #fff;
                z-index: 2;
                line-height: 83px;
                top:30px;
            }
            legend {
                padding: 10px;      
                font-family: Roboto, Arial, sans-serif;
                font-size: 18px;
                color: #fff;
                background-color: #1c87c9;
            }
            textarea {
                width: calc(100% - 12px);
                padding: 5px;
            }
            .testbox {
                display: flex;
                justify-content: center;
                align-items: center;
                height: inherit;
                padding: 20px;
            }
            form {
                width: 100%;
                padding: 20px;
                border-radius: 6px;
                background: #fff;
                box-shadow: 0 0 8px #006622; 
            }
            .banner {
                position: relative;
                height: 250px;
                background-image: url("/uploads/media/default/0001/02/cc6bc584f236c7234947015b89151ab6d04c4cbf.jpeg");  
                background-size: cover;
                display: flex;
                justify-content: center;
                align-items: center;
                text-align: center;
            }
            .banner::after {
                content: "";
                background-color: rgba(0, 0, 0, 0.4); 
                position: absolute;
                width: 100%;
                height: 100%;
            }
            input, select, textarea {
                margin-bottom: 10px;
                border: 1px solid #ccc;
                border-radius: 3px;
            }
            input {
                width: calc(100% - 10px);
                padding: 5px;
            }
            input[type="date"] {
                padding: 4px 5px;
            }
            textarea {
                width: calc(100% - 12px);
                padding: 5px;
            }
            .item:hover p, .item:hover i, .question:hover p, .question label:hover, input:hover::placeholder {
                color:  #006622;
            }
            .checkbox input[type=checkbox] {
                display:inline-block;
                height:15px;
                width:15px;
                margin-right:5px;
                vertical-align:text-top;
            }
            .item input:hover, .item select:hover, .item textarea:hover {
                border: 1px solid transparent;
                box-shadow: 0 0 3px 0  #006622;
                color: #006622;
            }
            .item {
                position: relative;
                margin: 10px 0;
            }
            .item span {
                color: red;
            }
            .week {
                display:flex;
                justfiy-content:space-between;
            }
            .colums {
                display:flex;
                justify-content:space-between;
                flex-direction:row;
                flex-wrap:wrap;
            }
            .colums div {
                width:30%;
            }
            input[type=radio], input[type=checkbox]  {
                display: none;
            }
            label.radio {
                position: relative;
                display: inline-block;
                margin: 5px 20px 15px 0;
                cursor: pointer;
            }
            .question span {
                margin-left: 30px;
            }
            .question-answer label {
                display: block;
            }
            label.radio:before {
                content: "";
                position: absolute;
                left: 0;
                width: 17px;
                height: 17px;
                border-radius: 50%;
                border: 2px solid #ccc;
            }
            input[type=radio]:checked + label:before, label.radio:hover:before {
                border: 2px solid  #006622;
            }
            label.radio:after {
                content: "";
                position: absolute;
                top: 6px;
                left: 5px;
                width: 8px;
                height: 4px;
                border: 3px solid  #006622;
                border-top: none;
                border-right: none;
                transform: rotate(-45deg);
                opacity: 0;
            }
            input[type=radio]:checked + label:after {
                opacity: 1;
            }
            .flax {
                display:flex;
                justify-content:space-around;
            }
            .btn-block {
                margin-top: 10px;
                text-align: center;
            }
            button {
                width: 150px;
                padding: 10px;
                border: none;
                border-radius: 5px; 
                background:  #1c87c9;
                font-size: 16px;
                color: #fff;
                cursor: pointer;
            }
            button:hover {
                background:  #0692e8;
            }
            @media (min-width: 568px) {
                .name-item{
                    display: flex;
                    flex-wrap: wrap;
                    justify-content: space-between;
                }
                .name-item input, .name-item div {
                    width: calc(50% - 20px);
                }
                .name-item div input {
                    width:97%;}
                .name-item div label {
                    display:block;
                    padding-bottom:5px;
                }
            }
            .testbox{
                width: 1000px; 
                margin: auto;
            }
            .abc{
                margin-bottom: -80px;
                /*                width = 100% ;
                                height = 60px;*/
            }
        </style>
    </head>
    <body>
        <jsp:include page="snow.jsp"></jsp:include>
            <div class="testbox">
                <form action="managerInforUser" method= post >
                    <div class="banner">
                        <div class="abc">
                            <img src="https://i.pinimg.com/originals/77/c3/66/77c366436d8bd35fe8b3ce5b8c66992e.png" />

                        </div>
                        <h1>APPLE STORE</h1>
                    </div>
                    <br/>
                    <fieldset>
                        <legend>YOUR INFORMATION</legend>
                        <div class="colums">
                            <div class="item">
                                <label for="fname">Account<span>*</span></label>
                                <input id="fname" type="text" name="acc" value="${u.account}" readonly />
                        </div>
                        <div class="item">
                            <label for="lname">Password<span>*</span></label>
                            <input id="lname" type="text" name="pass" value="${u.password}" />
                        </div>
                        <div class="item">
                            <label for="lname">RePassword<span>*</span></label>
                            <input id="lname" type="text" name="repass" value="${u.password}" />
                        </div>
                        <div class="item">
                            <label for="address">Full Name<span>*</span></label>
                            <input id="address" type="text"   name="name" value="${u.name}" />
                        </div>
                        <div class="item">
                            <label for="phone">Date Of Birth</label>
                            <input id="phone" type="date" name="dob" value="${u.date}"/>
                        </div>
                        <div class="item">


                            <label for="saddress">Gender</label>


                            <c:if test="${u.gender == 1}">
                                <select name="gender">
                                    <option value="1" selected >Male</option>
                                    <option value="0" >FeMale</option>
                                    <option value="2" >Other</option>
                                </select>
                            </c:if>
                            <c:if test="${u.gender == 0}">
                                <select name="gender">
                                    <option value="1"  >Male</option>
                                    <option value="0" selected>FeMale</option>
                                    <option value="2" >Other</option>
                                </select>
                            </c:if>

                            <c:if test="${u.gender == 2}">
                                <select name="gender">
                                    <option value="1"  >Male</option>
                                    <option value="0" >FeMale</option>
                                    <option value="2" selected>Other</option>
                                </select>
                            </c:if>


                        </div>
                        <div class="item">
                            <label for="phone">Address</label>
                            <input name="add" id="city" type="text" value="${u.address}" />
                        </div>
                        <div class="item">
                            <label for="phone">Answer - What is your dream job? </label>
                            <input name="ans" id="city" type="text" value="${u.answer}" />
                        </div>
                        <div class="item">
                            <label for="city">Phone</label>
                            <input name="phone" id="city" type="number" value="${u.phone}" />
                        </div>

                </fieldset>
                <br/>

                <div class="btn-block">
                    <button  type="submit">Confirm</button>
                    <input type="hidden" name ="action" value="update">
                    <div class="alert alert-dark" role="alert">${a}</div>
                </div>
            </form>
        </div>

    </body>
</html>