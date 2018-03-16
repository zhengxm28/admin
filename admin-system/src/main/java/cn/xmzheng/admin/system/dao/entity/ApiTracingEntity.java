package cn.xmzheng.admin.system.dao.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity(name = "api_tracing")
@Data
public class ApiTracingEntity {
	@GeneratedValue
	@Id
	private int id;
	private String cnName;
	private String apiName;
	private String apiMethod;
	private String cycle;
	private String cycleZone;
	private int totalTime;
	private int errorTime;
	private boolean isOpen;
}
