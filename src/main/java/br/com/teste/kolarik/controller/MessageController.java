package br.com.teste.kolarik.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import br.com.teste.kolarik.service.MessageService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.com.teste.kolarik.model.Message;

@RestController
@RequestMapping("/api")
public class MessageController {

	@Autowired
	MessageService messageService;

	@ApiOperation(value = "Criar Messages")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "OK"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 401, message = "Unauthorized"),
			@ApiResponse(code = 500, message = "Internal Server Error")})
	@PostMapping(value = "/messages")
	public Message createMessage(@Valid @RequestBody Message message) {
		Message result = messageService.save(message);
		return result;
	}

	@ApiOperation(value = "Listar Bots")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 401, message = "Unauthorized"),
			@ApiResponse(code = 500, message = "Internal Server Error")})
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public Optional<Message> getMessagesById(@PathVariable("id") String id){
		return messageService.findById(id);
	}
	
	@GetMapping(value="/{conversationid}")
	public List<Message> getAllBots(@PathVariable("conversationid") String conversationid){
		return messageService.findAll(conversationid);
	}
}
