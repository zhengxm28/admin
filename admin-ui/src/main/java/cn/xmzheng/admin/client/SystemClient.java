package cn.xmzheng.admin.client;

import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(name = "system-service", url = "${system-service.ip}:${system-service.port}", path = "/admin/system")
public interface SystemClient {

}
