package cn.xmzheng.admin.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "metadata")
public class MetadataEntity {
	private String id;

	@Id
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
