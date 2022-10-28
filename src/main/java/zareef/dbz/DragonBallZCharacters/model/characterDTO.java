package zareef.dbz.DragonBallZCharacters.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="characters")
public class characterDTO {
	
	private String id;
	
	private String name;
	
	private String gender;
	
	private String race;
	
	private int age;
	
	private String tranformation;
	
	private String specialpower;
	
	
}
