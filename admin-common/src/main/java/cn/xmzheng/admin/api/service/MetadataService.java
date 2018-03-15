package cn.xmzheng.admin.api.service;

import java.util.List;

import cn.xmzheng.admin.domain.Metadata;

public interface MetadataService {
	List<Metadata> findAll();
	Metadata findOne(String module);
	
	List<Metadata> findGroup(String group);
	Metadata findOne(Class<?> entityClass);
}
