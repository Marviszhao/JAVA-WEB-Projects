package chapter20_sql.cbag;

public class Select {
//	SELECT ������ FROM ������
//	SELECT * FROM ������
//	SELECT LastName,FirstName FROM Persons
//	-----------------DISTINCT---------------------------
//	SELECT DISTINCT ������ FROM ������
	
//	SELECT DISTINCT Company FROM Orders 
//	-----------------WHERE-----------------------
//	SELECT ������ FROM ������ WHERE �� ����� ֵ
//	
//	SELECT * FROM Persons WHERE City='Beijing'
//	
//	SELECT * FROM Persons WHERE FirstName='Bush'
//	
//	SELECT * FROM Persons WHERE FirstName=Bush
//	
//	������ȷ�ģ�
//	SELECT * FROM Persons WHERE Year>1965
//
//	���Ǵ���ģ�
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
