technologies utilisées : 

Spring-boot /JPA Hibernate /H2 DATABASE ( In memory DB)/ Tomcat / JAVA 8


Pour executer le projet il faut simplement executer la class BellApplication.java
Pour tester le service il faut installer PostMan ( extension de chrome)


Comment valider les features realisés dans ce micro-service

Premierement : 
Executer la classe BellApplication.java, il va lancer tomcat embedded dans spring boot
Lancer postman ( via Google Chrome)



1-  Voir le catalogue

Faire un GET - localhost:8080/catalogue



2-  Voir un produit particulier

Faire un GET - localhost:8080/produit/1 ou localhost:8080/produit/2
J'ai inséré dans la bd H2 uniquement 2 produits (en l'occurence, des livres)
Vous pouvez ajouter autant de livre que vous désirez dans le fichier data.sql



3- Valider le shopping-cart au debut

Faire un GET sur l'adresse suivante : localhost:8080/shopping-cart
Il va vous retourner le resultat du panier ( null tant qu'on a rien ajouter)



4- Ajouter un produit dans le panier

Faire un PUT sur l'adresse suivante : localhost:8080/shopping-cart/1 ou localhost:8080/shopping-cart/2
Il faut lui donner l'ID du livre que vous desirez ajouter
Il va vous retourner le code statut 200 (ok) s'il a bien fait l'ajout
Vous pouvez ajouter plusieurs fois le meme produit


5- Supprimer un produit du panier
Faire un DELETE sur l'adresse suivante : localhost:8080/shopping-cart/1 ou localhost:8080/shopping-cart/2
Il faut lui donner l'ID du livre que vous desirez supprimer
Il va vous retourner le code statut 200 (ok) s'il a bien supprimé
S'il y a plusieurs fois le meme element dans le panier, il va supprimer le premier qu'il trouve dans le panier et s'arreter.

Vous pouvez toujours consulter le panier pour voir ce qu'il reste dedans.
Vous pouvez supprimer un objet qui n'existe pas dans le panier, l'application va juste rien faire et retouner le code 200 (ok)
Même chose pour l'ajout d'un produit qui n'existe pas, aucune erreur ne sera lancé .. 

Le moins d'information communiqué a l'usager, le mieux c'est pour contrer le piratage.


Merci encore,

Christophe De boeck.