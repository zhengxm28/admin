package cn.xmzheng.admin.module.dao.entity.basedata;

import javax.persistence.Entity;

import cn.xmzheng.admin.module.dao.entity.share.SortableIdName;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity(name = "supplier")
@Data
@EqualsAndHashCode(callSuper = true)
public class SupplierEntity extends SortableIdName {

}
