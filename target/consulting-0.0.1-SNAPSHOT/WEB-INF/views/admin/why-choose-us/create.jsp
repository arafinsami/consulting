<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Create Gallery</h1>
		<a type="button" class="btn btn-success"
			href="${contextPath}/admin/why-choose-us/index">Back To Gallery List</a>
	</div>
</div>
<br>
<div class="row">
<br>
	<div class="container">
		<div class="col-lg-8">
			<form:form role="form" modelAttribute="chooseUs" method="post"
				action="${contextPath}${action}"
				enctype="multipart/form-data">
				<div class="input-field">
					<form:input type="text" class="form-control" path="description"
						placeholder="Description" />
				</div>
				<br>
				<div class="input-field">
					<label for="file-upload" class="custom-file-upload">
					    <i class="fa fa-cloud-upload"></i> Theme Upload
					</label>
					<input id="file-upload" type="file" name="chooseUsUpload"/>
				</div>
				<button type="submit"
					class="btn btn-primary btn-block">Create</button>
				<br />
			</form:form>
		</div>
	</div>
</div>


<script>
	CKEDITOR.replace('editor1');
</script>





















