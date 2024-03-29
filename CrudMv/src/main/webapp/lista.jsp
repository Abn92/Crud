<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CRUD MV - Listagem de Colaboradores</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<body>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container-fluid">
			<a class="navbar-brand" href="index.html">Gerenciar Caf�</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="index.html">Cadastro</a></li>

					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="lista.jsp">Listagem</a></li>
				</ul>
				<form class="d-flex" action="InsertSelect" method="GET">
					<input name="pesquisa" class="form-control me-2" type="search"
						placeholder="Digite um nome ou CPF" aria-label="Search">
					<button class="btn btn-outline-success" type="submit">Buscar</button>
				</form>
			</div>
		</div>
	</nav>

	<div class="container">
		<div class="row">
			<div class="col md-2">
				<hr>
				<h3>Listagem de Colaboradores</h3>
				<hr>
				<table class="table">
					<thead>
						<tr>
							<th>Id</th>
							<th>Nome</th>
							<th>CPF</th>
							<th>Alimento</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${listaColaboradores}" var="colaborador">
							<tr>
								<td>${colaborador.id }
								<td>${colaborador.nome }
								<td>${colaborador.cpf }
								<td>${colaborador.alimento }
								<td><a href="colabDestroy?colaboradorId=${colaborador.id}">Deletar</a>
									<a href="colabUpdate?colaboradorId=${colaborador.id}">Alterar</a></td>
							</tr>

						</c:forEach>
					</tbody>

				</table>
				<h5 style="text-align: center;">
					<a href="index.html"> Voltar para o cadastro de Colaboradores </a>
				</h5>


			</div>
		</div>
	</div>
</body>
</html>