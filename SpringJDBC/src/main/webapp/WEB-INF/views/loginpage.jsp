<%--
  Created by IntelliJ IDEA.
  User: Oshan Fernando
  Date: 10/17/2018
  Time: 18:58
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="/resources/loginStyles.css">
</head>
<body>

<div id="main">
    <div id="first">
        <c:url var = "action" value="/home"></c:url>
        <form:form action="${action}" method="post" modelAttribute="command">
            <h1 align="center">User Account</h1>
            <h4>Please fill all entries.</h4> <hr/>
            <label>E-mail </label><br/>
            <form:input path="email" /><br/>

            <label>Password </label><br/>
            <form:password path="password" /> <br/>

            <c:if test="${!empty error}">
                <label style="color:red"> ${error}</label>
            </c:if>


            <input style="margin-top: 50px" type="submit" value="Login"/>
            <br/>
            <a href="<c:url value="/createuser"/>"> Sign Up</a>
        </form:form>
    </div>


</div>
</body>
</html>
