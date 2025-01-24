package daemon;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.io.FileReader;

import config.Config;
import config.Project;
import interfaces.KV;

public class RunMapImpl implements RunMap {
    private int this_id;

    RunMapImpl(int this_id) {
        this.this_id = this_id;
    }

    private String getFilePath(String filename, Config config) {
        String[] desconstructed_file_path = filename.split("/");
        String file_name = desconstructed_file_path[desconstructed_file_path.length - 1];
        String file_path = config.getServerDestPath() + file_name + ".part." + this_id;
        return file_path;
    }

    public KV[] map(String filename) {
        ConcurrentHashMap<String, Integer> hm = new ConcurrentHashMap<>();
        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String finalLine = line;
                executor.submit(() -> {
                    String[] words = finalLine.split("\\s+");
                    for (String word : words) {
                        hm.compute(word, (k, v) -> v == null ? 1 : v + 1);
                    }
                });
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        executor.shutdown();
        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        KV[] kvlist = new KV[hm.size()];
        int i = 0;
        for (Map.Entry<String, Integer> entry : hm.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
            kvlist[i++] = new KV(entry.getKey(), entry.getValue().toString());
        }

        return kvlist;
    }

    public KV[] runMap(String fname) {
        Config config = new Project().getConfig();
        String file_path = getFilePath(fname, config);
        
        KV[] kv_list = map(file_path);
        return kv_list;
    }
}
