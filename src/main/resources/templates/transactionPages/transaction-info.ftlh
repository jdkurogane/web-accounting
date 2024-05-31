<!DOCTYPE html>
<html>
<head>
    <title>CoinGrind</title>
</head>
<body>
<h1>CoinGrind</h1><hr>
<h4>Detailed info about transactions</h4>
<b>Name of transaction: </b>${transaction.title}<br>
<b>Description of transaction: </b>${transaction.description}<br>
<b>Value of transaction: </b>${transaction.amountOfMoney}<br>
<b>Author: </b><a href="/user/${transaction.user.id}"> ${transaction.user.name}</a><br>
<b>Created: </b>${transaction.dateOfCreated}<br>
<hr>
<form action="/transaction/delete/${transaction.id}" method="post">
    <input type="submit" value="Delete transaction"/>
</form>
</body>
</html>