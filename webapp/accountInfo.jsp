<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
    <title>Account Info</title>
    <style><%@include file="/css/navStyles.css"%></style>
    <style><%@include file="/css/contentStyles.css"%></style>
</head>
<body>
    <div class="wrapper">
        <nav class="vert-nav">
            <h2>Navigation<br>bar</h2>
            <div class="menu">
                <c:if test="${sessionScope.user.userRole eq 'Admin'}">
                    <a href="${pageContext.request.contextPath}/webController?command=main">
                        <div class="item">Main</div>
                    </a>
                </c:if>
                <!-- <c:if test="${sessionScope.user.userRole eq 'User'}">
                    <a href="${pageContext.request.contextPath}/webController?command=employeeInfo&id=${requestScope.employee.employeeId}">
                        <div class="item">Main</div>
                    </a>
                </c:if> -->
                <a href="${pageContext.request.contextPath}/webController?command=accountInfo">
                    <div class="item">Account Info</div>
                </a>
                <a href="${pageContext.request.contextPath}/webController?command=logOut">
                    <div class="item">Log Out</div>
                </a>
            </div>
            <footer class="footer">
                <p>
                    &copy;Powered by<br>
                    Nazarii Melnyk
                </p>
            </footer>
        </nav>

        <main class="main">
            <div class="main-wrapper">
                <h2>Hello, ${sessionScope.user.userName}</h2>
                <h5>Email - ${sessionScope.user.userEmail}</h5>
                <h5>Role - ${sessionScope.user.userRole}</h5>
            </div>
        </main>
    </div>
</body>
</html>
