package study.service;

import org.springframework.web.multipart.MultipartFile;

import study.entity.EntryPermitDocumentUploadDetails;

public interface PermitRequestDocumentUploadService {

	EntryPermitDocumentUploadDetails uploadAadhar(MultipartFile file, String user_id, String reference_id);

	EntryPermitDocumentUploadDetails uploadPoliceVerification(MultipartFile file, String userId, String referenceId);

	
}
