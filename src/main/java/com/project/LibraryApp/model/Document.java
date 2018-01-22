package com.project.LibraryApp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="document")
public class Document {
	
	
	
	@Id
	@GeneratedValue
	private Long doc_code;
	
	@Column(name="doc_name")
	private String doc_name;
	
	@Column(name="original_version")
	private String original_version;
	
	@Column(name="digital_version")
	private String digital_version;
	
	@Column(name="genre")
	private String genre;
	
	@Column(name="author")
	private String author;
	
	
	@Column(name = "registerDate")
	private Date registerDate;
	
	
	@Column(name="summary")
	private String summary;
	
	@Column(name="availableStatus")
	private Boolean availableStatus;
	
	@Column(name="status")
	private Boolean status;
	
	@Column(name = "loanDate")
	private Date loanDate;
	
	@Column(name = "returnLoanDate")
	private Date returnLoanDate;
	
	@Override
	public String toString() {
		return "Document"+ doc_code+" "+original_version+" "+digital_version+" "+genre+""+author+""+registerDate+" "+summary+" "+availableStatus;
		
	}
	



	public Date getRegisterDate() {
		return registerDate;
	}




	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}




	public String getGenre() {
		return genre;
	}


	public void setGenre(String genre) {
		this.genre = genre;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public Long getDoc_code() {
		return doc_code;
	}

	public void setDoc_code(Long doc_code) {
		this.doc_code = doc_code;
	}

	public String getDoc_name() {
		return doc_name;
	}

	public void setDoc_name(String doc_name) {
		this.doc_name = doc_name;
	}

	public String getOriginal_version() {
		return original_version;
	}

	public void setOriginal_version(String original_version) {
		this.original_version = original_version;
	}

	public String getDigital_version() {
		return digital_version;
	}

	public void setDigital_version(String digital_version) {
		this.digital_version = digital_version;
	}





	public Boolean getStatus() {
		return status;
	}


	public void setStatus(Boolean status) {
		this.status = status;
	}


	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}


	public Boolean getAvailableStatus() {
		return availableStatus;
	}


	public void setAvailableStatus(Boolean available) {
		this.availableStatus = available;
	}

	
	
	
	
}
