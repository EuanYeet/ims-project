package com.qa.ims.persistence.domain;

public class Customer {

	private Long id;
	private String firstName;
	private String surname;
	private Integer age;
	private String telephone;

	public Customer(String firstName, String surname, int age, String telephone) {
		this.setFirstName(firstName);
		this.setSurname(surname);
		this.setAge(age);
		this.setTelephone(telephone);
	}

	public Customer(Long id, String firstName, String surname, int age, String telephone) {
		this.setId(id);
		this.setFirstName(firstName);
		this.setSurname(surname);
		this.setAge(age);
		this.setTelephone(telephone);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public int getAge() {
		return age;
	}
	
	public String getStringAge() {
		return age.toString();
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Override
	public String toString() {
		return "id:" + id + " first name:" + firstName + " surname:" + surname + " age:" + age + " telephone:" + telephone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
		result = prime * result + ((age == null) ? 0 : age.hashCode());
		result = prime * result + ((telephone == null) ? 0 : telephone.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		// True or False if object is the same
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		
		// Checks Class
		if (getClass() != obj.getClass())
			return false;
		
		// Casting other to object type Customer
		Customer other = (Customer) obj;
		
		// FirstName
		// Checks if 1 value is null
		if (getFirstName() == null) {
			if (other.getFirstName() != null)
				return false;
		// Way of checking != for strings
		} else if (!getFirstName().equals(other.getFirstName()))
			return false;
		
		// ID
		// Checks if 1 value is null
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		
		// Surname
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		
		// Age
		if (age == null) {
			if (other.age != null)
				return false;
		} else if (!age.equals(other.age))
			return false;
		// Telephone
		if (telephone == null) {
			if (other.telephone != null)
				return false;
		} else if (!telephone.equals(other.telephone))
			return false;
		return true;
	}

}
