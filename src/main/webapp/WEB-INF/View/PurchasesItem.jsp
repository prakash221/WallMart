<%-- 
    Document   : PurchasesItem
    Created on : Jul 26, 2021, 2:26:44 PM
    Author     : dcdip
--%>
<%@page import="com.mycompany.domain.Purchases"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page import="java.sql.ResultSet"%>

<jsp:include page="header.jsp"/>
<div class="container-fluid">
    <div class="row mb-4">
    <div class="col-md-3">
        
        <label>Invoice Number:</label>${InvoiceN}<br>
        <label>Supplier:</label>${Supplier}<br>
        <label>Total Amount: </label>${totalAmount}
        
    </div>    
    <div class="col-md-6" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLongTitle"></h5>
                    <button class="close" type="button" data-toggle="collapse" data-target="#purchasesItem" aria-label="Close"><span aria-hidden="true">×</span></button>
                </div>
                <div class="modal-body">
                    <form:form action="savePurchasesItem" modelAttribute="PurchasesItem" method="POST">
                        
                            <form:select placeholder="products" class="form-control form-control-user" path="ProductID">
                                <%
                                    ResultSet rsP = (ResultSet) request.getAttribute("products");
                                    while (rsP.next()) {
                                %>
                                <option  value="<% out.print(rsP.getString(1)); %>"><% out.print(rsP.getString(2)); %></option>
                                <%
                                    }
                                %>

                            </form:select> 
                        
                        <div class="form-group">
                            <form:input class="form-control form-control-user" placeholder="Unit price" path="pricePerUnit" value="${pricePerUnit}"/>
                        </div>
                        <div class="form-group">
                            <form:input class="form-control form-control-user" placeholder="Quantity" path="quantity" value="${quantity}"/>
                        </div>
                        <div class="modal-footer">

                            <form:button class="btn btn-primary" type="submit">Save</form:button>
                        </form:form>
                        
                    </div>
                </div>

            </div>
        </div>
        <a href="${pageContext.request.contextPath}/dashboard">Close</a>
        </div>

        <!-- Data Tales -->
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
                                ResultSet rsi = (ResultSet) request.getAttribute("PitemTable");
                            
                                while (rsi.next()) {
                            %>

                            <tr>

                                <td><% out.print(rsi.getString(3)); %></td>
                                <td><% out.print(rsi.getString(6)); %></td>
                                <td><% out.print(rsi.getString(5)); %></td>

                                <td> 
                                    
                                    <a class="btn btn-warning mr-2" href="${pageContext.request.contextPath}/deletePurchasesItem?id=<% out.print(rsi.getInt(1)); %>">Delete</a> 



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

    </div>

<jsp:include page="footer.jsp"/>
