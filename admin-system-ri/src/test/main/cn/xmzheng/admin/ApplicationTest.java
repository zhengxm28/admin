package cn.xmzheng.admin;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.xmzheng.admin.entity.MetadataEntity;
import cn.xmzheng.admin.repository.MetadataRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {
	@Autowired MetadataRepository metadataRepository;
	
	@Test
	public void findTest() {
		MetadataEntity metadata = metadataRepository.findOne("metadata");
		assertEquals("元数据", metadata.getCnName());
	}

}
