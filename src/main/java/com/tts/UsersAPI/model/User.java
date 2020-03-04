package com.tts.UsersAPI.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="id")
		private Long id;
		
		@Length(max = 20, message = "Your username cannot have more than 20 characters")
		@Column(name="first_Name")
		private String first_name;

		@Length(min = 2, message = "Your username must have at least 2 characters")
		@Column(name="last_Name")
		private String last_name;
		
		@Length(min = 4, message = "Your username must have at least 4 characters")
		@Length(max = 20, message = "Your username cannot have more than 20 characters")
		@Column(name="state")
		private String state;


}
