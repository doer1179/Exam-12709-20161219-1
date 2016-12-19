<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>更新电影信息</title>
</head>
<body>
<h3>更新电影信息</h3>
<form action="UpdateOne2" method="post">
编号：<input type="text" name="film_id" value="${film.film_id}" readonly />
名称：<input type="text" name="title" placeholder="电影名称" value="${film.title}" />
简介：<input type="text" name="description" placeholder="电影简介" value="${film.description}" />
语言：<select onchange="" style="width:180px; margin-left:-20px;" name="language_id" >
 					<option value="">  ${film.language}  </option>
	<c:forEach items="${LanguageList}" var="m" varStatus="status">
                   <option value="${m.language_id}">${m.name}</option>
					</c:forEach>
					
                  </select>
<input type="submit" value="更新电影">
</form>
</body>
</html>