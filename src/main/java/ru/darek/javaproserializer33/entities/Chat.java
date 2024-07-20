package ru.darek.javaproserializer33.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty("chat_identifier")
    private String chatIdentifier;  // chat_sessions.chat_identifier
    private String last;            // chat_sessions.members.last
    @JsonProperty("belong_number")
    private String belongNumber;    // chat_sessions.messages.belong_number
    private LinkedList<Message> messages = new LinkedList<>();  // chat_sessions.messages.send_date + chat_sessions.messages.text

    public Chat(String chat_identifier, String last, String belong_number) {
        this.chatIdentifier = chat_identifier;
        this.last = last;
        this.belongNumber = belong_number;
        this.messages = new LinkedList<>();
    }

    public void addMessage(Message message) {
        logger.debug("Adding message: {}", message);
        this.messages.add(message);
        this.messages.sort(Comparator.comparing(Message::getSend_date)); // по возрастанию message.send_date
        logger.debug("Messages sorted: {}", this.messages);
    }

    public void addMessage2(Message message) { // по возрастанию message.send_date
        if (this.messages == null)
            this.messages = new LinkedList<>();
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
