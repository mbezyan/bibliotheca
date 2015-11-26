/**
 * 
 */
package bibliotheca.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import bibliotheca.dao.LibraryDao;
import bibliotheca.model.Member;
import bibliotheca.model.Person;


/**
 * @author Mohammad M. Bezyan
 *
 */

@Controller
public class MemberController {
	
	@Autowired
    private LibraryDao libraryDao;
	
	@RequestMapping(value="/members")
	public ModelAndView returnBean(HttpServletRequest request) {
        return new ModelAndView("members.jsp", "libraryDao", libraryDao);
    }
	
}
