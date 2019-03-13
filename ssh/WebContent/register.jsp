<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<s:form action="user_add" namespace="/user">
		<s:textfield name="username" label="用户名" />
		<s:password name="password" label="密码" />
		<s:textfield name="age" label="年龄" />
		<s:reset value="重置" />
		<s:submit value="注册" />
	</s:form>
	<s:form action="user_findAll" namespace="/user">
	<s:submit value="主页"/></s:form>
</body>
</html>