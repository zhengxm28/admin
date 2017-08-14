package cn.xmzheng.admin.domain;

import java.beans.PropertyDescriptor;

import org.apache.commons.collections.MultiMap;
import org.apache.commons.collections.map.MultiValueMap;

import lombok.Data;

public @Data class Metadata {
	private String module; // 模块
	private String cnName; // 中文名称
	private String tableName; // 对应表名
	private int status; // 状态标识位
	private int sortNo; // 排序
	private Class<?> entityJavaType; // 数据层class
	private PropertyDescriptor[] pds; // 数据层pd描述
	private Object repositoryBean; // repository类对单例
	private MultiMap ddicInfo = new MultiValueMap(); // 数据字典信息
}
