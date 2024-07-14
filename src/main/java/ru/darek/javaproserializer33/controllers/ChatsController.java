package ru.darek.javaproserializer33.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.darek.javaproserializer33.entities.Structure;
import ru.darek.javaproserializer33.dtos.*;
/*
import ru.darek.spring_serialize33.dtos.MemberDto;
import ru.darek.spring_serialize33.dtos.MessageDto;
import ru.darek.spring_serialize33.dtos.SessionDto;
import ru.darek.spring_serialize33.entities.Structure;
*/
import ru.darek.javaproserializer33.services.SessionChatServices;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/chat")
public class ChatsController {
    private static final Logger logger = LoggerFactory.getLogger(ChatsController.class.getName());
   // private final ProductsService productsService;
    private final SessionChatServices sessionChatServices;

//    @PostMapping("/struct")
//    @ResponseStatus(HttpStatus.CREATED)
//    public String createNewStructure(@RequestBody SessionDto sessionDto) throws JsonProcessingException {
//        logger.info("Request for create structure: {} -- {} - {}", sessionDto, sessionDto.getChat_sessions().size(), sessionDto.getChat_sessions().get(0).getChat_id());
//        return sessionChatServices.getNewStructure(sessionDto);
//    }
    @PostMapping("/struct")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Structure> createNewStructure(@RequestBody SessionDto sessionDto,@RequestHeader(HttpHeaders.ACCEPT) String accept) throws JsonProcessingException {
        logger.info("Request for create structure: {} -- {} - {} - {}", sessionDto, sessionDto.getChat_sessions().size(), sessionDto.getChat_sessions().get(0).getChat_id(),accept);
        return ResponseEntity.ok(sessionChatServices.getNewStructure(sessionDto));
    }
    @PostMapping("/member")
    @ResponseStatus(HttpStatus.CREATED)
    public MemberDto createNewMember(@RequestBody MemberDto memberDto) throws JsonProcessingException {
        logger.info("Request for test memberDto: {} -- {} - {}", memberDto, memberDto.getPhone_number(), memberDto.getService());
        return memberDto;
    }
    @PostMapping("/message")
    @ResponseStatus(HttpStatus.CREATED)
     public MessageDto  createNewMessage(@RequestBody MessageDto messageDto) throws JsonProcessingException {
        logger.info("Request for test messageDto: {} -- {} - {}", messageDto, messageDto.getSend_date(), messageDto.getDate());
        return messageDto;
      //  return "Chren morzow!";
    }
    @GetMapping("/test0")
    public ResponseEntity<MemberDto> getProductDetails0(@RequestHeader(HttpHeaders.ACCEPT) String accept) throws JsonProcessingException {
        logger.info("MemberDto to json {} -- accept: {}", 1, accept);
        MemberDto obj = getMemberDto();
        logger.info("MemberDto to json {}", 2);
        ObjectMapper mapper = new ObjectMapper();
        logger.info("MemberDto to json {}", 3);
        System.out.println(mapper.writer().withDefaultPrettyPrinter().writeValueAsString(obj));
        logger.info("MemberDto to json: {}", mapper.writer().withDefaultPrettyPrinter().writeValueAsString(obj));
      //  return mapper.writer().withDefaultPrettyPrinter().writeValueAsString(obj);
        return ResponseEntity.ok(obj);
    }

    @GetMapping("/test1")
    public String getProductDetails1(@RequestHeader(HttpHeaders.ACCEPT) String accept) throws JsonProcessingException {
        logger.info("MemberDto to json {} -- accept: {}", 1, accept);
        //  List<MemberDto> obj = new ArrayList<>();
        //  MemberDto obj = new MemberDto("Moskow", 934L, "N:\\Tenorshare iCareFone\\Temp\\AnalysisTemp\\113.jpg", "Saint-Petersburg", "Bologoe", "Apple", "SMS", "N:\\Tenorshare iCareFone\\Temp\\AnalysisTemp\\113.thumb");
        MemberDto obj = getMemberDto();
        logger.info("MemberDto to json {}", 2);
        ObjectMapper mapper = new ObjectMapper();
        logger.info("MemberDto to json {}", 3);
        System.out.println(mapper.writer().withDefaultPrettyPrinter().writeValueAsString(obj));
        logger.info("MemberDto to json: {}", mapper.writer().withDefaultPrettyPrinter().writeValueAsString(obj));
        //   return "This is TEST!" + mapper.writer().withDefaultPrettyPrinter().writeValueAsString(obj);
        return mapper.writer().withDefaultPrettyPrinter().writeValueAsString(obj);
    }


