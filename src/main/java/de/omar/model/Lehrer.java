package de.omar.model;

import lombok.Data;

import javax.persistence.*;

@Entity(name="lehrer")
@Data
@DiscriminatorValue("1")
public class Lehrer extends User{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String lehrstuhl;
	private String forschungsGebiet;

}
