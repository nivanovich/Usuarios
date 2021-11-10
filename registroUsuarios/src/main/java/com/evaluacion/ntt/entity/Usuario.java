package com.evaluacion.ntt.entity;
import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
@Entity
@Data
public class Usuario implements Serializable{
	private static final long serialVersionUID = 4894729030347835498L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
	private Long id;
	@Column(name = "NAME", unique = false, nullable = false, length = 100)
	private String name;
	@Column(name = "EMAIL", nullable = false, unique = true)
	private String email;
	@Column(name = "PASSWORD", nullable = false, unique = false)
	private String password;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="USUARIO_ID")
	private List<Phone> phones;
	@Column(name = "TOKEN", nullable = true, unique = false)
	private String token;
	
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", phones="
				+ phones + "]";
	}

}
