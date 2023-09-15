<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
    <title>Sign Up</title>
    <style><%@include file="/css/logInStyles.css"%></style>
</head>
<body>
    <div class="wrapper fadeInDown">
        <div id="formContent">
            <h2 class="active"> User creation form </h2>

            <form action="${pageContext.request.contextPath}/webController?command=signUp" method="post">
                <input type="text"
                        id="login"
                        class="fadeIn first"
                        name="name"
                        placeholder="Name"
                        required
                />
                <input type="email"
                       id="email"
                       class="fadeIn second"
                       name="email"
                       placeholder="Email@example.com"
                       required
                />
                <input type="password"
                       id="password"
                       class="fadeIn third"
                       name="password"
                       placeholder="Password"
                       required
                />
                <input type="password"
                       id="confirmPassword"
                       class="fadeIn fourth"
                       name="login"
                       placeholder="Confirm password"
                       required
                />
                <input type="text"
                       class="fadeIn fifth"
                       placeholder="Position"
                       name="position"
                       required
                />
                <input type="text"
                       class="fadeIn sixth"
                       placeholder="Card UID"
                       name="code"
                       required
                />
                <select name="role" class="fadeIn seventh">
                    <option value="Admin">Admin</option>
                    <option value="User">User</option>
                </select>
                <div>
                    <label class="fadeIn eighth">Start time: </label>
                    <input type="time"
                           class="fadeIn eighth"
                           min="06:00"
                           max="21:00"
                           name="startTime"
                           required
                    />
                </div>
                <div>
                    <label class="fadeIn ninth">End time: </label>
                    <input type="time"
                           class="fadeIn ninth"
                           min="06:00"
                           max="21:00"
                           name="endTime"
                           required
                    />
                </div>
                <input type="submit"
                       class="fadeIn tenth"
                       value="Create user"
                />
            </form>
        </div>
    </div>
</body>
</html>
