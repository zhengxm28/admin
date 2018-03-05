package cn.xmzheng.admin.domain.event;

/**
 * CQRS:Command事件(增删改)/Query事件(查询)
 * 
 * @author fczheng
 *
 */
public interface Event {
	boolean isQuery();
}
