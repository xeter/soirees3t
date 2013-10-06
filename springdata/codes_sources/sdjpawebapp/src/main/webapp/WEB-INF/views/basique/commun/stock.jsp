<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:choose>
	<c:when test="${empty velosTrouves}">
		<p>Pas de v&eacute;los en stock !</p>
	</c:when>
	<c:otherwise>
		<p>V&eacute;los en stock :</p>
		<c:forEach var="veloTrouve" items="${velosTrouves}">
			<p><a href="/welcome/voir/${veloTrouve.id}">Voir le modele ${veloTrouve.modele}</a></p>
		</c:forEach>
	</c:otherwise>
</c:choose>
