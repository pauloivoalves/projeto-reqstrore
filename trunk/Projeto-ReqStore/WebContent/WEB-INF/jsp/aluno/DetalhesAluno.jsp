<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="br.ufc.si.model.Requisito"%>
<%@page import="br.ufc.si.model.Projeto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script type="text/javascript" src="../js/Script.js"></script>
<script type="text/javascript" src="../js/JQuerry.js"></script>
<link href="../css/Style.css" rel="stylesheet" type="text/css" />
<link type="text/css" href="../css/menu.css" rel="stylesheet" />

<title>Detalhes do Aluno</title>
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
									<li><a href="<c:url value="/Projeto/lista"/>">Listar projetos</a></li>
									<li><a href="<c:url value="/Projeto/Busca"/>">Buscar Projetos</a></li>
									<li><a href="#">Meus Projetos</a></li>
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
						<p>
							Nome: <c:out value="${aluno.nome}"/>
						</p>
					</div>
				</div>

				<div id="inner_content">
					<div id="detalhes">

						<div class="descricao">
					
							<strong>Email: </strong><c:out value="${aluno.email}"/>
							
							
						</div>
					</div>

					<div id="lista">
						<div
							style="float: left; width: 49%; overflow: auto; height: 170px;">
							<table style="width: 100%; float: left;" id="lista_projetos">
								<thead>
									<tr>
										<td colspan="3" style="font-size: 14px;"><b>Projetos
												Próprios</b></td>
									</tr>
									<tr>
										<td><label>Projeto</label></td>
										<td><label>Tipo</label></td>
										<td><label>Dificuldade</label></td>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${aluno.projetos}" var="projeto">
										<tr
											onclick="location.href = '<c:url value="/Projeto/"/>Detalhes?id=${projeto.id}';">
											<td>${projeto.nome }</td>
											<td>${projeto.tipoProjeto }</td>
											<td>${projeto.dificuldade }</td>
										</tr>
									</c:forEach>
								</tbody>

							</table>
						</div>
						<div
							style="float: right; width: 49%; overflow: auto; height: 170px;">
							<table style="width: 100%; float: right;" id="lista_projetos">
								<thead>
									<tr>
										<td colspan="3" style="font-size: 14px;"><b>Projetos
												dos quais Paticipa</b></td>
									</tr>
									<tr>
										<td><label>Nome</label></td>
										<td><label>Email</label></td>
										<td><label>Projetos</label></td>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${aluno.projetos_participantes}"
										var="projeto">
										<tr
											onclick="location.href = '<c:url value="/Projeto/"/>Detalhes?id=${projeto.id}';">
											<td>${projeto.nome }</td>
											<td>${projeto.tipoProjeto }</td>
											<td>${projeto.dificuldade }</td>
										</tr>
									</c:forEach>
								</tbody>

							</table>
						</div>
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
</html>