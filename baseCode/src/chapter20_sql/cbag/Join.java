package chapter20_sql.cbag;

public class Join {

//	
//	SELECT Persons.LastName, Persons.FirstName, Orders.OrderNo
//	FROM Persons, Orders
//	WHERE Persons.Id_P = Orders.Id_P 
//	
//	SELECT Persons.LastName, Persons.FirstName, Orders.OrderNo
//	FROM Persons
//	INNER JOIN Orders
//	ON Persons.Id_P = Orders.Id_P
//	ORDER BY Persons.LastName
	
//	JOIN: 如果表中有至少一个匹配，则返回行
//	LEFT JOIN: 即使右表中没有匹配，也从左表返回所有的行
//	RIGHT JOIN: 即使左表中没有匹配，也从右表返回所有的行
//	FULL JOIN: 只要其中一个表中存在匹配，就返回行
	
//	SELECT column_name(s)
//	FROM table_name1
//	INNER JOIN table_name2 
//	ON table_name1.column_name=table_name2.column_name
	
//	SELECT Persons.LastName, Persons.FirstName, Orders.OrderNo
//	FROM Persons
//	INNER JOIN Orders
//	ON Persons.Id_P=Orders.Id_P
//	ORDER BY Persons.LastName
}
