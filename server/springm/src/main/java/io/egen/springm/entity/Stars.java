package io.egen.springm.entity;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table
@NamedQueries({ 
	@NamedQuery(name = "Stars.findById", query = "SELECT s FROM Stars s WHERE s.id=:pStarId"),
})
public class Stars {
	
	@Id
	@GenericGenerator(name = "customUUID", strategy = "uuid2")
	@GeneratedValue(generator = "customUUID")
	private String id;
	
	@ElementCollection
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<String> actor;
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public List<String> getActor() {
		return actor;
	}
	public void setActor(List<String> actor) {
		this.actor = actor;
	}
	@Override
	public String toString() {
		return "Actors [id=" + id + ", actor=" + actor + "]";
	}
	
}