package com.dummy.service.dummyService.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // it will take care all CURD
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
    private String id;
    private String name;
    private String releaseDate;


    @Override
    public String toString() {
        return "{" +
                "\"id\":\"" + id +"\""+
                ", \"name\":'" + name + '\'' +
                ", \"releaseDate\":'" + releaseDate + '\''+
                '}';
    }
}
