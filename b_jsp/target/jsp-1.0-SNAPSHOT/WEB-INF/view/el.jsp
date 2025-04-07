<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang='ko'>
<head>
    <title>Title</title>
</head>
<body>
<main class="container">
    <h4>pageContext</h4>
    <div>pageContext : ${pageContext}</div>

    <h4>EL</h4>
    <%-- request.getParameter("name") --%>
    <div>이름 : ${param.name}</div>
    <%-- request.getAttribute("sum")   --%>
    <div>합계 : ${requestScope.sum}</div>
    <%-- 속성만 작성하면 가까운 scope의 속성을 반환
        pageContext > request > session > context --%>
    <div>평균 : ${avg}</div>

    <h4>1. dto</h4>
    <div>이름 : ${student.name}</div>
    <div>국어 : ${student.kor}</div>
    <div>수학 : ${student.math}</div>
    <div>영어 : ${student.eng}</div>
    <div>개발 : ${student.develop}</div>
    <div>합계 : ${student.sum}</div>
    <div>평균 : ${student.avg}</div>

    <h4>2. map</h4>
    <div>이름 : ${studentMap.name}</div>
    <div>국어 : ${studentMap.kor}</div>
    <div>수학 : ${studentMap.math}</div>
    <div>영어 : ${studentMap.eng}</div>
    <div>개발 : ${studentMap.develop}</div>
    <div>합계 : ${studentMap.sum}</div>
    <div>평균 : ${studentMap.avg}</div>

    <h4>3. array/list</h4>
    <div>이름 : ${studentList[0].name}</div>
    <div>국어 : ${studentList[0].kor}</div>
    <div>수학 : ${studentList[0].math}</div>
    <div>영어 : ${studentList[0].eng}</div>
    <div>개발 : ${studentList[0].develop}</div>
    <div>합계 : ${studentList[0].sum}</div>
    <div>평균 : ${studentList[0].avg}</div>

    <h4>4. cookie</h4>
    <div>JSESSIONID : ${cookie.JSESSIONID.value}</div>

    <h4>5. session</h4>
    <div>${sessionScope.principal} 님 환영합니다.</div>
    <div>${principal} 님 환영합니다.</div>

</main>

</body>
</html>