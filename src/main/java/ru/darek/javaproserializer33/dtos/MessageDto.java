package ru.darek.javaproserializer33.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MessageDto {
    private int ROWID;
    private String attributedBody;
    private String belong_number;
    private Date date;
    private Date date_read;
    private UUID guid;
    private Long handle_id;
    private Integer has_dd_results;
    private Integer is_deleted;
    private Integer is_from_me;
    @JsonFormat (shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private Date send_date;  // LocalDate ?
    private Integer send_status;
    private String service;
    private String text;

}

