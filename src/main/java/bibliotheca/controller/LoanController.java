package bibliotheca.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import bibliotheca.dao.LibraryDao;
import bibliotheca.model.Book;
import bibliotheca.model.Loan;

@Controller
public class LoanController {
	@Autowired
    private LibraryDao libraryDao;
	
	@RequestMapping(value="/laons")
	public ModelAndView returnBean(HttpServletRequest request) {
        return new ModelAndView("loans.jsp", "libraryDao", libraryDao);
    }
	
	@RequestMapping(value="/booksOnLoan", method = RequestMethod.POST)
	@ResponseBody
	public List<Book> booksOnLoanForUser(HttpServletRequest request) {
		List<Loan> loans = libraryDao.getMemberBookLoans(Long.valueOf(request.getParameter("selectedMemberId")));
		List<Book> books = new ArrayList<Book>();
		for (Loan loan: loans) {
			books.add((Book) loan.getAsset());			
		}
		return books;
	}

}
