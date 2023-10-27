package com.aysu.rabbitmq.producer;

import com.aysu.rabbitmq.model.SaveAuthModel;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateUserProducer {

    public final RabbitTemplate rabbitTemplate;

    public void convertAndSend(SaveAuthModel model){
        rabbitTemplate.convertAndSend("direct-exchange-auth","save-binding-key",model);
    }
}
