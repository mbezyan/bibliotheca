<%@page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="bibliotheca.*"%>
 
<jsp:useBean id="libraryDao" type="bibliotheca.dao.LibraryDao" scope="request" />
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
 
<html>
    <body>   
    <%@ include file="header.html" %>
         
               
        <div class="container">
		<h2>Loans</h2>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Member</th>
					<th>Book</th>
					<th>Checked out on</th>
					<th>Checked in on</th>
					<th>Due date</th>
				</tr>
			</thead>
			<tbody>

				<% for (bibliotheca.model.Loan loan : libraryDao.getAllBookLoans()) { %>
				<tr>
					<td><%= loan.getMember().getPerson().getLastName() + ", " + loan.getMember().getPerson().getLastName() %></td>
					<td><%= ((bibliotheca.model.Book) loan.getAsset()).getTitle() %></td>
					<td><%= loan.getCheckedOutOn() %></td>
					<td><%= loan.getCheckedInOn() %></td>
					<td><%= loan.getDueDate() %></td>
				</tr>
				<% } %>

			</tbody>
		</table>
	</div>
     </body>
 </html>