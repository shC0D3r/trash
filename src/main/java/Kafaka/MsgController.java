package Kafaka;

import models.NewHero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
public class MsgController {

    @Autowired
    private KafkaTemplate<String, NewHero> kafkaTemplate;

    public void sendHero(String topic, NewHero hero){
        kafkaTemplate.send(topic, hero);
    }
}

