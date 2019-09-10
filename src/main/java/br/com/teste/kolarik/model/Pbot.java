package br.com.teste.kolarik.model;

import org.bson.types.ObjectId;

public class Pbot {
	
	private Bot bot;
	private ObjectId id;
	
	public Bot getBot() {
		return bot;
	}
	public void setBot(Bot bot) {
		this.bot = bot;
	}
	public ObjectId getId() {
		return id;
	}
	public void setId(ObjectId id) {
		this.id = id;
	}
}
