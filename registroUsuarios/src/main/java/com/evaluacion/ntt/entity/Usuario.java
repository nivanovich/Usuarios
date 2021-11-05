package com.evaluacion.ntt.entity;
import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Usuario implements Serializable{
	private static final long serialVersionUID = 4894729030347835498L;
	@Id
    @GeneratedValue
	private Long id;
	private String name;
	private String email;
	private String password;
	@OneToMany(targetEntity=Phone.class, mappedBy="usuario", fetch=FetchType.EAGER)
	List<Phone> phones;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Phone> getPhones() {
		return phones;
	}
	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", phones="
				+ phones + "]";
	}

}
