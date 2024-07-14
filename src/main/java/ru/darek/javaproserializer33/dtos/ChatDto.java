package ru.darek.javaproserializer33.dtos;

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
    private List<MemberDto> members;
    private List<MessageDto> messages;

}
/*
 "chat_id":946,
      "chat_identifier":"Apple",
      "display_name":"",
      "is_deleted":0,
 */
