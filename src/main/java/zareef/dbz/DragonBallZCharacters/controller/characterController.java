package zareef.dbz.DragonBallZCharacters.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import zareef.dbz.DragonBallZCharacters.model.characterDTO;
import zareef.dbz.DragonBallZCharacters.repository.characterRepository;

@RestController
public class characterController {
	
	@Autowired
	private characterRepository characterRepo;
	
	@GetMapping("/characters")
	public ResponseEntity<?> getAllcharacters(){
		List<characterDTO> characters = characterRepo.findAll();
		if (characters.size() > 0) {
			return new ResponseEntity<List<characterDTO>>(characters,HttpStatus.OK);
		}else {
			return new ResponseEntity<>("No characters available", HttpStatus.NOT_FOUND);
		}
	}
	
	
	@PostMapping("/characters")
	public ResponseEntity<?> createcharacter(@RequestBody characterDTO character){
		try{
			character.setCreatedAt(new Date(System.currentTimeMillis()));
			characterRepo.save(character);
			return new ResponseEntity<characterDTO>(character, HttpStatus.OK);
			
		}catch(Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/characters/{id}")
	public ResponseEntity<?> getSinglecharacter(@PathVariable("id") String id){
		Optional<characterDTO> characterOptional = characterRepo.findById(id);
		if (characterOptional.isPresent()) {
			return new ResponseEntity<>(characterOptional.get(), HttpStatus.OK);
		}else {
			return new ResponseEntity<>("No character is found with id "+id, HttpStatus.NOT_FOUND);
		}
	}
	
	
	
	@PutMapping("/characters/{id}")
	public ResponseEntity<?> updateById(@PathVariable("id") String id, @RequestBody characterDTO character){
		Optional<characterDTO> characterOptional = characterRepo.findById(id);
		if (characterOptional.isPresent()) {
			characterDTO characterToSave = characterOptional.get();
			characterToSave.setName(character.getName() != null ? character.getName() : characterToSave.getName());
			characterToSave.setCreatedAt(character.getName() != null ? character.getCreatedAt() : characterToSave.getCreatedAt());
			characterToSave.setGender(character.getGender() != null ? character.getGender() : characterToSave.getGender());
			characterToSave.setRace(character.getRace() != null ? character.getRace() : characterToSave.getRace());
			characterToSave.setAge(character.getAge() != 0 ? character.getAge() : characterToSave.getAge());
			characterToSave.setSpecialpower(character.getSpecialpower() != null ? character.getSpecialpower() : characterToSave.getSpecialpower());
			characterToSave.setUpdateAt(character.getUpdateAt() != null ? character.getUpdateAt() : characterToSave.getUpdateAt());
			characterToSave.setTransform(character.getTransform() != null ? character.getTransform() : characterToSave.getTransform());
			characterRepo.save(characterToSave);
			return new ResponseEntity<>(characterToSave, HttpStatus.OK);
		}else {
			return new ResponseEntity<>("character not found with id "+id, HttpStatus.NOT_FOUND);
		}
		
	}
	
	@DeleteMapping("/characters/{id}")
	public ResponseEntity<?>deletByID(@PathVariable("id") String id){
		try {
			characterRepo.deleteById(id);
			return new ResponseEntity<>("Deleted the character with id "+id, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	
	
}
