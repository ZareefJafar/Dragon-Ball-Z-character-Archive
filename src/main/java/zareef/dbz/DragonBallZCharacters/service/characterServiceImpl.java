package zareef.dbz.DragonBallZCharacters.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zareef.dbz.DragonBallZCharacters.exception.characterCollectionException;
import zareef.dbz.DragonBallZCharacters.model.characterDTO;
import zareef.dbz.DragonBallZCharacters.repository.characterRepository;

@Service
public class characterServiceImpl implements characterService {

	@Autowired
	private characterRepository characterRepo;
	
	@Override
	public void createcharacter(characterDTO name) throws ConstraintViolationException, characterCollectionException {
		Optional<characterDTO> characterOptional = characterRepo.findBycharacter(name.getName());
		if (characterOptional.isPresent()) {
			throw new characterCollectionException(characterCollectionException.characterAlreadyExists());
		}else {
			name.setCreatedAt(new Date(System.currentTimeMillis()));
			characterRepo.save(name);
		}
		
	}

	@Override
	public List<characterDTO> getAllcharacter() {
		List<characterDTO> characters = characterRepo.findAll();
		if (characters.size()>0) {
			return characters;
		}else {
			return new ArrayList<characterDTO>();
		}
	}

	@Override
	public characterDTO getSinglecharacter(String id) throws characterCollectionException {
		Optional<characterDTO> optionalcharacter = characterRepo.findById(id);
		if (!optionalcharacter.isPresent()) {
			throw new characterCollectionException(characterCollectionException.NotFoundException(id));
		}else {
			return optionalcharacter.get();
		}
		
	}

}
