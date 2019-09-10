package br.com.teste.kolarik.controller;

import java.util.List;
import javax.validation.Valid;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.teste.kolarik.model.Bot;
import br.com.teste.kolarik.service.BotService;

@RestController
@RequestMapping("/bots")
public class BotController {

	@Autowired
	BotService service;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Bot> getAllBots() {
		return service.getAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Bot getBotById(@RequestParam (value="id",required=true)ObjectId id, Bot bot) {
		return service.getById(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public Bot modifyBotById(@RequestParam(value="id", required=true) ObjectId id, @RequestBody Bot bot) {
		return service.update(id, bot);
	}

	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public Bot createBot(@Valid @RequestBody Bot bot) {
		return service.create(bot);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteBot(@RequestParam(value="id", required=true) ObjectId id) {
		service.delete(id);
	}
}
