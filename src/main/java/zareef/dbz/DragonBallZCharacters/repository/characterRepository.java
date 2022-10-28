package zareef.dbz.DragonBallZCharacters.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import zareef.dbz.DragonBallZCharacters.model.characterDTO;


@Repository
public interface characterRepository extends MongoRepository<characterDTO, String> {

}
