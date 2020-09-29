package com.ucs.edu.Review.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class LoginUser implements Serializable{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    @Transient
    private String passwordConfirm;

    @OneToMany(mappedBy="user")
    private List<Product> getProductList=new ArrayList<Product>();
    
    @ManyToOne
    @JoinColumn(name="roleId")
    private UserRole roles;

    
    
	public List<Product> getGetProductList() {
		return getProductList;
	}

	public void setGetProductList(List<Product> getProductList) {
		this.getProductList = getProductList;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	public UserRole getRoles() {
		return roles;
	}

	public void setRoles(UserRole roles) {
		this.roles = roles;
	}

	
    
    
	

}
