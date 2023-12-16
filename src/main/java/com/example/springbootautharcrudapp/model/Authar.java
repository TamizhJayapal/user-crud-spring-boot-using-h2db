package com.example.springbootautharcrudapp.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="Authar")

public class Authar {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String name;
	
	private String email;
	
	private String country;

	public Authar() {
	}

	public Authar(int id, String name, String email, String country) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.country = country;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Authar [id=" + id + ", name=" + name + ", email=" + email + ", country=" + country + "]";
	}
	
	
}
