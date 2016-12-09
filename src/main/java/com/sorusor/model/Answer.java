package com.sorusor.model;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
 
@Entity
@Table(name="ANSWER")
public class Answer implements Serializable{
	private static final long serialVersionUID = -3816649226815526951L;

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
 
    @ManyToOne(optional = false)	
    @JoinColumn(name = "QUESTION_ID")
    private Question question; 
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "USER_ID")
    private User user;
     
    @Column(name = "TEXT")
    private String text;
    
    @Override
    public String toString() {
        return "Answer [id=" + id + ", text=" + text + "]";
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public Question getQuestion() {
		return question;
	}


	public void setQuestion(Question question) {
		this.question = question;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public String getText() {
		return text;
	}


	public void setText(String text) {
		this.text = text;
	}
 
 
     
}