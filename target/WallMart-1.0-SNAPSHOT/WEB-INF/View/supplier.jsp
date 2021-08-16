<%@page import="java.sql.ResultSet"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<jsp:include page="header.jsp"/>

<!--Add new supplier-->
<div class="container-fluid">
    
        <a class="btn btn-primary text-white" type="button" href="${pageContext.request.contextPath}/SupplierNew" >Add New Supplier</a>

        <div class="collapse ${Show}" id="addSupplier"  tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLongTitle"></h5>
                        <button class="close" type="button" data-toggle="collapse" data-target="#addSupplier" aria-label="Close"><span aria-hidden="true">×</span></button>
                    </div>
                    <div class="modal-body">
                        <form:form action="${action}" modelAttribute="Supplier" method="POST">

                            <div class="form-group">
                                <form:input class="form-control form-control-user" placeholder="Company Name" path="CompanyName" value="${CompanyName}"/>
                                <form:input class="form-control form-control-user" placeholder="Contact Person" path="ContactPerson" value="${ContactPerson}"/>
                                <form:input class="form-control form-control-user" placeholder="Address" path="Address" value="${Address}"/>
                                <form:input class="form-control form-control-user" placeholder="Phone Number" path="PhoneNumber" value="${PhoneNumber}"/>
                                <form:input class="form-control form-control-user" placeholder="Email" path="Email" value="${Email}"/>
                                <form:input class="form-control form-control-user" placeholder="VAT Number" path="VatNumber" value="${VatNumber}"/>
                            </div>
                            <div class="modal-footer">

                                <form:button class="btn btn-primary" type="submit">Save</form:button>

                        </form:form>
                        <a herf="#" class="btn btn-secondary text-white" data-toggle="collapse" data-target="#addSupplier">Close</a>
                    </div>
                </div>

            </div>
            </div>
        </div>
<!--Add new supplier Ends-->


    <!-- Data Tales -->
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Supplier Table</h6>
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <div class="text-danger "id="formFooter">
                    ${message}
                </div>
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                    <thead>
                        <tr>
                            <th>Company Name:</th>
                            <th>Contact Person</th>
                            <th>Address</th>
                            <th>Phone</th>
                            <th>Email</th>
                            <th>VAT Number</th>
                        </tr>
                    </thead>
                    <tbody id="idset">
                        <%
                            ResultSet rs = (ResultSet) request.getAttribute("SupTable");
                            
                            while (rs.next()) {
                        %>

                        <tr>

                            <td><% out.print(rs.getString(2)); %></td>
                            <td><% out.print(rs.getString(3)); %></td>
                            <td><% out.print(rs.getString(4)); %></td>
                            <td><% out.print(rs.getString(5)); %></td>
                            <td><% out.print(rs.getString(6)); %></td>
                            <td><% out.print(rs.getString(7)); %></td>
                            <td> 
                                <a class="btn btn-warning mr-2" href="${pageContext.request.contextPath}/editSuplier?id=<% out.print(rs.getInt(1)); %>">Edit</a> 


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