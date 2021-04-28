package com.sssakib.SpringBootApp;


import javax.persistence.*;

import java.sql.Blob;
import java.util.Objects;

@Entity
@Table(name = "user")
public class User {
	 private String name,mobile,email,address,password;
	 private long id;
	 private String  image;
	 
	 

	



	public User(){

	 }

	

	public User(String name, String mobile, String email, String address, String password, long id, String image) {
		super();
		this.name = name;
		this.mobile = mobile;
		this.email = email;
		this.address = address;
		this.password = password;
		this.id = id;
		this.image = image;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	 public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	 

	public String getName() {
	    return name;
	}

	public void setName(String name) {
	    this.name = name;
	}

	public String getMobile() {
	    return mobile;
	}

	public void setMobile(String mobile) {
	   this.mobile = mobile;
	}

	public String getEmail() {
	   return email;
	}

	public void setEmail(String email) {
	   this.email = email;
	}

	public String getAddress() {
	   return address;
	}

	public void setAddress(String address) {
	   this.address = address;
	}

	public String getPassword() {
	   return password;
	}

	public void setPassword(String password) {
	   this.password = password;
	}
	public String getImage() {
		return image;
	}



	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name,mobile,email,address,password,image);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null ) return false;
		if(!(o instanceof User)) return false;

		User user = (User) o;


		if(password == null){
			if(user.password != null)
				return false;
		}else if(!password.equals(user.password))
			return false;
		if (mobile == null) {
			if (user.mobile != null)
				return false;
		} else if (!mobile.equals(user.mobile))
			return false;

		return true;


	}



	@Override
	public String toString() {
		return "User [name=" + name + ", mobile=" + mobile + ", email=" + email + ", address=" + address + ", password="
				+ password + ", id=" + id + ", image=" + image + "]";
	}
	

	


}
