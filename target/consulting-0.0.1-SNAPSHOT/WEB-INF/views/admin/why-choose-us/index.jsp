
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
					href="${contextPath}/admin/why-choose-us/create">Create why
					choose us</a>
			</div>
			<div class="panel-body">
				<table class="table">
					<thead>
						<tr>
							<th width="30%">Title</th>
							<th width="40%">Description</th>
							<th width="10%">Attachment</th>
							<th width="20%">Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${chooses}" var="choose">
							<tr>
								<td>${choose.description}</td>
								<td><img
									src="<c:url value="/whyChooseUsUploadPath/${choose.attachment}"/>"
									style="width: 100px; height: 80px;"></td>
								<td><a type="button" class="btn btn-danger"
									href="${contextPath}/admin/why-choose-us/delete/${choose.chooseId}"
									onclick="return confirm('Are you sure you want to delete?');">Delete</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>

