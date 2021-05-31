<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : ManagerCategory
    Created on : 19-Mar-2021, 17:01:02
    Author     : hp
--%>

<%-- 
    Document   : ManagerOrderDetail
    Created on : 13-Mar-2021, 18:18:58
    Author     : hp
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Manager Category | Apple Store</title>
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
                width: 780px;
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
    </head>
    <body>
        <!--<form action="managercategory" method="post">-->
        <div class="container-lg">
            <div class="table-responsive">
                <div class="table-wrapper">
                    <div class="table-title">
                        <div class="row">
                            <div class="col-sm-8"><h2>Category <b>Details</b></h2></div>
                            <a href="#addEmployeeModal"  class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Add New Category</span></a>
                            <!--                                <div class="col-sm-4">
                                                                <button type="button" class="btn btn-info add-new"><i class="fa fa-plus"></i> Add New</button>
                                                            </div>-->
                        </div>
                    </div>
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>Category ID</th>
                                <th>Category Name</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${list}" var="o">
                                <tr>
                                    <td>${o.cid}</td>
                                    <td>${o.cname}</td>
                                    <td>
                                        <!--<button type="submit"><a href="updateCategoty?id=${o.cid}" class="edit" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a></button>-->
                                        <!--<input type="submit" value="Update" />-->
                                        <a href="managercategory?action=preupdate&cid=${o.cid}&cname=${o.cname}" >Update</a>
                                        <!--<a href="updateCategoty?id=${o.cid}" class="edit" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>-->
                                        <!--<a href="#update"  class="edit" title="Edit" data-toggle="modal"><i class="material-icons">&#xE254;</i></a>-->
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>

                    
                </div>
            </div>
        </div>
        <c:if test="${cid != null}">
                        <!--<form action="updateCategoty" method="post" >-->

                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <form action="managercategory" method="post" >
                                        <div class="modal-header">						
                                            <h4 class="modal-title">Update Category</h4>
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                        </div>
                                        <div class="modal-body">					
                                            <div class="form-group">
                                                <label>Category ID</label>

                                                <input name="id" type="number" class="form-control" value="${cid}" readonly="Not edit">
                                            </div>

                                            <div class="form-group">
                                                <label>Category Name</label>
                                                <input name="name" type="text" class="form-control" value="${cname}" required>
                                            </div>


                                        </div>
                                        <div class="modal-footer">
                                            <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                                            <input type="submit" class="btn btn-success" value="Update">
                                            <input type="hidden" name="action" class="btn btn-success" value="update">
                                        </div>
                                    </form>
                                </div>
                            </div>
                        <!--</form>-->
                    </c:if>
        <!--</form>-->

        <div id="addEmployeeModal" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <!--enctype="multipart/form-data"-->
                    <form action="managercategory" method="post" >
                        <div class="modal-header">						
                            <h4 class="modal-title">Add Category</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        </div>
                        <div class="modal-body">					
                            <div class="form-group">
                                <label>Category ID</label>

                                <input name="id" type="number" class="form-control" value="${cidlast+1}" min="${cidlast}" required>
                            </div>

                            <div class="form-group">
                                <label>Category Name</label>
                                <input name="name" type="text" class="form-control" required>
                            </div>


                        </div>
                        <div class="modal-footer">
                            <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                            <input type="submit" class="btn btn-success" value="Add">
                            <input type="hidden" name="action" class="btn btn-success" value="add">
                        </div>
                    </form>
                </div>
            </div>
        </div>



    </body>
</html>