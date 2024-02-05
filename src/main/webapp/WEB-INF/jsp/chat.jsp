<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
    <link rel="icon" href="data:,">
    <head>
        <meta charset="UTF-8">
        <script src="https://kit.fontawesome.com/b56e379ce1.js" crossorigin="anonymous"></script>
        <title>Чат</title>
        <style>
            <%@include file="../css/chat.css"%>
        </style>
    </head>
    <body>
        <header>
            <a href="chat?command=logout" class="btn logout">Выход</a>
            <c:if test="${user.userType eq 'ADMIN'}">
                <a href="chat?command=show_admin_page" class="btn admin">Aдминистратор</a>
            </c:if>
        </header>
        <main>
        <div align="center" class="chat-container">
                    <div class="message-field">
                    <c:forEach items="${messages}" var="message">
                    <c:choose><c:when test="${message.username == user.name}">
                    <div class="message-block" style="justify-content: end">
                        <div class="message" style="background-color: #cd66cc">
                             <label class="name"><c:out value="You" /></label>
                             <label><c:out value="${message.textMessage}"/></label>
                        </div>
                    </div>
                        </c:when>
                        <c:otherwise>
                        <div class="message-block">
                        <div class="message">
                             <label class="name"><c:out value="${message.username}" /></label>
                             <label><c:out value="${message.textMessage}"/></label>
                        </div>
                        </div>
                        </c:otherwise>
                    </c:choose>
                    </c:forEach></div>
            <c:if test="${!user.readOnlyMode}">
                     <form action="chat?command=send_message" method="post">
                          <input type="text" name="message" value="${textMessage}"
                                class="input-message" placeholder="Введите сообщение...">
                          <button type="submit" class="send">
                          <i class="fa fa-paper-plane" aria-hidden="true"></i></button>
                     </form>
            </c:if>
            <c:if test="${user.readOnlyMode}">
                    <form action="messages">
                        <input type="text" name="message" class="input-message" disabled>
                        <button type="submit" class="send" disabled></button>
                    </form>
                </div>
            </c:if>
        </main>
    </body>
</html>