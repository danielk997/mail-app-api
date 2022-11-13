package com.mailapp.mailapi.modules.campaigns.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("campaigns")
public class CampaignController {

    @GetMapping("/")
    public String getTest() {
        return "Test123";
    }
}
