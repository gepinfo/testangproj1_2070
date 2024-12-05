package com.default_service.gcam.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "screens")
@Data
public class Screen{

    @Id
    private String id;

    private String resources;
    private String role;
    private Date created_at;
    private String screenName;

}

