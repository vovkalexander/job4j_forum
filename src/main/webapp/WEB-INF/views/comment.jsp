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
    <title>Create</title>
    <style>
        #btn {
            margin-left: 260px;

        }

        input[type=textarea] {
            border: 1px solid black;
            width: 500px;
            height: 120px;
        }

    </style>
</head>
<body>
<div class="container mt-3">
    <div class="row">
        <h4>Добавить комментарии</h4>
    </div>
    <div class="row">
        <form name='login' action="<c:url value='/add'/>" method='POST'>
            <table class="table">
                <tbody>
                <tr>

                    <input type="hidden" name="id" value="${post.id}"/>
                </tr>
                <tr>
                    <div class="form-group">
                        <td>Комментарии:</td>
                        <td width="500px"><input type='textarea' class="form-control" name='comment'></td>
                    </div>
                </tr>
                <tr>
                    <td colspan='2'><input name="submit" id="btn" type="submit" class="btn btn-primary" value="Добавить" /></td>
                </tr>
            </table>
            </tbody>
        </form>
    </div>
</div>
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