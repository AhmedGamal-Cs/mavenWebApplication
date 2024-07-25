<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Management</title>
</head>
<body>
<form action="Emp" method="post">
	ID : <input type="text" name="ID" placeholder="typeYourId"/><br>
	fullName : <input type="text" name="fullName" placeholder="typeYourFullName"/><br>
	birthDate : <input type="text" name="birthDate" placeholder="typeYourBirthDate"/><br>
	Salary : <input type="text" name="Salary" placeholder="typeYourSalary"/><br>
	<input type="submit" value="Add" name="add"/>
	<input type="submit" value="Delete" name="delete"/>
	<input type="submit" value="Update" name="update"/>
</form>
</body>
</html>
