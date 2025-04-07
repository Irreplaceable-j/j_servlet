<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang='ko'>
<head>
    <title>Title</title>
</head>
<body>

<%--
    el 표기법 : 자바 bean 규약을 따르는 객체의 속성에 편하게 접근하고 사용하기 위해 제공되는 기술
    자바 bean 규약 : 기본생성자, 모든 속성 private , 모든 속성 getter/setter

    ${} : 객체 프로퍼티에 접근해 값을 읽어 올 때 사용
    #{} : 객체 프로퍼티에 값을 넣을 때 사용 (사용 안함)
--%>

<main class="container">
    <h4>EL literal 표현식</h4>
    <span>문자열 : ${"문자열 테스트"}</span>
    <span>정수 : ${10}</span>
    <span>실수 : ${10.101}</span>
    <span>boolean : ${true}</span>
    <%--  null 일 경우 공백이 출력  --%>
    <span>null : ${null}</span>

    <h4>EL 연산자</h4>
    <pre>
        산술연산자, 비교연산자, 논리연산자, 삼항연산자, empty 연산
        산술연산자 : +, -, *, /, %
        비교연산자 : <, &lt, <=, >=, ==, !=
        논리연산자 : &&(and), ||(or), !(not)
        empty : true
            값이 null, 문자열, 배열, collection 의 length 가 0
        empty : false
            이 외의 모든 경우
    </pre>
    <h5>비교연산</h5>
    <div> 1 == 2 : ${1 == 2}, ${1 eq 2}</div>
    <div> 1 != 2 : ${1 != 2}, ${1 ne 2}</div>
    <div> 1 > 2 : ${1 > 2}, ${1 gt 2}</div>
    <div> 1 < 2 : ${1 < 2}, ${1 lt 2}</div>
    <div> 1 >= 2 : ${1 >= 2}, ${1 ge 2}</div>
    <div> 1 <= 2 : ${1 <= 2}, ${1 le 2}</div>

    <h5>논리연산</h5>
    <div>true && true : ${true && true}, ${true and true}</div>
    <div>true || true : ${true || true}, ${true or true}</div>
    <div>!true : ${!true}, ${not true}</div>

    <h5>삼항연산자</h5>
    <div>
        1 > 2 ? '크다' : '작다' >>> 결과 : ${1 > 2 ? "크다":"작다"}
    </div>

    <h5>empty</h5>
    <div>
        empty null : ${empty null}
    </div>
</main>



</body>
</html>