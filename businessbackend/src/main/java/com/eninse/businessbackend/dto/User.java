package com.eninse.businessbackend.dto;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotBlank;

import com.eninse.businessbackend.constants.UserMessagesConstants;

@Entity
@Table(name = "user_detail")
public class User implements Serializable {

	private static final long serialVersionUID = -3612806247059771994L;
	
	/*
	 * Private Fields Users Products
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="first_name")
	@NotBlank(message=UserMessagesConstants.USER_FIRST_NAME)
	private String firstName;
	
	@Column(name="last_name")
	@NotBlank(message=UserMessagesConstants.USER_LAST_NAME)
	private String lastName;
	
	@Column(name="date_of_born")
	private Date dateOfBorn;
	
	private String role;
	
	private String gender;
	
	@NotBlank(message=UserMessagesConstants.USER_PASSWORD)
	private String password;
	
	@Transient
	@NotBlank(message=UserMessagesConstants.USER_CONFIRM_PASSWORD)
	private String confirmPassword;
	
	@NotBlank(message=UserMessagesConstants.USER_EMAIL)
	private String email;
	
	private boolean enabled = true;
	
	@Column(name="contact_number")
	private String contactNumber;

	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	private Cart cart;

	@Column(name="code_promo")
	private String codPromo;
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName="
				+ lastName + ", dateOfBorn=" + dateOfBorn + ", role=" + role
				+ ", gender=" + gender + ", password=" + password
				+ ", confirmPassword=" + confirmPassword + ", email=" + email
				+ ", enabled=" + enabled + ", contactNumber=" + contactNumber
				+ ", cart=" + cart + ", codPromo=" + codPromo + "]";
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	} 

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the enabled
	 */
	public boolean isEnabled() {
		return enabled;
	}

	/**
	 * @param enabled the enabled to set
	 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	/**
	 * @return the contactNumber
	 */
	public String getContactNumber() {
		return contactNumber;
	}

	/**
	 * @param contactNumber the contactNumber to set
	 */
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	/**
	 * @return the cart
	 */
	public Cart getCart() {
		return cart;
	}

	/**
	 * @param cart the cart to set
	 */
	public void setCart(Cart cart) {
		this.cart = cart;
	}

	/**
	 * @return the confirmPassword
	 */
	public String getConfirmPassword() {
		return confirmPassword;
	}

	/**
	 * @param confirmPassword the confirmPassword to set
	 */
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the datOfBorn
	 */
	public Date getDateOfBorn() {
		return dateOfBorn;
	}

	/**
	 * @param datOfBorn the datOfBorn to set
	 */
	public void setDateOfBorn(Date dateOfBorn) {
		this.dateOfBorn = dateOfBorn;
	}

	/**
	 * @return the codPromo
	 */
	public String getCodPromo() {
		return codPromo;
	}

	/**
	 * @param codPromo the codPromo to set
	 */
	public void setCodPromo(String codPromo) {
		this.codPromo = codPromo;
	}
	
}
