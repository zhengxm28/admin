# admin 后台管理系统
* skill stacks 
  (gradle, spring-boot, spring-data-jpa, spring-session, disrupt, 
  jsr303, redis, mariadb, 
  thymeleaf, vue.js, bootstrap, webjars)
* spring-cloud(划分成新项目: micro-utility)
  * eureka
  * cloud-config
  * zuul
* function
  * login
  * auth(user/role/permission/menu)
  * ddic
  * file-upload
  * validation
 * 采用纵向分层
   * controller-service-repository在一起
   * 小型项目
     * 系统管理, 用户权限, 日志放在一起(admin-system)
     * 业务模块(admin-module)
  
  