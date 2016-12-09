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
@Table(name="QUESTION")
public class Question implements Serializable{
	private static final long serialVersionUID = -3816649226815526951L;

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
 
    @ManyToOne(optional = false)	
    @JoinColumn(name = "SUBJECT_ID")
    private Subject subject; 
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "USER_ID")
    private User user;
    
     
    @Column(name = "TEXT")
    private String text;
    
    public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
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

	public Integer getId() {
        return id;
    }
 
    public void setId(Integer id) {
        this.id = id;
    }
 
   

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }
 
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Question))
            return false;
        Question other = (Question) obj;
        if (id != other.id)
            return false;
        return true;
    }
 
    @Override
    public String toString() {
        return "User [id=" + id + ", text=" + text + "]";
    }
 
 
     
}