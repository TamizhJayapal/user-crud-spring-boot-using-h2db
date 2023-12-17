package com.example.springbootautharcrudapp.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name="authar")
public class Authar {
	@Id
	@GeneratedValue
	private int id;

	private String name;

	private String email;

	private String country;

}
