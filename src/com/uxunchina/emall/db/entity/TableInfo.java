package com.uxunchina.emall.db.entity;

import java.io.Serializable;
import java.util.List;

public class TableInfo implements Serializable{
	private static final long serialVersionUID = 1L;

	private String table_name;
	private String comments;
	
	private List<Column> columns;

	public String getTable_name() {
		return table_name;
	}

	public void setTable_name(String table_name) {
		this.table_name = table_name;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public List<Column> getColumns() {
		return columns;
	}

	public void setColumns(List<Column> columns) {
		this.columns = columns;
	}

	@Override
	public String toString() {
		return "TableInfo [table_name=" + table_name + ", comments=" + comments + "]";
	}

}
