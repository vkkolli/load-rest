package com.cei.load.domain;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.cei.load.domain.vo.Auditable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The Class LoadStatus.
 */
@Entity
@Table(name = "load_status", schema = "logisol")
@AttributeOverride(name = "id", column = @Column(name = "load_status_id"))
@SequenceGenerator(name = "seq", sequenceName = "logisol.load_status_seq", allocationSize = 1)
@Getter
@Setter
@NoArgsConstructor
public class LoadStatus extends Auditable<Long> {

	/** The load status name. */
	@Column(name = "load_status_name")
	String name;

	/** The description. */
	@Column(name = "description")
	String description;

	/** The is active. */
	@Column(name = "is_active")
	boolean isActive;
	
	public LoadStatus(Long id) {
		setId(id);
	}

	/**
	 * 10 Posted 
	 * 20 Carrier Assigned 
	 * 30 Pending Pickup 
	 * 40 In Transit 
	 * 50 Delivered
	 */
}
