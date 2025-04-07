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
      <ul id="nav-mobile" class="right hide-on-med-and-down grey-text">
        <li><a href="/member/login" class="grey-text">sign in</a></li>
        <li><a href="badges.html" class="grey-text">sign up</a></li>
      </ul>
    </div>
  </nav>
</header>

<main class="container">
  <h4>D_cookie_result</h4>
  <div class="row">
    <div class="col s4">
      <div class="card">
        <div class="card-image">
          <img src="<%= request.getAttribute("filePath")%>">
          <span class="card-title"><%= request.getAttribute("search")%></span>
        </div>
        <div class="card-content">
          <p><%= request.getAttribute("desc")%></p>
        </div>
        <div class="card-action">
          <a href="/cookie/lang?search=<%= request.getAttribute("lastSearch")%>">
            <%= request.getAttribute("lastSearch")%>
          </a>
        </div>
      </div>
    </div>
  </div>
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
<script>
  document.addEventListener('DOMContentLoaded', function() {
    const elems = document.querySelectorAll('select');
    const instances = M.FormSelect.init(elems);
  });
</script>

</body>
</html>