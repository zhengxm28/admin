package cn.xmzheng.admin.common.util;

import java.beans.PropertyDescriptor;
import java.nio.file.ProviderNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ObjectUtils;

import cn.xmzheng.admin.common.annotation.Ddic;

public class ClazzUtil {
	private ClazzUtil() {
	}

	private static final Logger logger = LoggerFactory.getLogger(ClazzUtil.class);

	/**
	 * @param javaType
	 * @return
	 * @throws ClassNotFoundException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	public static Object getInstance(Class<?> javaType) {
		try {
			return javaType.newInstance();
		} catch (Exception e) {
			logger.error(javaType + " not exist");
			throw new ProviderNotFoundException("javaType not exist");
		}

	}

	/**
	 * @param entityClass
	 * @return
	 * @throws ClassNotFound
	 */
	public static Class<?> getJavaType(String entityClass) {
		try {
			return Class.forName(entityClass);
		} catch (Exception e) {
			logger.error(entityClass + " not exist");
			throw new ProviderNotFoundException("entityClass not exist");
		}
	}

	/**
	 * @param pds
	 * @return
	 */
	public static List<PropertyDescriptor> findDdicProperty(PropertyDescriptor[] pds) {
		List<PropertyDescriptor> pdResult = new ArrayList<>();
		for (PropertyDescriptor pd : pds) {
			Ddic ddic = pd.getReadMethod().getAnnotation(Ddic.class);
			if (!ObjectUtils.isEmpty(ddic)) {
				pdResult.add(pd);
			}
		}
		return pdResult;
	}

	/**
	 * @param pds
	 * @param name
	 * @return
	 */
	public static PropertyDescriptor findProperty(PropertyDescriptor[] pds, String name) {
		for (PropertyDescriptor pd : pds) {
			if (pd.getName().equals(name))
				return pd;
		}
		logger.error("{}: field not exist", name);
		throw new ProviderNotFoundException("field not exist");
	}
	
}
