package cn.xmzheng.admin.system.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.EntityType;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cglib.core.ReflectUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import cn.xmzheng.admin.api.service.MetadataService;
import cn.xmzheng.admin.common.util.ClazzUtil;
import cn.xmzheng.admin.constants.Constants;
import cn.xmzheng.admin.domain.Metadata;
import cn.xmzheng.admin.system.dao.entity.MetadataEntity;
import cn.xmzheng.admin.system.dao.repository.MetadataRepository;

@Service
public class MetadataServiceImpl implements MetadataService, InitializingBean {

	@Autowired
	EntityManager entityManager;
	@Autowired
	ApplicationContext context;
	@Autowired
	MetadataRepository metadataRepository;

	private Map<String, String> entityMap = new HashMap<>();

	@Override
	@Cacheable(value = "metadata", key = "#root.methodName")
	public List<Metadata> findAll() {
		List<Metadata> result = new ArrayList<>();
		List<MetadataEntity> entitys = metadataRepository.findAll();
		entitys.forEach(e -> {
			Metadata meta = new Metadata();
			BeanUtils.copyProperties(e, meta);
			fillMeta(meta);
			result.add(meta);
		});
		return result;
	}

	@Override
	@Cacheable(value = "metadata", key = "#module")
	public Metadata findOne(String module) {
		List<Metadata> allMetadata = findAll();
		for (Metadata e : allMetadata)
			if (module.equals(e.getModule()))
				return e;
		throw new IllegalArgumentException("module metadata not exist");
	}

	@Override
	public List<Metadata> findGroup(String group) {
		return null;
	}

	@Override
	@Cacheable(value = "metadata", key = "#entityClass")
	public Metadata findOne(Class<?> entityClass) {
		List<Metadata> allMetadata = findAll();
		for (Metadata e : allMetadata)
			if (entityClass.equals(e.getEntityJavaType()))
				return e;
		throw new IllegalArgumentException("module metadata not exist");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		Set<EntityType<?>> entities = entityManager.getMetamodel().getEntities();
		// key:table,value:EntityClass
		entities.forEach(e -> entityMap.put(e.getName(), e.getBindableJavaType().getName()));
	}

	/**
	 * 填充metaInfo上下文属性
	 * 
	 * @param metadataInfo
	 */
	private void fillMeta(Metadata metadata) {
		String entityClass = entityMap.get(metadata.getTableName());
		String[] arr = entityClass.split(Constants.POINT_SEPERATOR);
		String repository = arr[arr.length - 1].replace("Entity", "Repository");
		Object repositoryBean = context.getBean(repository);
		metadata.setRepository(repositoryBean);
		metadata.setEntityJavaType(ClazzUtil.getJavaType(entityClass));
		metadata.setPds(ReflectUtils.getBeanProperties(metadata.getEntityJavaType()));
		// setDdic(metadata);
	}

}
