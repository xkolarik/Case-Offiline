package br.com.teste.kolarik.repository;
							
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import br.com.teste.kolarik.model.Pbot;

public interface BotRepository extends MongoRepository<Pbot, String>{
	Pbot findById(ObjectId id);
}
