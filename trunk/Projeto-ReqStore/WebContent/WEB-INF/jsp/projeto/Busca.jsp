<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="br.ufc.si.Tipos.TipoProjeto"%>
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

<title>Busca de Projetos</title>

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
								<label>Buscar Projetos</label>
							</p>
						</div>
					</div>
	
					<div id="inner_content">
						<form name = "formBuscarProjeto" action="/ReqStore/Projeto/Busca">
							<div id="detalhes">
	
							<div id = "tituloDificuldade">
								<div id= "titulo" style = "width: 50%; float: left;">
									<label for="titulo">Título do Projeto</label><br>	
									<input type="text" name = "nomeProjeto" value = ""> 
								</div>
								
								<div id= "porntuacaoProjeto" style = "width: 50%; float: right;">
									<label>Pontuação do Projeto</label><br>
									<input id = "pontuacaoProjeto" type="radio" value = "4" name = "pontuacaoProjeto">Pontuação 4
								</div>
							</div>
	
							<div id="tipoProjeto">
								<label style = "font-size: 12px;">Tipo do Projeto</label><br>	
								<input id = "TipoDesk" class = "teste" type="radio" name = "tipoProjeto" value = "DESKTOP"> DESKTOP
								<input id = "TipoMob" class = "teste" type="radio" name = "tipoProjeto" value = "MOBILE"> MOBILE
								<input id = "TipoWeb" class = "teste" type="radio" name = "tipoProjeto" value = "WEB"> WEB
							</div>
							
							
							<input id = "buscar" type="submit">
					</div>
						</form>
	
						<div id="requisitos">
							<c:choose>
								<c:when test="${not empty projetoList}">
								
									<table align="center" id="lista_projetos">
										<thead>
											<tr>
												<td colspan="3" style="font-size: 14px;"><b>Requisitos</b></td>
											</tr>

											<tr>
												<td><label>Projeto</label></td>
												<td><label>Tipo</label></td>
												<td><label>Porntua&ccedil;&atilde;o</label></td>
											</tr>
										</thead>

										<tbody>
											<c:forEach items="${projetoList}" var="projeto">
												<tr onclick="location.href = 'Detalhes?id=${projeto.id}';">
													<td>${projeto.nome }</td>
													<td>${projeto.tipoProjeto }</td>
													<td>${projeto.pontuacao }</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>

								</c:when>
								<c:otherwise>
											<script type = "text/javascript">
												alert('Não foram encontrados projetos com os parâmetros definidos.');
											</script>
								</c:otherwise>
							</c:choose>
						</div>
					</div>
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
	<script type="text/javascript">
		$('#buscar').click(function(){
			
			if($("#pontuacaoProjeto").is(":checked") == false){
				
				alert('Para melhor refinamento da busca você deve selecionar uma dificuldade.');
				return false;
				
			}else if (!$(".teste").is(":checked")){
				alert ('Para melhor refinamento da busca você deve selecionar um tipo de projeto.');
				return false;
			}
			
			document.formBuscarProjeto.submit();
		});
	</script>
</body>
</html>