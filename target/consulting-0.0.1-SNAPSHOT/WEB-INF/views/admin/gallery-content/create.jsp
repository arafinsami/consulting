<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Create Gallery Content</h1>
		<a type="button" class="btn btn-success"
			href="${contextPath}/admin/gallery-content/index">Back To Gallery
			Content List</a>
	</div>
</div>
<br>
<div class="row">
<br>
	<div class="container">
		<div class="col-lg-8">
			<form:form role="form" modelAttribute="galleryContent" method="post"
				action="${contextPath}${action}" enctype="multipart/form-data">

				<div class="input-field">
					<form:select class="form-control selectpicker"
						path="gallery.galleryId">
						<form:options items="${galleries}" itemLabel="name"
							itemValue="galleryId" required="required"></form:options>
					</form:select>
				</div>
				<br>
				<div class="input-field">
					<form:input type="text" class="form-control" path="title"
						placeholder="Title" />
				</div>
				<br>
				<div class="input-field">
					<form:textarea name="editor1" id="editor1" rows="10" cols="80"
						path="description" />
				</div>
				<br>
				<div class="input-field">
					<label for="file-upload" class="custom-file-upload"> <i
						class="fa fa-cloud-upload"></i> File Upload
					</label> <input id="file-upload" type="file" name="galleryContent" />
				</div>
				<button type="submit" class="btn btn-primary btn-block">Create</button>
				<br />
			</form:form>
		</div>
	</div>
</div>


<script>
	CKEDITOR.replace('editor1');
</script>





















