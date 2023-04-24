with Cache_LL;                 use Cache_LL;
with Ada.Text_IO;              use Ada.Text_IO;
with Ada.Strings.Unbounded;    use Ada.Strings.Unbounded;
with Ada.Text_IO.Unbounded_IO; use Ada.Text_IO.Unbounded_IO;

procedure test_Cache_LL is
    Cache : T_Cache;
    DestInterface : Unbounded_String;
    A_Trouve: Boolean;

begin
    Initialiser(Cache, 2);
    pragma assert (Taille(Cache) = 0);
    Put_Line("Attendu après initialisation :");
    Put_Line("cache : (ligne 18)");
    Put_Line("Cache vide");
    Put_Line("Obtenu :");
    Afficher(Cache, 18); New_Line;
    Put_Line("Initialisation : OK");
    
    New_Line;
    Put_Line("### Test LRU (taille max : 2) et fonctions de base ###"); New_Line;

    Enregistrer(Cache, 0, 4294967295, To_Unbounded_String("eth0"), LRU);
    -- 0.0.0.0 : eth0
    Put_Line("Attendu après ajour de 0.0.0.0 :");
    Put_Line("cache : (ligne 30)");
    Put_Line("0.0.0.0 255.255.255.255 eth0");
    Put_Line("Obtenu :");
    Afficher(Cache, 30); New_Line;

    Enregistrer(Cache, 1, 4294967295, To_Unbounded_String("eth1"), LRU);
    -- 0.0.0.0 : eth0
    -- 0.0.0.1 : eth1
    Put_Line("Attendu après ajour de 0.0.0.1 :");
    Put_Line("cache : (ligne 40)");
    Put_Line("0.0.0.0 255.255.255.255 eth0");
    Put_Line("0.0.0.1 255.255.255.255 eth1");
    Put_Line("Obtenu :");
    Afficher(Cache, 40); New_Line;
    Put_Line("Enregistrer : OK"); New_Line;

    Lire(Cache, 0, LRU, DestInterface, A_Trouve);
    -- 0.0.0.1 : eth1
    -- 0.0.0.0 : eth0
    pragma assert(A_Trouve);
    Put_Line("Attendu après lecture de 0.0.0.0 : eth0");
    Put("Obtenu : "); Put_Line(DestInterface); New_Line;

    Lire(Cache, 3, LRU, DestInterface, A_Trouve);
    pragma assert(not A_Trouve);

    Put_Line("Attendu après lecture :");
    Put_Line("cache : (ligne 58)");
    Put_Line("0.0.0.1 255.255.255.255 eth1");
    Put_Line("0.0.0.0 255.255.255.255 eth0");
    Put_Line("Obtenu :");
    Afficher(Cache, 58); New_Line;
    Put_Line("Lire : OK"); New_Line;

    Enregistrer(Cache, 2, 4294967295, To_Unbounded_String("eth2"), LRU);
    -- 0.0.0.0 : eth0
    -- 0.0.0.2 : eth2
    Put_Line("Attendu après ajout de 0.0.0.2 alors que cache plein :");
    Put_Line("cache : (ligne 69)");
    Put_Line("0.0.0.0 255.255.255.255 eth0");
    Put_Line("0.0.0.2 255.255.255.255 eth2");
    Put_Line("Obtenu :");
    Afficher(Cache, 69); New_Line;

    Incrementer_Defauts(Cache);
    Put_Line("Attendu affichange statistiques (après ajouts de defauts de cache artificiellement) :");
    Put_Line("Nombre d'appels : 2");
    Put_Line("Nombre de défauts de cache : 1");
    Put_Line("Taux de défauts de cache : 0.5");
    Put_Line("Obtenu :");
    Afficher_Stat(Cache); New_Line;
    Put_Line("Statistiques : OK"); New_Line;

    Put_Line("Comportement LRU : OK"); New_Line;
    Vider(Cache);
    Put_Line("### Test FIFO (taille max : 3) ###"); New_Line;

    Initialiser(Cache, 3);
    Enregistrer(Cache, 0, 4294967295, To_Unbounded_String("eth0"), FIFO);
    Enregistrer(Cache, 1, 4294967295, To_Unbounded_String("eth1"), FIFO);
    Enregistrer(Cache, 2, 4294967295, To_Unbounded_String("eth2"), FIFO);
    -- 0.0.0.0 : eth0
    -- 0.0.0.1 : eth1
    -- 0.0.0.2 : eth2
    Put_Line("Cache :");
    Afficher(Cache, 92); New_Line;

    Lire(Cache, 0, FIFO, DestInterface, A_Trouve);
    -- Aucun changement
    pragma assert(A_Trouve);
    Put_Line("Attendu après lecture : aucun changement");
    Put_Line("Obtenu :");
    Afficher(Cache, 99); New_Line;

    Enregistrer(Cache, 3, 4294967295, To_Unbounded_String("eth3"), FIFO);
    -- 0.0.0.1 : eth1
    -- 0.0.0.2 : eth2
    -- 0.0.0.3 : eth3
    Put_Line("Attendu après ajout de 0.0.0.3 alors que cache plein :");
    Put_Line("cache : (ligne 111)");
    Put_Line("0.0.0.1 255.255.255.255 eth1");
    Put_Line("0.0.0.2 255.255.255.255 eth2");
    Put_Line("0.0.0.3 255.255.255.255 eth3");
    Put_Line("Obtenu :");
    Afficher(Cache, 111); New_Line;

    Put_Line("Comportement FIFO : OK"); New_Line;
    Vider(Cache);
    Put_Line("### Test LFU (taille max : 3) ###"); New_Line;

    Initialiser(Cache, 3);
    Enregistrer(Cache, 0, 4294967295, To_Unbounded_String("eth0"), LFU);
    Enregistrer(Cache, 1, 4294967295, To_Unbounded_String("eth1"), LFU);
    Enregistrer(Cache, 2, 4294967295, To_Unbounded_String("eth2"), LFU);
    -- 0.0.0.0 : eth0 - 0
    -- 0.0.0.1 : eth1 - 0
    -- 0.0.0.2 : eth2 - 0
    Put_Line("Cache :");
    Afficher(Cache, -1); New_Line;

    Lire(Cache, 0, LFU, DestInterface, A_Trouve);
    Lire(Cache, 0, LFU, DestInterface, A_Trouve);
    Lire(Cache, 2, LFU, DestInterface, A_Trouve);
    -- 0.0.0.0 : eth0 - 2
    -- 0.0.0.1 : eth1 - 0
    -- 0.0.0.2 : eth2 - 1
    Put_Line("Attendu après deux lecture de 0.0.0.0, une lecture de 0.0.0.2 :");
    Put_Line("cache : (ligne 139)");
    Put_Line("0.0.0.0 255.255.255.255 eth0");
    Put_Line("0.0.0.1 255.255.255.255 eth1");
    Put_Line("0.0.0.2 255.255.255.255 eth2");
    Put_Line("Obtenu :");
    Afficher(Cache, 139); New_Line;

    Enregistrer(Cache, 3, 4294967295, To_Unbounded_String("eth3"), LFU);
    -- 0.0.0.0 : eth0 - 2
    -- 0.0.0.2 : eth2 - 0
    -- 0.0.0.3 : eth3 - 0

    Put_Line("Attendu après ajout de 0.0.0.3 alors que cache plein :");
    Put_Line("cache : (ligne 152)");
    Put_Line("0.0.0.0 255.255.255.255 eth0");
    Put_Line("0.0.0.2 255.255.255.255 eth2");
    Put_Line("0.0.0.3 255.255.255.255 eth3");
    Put_Line("Obtenu :");
    Afficher(Cache, 152); New_Line;

    Put_Line("Comportement LFU : OK"); New_Line;

    Vider(Cache);

    Put_Line("############# Fin des tests ! #############");
end test_Cache_LL;