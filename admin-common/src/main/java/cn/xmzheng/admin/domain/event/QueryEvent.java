package cn.xmzheng.admin.domain.event;

public class QueryEvent implements Event {

	@Override
	public boolean isQuery() {
		return true;
	}

}
