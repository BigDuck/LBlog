package com.j.blog.daomain;
/**
 * 用户实体类
 * @author J
 *
 */
public class User  extends BaseDaomain{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private int uId;
private String uName;
private String uPsw;
private String uEmail;
private int uLv;
public int getuId() {
	return uId;
}
public void setuId(int uId) {
	this.uId = uId;
}
public String getuName() {
	return uName;
}
public void setuName(String uName) {
	this.uName = uName;
}
public String getuPsw() {
	return uPsw;
}
public void setuPsw(String uPsw) {
	this.uPsw = uPsw;
}
public String getuEmail() {
	return uEmail;
}
public void setuEmail(String uEmail) {
	this.uEmail = uEmail;
}
public int getuLv() {
	return uLv;
}
public void setuLv(int uLv) {
	this.uLv = uLv;
}
@Override
public String toString() {
	return "User [uId=" + uId + ", uName=" + uName + ", uPsw=" + uPsw + ", uEmail=" + uEmail + ", uLv=" + uLv + "]";
}
public User(int uId, String uName, String uPsw, String uEmail, int uLv) {
	super();
	this.uId = uId;
	this.uName = uName;
	this.uPsw = uPsw;
	this.uEmail = uEmail;
	this.uLv = uLv;
}
public User() {
	super();
}
}
