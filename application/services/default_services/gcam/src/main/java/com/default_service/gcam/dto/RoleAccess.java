package com.default_service.gcam.dto;
import java.util.Map;

import lombok.Data;

@Data
public class RoleAccess {
    private Map<String, RoleDetail> accessMap; // A map of role names to RoleDetail
}
