package com.default_service.gcam.dto;

import java.util.List;

import lombok.Data;

@Data
public class ResourceResponseDto {
    private String resourceName;
    private String resourceType;
    private List<String> roles;
    private List<ResourceAccessDto> access;
}
