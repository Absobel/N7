package manipulation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

public class ImportExportCSV {

	public void importData(JFrame frame, JTabbedPane tabbedPane) {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Choisir un fichier à importer");
		int userSelection = fileChooser.showOpenDialog(frame);

		if (userSelection == JFileChooser.APPROVE_OPTION) {
			File fileToImport = fileChooser.getSelectedFile();
			try (BufferedReader br = new BufferedReader(new FileReader(fileToImport))) {
				String line;
				int row = 0;
				while ((line = br.readLine()) != null) {
					String[] values = line.split(",");
					System.out.println(line);

					// Obtenez le nombre de colonnes éditables de la table.
					JPanel panel = (JPanel) tabbedPane.getSelectedComponent();
					JScrollPane scrollPane = (JScrollPane) panel.getComponent(0);
					JTable table = (JTable) scrollPane.getViewport().getView();
					int editableColumnCount = 0;
					for (int i = 0; i < table.getColumnCount(); i++) {
						if (table.isCellEditable(row, i)) {
							editableColumnCount++;
						}
					}
					/*if (values.length +1 > editableColumnCount) {
						JOptionPane.showMessageDialog(frame,
								"Le nombre de colonnes dans le fichier CSV est supérieur au nombre de colonnes éditables dans la table.",
								"Erreur d'importation", JOptionPane.ERROR_MESSAGE);
						break;
					}
					*/

					for (int i = 0; i < values.length; i++) {
						if (table.isCellEditable(row, i + 1)) { 
							table.setValueAt(values[i], row, i + 1);
						}
					}
					row++;
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	public void exportDataAsCSV(JFrame frame, JTabbedPane tabbedPane) {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Choisir l'emplacement pour sauvegarder");
		int userSelection = fileChooser.showSaveDialog(frame);

		if (userSelection == JFileChooser.APPROVE_OPTION) {
			File fileToSave = fileChooser.getSelectedFile();
			try (PrintWriter pw = new PrintWriter(fileToSave)) {
				JPanel panel = (JPanel) tabbedPane.getSelectedComponent();
				JScrollPane scrollPane = (JScrollPane) panel.getComponent(0);
				JTable table = (JTable) scrollPane.getViewport().getView();
				TableModel model = table.getModel();
				for (int i = 0; i < model.getRowCount(); i++) {
					StringBuilder sb = new StringBuilder();
					for (int j = 1; j < model.getColumnCount(); j++) {
						sb.append(model.getValueAt(i, j).toString());
						if (j < model.getColumnCount() - 1) {
							sb.append(",");
						}
					}
					pw.println(sb.toString());
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}
