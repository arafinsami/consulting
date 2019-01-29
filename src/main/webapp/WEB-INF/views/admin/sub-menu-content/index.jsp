
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
					href="${contextPath}/admin/sub-menu-content/create">Create
					Content</a>
			</div>
			<!-- /.panel-heading -->
			<div class="panel-body">
				<table class="table">
					<thead>
						<tr>
							<th width="20%">Page Name</th>
							<th width="20%">Sub Menu Name</th>
							<th width="40%">Attachment</th>
							<th width="20%">Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${ChildMenuContents.getContent()}"
							var="ChildMenuContent" varStatus="loop">
							<tr>
								<td>${ChildMenuContent.title}</td>

								<td>${ChildMenuContent.menu.name}</td>
								<td><img
									src="<c:url value="/attachmentUploadPath/${ChildMenuContent.attachment}"/>"
									style="width: 100px; height: 80px;"></td>
								<td><a type="button" class="btn btn-primary"
									href="${contextPath}/admin/sub-menu-content/create/${ChildMenuContent.childMenuContentId}">Edit</a>
									&nbsp;&nbsp; <a type="button" class="btn btn-danger"
									href="${contextPath}/admin/sub-menu-content/delete/${ChildMenuContent.childMenuContentId}"
									onclick="return confirm('Are you sure you want to delete?');">Delete</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<div class="col-md-4 col-md-offset-4">
					<ul class="pagination">
						<li><a
							href="${contextPath}/admin/sub-menu-content/index?page=${ChildMenuContents.previousPageable().getPageNumber()}">Previous</a></li>
						<li><a
							href="${contextPath}/admin/sub-menu-content/index?page=${ChildMenuContents.nextPageable().getPageNumber()}">Next</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
</div>





