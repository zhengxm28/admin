package cn.xmzheng.admin.system;

import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableRedisHttpSession(maxInactiveIntervalInSeconds=30*60*1000)
@EnableCaching
public class Application {
	@Autowired StringRedisTemplate template;
	@Autowired CacheManager cacheManager;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@GetMapping("/test")
	public String test(HttpSession session) {
		Cache cache = cacheManager.getCache("admin:system");
		cache.put(session.getId(), "test");
		Set<Object> keys = template.opsForHash().keys("spring:session:sessions:" + session.getId());
		System.out.println(keys);
		return session.getId();
	}
}
