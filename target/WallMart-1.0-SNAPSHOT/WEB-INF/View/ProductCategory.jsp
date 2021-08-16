<%-- 
    Document   : Dashboard
    Created on : Mar 19, 2021, 12:48:20 PM
    Author     : dcdip
--%>

<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Dashboard</title>

  <!-- Custom fonts for this template-->
  <link href="${pageContext.request.contextPath}/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

  <!-- Custom styles for this template-->
  <link href="${pageContext.request.contextPath}/resources/css/sb-admin-2.min.css" rel="stylesheet">

</head>

<body id="page-top">

  <!-- Page Wrapper -->
  <div id="wrapper">

    <!-- Sidebar -->
    <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">
        <a class="sidebar-brand d-flex align-items-center justify-content-center" href="index.html">
        <div class="sidebar-brand-icon rotate-n-15">
          <i class="fas fa-laugh-wink"></i>
        </div>
        <div class="sidebar-brand-text mx-3">Dashboard</div>
      </a>
        <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
          <i class="fas fa-fw fa-cog"></i>
          <span>Products</span>
        </a>
        <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar" style="">
          <div class="bg-white py-2 collapse-inner rounded">
            <a class="collapse-item" href="${pageContext.request.contextPath}/Product">Product table</a>
            <a class="collapse-item" href="${pageContext.request.contextPath}/AddProductCat">Product Category Table</a>
          </div>
        </div>
      </li>
      
      <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapsesales" aria-expanded="false" aria-controls="collapseTwo">
          <i class="fas fa-fw fa-cog"></i>
          <span>Sales</span>
        </a>
        <div id="collapsesales" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar" style="">
          <div class="bg-white py-2 collapse-inner rounded">
            <a class="collapse-item" href="${pageContext.request.contextPath}/customer">Add New Customer</a>
            <a class="collapse-item" href="${pageContext.request.contextPath}/sales">Product sales</a>
          </div>
        </div>
      </li>
      
      <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapsePurchases" aria-expanded="false" aria-controls="collapseTwo">
          <i class="fas fa-fw fa-cog"></i>
          <span>Purchases</span>
        </a>
        <div id="collapsePurchases" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar" style="">
          <div class="bg-white py-2 collapse-inner rounded">
            
            <a class="collapse-item" href="${pageContext.request.contextPath}/Purchases">New Purchases</a>
          </div>
        </div>
      </li>

    </ul>
    <!-- End of Sidebar -->

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

      <!-- Main Content -->
      <div id="content">

        <!-- Topbar -->
        <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">
            <ul class="navbar-nav ml-auto">
            <li class="nav-item dropdown no-arrow">
              <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <span class="mr-2 d-none d-lg-inline text-gray-600 small">${Name}</span>
                <img class="img-profile rounded-circle" src="https://source.unsplash.com/QAB-WJcbgJk/60x60">
              </a>
              <!-- Dropdown - User Information -->
              <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="userDropdown">
                <a class="dropdown-item" href="#">
                  <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                  Profile
                </a>
                <a class="dropdown-item" href="#">
                  <i class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i>
                  Settings
                </a>
                <a class="dropdown-item" href="#">
                  <i class="fas fa-list fa-sm fa-fw mr-2 text-gray-400"></i>
                  Activity Log
                </a>
                <div class="dropdown-divider"></div>
                <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">
                  <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                  Logout
                </a>
              </div>
            </li>
</ul>
        </nav>
        <!-- End of Topbar -->

        <!-- Begin Page Content -->
        <div class="container-fluid">
            <a class="btn btn-primary text-white" type="button" href="${pageContext.request.contextPath}/ProductCat" >Add New Product Category</a>
                        
            <div class="collapse ${Show}" id="addNewProductCat"  tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle" aria-hidden="true">
                            <div class="modal-dialog" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="exampleModalLongTitle"></h5>
                                        <button class="close" type="button" data-toggle="collapse" data-target="#addNewProductCat" aria-label="Close"><span aria-hidden="true">×</span></button>
                                    </div>
                                    <div class="modal-body">
                                        <form:form action="${action}" modelAttribute="ProductCatSave" method="POST">
                                            
                                            <div class="form-group"><form:input class="form-control form-control-user" placeholder="Category Name" path="catName" value="${CatName}"/></div>
                                            <div class="modal-footer">
                                                
                                                <form:button class="btn btn-primary" type="submit">Save</form:button>
                                            
                                        </form:form>
                                            <a herf="#" class="btn btn-secondary text-white" data-toggle="collapse" data-target="#addNewProductCat">Close</a>
                                            </div>
                                        </div>

                                </div>
                            </div>
                        </div>
                                            
            <!-- Data Tales -->
                        <div class="card shadow mb-4">
                            <div class="card-header py-3">
                                <h6 class="m-0 font-weight-bold text-primary">Customer Table</h6>
                            </div>
                            <div class="card-body">
                                <div class="table-responsive">
                                    <div class="text-danger "id="formFooter">
                                        ${message}
                                    </div>
                                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                        <thead>
                                            <tr>
                                                <th>SNo:</th>
                                                <th>Category</th>
                                                
                                                <th></th>
                                            </tr>
                                        </thead>
                                        <tbody id="idset">
                                        <%
                                            ResultSet rs = (ResultSet) request.getAttribute("PCTable");
                                            int i =1;
                                            while (rs.next()) {
                                        %>
                                        
                                            <tr>
                                                <td><% out.print(i); %></td>
                                                <td><% out.print(rs.getString(2)); %></td>
                                                <td> 
                                                    <a class="btn btn-warning mr-2" href="${pageContext.request.contextPath}/editProductCat?id=<% out.print(rs.getInt(1)); %>">Edit</a> 
                                                
                                        
                                                </td>

                                            </tr>

                                        
                                        
                                        <%
                                            i++;
                                            }
                                        %>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>

        </div>
        <!-- /.container-fluid -->

      </div>
      <!-- End of Main Content -->

      <!-- Footer -->
      <footer class="sticky-footer bg-white">
        <div class="container my-auto">
          <div class="copyright text-center my-auto">
            <span>Copyright &copy; Your Website 2020</span>
          </div>
        </div>
      </footer>
      <!-- End of Footer -->

    </div>
    <!-- End of Content Wrapper -->

  </div>
  <!-- End of Page Wrapper -->

  <!-- Scroll to Top Button-->
  <a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
  </a>

  <!-- Logout Modal-->
  <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
          <button class="close" type="button" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">×</span>
          </button>
        </div>
        <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
        <div class="modal-footer">
          <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
          <a class="btn btn-primary" href="${pageContext.request.contextPath}/logout">Logout</a>
        </div>
      </div>
    </div>
  </div>

  <!-- Bootstrap core JavaScript-->
  <script src="${pageContext.request.contextPath}/resources/vendor/jquery/jquery.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Core plugin JavaScript-->
  <script src="${pageContext.request.contextPath}/resources/vendor/jquery-easing/jquery.easing.min.js"></script>

  <!-- Custom scripts for all pages-->
  <script src="${pageContext.request.contextPath}/resources/js/sb-admin-2.min.js"></script>

  <!-- Page level plugins -->
  <script src="${pageContext.request.contextPath}/resources/vendor/chart.js/Chart.min.js"></script>

  <!-- Page level custom scripts -->
  <script src="${pageContext.request.contextPath}/resources/js/demo/chart-area-demo.js"></script>
  <script src="${pageContext.request.contextPath}/resources/js/demo/chart-pie-demo.js"></script>

</body>

</html>
