package com.default_service.gcam.dto;

import java.util.List;
import java.util.Map;

import lombok.Data;

@Data
public class ResourceAccessDto {
    private String type;
    private List<Map<String, String>> screens;
    private Map<String, Map<String, Boolean>> value;
}
