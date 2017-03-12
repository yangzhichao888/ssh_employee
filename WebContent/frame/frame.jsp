<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
	<frameset rows="80,*">
	   <frame name="top" src="${pageContext.request.contextPath}/frame/top.jsp">
	   <frameset cols="150,*" id="main">
	
	      <frame  name = "left" src="${pageContext.request.contextPath}/frame/left.jsp"> 
	     <frame name="right" src="${pageContext.request.contextPath}/frame/right.jsp">
	   </frameset>
	</frameset>
</html>