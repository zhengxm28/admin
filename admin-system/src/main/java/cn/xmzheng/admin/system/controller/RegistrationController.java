package cn.xmzheng.admin.system.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Applications;

@RestController
public class RegistrationController {
	@Autowired EurekaClient eurekaClient;
	@Autowired
	CacheManager cacheManager;
	@Autowired
	StringRedisTemplate template;
	/**
	 * @return
	 */
	@GetMapping("/instance-info")
	public Applications showInfo() {
		return eurekaClient.getApplications();
	}
	
	@GetMapping("/test")
	public String test(HttpSession session) {
		cacheManager.getCache("admin:system").put(session.getId(), "test");
		return "test";
	}
	
	@GetMapping("/testRedis")
	public String testRedis() {
		for (int i=0; i<50000; i++) {
			System.out.println(template.opsForHash().entries("aaaa"));
			System.out.println(i);
		}
		return "okay";
	}
}
