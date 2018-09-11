# GenDataDict
根据数据库中注释生成数据字典。

使用的是mybatis，目前只支持oracle，原则上可以自己修改sql兼容其他数据库。

## 方法说明
+ TablesApiTools 读取数据库生成json。
+ TablesHtmlTools 读取json生成html格式数据字典，所引用的静态资源在template/static/文件夹中。
+ TablesDocTools 读取json文件生成docx格式数据字典。

## 配置说明
+ 修改mybatis-config.xml中数据库相关配置即可。
