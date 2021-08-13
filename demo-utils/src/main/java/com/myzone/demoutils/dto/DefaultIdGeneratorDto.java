package com.myzone.demoutils.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class DefaultIdGeneratorDto {

    private String splitString = "";

    private String preFix = "";

    private int Initial = 1;

    private int rollingInterval = 1;
}