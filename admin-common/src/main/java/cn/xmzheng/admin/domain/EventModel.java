package cn.xmzheng.admin.domain;

import lombok.Data;

@Data
public class EventModel {
	private String methodName;
	private Object respositoryBean;
	private Object[] args;
}
