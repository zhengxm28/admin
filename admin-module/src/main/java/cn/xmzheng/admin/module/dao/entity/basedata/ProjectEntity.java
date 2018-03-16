package cn.xmzheng.admin.module.dao.entity.basedata;

import java.sql.Date;

import javax.persistence.Entity;

import cn.xmzheng.admin.module.dao.entity.share.SortableIdName;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity(name = "project")
@Data
@EqualsAndHashCode(callSuper = true)
public class ProjectEntity extends SortableIdName {
	private String principal; // 项目负责人
	private Date setupDate; // 立项日期
	private String department; // 部门
	private String invoiceType; // 发票类型
}
