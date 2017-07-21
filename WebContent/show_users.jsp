<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Test</title>
<script type="text/javascript" src="/web_test/js/jquery-1.8.2.min.js"></script>
<script type="text/javascript">

	 	$(function(){
	/* 	console.log("hello");
	}); */
	/* console.log($("#btn"));
	$("#btn").on("click",function(){console.log("hello word!")}); */
	
	 /*$("#btn").on("click",function(){
		$.get("getUser.action",function(obj){
			console.log(obj);
			console.log(JSON.stringfy(obj));
			console.log(obj.id);
			console.log(obj.name);
		},"json");
	});  */	
	 $("#btn").on("click",function(){
		$.get("findAllUser.action",function(array){
			$("tbody").empty();
			$.each(array,function(i,e){
				//console.log(array);
				var a="<a  class='del_a' href='deleteUser.action' delId='"+e.id+"'>删除</a>";
				var tr=$("<tr> <td>"+e.id+"</td> <td>"+e.name+"</td><td>"+a+"</td> </tr>");
				$("tbody").append(tr);
				tr.hide().fadeIn(3000);//fadeIn是从无到有，fadeOut是从有到无
			});
			$(".del_a").on("click",function(){
				//console.log($(this).attr("href"));
				//console.log($(this).attr("delId"));
				
				var url = $(this).attr("href");
				
				var id = $(this).attr("delId");
				var _this=this;
				/* console.log("hello"); */
				
				$.get(url,{id:id},function(obj){
					
					//console.log(obj.msg);
					if(obj.msg=="OK"){
						//console.log(
						$(_this).parent().parent().fadeOut(3000,function(){});
						$(this).remove();
						
					}
					
				},"json");
				
				
				return false;
			});

		},"json");
	});
		//"#"是为了拿到id
		$("#formBtn").on("click",function(){
			console.log("Hello");
		});
	
	}); 
	
</script>
</head>
<body>
<input id="btn" type="button" value="提交">
<form action="addUser.action">
<table>
<tr>
<td>id:<input type="text" name="id" size="18px"></br></td></tr>
<tr>
<td>name:<input type="text" name="name" size="18px"></br></form>
<input id="formBtn" type="button" value="ajax提交">

</td>
</tr>
</table>
	<table>
	<thead>
		<tr>
			<td>编码</td>
			<td>姓名</td>
			<td>操作</td>
		</tr>
	</thead>
	
	<tbody>
	
	</tbody>
		<c:forEach items="${allUsers}" var="u">
			<tr>
				<td>${u.id}</td>
				<td>${u.name}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>