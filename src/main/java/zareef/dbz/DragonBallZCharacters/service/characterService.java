package zareef.dbz.DragonBallZCharacters.service;

import java.util.List;

import javax.validation.ConstraintViolationException;

import zareef.dbz.DragonBallZCharacters.exception.characterCollectionException;
import zareef.dbz.DragonBallZCharacters.model.characterDTO;

public interface characterService {

	public void createcharacter(characterDTO name) throws ConstraintViolationException, characterCollectionException ;
	
	public List<characterDTO> getAllcharacter();
	
	public characterDTO getSinglecharacter(String id) throws characterCollectionException;

}
