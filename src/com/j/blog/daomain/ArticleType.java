package com.j.blog.daomain;

/**
 * Œƒ’¬¿‡–Õ
 * @author J
 *
 */
public class ArticleType extends BaseDaomain{
	private static final long serialVersionUID = 1L;
private int tId;
private String tName;
private String other;
public int gettId() {
	return tId;
}
public void settId(int tId) {
	this.tId = tId;
}
public String gettName() {
	return tName;
}
public void settName(String tName) {
	this.tName = tName;
}
public String getOther() {
	return other;
}
public void setOther(String other) {
	this.other = other;
}
@Override
public String toString() {
	return "ArticleType [tId=" + tId + ", tName=" + tName + ", other=" + other + "]";
}
public ArticleType(int tId, String tName, String other) {
	super();
	this.tId = tId;
	this.tName = tName;
	this.other = other;
}
public ArticleType() {
	super();

}
}
