package ru.darek.javaproserializer33.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Chat {
    private static final Logger logger = LoggerFactory.getLogger(Chat.class.getName());
    private String chat_identifier; // chat_sessions.chat_identifier
    private String last; // chat_sessions.members.last
    private String belong_number; // chat_sessions.messages.belong_number
    private List<Message> messages = new ArrayList<>();  // chat_sessions.messages.send_date + chat_sessions.messages.text

    public Chat(String chat_identifier, String last, String belong_number) {
        this.chat_identifier = chat_identifier;
        this.last = last;
        this.belong_number = belong_number;
    }
    public void addMessage(Message message){
        logger.info("1 addMessage message: {}", message);
        this.messages.add(message);
        logger.info("2 addMessage messages: {}", this.messages);
        // TODO поменять на LinkedList и вставлять корректно по возрастанию message.send_date
    }
}
