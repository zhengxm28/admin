package cn.xmzheng.admin.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.xmzheng.admin.api.service.cqrs.AccessService;
import cn.xmzheng.admin.api.service.cqrs.CommandService;
import cn.xmzheng.admin.api.service.cqrs.IService;
import cn.xmzheng.admin.domain.DtoModel;

@Service
public class ServiceImpl<T> implements IService<T> {
	@Autowired
	AccessService<T> accessService;
	@Autowired
	CommandService<T> commandService;

	@Override
	public DtoModel<T> excuteEvent(DtoModel<T> dto) {
		if (dto.getEvent().isQuery())
			return accessService.query(dto);
		return commandService.command(dto);
	}

}
