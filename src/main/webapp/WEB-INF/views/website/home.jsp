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
			<c:forEach items="${chooses}" var="choose">
				<div class="col-md-6 col-sm-6">
					<div class="about-text">
						<div class="section-title text-left">
							<h2 style="color: rgba(255, 8, 0, .78)">
								${choose.title}
							</h2>
						</div>
						<p>${choose.description}.</p>

						<ul class="withArrow">
							<c:forEach items="${choose.chooseUsLists}" var="chooseList">
								<li><span class="fa fa-angle-right"></span>${chooseList.title}</li>
							</c:forEach>
						</ul>
					</div>
				</div>
				<div class="col-md-6 col-sm-6">
					<div class="about-image">
						<img src="<c:url value="/whyChooseUsUploadPath/${choose.attachment}"/>"
							alt="About Images">
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</section>

<section id="content">
	<div class="container">
		<section class="services">
			<c:forEach items="${services}" var="service">
				<div class="row">
					<div class="col-md-12">
						<div class="aligncenter">
							<h2 class="aligncenter" style="color: rgba(255, 8, 0, .78)">
								Our <strong>Services</strong>
							</h2>
							${service.description}
						</div>
						<div class="col-sm-10 col-sm-offset-1">
							<img class="img-responsive" style="height: 400px; width: 1100px;"
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
			<c:forEach items="${processLists}" var="processList">
				<div class="row">
					<div class="col-md-12">
						<div class="aligncenter">
							<h2 class="aligncenter" style="color: rgba(255, 8, 0, .78)">
								Our <strong>Process</strong>
							</h2>
							${processList.description}
						</div>
						<div class="col-sm-10 col-sm-offset-1">
							<img class="img-responsive" style="height: 400px; width: 1100px;"
								src="<c:url value="/ourProcessUploadPath/${processList.attachment}"/>"
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
			<c:forEach items="${businessLists}" var="businessList">
				<div class="row">
					<div class="col-md-12">
						<div class="aligncenter">
							<h2 class="aligncenter" style="color: rgba(255, 8, 0, .78)">
								Our <strong>Business</strong>
							</h2>
							${businessList.description}
						</div>
						<div class="col-sm-10 col-sm-offset-1">
							<img class="img-responsive" style="height: 400px; width: 1100px;"
								src="<c:url value="/ourBusinessUploadPath/${businessList.attachment}"/>"
								alt="Business Image">
						</div>
					</div>
				</div>
			</c:forEach>
		</section>
	</div>
</section>

