package ru.darek.javaproserializer33.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MemberDto {
    private String first;
    private Long handle_id;
    private String image_path;
    private String last;
    private String middle;
    private String phone_number;
    private String service;
    private String thumb_path;

}
