#include <stdio.h>

typedef struct {
    int x;
    int y;
} Coord;

Coord coord_from_string(const char *str) {
    Coord coord = {0, 0};
    sscanf(str, "%d,%d", &coord.x, &coord.y);
    return coord;
}



typedef struct {
    Coord size;
    char **grid; // [y][x]
} World;

World world_from_string(const char *str, Coord size){
    World world = {
        .size = size,
        .grid = malloc(size.y * sizeof(char*))
    };

    const char *ptr = str;
    for (int y = 0; y < size.y; y++){
        world.grid[y] = malloc(size.x * sizeof(char));
        for (int x = 0; x < size.x; x++){
            char c = *(ptr+(size.x+1)*y+x);
            if (c == 'E'){
                c = ' ';
            }
            world.grid[y][x] = c;
        }
    }
    return world;
}

World world_from_file(const char *path) {
    FILE *file = fopen(path, "r");

    // first line is the size
    char *line = NULL;
    size_t len; // ignored
    getline(&line, &len, file);
    Coord size = coord_from_string(line);

    long pos = ftell(file);
    fseek(file, 0, SEEK_END);
    long left_size = ftell(file) - pos;
    fseek(file, pos, SEEK_SET);

    char* world_str = malloc(left_size);
    world_str[0] = '\0';
    while (getline(&line, &len, file) != -1){
        strcat(world_str, line);
    }

    World world = world_from_string(world_str, size);

    free(line);
    free(world_str);
    fclose(file);

    return world;
}

char* world_to_string(World *world){
    char *str = malloc((world->size.x + 1) * world->size.y + 1);
    char *ptr = str;
    for (int y = 0; y < world->size.y; y++){
        for (int x = 0; x < world->size.x; x++){
            *ptr++ = world->grid[y][x];
        }
        *ptr++ = '\n';
    }
    *ptr = '\0';
    return str;
}

void world_free(World *world){
    for (int y = 0; y < world->size.y; y++){
        free(world->grid[y]);
    }
    free(world->grid);
}

Coord search(World *world, char c){
    for (int y = 0; y < world->size.y; y++){
        for (int x = 0; x < world->size.x; x++){
            if (world->grid[y][x] == c){
                return (Coord){x, y};
            }
        }
    }
    return (Coord){-1, -1};
}

char get(World *world, Coord coord){
    return world->grid[coord.y][coord.x];
}

void set(World *world, Coord coord, char c){
    world->grid[coord.y][coord.x] = c;
}



typedef struct {
    char *key;
    char *value;
} Pair;

typedef struct {
    Pair *pairs;
    size_t size;
    size_t capacity;
} HashMap;

HashMap hashmap_new(){
    return (HashMap){NULL, 0, 0};
}

void hashmap_free(HashMap *map){
    for (size_t i = 0; i < map->size; i++){
        free(map->pairs[i].key);
        free(map->pairs[i].value);
    }
    free(map->pairs);
}

void hashmap_set(HashMap *map, const char *key, const char *value){
    for (size_t i = 0; i < map->size; i++){
        if (strcmp(map->pairs[i].key, key) == 0){
            free(map->pairs[i].value);
            map->pairs[i].value = strdup(value);
            return;
        }
    }
    if (map->size == map->capacity){
        map->capacity = map->capacity == 0 ? 1 : map->capacity * 2;
        map->pairs = realloc(map->pairs, map->capacity * sizeof(Pair));
    }
    map->pairs[map->size++] = (Pair){strdup(key), strdup(value)};
}

const char* hashmap_get(HashMap *map, const char *key){
    for (size_t i = 0; i < map->size; i++){
        if (strcmp(map->pairs[i].key, key) == 0){
            return map->pairs[i].value;
        }
    }
    return NULL;
}