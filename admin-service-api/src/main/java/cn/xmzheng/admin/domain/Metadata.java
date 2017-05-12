package cn.xmzheng.admin.domain;

import java.beans.PropertyDescriptor;

import org.apache.commons.collections.MultiMap;
import org.apache.commons.collections.map.MultiValueMap;

public class Metadata {
	private String module;  //模块
	private String cnName;  //中文名称
	private String tableName;  //对应表名
	private int status;  //状态标识位
	private int sortNo;  //排序号
	
	private boolean needLog;
	private MultiMap ddicInfo = new MultiValueMap();
	
	private Class<?> entityJavaType;
	private Object repositoryBean;
	private PropertyDescriptor[] pds;
	
	public String getModule() {
		return module;
	}
	public void setModule(String module) {
		this.module = module;
	}
	public String getCnName() {
		return cnName;
	}
	public void setCnName(String cnName) {
		this.cnName = cnName;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getSortNo() {
		return sortNo;
	}
	public void setSortNo(int sortNo) {
		this.sortNo = sortNo;
	}
	public boolean isNeedLog() {
		return needLog;
	}
	public void setNeedLog(boolean needLog) {
		this.needLog = needLog;
	}
	public MultiMap getDdicInfo() {
		return ddicInfo;
	}
	public void setDdicInfo(MultiMap ddicInfo) {
		this.ddicInfo = ddicInfo;
	}
	public Class<?> getEntityJavaType() {
		return entityJavaType;
	}
	public void setEntityJavaType(Class<?> entityJavaType) {
		this.entityJavaType = entityJavaType;
	}
	public Object getRepositoryBean() {
		return repositoryBean;
	}
	public void setRepositoryBean(Object repositoryBean) {
		this.repositoryBean = repositoryBean;
	}
	public PropertyDescriptor[] getPds() {
		return pds;
	}
	public void setPds(PropertyDescriptor[] pds) {
		this.pds = pds;
	}
}
