package cn.xmzheng.admin.module.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cn.xmzheng.admin.module.dao.entity.basedata.CustomerEntity;

@Repository
public interface ProjectRepository extends JpaRepository<CustomerEntity, String> {

}
