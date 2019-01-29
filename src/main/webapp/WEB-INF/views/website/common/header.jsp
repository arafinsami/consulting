<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!-- start header -->
<header>
	<div class="navbar navbar-default navbar-static-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="${contextPath}/"><i
					class="icon-info-blocks material-icons">language</i></a>
			</div>
			<div class="navbar-collapse collapse ">
				<ul class="nav navbar-nav">
					<li><a class="waves-effect waves-dark"
						href="${contextPath}/">Home</a></li>
					<c:forEach items="${menus}" var="menu">
						<li class="dropdown">
						  <a href="#"
						    data-toggle="dropdown"
						    class="dropdown-toggle waves-effect waves-dark">${menu.name}
						  <b class="caret"></b>
						  </a>
						  <ul class="dropdown-menu">
						    <c:forEach items="${menu.childMenuContents}" var="childMenuContent">
							    <li>
							       <a class="waves-effect waves-dark"
							      href="${contextPath}/details/${childMenuContent.childMenuContentId}">${childMenuContent.title}</a>
							    </li>
						    </c:forEach>
						  </ul>
						</li>
					</c:forEach>
					<li><a class="waves-effect waves-dark"
						href="${contextPath}/contact">Contact</a>
					</li>
					<li class="dropdown" id="about"><a href="#"
						data-toggle="dropdown"
						class="dropdown-toggle waves-effect waves-dark">Media & Publications <b
							class="caret"></b></a>
						<ul class="dropdown-menu">
							<%-- <li><a class="waves-effect waves-dark"
								href="${contextPath}/about">Our Team</a></li>
							<li><a class="waves-effect waves-dark"
								href="${contextPath}/services">Our Services</a></li> --%>
							<li><a class="waves-effect waves-dark"
								href="${contextPath}/gallery">Gallery</a></li>
							<li><a class="waves-effect waves-dark"
								href="${contextPath}/gallery">Gallery</a></li>
						</ul>
					</li>
				</ul>
			</div>
		</div>
	</div>
</header>



