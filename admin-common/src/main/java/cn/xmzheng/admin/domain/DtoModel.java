package cn.xmzheng.admin.domain;

import cn.xmzheng.admin.domain.event.Event;
import lombok.Data;

public @Data class DtoModel<T> {
	private Event event;
	private String module;
	private String operation;
	private T body;
}