package br.com.teste.kolarik.service.impl;

import br.com.teste.kolarik.model.Message;
import br.com.teste.kolarik.repository.MessageRepository;
import br.com.teste.kolarik.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MessageServiceImpl implements MessageService {

    @Autowired
    MessageRepository messageRepository;

    @Override
    public Message save(Message message) {
        return messageRepository.save(message);
    }

    @Override
    public Optional<Message> findById(String id) {
        return messageRepository.findById(id);
    }

    @Override
    public List<Message> findAll(String conversationid) {
        List<Message> listMessages = messageRepository.findAll();
        List<Message> listMessagesReturn = new ArrayList<>();
        for (Message m : listMessages) {
            if (m.getConversarionId().equals(conversationid)) {
                listMessagesReturn.add(m);
            }
        }
        return listMessagesReturn;
    }
}
