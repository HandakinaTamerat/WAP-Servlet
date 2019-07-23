<%--
  Created by IntelliJ IDEA.
  User: handakina
  Date: 7/11/2019
  Time: 10:53 PM
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>

    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ taglib prefix="ct" uri="http://handakina.com" %>

    <%@ page isELIgnored="false" %>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <link href="<c:url value='/resources/css/index.css'/>" rel="stylesheet"/>
    <link href="<c:url value='/resources/css/login.css'/>" rel="stylesheet"/>
    <script src="<c:url value='/resources/js/index.js'/>" type="text/javascript"></script>
    <title>Free - Food </title>
</head>
<body>
<jsp:include page="header.jsp"/>

<div class="login-modal" id="loginModal">

    <div class="login-form">
        <div>
            <h4>Login - Form</h4> <span id="modalClose">X</span>
        </div>
        <hr/>
        <form action="login" method="post" id="login-form">
            User Name: <input type="text" class="form-control" name="name">
            Password: <input type="password" class="form-control" name="password">
            <input type="submit" value="Login" class="btn btn-primary"/>
        </form>
    </div>
</div>
<section class="container-fluid">

    <c:forEach items="${items}" var="item">
        <ct:prduct alt="${item.itemName}" id="${item.id}" price="${item.price}"
                   src="${pageContext.request.contextPath}/${item.image}" title="${item.itemName}"/>
    </c:forEach>
</section>

</body>
</html>
