package ru.darek.javaproserializer33.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.darek.javaproserializer33.entities.Structure;
import ru.darek.javaproserializer33.dtos.*;

import ru.darek.javaproserializer33.services.SessionChatServices;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/chat")
public class ChatsController {
    private static final Logger logger = LoggerFactory.getLogger(ChatsController.class);
    private final SessionChatServices sessionChatServices;

    @PostMapping("/struct")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Structure> createNewStructure(@RequestBody SessionDto sessionDto,
                                                        @RequestHeader(HttpHeaders.ACCEPT) String accept) throws JsonProcessingException {
        logger.debug("Request for create structure: {} -- {} - {} - {}",
                sessionDto,
                sessionDto.getChatSessions().size(),
                sessionDto.getChatSessions().get(0).getChatId(),
                accept);
       // return ResponseEntity.ok(sessionChatServices.getNewStructure(sessionDto));
        Structure newStructure = sessionChatServices.getNewStructure(sessionDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(newStructure);
    }
}