    @GetMapping("/test2")
    public String getProductDetails2() throws JsonProcessingException, ParseException {
        logger.info("MessageDto to json {}", 1);
        //  List<MemberDto> obj = new ArrayList<>();
        //  SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss", Locale.ENGLISH);
        //  SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy hh:mm:ss a", Locale.ENGLISH);
      /*  MessageDto obj = new MessageDto(
                19315,
                "BAtzdHJlYW10eXBlZIHoA4QBQISABClOU011dGFibGVBdHRyaWJ1dGVkU3RyaW5nAISEEk5TQXR0cmlidXRlZFN0cmluZwCEhAhOU09iamVjdACFkoSEhA9OU011dGFibGVTdHJpbmcBhIQITlNTdHJpbmcBlYQBK4GAAFBST0JMRU0gQ1JJVElDQUwgUEdfU01FIC0gRlAgcHJvY2Vzc2luZyBzdGF0dXMgbG9jYWxob3N0IDEyNy4wLjAuMSBFUlJPUi4gUmVzdWx0PVRoZXJlIGFyZSBbMV0gcGF5bWVudHMgaW4gRlAgcHJvY2Vzc2luZyBzdGF0dXM6hoQCaUkBOZKEhIQMTlNEaWN0aW9uYXJ5AJWEAWkBkoSYmB1fX2tJTU1lc3NhZ2VQYXJ0QXR0cmlidXRlTmFtZYaShISECE5TTnVtYmVyAISEB05TVmFsdWUAlYQBKoSbmwCGhpkCCZKEmpsCkoSYmB5fX2tJTURhdGFEZXRlY3RlZEF0dHJpYnV0ZU5hbWWGkoSEhAZOU0RhdGEAlZuBLQKEBls1NTdjXWJwbGlzdDAw1AECAwQFBgcMWCR2ZXJzaW9uWSRhcmNoaXZlclQkdG9wWCRvYmplY3RzEgABhqBfEA9OU0tleWVkQXJjaGl2ZXLSCAkKC1d2ZXJzaW9uWWRkLXJlc3VsdIALgAGsDQ4cJCUmLC0uMjY6VSRudWxs1w8QERITFBUWFxgZGhsaUk1TViRjbGFzc1JBUlFUUVBSU1JSVk6ABoAKgAKABxABgAjUHR4fECAhIiNfEBJOUy5yYW5nZXZhbC5sZW5ndGhfEBROUy5yYW5nZXZhbC5sb2NhdGlvblpOUy5zcGVjaWFsgAOABBAEgAUQCRA50icoKSpaJGNsYXNzbmFtZVgkY2xhc3Nlc1dOU1ZhbHVloikrWE5TT2JqZWN0WTEyNy4wLjAuMVlJUEFkZHJlc3PSLxAwMVpOUy5vYmplY3RzoIAJ0icoMzReTlNNdXRhYmxlQXJyYXmjMzUrV05TQXJyYXnSJyg3OF8QD0REU2Nhbm5lclJlc3VsdKI5K18QD0REU2Nhbm5lclJlc3VsdBABAAgAEQAaACQAKQAyADcASQBOAFYAYABiAGQAcQB3AIYAiQCQAJMAlQCXAJoAnQCfAKEAowClAKcAqQCyAMcA3gDpAOsA7QDvAPEA8wD1APoBBQEOARYBGQEiASwBNgE7AUYBRwFJAU4BXQFhAWkBbgGAAYMBlQAAAAAAAAIBAAAAAAAAADsAAAAAAAAAAAAAAAAAAAGXhpKbkpyGmQE+hg==",
                "+79219213267",
                new Date(TimeUnit.SECONDS.toMillis(701953759344326016L)),
                new Date(TimeUnit.SECONDS.toMillis(701953934692792192L)),
                UUID.fromString("A6EF7781-F25E-0351-8847-140D0810A973"),
                934L,
                1,
                0,
                0,
                new SimpleDateFormat("dd-MM-yyyy HH:mm:ss", Locale.ENGLISH).parse("03-31-2023 14:09:19"),
                0,
                "SMS",
                "PROBLEM CRITICAL - There is hight price of the order"); */
        MessageDto obj = getMessageDto();
        logger.info("MessageDto to json {}", 2);
        ObjectMapper mapper = new ObjectMapper();
        logger.info("MessageDto to json {}", 3);
        System.out.println(mapper.writer().withDefaultPrettyPrinter().writeValueAsString(obj));
        logger.info("MessageDto to json: {}", mapper.writer().withDefaultPrettyPrinter().writeValueAsString(obj));
        //   return "This is TEST!" + mapper.writer().withDefaultPrettyPrinter().writeValueAsString(obj);
        return mapper.writer().withDefaultPrettyPrinter().writeValueAsString(obj);
    }


