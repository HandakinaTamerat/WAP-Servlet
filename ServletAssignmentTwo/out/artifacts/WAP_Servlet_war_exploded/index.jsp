<%--
  Created by IntelliJ IDEA.
  User: handakina
  Date: 7/11/2019
  Time: 10:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="<c:url value='/resources/css/index.css'/>" rel="stylesheet"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Form - Page </title>
  </head>
  <body>
  <div class="container">
    <h1>Welcome to login screen</h1>
    <div class="form">
      <form action="userpage" method="POST">
        <div>
          <% String name="";
              for (Cookie cookie : request.getCookies()) {
                if (cookie.getName().equals("userName")) {
                  name= cookie.getValue();
                }
              }
            %>

          <h5>User Name: </h5> <input type="text" name="name" value="<%=  name.equals("")?"":name%>" >
        </div>
        <div>
          <h5>Password: </h5><input type="password" name="password">
        </div>
        <div>
            <input type="checkbox" name="remember" id="remember" <%=name.equals("")?"":"checked"%>> <label for="remember"> Remember Me</label>
        </div>
        <input type="submit" value="Login">
      </form>
    </div>
  </div>
  </body>
</html>
