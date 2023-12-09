package simplepdl.manip;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import petrinet.Arc;
import petrinet.ArcDirection;
import petrinet.ArcKind;
import petrinet.PetriNet;
import petrinet.PetriNetElement;
import petrinet.PetrinetFactory;
import petrinet.PetrinetPackage;
import petrinet.Place;
import petrinet.Transition;
import simplepdl.NeededRessource;
import simplepdl.Process;
import simplepdl.ProcessElement;
import simplepdl.Ressource;
import simplepdl.SimplepdlPackage;
import simplepdl.WorkDefinition;
import simplepdl.WorkSequence;
import simplepdl.WorkSequenceType;

public class SimplePDLtoPetriNet {
	public static class Key {
		public ProcessElement pe;
		public String var_name;

		public Key(ProcessElement pe, String var_name) {
			this.pe = pe;
			this.var_name = var_name;
		}
	}
	
	public static class Env {
		private HashMap<Key, PetriNetElement> env;

		public Env() {
			this.env = new HashMap<Key, PetriNetElement>();
		}

		public void pushElement(ProcessElement pe, String var_name, PetriNetElement p) {
			this.env.put(new Key(pe, var_name), p);
		}

		public PetriNetElement getElement(ProcessElement pe, String var_name) {
			return this.env.get(new Key(pe, var_name));
		}

		public List<PetriNetElement> getPetriNetElements() {
			return new ArrayList<PetriNetElement>(this.env.values());
		}

		public void ruleWD(WorkDefinition wd) {		
			Place start_place = SimplePDLtoPetriNet.place(wd.getName() + "_start", 1);
			Place active_place = SimplePDLtoPetriNet.place(wd.getName() + "_active", 0);
			Place finished_place = SimplePDLtoPetriNet.place(wd.getName() + "_finished", 0);
			Place started_place = SimplePDLtoPetriNet.place(wd.getName() + "_started", 0);

			Transition starting_transition = SimplePDLtoPetriNet.transition(wd.getName() + "_starting");
			Transition finishing_transition = SimplePDLtoPetriNet.transition(wd.getName() + "_finishing");

			Arc arc1 = SimplePDLtoPetriNet.arc(start_place, starting_transition, 1, ArcKind.NORMAL, ArcDirection.P2T, "");
			Arc arc2 = SimplePDLtoPetriNet.arc(active_place, starting_transition, 1, ArcKind.NORMAL, ArcDirection.T2P, "");
			Arc arc3 = SimplePDLtoPetriNet.arc(active_place, finishing_transition, 1, ArcKind.NORMAL, ArcDirection.P2T, "");
			Arc arc4 = SimplePDLtoPetriNet.arc(finished_place, finishing_transition, 1, ArcKind.NORMAL, ArcDirection.T2P, "");
			Arc arc5 = SimplePDLtoPetriNet.arc(started_place, starting_transition, 1, ArcKind.NORMAL, ArcDirection.T2P, "");

			this.pushElement(wd, "active_place", active_place);
			this.pushElement(wd, "finished_place", finished_place);
			this.pushElement(wd, "started_place", started_place);
			this.pushElement(wd, "starting_transition", starting_transition);
			this.pushElement(wd, "finishing_transition", finishing_transition);
			this.pushElement(wd, "start_place", start_place);
			this.pushElement(wd, "arc1", arc1);
			this.pushElement(wd, "arc2", arc2);
			this.pushElement(wd, "arc3", arc3);
			this.pushElement(wd, "arc4", arc4);
			this.pushElement(wd, "arc5", arc5);
		}

		public void ruleWS(WorkSequence ws) {
			WorkSequenceType linkType = ws.getLinkType();

			String place_var_name, transition_var_name;
			if (linkType == WorkSequenceType.START_TO_START || linkType == WorkSequenceType.FINISH_TO_START) {
				place_var_name = "started_place";
				transition_var_name = "starting_transition";
			} else {
				place_var_name = "finished_place";
				transition_var_name = "finishing_transition";
			}

			Place p = (Place) this.getElement(ws.getPredecessor(), place_var_name);
			Transition t = (Transition) this.getElement(ws.getSuccessor(), transition_var_name);

			Arc readarc = SimplePDLtoPetriNet.arc(p, t, 1, ArcKind.READ, ArcDirection.P2T, "");

			this.pushElement(ws, "readarc", readarc);
		}

