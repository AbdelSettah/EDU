package de.omar.model;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "user")
@Data
public class User extends AbstractTimestampEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@OneToOne
	private Profil profil;

}
