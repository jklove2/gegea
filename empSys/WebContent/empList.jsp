<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>员工列表</title>
<style type="text/css">
body {
	margin: 0;
	background-image: url(img/list.jpg);
}

table {
	position: relative;
	left: 10%;
	text-align: center;
	width: 80%;
	color: white;
}

caption {
	font-size: 40px;
	color: white;
}

th {
	font-size: 25px;
	color: white;
}

a {
	font-size: 22px;
	color: aquamarine;
}

.aa {
	position: relative;
	left: 10%;
	top: 10px;
}

input {
	width: 50px;
	height: 25px;
}

.sp1 {
	position: relative;
	font-size: 24px;
	color: white;
}

.ca {
	position: relative;
	top: -60px;
}

.sp2 {
	position: relative;
	top: 50px;
}

#sb {
	height: 30px;
	width: 60px;
}
</style>
</head>

<body>
	<div>
		<form method="post"
			action="${pageContext.request.contextPath }/EmpListServlet">
			<span class="sp1">姓名：</span><input class="inp" type="text"
				name="name" /> <span class="sp1">性别：</span><input class="inp"
				type="text" name="gender" /> <span class="sp1">年龄：</span><input
				class="inp" type="text" name="age" /> <input class="inp" id="sb"
				type="submit" value="查询" />
		</form>

	</div>

	<span class="sp2">
		<table border="1" cellspacing="0">
			<caption class="ca">全部员工信息</caption>

			<thead>
				<tr>
					<th>id</th>
					<th>姓名</th>
					<th>密码</th>
					<th>性别</th>
					<th>年龄</th>
					<th>入职日期</th>
					<th>薪资</th>
					<th>电话</th>
					<th>邮箱</th>
					<th colspan="2">操作</th>
				</tr>
			</thead>
			<c:forEach items="${requestScope.list }" var="e">
				<tr>
					<td>${e.id }</td>
					<td>${e.name }</td>
					<td>${e.password }</td>
					<td>${e.gender }</td>
					<td>${e.age }</td>
					<td>${e.hiredate }</td>
					<td>${e.salary }</td>
					<td>${e.phone }</td>
					<td>${e.email }</td>
					<td><a name="name"
						href="${pageContext.request.contextPath }/FindServlet?name=${e.name }">修改</a>
					</td>
					<td><a id="a" onclick="return qr()"
						href="${pageContext.request.contextPath }/DeleteServlet?name=${e.name }">删除</a>
					</td>
				</tr>
			</c:forEach>
		</table> <a class="aa"
		href="${pageContext.request.contextPath }/RecoverServlet">恢复删除数据</a> <br>
		<a class="aa" href="${pageContext.request.contextPath }/index.jsp">返回主页</a>
	</span>

</body>

</html>

<script type="text/javascript">
	function qr() {
		var str = "确认删除";
		if (confirm(str) == true) {
			return true;

		} else {
			return false;
		}

	}
</script>