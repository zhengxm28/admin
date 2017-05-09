package cn.xmzheng.admin.common.convert;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.core.convert.converter.Converter;

public class ListConverts<S, T> implements Converter<List<S>, List<T>> {
	private Class<T> clazz;

	public ListConverts(Class<T> clazz) {
		this.clazz = clazz;
	}

	@Override
	public List<T> convert(List<S> source) {
		List<T> target = new ArrayList<>();
		for (S s : source) {
			try {
				T t = clazz.newInstance();
				BeanUtils.copyProperties(s, t);
				target.add(t);
			} catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			}

		}
		return target;
	}

	public static <S, T> ListConverts<S, T> newInstance(Class<T> clazz) {
		return new ListConverts<S, T>(clazz);
	}

}
