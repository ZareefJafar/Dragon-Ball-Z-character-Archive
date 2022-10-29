package zareef.dbz.DragonBallZCharacters.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.ConstraintViolationException;

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

import zareef.dbz.DragonBallZCharacters.exception.characterCollectionException;
import zareef.dbz.DragonBallZCharacters.model.characterDTO;
import zareef.dbz.DragonBallZCharacters.repository.characterRepository;
import zareef.dbz.DragonBallZCharacters.service.characterService;

@RestController
public class characterController {
	
	@Autowired
	private characterRepository characterRepo;
	
	@Autowired
	private characterService characterService;
	
	@GetMapping("/characters")
	public ResponseEntity<?> getAllcharacters(){
		List<characterDTO> characters = characterService.getAllcharacter();
		return new ResponseEntity<>(characters, characters.size() > 0 ? HttpStatus.OK : HttpStatus.NOT_FOUND);
	}
	
	
	@PostMapping("/characters")
	public ResponseEntity<?> createcharacter(@RequestBody characterDTO character){
		try{
			characterService.createcharacter(character);
			return new ResponseEntity<characterDTO>(character, HttpStatus.OK);
			
		}catch(ConstraintViolationException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
		}catch(characterCollectionException e){
			return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
		}
	}
	
	@GetMapping("/characters/{id}")
	public ResponseEntity<?> getSinglecharacter(@PathVariable("id") String id){
		try {
			return new ResponseEntity<>(characterService.getSinglecharacter(id), HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
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
			characterToSave.setUpdateAt(new Date(System.currentTimeMillis()));
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
