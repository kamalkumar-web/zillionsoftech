package com.zillionsoftech.org.entities;

import lombok.Data;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Sandeep Rana
 *
 */
@Entity
@Table(name ="ROLES") @Data
public class Roles implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 12786472637846L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long roleId;
	
	private String roleName;
	
	private String roleDesc;


}
