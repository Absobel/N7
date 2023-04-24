with Ada.Text_IO;              use Ada.Text_IO;
with exceptions;               use exceptions;
with Ada.Text_IO.Unbounded_IO; use Ada.Text_IO.Unbounded_IO;    

package body Cache_LL is

    procedure Initialiser (Cache : in out T_Cache; Taille_Max : Integer) is
    begin
        Initialiser(Cache.Liste);
        Cache.Taille_Max := Taille_Max;
        Cache.Nb_Appels := 0;
        Cache.Nb_Defauts := 0;
    end;

    procedure Afficher_Stat (Cache : in T_Cache) is
        Type T_Taux is delta 0.01 range 0.0 .. 100.0;

        package Taux_IO is new Ada.Text_IO.Fixed_IO(T_Taux);
        use Taux_IO;

        Taux_Defauts : T_Taux;
    begin
        if Cache.Taille_Max /= 0 then
            Put_Line("Nombre d'appels : " & Integer'Image(Cache.Nb_Appels));
            Put_Line("Nombre de défauts : " & Integer'Image(Cache.Nb_Defauts));
            if Cache.Nb_Appels = 0 then
                Taux_Defauts := 0.0;
            else
                Taux_Defauts := T_Taux(Float(Cache.Nb_Defauts)*100.0 / Float(Cache.Nb_Appels));
            end if;
            Put("Taux de défauts de cache : ");
            Put(Taux_Defauts, 1);
            Put_Line(" %");
        else
            Put_Line("Cache désactivé.");
        end if;

    end;


    procedure Afficher (Cache : in T_Cache; Numero_Ligne: Integer) is

        procedure Afficher_Liste (Cle: T_AdresseIP; Donnee : T_Cellule) is
        begin
            AfficherAdresseIP(Cle);
            AfficherAdresseIP(Donnee.Masque);
            Put(Donnee.DestInterface);
            New_Line;
        end Afficher_Liste;

        procedure Afficher_Cache_Liste is new Pour_Chaque(Traiter => Afficher_Liste);

    begin
        Put_Line("cache : (ligne" & Integer'Image(Numero_Ligne) & ")");
        if Cache.Taille_Max /= 0 then
            if Est_Vide(Cache.Liste) then
                Put_Line("Cache vide");
            else
                Afficher_Cache_Liste(Cache.Liste);
            end if;
        else
            Put_Line("Cache désactivé.");
        end if;
    end;


    procedure Lire (Cache : in out T_Cache; Destination : in T_AdresseIP; Politique : T_Politique; DestInterface : out Unbounded_String; A_Trouve : out Boolean) is
        Masque : T_AdresseIP;
        Masque_le_plus_long: T_AdresseIP;
        Dest_Accedee: T_AdresseIP;
        Donnee_Accedee: T_Cellule;

        procedure EstAdresseCorrecte(Cle: in T_AdresseIP; Donnee: in T_Cellule) is
        begin
            Masque := Donnee.Masque;
            if (Destination and Masque) = (Cle and Masque) and Masque > Masque_le_plus_long then
                DestInterface := Donnee.DestInterface;
                Masque_le_plus_long := Masque;
                A_Trouve := True;
                Dest_Accedee := Cle;
                Donnee_Accedee := Donnee;
            end if;
        end;

        procedure TrouverAdresse is new Pour_Chaque(Traiter => EstAdresseCorrecte);
    begin
        Cache.Nb_Appels := Cache.Nb_Appels + 1;
        A_Trouve := False;
        TrouverAdresse(Cache.Liste);
        if A_Trouve then
            if Politique = LRU then
                Supprimer(Cache.Liste, Dest_Accedee);
                Ajouter_Fin(Cache.Liste, Dest_Accedee, Donnee_Accedee);
            elsif Politique = FIFO then 
                null;
            elsif Politique = LFU then
                Donnee_Accedee.Nb_Appels_Adresse := Donnee_Accedee.Nb_Appels_Adresse + 1;
                Mise_A_Jour(Cache.Liste, Dest_Accedee, Donnee_Accedee);
            end if;
        end if;
    end;


    procedure Enregistrer (Cache : in out T_Cache; Destination : in T_AdresseIP; Masque: in T_AdresseIP; DestInterface : in Unbounded_String; Politique : in T_Politique) is
        Cellule : constant T_Cellule := T_Cellule'(DestInterface, Masque, 0);
        Min_Cellule : T_Cellule;
        Min : Integer;
        Dest : T_AdresseIP;
        Min_Dest : T_AdresseIP;
    begin
        Ajouter_Fin(Cache.Liste, Destination, Cellule);
        if Taille(Cache.Liste) > Cache.Taille_Max then
            if Politique = LRU or Politique = FIFO then
                Supprimer_Tete(Cache.Liste);
            elsif Politique = LFU then
                Element_Index(Cache.Liste, 0, Min_Dest, Min_Cellule);
                Min := Min_Cellule.Nb_Appels_Adresse;
                for i in 1..(Taille(Cache.Liste)-1) loop
                    Element_Index(Cache.Liste, i, Dest, Min_Cellule);
                    if Min_Cellule.Nb_Appels_Adresse < Min then
                        Min := Min_Cellule.Nb_Appels_Adresse;
                        Min_Dest := Dest;
                    end if;
                end loop;
                Supprimer(Cache.Liste, Min_Dest);
            else
                raise PolitiqueInvalide;
            end if;
        else
            null;
        end if;
    end;


    procedure Incrementer_Defauts (Cache : in out T_Cache) is
    begin
        Cache.Nb_Defauts := Cache.Nb_Defauts + 1;
    end;

    procedure Vider(Cache : in out T_Cache) is
    begin
        Vider(Cache.Liste);
    end;
    
    -- Tests

    function Taille (Cache : in T_Cache) return Integer is
    begin
        return Taille(Cache.Liste);
    end;


    function Est_Vide (Cache : in T_Cache) return Boolean is
    begin
        return Est_Vide(Cache.Liste);
    end;

    function Nb_Appels_Destination (Cache : in T_Cache; Destination : in T_AdresseIP) return Integer is
        Donnee : T_Cellule;
    begin
        if Cle_Presente(Cache.Liste, Destination) then
            Donnee := La_Donnee(Cache.Liste, Destination);
            return Donnee.Nb_Appels_Adresse;
        else
            return 0;
        end if;
    end;

end Cache_LL;