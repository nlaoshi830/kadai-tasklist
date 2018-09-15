<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:import url="../layout/app.jsp">
    <c:param name="content">
        <c:choose>
            <c:when test="${task != null}">
		        <H2>id: ${task.id}のタスク詳細ページ</H2>

                <table>
                    <tr>
                        <th>タイトル</th>
                        <td><c:out value="${task.title}"></c:out></td>
                    </tr>
                    <tr>
                        <th>タスク内容</th>
                        <td><c:out value="${task.content}"></c:out></td>
                    </tr>
                    <tr>
                        <th>登録日時</th>
                        <td><fmt:formatDate value="${task.created_at}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate></td>
                    </tr>
                    <tr>
                        <th>更新日時</th>
                        <td><fmt:formatDate value="${task.updated_at}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate></td>
                    </tr>
                </table>

		        <p><a href = "${pageContext.request.contextPath}/index">一覧に戻る</a></p>
		        <p><a href = "${pageContext.request.contextPath}/edit?id=${task.id}">このタスクを編集する</a></p>
            </c:when>
            <c:otherwise>
                <h2>お探しのデータは見つかりませんでした</h2>
            </c:otherwise>
        </c:choose>


    </c:param>
</c:import>