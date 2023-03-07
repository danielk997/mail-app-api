package com.mailapp.mailapi.modules.files.web;

import com.mailapp.mailapi.modules.configuration.dto.SmtpConfigurationCreateDTO;
import com.mailapp.mailapi.modules.configuration.dto.SmtpConfigurationDTO;
import com.mailapp.mailapi.modules.files.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("files")
public class FileController {

    private final FileService fileService;

    @GetMapping
    public List<SmtpConfigurationDTO> getAll() {
        return fileService.getAll();
    }

    @GetMapping("/{id}")
    public SmtpConfigurationDTO getById(@PathVariable("id") Long id) {
        return fileService.getById(id);
    }

    @PostMapping()
    public String handleFileUpload(@RequestParam("file") MultipartFile file) {


        return "";
    }
}
