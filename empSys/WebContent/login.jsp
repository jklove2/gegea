<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title></title>
		<script type="text/javascript">
		function changeImg(){
		
			var val = document.getElementById("validate");
			val.src="${pageContext.request.contextPath }/ImgCheckServlet?date="+new Date();
		}
		
		
		</script>
		<style>
			body {
				margin: 0px;
				background-image: url(img/登录页面.jpg);
				background: cover;
			}
			
			div {
				position: relative;
				top: 100px;
				width: 40%;
				left: 42%;
			}
			
			#len {
				font-size: 35px;
				color: chocolate;
			}
			
			.in {
				position: relative;
				top=70px;
				width: 60%;
				height: 25px;
				margin: 10px;
			}
			.i2{
				width: 25%;
				height: 40px;
				font-size: 18px;
			}
			label{
			cursor:pointer;
			}
		
		</style>
	</head>

	<body>
		<div>
			<form action="${pageContext.request.contextPath }/loginServlet" style="text-align: center" method="post">
				<fieldset>
					<lengend id="len">欢迎来到员工系统</lengend>
					<br> <span style="font-size: 20px;" class="sp">账户名:</span><input class="in" type="text" name="name" id="name" autofocus="autofocus" /><br>
					<span style="font-size: 20px;" class="sp">&nbsp;&nbsp;密码:&nbsp;</span><input class="in" type="password" name="password" id="password" /><br>
					验证码:<input type="text" name="validate">
				<label onclick="changeImg()" >
					<img id="validate"   alt="验证码" src="${pageContext.request.contextPath }/ImgCheckServlet"><input  type="button"value="刷新图片"/>
					</label>
					<span style="color: red; font-size: 25px;" id="nameSpan">${requestScope.error_msg }</span><br>
					<input class="i2" type="reset" value="重置">
					<a href="${pageContext.request.contextPath }/register.jsp"><input class="i2" type="button" value="注册" />
					</a> <input class="i2" type="submit" value="登录">
				</fieldset>
			</form>
		</div>

	</body>

</html>