<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="ct" uri="http://handakina.com" %>

<%@ page isELIgnored="false" %> <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="ct" uri="http://handakina.com" %>

<%@ page isELIgnored="false" %>

<header>
    <div>
        <div class="logo">
            <a href="index.jsp" >
                <h2 style="text-align: center;margin: 0px;">Wap Project</h2>
            </a>

        </div>
        <input type="search" class="form-control">

        <c:if test="${not empty user}">
            <form action="checkout.jsp">
                <div class="cart-container btn btn-outline-dark" id="cart-container">
                    <span id="cartNum">${user.cart.orderItems.size()}</span>
                    <div class="cart">
                        <img src="<c:url value="/resources/images/cart.png"/> ">
                    </div>
                    <input type="submit" class="btn btn-primary" value="checkout">
                </div>
            </form>

        </c:if>
        <c:if test="${empty user}">
            <form action="checkout.jsp">
                <div class="cart-container btn btn-outline-dark" id="cart-container" style="display: none">
                    <span id="cartNum">0</span>
                    <div class="cart">
                        <img src="<c:url value="/resources/images/cart.png"/> ">
                    </div>
                    <input type="submit" class="btn btn-primary" value="checkout">
                </div>
            </form>

        </c:if>

        <c:if test="${not empty user}">
            <a href="index.jsp">
            <div class="cart-container btn btn-outline-dark" id="signout-container">
                <div class="cart">
                    <img src="<c:url value="/resources/images/account.png"/> ">
                </div>



                <input type="submit" class="btn btn-primary" value="Sign out">
            </div>
            </a>
        </c:if>
        <c:if test="${empty user}">
            <a href="index.jsp">
            <div class="cart-container btn btn-outline-dark" id="signout-container" style="display: none">
                <div class="cart">
                    <img src="<c:url value="/resources/images/account.png"/> ">
                </div>
                <input type="submit" class="btn btn-primary" value="Sign out">
            </div>
            </a>
        </c:if>

        <c:if test="${not empty user}">
            <div class="cart-container btn btn-outline-dark" id="account-container" style="display: none">
                <div class="cart">
                    <img src="<c:url value="/resources/images/account.png"/> ">
                </div>
                <input type="submit" class="btn btn-primary" value="Sign In">
            </div>
        </c:if>
        <c:if test="${empty user}">
            <div class="cart-container btn btn-outline-dark" id="account-container">
                <div class="cart">
                    <img src="<c:url value="/resources/images/account.png"/> ">
                </div>
                <input type="submit" class="btn btn-primary" value="Sign In">
            </div>
        </c:if>


    </div>
</header>