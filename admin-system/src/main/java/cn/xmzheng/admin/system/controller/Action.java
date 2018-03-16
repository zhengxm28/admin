package cn.xmzheng.admin.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cn.xmzheng.admin.api.service.cqrs.IService;
import cn.xmzheng.admin.domain.DtoModel;
import cn.xmzheng.admin.domain.event.CommandEvent;
import cn.xmzheng.admin.domain.event.QueryEvent;

@RestController
public class Action<T> {
	@Autowired
	IService<T> service;
	
	@GetMapping("/api/{module}/list")
    public Object findAll(@RequestBody QueryEvent<T> event, @PathVariable String module){
		DtoModel<T> dto = new DtoModel<>();
		dto.setModule(module);
		dto.setEvent(event);
		return service.excuteEvent(dto);
    }

	@PostMapping({"/api/{module}/save", "/api/{module}/edit", "/api/{module}/delete"})
    public Object operate(@RequestBody CommandEvent<T> event, @PathVariable String module){
		DtoModel<T> dto = new DtoModel<>();
		dto.setModule(module);
		dto.setEvent(event);
		return service.excuteEvent(dto);
    }
}
