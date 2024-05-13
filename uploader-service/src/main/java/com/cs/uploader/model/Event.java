package com.cs.uploader.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Max.Alencar
 */
@Document
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Event {

    @Id
    private String id;
    private Long timestamp;
    private String type;
    private String host;
    private Boolean alert;
    private transient String state;

}
