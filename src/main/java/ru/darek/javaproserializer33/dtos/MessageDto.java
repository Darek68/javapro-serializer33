package ru.darek.javaproserializer33.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class MessageDto {
    private int ROWID;
    private String attributedBody;
    @JsonProperty("belong_number")
    private String belongNumber;
    private Date date;    // LocalDateTime ?
    @JsonProperty("date_read")
    private Date dateRead;
    private UUID guid;
    @JsonProperty("handle_id")
    private Long handleId;
    @JsonProperty("has_dd_results")
    private Integer hasDdResults;
    @JsonProperty("is_deleted")
    private Integer isDeleted;
    @JsonProperty("is_from_me")
    private Integer isFromMe;
    @JsonProperty("send_date")
    @JsonFormat (shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private Date sendDate;
    @JsonProperty("send_status")
    private Integer sendStatus;
    private String service;
    @JsonProperty("text")
    private String messageText;

}

