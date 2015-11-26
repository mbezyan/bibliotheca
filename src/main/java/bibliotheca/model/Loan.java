/**
 * 
 */
package bibliotheca.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Mohammad M. Bezyan
 *
 */
@Entity
public class Loan implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name = "Loan_Id")
	private Long loanId;
	@ManyToOne
	@JoinColumn(name = "Member_Id")
	private Member member;	
	@ManyToOne
	@JoinColumn(name = "Asset_Id")
	private Asset asset;
	@Temporal(TemporalType.DATE)
	@Column(name = "Checked_Out_On")
	private Date checkedOutOn;
	@Temporal(TemporalType.DATE)
	@Column(name = "Checked_In_On")
	private Date checkedInOn;
	@Column(name = "Due_Date")
	@Temporal(TemporalType.DATE)
	private Date dueDate;
	
	public Loan() {		
	}
	
	public Loan(Member member, Asset asset, Date checkedOutOn, Date checkedInOn, Date dueDate) {
		super();
		this.member = member;
		this.asset = asset;
		this.checkedOutOn = checkedOutOn;
		this.checkedInOn = checkedInOn;
		this.dueDate = dueDate;
	}
	
	public Long getLoanId() {
		return loanId;
	}
	public void setLoanId(Long loanId) {
		this.loanId = loanId;
	}	
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public Asset getAsset() {
		return asset;
	}
	public void setAsset(Asset asset) {
		this.asset = asset;
	}
	public Date getCheckedOutOn() {
		return checkedOutOn;
	}
	public void setCheckedOutOn(Date checkedOutOn) {
		this.checkedOutOn = checkedOutOn;
	}
	public Date getCheckedInOn() {
		return checkedInOn;
	}
	public void setCheckedInOn(Date checkedInOn) {
		this.checkedInOn = checkedInOn;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
}
