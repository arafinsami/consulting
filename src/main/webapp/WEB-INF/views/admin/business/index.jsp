
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
					href="${contextPath}/admin/business/create">Create Our Business</a>
			</div>
			<div class="panel-body">
				<table class="table">
					<thead>
						<tr>
							<th>Our Business</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${ourBusiness.getContent()}" var="ourBusin"
							varStatus="loop">
							<tr>
								<%-- <td>${ourBusin.title}</td> --%>
								<td><img
									src="<c:url value="/ourBusinessUploadPath/${ourBusin.attachment}"/>"
									style="width: 100px; height: 80px;"></td>
								<td><a type="button" class="btn btn-primary"
									href="${contextPath}/admin/business/create/${ourBusin.ourBusinessId}">Edit</a>
									&nbsp;&nbsp; <a type="button" class="btn btn-danger"
									href="${contextPath}/admin/business/delete/${ourBusin.ourBusinessId}"
									onclick="return confirm('Are you sure you want to delete?');">Delete</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<div class="col-md-4 col-md-offset-4">
					<ul class="pagination">
						<li><a
							href="${contextPath}/admin/business/index?page=${ourBusiness.previousPageable().getPageNumber()}">Previous</a></li>
						<li><a
							href="${contextPath}/admin/business/index?page=${ourBusiness.nextPageable().getPageNumber()}">Next</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
</div>

<script>
	$(document)
			.ready(
					function() {
						var $table = $('#dataTables-example');
						if ($table.length) {
							var jsonUrl = '';
							jsonUrl = 'http://localhost:8080/consulting/admin/api/allbusiness';
							$table
									.DataTable({
										lengthMenu : [
												[ 3, 5, 10, -1 ],
												[ '3 Records', '5 Records',
														'10 Records', 'ALL' ] ],
										pageLength : 3,
										ajax : {
											url : jsonUrl,
											dataSrc : ''
										},
										columns : [
												{
													data : 'title'
												},
												{
													data : 'description'
												},
												{
													data : 'attachment',
													bSortable : false,
													mRender : function(data,
															type, row) {
														return '<img src="'
																+ 'http://localhost:8080/consulting/ourBusinessUploadPath/' + data
																+'" style="width:100px;height:100px;"/>';

													}
												} ]
									});
						}
					});
</script>
