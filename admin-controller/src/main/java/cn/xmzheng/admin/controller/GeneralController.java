package cn.xmzheng.admin.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.xmzheng.admin.domain.DtoModel;
import cn.xmzheng.admin.service.IService;
import cn.xmzheng.admin.support.DtoConvert;

@RestController
public class GeneralController {
	@Autowired
	IService service;

	@RequestMapping("/{module}/{mode}")
	ResponseEntity<?> generalAction(@RequestBody RequestEntity<DtoModel<?>> request) {
		URI url = request.getUrl();
		DtoModel<?> model = request.getBody();
		if (HttpMethod.GET.equals(request.getMethod())) {
			model.setAccess(true);
		} else {
//			model.setMode(mode);
			url.toString();
		}
		DtoModel<?> result = service.excute(request.getBody());
		return DtoConvert.convertResponse(result);
	}
}
