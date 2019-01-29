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
				<h2 class="pageTitle">${menu.name}</h2>
			</div>
		</div>
	</div>
</section>
<br>
<section id="gallery-1" class="content-block section-wrapper gallery-1">
	<div class="container">
		<div class="row">
			<div id="isotope-gallery-container">

				<c:forEach items="${menu.childMenuContent}" var="content">
					<div
						class="col-md-4 col-sm-6 col-xs-12 gallery-item-wrapper artwork creative">
						<div class="gallery-item">
							<div class="gallery-thumb">
								<img
									src="<c:url value="/attachmentUploadPath/${content.attachment}"/>"
									class="img-responsive" alt="1st gallery Thumb">
								<div class="image-overlay"></div>
								<a
									href="<c:url value="/attachmentUploadPath/${content.attachment}"/>"
									class="gallery-zoom"><i class="fa fa-eye"></i></a>
							</div>
							<div class="editContent" style="margin-top: 2px;" align="center">
								<a type="button" class="btn btn-primary"
									href="${contextPath}/details/${content.childMenuContentId}" ><h5>${content.title}</h5></a>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
</section>































