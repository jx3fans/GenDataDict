package com.uxunchina.emall.db;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.uxunchina.emall.db.entity.TableInfo;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class TablesHtmlTools {
	
	public static void main(String[] args) throws IOException, TemplateException {
		File file = new File("api.json");
		String jsonstr = FileUtils.readFileToString(file);
		
		List<TableInfo> tt = JSON.parseObject(jsonstr, new TypeReference<List<TableInfo>>() {});
		
		Map<String, Object> dat = new HashMap<String, Object>();
		dat.put("tt", tt);
		
		Configuration freeMakerCfg = new Configuration(Configuration.VERSION_2_3_23);
		freeMakerCfg.setDefaultEncoding("UTF-8");		
		freeMakerCfg.setDirectoryForTemplateLoading(new File("templates"));
		
		Writer out = new FileWriter("F:\\workspace\\cxx_html\\index.html");
		Template template = freeMakerCfg.getTemplate("datatable.ftl");
		template.process(dat, out);
		
		out.flush();
		out.close();
		System.out.println("生成完毕！");
	}

}
