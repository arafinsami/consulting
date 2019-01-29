
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />



<div class="row">
<br>
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">
				<a type="button" class="btn btn-success"
					href="${contextPath}/admin/gallery-content/create">Create
					Gallery Contents</a>
			</div>
			<!-- /.panel-heading -->
			<div class="panel-body">
				<table class="table">
					<thead>
						<tr>
							<th>Menu Name</th>
							<th>Gallery Name</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${galleryContents.getContent()}"
							var="galleryContent" varStatus="loop">
							<tr>
								<td>${galleryContent.title}</td>
								<td>${galleryContent.gallery.name}</td>
								<td><img
									src="<c:url value="/galleryContentUploadPath/${galleryContent.attachment}"/>"
									style="width: 100px; height: 80px;"></td>
								<td><a type="button" class="btn btn-primary"
									href="${contextPath}/admin/gallery-content/create/${galleryContent.galleryContentId}">Edit</a>
									&nbsp;&nbsp; <a type="button" class="btn btn-danger"
									href="${contextPath}/admin/gallery-content/delete/${galleryContent.galleryContentId}"
									onclick="return confirm('Are you sure you want to delete?');">Delete</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<div class="col-md-4 col-md-offset-4">
					<ul class="pagination">
						<li><a
							href="${contextPath}/admin/gallery-content/index?page=${galleryContents.previousPageable().getPageNumber()}">Previous</a></li>
						<li><a
							href="${contextPath}/admin/gallery-content/index?page=${galleryContents.nextPageable().getPageNumber()}">Next</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
</div>

