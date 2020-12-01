package br.com.teste.kolarik.controller;

import java.util.List;
import javax.validation.Valid;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.com.teste.kolarik.model.Bot;
import br.com.teste.kolarik.service.BotService;

@RestController
@RequestMapping("/api")
public class BotController {

	@Autowired
	BotService service;

	@ApiOperation(value = "Criar Bot")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "OK"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 401, message = "Unauthorized"),
			@ApiResponse(code = 500, message = "Internal Server Error")})
	@PostMapping(value = "/bots")
	public Bot createBot(@Valid @RequestBody String id, String name) {
		return service.create(id,name);
	}


	@ApiOperation(value = "Listar Bots")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 401, message = "Unauthorized"),
			@ApiResponse(code = 500, message = "Internal Server Error")})
	@RequestMapping(value = "/bots/{id}", method = RequestMethod.GET)
	public Bot getBotById(@RequestParam (value="id",required=true)String id) {
		return service.getById(id);
	}
}
