<!DOCTYPE html>
<html>
<head>
    <title>CoinGrind</title>
</head>
<body>
<h1>CoinGrind</h1>
<hr>
<#if user.email??>
    <h3>User name: <i>${user.name}</i></h3>
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <input type="submit" value="Log out"/>
    </form>
    <#if user.isAdmin()>
        <a href="/admin">Панель администратора</a>
    </#if>
<#else>
<a href="/login">Log in</a></h1>
</#if>
<hr>
<h4>Your transactions</h4>
<form action="/transactions" method="get">
    Search for transaction... <input type="text" name="title"><br>
    <input type="submit" value="Search"/>
</form>
<#list transactions as transaction>
    <div>
        <p><b>${transaction.title}</b> ${transaction.amountOfMoney} руб. | <a href="/transaction/${transaction.id}">More...</a></p>
    </div>
    <#else>
    <h3>Transaction is not found</h3>
</#list>
<#if user.email??>
<hr>
<h3>Add new transaction</h3>
<form action="/transaction/create" method="post">
    Name of transaction: <input type="text" name="title"/><br><br>
    Description of transaction: <input type="text" name="description"/><br><br>
    Amount of money: <input type="number" name="amountOfMoney"/><br><br>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Add transaction"/>
</form>
</#if>
</body>
</html>