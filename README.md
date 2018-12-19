# PROP - Generador d’horaris

#### Segon Lliurament: divendres 21 de desembre (lliuraments interactius: a partir del 8 de gener)
##### Entregar en paper dilluns:
- Manual usuari
- Diagrames uml
- Relacio de les classes
- Descripció de l’algorisme i estructures de dades

## TO DO
- [x] Comprovació de totes les restriccions
- [ ] Falta poder generar horari de 2 plans estudis usant les mateixes aules!
- [x] BT with SubGrup. Sino es pot ferho amb {10, 11, 12, 20, 21, 22}
- [ ] Capacitats grups -> millorar divisio
- [x] Classe Restriccions 
- [ ] El BT es infinit si no pot assignar un grup (ja que no li pot decrementar les horesTeo/Lab i la crida es infinita)
- [ ] Importar des de fitxer
- [ ] Guardar tot el que modifiquem
- [ ] Implementar setNumGrups

- [ ] Manual d’usuari de l’aplicació -> ha d’explicar com funcionen les funcionalitats (entrar a l’aplicatiu, generar un horari automàticament, modificar-lo, com es crea assignatura, com es borra assignatura,...) -> fer pantallazos de les vistes amb indicacions de com fer les coses. (índex i ben fet)
- [ ] Impressió dels tres diagrames UML (domini, vistes + controladors presentació, capa dades + controladors dades) separats
- [ ] Breu descripció de l’algorisme i estructura de dades utilitzats (tornar a fer bé, ja que el nostre era cutre).
- [ ] Relació de les classes implementades per cada grup -> explicar explícitament a un document
- [ ] Codi de totes les classes, executables del programa amb jocs de proves.

## Jocs de proves: 
#### per cada d’una de les funcionalitats existents s’ha de provar des de l’aplicatiu fent un joc d’assaig.

S’ha de fer un conjunt de proves per cada funcionalitat: funcionalitat -> conjunt de proves.
Proves de casos extrems i de casos intermitjos.
Explicació dels casos -> Aquest cas d’ús seria provar aquesta funcionalitat amb els paràmetres tal i tal. Coses d’aquest estil
Exemple: Volem provar la generació de l’horari sense cap assignatura
Resultat esperat
Execució: s’ha executat el cas i es demostra amb un pantallasso de la finestra amb els paràmetres entrats i la finestreta dient no es pot generar l’horari per què tal i qual.
Finalment una línia dient si l’execució ha donat com a resultat el resultat que s’esperava o no i en cas negatiu hem de justificar el perquè.

Opcional: Carpeta de documentació generada per javadoc
