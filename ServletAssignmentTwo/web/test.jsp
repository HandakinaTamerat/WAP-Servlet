<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: handakina
  Date: 7/12/2019
  Time: 10:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>--%>

<%@ taglib prefix="ct" uri="http://mycompany.com"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<ct:tag1/>
<br>

<ct:tag2>
    Hello from the tag body.
</ct:tag2>
<br>

<ct:tag3 message="Hello From Attributes :)" />
<br>
<ct:tag3 message='<%= request.getHeader("User-Agent") %>' />
<br>
<ct:tag3 message="${pageContext.request.localAddr}" />
<br>

<ct:currentDateTime color="red" size="24px" />

</body>
</html>
