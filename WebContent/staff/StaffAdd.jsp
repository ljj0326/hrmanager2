<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basepath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<base href="<%=basepath %>">
		<title>增加员工</title>
		<link rel="stylesheet" type="text/css" href="../css/style.css">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<script type="text/javascript">
		  function checksalary() {
			var selid=document.getElementById("job_id").value;
			var minsal=eval("document.form1getElementById('min"+ selid + "').value");
			var maxsal= eval("document.form1getElementById('max"+ selid + "').value");
			//判断
			   if(mysalar>=minsal&&mysalar<=maxsal){
				   //添加
				   confirm("确定提交数据");
				   documwnt.form1.submit();
			   }else if(mysalar<minsal){
				   alert("工资不能小于最低工资");
			   }else if(mysalar>minsal){
				   alert("工资不能大于最高工资");
			   }else{
				   alert("出现问题");
			   }
		}
		</script>
	</head>
	<body>
		<!-- 页面内容 -->
		<table border="0" width="950" height="350" bgcolor="#ffffff"
			align="center">
			<tr>
				<td align="center" valign="top">
					<form name="form1" method="post" action="staff/staff!insertStaffFun">
						<table width="500" border="0" cellpadding="5" cellspacing="1"
							bgcolor="#CCCCCC">
							<tr>
								<td height="24" colspan="2" align="center" bgcolor="#FFCC00">
									请填写以下员工信息
								</td>
							</tr>
							<tr>
								<td width="120" height="24" bgcolor="#FFFFFF">
									员工姓名
								</td>
								<td width="357" height="24" bgcolor="#FFFFFF">
									<input name="staff.e_name" type="text" id="empname">
									*
								</td>
							</tr>
							<tr>
								<td height="24" bgcolor="#FFFFFF">
									邮箱地址
								</td>
								<td height="24" bgcolor="#FFFFFF">
									<input name="staff.e_mail" type="text" id="email">
									*
								</td>
							</tr>
							<tr>
								<td height="24" bgcolor="#FFFFFF">
									电话号码
								</td>
								<td height="24" bgcolor="#FFFFFF">
									<input name="staff.e_tel" type="text" id="phone_number">
									例如123.456.789
								</td>
							</tr>
							<tr>
								<td height="24" bgcolor="#FFFFFF">
									入职日期
								</td>
								<td height="24" bgcolor="#FFFFFF">
									<input name="staff.e_starttime" type="text" id="hire_date"  onfocus="calendar()">
									yyyy-mm-dd
								</td>
							</tr>
							<tr>
								<td height="24" bgcolor="#FFFFFF">
									职务
								</td>
								<td height="24" bgcolor="#FFFFFF">
									<select name="staff.e_titleid" id="job_id" onChange="showSal()">
										<option value="">
											请选择职务
										</option>
										<!-- 循环输出所有的职务option -->
										<c:forEach items="${requestScope.tlist }" var="title">
											<option value="${title.getT_id()}">${title.getT_name()}</option>
										</c:forEach>
									</select>
									<c:forEach items="${requestScope.tlist }" var="title">
								    <input type="hidden" name="min${title.getT_id()}" value="${title.getT_minsalary()}" />
							        <input type="hidden" name="max${title.getT_id()}" value="${title.getT_maxsalary()}" />
								    </c:forEach>

								</td>
							</tr>
							<tr>
								<td height="24" bgcolor="#FFFFFF">
									工资
								</td>
								<td height="24" bgcolor="#FFFFFF">
									<input name="staff.e_salary" type="text" id="salary">
									*
								</td>
							</tr>
							<tr>
								<td height="24" bgcolor="#FFFFFF">
									部门
								</td>
								
								<td height="24" bgcolor="#FFFFFF">
									<select name="staff.e_deptid" id="department_id">
										<option value="">
											请选择部门
										</option>
										<c:forEach items="${requestScope.dlist }" var="dept">
											<option value="${dept.getD_id()}">${dept.getD_name()}</option>
										</c:forEach>
									</select>
								</td>
							</tr>
							<tr>
								<td height="24" colspan="2" align="center" bgcolor="#FFFFFF">
									<input type="submit" name="Submit" value="提交">
									<input type="button" name="Submit2" value="取消"
										onclick="history.back()">
								</td>
							</tr>
						</table>
					</form>
				</td>
			</tr>
		</table>


	</body>
</html>