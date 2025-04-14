package br.edu.ifrs.tads.ppa.demo.infrastructure.event;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class NewUserEventListener {

    @RabbitListener(queues = RabbitMQConfig.USER_QUEUE)
    public void newUser(NewUserEvent event) {
        
    }
}