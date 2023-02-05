//package com.anchtun.loan.config;
//
//import org.springframework.amqp.core.AmqpTemplate;
//import org.springframework.amqp.core.Queue;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.boot.ApplicationRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class RabbitConfig {
//
//    @Bean
//    public ApplicationRunner runner(AmqpTemplate template) {
//        return args -> template.convertAndSend("zipkin", "zipkin");
//    }
//
//    @Bean
//    public Queue myQueue() {
//        return new Queue("zipkin");
//    }
//
//    @RabbitListener(queues = "zipkin")
//    public void listen(String in) {
//        System.out.println(in);
//    }
//}
