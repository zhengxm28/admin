package cn.xmzheng.admin.system.service;

import org.springframework.stereotype.Service;

import cn.xmzheng.admin.api.service.cqrs.AccessService;
import cn.xmzheng.admin.domain.DtoModel;

@Service
public class AccessServiceImpl<T> implements AccessService<T> {

	@Override
	public DtoModel<T> query(DtoModel<T> dto) {
		return null;
	}


}
