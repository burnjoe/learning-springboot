package com.learning_springboot.learning_springboot;

import org.springframework.stereotype.Component;

@Component
public class WelcomeMessage {

    public String getWelcomeMessage() {
        return "Welcome user";
    }

}
