<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<section id="banner">
	<div id="main-slider" class="flexslider">
		<ul class="slides">
			<c:forEach items="${sliders}" var="slider">
				<li><img
					src="<c:url value="/sliderUploadPath/${slider.attachment}"/>"
					alt="" />
					<div class="flex-caption">
						<h3>${slider.subtitle}</h3>
						<p>${slider.title}</p>

					</div></li>
			</c:forEach>
		</ul>
	</div>
</section>

<section class="section-padding whyWe nav-bg">
	<div class="container">
		<div class="row">
			<div class="col-md-6 col-sm-6">
				<div class="about-text">
					<div class="section-title text-left">
						<h2>
							Why <strong>Choose Us</strong>
						</h2>
						<p>
							Curabitur aliquet quam id dui posuere blandit. Donec sollicitudin
							molestie malesuada Pellentesque <br>ipsum id orci porta
							dapibus. Vivamus suscipit tortor eget felis porttitor volutpat.
						</p>
					</div>
					<p>Grids is a responsive Multipurpose Template. Lorem ipsum
						dolor sit amet, consectetur adipiscing elit. Curabitur aliquet
						quam id dui posuere blandit. Donec sollicitudin molestie
						malesuada. Pellentesque in ipsum id orci porta dapibus. Vivamus
						suscipit tortor eget felis porttitor volutpat.</p>

					<ul class="withArrow">
						<li><span class="fa fa-angle-right"></span> Lorem ipsum dolor
							sit amet</li>
						<li><span class="fa fa-angle-right"></span> consectetur
							adipiscing elit</li>
						<li><span class="fa fa-angle-right"></span> Curabitur aliquet
							quam id dui</li>
						<li><span class="fa fa-angle-right"></span> Donec
							sollicitudin molestie malesuada.</li>
					</ul>
					<a href="#" class="btn btn-primary waves-effect waves-dark">Learn
						More</a>
				</div>
			</div>
			<div class="col-md-6 col-sm-6">
				<div class="about-image">
					<img src="<c:url value="/resources/img/about1.jpg"/>"
						alt="About Images">
				</div>
			</div>
		</div>
	</div>
</section>

<section id="content">
	<div class="container">
		<section class="services">
			<div class="row">
				<div class="col-md-12">
					<div class="aligncenter">
						<h2 class="aligncenter">
							Our <strong>Services</strong>
						</h2>
						Lorem ipsum dolor sit amet, consectetur adipisicing elit. Dolores
						quae porro consequatur aliquam, incidunt eius magni provident, <br />doloribus
						omnis minus ovident, doloribus omnis minus temporibus perferendis
						nesciunt..
					</div>
					<br />
				</div>
			</div>

			<c:forEach items="${services}" var="service">
				<div class="row">
					<div class="col-sm-4 info-blocks">
						<div class="info-blocks-in">
							<h3>${service.title}</h3>
							<div class="line"></div>
							<img class="img-responsive"
								src="<c:url value="/ourServicesUploadPath/${service.attachment}"/>"
								alt="">
						</div>
					</div>
				</div>
			</c:forEach>
		</section>
	</div>
</section>
<section id="content">
	<div class="container">
		<section class="services">
			<div class="row">
				<div class="col-md-12">
					<div class="aligncenter">
						<h2 class="aligncenter">
							Our <strong>Process</strong>
						</h2>
						Lorem ipsum dolor sit amet, consectetur adipisicing elit. Dolores
					quae porro consequatur aliquam, incidunt eius magni provident, <br />doloribus
					omnis minus ovident, doloribus omnis minus temporibus perferendis
					nesciunt..
					</div>
					<br />
				</div>
			</div>

			<c:forEach items="${processLists}" var="processList">
				<div class="row">
					<div class="col-sm-4 info-blocks">
						<div class="info-blocks-in">
							<h3>${processList.title}</h3>
							<div class="line"></div>
							<img class="img-responsive"
								src="<c:url value="/ourProcessUploadPath/${processList.attachment}"/>"
								alt=""> <span class="card-title center">${processList.title}</span>
						</div>
					</div>
				</div>
			</c:forEach>
		</section>
	</div>
</section>
<section class="section-padding gray-bg">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="section-title text-center">
					<h2>
						Our <strong>Business</strong>
					</h2>
					<p>
						Curabitur aliquet quam id dui posuere blandit. Donec sollicitudin
						molestie malesuada Pellentesque <br>ipsum id orci porta
						dapibus. Vivamus suscipit tortor eget felis porttitor volutpat.
					</p>
				</div>
			</div>
		</div>
		<c:forEach items="${businessLists}" var="businessList">
			<div class="row">
				<div class="col-md-6 col-sm-6">
					<div class="about-image">
						<img
							src="<c:url value="/ourBusinessUploadPath/${businessList.attachment}"/>"
							alt="About Images">
					</div>
				</div>
				<div class="col-md-6 col-sm-6">
					<div class="about-text">
						<p>${businessList.description}</p>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
</section>







