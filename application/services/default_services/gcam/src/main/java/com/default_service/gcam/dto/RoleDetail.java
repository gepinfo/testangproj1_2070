package com.default_service.gcam.dto;
import java.util.List;
import java.util.Map;

import lombok.Data;

@Data
public class RoleDetail {
    private String type;
    private List<Screen> screens;
    private Map<String, List<ComponentWrapper>> value;
}
