package br.com.teste.kolarik.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.teste.kolarik.model.Message;

public interface MessageRepository extends MongoRepository<Message, String> {
	Message findById(ObjectId id);
}
