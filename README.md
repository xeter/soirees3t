soirees3t
=========

Exemples pour la soirée 3T sur Spring Data chez So@t. Vous y trouverez les exemples mentionnés lors des soirées. 

Pour compiler : <code>mvn clean install</code> tout simplement.
Pour les applications web, vous pouvez lancer jetty : <code>mvn jetty:run</code>. Vous accéderez ainsi à la webapp à l'adresse localhost:8080/<nom webapp>

Pour le projet sdrestws, il faut compiler puis lancer le serveur jetty : <code>mvn clean install jetty:run</code>. Vous pourrez ensuite manipuler l'application avec curl, par exemple :
<code>curl -v http://localhost:8080</code>, 
<code>curl -H "Content-Type: application/json" -d '{"titre":"Get Lucky","id":"2"}' http://localhost:8080/chanson</code> (il faut mettre l'id parce qu'il n'est pas généré par Hibernate)
, <code>curl -v http://localhost:8080/chanson/2</code> (2 étant l'id de la chanson créée)
