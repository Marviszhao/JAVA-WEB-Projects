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
	
//	JOIN: �������������һ��ƥ�䣬�򷵻���
//	LEFT JOIN: ��ʹ�ұ���û��ƥ�䣬Ҳ����������е���
//	RIGHT JOIN: ��ʹ�����û��ƥ�䣬Ҳ���ұ������е���
//	FULL JOIN: ֻҪ����һ�����д���ƥ�䣬�ͷ�����
	
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
