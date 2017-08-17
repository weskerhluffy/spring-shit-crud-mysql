package com.websystique.springboot.model;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "APP_USER")
public class User implements Serializable {

	@Setter
	@Getter
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Setter
	@Getter
	@NotEmpty
	@Column(name = "NAME", nullable = false)
	private String name;

	@Setter
	@Getter
	@Column(name = "AGE", nullable = false)
	private Integer age;

	@Setter
	@Getter
	@Column(name = "SALARY", nullable = false)
	private double salary;

}