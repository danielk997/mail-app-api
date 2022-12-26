package com.mailapp.mailapi.modules.campaigns.dto;


import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class StatsDTO {

    private List<ViewDTO> views;
    private List<ClickDTO> clicks;
}
