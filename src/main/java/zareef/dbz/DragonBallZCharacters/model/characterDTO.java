package zareef.dbz.DragonBallZCharacters.model;

import java.util.Date;

import javax.validation.constraints.NotNull;

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
	
	@NotNull(message = "Name field can not be null")
	private String name;
	
	@NotNull(message = "Gender field can not be null")
	private String gender;
	
	@NotNull(message = "Race field can not be null")
	private String race;
	
	@NotNull(message = "Age field can not be null")
	private int age;
	
	private String transform;
	
	private String specialpower;
	
	private Date createdAt;
	
	private Date updateAt;

	
	
	
	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSpecialpower() {
		return specialpower;
	}

	public void setSpecialpower(String specialpower) {
		this.specialpower = specialpower;
	}

	public Date getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}

	public String getTransform() {
		return transform;
	}

	public void setTransform(String transform) {
		this.transform = transform;
	}
	
}
