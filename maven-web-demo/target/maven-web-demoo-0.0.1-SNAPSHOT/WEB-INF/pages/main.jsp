<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import ="com.junhao.domain.User" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>主页</title>
	<link rel="stylesheet" href="<c:url value='/css/bootstrap.min.css'/>">
	<script src="<c:url value='/js/jquery-3.2.1.min.js'/>"></script>  <!--jquery引用与bootstrap前-->
	<script src="<c:url value='/js/bootstrap.min.js'/>"></script>

</head>
	<body>
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
					aria-expanded="false">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Brand</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">Link <span class="sr-only">(current)</span></a></li>
					<li><a href="#">Link</a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">Dropdown <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="#">Action</a></li>
							<li><a href="#">Another action</a></li>
							<li><a href="#">Something else here</a></li>
							<li role="separator" class="divider"></li>
							<li><a href="#">Separated link</a></li>
							<li role="separator" class="divider"></li>
							<li><a href="#">One more separated link</a></li>
						</ul></li>
				</ul>
				<form class="navbar-form navbar-left">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Search">
					</div>
					<button type="submit" class="btn btn-default">Submit</button>
				</form>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#">Link</a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">Dropdown <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="#">Action</a></li>
							<li><a href="#">Another action</a></li>
							<li><a href="#">Something else here</a></li>
							<li role="separator" class="divider"></li>
							<li><a href="#">Separated link</a></li>
						</ul></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>


	<div class="container">
		<div class="row">
			<span class="col-md-offset-9 col-md-3">WelCome,<h3 style="display:inline;">${user.username}</h3></span>
		</div>
		<div class="row">
			<c:forEach items="${goods}" var="good">
				<div class="col-md-offset-2 col-md-8">
					<div class="thumbnail">
						<a href="#"> <img src="<c:url value='/images/${good.image}'/>"
							alt="${good.remark}">
						</a>
						<div class="caption">
							<h3>${good.goodname}</h3>
							<p>${good.remark}</p>
							<p class="text-center">
								<a
									href="<c:url value="addCart/userid/${user.id}/goodid/${good.id}/goodname/${good.goodname}/price/${good.price}"/>"
									class="btn btn-primary">购买</a>
							</p>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
		
		<!-- 分页 -->
		<div class="row col-md-offset-4 col-md-4">
			<nav aria-label="Page navigation">
				<ul class="pagination">
					<li id="li-previous"><a id="previous" href="${previous}"
						aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
					</a></li>

					<li><a href="${next}" aria-label="Next"> <span
							aria-hidden="true">&raquo;</span>
					</a></li>
				</ul>
			</nav>
		</div>
	</div>


	

	<a href="<c:url value='Cartlist?userid=${user.id}'/>"
		class="btn btn-primary">进入购物车</a>

	<script>
		var pagenumber = Math.ceil(${count}/${size});
		
		for (var i=pagenumber; 0<i;i--)
		{
			$("#li-previous").after("<li><a "+"id='"+i+"'"+"href='<c:url value='main'/>?pageNO="+i+"'>"+i+"</a></li>")
		};
		
	</script>


</body>
</html>
