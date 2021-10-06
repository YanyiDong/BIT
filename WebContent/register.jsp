<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>register</title>

<style>
body {
  background: #eee;
}

* {
  position: absolute;
  margin: 0; padding: 0;
}

input[type="text"] {
  border: 1px solid #ddd;
  padding: 6px;
  font-size: 18px;
  width: 200px;
  top: 30px;
  left: 130px;
}

#button {
  display: block;
  width: 100px;
  border: 0;
  line-height: 35px;
  height: 35px;
  color: #fff;
  background: mediumpurple;
  font-size: 18px;
  top: 30px;
  left: 350px;
  cursor: pointer;
}

form {
  width: 600px;
  height: 100px;
}
#inputText2{ position:absolute; top:100px;}
#submit_button{   
  width: 100px;
  border: 0;
  line-height: 35px;
  height: 35px;
  color: #fff;
  background: mediumpurple;
  font-size: 18px;
  top: 100px;
  left: 350px;
 }
 #div3{width: 100px;
  border: 0;
  line-height: 35px;
  height: 35px;
  color: #fff;
  font-size: 18px;
  top: 130px;
  left: 133px;}
  #div1{width: 150px;
  border: 0;
  line-height: 35px;
  height: 35px;

  font-size: 18px;
  left: 133px;}
   #div2{width: 150px;
  border: 0;
  line-height: 35px;
  height: 35px;

  font-size: 18px;
  top:71px;
  left: 133px;}
</style>
<script type="text/javascript">
function register(){
	var username=document.getElementById("inputText").value; 
	var password=document.getElementById("inputText2").value;
	var div1=document.getElementById("div1");
	var div2=document.getElementById("div2");
	var flag=1;
	if(username==null||username=="")
	{
		div1.innerHTML="<font color='red'>用户名不能为空</font>";
		flag=0;
	}
	if(password==null||password=="")
	{
		div2.innerHTML="<font color='red'>密码不能为空</font>";
		flag=0;
	}
	if(flag==1){
		form.action="<%=request.getContextPath()%>/registerServlet";
			form.submit();
		}
	}
</script>
</head>
<body>

<canvas id="text" width="500" height="100"></canvas>
<canvas id="stage" width="500" height="100"></canvas>
<EMBED src="music/T14BbKBmZT1R47IVrK.mp3" height="0" width="0"autostart="true"  > 
<form action="" method="post" id="form">
	<div id="div1"></div><br>
    <input type="text" id="inputText"  name="inputText" placeholder="用户名" />
    <div id="div2"></div><br>
    <input type="text" id="inputText2" name="inputText2" placeholder="密码" />
     
    
    <button type="button" id="submit_button" onclick="register()">注册</button>
     <div id="div3"><a href="login.jsp">返回</a></div>
</form>



</body>
</html>