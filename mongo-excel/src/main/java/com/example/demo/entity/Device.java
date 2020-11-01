package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Device {
    private String id;
    private String value;
    private String dataoffset;
    private String category;
    private Long nowtime;

    public Device(String value, String dataoffset, String category, Long nowtime) {
        this.value = value;
        this.dataoffset = dataoffset;
        this.category = category;
        this.nowtime = nowtime;
    }
}
