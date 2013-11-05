<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script type="text/javascript" src="../js/Script.js"></script>
<script type="text/javascript" src="../js/JQuerry.js"></script>
<link href="../css/Style.css" rel="stylesheet" type="text/css" />
<link type="text/css" href="../css/menu.css" rel="stylesheet" />

<title>Meus Projetos</title>
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
									<li><a href="<c:url value="/Projeto/lista"/>">Listar Projetos</a></li>
									<li><a href="<c:url value="/Projeto/Busca"/>">Buscar Projetos</a></li>
									<li><a href="<c:url value="/Projeto/MeusProjetos?id=${usuarioWeb.id}"/>">Meus Projetos</a></li>
								</ul></li>
							<li><img src="../imagens/separador.png"></li>
							<li><a href="#">Usu&aacute;rios</a>
								<ul class="submenu" style = "z-index: 100">
									<li><a href="#">Listar Usu&aacute;rios</a></li>
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
									<li><a href="#">Minhas Turmas</a></li>
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

				<div id="inner_top">
					<div class="page_tittle">
						<p>Meus Projetos</p>
					</div>
				</div>
				<div id="inner_content">
					<div id="lista">
						<c:choose>
							<c:when test="${not empty projetoList }">
								<table align="center" id="lista_projetos">
									<thead>
										<tr>
											<td colspan="3" style="font-size: 14px;"><b>Projetos</b></td>
										</tr>
										<tr>
											<td><label>Projeto</label></td>
											<td><label>Tipo</label></td>
											<td><label>Porntua&ccedil;&atilde;o</label></td>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${projetoList}" var="projeto">
											<tr>
												<td onclick="location.href = 'Detalhes?id=${projeto.id}';">${projeto.nome }</td>
												<td onclick="location.href = 'Detalhes?id=${projeto.id}';">${projeto.tipoProjeto }</td>
												<td onclick="location.href = 'Detalhes?id=${projeto.id}';">${projeto.dificuldade }</td>
												<td onclick="location.href = 'Remover?id_projeto=${projeto.id}&id_usuario=${usuarioWeb.id}';" class = "exc"><img height="15px" src = "../imagens/trash0.png"></td>
											</tr>
										</c:forEach>
									</tbody>
		
								</table>
							</c:when>
							<c:otherwise>
							<br>
							<br>
							<br>
									<label style = "font-size: 18px; font-family: arial; font-weight: bold; color: #838388"> :(  Você não possui projetos cadastrados. <br>Consulte um administrador e solicite permissão para adicionar um projeto.</label>
							</c:otherwise>
						</c:choose>
					</div>
				</div>

			</div>
			<div id="footer_menu">
				<table>
					<tr>
						<td><a target="_blank"
							href="https://sistemas.quixada.ufc.br/apps2/sippa/index.jsp">SIPPA</a></td>
						<td>&bull;</td>
						<td><a target="_blank"
							href="https://sistemas.quixada.ufc.br/apps2/savi/index.jsp">SAVI</a></td>
						<td>&bull;</td>
						<td><a target="_blank"
							href="https://sistemas.quixada.ufc.br/apps2/sisac/index.jsp">SISAC</a></td>
						<td>&bull;</td>
						<td><a target="_blank"
							href="https://sistemas.quixada.ufc.br/SEVEN/">SEVEN</a></td>
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
	$('.exc').mouseenter( function(){
		$('img',$(this)).attr('src','../imagens/trash.png');
	} ).mouseleave( function(){
		$('img',$(this)).attr('src','../imagens/trash0.png');
	} );
</script>

</html>