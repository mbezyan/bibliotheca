/**
 * 
 */
package bibliotheca.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Mohammad M. Bezyan
 *
 */

@Entity(name = "Person")
public class Person implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column (name = "Person_Id")
	private Long personId;
	@Column (name = "First_Name")
	private String firstName;
	@Column (name = "Middle_Name")
	private String middleName;
	@Column (name = "Last_Name")
	private String lastName;
	@Column (name = "Primary_Phone_Number")
	private String primaryPhoneNumber;
	@Column (name = "Other_Phone_Number")
	private String otherPhoneNumber;
	@Column (name = "Email_Address")
	private String emailAddress;
	
	public Person() {
	}
	
	public Person(String firstName, String middleName, String lastName, String primaryPhoneNumber,
			String otherPhoneNumber, String emailAddress) {
		super();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.primaryPhoneNumber = primaryPhoneNumber;
		this.otherPhoneNumber = otherPhoneNumber;
		this.emailAddress = emailAddress;
	}

	public Long getPersonId() {
		return personId;
	}
	public void setPersonId(Long personId) {
		this.personId = personId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPrimaryPhoneNumber() {
		return primaryPhoneNumber;
	}
	public void setPrimaryPhoneNumber(String primaryPhoneNumber) {
		this.primaryPhoneNumber = primaryPhoneNumber;
	}
	public String getOtherPhoneNumber() {
		return otherPhoneNumber;
	}
	public void setOtherPhoneNumber(String otherPhoneNumber) {
		this.otherPhoneNumber = otherPhoneNumber;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
}
