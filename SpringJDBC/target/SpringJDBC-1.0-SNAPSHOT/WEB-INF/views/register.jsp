<%--
  Created by IntelliJ IDEA.
  User: Oshan Fernando
  Date: 10/17/2018
  Time: 20:50
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Create Account</title>
    <link rel="stylesheet" type="text/css" href="/resources/loginStyles.css">
</head>
<body>

    <div id="main">


        <div id="first">

            <c:url var="action" value="/register" ></c:url>
            <form:form action="${action}" method="post" modelAttribute="user">
                <h1 align="center">Create Account</h1>
                <h4>Please fill all entries.</h4>
                <c:if test="${!empty msg}">
                    <label style="color: greenyellow">${msg}</label>
                </c:if>
                <c:if test="${!empty err}">
                    <label style="color: red">${err}</label>
                </c:if>
                <hr/>
                <label>Name </label><br/>
                <form:input path="name" /><br/>

                <label>Address </label><br/>
                <form:input path="address" /><br/>

                <label>Age </label><br/>
                <form:input path="age" /><br/>

                <label>E-mail </label><br/>
                <form:input path="email" /><br/>

                <label>Password </label><br/>
                <form:password path="password" /><br/>

                <input style="margin-top: 50px" type="submit" value="Create Account"/>

            </form:form>
        </div>
    </div>

</body>
</html>
