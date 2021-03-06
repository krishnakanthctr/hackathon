package com.orders.dto;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "BATCH_JOB_EXECUTION")
public class BatchJobExecution {

	@Id
	@Column(name = "JOB_EXECUTION_ID")
	private Long jobExecutionId;

	@Column(name = "VERSION")
	private Long version;

	@Column(name = "JOB_INSTANCE_ID")
	private long jobInstanceId;

	@Column(name = "CREATE_TIME")
	private Timestamp createTime;

	@Column(name = "START_TIME")
	private Timestamp startTime;

	@Column(name = "END_TIME")
	private Timestamp endTime;

	@Column(name = "STATUS")
	private String status;

	@Column(name = "EXIT_CODE")
	private String exitCode;

	@Column(name = "EXIT_MESSAGE")
	private String exitMessage;

	@Column(name = "LAST_UPDATED")
	private Timestamp lastUpdated;

	@Column(name = "JOB_CONFIGURATION_LOCATION")
	private String jobConfigurationLocation;
}