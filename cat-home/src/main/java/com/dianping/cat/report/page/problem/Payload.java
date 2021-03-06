package com.dianping.cat.report.page.problem;

import org.unidal.web.mvc.ActionContext;
import org.unidal.web.mvc.payload.annotation.FieldMeta;

import com.dianping.cat.report.ReportPage;
import com.dianping.cat.report.page.AbstractReportPayload;

public class Payload extends AbstractReportPayload<Action> {
	@FieldMeta("op")
	private Action m_action;

	@FieldMeta("group")
	private String m_groupName;

	@FieldMeta("linkCount")
	private int m_linkCount;

	@FieldMeta("urlThreshold")
	private int m_urlThreshold = 1000;

	@FieldMeta("minute")
	private int m_minute;

	@FieldMeta("sqlThreshold")
	private int m_sqlThreshold = 100;

	@FieldMeta("serviceThreshold")
	private int m_serviceThreshold = 50;

	@FieldMeta("cacheThreshold")
	private int m_cacheThreshold = 10;

	@FieldMeta("callThreshold")
	private int m_callThreshold = 50;

	@FieldMeta("status")
	private String m_status;

	@FieldMeta("thread")
	private String m_threadId;

	@FieldMeta("type")
	private String m_type;

	public Payload() {
		super(ReportPage.PROBLEM);
	}

	public String getQueryString() {
		StringBuilder sb = new StringBuilder();

		sb.append("&urlThreshold=").append(m_urlThreshold);
		sb.append("&sqlThreshold=").append(m_sqlThreshold);
		sb.append("&serviceThreshold=").append(m_serviceThreshold);
		sb.append("&cacheThreshold=").append(m_cacheThreshold);
		sb.append("&callThreshold=").append(m_callThreshold);
		return sb.toString();
	}

	@Override
	public Action getAction() {
		return m_action;
	}

	public String getGroupName() {
		return m_groupName;
	}

	public int getLinkCount() {
		if (m_linkCount < 40) {
			m_linkCount = 40;
		}
		return m_linkCount;
	}

	public int getSqlThreshold() {
		return m_sqlThreshold;
	}

	public void setSqlThreshold(int sqlThreshold) {
		m_sqlThreshold = sqlThreshold;
	}

	public int getServiceThreshold() {
		return m_serviceThreshold;
	}

	public void setServiceThreshold(int serviceThreshold) {
		m_serviceThreshold = serviceThreshold;
	}

	public int getCacheThreshold() {
		return m_cacheThreshold;
	}

	public void setCacheThreshold(int cacheThreshold) {
		m_cacheThreshold = cacheThreshold;
	}

	public int getCallThreshold() {
		return m_callThreshold;
	}

	public void setCallThreshold(int callThreshold) {
		m_callThreshold = callThreshold;
	}

	public int getUrlThreshold() {
		return m_urlThreshold;
	}

	public int getMinute() {
		return m_minute;
	}

	public String getStatus() {
		return m_status;
	}

	public String getThreadId() {
		return m_threadId;
	}

	public String getType() {
		return m_type;
	}

	public void setAction(String action) {
		m_action = Action.getByName(action, Action.VIEW);
	}

	public void setGroupName(String groupName) {
		m_groupName = groupName;
	}

	public void setLinkCount(int linkSize) {
		m_linkCount = linkSize;
	}

	public void setUrlThreshold(int longTime) {
		m_urlThreshold = longTime;
	}

	public void setMinute(int minute) {
		m_minute = minute;
	}

	public void setStatus(String status) {
		m_status = status;
	}

	public void setThreadId(String threadId) {
		m_threadId = threadId;
	}

	public void setType(String type) {
		m_type = type;
	}

	@Override
	public void validate(ActionContext<?> ctx) {
		if (m_action == null) {
			m_action = Action.VIEW;
		}
	}
}
