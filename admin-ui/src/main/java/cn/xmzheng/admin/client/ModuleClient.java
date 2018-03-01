package cn.xmzheng.admin.client;

import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(name = "module-service", url = "${module-service.ip}:${module-service.port}", path = "/admin/module")
public interface ModuleClient {

}
