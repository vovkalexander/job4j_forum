<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset= "UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <style>
        a {
            margin-left: 150px;
            font-size: 18px;
        }

        input[type=text]  {
            border: 1px solid black;
        }

        input[type=password]  {
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
        <ul class="nav" >
            <li class="nav-item">
                <a class ="nav-link" href="<c:url value='/login'/>">Войти в аккаунт</a>
            </li>
        </ul>
    </div>
    <c:if test="${not empty errorMessage}">
    <div style="color:red; font-weight: bold; margin: 30px 0px;">
            ${errorMessage}
    </div>
    </c:if>
    <div class="container">
        <form name='login' action="<c:url value='/reg'/>" method='POST'>
            <table>
                <thead>
                <tr>
                    <th scope="row" style="">Регистрация</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <div class="form-group">
                        <td>Пользователь:</td>
                        <td><input type='text' class="form-control" name='username'></td>
                    </div>
                </tr>
                <tr>
                    <div class="form-group">
                    <td>Пароль:</td>
                    <td width="400px"><input type='password' class="form-control" name='password'/></td>
                    </div>
                </tr>
                <tr>
                    <td colspan='2'><input name="submit" class="btn btn-primary" id = "btn" type="submit" value="submit" /></td>
                </tr>
                </tbody>
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