package cn.xmzheng.admin.module.dao.entity.share;


import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Data;

@MappedSuperclass
@Data
public class IdName {
	@Id
	private String id;
	@Column(length = 128)
	private String name;
	
	@Override
	public String toString() {
		return "IdName [id=" + id + ", name=" + name + "]";
	}
}
