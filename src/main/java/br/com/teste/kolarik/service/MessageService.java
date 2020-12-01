package br.com.teste.kolarik.service;

import br.com.teste.kolarik.model.Message;

import java.util.List;
import java.util.Optional;

public interface MessageService {
    Message save(Message message);
    Optional<Message> findById(String id);
    List<Message> findAll(String conversationid);
}
