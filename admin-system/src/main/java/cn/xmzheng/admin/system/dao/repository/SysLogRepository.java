package cn.xmzheng.admin.system.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cn.xmzheng.admin.system.dao.entity.SysLogEntity;

@Repository
public interface SysLogRepository extends JpaRepository<SysLogEntity, Long> {

}
