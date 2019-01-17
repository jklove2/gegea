<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<style type="text/css">
			body{
				margin: 0;
			background-image: url(img/主页.jpg);
			}
			div{
				float: right;
				font-size: 20px;
			}
			a : hover{
				cursor: pointer;
			}
			input{
				position: relative;
				top: 50px;
				width: 15%;
				height: 70px;
				margin: 20px;
				font-size: 35px;
			}
		</style>
	</head>
	<body>
		
	<h1 align="center" style="font-size: 50px;">欢迎来到员工信息系统</h1>
	<hr width="80%">
	<c:if test="${sessionScope.user == null }">
		<a href="${pageContext.request.contextPath }/register.jsp" ><input type="button" value="注册" /></a>
		<a href="${pageContext.request.contextPath }/login.jsp"><input type="button" value="登录" /></a>
	</c:if>
	<c:if test="${sessionScope.user != null }">
		<a href="${pageContext.request.contextPath }/empList.jsp"><input type="button" value="员工列表" /></a>
		<a href="${pageContext.request.contextPath }/LogoutServlet"><input type="button" value="安全退出" /></a>
		<div>
			${sessionScope.user.name }欢迎您的到来<br>
			您上次登录的时间：${requestScope.lastTime }
		</div>
		
	</c:if>
	</body>
</html>
