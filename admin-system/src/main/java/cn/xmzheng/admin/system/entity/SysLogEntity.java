package cn.xmzheng.admin.system.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import lombok.Data;

@Entity(name = "sys_log")
public @Data class SysLogEntity {
	@GeneratedValue
	private long id;
	private String tableName;
	private String mode;
	private String operator;
	private Date logTime;
	private String prePersist, postPersist;
	private String memo;
}
