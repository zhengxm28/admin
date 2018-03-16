package cn.xmzheng.admin.system.dao.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity(name = "ddic_category")
public @Data class DdicCategoryEntity {
	@GeneratedValue
	@Id
	private int id;
	private String category;
	private String cnName;
	private String memo;
}
