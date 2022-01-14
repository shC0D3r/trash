package Kafaka;

import dao.NewHeroDAO;

import models.NewHero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@EnableKafka
@Service
public class Listners {

    @Autowired
    private MsgController msgController;

    @KafkaListener(topics = "First_request")
    public void firstService(NewHero hero){
        System.out.println("First_request: Принят в первом топике");
        NewHeroDAO DAO = new NewHeroDAO();
        DAO.save(hero);
        hero.setId(100);
        msgController.sendHero("Second_request", hero);
        System.out.println("First_request: Отправлен во второй топик");
    }

    @KafkaListener(topics = "Second_request")
    public void msgListener(NewHero hero){
        System.out.println("Second_request: Получен " + hero);
    }

}
