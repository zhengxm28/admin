package cn.xmzheng.admin.api.service.cqrs;

import cn.xmzheng.admin.domain.DtoModel;
/**
 * CQRS, 提供C, Q执行接口
 * @author fczheng
 *
 */
public interface IService<T> {
	DtoModel<T> excuteEvent(DtoModel<T> dto);
}
