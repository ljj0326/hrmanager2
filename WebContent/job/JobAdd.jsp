<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
String path=request.getContextPath();
String basepath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<base href="<%=basepath %>">
		<title>增加新职务</title>
		<link rel="stylesheet" type="text/css" href="../css/style.css">
	  <script type="text/javascript">
	  function checksalary() {
		  
		   //获得最高工资和最低工资
		   var maxsal=document.getElementById("max_salary").value;
		   var minsal=document.getElementById("min_salary").value;
		   alert(maxsal>minsal);
		   //判断
		   if(minsal<maxsal){
			   //添加
			   window.confirm("确定提交数据");
			   //form表单提交
			   document.form1.submit();
		   }else{
			   alert("最高工资需要大于最低工资");
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
					<form name="form1" method="post" action="title/title!insertTitleFun">
						<table width="500" border="0" cellpadding="5" cellspacing="1"
							bgcolor="#CCCCCC">
							<tr>
								<td height="24" colspan="2" align="center" bgcolor="#FFCC00">
									请填写新职务类型信息
								</td>
							</tr>
			
							<tr>
								<td height="24" bgcolor="#FFFFFF">
									职务名称
								</td>
								<td height="24" bgcolor="#FFFFFF">
									<input name="title.t_name" type="text" id="job_title">
									*
								</td>
							</tr>
							<tr>
								<td height="24" bgcolor="#FFFFFF">
									最低工资
								</td>
								<td height="24" bgcolor="#FFFFFF">
									<input name="title.t_minsalary" type="text" id="min_salary">
									*
								</td>
							</tr>
							<tr>
								<td height="24" bgcolor="#FFFFFF">
									最高工资
								</td>
								<td height="24" bgcolor="#FFFFFF">
									<input name="title.t_maxsalary" type="text" id="max_salary">
									*
								</td>
							</tr>
							<tr>
								<td height="24" colspan="2" align="center" bgcolor="#FFFFFF">
									<input type="button" name="Submit" value="提交" onclick="checksalary()">
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