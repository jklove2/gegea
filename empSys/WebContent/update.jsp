<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/register.css" />

</head>
<body>
	<div>
		<form
			action="${pageContext.request.contextPath }/UpdateServlet"
			method="post">
			<fieldset>
				<legend>请修改</legend>

				<span id="sp1">姓名：</span><input id="name" class="c1" type="text" name="name"
					placeholder="${requestScope.emp.name }" readonly="readonly" 
					value="${requestScope.emp.name }" /> <span class="c4" id="nameSpan"
					name="nameSpan"  >禁止修改</span><br /> <span id="sp1">密码：</span><input id="password1"
					class="c1" type="password" name="password1"
					placeholder="${requestScope.emp.password}" required="required"
					onblur="checkPassword()" /> <span class="c4" name="password1Span"
					id="password1Span">&ensp;*必填项</span> <br /><span id="sp1"> 确认密码:</span><input id="password2"
					class="c1" type="password" name="password2"
					placeholder="${requestScope.emp.password }" required="required"
					onblur="checkPassword()" /><span class="c4" id="password2Span"
					name="password2Span">*必填项</span> <br /> <span class="c2">性别:<label><input
						type="radio" name="gender" checked="checked" value="男" />男</label></span> <span
					class="c2"><label> <input type="radio" name="gender"
						value="女" />女
				</label></span> <br /> <span id="sp1">年龄：</span><input id="age" class="c3" name="age" type="text"
					required="required" onblur="checkAge()"
					placeholder="${requestScope.emp.age }" /><span class="c4"
					name="ageSpan" id="ageSpan">&ensp;*必填项</span><br /><span id="sp1"> 薪资：</span><input
					id="salary" class="c3" name="salary" type="text"
					placeholder="${requestScope.emp.salary }" required="required"
					onblur="checkSalary()" /><span class="c4" id="salarySpan"
					name="salarySpan">&ensp;*必填项</span><br /> <span id="sp1">电话：</span><input id="phone"
					class="c3" name="phone" type="text"
					placeholder="${requestScope.emp.phone }" required="required"
					onblur="checkPhone()" /><span class="c4" id="phoneSpan"
					name="phoneSpan">&ensp;*必填项</span><br /> <span id="sp1">邮箱：</span><input id="email"
					class="c3" name="email" type="text"
					placeholder="${requestScope.emp.email }" required="required"
					onblur="checkEmail()" /><span class="c4" id="emailSpan"
					name="emailSpan">&ensp;*必填项</span><br /> <input class="submit"
					type="submit" value="确认修改" />

			</fieldset>
		</form>
	</div>
</body>

</html>
<script type="text/javascript">
	function checkName() {
		var name = document.getElementById("name").value;
		if (name != "") {
			document.getElementById("nameSpan").innerHTML = "<span style='font-size: 25px ;color: green;'>&ensp;&ensp;√&ensp;&ensp;&ensp;</span>";

		}

	}

	function checkPassword() {
		var password1 = document.getElementById("password1").value;
		var password2 = document.getElementById("password2").value;
		var password1Span = document.getElementById("password1Span");
		var password2Span = document.getElementById("password2Span");
		if (password1 != "" && password2 != "") {
			if (password1 != password2) {

				password2Span.innerText = "密码不一致";
				document.getElementById("password1").value = "";
				document.getElementById("password2").value = "";
			} else {
				password1Span.innerHTML = "<span style='font-size: 20px ;color: green;'>密码一致</span>";
				password2Span.innerHTML = "<span style='font-size: 20px ;color: green;'>密码一致</span>";
			}
		}
	}

	function checkAge() {
		var reg = /^[1-9]{1}[0-9]*$/
		var age = document.getElementById("age").value;
		if (reg.test(age)) {
			document.getElementById("ageSpan").innerHTML = "<span style='font-size: 25px ;color: green;'>&ensp;&ensp;√&ensp;&ensp;&ensp;</span>";

		} else {
			document.getElementById("ageSpan").innerHTML = "&ensp;&ensp;不合规";
			document.getElementById("age").value = "";

		}

	}

	function checkSalary() {
		var reg = /^([1-9]{1,}[.]?[0-9]*)$/
		var salary = document.getElementById("salary").value;
		if (reg.test(salary)) {
			document.getElementById("salarySpan").innerHTML = "<span style='font-size: 25px ;color: green;'>&ensp;&ensp;√&ensp;&ensp;&ensp;</span>";
		} else {

			document.getElementById("salarySpan").innerHTML = "&ensp;&ensp;不合规";
			document.getElementById("salary").value = "";
		}
	}

	function checkPhone() {

		var reg = /^1[3|4|5|7|8][0-9]{9}$/;
		var phone = document.getElementById("phone").value;
		if (reg.test(phone)) {
			document.getElementById("phoneSpan").innerHTML = "<span style='font-size: 25px ;color: green;'>&ensp;&ensp;√&ensp;&ensp;&ensp;</span>";

		} else {
			document.getElementById("phoneSpan").innerHTML = "&ensp;&ensp;不合规";
			document.getElementById("phone").value = "";
		}

	}

	function checkEmail() {
		var reg = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
		var email = document.getElementById("email").value;
		if (reg.test(email)) {
			document.getElementById("emailSpan").innerHTML = "<span style='font-size: 25px ;color: green;'>&ensp;&ensp;√&ensp;&ensp;&ensp;</span>";

		} else {
			document.getElementById("emailSpan").innerHTML = "&ensp;&ensp;不合规";
			document.getElementById("email").value = "";
		}

	}
</script>