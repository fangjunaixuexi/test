<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>部门管理</title>
<style type="text/css">
#pageul li {
	font-size: 15px;
	margin-right: 10px;
}
ul li{display: inline;}
ul a{text-decoration: none;}
#pageul a {
	color: black;
}
</style>
</head>
<body>
	<div class="status">
		<div class="global-width">
			${sessionUser.name}
			你好！欢迎来到部门管理！&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="#" onclick="location.href='${pageContext.request.contextPath}/user/tologin'";>注销</a>
		</div>
	</div>
	<div>
	<table>
	<tr>
	部门分类
	<br>
	<c:forEach items="${pageBean.pageData}" var="pageBean">
	<tr>
	<td><input type="text" value="${pageBean.sname }"/></td>
	<td><a href="${pageContext.request.contextPath}/user/toDeleteSection?id=${pageBean.id}">删除</a></td>
	<td><a href="${pageContext.request.contextPath}/user/toUpdata?id=${pageBean.id}">修改</a></td>
	</tr>
	</c:forEach>
	
	</div>
	</tr>
	<tr>
	<td><a href="${pageContext.request.contextPath}/user/toAddSection">添加</a></td>
	</tr>
	</table>
		<div>
			<ul id="pageul">
				<!-- 上一页 -->
				<c:if test="${pageBean.currentPage!=1 }">
					<li><a href="${pageContext.request.contextPath }/user/tosection?currentPage=${pageBean.currentPage-1}">上一页</a></li>
				</c:if>
				<c:if test="${pageBean.currentPage==1 }">
					<li><a>上一页</a></li>
				</c:if>

				<c:forEach begin="1" end="${pageBean.totalPage }" var="page">
					<c:if test="${page!=pageBean.currentPage }">
						<li><a href="${pageContext.request.contextPath }/user/tosection?currentPage=${page }">${page }</a></li>
					</c:if>
					<c:if test="${page==pageBean.currentPage }">
						<li><font size="6px">${page }</font></li>
					</c:if>
				</c:forEach>
				<!-- 下一页 -->
				<c:if test="${pageBean.currentPage!=pageBean.totalPage }">
					<li><a href="${pageContext.request.contextPath }/user/tosection?currentPage=${pageBean.currentPage+1}">下一页</a></li>
				</c:if>
				<c:if test="${pageBean.currentPage==pageBean.totalPage }">
					<li>下一页</li>
				</c:if>
			</ul>
		</div>
</body>
</html>