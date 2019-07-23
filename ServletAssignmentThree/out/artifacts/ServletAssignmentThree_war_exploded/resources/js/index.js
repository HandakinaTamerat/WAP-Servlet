$(function () {
    $("#account-container").click(function () {
        $("#loginModal").show();
        return false;
    });
    $("#modalClose").click(function () {
        $("#loginModal").hide();
    });
    $(".addCartBtn").click(function () {
        var input = $(this).prev().prev().prev();
        var id = input.attr("id");
        addItemToCart(id);
        return false;
    });
    $("#login-form").submit(function (event) {
        event.preventDefault();
        $.ajax({
            url: "login",
            type: 'post',
            data: $("#login-form").serialize(),
            success: function(data, status, xhr) {
                var value=parseInt(data);
                if(value===1){
                    $("#account-container").hide();
                    $("#signout-container").show();
                    $("#cart-container").show();
                    alert("successfully logged in");
                }else {
                    alert("login was not successful please try again!");
                }
            },
            error: function(xhr, status, error){
                alert("login was not successful please try again!");
            }
        }).always(function () {
            $("#loginModal").hide();
        });
    });
    $("#signout-container").click(function () {
        $.ajax("/logout",{
            type:'post',
            success: function () {
                $("#signout-container").hide();
                $("#cart-container").hide();
                $("#account-container").show();
            }
        })
    });
});

function logedSuccess() {
    console.log("logged in");
}

function addItemToCart(itemId) {
    $.ajax({
        type: "get",
        url: "addCartServlet",
        contentType: "application/json", // NOT dataType!
        data: {id:itemId},
        success: function (resultObj) {
            if(resultObj.status=="ok"){
                $("#cartNum").html(resultObj.numberOfItem);
                alert("item added successfully");
            }else {
                alert("please login to add item to cart!");
            }
        },
        error: function (error) {
            alert("please login to add item to cart!");
        }
    });
}


