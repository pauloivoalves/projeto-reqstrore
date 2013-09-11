<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script type="text/javascript" src="js/Script.js"></script>
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
							<li><a href="#">Buscar Projetos</a></li>
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
				<div id="left"></div>
				<div id="center">
					<img src="../imagens/separador2.png">
				</div>


				<div id="right">
					<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
						Vestibulum dapibus malesuada lacus a varius. Nam tincidunt neque
						in lacus egestas rutrum sed tincidunt quam. Nullam nec tempus
						odio. Aliquam cursus tellus sed felis varius, a volutpat magna
						varius. Aliquam quis varius massa. Vestibulum fringilla mauris
						quis nunc porta ultrices non ut dui. </p>
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