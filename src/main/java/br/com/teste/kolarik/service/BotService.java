package br.com.teste.kolarik.service;

import br.com.teste.kolarik.model.Bot;

public interface BotService {
	Bot create(String id, String name);
	Bot getById(String id);
}
