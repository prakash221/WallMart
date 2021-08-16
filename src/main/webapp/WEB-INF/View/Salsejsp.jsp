<%-- 
    Document   : Sales
    Created on : Jul 27, 2021, 9:40:20 PM
    Author     : dcdip
--%>
<%@page import="java.sql.ResultSet"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<jsp:include page="header.jsp"/>
${message}
<div class="container-fluid">
    <form:form action="SaveSales" modelAttribute="Sales" method="POST">
        <div class="form-group">
            <label>Purchases Date:</label>
            <form:input type="date" path="SalesDate" id="from-datepicker"/>
        </div>
        <div class="form-group">
        <form:select placeholder="Customer" class="form-control form-control-user" path="CustomerID">
            <option>Select customer</option>
            <% 
                ResultSet rsc = (ResultSet) request.getAttribute("customerList");
                while (rsc.next()) {
            %>
            <option  value="<% out.print(rsc.getString(1)); %>"> <% out.print(rsc.getString(2)); %></option>
            <%
            }
            %>
        </form:select>
        </div>
        <div class="form-group">
            <form:input class="form-control form-control-user" placeholder="Amount" path="Amount"/>
        </div>
        <div class="form-group">
            <form:input class="form-control form-control-user" placeholder="VAT" path="TAXAmount" />
        </div>
        <div class="form-group">
            <form:input class="form-control form-control-user" placeholder="InvoiceNumber" path="InvoiceNumber" />
        </div>
        <form:button class="btn btn-primary" type="submit">Save</form:button>
    </form:form> 
    <a class="btn btn-danger" href="${pageContext.request.contextPath}/dashboard">Close</a>


</div>
