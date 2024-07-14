package ru.darek.javaproserializer33.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SessionDto {
    private List<ChatDto> chat_sessions;
}
