/**
 * 
 */
package bibliotheca.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.hibernate.Query;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import bibliotheca.model.Book;
import bibliotheca.model.Loan;
import bibliotheca.model.Member;




/**
 * @author Mohammad M. Bezyan
 *
 */

@Component
public class LibraryDao {
	@PersistenceContext
	private EntityManager em;
		
	@Transactional
	public void persist(Object object) {
		em.persist(object);
	}
	
    public List<Member> getAllMembers() {
        javax.persistence.Query query = em.createQuery("SELECT m FROM Member m ORDER BY m.memberId");
        return query.getResultList();
    }
    
    public List<Book> getAllBooks() {
        javax.persistence.Query query = em.createQuery("SELECT b FROM Book b ORDER BY b.assetId");
        return query.getResultList();
    }
    
    public List<Loan> getAllBookLoans() {
        javax.persistence.Query query = em.createQuery("SELECT l FROM Loan l WHERE l.asset.assetType = 'Book' ORDER BY l.loanId");
        return query.getResultList();
    }
    
    public List<Loan> getMemberBookLoans(Long memberId) {
        javax.persistence.Query query = em.createQuery("SELECT l FROM Loan l WHERE l.asset.assetType = 'Book' AND l.member.memberId = " + memberId + " ORDER BY l.loanId");
        return query.getResultList();
    }
    

}
