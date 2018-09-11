package com.uxunchina.emall.db.entity;

import java.io.Serializable;

public class Column implements Serializable{
	private static final long serialVersionUID = 1L;

	private String column_name;
	private String data_type;
	private String data_length;
	private String constraint_type;
	private String comments;

	public String getColumn_name() {
		return column_name;
	}

	public void setColumn_name(String column_name) {
		this.column_name = column_name;
	}

	public String getData_type() {
		return data_type;
	}

	public void setData_type(String data_type) {
		this.data_type = data_type;
	}

	public String getData_length() {
		return data_length;
	}

	public void setData_length(String data_length) {
		this.data_length = data_length;
	}

	public String getConstraint_type() {
		return constraint_type;
	}

	public void setConstraint_type(String constraint_type) {
		this.constraint_type = constraint_type;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "Column [column_name=" + column_name + ", data_type=" + data_type + ", data_length=" + data_length
				+ ", constraint_type=" + constraint_type + ", comments=" + comments + "]";
	}



}
