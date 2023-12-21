package com.ebrain.jdbc;

public class AbiData {
	
    private Integer id;
	
	private String user_name;
	
	private String first_name;

	private String last_name;

	private String mobile_no;
	
public AbiData(Integer id, String user_name, String first_name, String last_name, String mobile_no) {
		super();
		this.id = id;
		this.user_name = user_name;
		this.first_name = first_name;
		this.last_name = last_name;
		this.mobile_no = mobile_no;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getMobile_no() {
		return mobile_no;
	}

	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}

	@Override
	public String toString() {
		return "AbiData [id=" + id + ", user_name=" + user_name + ", first_name=" + first_name + ", last_name="
				+ last_name + ", mobile_no=" + mobile_no + "]";
	}
}


