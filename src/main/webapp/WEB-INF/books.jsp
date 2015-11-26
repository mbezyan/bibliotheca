<%@page contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="bibliotheca.*"%>

<jsp:useBean id="libraryDao" type="bibliotheca.dao.LibraryDao"
	scope="request" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
<body>
	<%@ include file="header.html"%>

	<div class="container">
		<h2>Books</h2>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Book ID</th>
					<th>Title</th>
					<th>Author</th>
					<th>ISBN</th>
				</tr>
			</thead>
			<tbody>

				<% for (bibliotheca.model.Book book : libraryDao.getAllBooks()) { %>
				<tr>
					<td><%= book.getAssetId() %></td>
					<td><%= book.getTitle() %></td>
					<td><%= book.getAuthorName() %></td>
					<td><%= book.getIsbn() %></td>
				</tr>
				<% } %>

			</tbody>
		</table>
	</div>

</body>
</html>