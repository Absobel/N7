# Rapport du projet MiniShell

## Sommaire

- [Rapport du projet MiniShell](#rapport-du-projet-minishell)
  - [Sommaire](#sommaire)
  - [Architecture de l'application](#architecture-de-lapplication)
  - [Choix de conception et spécificités](#choix-de-conception-et-spécificités)
    - [Gestion des jobs](#gestion-des-jobs)
    - [Gestion des commandes internes](#gestion-des-commandes-internes)
    - [Validité des commandes](#validité-des-commandes)
  - [Problèmes rencontrés](#problèmes-rencontrés)
    - [Signaux durant readcmd](#signaux-durant-readcmd)
    - [Crashs](#crashs)
    - [Nommage des jobs](#nommage-des-jobs)
  - [Tests](#tests)
    - [Tester une commande simple](#tester-une-commande-simple)
    - [Tester une commande avec des arguments](#tester-une-commande-avec-des-arguments)
    - [Tester une commande qui change l'état du shell](#tester-une-commande-qui-change-létat-du-shell)
    - [Tester le comportement de la commande `exit`](#tester-le-comportement-de-la-commande-exit)
    - [Tester une commande en tâche de fond](#tester-une-commande-en-tâche-de-fond)
    - [Tester les redirections en écrivant le contenu d'un répertoire dans un fichier](#tester-les-redirections-en-écrivant-le-contenu-dun-répertoire-dans-un-fichier)
    - [Tester les redirections en lisant le contenu d'un fichier](#tester-les-redirections-en-lisant-le-contenu-dun-fichier)
    - [Tester les tubes simples](#tester-les-tubes-simples)
    - [Tester les pipelines](#tester-les-pipelines)
    - [Tester les commandes internes `lj``sj``bg``fg`](#tester-les-commandes-internes-ljsjbgfg)


<br />
## Architecture de l'application

J'ai séparé mon code en plusieurs modules (en plus du readcmd.c fourni) :
- jobs.h/c : contient les fonctions relatives à la gestion des jobs
- utils.h/c : contient les fonctions utilitaires
- minishell.h/c : contient le main et les fonctions relatives à l'interprétation des commandes.


<br />
## Choix de conception et spécificités

### Gestion des jobs

J'ai utilisé pour cela un array de jobs au lieu d'une liste chaînée car, bien que cela implique un nombre maximal de jobs, cela est aussi le cas dans une distribution classique. Le nombre peut être trouvé dans le fichier `/proc/sys/kernel/pid_max` (4194304 sur ma machine). De plus, cela permet de simplifier la gestion des jobs et est moins propice aux erreurs.

De plus, j'ai choisi de représenter les jobs par une structure contenant les informations suivantes:
- pid: le pid du processus
- state : l'état du processus (ACTIF, SUSPENDU, TERMINE)
- cmd : la commande associée au processus

Dans mon implémentation, l'état TERMINE signifie que le processus n'existe effectivement plus et l'entrée dans le tableau peut être réutilisée. J'initialise d'ailleurs le tableau avec des jobs ayant un pid de -1 et un état TERMINE.

### Gestion des commandes internes

J'ai choisi de séparer les commandes internes en commandes utilisables avec des pipes et celles qui ne le sont pas. La séparation est telle qui suit :
- Commandes utilisables avec des pipes : lj
- Commandes non utilisables avec des pipes : exit, cd, sj, bg, fg

J'ai choisi de faire en sorte que cd, exit, bg et fg ne fonctionnent pas avec des pipes après essais sur bash. J'ai également décidé que sj ne fonctionnerait pas avec des pipes car cela n'aurait pas d'utilité dans tous les cas.

### Validité des commandes

La fonction access permet de vérifier si un fichier existe et si on a les droits de l'exécuter. Cependant, si l'on veut tester si les commandes sont valides, il faut récupérer leur chemin. J'ai donc décidé d'utiliser cette fonction dans une boucle qui itère sur la variable PATH. Cela permet de tester si les commandes sont valides sans avoir à utiliser execvp. Il faut aussi prendre en compte l'exécution de fichiers en ajoutant les cas `./` et `../`. De plus, j'ai décidé que si la commande contenait un `/`, elle serait considérée comme valide et dans le cas d'un fichier invalide le message d'erreur serait affiché par le shell. Cela pourrait mener à des problèmes de sécurité mais je n'ai pas trouvé de solution pour y remédier. 


<br />
## Problèmes rencontrés

### Signaux durant readcmd

J'ai eu des problèmes avec les signaux durant la lecture de la commande. En effet, si un signal est reçu durant la lecture, readcmd renvoie `cmd = NULL`. Or, Ctrl+D (EOF) qui doit arrêter le minishell fait aussi que readcmd renvoie `cmd = NULL`. Par conséquent, j'ai décidé d'ignorer complètement SIGINT et SIGTSTP durant la lecture de la commande.

### Crashs

Lorsque je lance l'éditeur de texte helix, puis appuie sur Ctrl+Z, le programme plante. Cependant, lorsque je réalise la même action sur vi, le programme ne plante pas. J'ai décidé de ne pas gérer ce cas car c'est un cas très spécifique avec un certain programme. De même pour la commande `sl` (qui affiche un train qui traverse l'écran pour ceux qui écrivent trop vite et tapent `sl` au lieu de `ls`) qui plante après un Ctrl+Z et je ne sais pas pourquoi.

### Nommage des jobs

J'avais décidé au départ de seulement nommer le job par la version concaténée de `cmd->seq[0]`. Hors lorsque j'ai ajouté les pipes, cela à fait que chaque job avait le nom de la première commande. Un petit changement (que j'ai fait après la date du rendu) a permis de corriger cela.

<br />
## Tests

### Tester une commande simple

```
ls
```

### Tester une commande avec des arguments

```
ls -l
```

### Tester une commande qui change l'état du shell

```
cd /
```

### Tester le comportement de la commande `exit`

```
exit
```

### Tester une commande en tâche de fond

```
sleep 10 &
```

### Tester les redirections en écrivant le contenu d'un répertoire dans un fichier

```
ls > file.txt
```

### Tester les redirections en lisant le contenu d'un fichier

```
cat < file.txt
```

### Tester les tubes simples

```
ls | wc -l
```

### Tester les pipelines

```
cat file.txt | grep "test" | wc -l
```

### Tester les commandes internes `lj``sj``bg``fg`

```
lj
sleep 30 &
lj
sj [id]
lj
bg [id]
lj
fg [id]
```