		public void ruleR(Ressource r) {
			Place p = SimplePDLtoPetriNet.place(r.getName(), r.getTotalQuantity());
			
			this.pushElement(r, "place", p);
		}

		public void ruleNR(NeededRessource nr) {
			Place arc_place = (Place) this.getElement(nr.getRessource(), "place");
			Transition arc_start_transition = (Transition) this.getElement((ProcessElement) nr.eContainer(), "starting_transition");
			Transition arc_finish_transition = (Transition) this.getElement((ProcessElement) nr.eContainer(), "finishing_transition");
			
			Arc arc_start = SimplePDLtoPetriNet.arc(arc_place, arc_start_transition, nr.getQuantity(), ArcKind.NORMAL, ArcDirection.P2T, "");
			Arc arc_finish = SimplePDLtoPetriNet.arc(arc_place, arc_finish_transition, nr.getQuantity(), ArcKind.NORMAL, ArcDirection.T2P, "");

			this.pushElement((ProcessElement) nr, "arc_start", arc_start);
			this.pushElement((ProcessElement) nr, "arc_finish", arc_finish);
		}
	}

	
	public static Place place(String name, int nbJetons) {
		Place place = myFactory.createPlace();
		place.setName(name);
		place.setNbJetons(nbJetons);
		return place;
	}

	public static Transition transition(String name) {
		Transition transition = myFactory.createTransition();
		transition.setName(name);
		return transition;
	}

	public static Arc arc(Place place, Transition transition, int weight, ArcKind linkType, ArcDirection arcType, String name) {
		Arc arc = myFactory.createArc();
		arc.setPlace(place);
		arc.setTransition(transition);
		arc.setWeight(weight);
		arc.setType(linkType);
		arc.setDirection(arcType);
		arc.setName(name);
		return arc;
	}

	public static PetrinetFactory myFactory = PetrinetFactory.eINSTANCE;
	
	public static void main(String[] args) {

		/////// CHARGER SIMPLEPDL
		
		PetrinetPackage packageInstance1 = PetrinetPackage.eINSTANCE;		
		SimplepdlPackage packageInstance2 = SimplepdlPackage.eINSTANCE;
		
		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("xmi", new XMIResourceFactoryImpl());
		ResourceSet resSet = new ResourceSetImpl();
		URI modelURIPetriNet = URI.createURI("../fr.n7.petriNet/Exemples/EMF_Created_ExempleSujet.xmi");
		URI modelURISimplePDL = URI.createURI("Exemples/ExempleSujet.xmi");
		
		// Utilisé pour ajouté des trucs à PetriNet
		Resource resourcePetriNet = resSet.createResource(modelURIPetriNet);
		Resource resourceSimplePDL = resSet.getResource(modelURISimplePDL, true);
		
		// RÃ©cupÃ©rer le premier Ã©lÃ©ment du modÃ¨le (Ã©lÃ©ment racine)
		Process process = (Process) resourceSimplePDL.getContents().get(0);
				
		///////. CREER PETRINET
		
		List<WorkDefinition> workDefinitions = new ArrayList<WorkDefinition>();
		List<WorkSequence> workSequences = new ArrayList<WorkSequence>();
		List<Ressource> ressources = new ArrayList<Ressource>();
		List<NeededRessource> neededRessources = new ArrayList<NeededRessource>();

		for (ProcessElement pe : process.getProcessElements()) {
			if (pe instanceof WorkDefinition) {
				workDefinitions.add((WorkDefinition) pe);
			} else if (pe instanceof WorkSequence) {
				workSequences.add((WorkSequence) pe);
			} else if (pe instanceof Ressource) {
				ressources.add((Ressource) pe);
			} else if (pe instanceof NeededRessource) {
				neededRessources.add((NeededRessource) pe);
			}
		}

		// Création de l'environnement
		Env env = new Env();
		workDefinitions.forEach(wd -> env.ruleWD(wd));
		workSequences.forEach(ws -> env.ruleWS(ws));
		ressources.forEach(r -> env.ruleR(r));
		neededRessources.forEach(nr -> env.ruleNR(nr));

		PetrinetFactory myFactory = PetrinetFactory.eINSTANCE;
		PetriNet petrinet = myFactory.createPetriNet();
		petrinet.setName(process.getName());
		resourcePetriNet.getContents().add(petrinet);
		env.getPetriNetElements().forEach(pne -> petrinet.getPetriNetElements().add(pne));

		// Sauver la ressource
	    try {
	    	resourcePetriNet.save(Collections.EMPTY_MAP);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
