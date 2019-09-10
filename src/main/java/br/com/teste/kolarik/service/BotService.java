package br.com.teste.kolarik.service;

import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.teste.kolarik.model.Bot;
import br.com.teste.kolarik.model.Pbot;
import br.com.teste.kolarik.repository.BotRepository;

@Service
public class BotService {

	@Autowired
	private BotRepository repositorio;

	public Bot create(Bot bot) {
		Pbot p = new Pbot();
		p.setId(ObjectId.get());
		p.setBot(bot);
		repositorio.save(p);
		return bot;
	}

	public List<Bot> getAll() {
		ArrayList<Bot> lBot = new ArrayList<Bot>();
		List<Pbot> pbots = repositorio.findAll();
		Bot bot1 = new Bot();
		for (Pbot bot : pbots) {
			bot1.setId(bot.getBot().getId());
			bot1.setName(bot.getBot().getName());
			lBot.add(bot1);
		}
		return lBot;
	}

	public Bot getById(ObjectId id) {
		Pbot result = repositorio.findById(id);
		Bot bot = new Bot();
		bot.setId(result.getBot().getId());
		bot.setName(result.getBot().getName());
		return bot;
	}

	public Bot update(ObjectId id, Bot bot) {
		Pbot result = repositorio.findById(id);
		result.setId(result.getId());
		result.getBot().setId(bot.getId());
		result.getBot().setName(bot.getName());
		repositorio.save(result);
		return getById(id);
	}

	public void delete(ObjectId id) {
		Pbot result = repositorio.findById(id);
		repositorio.delete(result);
	}
}
