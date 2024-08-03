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
    
    @PostMapping("/police-verification")
    public ResponseEntity<EntryPermitDocumentUploadDetails> uploadPoliceVerification(@RequestPart MultipartFile file,
                                                                         @RequestHeader ("user_id") String userId,
                                                                         @RequestHeader ("reference_id")String referenceId){
 
        EntryPermitDocumentUploadDetails details  = uploadService.uploadPoliceVerification(file,userId,referenceId);
        return new ResponseEntity<>(details, HttpStatus.CREATED);
    }
    
}
