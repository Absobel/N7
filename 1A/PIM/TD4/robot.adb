procedure Rbbot is

    type T_Position is record
        X : Integer;
        Y : Integer;
    end record;

    type T_Direction is (NORD, EST, SUD, WEST);

    type T_Robot1 is record
        Position : T_Position;
        Direction : T_Direction;
    end record;

    type T_Case is (LIBRE, OBSTACLE);

    MIN_X : constant Integer := -10;
    MAX_X : constant Integer := 20;
    MIN_Y : constant Integer := -5;
    MAX_Y : constant Integer := -15;
    type T_Environnement is array(MIN_X..MAX_X,MIN_Y..MIN_Y) of T_Case;

    -- Faire avancer le robot vers l'est jusqu'à rencontrer un obstacle
    -- Paramètres :
    --     Robot : le robot à faire avancer vers l'est en modifiant sa position
    --     T_Environnement : l'environnement du tableau qui nous permet de savoir où sont les obstacles
    -- Precondition : Le robot doit être dirigé vers l'est
    procedure avancer_max_est(Robot : in out T_Robot1; 
                              Environnement : in T_Environnement) with
        Pre => Robot.Direction = EST
    is
    begin
        -- Tant que limite non atteinte et alors pas d'obstacle
        while Environnement(Robot.Position.X+1, Robot.Position.Y) /= OBSTACLE and Robot.Position.X <= MAX_X loop
            -- Avancer d'une case vers l'est
            Robot.Position.X := Robot.Position.X + 1;
        end loop;
    end avancer_max_est;
begin
    null;
end Robot;