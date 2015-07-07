package com.techstudio.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="groomer")
public class Groomer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6914517629295065618L;

	public Groomer()
	{
		this.type = "";
		this.title = "";
		this.quote = "";
		this.logo = "";
		this.author = "";
	}
	
	@Id
	@GeneratedValue
	@Column(name = "id", columnDefinition="bigint", unique = true, nullable=false)
	private Long id;

	@Column(name = "type", columnDefinition="varchar(200)", nullable=false)
	private String type;
	
	@Column(name = "title", columnDefinition="varchar(100)", nullable=false)
	private String title;
	
	@Column(name = "quote", columnDefinition="varchar(100)", nullable=false)
	private String quote;
	
	@Column(name = "author", columnDefinition="varchar(50)", nullable=false)
	private String author;
	
	@Column(name = "logo", columnDefinition="varchar(100)", nullable=false)
	private String logo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getQuote() {
		return quote;
	}

	public void setQuote(String quote) {
		this.quote = quote;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}
	

	

	
}
