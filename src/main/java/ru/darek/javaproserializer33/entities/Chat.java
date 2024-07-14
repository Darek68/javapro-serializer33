package ru.darek.javaproserializer33.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Chat {
    private static final Logger logger = LoggerFactory.getLogger(Chat.class.getName());
    private String chat_identifier; // chat_sessions.chat_identifier
    private String last; // chat_sessions.members.last
    private String belong_number; // chat_sessions.messages.belong_number
    private LinkedList<Message> messages = new LinkedList<>();  // chat_sessions.messages.send_date + chat_sessions.messages.text

    public Chat(String chat_identifier, String last, String belong_number) {
        this.chat_identifier = chat_identifier;
        this.last = last;
        this.belong_number = belong_number;
    }

    public void addMessage(Message message) { // по возрастанию message.send_date
        logger.debug("1 addMessage message: {}", message);
        if (this.messages.isEmpty()) {
            this.messages.add(message);
            logger.debug("2 addMessage messages was empty, now: {}", this.messages);
            return;
        }
        int idx = 0;
        for (Message m : messages) {
            if (m.getSend_date().after(message.getSend_date())) {
                messages.add(idx, message);
                logger.debug("3 addMessage message added as {} element, now: {}",idx, this.messages);
                return;
            }
            idx++;
        }
        this.messages.add(message);
        logger.debug("4 addMessage message added to the end of the list: {}", this.messages);
    }
}
