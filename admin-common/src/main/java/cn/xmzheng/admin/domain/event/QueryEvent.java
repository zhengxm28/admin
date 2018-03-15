package cn.xmzheng.admin.domain.event;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort.Order;

import lombok.Data;

@Data
public class QueryEvent<T> implements Event {
	// 分页参数
	private int currentPage;
	private int plength;
	
	// 排序&查询参数
	private List<Order> orders;
	private Map<String, Object> extendMap;
	
	// 返回参数
	private Page<T> pages;

	@Override
	public boolean isQuery() {
		return true;
	}

}
