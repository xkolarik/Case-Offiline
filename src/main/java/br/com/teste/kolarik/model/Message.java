package br.com.teste.kolarik.model;

import org.bson.types.BSONTimestamp;
import org.bson.types.ObjectId;

public class Message {
	
	private ObjectId id;
	private BSONTimestamp timestamp;
	private ObjectId from;
	private ObjectId to;
	private String text;
	private ObjectId conversarionId;
	
	public ObjectId getConversarionId() {
		return conversarionId;
	}

	public void setConversarionId(ObjectId conversarionId) {
		this.conversarionId = conversarionId;
	}

	public Message() {
	}
	
	public ObjectId getId() {
		return id;
	}
	public void setId(ObjectId id) {
		this.id = id;
	}
	public BSONTimestamp getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(BSONTimestamp timestamp) {
		this.timestamp = timestamp;
	}
	public ObjectId getFrom() {
		return from;
	}
	public void setFrom(ObjectId from) {
		this.from = from;
	}
	public ObjectId getTo() {
		return to;
	}
	public void setTo(ObjectId to) {
		this.to = to;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
}
