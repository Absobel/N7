import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.List;

public class Import_export_csv {
    private static JFrame frame;
    private static JTable table;
    private static DefaultTableModel model;
    private static JTextField filePathField;

    public static void main(String[] args) {
        // Créez la fenêtre principale
        frame = new JFrame("Tableau Swing Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

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

        // Créez le champ de texte pour le chemin du fichier
        filePathField = new JTextField();
        filePathField.setPreferredSize(new Dimension(200, 25));

        // Créez le bouton pour charger les données depuis le fichier CSV
        JButton loadButton = new JButton("Charger depuis CSV");
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Chargez les données depuis le fichier CSV spécifié par l'utilisateur
                loadCSVData(filePathField.getText());
            }
        });

        // Créez le bouton pour enregistrer les données dans un fichier CSV
        JButton saveButton = new JButton("Enregistrer dans un fichier CSV");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Permettez à l'utilisateur de choisir l'emplacement et le nom du fichier à enregistrer
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Enregistrer le fichier CSV");
                int userSelection = fileChooser.showSaveDialog(frame);

                if (userSelection == JFileChooser.APPROVE_OPTION) {
                    File fileToSave = fileChooser.getSelectedFile();
                    saveCSVData(fileToSave);
                }
            }
        });

        // Ajoutez le JScrollPane, le bouton "Plus", le champ de texte et les boutons de chargement/enregistrement à la fenêtre
        frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
        frame.getContentPane().add(addButton, BorderLayout.SOUTH);
        frame.getContentPane().add(filePathField, BorderLayout.WEST);
        frame.getContentPane().add(loadButton, BorderLayout.EAST);
        frame.getContentPane().add(saveButton, BorderLayout.NORTH);

        // Rendez la fenêtre visible
        frame.setVisible(true);
    }

    private static void loadCSVData(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            // Effacez le contenu actuel du tableau
            model.setRowCount(0);

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

    private static void saveCSVData(File file) {
        try (PrintWriter writer = new PrintWriter(file)) {
            // Écrivez les en-têtes dans le fichier
            for (int i = 0; i < model.getColumnCount(); i++) {
                writer.print(model.getColumnName(i));
                if (i < model.getColumnCount() - 1) {
                    writer.print(",");
                }
            }
            writer.println(); // Nouvelle ligne après les en-têtes

            // Écrivez les données dans le fichier
            for (int row = 0; row < model.getRowCount(); row++) {
                for (int col = 0; col < model.getColumnCount(); col++) {
                    writer.print(model.getValueAt(row, col));
                    if (col < model.getColumnCount() - 1) {
                        writer.print(",");
                    }
                }
                writer.println(); // Nouvelle ligne après chaque ligne de données
            }

            JOptionPane.showMessageDialog(frame, "Les données ont été enregistrées avec succès.", "Enregistrement réussi", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Une erreur s'est produite lors de l'enregistrement des données.", "Erreur d'enregistrement", JOptionPane.ERROR_MESSAGE);
        }
    }
}
