//
//  main.c
//  world
//  Created by Ingenuity i/o on 2025/02/03
//
// no description
//

#ifdef _WIN32
#ifndef WIN32_LEAN_AND_MEAN
#define WIN32_LEAN_AND_MEAN
#endif
#define NOMINMAX
#include <windows.h>
#include <winsock2.h>
#endif

#include <ingescape/ingescape.h>
#include "utils.c"

World world;
HashMap players;

void outputWorld(World *world){
    char *str = world_to_string(world);
    igs_output_set_string("state", str);
    igs_service_call("Whiteboard", "clear", NULL, NULL);
    igs_service_arg_t *list = NULL;
    igs_service_args_add_string(&list, str);
    igs_service_args_add_int(&list, 400);
    igs_service_args_add_int(&list, 400);
    igs_service_args_add_string(&list, "white");
    igs_service_call("Whiteboard", "addText", &list, NULL);
    free(str);
}

void myIOCallback(igs_io_type_t ioType, const char* name, igs_io_value_type_t valueType,
                   void* value, size_t valueSize, void* myData){
    igs_info("%s changed", name);

    //add code here if needed

}

void myServiceFunction(const char *callerAgentName, const char *callerAgentUUID,
                       const char *serviceName, igs_service_arg_t *firstArgument, size_t nbArgs,
                       const char *token, void* myData){
    igs_info("%s(%s) called %s", callerAgentName, callerAgentUUID, serviceName);

    // TODO : respond to the reply "actionResult" with a boolean
    if (strcmp(serviceName, "connect") == 0) {
        Coord start = search(&world, 'S');
        if (start.x == -1){
            igs_error("No starting position");
        }
        else {
            char player = 'a' + players.size;
            hashmap_set(&players, callerAgentUUID, &player);
            set(&world, start, player);
            outputWorld(&world);
        } 
    }
    else if (strcmp(serviceName, "move") == 0) {
        // move the caller if in there
        const char* player = hashmap_get(&players, callerAgentUUID);
        Coord start = search(&world, *player);
        char *dir = firstArgument->c;
        Coord next = start;
        if (strcmp(dir, "up") == 0){
            next.y--;
        }
        else if (strcmp(dir, "down") == 0){
            next.y++;
        }
        else if (strcmp(dir, "left") == 0){
            next.x--;
        }
        else if (strcmp(dir, "right") == 0){
            next.x++;
        }
        if (next.x >= 0 && next.x < world.size.x && next.y >= 0 && next.y < world.size.y && get(&world, next) == ' '){
            set(&world, start, ' ');
            set(&world, next, *player);
        }
        outputWorld(&world);
    }
    else {
        igs_error("Unknown service %s", serviceName);
    }
}

void real_main() {
    world = world_from_file("../assets/level1");
    players = hashmap_new();
    outputWorld(&world);
}

int main(int argc, const char * argv[]) {
    if (argc < 4){
        printf("usage: ./world agent_name network_device port\n");
        int nb = 0;
        char **devices = igs_net_devices_list(&nb);
        printf("Please restart with one of these devices as network_device argument:\n");
        for (int i = 0; i < nb; i++){
            printf(" %s\n", devices[i]);
        }
        igs_free_net_devices_list(devices, nb);
        return 0;
    }

    igs_agent_set_name(argv[1]);
    igs_log_set_console(true);
    igs_log_set_file(true, NULL);
    igs_log_set_stream(true);

    igs_definition_set_class("world");

    igs_debug("Ingescape version: %d (protocol v%d)", igs_version(), igs_protocol());

    igs_output_create("state", IGS_STRING_T, 0, 0);
    igs_output_set_detailed_type("state", "DATA::grid", "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0//EN\" \"http://www.w3.org/TR/REC-html40/strict.dtd\">\n<html><head><meta name=\"qrichtext\" content=\"1\" /><meta charset=\"utf-8\" /><style type=\"text/css\">\np, li { white-space: pre-wrap; }\nhr { height: 1px; border-width: 0; }\nli.unchecked::marker { content: \"\\2610\"; }\nli.checked::marker { content: \"\\2612\"; }\n</style></head><body style=\" font-family:'Asap'; font-size:13px; font-weight:400; font-style:normal;\">\n<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" font-size:13px;\">repr of an n*m matrix representing the layout with :</span></p>\n<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" font-size:13px;\">- ' ' = Empty</span></p>\n<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" font-size:13px;\">- '#' = wall</span></p>\n<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" font-size:13px;\">- 'S' = starting_pos</span></p></body></html>");
    igs_service_init("move", myServiceFunction, NULL);
    igs_service_arg_add("move","dir", IGS_STRING_T);
    igs_service_init("connect", myServiceFunction, NULL);
    igs_service_reply_add("connect", "actionResult");
    igs_service_reply_arg_add("connect", "actionResult", "succeded", IGS_BOOL_T);

    igs_start_with_device(argv[2], atoi(argv[3]));

    real_main();

    getchar();
    world_free(&world);
    hashmap_free(&players);

    igs_stop();
    return 0;
}

