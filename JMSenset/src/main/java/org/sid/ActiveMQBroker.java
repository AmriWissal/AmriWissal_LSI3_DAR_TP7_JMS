package org.sid;
import org.apache.activemq.broker.BrokerService;
public class ActiveMQBroker {
    public static void main(String[] args) throws Exception {
        // Creating an instance of the ActiveMQ BrokerService
        BrokerService brokerservice= new BrokerService();
        // Adding a connector to the broker, specifying the listening address and port
        brokerservice.addConnector("tcp://0.0.0.0:61616");
        // Starting the ActiveMQ broker
        brokerservice.start();

    }
}
