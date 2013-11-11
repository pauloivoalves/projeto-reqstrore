<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<meta http-equiv="Content-type" content="text/html; charset=iso-8859-1" />  
    <meta http-equiv="Content-Language" content="pt-br" />
		<script type="text/javascript" src="js/Script.js"></script>
		<link href="css/Style.css" rel="stylesheet" type="text/css"/>
		<title>Listar Usuários</title>
	</head>
	<body>
		<div id = "tudo">
			<div id = "content">
				<div id = "topo">
					<img alt="" src="imagens/Logo.png">
				</div>
				<div id = "menu">
				 	<table align="center">
				 		<tr>
				 			<td><a href="<c:url value="/"/>">Home</a></td>	
				 			<td><img src = "imagens/separador.png"> </td>
				 			<td><label>Sobre</label></td>
				 			<td><img src = "imagens/separador.png"> </td>
				 			<td><label>Ajuda</label></td>
				 			<td><img src = "imagens/separador.png"> </td>
				 			<td><a href="<c:url value="/login"/>">Login</a></td>
				 		</tr>
				 	</table>
				</div>
				<div id = "inner_content_div" >
							 TESTETESTETESTETESTETESTETESTETESTETESTETESTETESTE
				</div>
				<div id = "footer_menu">
					<table>
						<tr>
							<td><a target="_blank" href = "https://sistemas.quixada.ufc.br/apps2/sippa/index.jsp">SIPPA</a></td>
							<td>&bull;</td>
							<td><a target="_blank" href = "https://sistemas.quixada.ufc.br/apps2/savi/index.jsp">SAVI</a></td>
							<td>&bull;</td>
							<td><a target="_blank" href = "https://sistemas.quixada.ufc.br/apps2/sisac/index.jsp">SISAC</a></td>
							<td>&bull;</td>
							<td><a target="_blank" href = "https://sistemas.quixada.ufc.br/SEVEN/">SEVEN</a></td>
							<td>&bull;</td>
							<td><a target="_blank" href = "http://www.si3.ufc.br/">SIGAA</a></td>
						</tr>
					</table>
					
				</div>
				<div id = "rodape">
						<strong>&reg; Todos os Direitos Reservados</strong>
				</div>
			</div>
		</div>
	</body>
</html>