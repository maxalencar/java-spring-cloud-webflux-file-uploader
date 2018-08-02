package com.cs.upload.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @author Max.Alencar
 *
 */
@Entity
@Table(name = "EVENTS")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Event {

	@Id
	@Column(name = "ID")
	private String id;

	@Column(name = "DURATION")
	private Long timestamp;

	@Column(name = "TYPE")
	private String type;

	@Column(name = "HOST")
	private String host;

	@Column(name = "ALERT")
	private Boolean alert;
	
	private transient String state;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}
	
	public Boolean getAlert() {
		return alert;
	}

	public void setAlert(Boolean alert) {
		this.alert = alert;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Event{id=" + id + ", timestamp=" + timestamp + ", type=" + type + ", host=" + host + ", alert=" + alert + ", state=" + state
				+ "}";
	}

}
