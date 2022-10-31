package zareef.dbz.DragonBallZCharacters.controller;

//import java.util.Date;
import java.util.List;
//import java.util.Optional;

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
			try {
				characterService.updatecharacter(id, character);
				return new ResponseEntity<>("Update character with id "+id, HttpStatus.OK);
			}catch(ConstraintViolationException e){
				return new ResponseEntity<>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
			}catch(characterCollectionException e) {
				return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
			}
		
	}
	
	@DeleteMapping("/characters/{id}")
	public ResponseEntity<?>deletByID(@PathVariable("id") String id){
		try {
			characterService.deletecharacterById(id);
			return new ResponseEntity<>("Deleted the character with id "+id, HttpStatus.OK);
		}catch(characterCollectionException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}


	public characterRepository getCharacterRepo() {
		return characterRepo;
	}


	public void setCharacterRepo(characterRepository characterRepo) {
		this.characterRepo = characterRepo;
	}
	
	
	
}
