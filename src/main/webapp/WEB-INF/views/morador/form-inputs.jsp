<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="form-group">
	<label for="nome">nome</label>
	<div class="input-group">
		<span class="input-group-addon"><i
			class="glyphicon glyphicon-unchecked"></i></span>
		<form:input path='nome' type='text' />
		<form:errors path='nome' />

	</div>
</div>
<div class="form-group">
	<label for="apartamento">Apartamento</label>
	<div class="input-group">
		<span class="input-group-addon"><i
			class="glyphicon glyphicon-unchecked"></i></span>
		<form:input path='apartamento' type='text' />
		<form:errors path='apartamento' />

	</div>
</div>

<div class="form-group">
	<label for="apelido">Como deseja ser chamado</label>
	<div class="input-group">
		<span class="input-group-addon"><i
			class="glyphicon glyphicon-unchecked"></i></span>
		<form:input path='apelido' type='text' />
		<form:errors path='apelido' />
	</div>
</div>

<div class="form-group">
	<label for="rfid">rfid</label>
	<div class="input-group">
		<span class="input-group-addon"><i
			class="glyphicon glyphicon-unchecked"></i></span>
		<form:input path='rfid' type='text' />
		<form:errors path='rfid' />
	</div>
</div>
