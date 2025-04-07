<%@ page import="com.grepp.servlet.app.auth.Principal" %>
<%@ page import="com.grepp.servlet.app.auth.Role" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>JSP - Hello World</title>
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
    <script
            src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <style>
      body {
        display: flex;
        min-height: 100vh;
        flex-direction: column;
      }

      main {
        flex: 1 0 auto;
      }

    </style>

</head>
<body>

<header class="header">
    <nav class="navbar white">
        <div class="nav-wrapper ">
            <a href="/" class="brand-logo grey-text">Grepp</a>
            <% Principal principal = (Principal) session.getAttribute("principal");
                if(principal == null || principal.role().contains(Role.ROLE_ANONYMOUS)){ %>
            <ul id="nav-mobile" class="right hide-on-med-and-down grey-text">
                <li><a href="/member/login" class="grey-text">sign in</a></li>
                <li><a href="/member/signup" class="grey-text">sign up</a></li>
            </ul>
            <% } else { %>
            <ul id="nav-mobile" class="right hide-on-med-and-down grey-text">
                <li><a href="/member/logout" class="grey-text">logout</a></li>
            </ul>
            <% } %>
        </div>
    </nav>
</header>

<main class="container" >

    <% if( request.getParameter("attr") != null && request.getParameter("attr").equals("signup")) { %>
    <div class="card-panel deep-purple lighten-3 white-text">회원가입을 환영합니다!!</div>
    <% } %>

    <% if( request.getParameter("error") != null) { %>
    <div class="card-panel red darken-3 lighten-3 white-text"><%= request.getParameter("error")%></div>
    <% } %>

    <ul class="collection with-header">
        <li class="collection-header"><h4>Welcome Servlet</h4></li>
        <li class="collection-item">
            <div>el-base<a href="/el/base" class="secondary-content"><i class="material-icons">send</i></a>
            </div>
        </li>
        <li class="collection-item">
            <div>el-exam<a href="/el/exam" class="secondary-content"><i class="material-icons">send</i></a>
            </div>
        </li>
        <li class="collection-item">
            <div>jstl-base<a href="/jstl/page" class="secondary-content"><i class="material-icons">send</i></a>
            </div>
        </li>
    </ul>

</main>
<footer class="page-footer">
    <div class="container">
        <div class="row">
            <div class="col l6 s12">
                <h5 class="white-text">Footer Content</h5>
                <p class="grey-text text-lighten-4">You can use rows and columns here to organize your
                    footer content.</p>
            </div>
            <div class="col l4 offset-l2 s12">
                <h5 class="white-text">Links</h5>
                <ul>
                    <li><a class="grey-text text-lighten-3" href="#!">Link 1</a></li>
                    <li><a class="grey-text text-lighten-3" href="#!">Link 2</a></li>
                    <li><a class="grey-text text-lighten-3" href="#!">Link 3</a></li>
                    <li><a class="grey-text text-lighten-3" href="#!">Link 4</a></li>
                </ul>
            </div>
        </div>
    </div>
    <div class="footer-copyright">
        <div class="container">
            © 2014 Copyright Text
            <a class="grey-text text-lighten-4 right" href="#!">More Links</a>
        </div>
    </div>
</footer>

</body>
</html>