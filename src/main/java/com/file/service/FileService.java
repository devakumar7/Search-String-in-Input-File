package com.file.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService {

    public String checkIpAddressInFile(MultipartFile file, String ipAddress) throws IOException {

        try (InputStream inputStream = file.getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {

            List<String> beforeSlashValues = new ArrayList<>();
            List<String> afterSlashValues = new ArrayList<>();

            // Read each line of the file
            bufferedReader.lines().forEach(line -> {
                // Split the line at "/"
                String[] parts = line.split("/");

                // Ensure the line has the expected format
                if (parts.length == 2) {
                    // Store values in separate arrays
                    beforeSlashValues.add(parts[0]);
                    afterSlashValues.add(parts[1]);
                } else {
                    // Handle invalid format or provide appropriate logging
                    System.err.println("Invalid format for line: " + line);
                }
            });
            
         // Perform your logic with the separated values
            System.out.println("Values before \"/\": " + beforeSlashValues);
            System.out.println("Values after \"/\": " + afterSlashValues);
            
         // Check if the provided IP address is in the array
            if (beforeSlashValues.contains(ipAddress)) {
                return "True, it is available in the provided IP addresses";
            } else {
                return "Error: IP address not found in the provided IP addresses";
            }

            
        }
    }
}
