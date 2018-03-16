package cn.xmzheng.admin.system.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity(name = "metadata")
public @Data class MetadataEntity {
	@Id
	private String module;
	private String cnName;
	private String tableName;
	private int sortNo;
	@Column(name = "switch")
	private int onOff;
}
