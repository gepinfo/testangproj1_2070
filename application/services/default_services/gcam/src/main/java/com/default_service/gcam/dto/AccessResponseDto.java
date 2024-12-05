package com.default_service.gcam.dto;
import java.util.List;

import lombok.Data;

@Data
public class AccessResponseDto {
    private List<AccessWrapper> Access;
}
