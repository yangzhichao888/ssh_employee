<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
<style type="text/css">
        .table1{
            border:1px solid #ddd;
            width:900px;
            
        }
        thead{
            background-color:lightblue;
        }

    </style>
</head>
<body>
<table border="0" width="900px">
<tr>
<td align="center" style="font-size:24px; color:#999">部门管理</td>

<td>
	<a href="${pageContext.request.contextPath}/department_saveUI.action"><img src="${pageContext.request.contextPath}/images/join.gif" /></a>
</td>
</tr>
</table>

<br/>

<table cellspacing="0" border="1" class="table1">
<thead>
   <tr>
	   <th width="450">部门名称</th>
	   <th  width="450">编辑</th>
	   <th  width="450">删除</th>
   </tr>
</thead>
	<s:iterator value = "list" var = "d">
<tbody>

		<tr>
			<td align="center"><s:property value = "#d.dname"/></td>
			<td align="center"><a href="${pageContext.request.contextPath}/department_edit.action?did=<s:property value="#d.did"/>"><img src="${pageContext.request.contextPath}/images/bianji.png" alt="编辑"></a></td>
			<td align="center"><a href="${pageContext.request.contextPath}/department_delete.action?did=<s:property value="#d.did"/>"><img src="${pageContext.request.contextPath}/images/trash.gif" alt="删除"></a></td>
		</tr>

</tbody>
	</s:iterator>
</table>
<br/>


<table border="0" cellspacing="0" cellpadding="0"  width="900px">
<tr>
<td align="right">
   <span> 第<s:property value = "currPage"/> / <s:property value = "totalPage"/>页</span>
   <span>
   <s:if test="currPage != 1" >
       <a href="${pageContext.request.contextPath}/department_findAll.action?currPage=1">首页</a>&nbsp;&nbsp;
       <a href="${pageContext.request.contextPath}/department_findAll.action?currPage=<s:property value = "currPage-1"/>">上一页</a>&nbsp;&nbsp;
    </s:if>
    
    <s:if test="currPage != totalPage" >
       <a href="${pageContext.request.contextPath}/department_findAll.action?currPage=<s:property value = "currPage+1"/>">下一页</a>&nbsp;&nbsp;
       <a href="${pageContext.request.contextPath}/department_findAll.action?currPage=<s:property value = "totalPage"/>">尾页</a>&nbsp;&nbsp;
     </s:if>
   </span>
</td>
</tr>
</table>
</body>
</html>