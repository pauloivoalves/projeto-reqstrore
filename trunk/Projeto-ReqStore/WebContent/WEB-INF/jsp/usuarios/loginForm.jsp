<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<script type="text/javascript" src="js/JQuerry.js"></script>
		<link href="css/Style.css" rel="stylesheet" type="text/css"/>
			<title>ReqSore - LoginLogin</title>
	
	
	<script type="text/javascript">
		$(window).load(function() {
			$('#usuario').val($('#tipo_usuario option:selected').val());
			$('#email').attr('name', "aluno.email");
			$('#senha').attr('name', "aluno.senha");
			
		});
	
		function MudaTipoUsuario() {
			$('#usuario').val($('#tipo_usuario option:selected').val());
			
			if($('#usuario').val() == '1'){
				$('#email').attr('name', "aluno.email");
				$('#senha').attr('name', "aluno.senha");
			}else if($('#usuario').val() == '2'){
				$('#email').attr('name', "professor.email");
				$('#senha').attr('name', "professor.senha");
			}else{
				$('#email').attr('name', "administrador.email");
				$('#senha').attr('name', "administrador.senha");				
			}
		}
		
	</script>
</head>
	<body>
	<input type="hidden" name = "usuario" value = "" id = "usuario">
		<div id = "tudo">
			<div id = "content">
				<div id = "topo">
					<img alt="" src="imagens/Logo.png">
				</div>
				<div id = "menu">
				 	<table align="center">
				 		<tr>
				 			<td><label>Home</label></td>
				 			<td><img src = "imagens/separador.png"> </td>
				 			<td><label>Sobre</label></td>
				 			<td><img src = "imagens/separador.png"> </td>
				 			<td><label>Ajuda</label></td>
				 			<td><img src = "imagens/separador.png"> </td>
				 			<td><label>Entrar</label></td>
				 			<c:if test="${usuarioWeb.logado}">
				 				<a href="<c:url value="/logout"/>">Logout</a>
    						</c:if>
				 		</tr>
				 	</table>
				</div>
			<div id="inner_content_div">
				<form action="<c:url value="/login"/>" method="POST">
				  <fieldset>
				    <legend>Efetue o login</legend>
				        
				    <label for="Email">Login:</label>
				      <input id="email" type="text" name="aluno.email"/>
				
				    <label for="senha">Senha:</label>
				      <input id="senha" type="password" name="aluno.senha"/>
				
				    <button type="submit">Login</button>
				  </fieldset>
				</form>
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