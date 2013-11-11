<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<meta http-equiv="Content-type" content="text/html; charset=iso-8859-1" />  
    <meta http-equiv="Content-Language" content="pt-br" />  
	<script type="text/javascript" src="../js/JQuerry.js"></script>
	<script type="text/javascript" src="../js/menu.js"></script>
	
	<link href="../css/menu.css" rel="stylesheet" type="text/css" />
	<link href="../css/Style.css" rel="stylesheet" type="text/css" />

	<title>Novo Requisito</title>
</head>
<body>
	<div id="tudo">
		<div id="content">
			<div id="topo">
				<img alt="" src="../imagens/Logo.png">
			</div>
			<c:choose>
				<c:when test="${usuarioWeb.tipo == 1}">
					<div id="menu">
						<ul class="dropdown">
							<li><a href="<c:url value="/Aluno/home"/>">Home</a></li>
							<li><img src="../imagens/separador.png"></li>
							<li><a href="#">Projetos</a>
								<ul class="submenu" style = "z-index: 100">
									<li><a href="<c:url value="/Projeto/lista?id_usuario=${usuarioWeb.id}"/>">Listar Projetos</a></li>
									<li><a href="<c:url value="/Projeto/Busca"/>">Buscar Projetos</a></li>
									<li><a href="<c:url value="/Projeto/MeusProjetos?id=${usuarioWeb.id}"/>">Meus Projetos</a></li>
								</ul></li>
							<li><img src="../imagens/separador.png"></li>
							<li><a href="#">Usu&aacute;rios</a>
								<ul class="submenu" style = "z-index: 100">
									<li><a href="<c:url value="/Usuarios/ListarUsuarios"/>">Listar Usu&aacute;rios</a></li>
									<li><a href="#">Buscar Usu&aacute;rio</a>
								</ul>
							</li>
							<li><img src="../imagens/separador.png"></li>
							<li><a href="#">Ajuda</a></li> 
								
							<c:if test="${!usuarioWeb.logado}">
								<li><img src="../imagens/separador.png"></li>
								<li><a href="<c:url value="/login"/>">Login</a></li>
							</c:if> <c:if test="${usuarioWeb.logado}">
								<li><img src="../imagens/separador.png"></li>
								<li><a href="<c:url value="/logout"/>">Logout</a></li>
							</c:if>
						</ul>
					</div>
				</c:when>
				<c:when test="${usuarioWeb.tipo == 2}">
					<div id="menu">
						<ul class="dropdown" style="width: 65% !important;">

							<li><a href="<c:url value="/Professor/ProfessorHome"/>">Home</a></li>
							<li><img src="../imagens/separador.png"></li>
							<li><a href="#">Projetos</a>
								<ul class="submenu" style = "z-index: 100">
									<li><a href="<c:url value="/Projeto/NovoProjeto"/>">Adicionar Projetos</a></li>
									<li><a href="<c:url value="/Projeto/lista?id_usuario=${usuarioWeb.id}"/>">Listar Projetos</a></li>
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
									<li><a href="<c:url value="/Usuarios/ListarUsuarios"/>">Listar Usu&aacute;rios</a></li>
									<li><a href="#">Buscar Usu&aacute;rio</a>
								</ul>
							</li>
							<li><img src="../imagens/separador.png"></li>
							<li><a href="#">Ajuda</a></li> 
							
							<c:if test="${!usuarioWeb.logado}">
								<li><img src="../imagens/separador.png"></li>
								<li><a href="<c:url value="/login"/>">Login</a></li>
							</c:if> 
							<c:if test="${usuarioWeb.logado}">
								<li><img src="../imagens/separador.png"></li>
								<li><a href="<c:url value="/logout"/>">Logout</a></li>
							</c:if>
						</ul>
					</div>
				</c:when>
				<c:otherwise>
					<!-- Adicionar home de admin -->
				</c:otherwise>
			</c:choose>
			<div id="inner_content_div">
				<form name  = "cadastrarRequisito" id = "cadastrarRequisito" action="<c:url value="/Requisito/AdicionaRequisito"/>" method="POST">
					<input type = "hidden" name = "requisito.tipoRequisito" id = "tipoRequisito" value = "">
					<input type = "hidden" name = "requisito.prioridadeRequisito" id = "prioriRequisito" value = "">
					<input type = "hidden" name = "id_projeto" value = "${projeto.id }">
				
					<div id = "novo_projeto">
						
						<label for="projeto.descricoa">Descri&ccedil;&atilde;o:</label> <br>
						<textarea maxlength="599" id = "descricao" name = "requisito.descricao" class = "input_login" style = "height: 60px; width: 600px;"></textarea><br>
						
						<label for="senha">Objetivo:</label> <br>
						<textarea maxlength="400" id = "objetivo" name = "requisito.foco_requisito" style = "height: 60px; width: 600px;"class = "input_login"></textarea><br>
						
						<label for = "select_tipo">Tipo do Requisto</label><br>
						<select class  = "input_login" name = "select_tipo" id = "select_tipo">
							<option value = "-1">Selecione...</option>
							<option value = "0">FUNCIONAL</option>
							<option value = "1">NAO FUNCIONAL</option>
							<option value = "2">NEGOCIO</option>							
						</select>
						<br>
						<label for = "select_prioridade">Prioridade do Requisto</label><br>
						<select class  = "input_login" name = "select_prioridade" id = "select_prioridade">
							<option value = "-1">Selecione...</option>
							<option value = "0">ESSENCIAL</option>
							<option value = "1">IMPORTANTE</option>
							<option value = "2">DESEJAVEL</option>
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
		
	$('#select_tipo').change(function() {
		$('#tipoRequisito').val($("#select_tipo option:selected").val());
	});
	
	$('#select_prioridade').change(function() {
		$('#prioriRequisito').val($("#select_prioridade option:selected").val());
	});
	
	$('#cadastrar').click(function() {
		if ($('#descricao').val() == "") {
			alert('Campo "Descri\u00e7\u00e3o" n\u00e3o preenchido.');
			$('#descricao').focus();
			return false;
		} else if ($('#objetivo').val() == "") {
			alert('Campo "Objetivo" n\u00e3o preenchido.');
			$('#objetivo').focus();
			return false;
		}else if($("#select_tipo option").filter(":selected").val() == "-1"){
			alert('Campo "Tipo do Projeto" n\u00e3o selecionado.');
			$('#select_tipo').focus();
			return false;
		}else if($("#select_prioridade option").filter(":selected").val() == "-1"){
			alert('Campo "Prioridade do Requisito" n\u00e3o selecionado.');
			$('#select_prioridade').focus();
			return false;
		}

		document.cadastrarRequisito.submit();
	});
</script>

</html>