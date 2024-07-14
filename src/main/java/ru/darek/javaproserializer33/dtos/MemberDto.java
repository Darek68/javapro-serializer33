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
/*
{
          "first":"Moskow",
          "handle_id":934,
          "image_path":"N:\\Tenorshare iCareFone\\Temp\\AnalysisTemp\\113.jpg",
          "last":"Saint-Petersburg",
          "middle":"Bologoe",
          "phone_number":"Apple",
          "service":"SMS",
          "thumb_path":"N:\\Tenorshare iCareFone\\Temp\\AnalysisTemp\\113.thumb"
        }
 */