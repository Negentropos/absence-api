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
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@DynamicUpdate
@Table(name="child")
public class Child {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_child")
	private int childId;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@JsonBackReference
	@OneToMany(
			mappedBy = "child",
			cascade = {
					CascadeType.PERSIST,
					CascadeType.MERGE
			}
			)
	private List<Absence> absences = new ArrayList<>();
	
	@JsonManagedReference
	@ManyToOne(
			cascade = {
					CascadeType.PERSIST,
					CascadeType.MERGE
			},
			fetch = FetchType.EAGER
			)
	@JoinColumn(name = "class_id_class")
	private ClassSchool classSchool;
	
	@JsonManagedReference
	@ManyToMany(
			mappedBy = "childs",
			cascade = {
							CascadeType.PERSIST,
							CascadeType.MERGE,
						}
			)
	private List<Parent> parents = new ArrayList<>();




	
	// TODO : Méthodes utilitaires à ajouter plus tard...
	
	
	
	

}
