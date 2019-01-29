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
				<h2 class="pageTitle">Portfolio</h2>
			</div>
		</div>
	</div>
</section>
<section id="content">
	<div class="container">

		<div class="row">
			<div class="col-md-12">
				<div class="about-logo">
					<h3>
						Our <span class="color">Team</span>
					</h3>
					<p>Sed ut perspiciaatis unde omnis iste natus error sit
						voluptatem accusantium doloremque laudantium, totam rem aperiam,
						eaque ipsa quae ab illo inventore veritatis et quasi architecto
						beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia
						voluptas</p>
				</div>
			</div>
		</div>

	</div>
</section>
<!-- Start Gallery 1-2 -->
<section id="gallery-1" class="content-block section-wrapper gallery-1">
	<div class="container">

		<!-- <div class="editContent">
			<ul class="filter">
				<li class="active"><a href="#" data-filter="*">All</a></li>
				<li><a class="waves-effect waves-dark" href="#"
					data-filter=".artwork">Artwork</a></li>
				<li><a class="waves-effect waves-dark" href="#"
					data-filter=".creative">Creative</a></li>
				<li><a class="waves-effect waves-dark" href="#"
					data-filter=".nature">Nature</a></li>
				<li><a class="waves-effect waves-dark" href="#"
					data-filter=".outside">Outside</a></li>
				<li><a class="waves-effect waves-dark" href="#"
					data-filter=".photography">Photography</a></li>
			</ul>
		</div> -->
		<!-- /.gallery-filter -->

		<div class="row">
			<div id="isotope-gallery-container">

				<c:forEach items="${ourTeams}" var="ourTeam">
					<div
						class="col-md-4 col-sm-6 col-xs-12 gallery-item-wrapper artwork creative">
						<div class="gallery-item">
							<div class="gallery-thumb">
								<img
									src="<c:url value="/teamUploadPath/${ourTeam.attachment}"/>"
									class="img-responsive" alt="1st gallery Thumb">
								<div class="image-overlay"></div>
								<a href="<c:url value="/teamUploadPath/${ourTeam.attachment}"/>"
									class="gallery-zoom"><i class="fa fa-eye"></i></a>
							</div>
							<div class="gallery-details">
								<div class="editContent">
									<h5>${ourTeam.title}</h5>
								</div>
								<div class="editContent">
									<p>${ourTeam.description}</p>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
			<!-- /.isotope-gallery-container -->
		</div>
		<!-- /.row -->
		<!-- /.container -->
	</div>
</section>
<!--// End Gallery 1-2 -->

