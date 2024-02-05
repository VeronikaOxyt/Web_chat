<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Администратор</title>
    <style>
        <%@include file="../css/admin.css"%>
        <%@include file="../css/toggle.css"%>
    </style>
</head>
<body>
    <main>
        <form action="admin?command=admin_actions" method="post">
                <h1>Панель управления</h1>
                <h2>Режим «Только чтение»</h2>
                <table class="user-list" name="users-list">
                    <c:forEach items="${users}" var="user">
                        <tr><td class="users">
                        <label><c:out value="${user.name}"/></label></td>
                            <td><c:choose>
                                <c:when test="${user.readOnlyMode == true}">
                                <label class="switch">
                                  <input type="checkbox" name="condition" value="${user.login}" checked>
                                  <span class="slider round"></span>
                                </label>
                                </c:when>
                                <c:otherwise>
                                    <label class="switch">
                                         <input type="checkbox" name="condition" value="${user.login}">
                                         <span class="slider round"></span>
                                    </label>
                                </c:otherwise>
                            </c:choose></td>
                        </tr>
                    </c:forEach>
                </table>
                <button class="button" type="submit">Сохранить</button>
            </form>
    </main>
</body>
</html>