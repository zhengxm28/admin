package cn.xmzheng.admin.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cn.xmzheng.admin.system.entity.MetadataEntity;

@Repository
public interface MetadataRepository extends JpaRepository<MetadataEntity, String> {

}
