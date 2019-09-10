package br.com.teste.kolarik.controller;

import java.util.List;

import javax.validation.Valid;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.teste.kolarik.model.Message;
import br.com.teste.kolarik.repository.MessageRepository;

@RestController
@RequestMapping("/messages")
public class MessageController {
	
	@Autowired
	MessageRepository repository; 
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public List<Message> getAllBots(){
		return repository.findAll();
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public Message getBotById(@PathVariable("id") ObjectId id){
		return repository.findById(id);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public Message createMessage(@Valid @RequestBody Message bot) {
	  bot.setId(ObjectId.get());
	  
	  repository.save(bot);
	  return bot;
	}
	
}
