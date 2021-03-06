<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="../layout/app.jsp">
	<c:param name="content">
		<c:choose>
			<c:when test="${task != null}">
				<h2>${task.id}番の修正</h2>

				<form method="POST"
					action="${pageContext.request.contextPath}/update">
					<c:import url="_form.jsp" />
				</form>
				<p>
					<a href="<c:url value='/index' />">全部見てみよう</a>
				</p>
				<p>
					<a href="#" onclick="confirmDestroy();">なかったことにする</a>
				</p>
				<form method="POST" action="<c:url value='/destroy ' />">
					<input type="hidden" name="_token" value="${_token}" />
				</form>
				<script>
					function confirmDestroy() {
						if (confirm("なかったことにするの？後悔しない？")) {
							document.forms[1].submit();
						}
					}
				</script>
			</c:when>
			<c:otherwise>
				<h2>どこ見てんだよ</h2>
			</c:otherwise>
		</c:choose>
	</c:param>
</c:import>