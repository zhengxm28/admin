package cn.xmzheng.admin.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cn.xmzheng.admin.system.entity.DdicCategoryEntity;

@Repository
public interface DdicCategoryRepository extends JpaRepository<DdicCategoryEntity, Integer> {

}
