<!DOCTYPE html>
<html>
<head>
    <title>CoinGrind</title>
</head>
<body>
<h1>CoinGrind</h1><hr>
<h3>Подробная информация о пользователе ${user.name}</h3>
<b>Номер телефона: </b> ${user.phoneNumber}<br>
<b>Email: </b> ${user.email}<br>
<h4>Transactions of user ${user.name}</h4>
<#list transactions as transaction>
    <div>
        <p><b>${transaction.title}</b> ${transaction.amountOfMoney} руб. | <a href="/transaction/${transaction.id}">Подробнее...</a></p>
    </div>
<#else>
    <h3>Transactions are omitted</h3>
</#list>
<#if errorMessage??>
    <h2 style="color: red">${errorMessage}</h2>
</#if>
</body>
</html>