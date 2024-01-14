package src;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TableauSwingExample {
    private static JFrame frame;
    private static JTable table;
    private static DefaultTableModel model;

    public static void main(String[] args) {
        // Créez la fenêtre principale
        frame = new JFrame("Tableau Swing Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Créez le modèle de tableau
        model = new DefaultTableModel();

        // Créez le tableau avec le modèle
        table = new JTable(model);

        // Ajoutez le tableau à un JScrollPane pour permettre le défilement
        JScrollPane scrollPane = new JScrollPane(table);

        // Créez le bouton "Plus"
        JButton addButton = new JButton("Plus");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Ajoutez une colonne avec un nom de colonne générique
                String newColumnName = "NewColumn" + (model.getColumnCount() + 1);
                model.addColumn(newColumnName);
            }
        });

        // Ajoutez le JScrollPane et le bouton à la fenêtre
        frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
        frame.getContentPane().add(addButton, BorderLayout.SOUTH);

        // Chargez les données depuis le fichier CSV
        loadCSVData("test_idm.csv");

        // Rendez la fenêtre visible
        frame.setVisible(true);
    }

    private static void loadCSVData(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            // Lisez la première ligne pour obtenir les en-têtes
            if ((line = reader.readLine()) != null) {
                String[] headers = line.split(",");
                // Ajoutez les en-têtes au modèle du tableau
                for (String header : headers) {
                    model.addColumn(header);
                }
            }
            // Lisez les lignes restantes pour obtenir les données
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                // Ajoutez les données au modèle du tableau
                model.addRow(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
