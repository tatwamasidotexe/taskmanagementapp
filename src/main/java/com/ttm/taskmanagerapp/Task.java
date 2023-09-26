package com.ttm.taskmanagerapp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Task {
	
	//	setting id as primary key and generating a random value for it
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column
    private String title;
    
    @Column
    private String description;
    
    @Column(name="isCompleted")
    private boolean completed;

    // CONSTRUCTORS    
    @SuppressWarnings("unused")
	private Task() {}
    
    
    public Task(String title, String desc) {
    	this.title = title;
    	this.description = desc;
    	this.completed = false;
    }
    
     //    SETTERS
    public void setTitle(String title) {
    	this.title = title;
    }
    
    public void setDesc(String desc) {
    	this.description = desc;
    }
    
    public void setStatus(boolean status) {
    	this.completed = status;
    }
    
//    GETTERS
    public Long getId() {
    	return this.id;
    }
    
    public String getTitle() {
    	return this.title;
    }
    
    public String getDesc() {
    	return this.description;
    }
    
    public boolean getStatus() {
    	return this.completed;
    }
}