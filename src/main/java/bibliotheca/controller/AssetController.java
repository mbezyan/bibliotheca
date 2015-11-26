/**
 * 
 */
package bibliotheca.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import bibliotheca.dao.LibraryDao;

/**
 * @author Mohammad M. Bezyan
 *
 */

@Controller
public class AssetController {
	@Autowired
    private LibraryDao libraryDao;
	
	@RequestMapping(value="/books")
	public ModelAndView returnBean(HttpServletRequest request) {
        return new ModelAndView("books.jsp", "libraryDao", libraryDao);
    }

}
