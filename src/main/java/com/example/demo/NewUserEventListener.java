package com.example.demo;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class NewUserEventListener {

    private final UserBusiness userBusiness;

    public NewUserEventListener(UserBusiness userBusiness) {
        this.userBusiness = userBusiness;
    }


    @RabbitListener(queues = RabbitMQConfig.USER_QUEUE)
    public void newUser(NewUser event) {
        userBusiness.criarUsuario(event);
    }
}