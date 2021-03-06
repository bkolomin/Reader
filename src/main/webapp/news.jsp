<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>News</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<section>
    <h3><a href="index.html">Home</a></h3>
    <h2>News</h2>
    <table border="1" cellpadding="8" cellspacing="0">
        <thead>
        <tr>
            <th>Date</th>
            <th>Description</th>
        </tr>
        </thead>
        <c:forEach items="${news}" var="newsItem">
            <jsp:useBean id="newsItem" scope="page" type="ru.bkolomin.news.model.NewsItem"/>
            <tr>
                <td>
                    <a href="${newsItem.url}">${newsItem.title}</a>
                </td>
                <td>
                        ${newsItem.description}
                </td>
            </tr>
        </c:forEach>
    </table>
</section>
</body>
</html>