package cn.xmzheng.admin.system.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.Data;

@Entity(name = "metadata")
public @Data class MetadataEntity {
	private String module;
	private String cnName;
	private String tableName;
	private int sortNo;
	@Column(name = "switch")
	private int onoff;
}
