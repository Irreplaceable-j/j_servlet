<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang='ko'>
<head>
    <title>Title</title>
</head>
<body>
<h4>JSTL</h4>
<pre>
        JSP 에서 사용하는 스크립틀릿의 복잡함을 해결하기 위해 등장
        변수 선언 및 초기화, 출력문, 조건문, 반복문, formatting
    </pre>

<c:set var="kor" value="100" />
<c:set var="math" value="200" />

<h5>1. out</h5>
<div>kor : <c:out value="${kor}"/></div>
<div>math : <c:out value="${math}"/></div>
<%-- xss attack : cross site scripting attack   --%>
<div>xss : <c:out value="${xss}"/></div>
<%-- <div>el xss : ${xss}</div> --%>

<div class="divider"></div>




</body>
</html>