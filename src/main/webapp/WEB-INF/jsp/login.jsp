<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <link rel="icon" href="data:,">
    <head>
        <meta charset="UTF-8">
        <title>Вход</title>
        <style>
             <%@include file="../css/login.css"%>
        </style>
    </head>
    <body>
        <div class="container-form" align="center">
            <form method="POST" action="chat?command=login">
                <h1>Spokanchat</h1>
                <table>
                    <tr>
                        <td><label for="loginInput">Логин</label></td>
                        <td><input id="loginInput" type="text" name="loginInput" value="${loginInput}"/></td>
                    </tr>
                    <tr>
                        <td><label for="passwordInput">Пароль</label></td>
                        <td><input id="passwordInput" type="password" name="passwordInput" value=""/></td>
                    </tr>
                    <tr>
                        <td><h4>${errorLoginMessage}</h4></td>
                        <td><button type="submit">Войти</button></td>
                    </tr>
                </table>
            </form>
        </div>
    </body>
</html>