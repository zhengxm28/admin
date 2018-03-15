package cn.xmzheng.admin.system.service;

import org.springframework.stereotype.Service;

import cn.xmzheng.admin.api.service.cqrs.CommandService;
import cn.xmzheng.admin.domain.DtoModel;

@Service
public class CommandServiceImpl<T> implements CommandService<T> {

	@Override
	public DtoModel<T> command(DtoModel<T> dto) {
		return null;
	}

}
