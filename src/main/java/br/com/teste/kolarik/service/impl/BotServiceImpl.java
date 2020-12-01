package br.com.teste.kolarik.service.impl;

import br.com.teste.kolarik.model.Bot;
import br.com.teste.kolarik.model.Pbot;
import br.com.teste.kolarik.repository.BotRepository;
import br.com.teste.kolarik.service.BotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class BotServiceImpl implements BotService {

    @Autowired
    private BotRepository botRepository;

    public Bot create(String id, String name) {
        Bot bot = new Bot();
        Optional<Pbot> result = botRepository.findById(id);
        if(result != null){
            bot.setId(result.get().getBot().getId());
            bot.setName(result.get().getBot().getName());
            botRepository.save(bot);
        }
        bot.setId(id);
        bot.setName(name);

        return getById(id);
    }

    public Bot getById(String id) {
        Optional<Pbot> result = botRepository.findById(id);
        Bot bot = new Bot();
        bot.setId(result.get().getBot().getId());
        bot.setName(result.get().getBot().getName());
        return bot;
    }
}
