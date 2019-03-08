<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />


<div class="navbar-default sidebar" role="navigation">
	<div class="sidebar-nav navbar-collapse">
		<ul class="nav" id="side-menu">
			<li class="sidebar-search">
				<div class="input-group custom-search-form">
					<input type="text" class="form-control" placeholder="Search...">
					<span class="input-group-btn">
						<button class="btn btn-default" type="button">
							<i class="fa fa-search"></i>
						</button>
					</span>
				</div>
			</li>
			<li><a href="#"><i class="fa fa-sitemap fa-fw"></i>
					Other Menus <span class="fa arrow"></span></a>
				<ul class="nav nav-second-level">
				    <li><a href="${contextPath}/admin/why-choose-us/index">Why choose us</a></li>
				    <li><a href="${contextPath}/admin/why-choose-us-title/index">Why choose us-Title</a></li>
					<li><a href="${contextPath}/admin/gallery/index">Gallery</a></li>
					<li><a href="${contextPath}/admin/gallery-content/index">Gallery Contents</a></li>
					<li><a href="${contextPath}/admin/contact/index">Contacts</a></li>
					<li><a href="${contextPath}/admin/process/index">Our Process</a></li>
					<li><a href="${contextPath}/admin/business/index">Our Business</a></li>
					<li><a href="${contextPath}/admin/service/index">Our Service</a></li>
					<li><a href="${contextPath}/admin/team/index">Our Team</a></li>
					<li><a href="${contextPath}/admin/slider/index">Slider</a></li>
				</ul> </li>
			
			<li><a href="#"><i class="fa fa-sitemap fa-fw"></i>
					Menus <span class="fa arrow"></span></a>
				<ul class="nav nav-second-level">
					<li><a href="${contextPath}/admin/menu/index">Menu create</a></li>
					<li><a href="${contextPath}/admin/sub-menu-content/index">Menu Content create</a></li>
				</ul> 
			</li>	
		</ul>
	</div>
</div>


