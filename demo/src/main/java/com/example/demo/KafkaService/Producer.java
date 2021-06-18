package com.example.demo.KafkaService;

import com.example.demo.Entity.Truck;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import javax.websocket.SendResult;

public class Producer {

//    private static final Logger logger = LoggerFactory.getLogger(Truck.class);
//    private final KafkaTemplate<Object, Class<Truck>> kafkaTemplate;
//    private final String Topic = "Topic1";
//    private Object ListenableFutureCallback;
//
//    public Producer(KafkaTemplate<Object, Class<Truck>> kafkaTemplate) {
//        this.kafkaTemplate = kafkaTemplate;
//    }
//
//    public void sendMessage(String message){
//        logger.info(String.format("$$$ Abfahrt!", message));
//
//        ListenableFuture<SendResult<String, String>> future =this.kafkaTemplate.send(Topic,message);
//        future.addCallback(new ListenableFutureCallback<SendResult<>>() {
//            @Override
//            public void onFailure(Throwable throwable) {
//
//            }
//
//            @Override
//            public void onSuccess(SendResult<> stringStringSendResult) {
//
//            }
//        }ListenableFutureCallback <>());
//    }
}
