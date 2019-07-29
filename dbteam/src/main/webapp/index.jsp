<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="Utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>寝室助手官</title>
<script src="js/jquery/2.0.0/jquery.min.js"></script>
<link href="css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
<script src="js/bootstrap/3.3.6/bootstrap.min.js"></script>
<style>
.video1 {
	display: block;
	margin: auto;
	width: 520px;
	height: 420px;
}
</style>
<script>
	$(function() {
		$("[data-toggle='popover']").popover();
	});
</script>

</head>
<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<nav class="navbar navbar-default navbar-inverse navbar-fixed-top"
					role="navigation">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle" data-toggle="collapse"
							data-target="#bs-example-navbar-collapse-1">
							<span class="sr-only">Toggle navigation</span><span
								class="icon-bar"></span><span class="icon-bar"></span><span
								class="icon-bar"></span>
						</button>
						<a class="navbar-brand" href="http://localhost:8080/dbteam/">首页</a>
					</div>

					<div class="collapse navbar-collapse"
						id="bs-example-navbar-collapse-1">
						<ul class="nav navbar-nav">
							<li class="active"><a href="#biaodan">联系我们</a></li>


						</ul>
						<form class="navbar-form navbar-left" role="search">
							<div class="form-group">
								<input type="text" class="form-control" />
							</div>
							<button type="submit" class="btn btn-default">查询</button>
						</form>

					</div>

				</nav>
				<br> <br> <br>
				<div class="page-header">
					<h1>
						寝室助手（微信小程序） <small>5.20号校内赛</small>
					</h1>
				</div>
				<p class="text-warning">
					<em>寝室助手</em> 是一款为 <strong>寝室卫生管理</strong> 而编写的微信小程序投入到<small></small>
					卫生管理中
				</p>
				<br> <br>
				<div class="carousel slide" id="carousel-340264">
					<ol class="carousel-indicators">
						<li class="active" data-slide-to="0"
							data-target="#carousel-340264"></li>
						<li data-slide-to="1" data-target="#carousel-340264"></li>
						<li data-slide-to="2" data-target="#carousel-340264"></li>
					</ol>
					<div class="carousel-inner">
						<div class="item active">
							<img alt="" src="<%=request.getContextPath()%>/image/11.png" />
							<div class="carousel-caption">
								<h4>图片添加映射思路</h4>
								<p>用数据分发，再加上mybatis数据库一对多将数据添加再查询， 返回到前端页面。</p>
							</div>
						</div>
						<div class="item">

							<img alt="" src="<%=request.getContextPath()%>/image/22.png">
							<!-- <img alt=""
								src="http://ibootstrap-file.b0.upaiyun.com/lorempixel.com/1600/500/sports/2/default.jpg" /> -->
							<div class="carousel-caption">
								<h4>接口</h4>
								<p>各个方法与前端调用的接口地址</p>
							</div>
						</div>
						<div class="item">
							<img alt="" src="<%=request.getContextPath()%>/image/111.png" />
							<div class="carousel-caption">
								<h4>变量名规范</h4>
								<p>全部数据的包括数据库的命名规范，主要用于前端和后端值的 传递</p>
							</div>
						</div>
					</div>
					<a class="left carousel-control" href="#carousel-340264"
						data-slide="prev"><span
						class="glyphicon glyphicon-chevron-left"></span></a> <a
						class="right carousel-control" href="#carousel-340264"
						data-slide="next"><span
						class="glyphicon glyphicon-chevron-right"></span></a>
				</div>
				<div class="alert alert-dismissable alert-success">
					<button type="button" class="close" data-dismiss="alert"
						aria-hidden="true">×</button>
					<h4>注意事项 :</h4>
					<strong>Warning :</strong> 以上图片再设置像素大小的时候可能会出现失真情况。 <a href="#"
						class="alert-link"></a>
				</div>
				<table class="table table-striped table-hover" name="biaodan">
					<thead>
						<tr>
							<th>编号</th>
							<th>姓名</th>
							<th>联系方式</th>
							<th>分工</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>1</td>
							<td>王建涛</td>
							<td>18888888</td>
							<td>全部页面UI设计</td>
						</tr>
						<tr class="success">
							<td>2</td>
							<td>李腾龙</td>
							<td>13666666</td>
							<td>小程序端代码编写</td>
						</tr>
						<tr class="error">
							<td>3</td>
							<td>胡佳艺</td>
							<td>17554361618</td>
							<td>后端程序代码编写</td>
						</tr>
						<tr class="warning">
							<td>4</td>
							<td>张帆</td>
							<td>18375437316</td>
							<td>视频制作</td>
						</tr>
						<tr class="info">
							<td>5</td>
							<td>于文辉</td>
							<td>176666666</td>
							<td>图片制作</td>
						</tr>
					</tbody>
				</table>
				<blockquote>
					<p>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;明德
						砺学 日新 致远</p>
					<small><cite>滨州学院</cite></small>
				</blockquote>

				<video class="video1" width="620px" height="420px" controls
					align="center">
					<source src="video/2018.mp4" type="video/mp4">

					<object data="video/mp4" width="620px" height="420px">
						<embed src="video/2018.mp4" width="520px" height="420px">
					</object>
				</video>
				<br> <br> <a href="#" class="list-group-item active">
					列表 </a> 
					<a href="#b1"  class="list-group-item">*&emsp;Spring事务增强 </a> 	
					<a href="#b2" class="list-group-item">*&emsp;C3P0数据连接池     </a> 
					<a href="#b3" class="list-group-item">*&emsp;非常简单的线程锁机制</a> 
					<a href="#b4"   class="list-group-item">*&emsp;hibernate数据校验</a> 
					<table class="table table-striped">
  
					<br> <br>
				<div class="jumbotron well">
					<h2>项目涉及到的技术内容</h2>
					<p>这个项目主要用到项目开发中的......</p>
					<p>
						&emsp;&emsp;
						<button class="btn btn-primary btn-lg" data-toggle="modal"
							data-target="#myModal">详情</button>
					</p>
				</div>




				<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
					aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">&times;</button>
								<h4 class="modal-title" id="myModalLabel">
									内容 <sub><small><em>按ESC退出 </em></small></sub>
								</h4>
							</div>
							<div class="modal-body">请查看技术列表</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">关闭</button>

							</div>
						</div>
						<!-- /.modal-content -->
					</div>
					<!-- /.modal -->
				</div>
				<!--  -->
				<div class="modal fade" id="b1" tabindex="-1" role="dialog"
					aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">×</button>
								<h4 class="modal-title" id="myModalLabel">模态框（Modal）标题</h4>
							</div>
							<div class="modal-body">按下 ESC 按钮退出。</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">关闭</button>
								<button type="button" class="btn btn-primary">提交更改</button>
							</div>
						</div>
						<!-- /.modal-content -->
					</div>
					<!-- /.modal-dialog -->
				</div>
				<!--  -->
				<div class="modal fade" id="b2" tabindex="-1" role="dialog"
					aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">×</button>
								<h4 class="modal-title" id="myModalLabel">模态框（Modal）标题</h4>
							</div>
							<div class="modal-body">按下 ESC 按钮退出。</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">关闭</button>
								<button type="button" class="btn btn-primary">提交更改</button>
							</div>
						</div>
						<!-- /.modal-content -->
					</div>
					<!-- /.modal-dialog -->
				</div>
				<!--  -->
				<div class="modal fade" id="b3" tabindex="-1" role="dialog"
					aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">×</button>
								<h4 class="modal-title" id="myModalLabel">模态框（Modal）标题</h4>
							</div>
							<div class="modal-body">按下 ESC 按钮退出。</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">关闭</button>
								<button type="button" class="btn btn-primary">提交更改</button>
							</div>
						</div>
						<!-- /.modal-content -->
					</div>
					<!-- /.modal-dialog -->
				</div>
			</div>
		</div>
	</div>



</body>



</html>