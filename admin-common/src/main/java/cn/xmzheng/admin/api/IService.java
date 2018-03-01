package cn.xmzheng.admin.api;

import org.springframework.stereotype.Service;
/**
 * CQRS, 提供C, Q执行接口
 * @author fczheng
 *
 */
@Service
public interface IService {
	void excuteQuery();
	
	void excuteCommand();
}
