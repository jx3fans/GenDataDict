package com.uxunchina.emall.db;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.alibaba.fastjson.JSON;
import com.uxunchina.emall.db.entity.Column;
import com.uxunchina.emall.db.entity.TableInfo;
import com.uxunchina.emall.db.mapper.TableInfoMapper;

/**
 * 获取数据库表结构，转化为json保存到文件中。
 * @author Administrator
 *
 */
public class TablesApiTools {

	public static void main(String[] args) throws IOException {
		InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
		
		SqlSession session = new SqlSessionFactoryBuilder().build(inputStream, "dev").openSession();
		
		TableInfoMapper tm = session.getMapper(TableInfoMapper.class);
		
		List<TableInfo> tt = tm.getAllTables();
		
		for (TableInfo tableInfo : tt) {
			System.out.println(tableInfo);
			List<Column> columns = tm.getColumnsByTableName(tableInfo.getTable_name());
			tableInfo.setColumns(columns);
		}
		session.close();
		
		String jsonstr = JSON.toJSONString(tt);
		File file = new File("api.json");
		FileUtils.write(file, jsonstr);
		System.out.println("读取完毕");
	}

}
