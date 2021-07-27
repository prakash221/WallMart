<%-- 
    Document   : Dashboard
    Created on : Mar 19, 2021, 12:48:20 PM
    Author     : dcdip
--%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page import="java.sql.ResultSet"%>
<jsp:include page="header.jsp"/>
<div class="container-fluid">

    <a class="btn btn-primary text-white mb-2" type="button" href="${pageContext.request.contextPath}/addNewProduct" >Add New Product</a>

    <div class="collapse ${Show}" id="addNewProduct" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLongTitle"></h5>
                    <button class="close" type="button" data-toggle="collapse" data-target="#addNewProduct" aria-label="Close"><span aria-hidden="true">×</span></button>
                </div>
                <div class="modal-body">
                    <form:form action="${action}" modelAttribute="Product" method="POST">

                        <div class="form-group"><form:input class="form-control form-control-user" placeholder="Product Name" path="ProductName" value="${ProductName}"/></div>
                        <div class="form-group"><form:select class="form-control form-control-user" path="CatID" value="" >
                                <%
                                    ResultSet rsp = (ResultSet) request.getAttribute("CatTable");
                                    while (rsp.next()) {
                                %>
                                <option  value="<% out.print(rsp.getString(1)); %>"><% out.print(rsp.getString(2)); %></option>
                                <%
                                    }
                                %>

                            </form:select> </div>
                        <div class="form-group"><form:input class="form-control form-control-user" placeholder="Price perUnit" path="PricePerUnit" value="${Price}" /></div>
                        <div class="form-group"><form:input class="form-control form-control-user" placeholder="Available Quantity" path="stock" value="${stock}"/></div>
                        <div class="modal-footer">

                            <form:button class="btn btn-primary" type="submit">Save</form:button>

                        </form:form>
                        <a herf="#" class="btn btn-secondary text-white" type="button" data-toggle="collapse" data-target="#addNewProduct" aria-label="Close">Close</a>
                    </div>
                </div>

            </div>
        </div>
    </div>

    <!--   Add new product end-->

    <div class="container-fluid">
        <!--    Product Table-->

        <div class="card shadow mb-4">
            <div class="card-header py-3">
                <h6 class="m-0 font-weight-bold text-primary">Product Table</h6>
            </div>
            <div class="card-body">
                <div class="table-responsive">
                    <div class="text-danger "id="formFooter">
                        ${message}
                    </div>
                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                        <thead>
                            <tr>
                                <th>Product Name</th>
                                <th>Product Category </th>
                                <th>Price per unit</th>
                                <th>Available Quantity</th>

                                <th></th>
                            </tr>
                        </thead>
                        <tbody id="idset">
                            <%
                                ResultSet rs = (ResultSet) request.getAttribute("ProductTable");
                                while (rs.next()) {
                            %>

                            <tr>
                                <td><% out.print(rs.getString(2)); %></td>
                                <td><% out.print(rs.getString(6)); %></td>
                                <td><% out.print(rs.getString(3)); %></td>
                                <td><% out.print(rs.getInt(4)); %></td>

                                <td> 
                                    <a class="btn btn-warning mr-2" href="${pageContext.request.contextPath}/editProduct?id=<% out.print(rs.getInt(1)); %>">Edit</a> 


                                </td>

                            </tr>



                            <%
                                }
                            %>
                        </tbody>
                    </table>

                </div>
                <!--                    Product Table end-->

            </div>
            <!--   Add new product-->

            <jsp:include page="footer.jsp"/>