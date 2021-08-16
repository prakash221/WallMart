<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page import="java.sql.ResultSet"%>
<jsp:include page="header.jsp"/>
<div class="container-fluid">
    <form:form action="TransferStock" modelAttribute="transferStock" method="POST">
        <form:select Class="form-control form-control-user" Placeholder="Select warehouse" path="fromId">
            <option>Select From</option>
            <%
                ResultSet rsw1 = (ResultSet) request.getAttribute("warehouse1");
                while (rsw1.next()) {
            %>
            <option  value="<% out.print(rsw1.getString(1)); %>"><% out.print(rsw1.getString(2)); %></option>
            <%
                }
            %>
        </form:select>
        <form:select Class="form-control form-control-user" Placeholder="Select warehouse" path="toID">
            <option>Select To</option>
            <%
                ResultSet rsw2 = (ResultSet) request.getAttribute("warehouse");
                while (rsw2.next()) {
            %>
            <option  value="<% out.print(rsw2.getString(1)); %>"><% out.print(rsw2.getString(2)); %></option>
            <%
                }
            %>
        </form:select>
        <form:select Class="form-control form-control-user" Placeholder="Select product" path="productID">
            <%
                ResultSet rsP = (ResultSet) request.getAttribute("Productlist");
                while (rsP.next()) {
            %>
            <option  value="<% out.print(rsP.getString(1)); %>"><% out.print(rsP.getString(2)); %></option>
            <%
                }
            %>
        </form:select>
        <form:input Class="form-control form-control-user" Placeholder="Quantity" path="quantity" ></form:input>
        <form:button class="btn btn-primary" type="submit">Save</form:button>
    </form:form>
</div>
<jsp:include page="footer.jsp"/>