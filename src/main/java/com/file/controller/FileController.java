package com.file.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.file.service.FileService;

@RestController
public class FileController {

	private final FileService fileService;

    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

	@PostMapping("/processFile")
	@ResponseBody
    public ResponseEntity<String> checkIpAddress(@RequestParam("file") MultipartFile file,
            @RequestParam("ipAddress") String ipAddress) {

		if (file.isEmpty()) {
			return new ResponseEntity<>("File is empty", HttpStatus.BAD_REQUEST);
		}

		try {
            // Call the service to check the IP address in the file
            String result = fileService.checkIpAddressInFile(file, ipAddress);
            
            // Return the result as a response
            return ResponseEntity.ok(result);
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Error processing the file");
        }
	}
}