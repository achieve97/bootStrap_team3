<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

  
 <c:choose>
<c:when test="${sessionScope.id ne null}">
<!-- ======= Sidebar ======= -->
  <aside id="sidebar" class="sidebar">

    <ul class="sidebar-nav" id="sidebar-nav">

      <li class="nav-item">
        <a class="nav-link " href="index.jsp">
          <i class="bi bi-grid"></i>
          <span>Main</span>
        </a>
      </li><!-- End Dashboard Nav -->
      

      <li class="nav-heading">Pages</li>

  


      <li class="nav-item">
        <a class="nav-link collapsed" href="pages-register.jsp">
          <i class="bi bi-card-list"></i>
          <span>Register</span>
        </a>
      </li><!-- End Register Page Nav -->

      <li class="nav-item">
        <a class="nav-link collapsed" href="pages-login.jsp">
          <i class="bi bi-box-arrow-in-right"></i>
          <span>Login</span>
        </a>
      </li><!-- End Login Page Nav -->

    

    </ul>

  </aside><!-- End Sidebar-->
       
              
    </c:when>
    <c:otherwise>
       
        <!-- ======= Sidebar ======= -->
  <aside id="sidebar" class="sidebar">

    <ul class="sidebar-nav" id="sidebar-nav">

      <li class="nav-item">
        <a class="nav-link " href="index.jsp">
          <i class="bi bi-grid"></i>
          <span>Dashboard</span>
        </a>
      </li><!-- End Dashboard Nav -->
      

      <li class="nav-heading">Pages</li>

  


      <li class="nav-item">
        <a class="nav-link collapsed" href="pages-register.jsp">
          <i class="bi bi-card-list"></i>
          <span>Register</span>
        </a>
      </li><!-- End Register Page Nav -->

      <li class="nav-item">
        <a class="nav-link collapsed" href="pages-login.jsp">
          <i class="bi bi-box-arrow-in-right"></i>
          <span>Login</span>
        </a>
      </li><!-- End Login Page Nav -->

    

    </ul>

  </aside><!-- End Sidebar-->
    </c:otherwise>
</c:choose>