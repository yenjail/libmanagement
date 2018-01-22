package com.project.LibraryApp.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="reservation")
public class Reservation {
	
	@Id
	@GeneratedValue
	private Long reservedId;
	
	
	@Column(name="reserveDate")
	private Date reserveDate;
	
	@ManyToOne
	@JoinColumn(name="doc_code")
	private Document doc_code;
	
	@ManyToOne
	@JoinColumn(name="reader_id")
	private Reader reader_id;

	public Long getReservedId() {
		return reservedId;
	}

	public void setReservedId(Long reservedId) {
		this.reservedId = reservedId;
	}

	public Date getReserveDate() {
		return reserveDate;
	}

	public void setReserveDate(Date reserveDate) {
		this.reserveDate = reserveDate;
	}

	public Document getDoc_code() {
		return doc_code;
	}

	public void setDoc_code(Document doc_code) {
		this.doc_code = doc_code;
	}

	public Reader getReader_id() {
		return reader_id;
	}

	public void setReader_id(Reader reader_id) {
		this.reader_id = reader_id;
	}
	
	
	
	
}
