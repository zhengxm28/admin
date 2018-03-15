package cn.xmzheng.admin.api.service.cqrs;

import cn.xmzheng.admin.domain.DtoModel;

public interface AccessService<T> {
	DtoModel<T> query(DtoModel<T> dto);
}
