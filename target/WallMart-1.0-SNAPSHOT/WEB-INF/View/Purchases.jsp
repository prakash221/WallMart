<%@page import="java.sql.ResultSet"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<jsp:include page="header.jsp"/>
<div class="container-fluid">
    <div  id="savePurchases"  tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLongTitle">Input items</h5>
                    <button class="close" type="button" data-toggle="collapse" data-target="#purchases" aria-label="Close"><span aria-hidden="true">×</span></button>
                </div>
                <div class="modal-body">
                    <form:form action="savePurchases" modelAttribute="Purchases" method="POST">

                        <div class="form-group">
                            <label>Purchases Date:</label>
                            <form:input type="date" path="PurchasesDate" id="from-datepicker"/>

                        </div>
                        <div class="form-group">
                            <div class="form-group">
                                <form:select placeholder="Supplier" class="form-control form-control-user" path="supplierID">
                                    <option>Select a supplier</option>
                                    <%
                                        ResultSet rss = (ResultSet) request.getAttribute("supplier");
                                        while (rss.next()) {
                                    %>
                                    <option  value="<% out.print(rss.getString(1)); %>"><% out.print(rss.getString(2)); %></option>
                                    <%
                                        }
                                    %>

                                </form:select> 
                            </div>
                        </div>
                        <div class="form-group">
                            <form:input class="form-control form-control-user" placeholder="Total Amount" path="totalAmount" value="${totalAmount}"/>
                        </div>
                        <div class="form-group">
                            <form:input class="form-control form-control-user" placeholder="Invoice Number" path="invoiceNumber" value="${invoiceNumber}"/>
                        </div>
                        <div class="modal-footer">

                            <form:button class="btn btn-primary" type="submit">Input purchases Items.</form:button>

                        </form:form>
                        <a herf="#" class="btn btn-secondary text-white" data-toggle="collapse" data-target="#purchases">Close</a>
                    </div>
                </div>

            </div>
        </div>
    </div>

    <!--Purchases item form-->
</div>





<jsp:include page="footer.jsp"/>