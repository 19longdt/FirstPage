<%-- 
    Document   : Statistical
    Created on : 17-Mar-2021, 08:43:26
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Statistical | Apple Store</title>
        <link rel="icon" href="https://i.pinimg.com/originals/77/c3/66/77c366436d8bd35fe8b3ce5b8c66992e.png"
              type ="image/x-icon">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style>
            /*	
        Side Navigation Menu V2, RWD
        ===================
        Author: https://github.com/pablorgarcia
            */

            @charset "UTF-8";
            @import url(https://fonts.googleapis.com/css?family=Open+Sans:300,400,700);

            body {
                font-family: 'Open Sans', sans-serif;
                font-weight: 300;
                line-height: 1.42em;
                color:#A7A1AE;
                background-color:#1F2739;
            }

            h1 {
                font-size:3em; 
                font-weight: 300;
                line-height:1em;
                text-align: center;
                color: #4DC3FA;
            }

            h2 {
                font-size:1em; 
                font-weight: 300;
                text-align: center;
                display: block;
                line-height:1em;
                padding-bottom: 2em;
                color: #FB667A;
            }

            h2 a {
                font-weight: 700;
                text-transform: uppercase;
                color: #FB667A;
                text-decoration: none;
            }

            .blue { color: #185875; }
            .yellow { color: #FFF842; }

            .container th h1 {
                font-weight: bold;
                font-size: 1em;
                text-align: center;
                color: #4DC3FA;
            }

            .container td {
                font-weight: normal;
                font-size: 1em;
                -webkit-box-shadow: 0 2px 2px -2px #0E1119;
                -moz-box-shadow: 0 2px 2px -2px #0E1119;
                box-shadow: 0 2px 2px -2px #0E1119;
            }

            .container {
                text-align: center;
                overflow: hidden;
                width: 80%;
                margin: 0 auto;
                display: table;
                padding: 0 0 8em 0;
            }

            .container td, .container th {
                padding-bottom: 2%;
                padding-top: 2%;
                /*padding-left:2%;*/
                text-align: center;
            }

            /* Background-color of the odd rows */
            .container tr:nth-child(odd) {
                background-color: #323C50;
            }

            /* Background-color of the even rows */
            .container tr:nth-child(even) {
                background-color: #2C3446;
            }

            .container th {
                background-color: #1F2739;
            }

            .container td:first-child { color: #FB667A; }

            .container tr:hover {
                background-color: #464A52;
                -webkit-box-shadow: 0 6px 6px -6px #0E1119;
                -moz-box-shadow: 0 6px 6px -6px #0E1119;
                box-shadow: 0 6px 6px -6px #0E1119;
            }

            .container td:hover {
                background-color: #FFF842;
                color: #403E10;
                font-weight: bold;

                box-shadow: #7F7C21 -1px 1px, #7F7C21 -2px 2px, #7F7C21 -3px 3px, #7F7C21 -4px 4px, #7F7C21 -5px 5px, #7F7C21 -6px 6px;
                transform: translate3d(6px, -6px, 0);

                transition-delay: 0s;
                transition-duration: 0.4s;
                transition-property: all;
                transition-timing-function: line;
            }

            @media (max-width: 800px) {
                .container td:nth-child(4),
                .container th:nth-child(4) { display: none; }
            }
            .im{
/*                margin-left: 200px;
                */margin-bottom:  -10px;
            }
        </style>
    </head>
    <body>
        <h1>   <a href="ControllerProduct" ></a> <img class="im" src="https://i.pinimg.com/originals/77/c3/66/77c366436d8bd35fe8b3ce5b8c66992e.png" width="60px" height="60px"  />
<span class="blue">&lt;</span>Table<span class="blue">&gt;</span> <span class="yellow">Statistical</pan></h1>
       

        <table class="container">
            <thead>
                <tr><th><h1>Category</h1></th>
                    <th><h1>Warehouse</h1></th>
                    <th><h1>Sold</h1></th>
                    <th><h1>Bestseller</h1></th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>iPhone</td>
                    <td>${a1}</td>
                    <td>${b1}</td>
                    <td>${l1}</td>
                </tr>
                <tr>
                    <td>MacBook</td>
                    <td>${a2}</td>
                    <td>${b2}</td>
                    <td>${l2}</td>
                </tr>
                <tr>
                    <td>Apple Watch</td>
                    <td>${a3}</td>
                    <td>${b3}</td>
                    <td>${l3}</td>
                </tr>
                <tr>
                    <td>Music</td>
                    <td>${a4}</td>
                    <td>${b4}</td>
                    <td>${l4}</td>
                </tr>
            </tbody>
        </table>
                 <!--<h4>Created with love by <a href="https://github.com/pablorgarcia" target="_blank">Pablo García</a></h4>-->
    </body>
</html>
