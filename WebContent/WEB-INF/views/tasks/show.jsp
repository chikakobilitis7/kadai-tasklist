<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="../layout/app.jsp">
    <c:param name="content" >
    <h2>${task.id} 番の詳細</h2>
    <p>お前は<c:out value="${task.content}" />をやるんだな</p>
    <p><fmt:formatDate value="${task.created_at}" pattern="yyyy年MM月dd日 HH時mm分ss秒" /><br />
    にそう決めたのは知っている。<br />
    <p><fmt:formatDate value="${task.updated_at}" pattern="yyyy年MM月dd日 HH時mm分ss秒" /><br />
    に心が揺らいだのはなぜ？</p>

    <p><a href="<c:url value='/index' />">全部見てみよう</a></p>
    <p><a href="<c:url value='/edit'  />"id="${task.id}">内容を直す</a></p>

    </c:param>
</c:import>