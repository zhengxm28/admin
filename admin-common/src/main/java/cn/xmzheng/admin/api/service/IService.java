package cn.xmzheng.admin.api.service;

import org.springframework.stereotype.Service;

import cn.xmzheng.admin.domain.event.Event;
/**
 * CQRS, 提供C, Q执行接口
 * @author fczheng
 *
 */
@Service
public interface IService {
	void excuteQuery(Event queryEvent);
	
	void excuteCommand(Event commandEvent);
}
