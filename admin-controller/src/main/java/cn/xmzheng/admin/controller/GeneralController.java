package cn.xmzheng.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.xmzheng.admin.domain.DtoModel;
import cn.xmzheng.admin.service.IService;
import cn.xmzheng.admin.support.DtoConvert;

@RestController
public class GeneralController {
	@Autowired
	IService service;

	@PostMapping("/{module}/{mode}")
	ResponseEntity<?> general(@PathVariable String module, @PathVariable String mode, DtoModel inModel) {
		inModel.setAccess(false);
		DtoModel result = service.excute(inModel);
		return DtoConvert.convertResponse(result);
	}

	@GetMapping("/{module}/list/{page}")
	ResponseEntity<?> generalAccess(@PathVariable String module, @PathVariable int page,
			DtoModel inModel) {
		inModel.setCurrentPage(page);
		inModel.setAccess(true);
		DtoModel result = service.excute(inModel);
		return DtoConvert.convertResponse(result);
	}
}
