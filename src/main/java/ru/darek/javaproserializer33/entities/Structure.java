package ru.darek.javaproserializer33.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Structure {
   private List<Chat> chats = new ArrayList<>();
}
