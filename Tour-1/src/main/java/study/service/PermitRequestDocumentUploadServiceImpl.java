package study.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import study.entity.EntryPermitDocumentUploadDetails;
import study.repository.PermitDocumentUploadDetailsRepository;

@Service
public class PermitRequestDocumentUploadServiceImpl implements PermitRequestDocumentUploadService {

	private static final String AADHAR_DOC_TYPE = "Aadhar";
	private static final String AADHAR_DIR = "./aadhar";
	private static final Logger logger = LoggerFactory.getLogger(PermitRequestDocumentUploadServiceImpl.class);
	private static final String PV_DOC_TYPE = "Police Verification";
	private static final String PV_DIR = "./police_verification";

	@Autowired
	private PermitDocumentUploadDetailsRepository repository;

	@Override
	public EntryPermitDocumentUploadDetails uploadAadhar(MultipartFile file, String user_id, String reference_id) {

		// Create the directory
        Path directoryPath = Paths.get(AADHAR_DIR , reference_id);
        if (!Files.exists(directoryPath)) {
            try {
                Files.createDirectories(directoryPath);
                logger.info("Created directory: {}", directoryPath.toString());
            } catch (IOException e) {
            	logger.error("Failed to create directory: {}", directoryPath.toString(), e);
            }
        }	
     // Save the file
        Path filePath = directoryPath.resolve(file.getOriginalFilename());
        try {
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
            logger.info("File uploaded successfully to: {}", filePath.toString());
        } catch (IOException e) {
        	logger.error("Failed to save file: {}", filePath.toString(), e);
        }

				
		EntryPermitDocumentUploadDetails details = new EntryPermitDocumentUploadDetails();
		details.setCreatedBy(Long.parseLong(user_id));
		details.setCreatedTime(LocalDateTime.now());
		details.setDocumentPath(filePath.toString());
		details.setReferenceId(reference_id);
		details.setDocumentType(AADHAR_DOC_TYPE);

		return repository.save(details);

	}

	@Override
	public EntryPermitDocumentUploadDetails uploadPoliceVerification(MultipartFile file, String userId,
			String referenceId) {
		// Create the directory
        Path directoryPath = Paths.get(PV_DIR , referenceId);
        if (!Files.exists(directoryPath)) {
            try {
                Files.createDirectories(directoryPath);
                logger.info("Created directory: {}", directoryPath.toString());
            } catch (IOException e) {
            	logger.error("Failed to create directory: {}", directoryPath.toString(), e);
            }
        }	
     // Save the file
        Path filePath = directoryPath.resolve(file.getOriginalFilename());
        try {
            Files.copy(file.getInputStream(), filePath);
            logger.info("File uploaded successfully to: {}", filePath.toString());
        } catch (IOException e) {
        	logger.error("Failed to save file: {}", filePath.toString(), e);
        }

				
		EntryPermitDocumentUploadDetails details = new EntryPermitDocumentUploadDetails();
		details.setCreatedBy(Long.parseLong(userId));
		details.setCreatedTime(LocalDateTime.now());
		details.setDocumentPath(filePath.toString());
		details.setReferenceId(referenceId);
		details.setDocumentType(PV_DOC_TYPE);

		return repository.save(details);
	}
	

	
		
	
}
