//
//  main.c
//  ihm
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
#include <gtk/gtk.h>

#define DIRECTIONS \
    X(up) \
    X(down) \
    X(left) \
    X(right)

#define BUTTON_DEFINE(name) \
    GtkWidget *name = gtk_button_new_with_label(#name); \
    g_signal_connect(name, "clicked", G_CALLBACK(button_handler), NULL); \
    gtk_widget_set_hexpand(name, TRUE); \
    gtk_widget_set_vexpand(name, TRUE);

/////

void button_handler(GtkButton *button) {
    const char *label = gtk_button_get_label(button);
    igs_output_set_string("command", label);

    igs_service_arg_t *list = NULL;
    igs_service_args_add_string(&list, label);
    igs_service_call("world", "move", &list, NULL);
}

void activate_handler(GtkApplication *app) {
    GtkWidget *win = gtk_application_window_new(GTK_APPLICATION(app));
    gtk_window_set_title(GTK_WINDOW(win), igs_agent_name());
    gtk_window_set_default_size(GTK_WINDOW(win), 400, 300);
    gtk_window_set_resizable(GTK_WINDOW(win), FALSE);

    #define X(name) BUTTON_DEFINE(name)
    DIRECTIONS
    #undef X

    GtkWidget *grid = gtk_grid_new();
    gtk_window_set_child(GTK_WINDOW(win), grid);
    gtk_widget_set_hexpand(grid, TRUE);
    gtk_widget_set_vexpand(grid, TRUE);
    gtk_grid_attach(GTK_GRID(grid), up, 1, 0, 1, 1);
    gtk_grid_attach(GTK_GRID(grid), down, 1, 1, 1, 1);
    gtk_grid_attach(GTK_GRID(grid), left, 0, 1, 1, 1);
    gtk_grid_attach(GTK_GRID(grid), right, 2, 1, 1, 1);

    igs_service_call("world", "connect", NULL, NULL);

    gtk_window_present(GTK_WINDOW(win));
}

int real_main() {
    GtkApplication *app = gtk_application_new(NULL, G_APPLICATION_DEFAULT_FLAGS);
    
    g_signal_connect(app, "activate", G_CALLBACK(activate_handler), NULL);

    int stat = g_application_run(G_APPLICATION (app), 0, NULL);
    g_object_unref(app);
    return stat;
}

int main(int argc, const char * argv[]) {
    if (argc < 4){
        printf("usage: ./ihm agent_name network_device port\n");
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

    igs_definition_set_class("ihm");

    igs_debug("Ingescape version: %d (protocol v%d)", igs_version(), igs_protocol());

    igs_output_create("command", IGS_STRING_T, 0, 0);

    igs_start_with_device(argv[2], atoi(argv[3]));

    real_main();

    getchar();

    igs_stop();
    return 0;
}

