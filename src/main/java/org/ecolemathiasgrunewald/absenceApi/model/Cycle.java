package org.ecolemathiasgrunewald.absenceApi.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="cycle")
public class Cycle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_cycle")
	private int cycleId;
	
	private String description;
	
	private String name;
	
	@JsonBackReference
	@OneToMany(
			mappedBy = "cycle",
			cascade = {
					CascadeType.PERSIST,
					CascadeType.MERGE
			}
			)
	private List<ClassSchool> classes = new ArrayList<>();
	
	@JsonBackReference
	@ManyToMany(
			mappedBy = "cycles",
			cascade = {
							CascadeType.PERSIST,
							CascadeType.MERGE,
						}
			)
	private List<User> users = new ArrayList<>();

	public int getCycleId() {
		return cycleId;
	}

	public void setCycleId(int cycleId) {
		this.cycleId = cycleId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ClassSchool> getClasses() {
		return classes;
	}

	public void setClasses(List<ClassSchool> classes) {
		this.classes = classes;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	

	
}
