<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang='ko'>
<head>
    <title>Title</title>
</head>
<body>
<main class="container" >
    <h4>성적입력</h4>
    <form class="col s12" action="/el/view" method="get">
        <div class="row">
            <div class="input-field col s7 ">
                <i class="material-icons prefix">account_circle</i>
                <input id="name" name="name" type="text" placeholder="name"
                       class="validate">
            </div>
            <div class="input-field col s7 ">
                <i class="material-icons prefix">mode_edit</i>
                <input id="kor" name="kor" type="number" placeholder="kor"
                       class="validate">
            </div>
            <div class="input-field col s7 ">
                <i class="material-icons prefix">mode_edit</i>
                <input id="eng" name="eng" type="number" placeholder="eng"
                       class="validate">
            </div>
            <div class="input-field col s7 ">
                <i class="material-icons prefix">mode_edit</i>
                <input id="math" name="math" type="number" placeholder="math"
                       class="validate">
            </div>
            <div class="input-field col s7 ">
                <i class="material-icons prefix">mode_edit</i>
                <input id="develop" name="develop" type="number" placeholder="develop"
                       class="validate">
            </div>
        </div>
        <button class="btn waves-effect waves-light offset-s1" type="submit" name="action">
            Submit
            <i class="material-icons right">send</i>
        </button>
    </form>
</main>

</body>
</html>