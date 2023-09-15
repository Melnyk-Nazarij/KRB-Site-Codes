<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
    <title>Employee Info</title>
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
                <h2>Employee: ${requestScope.employee.employeeName}</h2>
                <h4>Position - ${requestScope.employee.employeePosition}</h4>
                <h4>Current status - ${requestScope.employee.employeeStatus}</h4>
                <h4>Shift start time - ${requestScope.employee.startTime}</h4>
                <h4>Shift end time - ${requestScope.employee.endTime}</h4>
                <h4>Card code - ${requestScope.employee.cardCode}</h4>

                <h2>Attendance entries: </h2>
                <table>
                    <tr>
                        <th>Time</th>
                        <th>Type</th>
                    </tr>
                    <c:forEach var="entry" items="${requestScope.entries}">
                        <tr>
                            <td>
                                <div>
                                    ${entry.getTime()}
                                </div>
                            </td>
                            <td>
                                <div>
                                    ${entry.entryType}
                                </div>
                            </td>
                        </tr>
                    </c:forEach>
                </table>

                <h2>Per day status: </h2>
                <table>
                    <tr>
                        <th>Date</th>
                        <th>Status</th>
                    </tr>
                    <c:forEach var="day" items="${requestScope.workDays}">
                        <tr>
                            <td>
                                <div>
                                    ${day.date}
                                </div>
                            </td>
                            <td>
                                <div>
                                    ${day.dayStatus}
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
