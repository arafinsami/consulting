<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>${title}</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta name="description" content="" />
<meta name="author" content="http://webthemez.com" />
<!-- css -->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<jsp:include page="/WEB-INF/views/website/common/css.jsp" />

<script>
	window.menu = '${title}';
	window.contextRoot = '${contextRoot}'
</script>
</head>
<body>
	<div id="wrapper" class="home-page">
		<jsp:include page="/WEB-INF/views/website/common/header.jsp" />
		<jsp:include page="/WEB-INF/views/website/${pages}.jsp" />
		<jsp:include page="/WEB-INF/views/website/common/footer.jsp" />
	</div>
	<a href="#" class="scrollup waves-effect waves-dark"><i
		class="fa fa-angle-up active"></i></a>
	<jsp:include page="/WEB-INF/views/website/common/script.jsp" />
	
	<script type="text/javascript">
	
	$(function() {

		switch (menu) {

		case 'About':
			$('#about').addClass('active');
			break;
		case 'Contact Us':
			$('#contact').addClass('active');
			break;
		case 'Services':
			$('#services').addClass('active');
			break;
		case 'Gallery':
			$('#gallery').addClass('active');
			break;
		case 'Home':
			$('#home').addClass('active');
			break;
		default:
			$('#home').addClass('active');
			break;
		}

			
	});
	</script>
</body>
</html>


