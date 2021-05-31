<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Update Product | Apple Store</title>
        <link rel="icon" href="https://i.pinimg.com/originals/77/c3/66/77c366436d8bd35fe8b3ce5b8c66992e.png"
              type ="image/x-icon">
        <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700" rel="stylesheet">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
        <style>
            html, body {
                min-height: 100%;
                width: 1000px;
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
        </style>
    </head>
    <body>

        <div class="testbox">
            <form action="updateProduct" method= post >
                <div class="banner">
                    <h1>APPLE STORE</h1>
                </div>
                <br/>
                <fieldset>
                    <legend>Update Product Form</legend>
                    <div class="colums">
                        <div class="item">
                            <label for="fname">Product ID<span>*</span></label>
                            <input id="fname" type="text" name="id" value="${p.pid}" readonly/>
                        </div>
                        <div class="item">
                            <label for="lname">product Name<span>*</span></label>
                            <input id="lname" type="text" name="name" value="${p.pname}" />
                        </div>
                        <div class="item">
                            <label for="address">Price<span>*</span></label>
                            <input id="address" type="number"   name="price" value="${p.price}" />
                        </div>
                        <div class="item">
                            <label for="phone">Amount</label>
                            <input id="phone" type="number"   name="amount" value="${p.amount}"/>
                        </div>
                        <div class="item">
                            <label for="saddress">Category ID</label>
                            <select name="cid">
                                <c:forEach items="${list}" var="o">
                                    <option value="${o.cid}" ${o.cid == p.cid ? "selected":""}>${o.cname}</option>
                                </c:forEach>
                            </select>

<!--<input id="saddress" type="number"   name="saddress" value="${p.cid}" />-->
                        </div>
                        <div class="item">
                            <label for="city">Description(DISPLAY - PLATFORM - MAIN CAMERA - SELFIE CAMERA - Chipset - Internal - BATTERY)</label>
<!--                            <div><input id="lname" type="text" name="name" value="${p.pname}" />
                                <input id="lname" type="text" name="name" value="${p.pname}" /></div>-->
                            <textarea id="city" name ="des"  rows="5" placeholder="DISPLAY - PLATFORM - MAIN CAMERA - SELFIE CAMERA - Chipset - Internal - BATTERY" >${p.description}</textarea>
                        </div>
                        <div class="item">
                            <label for="zip">Image</label>
                            <img class="im" src="Img/${p.img}">
                            <input name="img" type="file" class="formm" value="C:/Users/hp/Desktop/PR_F/web/Img/ipX.PNG">
                        </div>
                        <!--                        <div class="item">
                                                    <label for="country">Country</label>
                                                    <input id="country" type="text"   name="text" />
                                                </div>-->
                </fieldset>
                <br/>
                <p>${result}</p>
                <div class="btn-block">
                    <button type="submit" href="updateProduct?id=${p.pid}">Confirm</button>
                </div>
            </form>
        </div>
    </body>
</html>