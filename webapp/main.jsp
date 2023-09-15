<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
    <title>Main</title>
    <style><%@include file="/css/navStyles.css"%></style>
    <style><%@include file="/css/contentStyles.css"%></style>
</head>
<body>
    <div class="wrapper">
        <nav class="vert-nav">
            <h2>Navigation<br>bar</h2>
            <div class="menu">
                <a href="${pageContext.request.contextPath}/webController?command=main">
                    <div class="item">Main</div>
                </a>
                <a href="${pageContext.request.contextPath}/webController?command=signUp">
                    <div class="item">Create User</div>
                </a>
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
            <div class="main-wrapper-admin">
                <table>
                    <tr>
                        <th>Employee</th>
                        <th>Status</th>
                    </tr>
                    <c:forEach var="employee" items="${requestScope.employees}">
                        <tr>
                            <td class="click-td">
                                <a href="${pageContext.request.contextPath}/webController?command=employeeInfo&id=${employee.employeeId}">
                                    <div>
                                        ${employee.employeeName}
                                    </div>
                                </a>
                            </td>
                            <td>
                                <div>
                                    ${employee.employeeStatus}
                                </div>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </main>
    </div>
</body>
</html>