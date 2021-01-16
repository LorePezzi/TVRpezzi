
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- dichiarazione e instanziazione di un loginBean !-->
<jsp:useBean id="richiesteBean" scope="request" class="jsp.RichiesteBean"/>

<!-- mappare gli attributi di un oggetto sui campi della form -->

<jsp:setProperty name="richiesteBean" property="*" />

<%
    if (request.getParameter("send") != null) {
        if (richiesteBean.invio()) {
%>
       
<%
        } else {
%>
<p style="color: red">Dati errati</p>
<%
        }
    }
%>
<html>
<head>
    <title>Login page</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <link href="css/style.css" rel="stylesheet">  
    
    <script>
    $(function () {
        $("#dataRilascio, #dataScad").datepicker({
            dateFormat: "yy-mm-dd"
        });
    });
    </script>
    
      
</head>
<body>
<div class="container">
    <form action="index.jsp" name="searchRideForm" method="POST">
		<table>
			<tr>
				<td><label for="from">Numero Patente:</label></td>
				<td><input type="text" id="numero" name="numero" autocomplete="off" autofocus required></td>
			</tr>
			<tr>
				<td><label for="date" placeholder="yyyy-mm-dd">Data di rilascio:</label></td>
				<td><input type="date" id="dataRilascio" name="dataRilascio"></td>
			</tr>
			<tr>
				<td><label for="date" placeholder="yyyy-mm-dd">Data scadenza:</label></td>
				<td><input type="date" id="dataScad" name="dataScad"></td>
			</tr>
			<tr>
				<td><label for="from">Ente di rilascio:</label></td>
				<td><input type="text" id="ente" name="ente" autocomplete="off" autofocus required></td>
			</tr>
			<tr>
				<td><input type="submit" name="send" value="Send"></td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>
