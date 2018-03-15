package cn.xmzheng.admin.domain.event;

import lombok.Data;

@Data
public class CommandEvent<T> implements Event {
	private String operation;
	
	@Override
	public boolean isQuery() {
		return false;
	}

	
}
