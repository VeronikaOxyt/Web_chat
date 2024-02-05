package org.example.data;

public class Message {
    private String username;
    private String textMessage;


    public Message(String username, String textMessage) {
        this.username = username;
        this.textMessage = textMessage;
    }

    public String getUsername() {
        return username;
    }

    public String getTextMessage() {
        return textMessage;
    }


}
