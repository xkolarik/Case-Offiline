package br.com.teste.kolarik.repository;
							
import br.com.teste.kolarik.model.Bot;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import br.com.teste.kolarik.model.Pbot;

import java.util.Optional;

public interface BotRepository extends MongoRepository<Pbot, String>{
	Optional<Pbot> findById(String id);
	Bot save(Bot bot);
}
