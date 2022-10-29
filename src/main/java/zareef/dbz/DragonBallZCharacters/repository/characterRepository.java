package zareef.dbz.DragonBallZCharacters.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import zareef.dbz.DragonBallZCharacters.model.characterDTO;


@Repository
public interface characterRepository extends MongoRepository<characterDTO, String> {
	
	@Query("{'name': ?0}")
	Optional<characterDTO> findBycharacter(String name);
	
}
