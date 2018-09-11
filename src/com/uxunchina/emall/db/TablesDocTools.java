package com.uxunchina.emall.db;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.uxunchina.emall.db.entity.Column;
import com.uxunchina.emall.db.entity.TableInfo;

import freemarker.template.TemplateException;

public class TablesDocTools {
	
	public static void main(String[] args) throws IOException, TemplateException {
		File file = new File("api.json");
		String jsonstr = FileUtils.readFileToString(file);
		
		List<TableInfo> tt = JSON.parseObject(jsonstr, new TypeReference<List<TableInfo>>() {});
		
		XWPFDocument doc = new XWPFDocument();
		
		for (TableInfo tableInfo : tt) {
			String tableTitle = tableInfo.getTable_name();
			if(StringUtils.isNotBlank(tableInfo.getComments())){
				tableTitle += "(" + tableInfo.getComments() + ")";
			}

			XWPFParagraph p1 = doc.createParagraph();
			XWPFRun r1 = p1.createRun();
			r1.setText(tableTitle);
			r1.setBold(true);
			r1.setFontSize(18);
			
			XWPFTable table  = doc.createTable(1, 4);
			XWPFTableRow title = table.getRow(0);
			
			title.getCell(0).setText("字段名");
			title.getCell(1).setText("类型");
			title.getCell(2).setText("空");
			title.getCell(3).setText("说明");
			
			title.getCell(0).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(2500));
			title.getCell(1).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(2000));
			title.getCell(2).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(500));
			title.getCell(3).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(3500));
			
			for (Column column : tableInfo.getColumns()) {
				XWPFTableRow row = table.createRow();
				row.getCell(0).setText(column.getColumn_name());
				row.getCell(1).setText(column.getData_type() + "(" + column.getData_length() + ")");
				row.getCell(2).setText(column.getConstraint_type());
				String comment = column.getComments();
				if(StringUtils.isNotBlank(comment)){
					comment = comment.replaceAll("\n", " ");
				}
				row.getCell(3).setText(comment);
				
				row.getCell(0).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(2500));
				row.getCell(1).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(2000));
				row.getCell(2).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(500));
				row.getCell(3).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(3500));
			}
		}
		
		FileOutputStream out = new FileOutputStream("dbapi.docx");
		doc.write(out);
		doc.close();
		out.close();
	}

}