    @GetMapping("/test3")
    public String getProductDetails3() throws JsonProcessingException, ParseException {
        logger.info("ChatDto to json {}", 1);
        List<MemberDto> members = new ArrayList<MemberDto>();
        members.add(getMemberDto());
        List<MessageDto> messages = new ArrayList<MessageDto>();
        messages.add(getMessageDto());
        //  List<MemberDto> obj = new ArrayList<>();
      /*  ChatDto obj = new ChatDto(
                946L,
                "Apple",
                "",
                0,
                members,
                messages); */
        ChatDto obj = getChatDto();
        logger.info("ChatDto to json {}", 2);
        ObjectMapper mapper = new ObjectMapper();
        logger.info("ChatDto to json {}", 3);
        System.out.println(mapper.writer().withDefaultPrettyPrinter().writeValueAsString(obj));
        logger.info("ChatDto to json: {}", mapper.writer().withDefaultPrettyPrinter().writeValueAsString(obj));
        //   return "This is TEST!" + mapper.writer().withDefaultPrettyPrinter().writeValueAsString(obj);
        return mapper.writer().withDefaultPrettyPrinter().writeValueAsString(obj);
    }
    @GetMapping("/test4")
    public String getProductDetails4() throws JsonProcessingException, ParseException {
        logger.info("SessionDto to json {}", 1);
        List<ChatDto> chats = new ArrayList<>();
        chats.add(getChatDto());
        SessionDto obj = new SessionDto(chats);
        logger.info("SessionDto to json {}", 2);
        ObjectMapper mapper = new ObjectMapper();
        logger.info("SessionDto to json {}", 3);
        System.out.println(mapper.writer().withDefaultPrettyPrinter().writeValueAsString(obj));
        logger.info("SessionDto to json: {}", mapper.writer().withDefaultPrettyPrinter().writeValueAsString(obj));
        return mapper.writer().withDefaultPrettyPrinter().writeValueAsString(obj);
    }

    /*
       "first":"Moskow",
                "handle_id":934,
                "image_path":"N:\\Tenorshare iCareFone\\Temp\\AnalysisTemp\\113.jpg",
                "last":"Saint-Petersburg",
                "middle":"Bologoe",
                "phone_number":"Apple",
                "service":"SMS",
                "thumb_path":"N:\\Tenorshare iCareFone\\Temp\\AnalysisTemp\\113.thumb"
       */
    private MemberDto getMemberDto() {
        return new MemberDto("Moskow",
                934L,
                "N:\\Tenorshare iCareFone\\Temp\\AnalysisTemp\\113.jpg",
                "Saint-Petersburg",
                "Bologoe",
                "Apple",
                "SMS",
                "N:\\Tenorshare iCareFone\\Temp\\AnalysisTemp\\113.thumb");
    }

