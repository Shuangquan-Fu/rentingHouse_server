package com.quan.api.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MongoHouse {
    @Id
    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId id;
    private Long hid;
    private String title;
    private Float[] loc;
}
