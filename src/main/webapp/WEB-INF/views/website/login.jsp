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
				<h2 class="pageTitle">Login</h2>
			</div>
		</div>
	</div>
</section>
<section id="content">
	<div class="container">
		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<p></p>
				<form:form method="post" role="form" modelAttribute="user"
					action="${contextPath}/login" class="form-horizontal">
					<div class="form-group">
						<div class="col-sm-9">
							<form:input type="text" class="form-control" path="username"
								placeholder="User Name" />
							<form:errors path="username" class="form-control" required="required" style="color:red"/>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-9">
							<form:input type="password" class="form-control" path="password"
								placeholder="Password" />
							<form:errors path="password" class="form-control" required="required" style="color:red"/>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-9">
							<button type="submit" class="btn btn-primary btn-block">&nbsp;
								Login &nbsp;</button>
						</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>
</section>

