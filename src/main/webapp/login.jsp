<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ include file="/include/css.jsp" %>
<title>Insert title here</title>
</head>
<body>
    <div class="container position-sticky z-index-sticky top-0">
    <div class="row">
      <div class="col-12">
        <!-- Navbar -->
        <nav class="navbar navbar-expand-lg blur border-radius-xl top-0 z-index-3 shadow position-absolute my-3 py-2 start-0 end-0 mx-4">
          <div class="container-fluid ps-2 pe-0">
            <a class="navbar-brand font-weight-bolder ms-lg-0 ms-3 " href="#">
              Gestion des filieres
            </a>
            <button class="navbar-toggler shadow-none ms-2" type="button" data-bs-toggle="collapse" data-bs-target="#navigation" aria-controls="navigation" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon mt-2">
                <span class="navbar-toggler-bar bar1"></span>
                <span class="navbar-toggler-bar bar2"></span>
                <span class="navbar-toggler-bar bar3"></span>
              </span>
            </button>
            <div class="collapse navbar-collapse" id="navigation">
              <ul class="navbar-nav mx-auto">
                <li class="nav-item">
                  <a class="nav-link d-flex align-items-center me-2 active" aria-current="page" href="#">
                    <i  class='fas fa-school'></i>
                    Acceuil
                  </a>
                </li>
                <li class="nav-item">
                  <a class="nav-link me-2" href="loginensa.jsp">
                    <i class="fa fa-user opacity-6 text-dark me-1"></i>
                    ENSA KHOURIBGA
                  </a>
                </li>
                <li class="nav-item">
                  <a class="nav-link me-2" href="loginfst.jsp">
                    <i class="fa fa-user opacity-6 text-dark me-1"></i>
                    FST KHOUNIFRA
                  </a>
                </li>
                <li class="nav-item">
                  <a class="nav-link me-2" href="loginest.jsp">
                    <i class="fa fa-user opacity-6 text-dark me-1"></i>
                      EST BENI MALLAL
                  </a>
                </li>
              </ul>
            </div>
          </div>
        </nav>
        <!-- End Navbar -->
      </div>
    </div>
  </div>
 <main class="main-content  mt-0">
  <div class="page-header align-items-start min-vh-100" style="background-image: url('template/img/usms.jpeg');">
      <span class="mask bg-gradient-dark opacity-6"></span>
    </div>
  </main>
</body>
<%@ include file="/include/js.jsp" %>
</html>