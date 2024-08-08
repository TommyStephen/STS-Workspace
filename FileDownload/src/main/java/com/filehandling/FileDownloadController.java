package com.filehandling;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/download")
public class FileDownloadController {

    @GetMapping
    public void download (HttpServletResponse response) throws IOException {
        
        // The file to be downloaded.
        Path file = Paths.get("C:/Data/STS Workspace/FileUploadToDirectory/uploads/TourOperatorArun/Sanju Samson.jpg");
        
        // Get the media type of the file
        String contentType = Files.probeContentType(file);
        if (contentType == null) {
            // Use the default media type
        	contentType = MediaType.APPLICATION_OCTET_STREAM_VALUE;
        }
        
        response.setContentType(contentType);
        // File Size
        response.setContentLengthLong(Files.size(file));
        /**
            * Building the Content-Disposition header with the ContentDisposition utility class can avoid the problem of garbled downloaded file names.
            */
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION, ContentDisposition.attachment()
                .filename(file.getFileName().toString(), StandardCharsets.UTF_8)
                .build()
                .toString());
        // Response data to the client
        Files.copy(file, response.getOutputStream());
        response.getOutputStream().flush();
		
    }
}