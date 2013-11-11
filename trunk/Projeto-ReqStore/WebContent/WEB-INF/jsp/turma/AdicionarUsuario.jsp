<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<meta http-equiv="Content-type" content="text/html; charset=iso-8859-1" />  
<meta http-equiv="Content-Language" content="pt-br" />

<script type="text/javascript" src="../js/Script.js"></script>
<script type="text/javascript" src="../js/JQuerry.js"></script>
<link href="../css/Style.css" rel="stylesheet" type="text/css" />
<link type="text/css" href="../css/menu.css" rel="stylesheet" />

<title>Listar Usuarios</title>
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
								<ul class="submenu">
									<li><a href="<c:url value="/Projeto/lista?id_usuario=${usuarioWeb.id}"/>">Listar Projetos</a></li>
									<li><a href="<c:url value="/Projeto/Busca"/>">Buscar Projetos</a></li>
									<li><a href="<c:url value="/Projeto/MeusProjetos?id=${usuarioWeb.id}"/>">Meus Projetos</a></li>
								</ul></li>
							<li><img src="../imagens/separador.png"></li>
							<li><a href="#">Usu&aacute;rios</a>
								<ul class="submenu">
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
						<ul class="dropdown" style = "width: 65% !important;">
		
							<li><a href="<c:url value="/Professor/ProfessorHome"/>">Home</a></li>
							<li><img src="../imagens/separador.png"></li>
							<li><a href="#">Projetos</a>
								<ul class="submenu">
									<li><a href="<c:url value="/Projeto/NovoProjeto"/>">Adicionar Projetos</a></li>
									<li><a href="<c:url value="/Projeto/lista?id_usuario=${usuarioWeb.id}"/>">Listar Projetos</a></li>
									<li><a href="<c:url value="/Projeto/Busca"/>">Buscar Projetos</a></li>
									<li><a href="<c:url value="/Projeto/MeusProjetos?id=${usuarioWeb.id}"/>">Meus Projetos</a></li>
								</ul>
							</li>
							<li><img src="../imagens/separador.png"></li>
							<li><a href="#">Turmas</a>
								<ul class="submenu">
									<li><a href="<c:url value="/Turma/TurmaForm"/>">Adicionar Turma</a></li>
									<li><a href="<c:url value="/Turma/lista"/>">Listar Turmas</a></li>
									<li><a href="#">Buscar Turmas</a></li>
									<li><a href="<c:url value="/Turma/MinhasTurmas?id=${usuarioWeb.id}"/>">Minhas Turmas</a></li>
								</ul>
							</li>
							<li><img src="../imagens/separador.png"></li>
							<li><a href="#">Usu&aacute;rios</a>
								<ul class="submenu">
									<li><a href="<c:url value="/Usuarios/ListarUsuarios"/>">Listar Usu&aacute;rios</a></li>
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
				</c:when>
				<c:otherwise>
					<!-- Adicionar home de admin -->
				</c:otherwise>
			</c:choose>

			<div id="inner_content_div">

				<div id="inner_top">
					<div class="page_tittle">
						<p>Listar Usuarios</p>
					</div>
				</div>
				<div id="inner_content">
					<div id="lista">
						<table style="width: 100%; float: right;" id="lista_projetos">
								<thead>
									<tr>
										<td colspan="3" style="font-size: 14px;"><b>Participantes</b></td>
									</tr>
									<tr>
										<td><label>Nome</label></td>
										<td><label>Email</label></td>
										<td><label>Projetos</label></td>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${usuarioWeb.all}" var="user">
										<tr>
											<td onclick="location.href = '<c:url value="/Aluno/"/>DetalhesAluno?id=${user.id}';">${user.nome }</td>
											<td onclick="location.href = '<c:url value="/Aluno/"/>DetalhesAluno?id=${user.id}';">${user.email }</td>
											<td onclick="location.href = '<c:url value="/Aluno/"/>DetalhesAluno?id=${user.id}';">${fn:length(user.projetos_participantes) + fn:length(user.projetos)}</td>
											
											<td onclick="location.href = '<c:url value="/Turma/AdicionarUsuarioTurma?id_turma=${turma.id}&id_usuario=${user.id}"/>';" style = "width: 15px; padding: 0px;" class = "botton_user">
												<span id="addUsuario" style="cursor: pointer; padding: 5px 10px; background-color: rgb(82, 113, 0); color: white; 
												float: right; border-top-left-radius: 5px; border-top-right-radius: 5px; border-bottom-right-radius: 5px; 
												border-bottom-left-radius: 5px;">+</span>
											</td>
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