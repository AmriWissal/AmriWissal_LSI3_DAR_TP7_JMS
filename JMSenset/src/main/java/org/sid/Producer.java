package org.sid;
import org.apache.activemq.ActiveMQConnectionFactory;
import javax.jms.*;
public class Producer {
    public static void main(String[] args) {
        try {
            // Creating a connection factory for ActiveMQ with the broker URL
            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
            // Creating a connection to the message broker
            Connection connection = connectionFactory.createConnection();
            // Starting the connection
            connection.start();
            // Creating a session with transaction enabled and auto-acknowledge mode
            Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
            // Creating a topic destination named "myTopic.topic"
            Destination destination = session.createTopic("myTopic.topic");
            // Creating a message producer for the specified destination
            MessageProducer producer = session.createProducer(destination);
            // Creating a text message
            TextMessage textMessage = session.createTextMessage();
            // Setting the text content of the message
            textMessage.setText("Hello Word");
            // Setting the delivery mode to non-persistent
            producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
            // Sending the text message to the specified destination
            producer.send(textMessage);
            // Committing the session to persist the message
            session.commit();
            // Closing the producer
            producer.close();
            // Closing the session
            session.close();


        } catch (JMSException e) {

        }
    }
}