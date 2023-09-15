<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
    <title>Log In</title>
    <style><%@include file="/css/logInStyles.css"%></style>
</head>
<body>
    <div class="wrapper fadeInDown">
        <div id="formContent">
            <h2 class="active"> Log In </h2>

            <div class="fadeIn first">
                <img src="https://cdn-icons-png.flaticon.com/512/5087/5087607.png" id="icon" alt="User Icon" />
            </div>

            <form action="${pageContext.request.contextPath}/webController?command=logIn" method="post">
                <input type="email"
                       id="login"
                       class="fadeIn second"
                       name="email"
                       placeholder="Email"
                       value="${requestScope.email}"
                       required
                />
                <input type="password"
                       id="password"
                       class="fadeIn third"
                       name="password"
                       placeholder="Password"
                       required
                />
                <input type="submit"
                       class="fadeIn fourth"
                       value="Log In"
                />
            </form>
        </div>
    </div>
</body>
</html>
