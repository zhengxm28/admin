package cn.xmzheng.admin.api.service.cqrs;

import cn.xmzheng.admin.domain.DtoModel;

public interface CommandService<T> {
	DtoModel<T> command(DtoModel<T> dto);
}
