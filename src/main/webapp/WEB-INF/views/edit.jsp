<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <title>Forum</title>
</head>
<body>
<div class="container">
    <div class="row">
        <ul class="nav" >
            <li class="nav-item">
                <a class ="nav-link" href="<c:url value='/'/>">На главную страницу</a>
            </li>
        </ul>
    </div>
</div>
<div class="container">
    <form action="<c:url value='/save?id=${post.id}'/>" method='POST'>
        <table>
            <tr>
                <td>Имя:</td>
                <td><input type="text" name="name" value="${post.name}"></td>
            </tr>
            <tr>
                <td>Описание:</td>
                <td><input type="text" name="desc" value="${post.desc}"></td>

            </tr>
            <tr>
                <td>Дата:</td>
                <td><input type="date" name="created" value="${post.created}"></td>
            </tr>
            <tr>
                <td colspan='2'><input name="submit" type="submit" class="btn btn-primary" value="Сохранить" /></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>