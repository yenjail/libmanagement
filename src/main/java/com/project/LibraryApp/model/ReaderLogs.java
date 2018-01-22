package com.project.LibraryApp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "readerLogs")
public class ReaderLogs {

	@Id
	@GeneratedValue
	private Long logID;
	
	@ManyToOne
	@JoinColumn(name="reader_id")
	private Reader reader_id;
	
	@Column(name = "logedDate")
	private Date logedInDate;

	public Long getLogID() {
		return logID;
	}

	public void setLogID(Long logID) {
		this.logID = logID;
	}

	public Reader getReader_id() {
		return reader_id;
	}

	public void setReader_id(Reader reader_id) {
		this.reader_id = reader_id;
	}

	public Date getLogedInDate() {
		return logedInDate;
	}

	public void setLogedInDate(Date logedInDate) {
		this.logedInDate = logedInDate;
	}
	
	
	
	
	
}
