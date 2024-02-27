package org.ecolemathiasgrunewald.absenceApi.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@DynamicUpdate
@Table(name="class")
public class ClassSchool {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_class")
	private int classId;
	
	private String name;
	
	@JsonManagedReference
	@ManyToOne(
			cascade = {
					CascadeType.PERSIST,
					CascadeType.MERGE
			},
			fetch = FetchType.EAGER
			)
	@JoinColumn(name = "cycle_id")
	private Cycle cycle;
	
	@JsonBackReference
	@OneToMany(
			mappedBy = "classSchool",
			cascade = {
					CascadeType.PERSIST,
					CascadeType.MERGE
			}
			)
	private List<Child> child = new ArrayList<>();

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Cycle getCycle() {
		return cycle;
	}

	public void setCycle(Cycle cycle) {
		this.cycle = cycle;
	}

	public List<Child> getChild() {
		return child;
	}

	public void setChild(List<Child> child) {
		this.child = child;
	}

	
	
	
	
}
