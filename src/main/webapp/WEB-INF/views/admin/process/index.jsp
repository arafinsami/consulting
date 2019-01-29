
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
			<a type="button" class="btn btn-success" href="${contextPath}/admin/process/create">Create Our Process</a>
			</div>
			<div class="panel-body">
				<table class="table">
					<thead>
						<tr>
							<th>Our Process</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${ourProcesses.getContent()}" var="ourProcess"
							varStatus="loop">
							<tr>
								<td>${ourProcess.title}</td>
								<td><img
									src="<c:url value="/ourProcessUploadPath/${ourProcess.attachment}"/>"
									style="width: 100px; height: 80px;"></td>
								<td>
									<a type="button" class="btn btn-primary" href="${contextPath}/admin/process/create/${ourProcess.ourProcessId}">Edit</a>
									&nbsp;&nbsp;
									<a type="button" class="btn btn-danger" href="${contextPath}/admin/process/delete/${ourProcess.ourProcessId}" 
									onclick="return confirm('Are you sure you want to delete?');">Delete</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<div class="col-md-4 col-md-offset-4">
					<ul class="pagination">
						<li><a
							href="${contextPath}/admin/process/index?page=${ourProcess.previousPageable().getPageNumber()}">Previous</a></li>
						<li><a
							href="${contextPath}/admin/process/index?page=${ourProcess.nextPageable().getPageNumber()}">Next</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
</div>



