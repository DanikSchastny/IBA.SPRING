<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<meta charset="ISO-8859-1">
<!DOCTYPE html>
<html>
<head>
    <title>Books</title>
</head>
<body>
<table border="2", cellpadding="5">
    <tr>
        <td>
            Book cover
        </td>
        <td>
            Title
        </td>
        <td>
            Author
        </td>
        <td>
            Pages amount
        </td>
        <td>
            action
        </td>
    </tr>
    <c:forEach var = "book" items="${booksList}">
        <tr>
            <td>
                <img src=${book.imageURL}, width="64", height="64">
            </td>
            <td>
                ${book.name}
            </td>
            <td>
                ${book.author}
            </td>
            <td>
                ${book.pageAmount}
            </td>
            <td>
                <a href="/edit/${film.id}">edit</a>
                <a href="/delete/${film.id}">delete</a>
            </td>
        </tr>
    </c:forEach>

</table>
</body>
</html>