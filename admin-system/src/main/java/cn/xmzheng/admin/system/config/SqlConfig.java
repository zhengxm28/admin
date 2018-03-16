package cn.xmzheng.admin.system.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@ConfigurationProperties(prefix="sql.system")
@Data
public class SqlConfig {
	private String day2cycleOfApiTracing;
}
