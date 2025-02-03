# Presentation

world : the agent that simulates the world. It receives the actions of the players and updates the map accordingly.
ihm : the interface with the player who can click on buttons to move the player on the map.

The layout of the map is taken from `assets/level1`. There can be as many players as there are 'S' in the map (S = Starting Location).

# Known issues

- I'm only printing the map on the whiteboard (and it's not even monospace)
- I've started the project this afternoon so I've not done as much as I wanted to but it was fun

# Prerequisites

You need to have GTK4 installed to run the ihm.

# How to run

run the following commands :
```bash
./run.sh world
./run.sh ihm joueur
./run.sh ihm joueur2
```

to run just from binaries then :
```bash
./runbin.sh world
./runbin.sh ihm joueur
./runbin.sh ihm joueur2
```

The port is set to 5670 and it takes the first available wifi interface but feel free to change that by running the binaries yourself.
"world" has to be run first though.