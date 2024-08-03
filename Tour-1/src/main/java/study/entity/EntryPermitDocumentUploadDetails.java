package study.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
public class EntryPermitDocumentUploadDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "reference_id")
	private String referenceId;

	@Column(name = "document_type")
	private String documentType;

	@Column(name = "document_path")
	private String documentPath;

	@Column(name = "created_by")
	private long createdBy;

	@Column(name = "created_time")
	private LocalDateTime createdTime;

	
	public EntryPermitDocumentUploadDetails() {
		super();
	}

	public EntryPermitDocumentUploadDetails(String referenceId, String documentType, String documentPath,
			long createdBy, LocalDateTime createdTime) {
		super();
		this.referenceId = referenceId;
		this.documentType = documentType;
		this.documentPath = documentPath;
		this.createdBy = createdBy;
		this.createdTime = createdTime;
	}

	public String getReferenceId() {
		return referenceId;
	}

	public void setReferenceId(String referenceId) {
		this.referenceId = referenceId;
	}

	public String getDocumentType() {
		return documentType;
	}

	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}

	public String getDocumentPath() {
		return documentPath;
	}

	public void setDocumentPath(String documentPath) {
		this.documentPath = documentPath;
	}

	public long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(long createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDateTime getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(LocalDateTime createdTime) {
		this.createdTime = createdTime;
	}

	public long getId() {
		return id;
	}
	
	
	
}
