package com.ucs.edu.Review.model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
@Entity
public class UserRole implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String roleName;
	@ManyToMany(mappedBy="userRole")
	private Set<LoginUser> user;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public Set<LoginUser> getUser() {
		return user;
	}
	public void setUser(Set<LoginUser> user) {
		this.user = user;
	}
	
	
}
