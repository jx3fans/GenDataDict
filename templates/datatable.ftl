<!DOCTYPE html>
<html lang="zh-CN">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="renderer" content="webkit">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>数据字典</title>
		
		<link rel="stylesheet" href="static/css/bootstrap.min.css" />
		<link rel="stylesheet" href="static/css/bootstrap-responsive.min.css" />
		
		<script type="text/javascript" src="static/js/jquery-1.11.3.min.js" ></script>
		<script type="text/javascript" src="static/js/bootstrap.min.js" ></script>
		
		<style type="text/css">
			.columdiv {
			    background-color: #fff;
			    border: 1px solid #08c;
			    border-radius: 4px;
			    margin: 15px 0;
			    position: relative;
			}
			
			.columdiv .title{
				padding: 10px;
				background-color: #08c;
				color: #ffffff;
			}
			
			.columdiv .table{
				margin-bottom: 0;
			}
			
			.side-menu{
				position:fixed;
				height:100%;
				overflow-y:scroll;
				width:100%;
			}
		</style>
	</head>
	<body>
		<div class="container-fluid">
			<div class="row-fluid">
				<div class="span3">
					<div class="span3 side-menu">
						<ul>
<#list tt as t>
							<li><a href="#${t.table_name}">${t.table_name} ${t.comments!''}</a></li>
</#list>
						</ul>						
					</div>
				</div>
				<div class="span9">
<#list tt as t>
					<a id="${t.table_name}"></a>
					<div class="columdiv">
						<div class="title">${t.table_name} ${t.comments!''}</div>
						<table class="table table-condensed">
							<tr>
								<th>字段名</th>
								<th>类型</td>
								<th>主键</th>
								<th>说明</th>
							</tr>
	<#list t.columns as c>
							<tr>
								<td class="span2">${c.column_name}</td>
								<td class="span2">${c.data_type}(${c.data_length})</td>
								<td class="span1">${c.constraint_type!''}</td>
								<td class="span4">${c.comments!''}</td>
							</tr>
	</#list>
						</table>
					</div>
</#list>
				</div>
			</div>
		</div
	</body>
</html>
