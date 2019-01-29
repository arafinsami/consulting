<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>${title}</title>
<jsp:include page="/WEB-INF/views/admin/common/css.jsp" />
<jsp:include page="/WEB-INF/views/admin/common/script.jsp" />

</head>

<body>

	<div id="wrapper">
		<!-- Navigation -->
		<nav class="navbar navbar-default navbar-static-top" role="navigation"
			style="margin-bottom: 0">
			<jsp:include page="/WEB-INF/views/admin/common/header.jsp" />
			<jsp:include page="/WEB-INF/views/admin/common/left-sidebar.jsp" />
		</nav>
		<div id="page-wrapper">
			<jsp:include page="/WEB-INF/views/admin/${pages}.jsp" />
		</div>
		<!-- /#page-wrapper -->
	</div>
	<!-- /#wrapper -->
</body>

</html>



