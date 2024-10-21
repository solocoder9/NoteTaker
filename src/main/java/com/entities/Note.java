package com.entities;

import java.util.Date;
import java.util.Random;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "notes")
public class Note {
	
	@Id
	private int id; // Unique identifier for the note
	
	private String title; // Title of the note
	
	@Column(length = 1500) // Limiting the length of the content
	private String content; // Content of the note
	
	private Date addedDate; // Date when the note was added

	// Default constructor
	public Note() {
		super();
	}

	// Parameterized constructor
	public Note(String title, String content, Date addedDate) {
		super();
		this.id = new Random().nextInt(100000); // Generates a random ID
		this.title = title;
		this.content = content;
		this.addedDate = addedDate;
	}

	// Getters and Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}
}
