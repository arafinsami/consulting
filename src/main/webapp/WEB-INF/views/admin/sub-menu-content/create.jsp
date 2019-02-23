<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Create Slider</h1>
		<a type="button" class="btn btn-success"
			href="${contextPath}/admin/sub-menu-content/index">Back To List</a>
	</div>
</div>
<br>
<div class="row">
<br>
	<div class="container">
		<div class="col-lg-8">
			<form:form role="form" modelAttribute="childMenuContent"
				method="post" action="${contextPath}${action}"
				enctype="multipart/form-data">

				<div class="input-field">
					<form:select class="form-control selectpicker"
						path="menu.menuId">
						<form:options items="${menus}" itemLabel="name"
							itemValue="menuId" required="required"></form:options>
					</form:select>
				</div>
				<br>
				<div class="input-field">
					<form:input type="text" class="form-control" path="title"
						placeholder="Title" required="required"/>
				</div>
				<br>
				<div class="input-field">
					<%-- <form:textarea type="text" class="form-control" path="description"
						placeholder="Description" required="required" /> --%>
					<form:textarea name="editor1" id="editor1" rows="10" cols="80" path="description"  required="required"/>
				</div>
				<div class="input-field">
					<label for="file-upload" class="custom-file-upload">
					    <i class="fa fa-cloud-upload"></i>Upload File
					</label>
					<input id="file-upload" type="file" name="attachmentUpload"/>
				</div>
				<button type="submit"
				class="btn btn-primary btn-block">Create</button>
			</form:form>
		</div>
	</div>
</div>
<br>
<script>
   CKEDITOR.replace( 'editor1' );
</script>




















