package org.ecolemathiasgrunewald.absenceApi.model;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;

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
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@DynamicUpdate
@Table(name="absence")
public class Absence {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_absence")
	private int absenceId;
	
	@Column(name = "date", columnDefinition = "DATE")
	private LocalDate date;
	
	@Column(name = "start_time", columnDefinition = "TIME")
	private LocalTime startTime;
	
	@Column(name = "end_time", columnDefinition = "TIME")
	private LocalTime endTime;
	
	@Column(name = "declaration_date", columnDefinition = "DATETIME")
	private LocalTime declarationDate;
	
	private String description;
	
	@Column(name = "canteen",nullable = false, columnDefinition = "TINYINT(1)")
	private boolean canteen;
	
	@Column(name = "nursery",nullable = false, columnDefinition = "TINYINT(1)")
	private boolean nursery;
	
	@Column(name = "after_school",nullable = false, columnDefinition = "TINYINT(1)")
	private boolean afterSchool;
	
	@JsonManagedReference
	@ManyToOne(
			cascade = CascadeType.ALL,
			fetch = FetchType.EAGER
			)
	@JoinColumn(name = "user_id")
	private User user;
	
	@JsonManagedReference
	@ManyToOne(
			cascade = CascadeType.ALL,
			fetch = FetchType.EAGER
			)
	@JoinColumn(name = "child_id")
	private Child child;

	public int getAbsenceId() {
		return absenceId;
	}

	public void setAbsenceId(int absenceId) {
		this.absenceId = absenceId;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public LocalTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isCanteen() {
		return canteen;
	}

	public void setCanteen(boolean canteen) {
		this.canteen = canteen;
	}

	public boolean isNursery() {
		return nursery;
	}

	public void setNursery(boolean nursery) {
		this.nursery = nursery;
	}

	public boolean isAfterSchool() {
		return afterSchool;
	}

	public void setAfterSchool(boolean afterSchool) {
		this.afterSchool = afterSchool;
	}

	public Child getChild() {
		return child;
	}

	public void setChild(Child child) {
		this.child = child;
	}
	
	

	
}
