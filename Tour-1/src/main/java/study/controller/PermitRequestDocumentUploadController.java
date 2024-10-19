package study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpServletRequest;
import study.entity.EntryPermitDocumentUploadDetails;
import study.service.PermitRequestDocumentUploadService;

@RestController
@RequestMapping("/doc_upload")
public class PermitRequestDocumentUploadController {

    @Autowired
    HttpServletRequest request;

    @Autowired
    PermitRequestDocumentUploadService uploadService;

    @PostMapping("/aadhar")
    public ResponseEntity<EntryPermitDocumentUploadDetails> uploadAadhar(@RequestPart MultipartFile file,
                                                                         @RequestHeader ("user_id") String userId,
                                                                         @RequestHeader ("reference_id")String referenceId){
 
        EntryPermitDocumentUploadDetails details  = uploadService.uploadAadhar(file,userId,referenceId);
        return new ResponseEntity<>(details, HttpStatus.CREATED);
    }
    
    @PostMapping("/aadhar_ChatGPT")
    public ResponseEntity<?> uploadAadharChatGPT(@RequestPart("file") MultipartFile file,
                                          @RequestHeader("user_id") String userId,
                                          @RequestHeader("reference_id") String referenceId) {
        // Validate userId and referenceId
        if (userId == null || userId.trim().isEmpty()) {
            return new ResponseEntity<>("User ID is required", HttpStatus.BAD_REQUEST);
        }

        if (referenceId == null || referenceId.trim().isEmpty()) {
            return new ResponseEntity<>("Reference ID is required", HttpStatus.BAD_REQUEST);
        }

        // Validate file
        if (file.isEmpty()) {
            return new ResponseEntity<>("File is required", HttpStatus.BAD_REQUEST);
        }

        // Validate file size (e.g., max 5 MB)
        if (file.getSize() > 5 * 1024 * 1024) {
            return new ResponseEntity<>("File size exceeds the 5 MB limit", HttpStatus.PAYLOAD_TOO_LARGE);
        }

        // Validate file type (e.g., accept only PDF or JPEG)
        String contentType = file.getContentType();
        if (!(contentType.equals("application/pdf") || contentType.equals("image/jpeg"))) {
            return new ResponseEntity<>("Only PDF and JPEG files are allowed", HttpStatus.UNSUPPORTED_MEDIA_TYPE);
        }

        try {
            // Call service to process the upload
            EntryPermitDocumentUploadDetails details = uploadService.uploadAadhar(file, userId, referenceId);
            return new ResponseEntity<>(details, HttpStatus.CREATED);

        } catch (Exception e) {
            // Handle any unexpected exceptions
            return new ResponseEntity<>("Failed to upload Aadhar file: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    
    
    @PostMapping("/police-verification")
    public ResponseEntity<EntryPermitDocumentUploadDetails> uploadPoliceVerification(@RequestPart MultipartFile file,
                                                                         @RequestHeader ("user_id") String userId,
                                                                         @RequestHeader ("reference_id")String referenceId){
 
        EntryPermitDocumentUploadDetails details  = uploadService.uploadPoliceVerification(file,userId,referenceId);
        return new ResponseEntity<>(details, HttpStatus.CREATED);
    }
    
}
