<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
			
	<title>购物车</title>
    <link rel="stylesheet" href="<c:url value='/css/bootstrap.min.css'/>">
	<script src="<c:url value='/js/jquery-3.2.1.min.js'/>"></script>  <!--jquery引用与bootstrap前-->
	<script src="<c:url value='/js/bootstrap.min.js'/>"></script>
	<title></title>
	</head>
	<body>
		<table class="table table-hover">
			<caption>购物清单</caption>
			<thead>
				<tr>
					<th>名称</th>
					<th>价格</th>
					<th>数量</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${cartgoods}" var="cartgoods">
				<tr>
					<td id="${cartgoods.goodid}">${cartgoods.goodname}</td>
					<td class="price">${cartgoods.price}</td>
					<td>

						<div class="col-md-2 col-xm-2">
							<div class="input-group">
								<span class="input-group-btn">
									<button class="btn btn-default minus" type="button">
										<span class="glyphicon glyphicon-minus" aria-hidden="true"></span>
									</button>
								</span> 
								<input type="text" class="form-control" value="${cartgoods.quantity}">
								<span class="input-group-btn">
									<button class="btn btn-default plus" type="button">
										<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
									</button>
								</span> 
							</div>
							<!-- /input-group -->
						</div>
					</td>
				</tr>
				</c:forEach>
				
				
			</tbody>
		</table>
		<span id="total"></span>
		
		<script>
			$(document).ready(function() {
				
				function total(){
					var i = 0;
					$(".price").each(function() {
						i = i + parseInt($(this).text())*parseInt($(this).next().find("input").val());
					});
					$("#total").text(i);
				};
				total();

				$(".plus").click(function() {

					var number = parseInt($(this).parent().prev().val());

					number = number + 1;

					$(this).parent().prev().val(number);
					total();

				});

				$(".minus").click(function() {

					var number = parseInt($(this).parent().next().val());

					number = number - 1;
					if (number >= 1) {

						$(this).parent().next().val(number);
						
					};
					var i=0;
					total();

				});

			});
		</script>
	</body>
</html>
