package com.project.LibraryApp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="archiveDocument")
public class ArchiveDocument {

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
	
	@Column(name="date_of_last_loan")
	private String date;
	
	
	@Column(name="summary")
	private String summary;
	
	@Column(name="password")
	private String password;
	
	
	@Override
	public String toString() {
		return "Document"+ doc_code+" "+original_version+" "+digital_version+" "+genre+""+author+""+date+" "+summary+" "+password;
		
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



	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

}
