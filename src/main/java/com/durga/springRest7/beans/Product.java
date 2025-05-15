package com.durga.springRest7.beans;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="product")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	@Id
	@Column(name="pid")
	private int pid;
	@Column(name="pname")
	private String pname;
	@Column(name="pdesc")
	private String pdesc;
	
	

}
