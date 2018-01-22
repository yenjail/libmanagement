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
@Table(name="requestReservation")
public class RequestReservation {
	
	@Id
	@GeneratedValue
	private Long reqId;
	
	
	@Column(name="reserveDate")
	private Date reserveDate;
	
	@Column(name="confirm")
	private boolean confirm;
	
	

	@ManyToOne
	@JoinColumn(name="doc_code")
	private Document doc_code;
	
	@ManyToOne
	@JoinColumn(name="reader_id")
	private Reader reader_id;

	
	

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

	public Long getReqId() {
		return reqId;
	}

	public void setReqId(Long reqId) {
		this.reqId = reqId;
	}

	

	public Date getReserveDate() {
		return reserveDate;
	}

	public void setReserveDate(Date reserveDate) {
		this.reserveDate = reserveDate;
	}
	
	public boolean isConfirm() {
		return confirm;
	}

	public void setConfirm(boolean confirm) {
		this.confirm = confirm;
	}
}
