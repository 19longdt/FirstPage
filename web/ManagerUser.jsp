<%-- 
    Document   : ManagerUser
    Created on : 14-Mar-2021, 10:47:24
    Author     : hp
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
    <form action="managerUser" method="post">
        <head>
            <meta charset="utf-8">
            <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
            <title>Manager User | Apple Store</title>
            <link rel="icon" href="https://i.pinimg.com/originals/77/c3/66/77c366436d8bd35fe8b3ce5b8c66992e.png"
              type ="image/x-icon">
            <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round|Open+Sans">
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
            <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
            <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
            <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
            <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
            <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
            <style>
                body {
                    color: #404E67;
                    background: #F5F7FA;
                    font-family: 'Open Sans', sans-serif;
                }
                .table-wrapper {
                    width: 1000px;
                    margin: 30px auto;
                    background: #fff;
                    padding: 20px;	
                    box-shadow: 0 1px 1px rgba(0,0,0,.05);
                }
                .table-title {
                    padding-bottom: 10px;
                    margin: 0 0 10px;
                }
                .table-title h2 {
                    margin: 6px 0 0;
                    font-size: 22px;
                }
                .table-title .add-new {
                    float: right;
                    height: 30px;
                    font-weight: bold;
                    font-size: 12px;
                    text-shadow: none;
                    min-width: 100px;
                    border-radius: 50px;
                    line-height: 13px;
                }
                .table-title .add-new i {
                    margin-right: 4px;
                }
                table.table {
                    table-layout: fixed;
                }
                table.table tr th, table.table tr td {
                    border-color: #e9e9e9;
                }
                table.table th i {
                    font-size: 13px;
                    margin: 0 5px;
                    cursor: pointer;
                }
                table.table th:last-child {
                    width: 100px;
                }
                table.table td a {
                    cursor: pointer;
                    display: inline-block;
                    margin: 0 5px;
                    min-width: 24px;
                }    
                table.table td a.add {
                    color: #27C46B;
                }
                table.table td a.edit {
                    color: #FFC107;
                }
                table.table td a.delete {
                    color: #E34724;
                }
                table.table td i {
                    font-size: 19px;
                }
                table.table td a.add i {
                    font-size: 24px;
                    margin-right: -1px;
                    position: relative;
                    top: 3px;
                }    
                table.table .form-control {
                    height: 32px;
                    line-height: 32px;
                    box-shadow: none;
                    border-radius: 2px;
                }
                table.table .form-control.error {
                    border-color: #f50000;
                }
                table.table td .add {
                    display: none;
                }
            </style>
            <script>
                $(document).ready(function () {
                    $('[data-toggle="tooltip"]').tooltip();
                    var actions = $("table td:last-child").html();
                    // Append table with add row form on add new button click
                    $(".add-new").click(function () {
                        $(this).attr("disabled", "disabled");
                        var index = $("table tbody tr:last-child").index();
                        var row = '<tr>' +
                                '<td><input type="text" class="form-control" name="account" id="name"></td>' +
                                '<td><input type="text" class="form-control" name="pass" id="department"></td>' +
                                '<td><input type="text" class="form-control" name="name" id="phone"></td>' +
                                '<td><input type="text" class="form-control" name="dob" id="name"></td>' +
                                '<td><input type="text" class="form-control" name="gender" id="department"></td>' +
                                '<td><input type="text" class="form-control" name="address" id="department"></td>' +
                                '<td><input type="text" class="form-control" name="phone" id="phone"></td>' +
                                '<td><input type="text" class="form-control" name="ans" id="department"></td>' +
                                '<td>' + actions + '</td>' +
                                '</tr>';
                        $("table").append(row);
                        $("table tbody tr").eq(index + 1).find(".add, .edit").toggle();
                        $('[data-toggle="tooltip"]').tooltip();
                    });
                    // Add row on add button click
                    $(document).on("click", ".add", function () {
                        var empty = false;
                        var input = $(this).parents("tr").find('input[type="text"]');
                        input.each(function () {
                            if (!$(this).val()) {
                                $(this).addClass("error");
                                empty = true;
                            } else {
                                $(this).removeClass("error");
                            }
                        });
                        $(this).parents("tr").find(".error").first().focus();
                        if (!empty) {
                            input.each(function () {
                                $(this).parent("td").html($(this).val());
                            });
                            $(this).parents("tr").find(".add, .edit").toggle();
                            $(".add-new").removeAttr("disabled");
                        }
                    });
                    // Edit row on edit button click
                    $(document).on("click", ".edit", function () {
                        $(this).parents("tr").find("td:not(:last-child)").each(function () {
                            $(this).html('<input type="text" class="form-control" value="' + $(this).text() + '">');
                        });
                        $(this).parents("tr").find(".add, .edit").toggle();
                        $(".add-new").attr("disabled", "disabled");
                    });
                    // Delete row on delete button click
                    $(document).on("click", ".delete", function () {
                        $(this).parents("tr").remove();
                        $(".add-new").removeAttr("disabled");
                    });
                });
            </script>
        </head>
        <body>

            <div class="container-lg">
                <div class="table-responsive">
                    <div class="table-wrapper">
                        <img class="am" src="https://i.pinimg.com/originals/77/c3/66/77c366436d8bd35fe8b3ce5b8c66992e.png"  width="55px" height="60px"/>
                        <a href="managerbill?action=back" >BACK TO HOME</a>
                        <div class="table-title">
                            <div class="row">
                                <div class="col-sm-8"><h2>User <b>Details</b></h2></div>
                                <!--                                <div class="col-sm-4">
                                                                    <button type="button" class="btn btn-info add-new"><i class="fa fa-plus"></i> Add New</button>
                                                                </div>-->
                            </div>
                        </div>
                        <table class="table table-bordered">
                            <thead>
                                <tr>
                                    <th>Account</th>
                                    <th>Password</th>
                                    <th>Full Name</th>
                                    <th>Date Of Birth</th>
                                    <th>Gender</th>
                                    <th>Address</th>
                                    <th>Phone Number</th>
                                    <th>Answer</th>
                                    <!--<th>Actions</th>-->
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${listu}" var="o">
                                    <tr>
                                        <td>${o.account}</td>
                                        <td>${o.password}</td>
                                        <td>${o.name}</td>
                                        <td>${o.date}</td>

                                        <c:if test="${o.gender == 1}">
                                            <td>MALE</td>
                                        </c:if>
                                        <c:if test="${o.gender == 0}">
                                            <td>FEMALE</td>
                                        </c:if>
                                        <td>${o.address}</td>
                                        <td>${o.phone}</td>
                                        <td>${o.answer}</td>
<!--                                        <td>
                                            <a href="managerUser?action=update&id=${o.account}" class="add" title="Add" data-toggle="tooltip"><i class="material-icons">&#xE03B;</i></a>
                                            <a class="edit" title="Edit" data-toggle="tooltip"><i class="material-icons">&#xE254;</i></a>
                                            <a href="managerUser?action=delete&id=${o.account}" class="delete" title="Delete" data-toggle="tooltip"><i class="material-icons">&#xE872;</i></a>
                                        </td>-->
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>  
        </body>
    </form>   
</html>