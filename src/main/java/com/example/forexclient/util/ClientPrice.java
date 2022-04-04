package com.example.forexclient.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ClientPrice {
    private String currencies;
    private Double bid;
    private Double ask;
    private Date date;
}
