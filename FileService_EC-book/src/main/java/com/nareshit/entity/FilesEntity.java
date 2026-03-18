package com.nareshit.entity;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

@Entity
@Table(name="files")
@NoArgsConstructor
public class FilesEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name="fileName")
	private String fileName;

	@Column(name="fileType")
	private String fileType;

	@JsonIgnore  //<--this field won't participate in response..won't show in postman or fronted
	@Column(columnDefinition = "longblob")
	@Lob
	private byte[] data;


	@CreationTimestamp
	@Column(name="createDate")
	public  LocalDateTime createDate;

	@UpdateTimestamp
	@Column(name="updateDate")
	public  LocalDateTime updateDate;


	//no arg-const
	public FilesEntity() {
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}

	public LocalDateTime getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(LocalDateTime updateDate) {
		this.updateDate = updateDate;
	}

	public FilesEntity(Long id, String fileName, String fileType, byte[] data, LocalDateTime createDate,
			LocalDateTime updateDate) {
		super();
		this.id = id;
		this.fileName = fileName;
		this.fileType = fileType;
		this.data = data;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}



 

}
