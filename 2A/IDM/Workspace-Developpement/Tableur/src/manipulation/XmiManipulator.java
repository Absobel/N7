package manipulation;

import tableur.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import algorithme.Algorithme;
import algorithme.Catalogue;

import org.eclipse.emf.ecore.*;

public class XmiManipulator {

	static TableurFactory tableurFactory;
	static Tableur tableur;
	int operation = 0;
	String algoname;
	private Map<String, Integer> operationMap = new HashMap<>();
	private Map<ColonneOutput, String> algorithmeMap = new HashMap<>();

	private JFrame frame;
	private static JTabbedPane tabbedPane;

	public XmiManipulator() {
		// Initialize the main frame and tabbed pane
		frame = new JFrame("XMI Table Viewer");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());

		tabbedPane = new JTabbedPane();

		frame.add(tabbedPane, BorderLayout.CENTER);
		frame.setSize(1000, 700);
		frame.setLocationRelativeTo(null); // Center on screen
		frame.setVisible(true);
	}

	private void processEObject(EObject eObject) {

		// Check if it's an instance of a Table and create a tab for it
		for (EObject child : eObject.eContents()) {

			if (child instanceof Catalogue) {
				for (EObject child2 : child.eContents()) {
				    if (child2 instanceof Algorithme) {
				        Algorithme algo = (Algorithme) child2;
				        algoname = algo.getRessource().getFile();

				    }
				        
				}
		    }
			if (child instanceof Table) {
				Table table = (Table) child;

				// Ajoute une colonne de à gauche pour les n uméros de lignes
				List<String> columnTitles = new ArrayList<>();
				Map<String, Colonne> columnMap = new HashMap<>();

				columnTitles.add(" ");
				table.getColonne().stream().map(Colonne::getName).forEach(columnTitles::add);

				// Convertit les titres des colonnes en un tableau
				String[] columnNames = columnTitles.toArray(new String[0]);
				int nblignes = 100;
				Object[][] rowData = new Object[nblignes][columnNames.length];
				for (int row = 0; row < nblignes; row++) {
					rowData[row][0] = row + 1; // Numéro de la ligne
					for (int col = 1; col < columnNames.length; col++) {
						rowData[row][col] = ""; // Données vides pour les autres colonnes
					}
				}
				for (EObject child2 : child.eContents()) {
					if (child2 instanceof Colonne) {

						if (child2 instanceof ColonneOutput) {
							ColonneOutput colonneOutput = (ColonneOutput) child2;
							columnMap.put(colonneOutput.getName(), colonneOutput);

							OperateurBinaire operationBinaire = (OperateurBinaire) colonneOutput.getOperation();
							if (operationBinaire != null) {
								int operationType = -1;
								switch (operationBinaire.getKind()) {
								case ADDITION:
									operationType = 1;
									break;
								case SOUSTRACTION:
									operationType = 2;
									break;
								case MULTIPLICATION:
									operationType = 3;
									break;
								case DIVISION:
									operationType = 4;
									break;
								default:
									break;
								}
								operationMap.put(colonneOutput.getName(), operationType);

							}
						} else {
							ColonneInput colonneOutput = (ColonneInput) child2;
							columnMap.put(colonneOutput.getName(), colonneOutput);

						}
					}
				}

				// Réglage des colonnes éditables
				boolean[] canEdit = new boolean[columnNames.length];
				canEdit[0] = false; // La première colonne (numéros de ligne) n'est pas éditable
				for (int i = 1; i < canEdit.length; i++) {
					canEdit[i] = !(table.getColonne().get(i - 1) instanceof ColonneOutput);
				}
				MyTableModel tableModel = new MyTableModel(columnNames, rowData, canEdit, columnMap);

				// Create a model for the JTable with the data and column names

				// Create a JTable with the model
				JTable jTable = new JTable(tableModel);
				TableColumnModel columnModel = jTable.getColumnModel();
				TableColumn firstColumn = columnModel.getColumn(0);
				firstColumn.setMaxWidth(30);
				JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
				JButton importButton = new JButton("Importer");
				JButton exportButton = new JButton("Exporter en CSV");

				// Wrap the JTable in a JScrollPane
				JScrollPane scrollPane = new JScrollPane(jTable);
				// Add the scroll pane to a new panel
				JPanel tablePanel = new JPanel(new BorderLayout());
				tablePanel.add(scrollPane, BorderLayout.CENTER);
				ImportExportCSV importExportCSV = new ImportExportCSV();
				importButton.addActionListener(e -> importExportCSV.importData(frame, tabbedPane));
				exportButton.addActionListener(e -> importExportCSV.exportDataAsCSV(frame, tabbedPane));

				buttonPanel.add(importButton);
				buttonPanel.add(exportButton);
				frame.add(buttonPanel, BorderLayout.PAGE_START);

				JButton validateButton = new JButton("Operation");
				JButton algoButton = new JButton("Algorithme");

				validateButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JPanel panel = (JPanel) tabbedPane.getSelectedComponent();
						JScrollPane scrollPane = (JScrollPane) panel.getComponent(0);
						JTable table = (JTable) scrollPane.getViewport().getView();
						MyTableModel model = (MyTableModel) table.getModel();

						// Parcourez chaque colonne, à partir de l'index 1 puisque 0 est pour les
						// numéros de ligne
						for (int colIndex = 1; colIndex < model.getColumnCount(); colIndex++) {
							String columnName = model.getColumnName(colIndex);
							Colonne colObject = model.getColumnMap().get(columnName);

							// Vérifiez que l'objet colonne n'est pas null
							if (colObject != null && colObject instanceof ColonneOutput) {
								ColonneOutput colOutput = (ColonneOutput) colObject;
								List<Colonne> inputColumns = colOutput.getColonnes();
						

								if (inputColumns.size() == 2) { // Pour les opérations binaires
									// Effectuez les calculs pour chaque ligne
									for (int rowIndex = 0; rowIndex < model.getRowCount(); rowIndex++) {
										Object value1 = model.getValueAt(rowIndex,
												model.findColumn(inputColumns.get(0).getName()));
										Object value2 = model.getValueAt(rowIndex,
												model.findColumn(inputColumns.get(1).getName()));
										if (value1 != null && !value1.toString().isEmpty() && value2 != null
												&& !value2.toString().isEmpty()) {
											double a = Double.parseDouble(value1.toString());
											double b = Double.parseDouble(value2.toString());
											double result = performOperation(a, b, colOutput.getOperation(),
													columnName);
											model.setValueAt(result, rowIndex, colIndex);
										}
									}
								}
							}
						}
					}
				});
				algoButton.addActionListener(new ActionListener() {
				    public void actionPerformed(ActionEvent e) {
				        JPanel panel = (JPanel) tabbedPane.getSelectedComponent();
				        JScrollPane scrollPane = (JScrollPane) panel.getComponent(0);
				        JTable table = (JTable) scrollPane.getViewport().getView();
				        MyTableModel model = (MyTableModel) table.getModel();

				        for (int colIndex = 1; colIndex < model.getColumnCount(); colIndex++) {
				            String columnName = model.getColumnName(colIndex);
				            Colonne colObject = model.getColumnMap().get(columnName);

				            if (colObject != null && colObject instanceof ColonneOutput) {
				                ColonneOutput colOutput = (ColonneOutput) colObject;
				                algoname = colOutput.getAlgo().getRessource().getFile();
				                List<Colonne> inputColumns = colOutput.getColonnes();

				                for (int rowIndex = 0; rowIndex < model.getRowCount(); rowIndex++) {
				                    List<String> rowData = new ArrayList<>();
				                    for (Colonne inputCol : inputColumns) {
				                        String value = model.getValueAt(rowIndex, model.findColumn(inputCol.getName())).toString();
				                        rowData.add(value);
				                    }
				                     
				                    String result = executePythonScript("C:\\Users\\olivi\\Downloads\\_TestIDM\\_TestIDM\\" + algoname, rowData);

				                    model.setValueAt(result, rowIndex, colIndex);
				                }
				            }
				        }
				    }
				});
				buttonPanel.add(validateButton);
				frame.add(buttonPanel, BorderLayout.PAGE_START);
				buttonPanel.add(algoButton);
				frame.add(buttonPanel, BorderLayout.PAGE_START);
				JLabel tableNameLabel = new JLabel(table.getName());
				tableNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
				tablePanel.add(tableNameLabel, BorderLayout.PAGE_START);
				tabbedPane.addTab(table.getName(), tablePanel);
			}
		}

	}

	private double performOperation(double a, double b, Operation operation, String name) {
		Integer operationType = operationMap.get(name);
		switch (operationType) {
		case 1:
			return a + b;
		case 2:
			return a - b;
		case 3:
			return a * b;
		case 4:
			return b != 0 ? a / b : Double.POSITIVE_INFINITY;
		default:
			return 0; // ou une autre valeur par défaut
		}
	}

	private String executePythonScript(String scriptPath, List<String> data) {
		   String result = "";
		   List<String> commands = new ArrayList<>();
		    commands.add("python");
		    commands.add(scriptPath);
		    commands.addAll(data); // Ajoute tous les éléments de 'data' à la liste des commandes

		    ProcessBuilder processBuilder = new ProcessBuilder(commands);
		  

		try {
			Process process = processBuilder.start();

			// Capture the output from the script
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line;
			while ((line = reader.readLine()) != null) {
				result += line;
			}

			// Check for errors
			BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
			String errorLine;
			while ((errorLine = errorReader.readLine()) != null) {
				return ""; // Return immediately if there is an error
			}

			int exitCode = process.waitFor();
			if (exitCode != 0) {
				return "";
			}
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
			return "";
		}

		return result;
	}

	public void processResource(Resource resource) {
		// Récupère le tableur
		for (EObject eObject : resource.getContents()) {
			processEObject(eObject);
		}
	}

	public static void main(String[] args) {

		// Charger le package SimplePDL afin de l'enregistrer dans le registre
		// d'Eclipse.
		TableurPackage packageInstance = TableurPackage.eINSTANCE;
		// Enregistrer l'extension ".xmi" comme devant �tre ouverte �
		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("xmi", new XMIResourceFactoryImpl());
		// Cr�er un objet resourceSetImpl qui contiendra une ressource EMF (le mod�le
		// SimplePDL)
		ResourceSet resGet = new ResourceSetImpl();
		// Charger la ressource (le mod�le SimplePDL)
		URI modelURI = URI.createURI("src/manipulation/goat2.xmi");
		ResourceSet resSet = new ResourceSetImpl();
		Resource resource = resSet.getResource(modelURI, true);

		// Check if the resource is loaded and has contents
		if (resource != null && !resource.getContents().isEmpty()) {
			// Le premier élément est un tableur
			EObject rootObject = resource.getContents().get(0);
			if (rootObject instanceof Tableur) {
				tableur = (Tableur) rootObject;
			}
		}

		SwingUtilities.invokeLater(() -> {
			XmiManipulator manipulator = new XmiManipulator();
			manipulator.processResource(resource);
			manipulator.frame.setVisible(true);
		});
	}

}
