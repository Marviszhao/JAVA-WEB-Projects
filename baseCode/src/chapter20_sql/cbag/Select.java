package chapter20_sql.cbag;

public class Select {
//	SELECT 列名称 FROM 表名称
//	SELECT * FROM 表名称
//	SELECT LastName,FirstName FROM Persons
//	-----------------DISTINCT---------------------------
//	SELECT DISTINCT 列名称 FROM 表名称
	
//	SELECT DISTINCT Company FROM Orders 
//	-----------------WHERE-----------------------
//	SELECT 列名称 FROM 表名称 WHERE 列 运算符 值
//	
//	SELECT * FROM Persons WHERE City='Beijing'
//	
//	SELECT * FROM Persons WHERE FirstName='Bush'
//	
//	SELECT * FROM Persons WHERE FirstName=Bush
//	
//	这是正确的：
//	SELECT * FROM Persons WHERE Year>1965
//
//	这是错误的：
//	SELECT * FROM Persons WHERE Year>'1965'
//	--------------------AND-OR---------------------------
//	SELECT * FROM Persons WHERE FirstName='Thomas' AND LastName='Carter'
//			
//	SELECT * FROM Persons WHERE firstname='Thomas' OR lastname='Carter'
//	
//	SELECT * FROM Persons WHERE (FirstName='Thomas' OR FirstName='William')
//	AND LastName='Carter'		
	
//	----------------------ORDER BY--------------------------
//	SELECT Company, OrderNumber FROM Orders ORDER BY Company
//	
//	SELECT Company, OrderNumber FROM Orders ORDER BY Company, OrderNumber
//	
//	SELECT Company, OrderNumber FROM Orders ORDER BY Company DESC
//	
//	SELECT Company, OrderNumber FROM Orders ORDER BY Company DESC, OrderNumber ASC
	
	
}
