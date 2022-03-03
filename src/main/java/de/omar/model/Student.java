package de.omar.model;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "student")
@Data
@DiscriminatorValue("2")
public class Student extends User{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String matrikelNummer;
	private String studiendFach;

}
