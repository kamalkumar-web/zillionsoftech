package com.zillionsoftech.org.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Set;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

/**
 * @author Sandeep Rana
 *
 */
@Entity
@Table(name ="USERS") @Data
public class Users implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1786785627835L;

	@Id
	@Column(name ="userId", nullable = false, length = 100)
	private String userId;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String phone;
	
	private String fullName;
	
	@JsonIgnore
	private String password;
	
	private boolean isEnable;
	
	private boolean isExpried;
	
	private Long userCreatedDate;

	@ManyToMany(fetch = FetchType.LAZY)
	private Set<Roles> roles;

	public Users() {
		this.isEnable = Boolean.TRUE;
		this.isExpried = Boolean.TRUE;
		this.userCreatedDate = LocalDateTime.now().atZone(ZoneId.of("UTC")).toInstant().toEpochMilli();
	}
	

}
