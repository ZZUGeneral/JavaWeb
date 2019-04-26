package zzu.minjie.bean;

import java.util.Date;

/**
 * 公告实体类
 * 
 *
 */
public class Notice {
	
	private int NoticeId;//公告号
	private String Theme;//主题
	private String Notice;//公告内容
	private Date Time;//发布时间
	
	
	
	public Notice() {
		
	}
    public Notice(String Theme) {
    	super();
		this.Theme = Theme;
	}
	
    public Notice(int NoticeId,String Theme,String Notice,Date Time) {
    	super();
    	this.NoticeId = NoticeId;
		this.Theme = Theme;
		this.Notice = Notice;
		this.Time = Time;
	}
	public int getNoticeId() {
		return NoticeId;
	}
	public void setNoticeId(int noticeId) {
		NoticeId = noticeId;
	}
	public String getTheme() {
		return Theme;
	}
	public void setTheme(String theme) {
		Theme = theme;
	}
	public String getNotice() {
		return Notice;
	}
	public void setNotice(String notice) {
		Notice = notice;
	}
	public Date getTime() {
		return Time;
	}
	public void setTime(Date time) {
		Time = time;
	}
	@Override
	public String toString() {
		return "Notice [NoticeId=" + NoticeId + ", Theme=" + Theme + ", Notice=" + Notice + ", Time=" + Time + "]";
	}
	

}