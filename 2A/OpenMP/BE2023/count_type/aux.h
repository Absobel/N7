long usecs ();

typedef struct
{
  int id;
} data_t;

void init_data(data_t *d, int ndata, int ntype);
void mysleep(long t);
unsigned int analyze(data_t data);
void check(unsigned int *typecounts, int ntype);
