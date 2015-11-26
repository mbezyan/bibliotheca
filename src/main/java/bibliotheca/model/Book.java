/**
 * 
 */
package bibliotheca.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author Mohammad M. Bezyan
 *
 */

@Entity
@DiscriminatorValue("Book")
public class Book extends Asset {
	private static final long serialVersionUID = 1L;
	
	private String title;
	@Column(name = "Author_Name")
	private String authorName;
	private String isbn;
	
	public Book() {
	}
	
	public Book(String barcode, String title, String authorName, String isbn) {
		super(barcode);
		this.title = title;
		this.authorName = authorName;
		this.isbn = isbn;
	}



	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
}
