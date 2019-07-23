<%@ page import="Models.Order" %>
<%@ page import="Models.OrderItem" %><%--
  Created by IntelliJ IDEA.
  User: handakina
  Date: 7/13/2019
  Time: 11:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <link href="<c:url value='/resources/css/index.css'/>" rel="stylesheet"/>
    <link href="<c:url value='/resources/css/confirmation.css'/>" rel="stylesheet"/>
    <link href="<c:url value='/resources/css/login.css'/>" rel="stylesheet"/>
    <script src="<c:url value='resources/js/index.js'/>" type="text/javascript"></script>
    <title>Payment Confirmation </title>
</head>
<body>
<jsp:include page="header.jsp"/>

<div class="container">
    <h3>Thank you for your order</h3>
    <hr/>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Item</th>
            <th scope="col">Quantity</th>
            <th scope="col">Unit Price</th>
        </tr>
        </thead>
        <tbody> <% double total=0;
            for (OrderItem listItem:
            ((Order)request.getAttribute("confirm")).getOrderItemList()) {
                total+=listItem.getQuantity()*listItem.getItem().getPrice();
            }%>
        <c:forEach items="${confirm.orderItemList}" var="orderItem" varStatus="in">

            <tr>
                <th scope="row">${in.count}</th>
                <td>${orderItem.item.itemName}</td>
                <td>${orderItem.quantity}</td>
                <td>$${orderItem.item.price}</td>
            </tr>
        </c:forEach>
        </tbody>
        <tfoot>
        <tr>
            <th scope="col" colspan="2">Total</th>
            <th scope="col" colspan="2"><%=total%></th>
        </tr>
        </tfoot>
    </table>
    <h5><strong>Your order have been sent successfully! thank you for choosing us!</strong></h5>
</div>
</body>
</html>
