<%-- 
    Document   : SalseItem
    Created on : Jul 30, 2021, 10:06:21 AM
    Author     : dcdip
--%>

<%@page import="com.mycompany.domain.Purchases"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page import="java.sql.ResultSet"%>

<jsp:include page="header.jsp"/>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-3">
            <label>Name: </label>${Customer}<br>
            <label>Invoice Number: </label>${InvoiceN}<br>
            <label>Amount: </label> ${Amount}<br>
            <label>VAT: </label> ${Tax}<br>
            <label>Total Amount:</label> ${TotalAmount}<br>

        </div>
        <div class="col-md-9">
            <div>
                <form:form action="SaveSalseItem" modelAttribute="SalseItem" method="POST">

                    <form:select placeholder="products" class="form-control form-control-user" path="ProductID">
                        <%
                            ResultSet rsP = (ResultSet) request.getAttribute("ProductList");
                            while (rsP.next()) {
                        %>
                        <option  value="<% out.print(rsP.getString(1)); %>"><% out.print(rsP.getString(2)); %></option>
                        <%
                            }
                        %>

                    </form:select> 

                    <div class="form-group">
                        <form:input class="form-control form-control-user" placeholder="Unit price" path="UnitPrice" value="${pricePerUnit}"/>
                    </div>
                    <div class="form-group">
                        <form:input class="form-control form-control-user" placeholder="Quantity" path="Quantity" value="${quantity}"/>
                    </div>
                    <div class="modal-footer">

                        <form:button class="btn btn-primary" type="submit">Save</form:button>
                    </form:form>
                </div>

            </div>
        </div>

    </div>

    <div class="card shadow mb-4">

        <div class="card-body">
            <div class="table-responsive">
                <div class="text-danger "id="formFooter">
                    ${message}
                </div>
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                    <thead>
                        <tr>
                            <th>Product Name</th>
                            <th>Quantity</th>
                            <th>Unit price</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            ResultSet rsi = (ResultSet) request.getAttribute("SalseItemTable");

                            while (rsi.next()) {
                        %>

                        <tr>

                            <td><% out.print(rsi.getString("ProductName")); %></td>
                            <td><% out.print(rsi.getString("Quantity")); %></td>
                            <td><% out.print(rsi.getString("UnitPrice")); %></td>

                            <td> 

                                <a class="btn btn-warning mr-2" href="${pageContext.request.contextPath}/deleteSalseItem?id=<% out.print(rsi.getInt("SalesID")); %>">Delete</a> 



                            </td>

                        </tr>



                        <%

                            }
                        %>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

