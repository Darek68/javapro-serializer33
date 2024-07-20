package ru.darek.javaproserializer33.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChatDto {
    private Long chatId;
    @JsonProperty("chat_identifier")
    private String chatIdentifier;
    @JsonProperty("display_name")
    private String displayName;
    @JsonProperty("is_deleted")
    private Integer isDeleted;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<MemberDto> members;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<MessageDto> messages;
}

