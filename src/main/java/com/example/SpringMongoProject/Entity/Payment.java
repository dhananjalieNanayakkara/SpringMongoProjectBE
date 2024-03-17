package com.example.SpringMongoProject.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.ShardingStrategy;

import java.time.LocalDate;
import java.util.Date;

@Document(collection = "payment")
@Data
public class Payment {
    @Id
    private String _id;
    private String userId;
    private String cardType;
    private String cardNo;
    private LocalDate exDate;
    private String cvv;

}
