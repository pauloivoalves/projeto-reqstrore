<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="br.ufc.si.model.Requisito"%>
<%@page import="br.ufc.si.model.Projeto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script type="text/javascript" src="../js/Script.js"></script>
<script type="text/javascript" src="../js/JQuerry.js"></script>
<link href="../css/Style.css" rel="stylesheet" type="text/css" />
<link type="text/css" href="../css/menu.css" rel="stylesheet" />

<title>Home</title>
</head>
<body>
	<div id="tudo">
		<div id="content">
			<div id="topo">
				<img alt="" src="../imagens/Logo.png">
			</div>
			<div id="menu">
				<ul class="dropdown">

					<li><a href="<c:url value="/Aluno/home"/>">Home</a></li>
					<li><img src="../imagens/separador.png"></li>
					<li><a href="#">Projetos</a>
						<ul class="submenu">
							<li><a href="<c:url value="/Projeto/lista"/>">Listar projetos</a></li>
							<li><a href="<c:url value="/Projeto/Busca"/>">Buscar Projetos</a></li>
							<li><a href="#">Meus Projetos</a></li>
						</ul></li>
					<li><img src="../imagens/separador.png"></li>
					<li><a href="#">Usu&aacute;rios</a>
						<ul class="submenu">
							<li><a href="#">Listar Usu&aacute;rios</a></li>
							<li><a href="#">Buscar Usu&aacute;rio</a>
						</ul></li>
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

				<div id="inner_top">
					<div class="page_tittle">
						<p>
							<c:out value="${projeto.nome}"></c:out>
						</p>
					</div>
				</div>

				<div id="inner_content">
					<div id="detalhes">

						<div class="descricao">
							<strong>Descrição</strong><br /> <br />
							<c:out value="${projeto.descricao}"></c:out>
						</div>


						<div id="detalhes2">
							<strong>Pontuação : </strong>
							<c:out value="${projeto.dificuldade}"></c:out>

							<Strong>Tipo do Projeto: </Strong>
							<c:out value="${projeto.tipoProjeto}"></c:out>
						</div>
					</div>

					<div id="requisitos">
						<table align="center" id="lista_projetos">
							<thead>
								<tr>
									<td colspan="3" style="font-size: 14px;"><b>Requisitos</b></td>
								</tr>

								<tr>
									<td><label>Tipo do Requisito</label></td>
									<td><label>Prioridade do Requisito</label></td>
									<td><label>Descrição do Requisito</label></td>
								</tr>
							</thead>

							<tbody>
								<c:forEach items="${projeto.requisitos}" var="requisito">
									<c:set var="desc1" value="${requisito.descricao }" />
									<c:set var="desc2" value="${fn:substring(desc1, 0, 60)}" />


									<tr onclick="location.href = '<c:url value="/Requisito/DetalhesRequisito"/>?id=${requisito.id}';">
										<td>${requisito.tipoRequisito }</td>
										<td>${requisito.prioridadeRequisito }</td>
										<td>${desc2}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>

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