<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<title>Vente de v&eacute;los en ligne</title>
<body>
	<%@include file="commun/titre.jsp"%>
	<%@include file="commun/stock.jsp"%>
	<p><a href="/welcome/${pagePrec}/${pageSize}">&lt;&lt;</a><a href="/welcome/${pageSuiv}/${pageSize}">&gt;&gt;</a></p>
	<%@include file="commun/lien_ajout_velo.jsp"%>
</body>
</html>