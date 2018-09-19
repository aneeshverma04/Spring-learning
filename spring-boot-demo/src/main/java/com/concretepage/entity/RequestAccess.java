package com.concretepage.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="requestaccess")
@EntityListeners(AuditingEntityListener.class)
public class RequestAccess implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="request_id")
	private int requestId;
	@Column(name="requestorname")
	private String requestorName;
	@Column(name="requestordomain")
	private String requestorDomain;
	@Column(name="platform_id")
	private int platformId;
	@Column(name="role_id")
	private int roleId;
	@Column(name="username")
	private String userName;
	@Column(name="userdomain")
	private String userDomain;
	@Column(name="pimaccess")
	private boolean pimAccess;
	@Column(name="validity")
	private Date validity;
	@Column(name="remarks")
	private String remarks;
	@Column(name="createddate")
	private Date createdDate;
	@Column(name="updateddate")
	private Date updatedDate;
	public int getRequestId() {
		return requestId;
	}
	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}
	public String getRequestorName() {
		return requestorName;
	}
	public void setRequestorName(String requestorName) {
		this.requestorName = requestorName;
	}
	public String getRequestorDomain() {
		return requestorDomain;
	}
	public void setRequestorDomain(String requestorDomain) {
		this.requestorDomain = requestorDomain;
	}
	public int getPlatformId() {
		return platformId;
	}
	public void setPlatformId(int platformId) {
		this.platformId = platformId;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserDomain() {
		return userDomain;
	}
	public void setUserDomain(String userDomain) {
		this.userDomain = userDomain;
	}
	public boolean getPimAccess() {
		return pimAccess;
	}
	public void setPimAccess(boolean pimAccess) {
		this.pimAccess = pimAccess;
	}
	public Date getValidity() {
		return validity;
	}
	public void setValidity(Date validity) {
		this.validity = validity;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
