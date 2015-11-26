<%@page contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="bibliotheca.*"%>

<jsp:useBean id="libraryDao" type="bibliotheca.dao.LibraryDao"
	scope="request" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>

</head>
<body>
	<%@ include file="header.html"%>
	<script>
		$(document).ready(function() {

			// jQuery methods
			$(".btn-books-on-loans").click(function() {
				var selector = $(this).data('selector');
				var memberId = $(this).data('memberid');
				var booksOnLoan = "";				
				$.ajax({
		            url : 'booksOnLoan.html',
		            type : "POST",
		            data: { selectedMemberId : memberId},
		            success: function(data, textStatus, jqXHR)
		            {
		            	booksOnLoan += "<tr id='" + memberId + "-loans'><td colspan='6'><b>Books on loan</b><br /><table class='table'><thead><tr><th>Title</th><th>Author</th></tr></thead><tbody>"
		            	$.each(data, function() {
		            		booksOnLoan += "<tr>";
		            		  
		            			  booksOnLoan += "<td>" + this['title'] + "</td>";
		            			  booksOnLoan += "<td>" + this['authorName'] + "</td>";
		            		  
		            		  booksOnLoan += "</tr>";
		            		});
		            	booksOnLoan += "</tbody></table></td></tr>";
		            	$(selector).append(booksOnLoan);
		            	$("#btn-books-on-loans-for-" + memberId).hide();
		            	$("#btn-hide-books-on-loans-for-" + memberId).show();
		            },
		            error: function (jqXHR, textStatus, errorThrown)
		            {
		            	alert(errorThrown);
		            }
		        });

			});
			
			$(".btn-hide-books-on-loans").click(function() {
				
				var memberId = $(this).data('memberid');
				$("#btn-books-on-loans-for-" + memberId).show();
				$("#btn-hide-books-on-loans-for-" + memberId).hide();
				$("#" + memberId + "-loans").remove();
			});
		});
	</script>

	<div class="container">
		<h2>Members</h2>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Member ID</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Primary Contact number</th>
					<th>Email</th>
					<th>Actions</th>
				</tr>
			</thead>


			<%
				for (bibliotheca.model.Member member : libraryDao.getAllMembers()) {
			%>
			<tbody id="<%=member.getMemberId()%>">
				<tr>
					<td><%=member.getMemberId()%></td>
					<td><%=member.getPerson().getFirstName()%></td>
					<td><%=member.getPerson().getLastName()%></td>
					<td><%=member.getPerson().getPrimaryPhoneNumber()%></td>
					<td><%=member.getPerson().getEmailAddress()%></td>
					<td><button class="btn-books-on-loans"
							id="btn-books-on-loans-for-<%=member.getMemberId()%>"
							data-selector="#<%=member.getMemberId()%>"
							data-memberid="<%=member.getMemberId()%>">See books on
							loan</button>
						<button class="btn-hide-books-on-loans"
						data-memberid="<%=member.getMemberId()%>"
						hidden="true" id="btn-hide-books-on-loans-for-<%=member.getMemberId()%>">Hide books on loan</button>
					</td>
				</tr>
			</tbody>
			<%
				}
			%>


		</table>
	</div>


</body>
</html>