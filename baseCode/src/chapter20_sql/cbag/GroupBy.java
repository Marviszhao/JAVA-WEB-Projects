package chapter20_sql.cbag;



public class GroupBy {
//	SELECT column_name, aggregate_function(column_name)
//	FROM table_name
//	WHERE column_name operator value
//	GROUP BY column_name
//	
//	SELECT Customer,SUM(OrderPrice) FROM Orders
//	GROUP BY Customer
//	
//	SELECT column_name, aggregate_function(column_name)
//	FROM table_name
//	WHERE column_name operator value
//	GROUP BY column_name
//	HAVING aggregate_function(column_name) operator value
//	
//	SELECT Customer,SUM(OrderPrice) FROM Orders
//	GROUP BY Customer
//	HAVING SUM(OrderPrice)<2000
//	
//	SELECT Customer,SUM(OrderPrice) FROM Orders
//	WHERE Customer='Bush' OR Customer='Adams'
//	GROUP BY Customer
//	HAVING SUM(OrderPrice)>1500
}
