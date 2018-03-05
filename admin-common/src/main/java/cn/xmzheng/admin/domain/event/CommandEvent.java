package cn.xmzheng.admin.domain.event;

public class CommandEvent implements Event {

	@Override
	public boolean isQuery() {
		return false;
	}

}
