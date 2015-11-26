/**
 * 
 */
package bibliotheca.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Mohammad M. Bezyan
 *
 */

@Entity
public class Member implements Serializable {
	private static final long serialVersionUID = 1L;
	

	
	@Id
	@GeneratedValue
	@Column(name = "Member_Id")
	private Long memberId;
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "Person_Id")
	private Person person;	
	@Temporal(TemporalType.DATE)
	@Column(name = "Join_Date")
	private Date joinDate;
	
	public Member() {		
	}
	
	public Member(Person person, Date joinDate) {
		super();
		this.person = person;
		this.joinDate = joinDate;
	}

	public Long getMemberId() {
		return memberId;
	}
	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}	
}
