package cn.xmzheng.admin.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
public @Data class RestException extends RuntimeException {
	private static final long serialVersionUID = 8759663554446017251L;
	
	private Object[] args;
	private String code;
}
