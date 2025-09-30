<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page isELIgnored="false"%>
<html>
<head>
<title>Payment Page</title>
<script src="https://checkout.razorpay.com/v1/checkout.js"></script>
</head>
<body>

	<h2>Pay with Razorpay</h2>

	<button id="rzp-button1">Pay Now</button>

	<script>
var options = {
    "key": "${key}", 
    "amount": "${amount}", 
    "currency": "INR",
    "name": "My Shop",
    "description": "Test Transaction",
    "order_id": "${orderId}", 
    "handler": function (response){
        alert("Payment ID: " + response.razorpay_payment_id);
        alert("Order ID: " + response.razorpay_order_id);
        alert("Signature: " + response.razorpay_signature);

        // 🔹 Call backend verify API
        fetch("/verify", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(response)
        })
        .then(res => res.json())
        .then(data => alert(JSON.stringify(data)))
    },
    "prefill": {
        "name": "Test User",
        "email": "test@example.com",
        "contact": "9999999999"
    },
    "theme": {
        "color": "#3399cc"
    }
};

document.getElementById('rzp-button1').onclick = function(e){
    var rzp1 = new Razorpay(options);
    rzp1.open();
    e.preventDefault();
}
</script>

</body>
</html>
