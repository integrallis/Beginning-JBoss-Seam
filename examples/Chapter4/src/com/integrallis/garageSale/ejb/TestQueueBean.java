package com.integrallis.garageSale.ejb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;

@MessageDriven(
        activationConfig =
        {
            @ActivationConfigProperty(
              propertyName="destinationType", propertyValue="javax.jms.Queue"),
            @ActivationConfigProperty(propertyName="destination", propertyValue="queue/testQueue")
        })
    public class TestQueueBean implements javax.jms.MessageListener {
 
        public void onMessage(javax.jms.Message message) {
            // Perform operations on the message
            
        }
}
