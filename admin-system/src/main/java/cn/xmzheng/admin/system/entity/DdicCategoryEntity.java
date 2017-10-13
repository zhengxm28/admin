package cn.xmzheng.admin.system.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import lombok.Data;

@Entity(name = "ddic_category")
public @Data class DdicCategoryEntity {
	@GeneratedValue
	private int id;
	private String category;
	private String cnName;
	private String memo;
}
