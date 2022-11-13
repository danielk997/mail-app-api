package com.mailapp.mailapi.modules.campaigns.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("campaigns")
public class CampaignController {

    @GetMapping
    public String getTest() {
        return "Test123";
    }
}
