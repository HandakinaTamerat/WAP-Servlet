<%@ page import="Models.OrderItem" %>
<%@ page import="Models.User" %><%--
  Created by IntelliJ IDEA.
  User: handakina
  Date: 7/13/2019
  Time: 3:15 PM
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
    <link href="<c:url value='/resources/css/checkout.css'/>" rel="stylesheet"/>
    <link href="<c:url value='/resources/css/login.css'/>" rel="stylesheet"/>
    <script src="<c:url value='resources/js/index.js'/>" type="text/javascript"></script>
    <title>Free Food - Check Out</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<h3>Check Out</h3>
<section class="container">
    <h5> Order Detail</h5>
    <div class="orders">
        <c:forEach items="${user.cart.orderItems}" var="orderItem">
            <div>
                <p>${orderItem.item.itemName}</p>
                <input type="button" value="X" class="btn btn-danger"/>
                <p>${orderItem.item.price}</p>
                <p>X</p>
                <input type="text" class="form-control checkoutNum" size="1" value="${orderItem.quantity}"/>
            </div>
        </c:forEach>
        <div>
            <p><strong>Total</strong></p>
            <% double total = 0;
                User thisUser = (User) session.getAttribute("wapUser");
                for (OrderItem item : thisUser.getCart().getOrderItems()) {
                    total += item.getQuantity() * item.getItem().getPrice();
                }%>
            <p><strong><%=total%>
            </strong></p>
        </div>

    </div>

    <h5>Billing and Shipping Address</h5>
    <form action="checkout" method="post">

        <div class="address">
            <div>
                <label for="name">Full Name: * </label>
                <input type="text" required id="name" name="name" class="form-control"/>
            </div>
            <div>
                <label for="address1">String Address 1: * </label>
                <input type="text" required id="address1" name="address1" class="form-control"/>
            </div>
            <div>
                <label for="address2">String Address 2: </label>
                <input type="text" required id="address2" name="address2" class="form-control"/>
            </div>
            <div>
                <label for="zipCode">Zip Code: * </label>
                <input type="number" required id="zipCode" name="zipCode" class="form-control" placeholder="Zip Code for city and state"/>
            </div>
            <div>
                <label for="phone">Phone: * </label>
                <input type="tel" required id="phone" name="phone" class="form-control"/>
            </div>
            <div>
                <label for="email">Email: * </label>
                <input type="email" required id="email" name="email" class="form-control"/>
            </div>
        </div>

        <h5>Payment form</h5>
        <div class="payment-form">
            <div>
                <label for="cardName">Name on Card: * </label>
                <input type="text" required required id="cardName" name="cardName" class="form-control"/>
            </div>
            <div>
                <label for="cardNumber">Card Number: * </label>
                <input type="text" required id="cardNumber" placeholder="XXXX-XXXX-XXXX" name="cardNumber" class="form-control"/>
            </div>
            <div>
                <label for="expDate">Expire Date: </label>
                <input type="text" required id="expDate" name="expDate" placeholder="XX/XX" class="form-control"/>
            </div>
            <div>
                <label for="cvc">CVC: * </label>
                <input type="number" required id="cvc" name="cvc" class="form-control" placeholder="XXX"/>
            </div>
        </div>

        <input type="submit" class="btn btn-primary sbm-area" value="Check Out"/>

    </form>
</section>


</body>
</html>
