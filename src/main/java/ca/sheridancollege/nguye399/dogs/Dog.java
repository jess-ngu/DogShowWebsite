package ca.sheridancollege.nguye399.dogs;

import java.io.Serializable;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dog implements Serializable{

	private static final long serialVersionUID = 4635740767768620319L;
	
	private int id;
	private int amount;
	private int maleClass;
	private int femaleClass;
	private int maleSpecialty;
	private int femaleSpecialty;
	private String name;
	private String ownerName;
	private String breed;
	private String gender;
	private String type;
}
