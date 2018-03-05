package cn.xmzheng.admin.exception;

import java.util.Locale;

import org.apache.shiro.authc.AuthenticationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import cn.xmzheng.admin.domain.RestMessage;

@RestControllerAdvice
public class RestExceptionHandler {
	private static final Logger logger = LoggerFactory.getLogger(RestExceptionHandler.class);
	private static final String UNEXPECTED_ERROR = "Exception.unexpected";
	private static final String AUTHENTICATION_ERROR = "Exception.unauthorized";

	@Autowired
	private MessageSource messageSource;

	@ExceptionHandler(RestException.class)
	public RestMessage<String> handleIllegalmentArgument(RestException ex, Locale locale) {
		String errorMessage = messageSource.getMessage(ex.getMessage(), ex.getArgs(), locale);
		return RestMessage.buildFail(HttpStatus.BAD_REQUEST.value(), errorMessage);
	}

	@ExceptionHandler(AuthenticationException.class)
	public RestMessage<String> handleAuthenticationException(AuthenticationException ex, Locale locale) {
		String errorMessage = messageSource.getMessage(AUTHENTICATION_ERROR, null, locale);
		logger.error(errorMessage, ex.getCause());
		return RestMessage.buildFail(HttpStatus.UNAUTHORIZED.value(), errorMessage);
	}

	@ExceptionHandler(Exception.class)
	public RestMessage<String> handleExceptions(Exception ex, Locale locale) {
		String errorMessage = messageSource.getMessage(UNEXPECTED_ERROR, null, locale);
		logger.error(errorMessage, ex.getCause());
		return RestMessage.buildFail(HttpStatus.INTERNAL_SERVER_ERROR.value(), errorMessage);
	}

}
