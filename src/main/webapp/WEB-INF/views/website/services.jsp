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
				<h2 class="pageTitle">Services</h2>
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
					<h3>
						Our Best <span class="color">Services</span>
					</h3>
					<p>Sed ut perspiciaatis unde omnis iste natus error sit
						voluptatem accusantium doloremque laudantium, totam rem aperiam,
						eaque ipsa quae ab illo inventore veritatis et quasi architecto
						beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia
						voluptas</p>
					<p>Sed ut perspiciaatis unde omnis iste natus error sit
						voluptatem accusantium doloremque laudantium, totam rem aperiam,
						eaque ipsa quae ab illo inventore veritatis et quasi architecto
						beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia
						voluptas</p>
				</div>
			</div>
		</div>

		<!-- Info Blcoks -->
		<div class="row">
			<div class="col-sm-4 info-blocks">
				<i class="icon-info-blocks fa fa-bell-o"></i>
				<div class="info-blocks-in">
					<h3>Awesome Design</h3>
					<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
						Dolores quae porro consequatur aliquam, incidunt</p>
				</div>
			</div>
			<div class="col-sm-4 info-blocks">
				<i class="icon-info-blocks fa fa-hdd-o"></i>
				<div class="info-blocks-in">
					<h3>FontAwesome</h3>
					<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
						Dolores quae porro consequatur aliquam, incidunt</p>
				</div>
			</div>
			<div class="col-sm-4 info-blocks">
				<i class="icon-info-blocks fa fa-lightbulb-o"></i>
				<div class="info-blocks-in">
					<h3>Bootstrap</h3>
					<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
						Dolores quae porro consequatur aliquam, incidunt</p>
				</div>
			</div>
		</div>
		<!-- End Info Blcoks -->


		<!-- Info Blcoks -->
		<div class="row">
			<div class="col-sm-4 info-blocks">
				<i class="icon-info-blocks fa fa-code"></i>
				<div class="info-blocks-in">
					<h3>SEO Ready</h3>
					<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
						Dolores quae porro consequatur aliquam, incidunt</p>
				</div>
			</div>
			<div class="col-sm-4 info-blocks">
				<i class="icon-info-blocks fa fa-compress"></i>
				<div class="info-blocks-in">
					<h3>Fully Responsive</h3>
					<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
						Dolores quae porro consequatur aliquam, incidunt</p>
				</div>
			</div>
			<div class="col-sm-4 info-blocks">
				<i class="icon-info-blocks fa fa-html5"></i>
				<div class="info-blocks-in">
					<h3>CSS3 + HTML5</h3>
					<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
						Dolores quae porro consequatur aliquam, incidunt</p>
				</div>
			</div>
		</div>
		<!-- End Info Blcoks -->
		<div class="row service-v1 margin-bottom-40">
			<div class="col-md-4 md-margin-bottom-40">
				<div class="card small">
					<div class="card-image">
						<img class="img-responsive" src="<c:url value="/resources/img/service1.jpg"/>" alt=""> <span
							class="card-title">Material Design</span>
					</div>
					<div class="card-content">
						<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
							Dolores quae porro consequatur aliquam, incidunt</p>
						<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
							Dolores quae porro consequatur aliquam, incidunt</p>
					</div>
				</div>
			</div>
			<div class="col-md-4 md-margin-bottom-40">
				<div class="card small">
					<div class="card-image">
						<img class="img-responsive" src="<c:url value="/resources/img/service2.jpg"/>" alt=""> <span
							class="card-title">Bootstrap</span>
					</div>
					<div class="card-content">
						<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
							Dolores quae porro consequatur aliquam, incidunt</p>
						<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
							Dolores quae porro consequatur aliquam, incidunt</p>
					</div>
				</div>
			</div>
			<div class="col-md-4 md-margin-bottom-40">
				<div class="card small">
					<div class="card-image">
						<img class="img-responsive" src="<c:url value="/resources/img/service3.jpg"/>" alt=""> <span
							class="card-title">HTML5/CSS3</span>
					</div>
					<div class="card-content">
						<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
							Dolores quae porro consequatur aliquam, incidunt</p>
						<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
							Dolores quae porro consequatur aliquam, incidunt</p>
					</div>
				</div>
			</div>
		</div>
		<!-- End Service Blcoks -->
	</div>
</section>

