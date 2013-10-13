<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<title>Vente de v&eacute;los en ligne</title>
<body>
	<%@include file="commun/titre.jsp"%>
	<%@include file="commun/stock.jsp"%>
	<p>
		<a href="/sdtouch/?page.page=${pagination.number}&page.size=2">&lt;&lt;</a>
		<a href="/sdtouch/?page.page=${(pagination.number + 1 >= pagination.totalPages) ? pagination.totalPages : pagination.number + 2}&page.size=2">&gt;&gt;</a>
	</p>
	<%@include file="commun/lien_ajout_velo.jsp"%>
</body>
</html>