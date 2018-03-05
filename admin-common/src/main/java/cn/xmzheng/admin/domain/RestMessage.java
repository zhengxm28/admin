package cn.xmzheng.admin.domain;

import lombok.Data;

public @Data class RestMessage<T> {
	private boolean isSuccess;

	private int code;
	private T body;

	public static <T> RestMessage<T> buildOk(T body) {
		RestMessage<T> result = new RestMessage<>();
		result.setSuccess(true);
		result.setBody(body);
		return result;
	}

	public static RestMessage<String> buildFail(int code, String message) {
		RestMessage<String> result = new RestMessage<>();
		result.setSuccess(false);
		result.setCode(code);
		result.setBody(message);
		return result;
	}
}
