package cn.xmzheng.admin.exception;

import org.springframework.core.NestedRuntimeException;

public class ServiceException extends NestedRuntimeException {

	private static final long serialVersionUID = 7810772670884551075L;

	public ServiceException(String msg) {
		super(msg);
	}

	public ServiceException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
