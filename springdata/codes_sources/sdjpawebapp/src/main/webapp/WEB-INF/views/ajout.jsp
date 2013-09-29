<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
	<title>Vente de v&eacute;los en ligne</title>
<body>
	<%@include file="/WEB-INF/views/commun/titre.jsp"%>
	<p>
		<form:form method="post" modelAttribute="velo" action="/welcome/sauv">
			Mod&egrave;le : <form:input id="id_modele" path="modele" type="text"/>
			<input type="submit" value="Ajouter"/>
		</form:form>
	</p>
	<p>${message}</p>
	<%@include file="/WEB-INF/views/commun/stock.jsp"%>
	<%@include file="/WEB-INF/views/commun/lien_accueil.jsp"%>
</body>
</html>