    /*
     "ROWID":19315,
          "attributedBody":"BAtzdHJlYW10eXBlZIHoA4QBQISABClOU011dGFibGVBdHRyaWJ1dGVkU3RyaW5nAISEEk5TQXR0cmlidXRlZFN0cmluZwCEhAhOU09iamVjdACFkoSEhA9OU011dGFibGVTdHJpbmcBhIQITlNTdHJpbmcBlYQBK4GAAFBST0JMRU0gQ1JJVElDQUwgUEdfU01FIC0gRlAgcHJvY2Vzc2luZyBzdGF0dXMgbG9jYWxob3N0IDEyNy4wLjAuMSBFUlJPUi4gUmVzdWx0PVRoZXJlIGFyZSBbMV0gcGF5bWVudHMgaW4gRlAgcHJvY2Vzc2luZyBzdGF0dXM6hoQCaUkBOZKEhIQMTlNEaWN0aW9uYXJ5AJWEAWkBkoSYmB1fX2tJTU1lc3NhZ2VQYXJ0QXR0cmlidXRlTmFtZYaShISECE5TTnVtYmVyAISEB05TVmFsdWUAlYQBKoSbmwCGhpkCCZKEmpsCkoSYmB5fX2tJTURhdGFEZXRlY3RlZEF0dHJpYnV0ZU5hbWWGkoSEhAZOU0RhdGEAlZuBLQKEBls1NTdjXWJwbGlzdDAw1AECAwQFBgcMWCR2ZXJzaW9uWSRhcmNoaXZlclQkdG9wWCRvYmplY3RzEgABhqBfEA9OU0tleWVkQXJjaGl2ZXLSCAkKC1d2ZXJzaW9uWWRkLXJlc3VsdIALgAGsDQ4cJCUmLC0uMjY6VSRudWxs1w8QERITFBUWFxgZGhsaUk1TViRjbGFzc1JBUlFUUVBSU1JSVk6ABoAKgAKABxABgAjUHR4fECAhIiNfEBJOUy5yYW5nZXZhbC5sZW5ndGhfEBROUy5yYW5nZXZhbC5sb2NhdGlvblpOUy5zcGVjaWFsgAOABBAEgAUQCRA50icoKSpaJGNsYXNzbmFtZVgkY2xhc3Nlc1dOU1ZhbHVloikrWE5TT2JqZWN0WTEyNy4wLjAuMVlJUEFkZHJlc3PSLxAwMVpOUy5vYmplY3RzoIAJ0icoMzReTlNNdXRhYmxlQXJyYXmjMzUrV05TQXJyYXnSJyg3OF8QD0REU2Nhbm5lclJlc3VsdKI5K18QD0REU2Nhbm5lclJlc3VsdBABAAgAEQAaACQAKQAyADcASQBOAFYAYABiAGQAcQB3AIYAiQCQAJMAlQCXAJoAnQCfAKEAowClAKcAqQCyAMcA3gDpAOsA7QDvAPEA8wD1APoBBQEOARYBGQEiASwBNgE7AUYBRwFJAU4BXQFhAWkBbgGAAYMBlQAAAAAAAAIBAAAAAAAAADsAAAAAAAAAAAAAAAAAAAGXhpKbkpyGmQE+hg==",
          "belong_number":"+79219213267",
          "date":701953759344326016,
          "date_read":701953934692792192,
          "guid":"A6EF7781-F25E-0351-8847-140D0810A973",
          "handle_id":934,
          "has_dd_results":1,
          "is_deleted":0,
          "is_from_me":0,
          "send_date":"03-31-2023 14:09:19",
          "send_status":0,
          "service":"SMS",
          "text":"PROBLEM CRITICAL - There is hight price of the order"
     */
    private MessageDto getMessageDto() throws ParseException {
        return new MessageDto(
                19315,
                "BAtzdHJlYW10eXBlZIHoA4QBQISABClOU011dGFibGVBdHRyaWJ1dGVkU3RyaW5nAISEEk5TQXR0cmlidXRlZFN0cmluZwCEhAhOU09iamVjdACFkoSEhA9OU011dGFibGVTdHJpbmcBhIQITlNTdHJpbmcBlYQBK4GAAFBST0JMRU0gQ1JJVElDQUwgUEdfU01FIC0gRlAgcHJvY2Vzc2luZyBzdGF0dXMgbG9jYWxob3N0IDEyNy4wLjAuMSBFUlJPUi4gUmVzdWx0PVRoZXJlIGFyZSBbMV0gcGF5bWVudHMgaW4gRlAgcHJvY2Vzc2luZyBzdGF0dXM6hoQCaUkBOZKEhIQMTlNEaWN0aW9uYXJ5AJWEAWkBkoSYmB1fX2tJTU1lc3NhZ2VQYXJ0QXR0cmlidXRlTmFtZYaShISECE5TTnVtYmVyAISEB05TVmFsdWUAlYQBKoSbmwCGhpkCCZKEmpsCkoSYmB5fX2tJTURhdGFEZXRlY3RlZEF0dHJpYnV0ZU5hbWWGkoSEhAZOU0RhdGEAlZuBLQKEBls1NTdjXWJwbGlzdDAw1AECAwQFBgcMWCR2ZXJzaW9uWSRhcmNoaXZlclQkdG9wWCRvYmplY3RzEgABhqBfEA9OU0tleWVkQXJjaGl2ZXLSCAkKC1d2ZXJzaW9uWWRkLXJlc3VsdIALgAGsDQ4cJCUmLC0uMjY6VSRudWxs1w8QERITFBUWFxgZGhsaUk1TViRjbGFzc1JBUlFUUVBSU1JSVk6ABoAKgAKABxABgAjUHR4fECAhIiNfEBJOUy5yYW5nZXZhbC5sZW5ndGhfEBROUy5yYW5nZXZhbC5sb2NhdGlvblpOUy5zcGVjaWFsgAOABBAEgAUQCRA50icoKSpaJGNsYXNzbmFtZVgkY2xhc3Nlc1dOU1ZhbHVloikrWE5TT2JqZWN0WTEyNy4wLjAuMVlJUEFkZHJlc3PSLxAwMVpOUy5vYmplY3RzoIAJ0icoMzReTlNNdXRhYmxlQXJyYXmjMzUrV05TQXJyYXnSJyg3OF8QD0REU2Nhbm5lclJlc3VsdKI5K18QD0REU2Nhbm5lclJlc3VsdBABAAgAEQAaACQAKQAyADcASQBOAFYAYABiAGQAcQB3AIYAiQCQAJMAlQCXAJoAnQCfAKEAowClAKcAqQCyAMcA3gDpAOsA7QDvAPEA8wD1APoBBQEOARYBGQEiASwBNgE7AUYBRwFJAU4BXQFhAWkBbgGAAYMBlQAAAAAAAAIBAAAAAAAAADsAAAAAAAAAAAAAAAAAAAGXhpKbkpyGmQE+hg==",
                "+79219213267",
                new Date(TimeUnit.SECONDS.toMillis(701953759344326016L)),
                new Date(TimeUnit.SECONDS.toMillis(701953934692792192L)),
                UUID.fromString("A6EF7781-F25E-0351-8847-140D0810A973"),
                934L,
                1,
                0,
                0,
                new SimpleDateFormat("dd-MM-yyyy HH:mm:ss", Locale.ENGLISH).parse("03-31-2023 14:09:19"),
                0,
                "SMS",
                "PROBLEM CRITICAL - There is hight price of the order");
    }
    /*
   private Long chat_id;
   private String chat_identifier;
   private String display_name;
   private Integer is_deleted;
   private List<MemberDto> members;
   private List<MessageDto> messages;

}

"chat_id":946,
     "chat_identifier":"Apple",
     "display_name":"",
     "is_deleted":0,
    */
    private ChatDto getChatDto() throws ParseException {
        List<MemberDto> members = new ArrayList<>();
        members.add(getMemberDto());
        List<MessageDto> messages = new ArrayList<>();
        messages.add(getMessageDto());
        return new ChatDto(
                946L,
                "Apple",
                "",
                0,
                members,
                messages);
    }

}
