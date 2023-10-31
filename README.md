# PME2022-KAWKA-Robin README 



## Pour récupérer le projet 

Vous pouvez cloner le projet en allant dans un dossier de votre ordinateur, et en executant la commande :
```
git clone https://forge.iut-larochelle.fr/rkawka/pme2022-kawka-robin.git
```

Vous récupererez toute l'arborescence, il vous suffit ainsi d'ouvrir un IDE comme Intellij par exemple et d'ouvrir ce dossier. 
Les fichiers sources se trouvent dans le dossier src/main/kotlin.
Les fichiers tests se trouvent dans le dossier src/test/kotlin.



## Pour éxecuter le fichier jar

Le fichier jar associé au projet est déjà crée. Pour accéder au fichier jar, suivez ce lien:<br> https://forge.iut-larochelle.fr/rkawka/pme2022-kawka-robin/-/tree/main/PME2022-KAWKA/build/libs ,ou alors dans votre IDE, et dans le dossier **build/libs**, faire clique droit sur le fichier jar puis run. <br>Vous pouvez également passer par le terminal. Dans un terminal allez dans le dossier du jar **(build/Libs)**  puis executez le avec la fonction: 
``` 
java -jar PME2022T-1.0-SNAPSHOT.jar 
```
pour lancer l'interface en ligne de commande du logiciel.<br> Si vous n'avez pas java ou n'avez pas renseigné les variables d'environnements, suivez ce tutoriel :<br> https://www.youtube.com/watch?v=FVxKbAukRxk&ab_channel=GeekyScript.<br>
N'hésitez pas à essayer l'application via la console pour mieux comprendre son fonctionnement.

## Pour voir la documentation

Pour voir la documentation générale, suivez ce lien : https://forge.iut-larochelle.fr/rkawka/pme2022-kawka-robin/-/wikis/Documentation-g%C3%A9n%C3%A9rale.<br>
Pour aller au sommaire de la documentation, suivez celui-ci: 
https://forge.iut-larochelle.fr/rkawka/pme2022-kawka-robin/-/wikis/Sommaire


## PS :

Pour créer ce projet, je m'étais basé sur le diagramme de classe fait en cours, qui mettait les attributs des classes Person et Employee en protected. Cependant, pour la plupart de ces attributs, il m'a fallu y accéder en lecture et en réecriture, j'ai donc du réecrire mes getters et setters. Une meilleure gestion de ces attributs aurait été certainement possible en les mettant en public pour que les getters et setters soient automatiquement crées par Kotlin et car il me fallait y accéder d'en dehors de la classe de toute façon.
