package com.example.NoSQLSpringboot.Model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "dbSequence")
@Data
public class IdIncrement {
    private String id;
    private int number;
}
