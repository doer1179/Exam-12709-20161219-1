<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增电影</title>
</head>
<body>
<form action="AddFilmServlet" method="post">
名称：<input type="text" name="title" required placeholder="电影名称" />
简介：<input type="text" name="description" required placeholder="电影简介" />
语言：<select onchange="" style="width:180px; margin-left:-20px; " name="language_id" required>
 					<option value="">   </option>
					<c:forEach items="${languageList}" var="matter" varStatus="status">
                   <option value="${matter.language_id}">${matter.name}</option>
					</c:forEach>
                  </select>
<input type="submit" value="新增电影">
</form>

</body>
</html>