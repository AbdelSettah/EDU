package de.omar.model;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "profil")
@Data
@DiscriminatorValue("2")
public class Profil extends AbstractTimestampEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String vorname;
	private String nachname;
	private String email;
	private String passwort;
	private String adresse;
	@Lob
	private String profilBild;

}
