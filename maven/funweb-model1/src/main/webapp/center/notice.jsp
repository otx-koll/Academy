<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Welcome to Fun Web</title>
<jsp:include page="/include/headContent.jsp" />

<link href="/css/subpage.css" rel="stylesheet" type="text/css"  media="all">
</head>

<body>
<div id="wrap">
	<%-- header 영역 --%>
	<jsp:include page="../include/topHeader.jsp" />

	<div class="clear"></div>
	<div id="sub_img_center"></div>
	
	<div class="clear"></div>
	<!-- nav 영역 -->
	<jsp:include page="../include/submenuBoard.jsp"/>
	
	<article>
		
	<h1>Notice</h1>
		
	<table id="notice">
		<tr>
			<th scope="col" class="tno">no.</th>
			<th scope="col" class="ttitle">title</th>
			<th scope="col" class="twrite">writer</th>
			<th scope="col" class="tdate">date</th>
			<th scope="col" class="tread">read</th>
		</tr>
		<tr>
			<td>15</td>
			<td class="left"> eget vehicula metus. In euismod sollicitudin lorem eu .</td>
			<td>Host Admin</td>
			<td>2011.05.11</td>
			<td>15000</td>
		</tr>
		<tr>
			<td>14</td>
			<td class="left">Lorem ipsum dolor sit amet, consectetur adipiscing elit.</td>
			<td>Sec Admin</td>
			<td>2011.05.11</td>
			<td>1500</td>
		</tr>
		<tr>
			<td>13</td>
			<td class="left">Vivamus viverra porttitor commodo.</td>
			<td>Sec Admin</td>
			<td>2011.05.11</td>
			<td>15</td>
		</tr>
		<tr>
			<td>12</td>
			<td class="left">In pulvinar fermentum erat a tincidunt. Nulla id magna sit ...</td>
			<td>Web Admin</td>
			<td>2011.05.11</td>
			<td>15</td>
		</tr>
		<tr>
			<td>11</td>
			<td class="left">Nullam ac dignissim diam. Mauris vitae magna ipsum,</td>
			<td>Web Admin</td>
			<td>2011.05.11</td>
			<td>150</td>
		</tr> 
		<tr>
			<td>10</td>
			<td class="left">Lorem ipsum dolor sit amet, consectetur adipiscing elit.</td>
			<td>Web Admin</td>
			<td>2011.05.11</td>
			<td>15000</td>
		</tr>
		<tr>
			<td>9</td>
			<td class="left">Vivamus viverra porttitor commodo.</td>
			<td>Web Admin</td>
			<td>2011.05.11</td>
			<td>150</td>
		</tr>
		<tr>
			<td>8</td>
			<td class="left">In pulvinar fermentum erat a tincidunt. Nulla id magna sit ...</td>
			<td>Sec Admin</td>
			<td>2011.05.11</td>
			<td>15000</td>
		</tr>
		<tr>
			<td>7</td>
			<td class="left">Sed diam velit, dictum a iaculis sed, tempor sed mi.</td>
			<td>Host Admin</td>
			<td>2011.05.11</td>
			<td>150</td>
		</tr>
		<tr>
			<td>6</td>
			<td class="left">Nullam ac dignissim diam. Mauris vitae magna ipsum,</td>
			<td>Host Admin</td>
			<td>2011.05.11</td>
			<td>15</td>
		</tr>
		<tr>
			<td>5</td>
			<td class="left"> eget vehicula metus. In euismod sollicitudin lorem eu.</td>
			<td>Host Admin</td>
			<td>2011.05.11</td>
			<td>15000</td>
		</tr>
		<tr>
			<td>4</td>
			<td class="left">Lorem ipsum dolor sit amet, consectetur adipiscing elit.</td>
			<td>Sec Admin</td>
			<td>2011.05.11</td>
			<td>1500</td>
		</tr>
		<tr>
			<td>3</td>
			<td class="left">Vivamus viverra porttitor commodo.</td>
			<td>Sec Admin</td>
			<td>2011.05.11</td>
			<td>15</td>
		</tr>
		<tr>
			<td>2</td>
			<td class="left">In pulvinar fermentum erat a tincidunt. Nulla id magna sit ...</td>
			<td>Web Admin</td>
			<td>2011.05.11</td>
			<td>15</td>
		</tr>
		<tr>
			<td>1</td>
			<td class="left">Nullam ac dignissim diam. Mauris vitae magna ipsum,</td>
			<td>Web Admin</td>
			<td>2011.05.11</td>
			<td>150</td>
		</tr>                   
	</table>

	<div id="table_search">
		<input name="" type="text" class="input_box"> <input type="button" value="Search" class="btn">
	</div>
	
	<div class="clear"></div>
	<div id="page_control">
		<a href="#">Prev</a> <a href="#">1</a> <a href="#">2</a> <a href="#">3</a> <a href="#">4</a> <a href="#">5</a> <a href="3">6</a> <a href="#">7</a> <a href="#">8</a> <a href="#">9</a> <a href="#">10</a> <a href="#">Next</a>
	</div>
		
	</article>
    
	<div class="clear"></div>
	<%-- footer 영역 --%>
	<jsp:include page="../include/bottomFooter.jsp" />
</div>

</body>
</html>   

