<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <title>Тема </title>
    <style>
        #btn{
            margin-left: 260px;
            margin-top: 2%;
        }

        a {
            margin-left: 5px;
            font-size: 17px;
        }

        h4 {
            margin-left: 200px;
        }

        input[type=text]  {
            border: 1px solid black;
        }

        input[type=date]  {
            border: 1px solid black;
        }
    </style>
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
    <h4>Создание Темы</h4>
    <form  action="<c:url value='/save'/>" method='POST'>
        <table>
            <tr>
                <div class="form-group">
                    <td>Имя:</td>
                    <td><input type="text" class="form-control" name="name"></td>
                </div>
            </tr>
            <tr>
                <div class="form-group">
                    <td>Описание:</td>
                    <td width="500px" ><input type="text" class="form-control" name="desc"></td>
                </div>
            </tr>
            <tr>
                <div class="form-group">
                    <td>Дата:</td>
                    <td><input type="date" class="form-control" name="created"></td>
                </div>
            </tr>
            <tr>
                <td colspan='2'><input name="submit" id="btn" type="submit" class="btn btn-primary" value="Сохранить"/></td>
            </tr>
        </table>
    </form>
</div>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
        integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
        integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>
</html>