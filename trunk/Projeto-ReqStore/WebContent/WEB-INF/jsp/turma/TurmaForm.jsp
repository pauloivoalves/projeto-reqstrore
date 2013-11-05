<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<script type="text/javascript" src="../js/JQuerry.js"></script>
		<script type="text/javascript" src="../js/menu.js"></script>
		
		<link href="../css/menu.css" rel="stylesheet" type="text/css" />
		<link href="../css/Style.css" rel="stylesheet" type="text/css" />
	
	<title>Nova Turma</title>
</head>
<body>
	<div id="tudo">
		<div id="content">
			<div id="topo">
				<img alt="" src="../imagens/Logo.png">
			</div>
			<div id="menu">
				<ul class="dropdown" style = "width: 65% !important;">

					<li><a href="<c:url value="/Professor/ProfessorHome"/>">Home</a></li>
					<li><img src="../imagens/separador.png"></li>
					<li><a href="#">Projetos</a>
						<ul class="submenu" style = "z-index: 100">
							<li><a href="<c:url value="/Projeto/NovoProjeto"/>">Adicionar Projetos</a></li>
									<li><a href="<c:url value="/Projeto/lista"/>">Listar Projetos</a></li>
									<li><a href="<c:url value="/Projeto/Busca"/>">Buscar Projetos</a></li>
									<li><a href="<c:url value="/Projeto/MeusProjetos?id=${usuarioWeb.id}"/>">Meus Projetos</a></li>
						</ul>
					</li>
					<li><img src="../imagens/separador.png"></li>
					<li><a href="#">Turmas</a>
						<ul class="submenu" style = "z-index: 100">
							<li><a href="<c:url value="/Turma/TurmaForm"/>">Adicionar Turma</a></li>
							<li><a href="<c:url value="/Turma/lista"/>">Listar Turmas</a></li>
							<li><a href="#">Buscar Turmas</a></li>
							<li><a href="<c:url value="/Turma/MinhasTurmas?id=${usuarioWeb.id}"/>">Minhas Turmas</a></li>
						</ul>
					</li>
					<li><img src="../imagens/separador.png"></li>
					<li><a href="#">Usu&aacute;rios</a>
						<ul class="submenu" style = "z-index: 100">
							<li><a href="#">Listar Usu&aacute;rios</a></li>
							<li><a href="#">Buscar Usu&aacute;rio</a>
						</ul>
					</li>
					<li><img src="../imagens/separador.png"></li>
					<li><a href="#">Ajuda</a> <c:if test="${!usuarioWeb.logado}">
							<li><img src="../imagens/separador.png"></li>
							<li><a href="<c:url value="/login"/>">Login</a></li>
						</c:if> <c:if test="${usuarioWeb.logado}">
							<li><img src="../imagens/separador.png"></li>
							<li><a href="<c:url value="/logout"/>">Logout</a></li>
						</c:if>
				</ul>
			</div>
			<div id="inner_content_div">
				<form name  = "AdicionaTurma" id = "AdicionaTurma" action="<c:url value="/Turma/AdicionaTurma"/>" method="POST">
				<input type="hidden" name = "id_usuario" id = "id_usuario" value = "${usuarioWeb.id}">
					<div id = "novo_projeto">
						<label for="nome">Nome da Turma:</label> <br>
						<input id="nome" class = "input_login" type="text" name="turma.nome"/><br>
						
						<label for="descricao">Descri&ccedil;&atilde;o:</label> <br>
						<textarea maxlength="700" id = "descricao" name = "turma.descricao" class = "input_login" style = "height: 60px; width: 600px;"></textarea><br>
						
						<a class  = "input_login btn-success" id = "cadastrar" href = "#">Cadastrar</a>
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
		
	$('#cadastrar').click(function() {
		if ($('#nome').val() == "") {
			alert('Campo "Nome do Projeto" n\u00e3o preenchido.');
			$('#nome').focus();
			return false;
		} else if ($('#descricao').val() == "") {
			alert('Campo "Descri\u00e7\u00e3o" n\u00e3o preenchido.');
			$('#descricao').focus();
			return false;
		} 
		document.AdicionaTurma.submit();
	});
</script>

</html>