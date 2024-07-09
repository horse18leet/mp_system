package org.vyatsu.localApiModule.messaging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfiguration {

    @Value("${rabbitmq.host}")
    private String hostname;
    @Value("${rabbitmq.username}")
    private String username;
    @Value("${rabbitmq.password}")
    private String password;
    Logger logger =  LoggerFactory.getLogger(RabbitConfiguration.class);

    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory(hostname);
        connectionFactory.setUsername(username);
        connectionFactory.setPassword(password);
        return connectionFactory;
    }

    @Bean
    public AmqpAdmin amqpAdmin(){
        return new RabbitAdmin(connectionFactory());
    }

    @Bean
    public RabbitTemplate rabbitTemplate(){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory());
        rabbitTemplate.setMessageConverter(messageConverter());
        return rabbitTemplate;
    }
    @Bean
    public FanoutExchange fanoutExchangeA(){
        return new FanoutExchange("exchange-order-1");
    }
<<<<<<< Updated upstream
=======
    @Bean
    public FanoutExchange fanoutExchangeB(){
        return new FanoutExchange("exchange-apikeywb-1");
    }
    @Bean
    public FanoutExchange fanoutExchangeC(){
        return new FanoutExchange("exchange-order-2");
    }
    @Bean
    public FanoutExchange fanoutExchangeD(){
        return new FanoutExchange("exchange-sale-1");
    }

>>>>>>> Stashed changes
    @Bean
    public Queue queueOrder(){
        return new Queue("queue.RecordOrders", false);
    }
    @Bean
    public Queue queueRecordOrder(){
        return new Queue("queue.RecordOrder", false);
    }
    @Bean
    public Queue queueRecordSale(){
        return new Queue("queue.RecordSale", false);
    }
    @Bean
    public Queue queueApiKeyWB(){
        return new Queue("queue.ApiKeyWB", false);
    }
    @Bean
    public Queue queueReportDetailWB(){
        return new Queue("queue.ReportDetailWB", false);
    }
//    @Bean
//    DirectExchange exchange(){
//        return new DirectExchange("exchange.direct");
//    }

//    @Bean
//    DirectExchange exchange(){
//        return new DirectExchange("exchange.direct");
//    }

    @Bean
    public Binding binding1(){
        return BindingBuilder.bind(queueOrder()).to(fanoutExchangeA());
<<<<<<< Updated upstream
=======
    }
    @Bean
    public Binding binding2(){
        return BindingBuilder.bind(queueApiKeyWB()).to(fanoutExchangeB());
>>>>>>> Stashed changes
    }

    @Bean
    public Binding binding3(){
        return BindingBuilder.bind(queueRecordOrder()).to(fanoutExchangeC());
    }
    @Bean
    public Binding binding4(){
        return BindingBuilder.bind(queueRecordSale()).to(fanoutExchangeD());
    }
    @Bean
    public Binding binding5(){
        return BindingBuilder.bind(queueReportDetailWB()).to(fanoutExchangeA());
    }

    @Bean
    MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }
    @Bean
    ApplicationRunner runner(ConnectionFactory cf) {
        return args -> cf.createConnection().close();
    }
}
