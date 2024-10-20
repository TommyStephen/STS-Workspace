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
public class ChatGPT {
	
	private static final String AADHAR_DOC_TYPE = "Aadhar";
    private static final String AADHAR_DIR = "./aadhar";
    private static final Logger logger = LoggerFactory.getLogger(PermitRequestDocumentUploadServiceImpl.class);
    private static final String PV_DOC_TYPE = "Police Verification";
    private static final String PV_DIR = "./polic_verification";

    @Autowired
    private PermitDocumentUploadDetailsRepository repository;

    public EntryPermitDocumentUploadDetails uploadAadhar(MultipartFile file, String user_id, String reference_id) {
        validateInputs(file, user_id, reference_id);

        Path directoryPath = Paths.get(AADHAR_DIR, reference_id);
        createDirectoryIfNotExists(directoryPath);
        Path filePath = saveFile(file, directoryPath);

        EntryPermitDocumentUploadDetails details = createDocumentDetails(filePath, user_id, reference_id, AADHAR_DOC_TYPE);
        return repository.save(details);
    }
  
    public EntryPermitDocumentUploadDetails uploadPoliceVerification(MultipartFile file, String userId, String referenceId) {
        validateInputs(file, userId, referenceId);

        Path directoryPath = Paths.get(PV_DIR, referenceId);
        createDirectoryIfNotExists(directoryPath);
        Path filePath = saveFile(file, directoryPath);

        EntryPermitDocumentUploadDetails details = createDocumentDetails(filePath, userId, referenceId, PV_DOC_TYPE);
        return repository.save(details);
    }

    private void validateInputs(MultipartFile file, String userId, String referenceId) {
        if (file == null || file.isEmpty()) {
            throw new IllegalArgumentException("File must not be null or empty");
        }
        if (userId == null || userId.isEmpty()) {
            throw new IllegalArgumentException("User ID must not be null or empty");
        }
        if (referenceId == null || referenceId.isEmpty()) {
            throw new IllegalArgumentException("Reference ID must not be null or empty");
        }
    }

    private void createDirectoryIfNotExists(Path directoryPath) {
        if (!Files.exists(directoryPath)) {
            try {
                Files.createDirectories(directoryPath);
                logger.info("Created directory: {}", directoryPath.toString());
            } catch (IOException e) {
                logger.error("Failed to create directory: {}", directoryPath.toString(), e);
                throw new RuntimeException("Failed to create directory", e);
            }
        }
    }

    private Path saveFile(MultipartFile file, Path directoryPath) {
        Path filePath = directoryPath.resolve(file.getOriginalFilename());
        try {
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
            logger.info("File uploaded successfully to: {}", filePath.toString());
        } catch (IOException e) {
            logger.error("Failed to save file: {}", filePath.toString(), e);
            throw new RuntimeException("Failed to save file", e);
        }
        return filePath;
    }

    private EntryPermitDocumentUploadDetails createDocumentDetails(Path filePath, String userId, String referenceId, String documentType) {
        EntryPermitDocumentUploadDetails details = new EntryPermitDocumentUploadDetails();
        details.setCreatedBy(Long.parseLong(userId));
        details.setCreatedTime(LocalDateTime.now());
        details.setDocumentPath(filePath.toString());
        details.setReferenceId(referenceId);
        details.setDocumentType(documentType);
        return details;
    }
}
