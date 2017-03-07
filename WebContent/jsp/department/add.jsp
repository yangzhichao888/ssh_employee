<%@ page contentType="text/html; charset=UTF-8" %>

<!-- 引入Struts标签库 -->
<%@ taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE HTML>
<html>
<head></head>
<body>
<table border="0" width="600px">
<tr>
<td align="center" style="font-size:24px; color:#666">添加部门</td>
</tr>
<tr>
<td align="right" > 
<a href="javascript:document.getElementById('saveForm').submit()">确定</a> &nbsp;&nbsp;
<a href="javascript:history.go(-1)">取消</a>
</td>
</tr>
</table>
<br/>
 <br>
 <s:form id = "saveForm" action ="department_save" method = "post" namespace = "/" theme = "simple">
	<table style="font-size::16px">
		<tr>
		  <td>部门名称</td>
		  <td><s:textfield name = "dname" /></td>
		</tr>
		<tr>
		  <td>部门介绍</td>
		  
		</tr>
		<tr>
		  <td width="10%"></td>
		  <td>
		     <s:textarea rows = "5" cols = "50" name = "ddesc"></s:textarea>
		  </td>
		</tr>
	</table>
</s:form>
</body>
</html> 