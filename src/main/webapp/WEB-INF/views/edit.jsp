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
    <style>
        a {
            margin-left: 5px;
            font-size: 17px;
        }

        input[type=text]  {
            border: 1px solid black;
        }

        input[type=date]  {
            border: 1px solid black;
        }

        #btn {
            margin-left: 260px;
            margin-top: 2%;
        }
    </style>

</head>
<body>
<div class="container">
    <div class="row">
        <ul class="nav">
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
                <div class="form-group">
                    <td>Имя:</td>
                    <td><input type="text" class="form-control" name="name" value="${post.name}"></td>
                </div>
            </tr>
            <tr>
                <div class="form-group">
                <td>Описание:</td>
                <td width="500px"><input type="text" class="form-control" name="desc" value="${post.desc}"></td>
                </div>
            </tr>
            <tr>
                <div class="form-group">
                <td>Дата:</td>
                <td ><input type="date" name="created" class="form-control"  value="${post.created}"></td>
                </div>
            </tr>
            <tr>
                <td colspan='2'><input name="submit"  type="submit" id="btn" class="btn btn-primary" value="Сохранить" /></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>