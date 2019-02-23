
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
					href="${contextPath}/admin/service/create">Create Our Service</a>
			</div>
			<div class="panel-body">
				<table width="100%"
					class="table table-striped table-bordered table-hover"
					id="dataTables-example">
					<thead>
						<tr>
							<!-- <th>Title</th> -->
							<th>Attachment</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${ourServices.getContent()}" var="ourService"
							varStatus="loop">
							<tr>
								<%-- <td>${ourService.title}</td> --%>
								<td><img
									src="<c:url value="/ourServicesUploadPath/${ourService.attachment}"/>"
									style="width: 100px; height: 80px;"></td>
								<td><a type="button" class="btn btn-primary"
									href="${contextPath}/admin/service/create/${ourService.ourServiceId}">Edit</a>
									&nbsp;&nbsp; <a type="button" class="btn btn-danger"
									href="${contextPath}/admin/service/delete/${ourService.ourServiceId}"
									onclick="return confirm('Are you sure you want to delete?');">Delete</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<div class="col-md-4 col-md-offset-4">
					<ul class="pagination">
						<li><a
							href="${contextPath}/admin/service/index?page=${ourServices.previousPageable().getPageNumber()}">Previous</a></li>
						<li><a
							href="${contextPath}/admin/service/index?page=${ourServices.nextPageable().getPageNumber()}">Next</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
</div>

