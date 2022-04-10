<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CRUD MV - Atualizar Colaborador</title>
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
			<a class="navbar-brand" href="index.html">Gerenciar Café</a>
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
						aria-current="page" href="InsertSelect">Listagem</a></li>
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
				<h3>Atualizar Colaborador</h3>
				<hr>
				<form action="colabUpdate" method="POST">
					<label for="colaboradorId" class="form-label">Id Editado:</label> <input
						id="colaboradorId" name="colaboradorId" value="${colaborador.id}"
						type="number" readonly>
					<div class="m-4">
						<div class="row g-3">
							<div class="col-6">
								<label for="nome" class="form-label">Nome</label> <input
									value="${colaborador.nome}" maxlength="40"
									onkeypress="return event.charCode == 32 || event.charCode >= 65  && event.charCode <= 90 || event.charCode >= 97  && event.charCode <= 122 "
									name="nome" type="text" class="form-control" placeholder="Nome">
							</div>
							<div class="col-2">
								<label for="cpf" class="form-label">CPF</label> <input
									maxlength="11" value="${colaborador.cpf}"
									onkeypress="return event.charCode >= 48 && event.charCode <= 57"
									name="cpf" type="text" class="form-control" placeholder="CPF">
							</div>
							<div class="col-2">
								<label for="alimento" class="form-label">Alimento</label> <input
									id="alimento" maxlength="30" value="${colaborador.alimento}"
									onkeypress="return event.charCode == 32 || event.charCode >= 65  && event.charCode <= 90 || event.charCode >= 97  && event.charCode <= 122 "
									name="alimento" type="text" class="form-control"
									placeholder="Alimento">
							</div>

							<div class="lg-2" style="text-align: center;">
								<button type="reset" class="btn btn-danger">Limpar</button>
								<button type="submit" class="btn btn-primary">Alterar</button>
							</div>
						</div>
					</div>

				</form>
			</div>
		</div>
	</div>
</body>
</html>