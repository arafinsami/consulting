<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Create Menu</h1>
		<a type="button" class="btn btn-success"
			href="${contextPath}/admin/menu/index">Back To Menu List</a>
	</div>
</div>
<br>
<div class="row">
<br>
	<div class="col-lg-6">
		<form:form role="form" modelAttribute="menu" method="post"
			action="${contextPath}${action}"
			enctype="multipart/form-data">
			<div class="input-field">
				<form:input type="text" class="form-control" path="name"
					placeholder="Menu Name" required="required"/>
			</div>
			<br>
			<button type="submit"
				class="btn btn-primary btn-block">Create</button>
		</form:form>
	</div>
</div>























