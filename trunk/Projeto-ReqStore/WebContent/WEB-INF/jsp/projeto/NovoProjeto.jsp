<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<script type="text/javascript" src="../js/JQuerry.js"></script>
		<script type="text/javascript" src="../js/menu.js"></script>
		
		<link href="../css/menu.css" rel="stylesheet" type="text/css" />
		<link href="../css/Style.css" rel="stylesheet" type="text/css" />
	
	<title>Novo Projeto</title>
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
				<form name  = "cadastrarProjeto" id = "cadastrarProjeto" action="<c:url value="/Projeto/AdicionaProjeto"/>" method="POST">
				<input type = "hidden" name = "projeto.tipoProjeto" id = "tipoProjeto" value = "">
				<input type = "hidden" name = "projeto.dificuldade" id = "dificuldadeProjeto" value = "2">
				<input type = "hidden" name = "id_criador" value = "${usuarioWeb.id }">
				
					<div id = "novo_projeto">
						<label for="nome">Nome do Projeto:</label> <br>
						<input id="nome" class = "input_login" type="text" name="projeto.nome"/>
						
						
						<div id= "porntuacaoProjeto" style = "width: 50%; float: right; margin-top: -17px;">
										<label>Dificuldade do Projeto</label><br>
										<input type = "hidden" id = "dificuldadeProjeto" name = "dificuldadeProjeto" value = "2">
										<ul>
											<li id = "iniciante" value = "2"><img style = "cursor:pointer;" title = "2" src = "../imagens/dificuldadeselecionada.png"></li>
											<li id = "iniciado" value = "4"><img style = "cursor:pointer;" title = "4" src = "../imagens/dificuldade.png"></li>
											<li id = "medio" value = "6"><img style = "cursor:pointer;" title = "6" src = "../imagens/dificuldade.png"></li>
											<li id = "dificil" value = "8"><img style = "cursor:pointer;" title = "8" src = "../imagens/dificuldade.png"></li>
											<li id = "avancado" value = "10"><img style = "cursor:pointer;" title = "10" src = "../imagens/dificuldade.png"></li>
										</ul>
									</div><br>

						<label for="projeto.descricoa">Descri&ccedil;&atilde;o:</label> <br>
						<textarea maxlength="700" id = "descricao" name = "projeto.descricao" class = "input_login" style = "height: 60px; width: 600px;"></textarea><br>
						
						<label for="senha">Objetivo:</label> <br>
						<textarea maxlength="700" id = "objetivo" name = "projeto.foco_projeto" style = "height: 60px; width: 600px;"class = "input_login"></textarea><br>
						
						<label for = "select_projeto">Tipo do Projeto</label><br>
						<select class  = "input_login" name  = "select_projeto" id = "select_projeto">
							<option value = "0">Selecione...</option>
							<option value = "1">WEB</option>
							<option value = "2">DESKTOP</option>
							<option value = "3">MOBILE</option>
							<option value = "4">COMERCIAL</option>
							<option value = "4">EDUCACIONAL</option>
						</select>
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
		
	$('#select_projeto').change(function() {
		$('#tipoProjeto').val($("#select_projeto option:selected").val());
	});
	
	$('#iniciante').click(function(){
		$('#iniciado > img').attr('src', '../imagens/dificuldade.png');
		$('#medio > img').attr('src', '../imagens/dificuldade.png');
		$('#dificil > img').attr('src', '../imagens/dificuldade.png');
		$('#avancado > img').attr('src', '../imagens/dificuldade.png');
		$('#dificuldadeProjeto').val('2');
	});
	$('#iniciado').click(function(){
		$('#iniciado > img').attr('src', '../imagens/dificuldadeselecionada.png');
		$('#iniciante > img').attr('src', '../imagens/dificuldadeselecionada.png');
		$('#medio > img').attr('src', '../imagens/dificuldade.png');
		$('#dificil > img').attr('src', '../imagens/dificuldade.png');
		$('#avancado > img').attr('src', '../imagens/dificuldade.png');
		$('#dificuldadeProjeto').val('4');
	});
	$('#medio').click(function(){
		$('#medio > img').attr('src', '../imagens/dificuldadeselecionada.png');
		$('#iniciado > img').attr('src', '../imagens/dificuldadeselecionada.png');
		$('#iniciante > img').attr('src', '../imagens/dificuldadeselecionada.png');
		$('#dificil > img').attr('src', '../imagens/dificuldade.png');
		$('#avancado > img').attr('src', '../imagens/dificuldade.png');
		$('#dificuldadeProjeto').val('6');
	});
	$('#dificil').click(function(){
		$('#dificil > img').attr('src', '../imagens/dificuldadeselecionada.png');
		$('#medio > img').attr('src', '../imagens/dificuldadeselecionada.png');
		$('#iniciado > img').attr('src', '../imagens/dificuldadeselecionada.png');
		$('#iniciante > img').attr('src', '../imagens/dificuldadeselecionada.png');
		$('#avancado > img').attr('src', '../imagens/dificuldade.png');
		$('#dificuldadeProjeto').val('8');
	});
	$('#avancado').click(function(){
		$('#avancado > img').attr('src', '../imagens/dificuldadeselecionada.png');
		$('#dificil > img').attr('src', '../imagens/dificuldadeselecionada.png');
		$('#medio > img').attr('src', '../imagens/dificuldadeselecionada.png');
		$('#iniciado > img').attr('src', '../imagens/dificuldadeselecionada.png');
		$('#iniciante > img').attr('src', '../imagens/dificuldadeselecionada.png');
		$('#dificuldadeProjeto').val('10');
	});

	$('#cadastrar').click(function() {
		if ($('#nome').val() == "") {
			alert('Campo "Nome do Projeto" n\u00e3o preenchido.');
			$('#nome').focus();
			return false;
		} else if ($('#descricao').val() == "") {
			alert('Campo "Descri\u00e7\u00e3o" n\u00e3o preenchido.');
			$('#descricao').focus();
			return false;
		} else if ($('#objetivo').val() == "") {
			alert('Campo "Objetivo" n\u00e3o preenchido.');
			$('#objetivo').focus();
			return false;
		}else if($("#select_projeto option").filter(":selected").val() == "0"){
			alert('Campo "Tipo do Projeto" n\u00e3o selecionado.');
			$('#select_projeto').focus();
			return false;
		}

		document.cadastrarProjeto.submit();
	});
</script>

</html>