package org.sid;
import org.apache.activemq.ActiveMQConnectionFactory;
import javax.jms.*;
public class Consumer {
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
            // Creating a message consumer for the specified destination
            MessageConsumer consumer = session.createConsumer(destination);
            // Setting a message listener for asynchronous message consumption
            consumer.setMessageListener(new MessageListener() {
                @Override
                //vérifier si le message et de type textmessage
                public void onMessage(Message message) {
                    // Checking if the received message is of type TextMessage
                    if (message instanceof TextMessage){
                        // Casting the message to TextMessage
                        TextMessage textMessage = (TextMessage) message;
                        try {
                            // Retrieving and printing the text content of the message
                            System.out.println("Message recu : " +textMessage.getText());
                        }
                        catch (JMSException e){e.printStackTrace();}
                    }
                }
            });
        } catch (JMSException e){

        }
    }
}
