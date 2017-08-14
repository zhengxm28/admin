package cn.xmzheng.admin.system.domain;

import lombok.Data;

public @Data class DtoModel {
	// 模块名称
	private String module;

	// 动作参数
	private String mode;
	private boolean isAccess;

	// 分页参数
	private int currentPage;
	private long total;

	enum Operator {

	}
}