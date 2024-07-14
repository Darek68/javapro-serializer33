package ru.darek.javaproserializer33.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Message {
    private Date send_date;  // chat_sessions.messages.send_date
    private String text; // chat_sessions.messages.text
}
