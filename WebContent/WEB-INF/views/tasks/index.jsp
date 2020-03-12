<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="../layout/app.jsp">
	<c:param name="content">
		<h2>これ終わってないよ</h2>
		<ul>
			<%--IndexServletのdoGetから飛ばされてきたやつを繰り返す --%>
			<c:forEach var="task" items="${tasks}">
				<li>
					<%-- idが表示され、クリックするとshowにとぶ --%>
		            <a href="${pageContext.request.contextPath}/show?id=${task.id}">
		            <c:out value="${task.id}" />
				    </a>
					 <c:out value="${task.content}" />
				</li>
			</c:forEach>
		</ul>
		<p><a href="<c:url value='/new' />">ほかにやることは？</a></p>

	</c:param>
</c:import>
