<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>电影列表</title>
</head>
<body>
 <div>
     <table>
      <tr>  
            <td> Film_id </td>  
            <td> Title </td>  
            <td> Description </td> 
            <td> Language </td>        
        </tr> 
        
<c:forEach items="${film_list}" var="matter" varStatus="status">
                <td>${matter.film_id}</td>
                <td>${matter.title}</td>
                <td>${matter.description}</td>
                <td>${matter.language}</td>
                <td>
                  <a href="DeleteOne?film_id=${matter.film_id}">删除</a>
                </td>
                <td>
                  <a href="UpdateOne1?film_id=${matter.film_id}">更新</a>
                </td>
              </tr>
            </c:forEach>
     </table>
     </div>
</body>
</html>