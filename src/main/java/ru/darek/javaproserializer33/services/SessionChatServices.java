package ru.darek.javaproserializer33.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.darek.javaproserializer33.dtos.*;
import ru.darek.javaproserializer33.entities.*;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

@RequiredArgsConstructor
@Service
public class SessionChatServices {
    private static final Logger logger = LoggerFactory.getLogger(SessionChatServices.class.getName());
    //  private final ProductsRepository productsRepository;

    public Structure getNewStructure(SessionDto sessionDto) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        logger.info("getNewStructure sessionDto: {} ", sessionDto);
        Structure structure = makeStructure(sessionDto);
        logger.info("getNewStructure structure: {} ", structure);
        String outJson = mapper.writer().withDefaultPrettyPrinter().writeValueAsString(structure);
        System.out.println("outJson \n   " + outJson);
        try (PrintWriter out = new PrintWriter("structure.json")) {
            out.println(outJson);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Structure newStructure= mapper.readValue(outJson, Structure.class);
        System.out.println("newStructure: \n   " + newStructure);

      //  return outJson;
        return structure;
    }

    private Structure makeStructure(SessionDto sessionDto) {
        logger.info("1 makeStructure sessionDto: {}", sessionDto);
        Structure structure = new Structure();
        Chat newChat;
        String last;
        logger.info("2 makeStructure sessionDto: {}", sessionDto);
        for (ChatDto chatDto : sessionDto.getChat_sessions()) {
            if (chatDto.getMembers().isEmpty()) last = null;
            else last = chatDto.getMembers().get(0).getLast();  // TODO во вх. json массив members сделать не пустой!!!
            logger.info("3 makeStructure chatDto: {} -- last: {} -- Chat_identifier: {}", chatDto, last, chatDto.getChat_identifier());
            for (MessageDto messageDto : chatDto.getMessages()) {
                String finalLast = last;
                logger.info("4 makeStructure Belong_number: {} -- Send_date: {} -- Text: {}", messageDto.getBelong_number(), messageDto.getSend_date(), messageDto.getText());
                newChat = structure
                        .getChats()
                        .stream()
                        .filter(chat -> chat.getChat_identifier().equals(chatDto.getChat_identifier()))
                        .filter(chat -> chat.getLast().equals(finalLast))
                        .filter(chat -> chat.getBelong_number().equals(messageDto.getBelong_number())) // TODO во вх. json массив messages сделать не пустой!!!
                        .findFirst()
                        .orElse(null);
                if (newChat == null) {
                    newChat = new Chat(chatDto.getChat_identifier(), last, messageDto.getBelong_number());
                    logger.info("44 makeStructure create newChat: {}", newChat);
                    structure.getChats().add(newChat);
                    logger.info("444 makeStructure structure: {}", structure);
                }
                logger.info("5 makeStructure newChat: {}", newChat);
                newChat.addMessage(new Message(messageDto.getSend_date(), messageDto.getText())); // вставка по возрастанию
                logger.info("6 makeStructure newChat: {}", newChat);
            }
        }
        return structure;
    }
}

/*
Создать новую структуру: список из полей <chat_sessions.chat_identifier> - <chat_sessions.members.last> -
<chat_sessions.messages.belong_number> - <chat_sessions.messages.send_date> -
<chat_sessions.messages.text> с группировкой по полю <chat_sessions.messages.belong_number> и сортировкой от более старых сообщений к более новым
 */
/*
  private String chat_identifier; // chat_sessions.chat_identifier
    private String last; // chat_sessions.members.last
    private String belong_number; // chat_sessions.messages.belong_number
    private Date send_date;  // chat_sessions.messages.send_date
    private String text; // chat_sessions.messages.text
 */

/*
Создать новую структуру: список из полей <chat_sessions.chat_identifier> - <chat_sessions.members.last> -
<chat_sessions.messages.belong_number> - <chat_sessions.messages.send_date> -
<chat_sessions.messages.text> с группировкой по полю <chat_sessions.messages.belong_number> и сортировкой от более старых сообщений к более новым
Данные дублироваться не должны (файл должен получиться как можно меньше)
Сериализовать полученные данные и записать их в файл (текстовой или бинарный)
Десериализовать полученные данный и вывести результат на консоль
 */