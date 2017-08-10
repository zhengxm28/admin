package cn.xmzheng.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
	ResponseEntity<?> general(DtoModel inModel) {
		inModel.setAccess(false);
		DtoModel result = service.excute(inModel);
		return DtoConvert.convertResponse(result);
	}

	@GetMapping("/{module}/list/{currentPage}")
	ResponseEntity<?> generalAccess(DtoModel inModel) {
		inModel.setAccess(true);
		DtoModel result = service.excute(inModel);
		return DtoConvert.convertResponse(result);
	}
}
