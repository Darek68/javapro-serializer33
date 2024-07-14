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
/*
{
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
        }
 */
