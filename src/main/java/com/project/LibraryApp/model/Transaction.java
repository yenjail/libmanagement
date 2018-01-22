package com.project.LibraryApp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author anjil
 *
 */
@Entity
@Table(name="transaction")
public class Transaction {
	
	@Id
	@GeneratedValue
	private Long transId;
	
	@ManyToOne
	@JoinColumn(name="doc_code")
	private Document doc_code;
	
	@ManyToOne
	@JoinColumn(name = "reader_id")
	private Reader reader_id;
	
	@Column( name = "loanedDate")
	private Date loanedDate;
	
	@Column( name="returnStatus" )
	private Boolean returnStatus;

	
	
	public Date getLoanedDate() {
		return loanedDate;
	}

	public void setLoanedDate(Date loanedDate) {
		this.loanedDate = loanedDate;
	}



	public Long getTransId() {
		return transId;
	}

	public void setTransId(Long transId) {
		this.transId = transId;
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

	public Boolean getReturnStatus() {
		return returnStatus;
	}

	public void setReturnStatus(Boolean returnStatus) {
		this.returnStatus = returnStatus;
	}

}
