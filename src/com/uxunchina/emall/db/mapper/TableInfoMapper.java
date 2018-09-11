package com.uxunchina.emall.db.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.uxunchina.emall.db.entity.Column;
import com.uxunchina.emall.db.entity.TableInfo;

public interface TableInfoMapper {
	
	public List<TableInfo> getAllTables();
	
	public List<Column> getColumnsByTableName(@Param(value="name") String name);
}
