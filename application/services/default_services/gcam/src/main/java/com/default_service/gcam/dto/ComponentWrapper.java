package com.default_service.gcam.dto;
import java.util.Map;

import lombok.Data;

@Data
public class ComponentWrapper {
    private Map<String, ComponentDetail> components;
}
