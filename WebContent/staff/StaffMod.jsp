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
<base href="<%=basepath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>修改员工</title>
<link rel="stylesheet" type="text/css" href="../css/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=gbk">

<script type="text/javascript" src="../inc/Calendar1.inc"></script>

<script type="text/javascript">
	//显示对应职务的最低和最高工资
	function showSal() {
		//获得职务表单元素对象
		var job_id = document.form1.job_id;
		//显示最低工资和最高工资
		if (job_id.value != "") {
			document.form1.min_salary.value = eval("document.form1.min"
					+ job_id.value + ".value");
			document.form1.max_salary.value = eval("document.form1.max"
					+ job_id.value + ".value");
		} else {
			document.form1.min_salary.value = "";
			document.form1.max_salary.value = "";
		}
	}
	
	  function checksalary() {
		  
		   //获得最高工资和最低工资
		   var mysalary=document.getElementById("salary").value;
		   var maxsal=document.getElementById("max_salary").value;
		   var minsal=document.getElementById("min_salary").value;
		   alert(mysalary+"---"+maxsal+"---"+minsal);
		   //判断
		   if(mysalary>=minsal&&mysalary<=maxsal){
			   //添加
			   confirm("确定提交数据");
			   documwnt.form1.submit();
		   }else if(mysalary<minsal){
			   alert("工资不能小于最低工资");
		   }else if(mysalary>maxsal){
			   alert("工资不能大于最高工资");
		   }else{
			   alert("出现问题");
		   }
		
	}
</script>
</head>

<body onLoad="showSal()">

	<table border="0" width="950" height="350" bgcolor="#ffffff"
		align="center">
		<tr>
			<td align="center" valign="top">
				<form name="form1" method="post" action="staff/staff!updateStaffFun">
					<table width="500" border="0" cellpadding="5" cellspacing="1"
						bgcolor="#CCCCCC">
						<tr>
							<td height="24" colspan="2" align="center" bgcolor="#FFCC00">
								请修改员工信息</td>
						</tr>
						<tr>
							<td width="120" height="24" bgcolor="#FFFFFF">员工姓名</td>
							<td width="357" height="24" bgcolor="#FFFFFF"><input
								name="staff.e_name" type="text" id="empname" value="${requestScope.staff.getE_name() }">
								*</td>
						</tr>
						<tr>
							<td height="24" bgcolor="#FFFFFF">邮箱地址</td>
							<td height="24" bgcolor="#FFFFFF"><input name="staff.e_mail"
								type="text" id="email" value="${requestScope.staff.getE_mail() }"> *</td>
						</tr>
						<tr>
							<td height="24" bgcolor="#FFFFFF">电话号码</td>
							<td height="24" bgcolor="#FFFFFF"><input name="staff.e_tel"
								type="text" id="phone_number" value="${requestScope.staff.getE_tel() }">
								例如123.456.789</td>
						</tr>
						<tr>
							<td height="24" bgcolor="#FFFFFF">入职日期</td>
							<td height="24" bgcolor="#FFFFFF"><input
								name="staff.e_starttime" type="text" id="hire_date"
								value="${requestScope.staff.getE_starttime() }" onfocus="calendar()"> yyyy-mm-dd</td>
						</tr>
						<tr>
							<td height="24" bgcolor="#FFFFFF">职务</td>
							<td height="24" bgcolor="#FFFFFF">
							<select name="staff.e_titleid" id="job_id" onChange="showSal()">
								<c:forEach items="${requestScope.tlist }" var="title">
								${title.getT_id() eq requestScope.staff.getE_titleid()}
								   <c:if test="${title.getT_id() eq requestScope.staff.getE_titleid()}">
									 <option selected="selected" value="${title.getT_id()}">${title.getT_name()}</option>
									</c:if>
									 <c:if test="${title.getT_id() ne requestScope.staff.getE_titleid()}">
									    <option  value="${title.getT_id()}">${title.getT_name()}</option>
									</c:if>
								</c:forEach>
							</select><br>
							 <!-- 隐藏表单元素：存储每种职务的最低和最高工资 --> 
							 <c:forEach items="${requestScope.tlist }" var="title">
								    <input type="hidden" name="min${title.getT_id()}" value="${title.getT_minsalary()}" />
							        <input type="hidden" name="max${title.getT_id()}" value="${title.getT_maxsalary()}" />
								</c:forEach>
							工资范围 <br>
							<input name="min_salary" type="text" id="min_salary" size="10" readonly>
						  ~ <input name="max_salary" type="text" id="max_salary" size="10" readonly></td>
						</tr>
						<tr>
							<td height="24" bgcolor="#FFFFFF">工资</td>
							<td height="24" bgcolor="#FFFFFF"><input name="staff.e_salary"
								type="text" id="salary" value="${requestScope.staff.getE_salary() }"> *</td>
						</tr>
						<tr>
							<td height="24" bgcolor="#FFFFFF">部门</td>
							<td height="24" bgcolor="#FFFFFF"><select
								name="staff.e_deptid" id="department_id">
									<option value="">请选择部门</option>
									<!-- 循环输出所有的部门的option -->
									<c:forEach items="${requestScope.dlist }" var="dept">
											<option value="${dept.getD_id()}">${dept.getD_name()}</option>
									</c:forEach>
							</select></td>
						</tr>
						<tr>
							<td height="24" colspan="2" align="center" bgcolor="#FFFFFF">
								<input type="button" name="Submit" value="更新" onclick="checksalary()">
								<input type="button" name="Submit2" value="取消"
								onclick="history.back()"> <input name="staff.e_id"
								type="hidden" id="employee_id" value="${requestScope.staff.getE_id() }">
							</td>
						</tr>
					</table>
				</form>
			</td>
		</tr>
	</table>
</body>
</html>