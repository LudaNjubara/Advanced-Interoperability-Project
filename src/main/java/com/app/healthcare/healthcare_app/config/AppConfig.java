package com.app.healthcare.healthcare_app.config;


//@Configuration
//public class AppConfig {
//
//    @Value("${spring.activemq.broker-url}")
//    private String brokerUrl;
//
//    @Value("${spring.activemq.user}")
//    private String username;
//
//    @Value("${spring.activemq.password}")
//    private String password;
//
//    @Bean
//    public ConnectionFactory connectionFactory() {
//        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
//        activeMQConnectionFactory.setBrokerURL(brokerUrl);
//        activeMQConnectionFactory.setUserName(username);
//        activeMQConnectionFactory.setPassword(password);
//        PooledConnectionFactory pooledConnectionFactory = new PooledConnectionFactory();
//        pooledConnectionFactory.setConnectionFactory(activeMQConnectionFactory);
//        pooledConnectionFactory.setMaxConnections(10);
//        return pooledConnectionFactory;
//    }
//
//    @Bean
//    public JmsTemplate jmsTemplate() {
//        JmsTemplate jmsTemplate = new JmsTemplate();
//        jmsTemplate.setConnectionFactory(connectionFactory());
//        return jmsTemplate;
//    }
//
//}