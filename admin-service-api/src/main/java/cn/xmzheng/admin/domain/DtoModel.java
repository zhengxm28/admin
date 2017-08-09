package cn.xmzheng.admin.domain;

import lombok.Data;

public @Data class DtoModel<T> {
	private String module;
	private String mode;
	private boolean isAccess;
	
	enum Operator {
		
	}
}