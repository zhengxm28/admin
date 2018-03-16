package cn.xmzheng.admin.module.dao.entity.share;

import javax.persistence.MappedSuperclass;

import lombok.Data;
import lombok.EqualsAndHashCode;

@MappedSuperclass
@Data
@EqualsAndHashCode(callSuper=true)
public class SortableIdName extends IdName {
	private int sortNo;
}
