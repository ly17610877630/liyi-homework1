package com.liyi.cms.pojo;

public class Plan {
	private Integer id;
	private String name;
	private String amout;
	private String manger;
	private String content;
	private Integer did;
	private String dname;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAmout() {
		return amout;
	}
	public void setAmout(String amout) {
		this.amout = amout;
	}
	public String getManger() {
		return manger;
	}
	public void setManger(String manger) {
		this.manger = manger;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getDid() {
		return did;
	}
	public void setDid(Integer did) {
		this.did = did;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	@Override
	public String toString() {
		return "Plan [id=" + id + ", name=" + name + ", amout=" + amout + ", manger=" + manger + ", content=" + content
				+ ", did=" + did + ", dname=" + dname + "]";
	}
}
