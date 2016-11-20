package com.sorusor.model;
import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

 
@Entity
@Table(name="SUBJECT")
public class Subject implements Serializable{
	private static final long serialVersionUID = 7448826104621881503L;

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
 
    @Column(name = "NAME")
    private String name;
    
//    @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL)
//    private List<Question> questions;
 
   

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
        if (!(obj instanceof Subject))
            return false;
        Subject other = (Subject) obj;
        if (id != other.id)
            return false;
        return true;
    }
 
    @Override
    public String toString() {
        return "Subject [id=" + id + ", name=" + name+ "]";
    }
 
 
     
}