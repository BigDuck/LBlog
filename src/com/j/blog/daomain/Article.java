package com.j.blog.daomain;

import java.util.Date;

/**
 * 文章是实体类
 * @author J
 *
 */
public class Article extends BaseDaomain {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int aId;
	private String aTitle;
	private String aContent;
	private User user;
	private String aPhoto;
	private Date aDate;
	private String aOther;
	private int  userId;
	private int typeId;
	private ArticleType aType;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public int getaId() {
		return aId;
	}
	public void setaId(int aId) {
		this.aId = aId;
	}
	public String getaTitle() {
		return aTitle;
	}
	public void setaTitle(String aTitle) {
		this.aTitle = aTitle;
	}
	public String getaContent() {
		return aContent;
	}
	public void setaContent(String aContent) {
		this.aContent = aContent;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getaPhoto() {
		return aPhoto;
	}
	public void setaPhoto(String aPhoto) {
		this.aPhoto = aPhoto;
	}
	public Date getaDate() {
		return aDate;
	}
	public void setaDate(Date aDate) {
		this.aDate = aDate;
	}
	public String getaOther() {
		return aOther;
	}
	public void setaOther(String aOther) {
		this.aOther = aOther;
	}
	public ArticleType getaType() {
		return aType;
	}
	public void setaType(ArticleType aType) {
		this.aType = aType;
	}
	@Override
	public String toString() {
		return "Article [aId=" + aId + ", aTitle=" + aTitle + ", aContent="
				+ aContent + ", user=" + user + ", aPhoto=" + aPhoto
				+ ", aDate=" + aDate + ", aOther=" + aOther + ", userId="
				+ userId + ", typeId=" + typeId + ", aType=" + aType + "]";
	}
	public Article(String aTitle, String aContent, User user, String aPhoto,
			Date aDate, String aOther, int userId, int typeId, ArticleType aType) {
		super();
		this.aTitle = aTitle;
		this.aContent = aContent;
		this.user = user;
		this.aPhoto = aPhoto;
		this.aDate = aDate;
		this.aOther = aOther;
		this.userId = userId;
		this.typeId = typeId;
		this.aType = aType;
	}
	public Article() {
		super();
	}
	
	

}
