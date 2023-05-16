<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ include file="/include/css.jsp" %>
<title>Insert title here</title>
</head>
<body class="g-sidenav-show  bg-gray-200">
    <div class="container position-sticky z-index-sticky top-0">
    <div class="row">
      <div class="col-12">
        <!-- Navbar -->
        <nav class="navbar navbar-expand-lg blur border-radius-xl top-0 z-index-3 shadow position-absolute my-3 py-2 start-0 end-0 mx-4">
          <div class="container-fluid ps-2 pe-0">
            <a class="navbar-brand font-weight-bolder ms-lg-0 ms-3 " href="loginensa.jsp">
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
                  <a class="nav-link d-flex align-items-center me-2 active" aria-current="page" href="login.jsp">
                    <i class='fas fa-school'></i>
                    Acceuil
                  </a>
                <li class="nav-item">
                  <a class="nav-link me-2" href="#">
                    <i class="fa fa-user opacity-6 text-dark me-1"></i>
                      ENSA KHOURIBGA
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
  <form action="Connexionensa" method="post">
 <main class="main-content  mt-0">
   <div class="page-header align-items-start min-vh-100" >
      <div class="container my-auto">
        <div class="row">
          <div class="col-lg-4 col-md-8 col-12 mx-auto">
            <div class="card z-index-0 fadeIn3 fadeInBottom">
              <div class="card-header p-0 position-relative mt-n4 mx-3 z-index-2">
                <div class="bg-gradient-primary shadow-primary border-radius-lg py-3 pe-1">
                  <h4 class="text-white font-weight-bolder text-center mt-2 mb-0">Se connecter</h4>
                </div>
              </div>
              <div class="card-body">
                <form role="form" class="text-start">
                  <div class="input-group input-group-outline my-3">
                    <input type="text" class="form-control" name="nom" placeholder="Nom">
                  </div>
                  <div class="input-group input-group-outline mb-3">
                    <input type="password" class="form-control" name="password" placeholder="Mot de passe">
                  </div>
                  <div class="text-center">
                    <input class="btn bg-gradient-primary w-100 my-4 mb-2"type="submit" value="Se connecter">
                  </div>
                  <p class="mt-4 text-sm text-center">
                    Vous n'avez pas de compte ?
                    <a href="#" class="text-primary text-gradient font-weight-bold">Deconnecter</a>
                  </p>
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </main>
  </form>
</body>
<%@ include file="/include/js.jsp" %>
</html>