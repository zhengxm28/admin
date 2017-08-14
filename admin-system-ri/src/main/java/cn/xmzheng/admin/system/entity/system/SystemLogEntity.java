package cn.xmzheng.admin.system.entity.system;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "system_log")
public class SystemLogEntity {
	private int id;
	private String tableName;
	private String action;
	private String preData;
	private String postData;
	private String operator;
	private Date operateTime;
	private String memo;

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column
	public String getTableName() {
		return tableName;
	}

	@Column
	public String getAction() {
		return action;
	}

	@Column
	public String getPreData() {
		return preData;
	}

	@Column
	public String getPostData() {
		return postData;
	}

	@Column
	public String getOperator() {
		return operator;
	}

	@Column
	public Date getOperateTime() {
		return operateTime;
	}

	@Column
	public String getMemo() {
		return memo;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public void setPreData(String preData) {
		this.preData = preData;
	}

	public void setPostData(String postData) {
		this.postData = postData;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public void setOperateTime(Date operateTime) {
		this.operateTime = operateTime;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}
	
}
