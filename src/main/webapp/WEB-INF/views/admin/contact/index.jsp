
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
			<div class="panel-heading">All Contacts</div>
			<div class="panel-body">
				<table class="table">
					<thead>
						<tr>
							<th width="15%">Name</th>
							<th width="15%">Email</th>
							<th width="55%">Message</th>
							<th width="15%">Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${contacts.getContent()}" var="contact"
							varStatus="loop">
							<tr>
								<td>${contact.name}</td>
								<td>${contact.email}</td>
								<td>${contact.message}</td>
								<td><a type="button" class="btn btn-danger"
									href="${contextPath}/admin/contact/delete/${contact.contactId}"
									onclick="return confirm('Are you sure you want to delete?');">Delete</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<div class="col-md-4 col-md-offset-4">
					<ul class="pagination">
						<li><a
							href="${contextPath}/admin/contact/index?page=${contacts.previousPageable().getPageNumber()}">Previous</a></li>
						<li><a
							href="${contextPath}/admin/contact/index?page=${contacts.nextPageable().getPageNumber()}">Next</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
</div>