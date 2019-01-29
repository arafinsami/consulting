<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<section id="inner-headline">
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<h2 class="pageTitle">${childMenuContent.title}</h2>
			</div>
		</div>
	</div>
</section>
<section id="content">
	<div class="container content">
		<!-- Service Blcoks -->
		<div class="row">
			<div class="col-md-12">
				<div class="about-logo">
					<p>${childMenuContent.description}</p>
				</div>
			</div>
		</div>
		<div class="row service-v1 margin-bottom-40">
			<div class="col-md-4 md-margin-bottom-40">
				<div class="card small">
					<div class="card-image">
						<img class="img-responsive" src="<c:url value="/attachmentUploadPath/${childMenuContent.attachment}"/>" alt="">
					</div>
				</div>
			</div>
		</div>
	</div>
</section>









