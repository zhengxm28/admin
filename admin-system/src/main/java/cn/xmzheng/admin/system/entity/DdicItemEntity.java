package cn.xmzheng.admin.system.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity(name = "ddic_item")
public @Data class DdicItemEntity {
	@GeneratedValue
	@Id
	private int id;
	private int categoryId;
	private String key;
	private String value;
	private int sortNo;
	@Column(insertable = false)
	private int enable;
	private String memo;
	private String attribute1, attribute2, attribute3;
}
