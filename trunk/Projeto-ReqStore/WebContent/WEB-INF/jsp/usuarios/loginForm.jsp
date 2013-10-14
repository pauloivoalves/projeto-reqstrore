<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script type="text/javascript" src="js/JQuerry.js"></script>
	<script type="text/javascript" src="js/menu.js"></script>
	
	<link href="css/menu.css" rel="stylesheet" type="text/css" />
	<link href="css/Style.css" rel="stylesheet" type="text/css" />
	
	<title>ReqSore - LoginLogin</title>
</head>
<body>
	<input type="hidden" name="usuario" value="" id="usuario">
	<div id="tudo">
		<div id="content">
			<div id="topo">
				<img alt="" src="imagens/Logo.png">
			</div>
			<div id="menu">
				<ul class="dropdown">

					<li><a href="<c:url value="/"/>">Home</a></li>
					<li><img src="imagens/separador.png"></li>
					<li><a href="#">Sobre</a>
					<li><img src="imagens/separador.png"></li>
					<li><a href="#">Ajuda</a></li>
					<c:if test="${!usuarioWeb.logado}">
						<li><img src="imagens/separador.png"></li>
						<li><a href="<c:url value="/login"/>">Login</a></li>
					</c:if>
					<c:if test="${usuarioWeb.logado}">
						<li><img src="imagens/separador.png"></li>
						<li><a href="<c:url value="/logout"/>">Logout</a></li>
					</c:if>
				</ul>
			</div>
			<div id="inner_content_div">
				<form name  = "formLogin" id = "formLogin" action="<c:url value="/login"/>" method="POST">
				<input type = "hidden" name = "tipo_usuario" id = "tipo_usuario">
				
					<div id = "login">

						<label for="Email">Login:</label> <br>
						<input id="email" class  = "input_login" type="text" name="aluno.email" /> <br>
						
						<label for="senha">Senha:</label> <br>
						<input  class  = "input_login" id="senha" type="password" name="aluno.senha" /><br>
						
						<label for = "select_usuario">Tipo de Usu&aacute;rio</label><br>
						<select class  = "input_login" name  = "select_usuario" id = "select_usuario">
							<option value = "Selecione..."></option>
							<option value = "aluno">Aluno</option>
							<option value = "professor">Professor</option>
							<option value = "administrador">Administrador</option>
						</select>

						<a id = "entrar"href = "#"><img src = "imagens/entrar.png"></a>
					</div>
				</form>
			</div>
			<div id="footer_menu">
				<table>
					<tr>
						<td><a target="_blank" href="https://sistemas.quixada.ufc.br/apps2/sippa/index.jsp">SIPPA</a></td>
						<td>&bull;</td>
						<td><a target="_blank" href="https://sistemas.quixada.ufc.br/apps2/savi/index.jsp">SAVI</a></td>
						<td>&bull;</td>
						<td><a target="_blank" href="https://sistemas.quixada.ufc.br/apps2/sisac/index.jsp">SISAC</a></td>
						<td>&bull;</td>
						<td><a target="_blank" href="https://sistemas.quixada.ufc.br/SEVEN/">SEVEN</a></td>
						<td>&bull;</td>
						<td><a target="_blank" href="http://www.si3.ufc.br/">SIGAA</a></td>
					</tr>
				</table>

			</div>
			<div id="rodape">
				<strong>&reg; Todos os Direitos Reservados</strong>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	$('#entrar').click(function(){
		if($('#email').val() == ""){
			alert('Campo "E-mail" n\u00e3o preenchido.');
			$('#email').focus();
			return false;
		}else if($('#senha').val() == ""){
			alert('Campo "Senha" n\u00e3o preencido."');
			$('#senha').focus();
		}else if($("#select_usuario option").filter(":selected").val() == "Selecione..."){
			alert('Campo "Tipo Usu\u00e1rio" n\u00e3o selecionado.');
			$('#select_usuario').focus();
			return false;
		}
		
		document.formLogin.submit();	
	});
</script>

</html>