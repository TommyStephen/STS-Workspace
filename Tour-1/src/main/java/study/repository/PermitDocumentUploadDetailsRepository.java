package study.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import study.entity.EntryPermitDocumentUploadDetails;

public interface PermitDocumentUploadDetailsRepository extends JpaRepository<EntryPermitDocumentUploadDetails, Long> {

}
