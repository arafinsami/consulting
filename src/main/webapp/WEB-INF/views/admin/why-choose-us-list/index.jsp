
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
					href="${contextPath}/admin/why-choose-us-list/create">Create why
					choose us List</a>
			</div>
			<div class="panel-body">
				<table class="table">
					<thead>
						<tr>
							<th width="50%">Title</th>
							<th width="25%">Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${chooses}" var="choose">
							<tr>
								<td>${choose.title}</td>
								<td><a type="button" class="btn btn-danger"
									href="${contextPath}/admin/why-choose-us-list/delete/${choose.chooseUsListId}"
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

