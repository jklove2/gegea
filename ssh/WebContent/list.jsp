<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<s:debug></s:debug>
<body>
	<table>
		<thead>
			<tr>
				<th>序号</th>
				<th>用户名</th>
				<th>密码</th>
				<th>年纪</th>
				<th rowspan="2">操作</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="#list" status="s">
				<tr>
					<th><s:property value="#s.count" /></th>
					<th><s:property value="username" /></th>
					<th><s:property value="password" /></th>
					<th><s:property value="age" /></th>
					<s:url namespace="/user" action="user_findById" var="url1">
						<s:param name="id" value="<s:property value='id' />"></s:param>
					</s:url>
					<th><a
							href="${pageContext.request.contextPath }/user/user_findById&id=1">修改</a></th>
					<s:url namespace="/user" action="user_delete" var="url2">
						<s:param name="id" value="<s:property value='id' />"></s:param>
					</s:url>
					<th><s:a href="<s:property value='#url2'/>">删除</s:a></th>
				</tr>
			</s:iterator>
		</tbody>
	</table>


</body>
</html>