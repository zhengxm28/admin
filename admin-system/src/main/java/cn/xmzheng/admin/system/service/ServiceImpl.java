package cn.xmzheng.admin.system.service;

import java.lang.reflect.Method;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import cn.xmzheng.admin.api.service.MetadataService;
import cn.xmzheng.admin.api.service.cqrs.AccessService;
import cn.xmzheng.admin.api.service.cqrs.CommandService;
import cn.xmzheng.admin.api.service.cqrs.IService;
import cn.xmzheng.admin.domain.DtoModel;
import cn.xmzheng.admin.domain.Metadata;
import cn.xmzheng.admin.exception.ServiceException;

@Service
public class ServiceImpl<T> implements IService<T> {
	private static final Logger logger = LoggerFactory.getLogger(ServiceImpl.class);

	@Autowired
	MetadataService metadataService;
	@Autowired
	AccessService<T> accessService;
	@Autowired
	CommandService<T> commandService;

	@SuppressWarnings("unchecked")
	@Override
	public DtoModel<T> excuteEvent(DtoModel<T> dto) {
		try {
			Metadata meta = metadataService.findOne(dto.getModule());
			if (meta.getDeclaredMethodsCache().contains(dto.getOperation())) {
				Class<?> paramTypes = dto.getBody() == null ? String.class : dto.getBody().getClass();
				Method method = ReflectionUtils.findMethod(meta.getRepository().getClass(), dto.getOperation(),
						paramTypes);
				return (DtoModel<T>) ReflectionUtils.invokeJdbcMethod(method, meta.getRepository(), dto.getBody());
			}
			if (dto.getEvent().isQuery())
				return accessService.query(dto);
			return commandService.command(dto);
		} catch (SQLException e) {
			logger.error(e.getLocalizedMessage());
			throw new ServiceException(e.getMessage(), e.getCause());
		}
	}
}
