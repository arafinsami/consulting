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
				<h2 class="pageTitle" style="">Contact Us</h2>
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
						Get<span class="color"> in Touch</span>
					</h3>
					<p>Sed ut perspiciaatis unde omnis iste natus error sit
						voluptatem accusantium doloremque laudantium, totam rem aperiam,
						eaque ipsa quae ab illo inventore veritatis et quasi architecto
						beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia
						voluptas</p>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<p></p>
				<form:form role="form" modelAttribute="contact" method="post"
					action="${contextPath}${action}">
					<div class="input-field">
						<form:input type="text" class="form-control" path="name"
							placeholder="Name"/>
						<form:errors path="name" class="form-control" required="required" style="color:red"/>
					</div>
					<div class="input-field">
						<form:input type="email" class="form-control" path="email"
							placeholder="Email" required="required" />
						<form:errors path="email" class="form-control" required="required" style="color:red"/>
					</div>
					<div class="input-field">
						<form:input type="text" class="form-control" path="phoneNumber"
							placeholder="Phone Number"/>
						<form:errors path="name" class="form-control" required="required" style="color:red"/>
					</div>
					<div class="input-field">
						<form:textarea type="text" class="form-control" path="message"
							placeholder="Message" required="required" />
						<form:errors path="Message" class="form-control" required="required" style="color:red"/>
					</div>
					<button type="submit"
						class="btn btn-primary waves-effect waves-dark pull-right">Submit</button>
					<br />
				</form:form>
			</div>
		</div>
	</div>
</section>







