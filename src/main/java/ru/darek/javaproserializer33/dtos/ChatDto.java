package ru.darek.javaproserializer33.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ChatDto {
    private Long chat_id;
    private String chat_identifier;
    private String display_name;
    private Integer is_deleted;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<MemberDto> members;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<MessageDto> messages;
}

