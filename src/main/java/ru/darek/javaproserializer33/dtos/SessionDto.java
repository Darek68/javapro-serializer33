package ru.darek.javaproserializer33.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SessionDto {
    @JsonProperty("chat_sessions")
    private List<ChatDto> chatSessions;
}
