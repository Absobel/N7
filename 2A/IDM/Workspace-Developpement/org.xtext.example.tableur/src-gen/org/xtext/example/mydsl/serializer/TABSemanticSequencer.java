/*
 * generated by Xtext 2.32.0
 */
package org.xtext.example.mydsl.serializer;

import com.google.inject.Inject;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;
import org.xtext.example.mydsl.services.TABGrammarAccess;
import org.xtext.example.mydsl.tAB.Algorithme;
import org.xtext.example.mydsl.tAB.Calcul;
import org.xtext.example.mydsl.tAB.Catalogue;
import org.xtext.example.mydsl.tAB.ColonneInput;
import org.xtext.example.mydsl.tAB.ColonneOutput;
import org.xtext.example.mydsl.tAB.Documentation;
import org.xtext.example.mydsl.tAB.Entree;
import org.xtext.example.mydsl.tAB.EntreeScript;
import org.xtext.example.mydsl.tAB.Operand;
import org.xtext.example.mydsl.tAB.OperateurBinaire;
import org.xtext.example.mydsl.tAB.OperateurUnaire;
import org.xtext.example.mydsl.tAB.OperationBinaireScript;
import org.xtext.example.mydsl.tAB.OperationUnaireScript;
import org.xtext.example.mydsl.tAB.Parametre;
import org.xtext.example.mydsl.tAB.Ressource;
import org.xtext.example.mydsl.tAB.Script;
import org.xtext.example.mydsl.tAB.Sortie;
import org.xtext.example.mydsl.tAB.SortieScript;
import org.xtext.example.mydsl.tAB.TABPackage;
import org.xtext.example.mydsl.tAB.Table;
import org.xtext.example.mydsl.tAB.Tableur;

@SuppressWarnings("all")
public class TABSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private TABGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == TABPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case TABPackage.ALGORITHME:
				sequence_Algorithme(context, (Algorithme) semanticObject); 
				return; 
			case TABPackage.CALCUL:
				sequence_Calcul(context, (Calcul) semanticObject); 
				return; 
			case TABPackage.CATALOGUE:
				sequence_Catalogue(context, (Catalogue) semanticObject); 
				return; 
			case TABPackage.COLONNE_INPUT:
				sequence_ColonneInput(context, (ColonneInput) semanticObject); 
				return; 
			case TABPackage.COLONNE_OUTPUT:
				sequence_ColonneOutput(context, (ColonneOutput) semanticObject); 
				return; 
			case TABPackage.DOCUMENTATION:
				sequence_Documentation(context, (Documentation) semanticObject); 
				return; 
			case TABPackage.ENTREE:
				sequence_Entree(context, (Entree) semanticObject); 
				return; 
			case TABPackage.ENTREE_SCRIPT:
				sequence_EntreeScript(context, (EntreeScript) semanticObject); 
				return; 
			case TABPackage.OPERAND:
				sequence_Operand(context, (Operand) semanticObject); 
				return; 
			case TABPackage.OPERATEUR_BINAIRE:
				sequence_OperateurBinaire(context, (OperateurBinaire) semanticObject); 
				return; 
			case TABPackage.OPERATEUR_UNAIRE:
				sequence_OperateurUnaire(context, (OperateurUnaire) semanticObject); 
				return; 
			case TABPackage.OPERATION_BINAIRE_SCRIPT:
				sequence_OperationBinaireScript(context, (OperationBinaireScript) semanticObject); 
				return; 
			case TABPackage.OPERATION_UNAIRE_SCRIPT:
				sequence_OperationUnaireScript(context, (OperationUnaireScript) semanticObject); 
				return; 
			case TABPackage.PARAMETRE:
				sequence_Parametre(context, (Parametre) semanticObject); 
				return; 
			case TABPackage.RESSOURCE:
				sequence_Ressource(context, (Ressource) semanticObject); 
				return; 
			case TABPackage.SCRIPT:
				sequence_Script(context, (Script) semanticObject); 
				return; 
			case TABPackage.SORTIE:
				sequence_Sortie(context, (Sortie) semanticObject); 
				return; 
			case TABPackage.SORTIE_SCRIPT:
				sequence_SortieScript(context, (SortieScript) semanticObject); 
				return; 
			case TABPackage.TABLE:
				sequence_Table(context, (Table) semanticObject); 
				return; 
			case TABPackage.TABLEUR:
				sequence_Tableur(context, (Tableur) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * <pre>
	 * Contexts:
	 *     Algorithme returns Algorithme
	 *
	 * Constraint:
	 *     (name=ID entrees+=Entree* sorties+=Sortie* documentation+=Documentation* ressource+=Ressource*)
	 * </pre>
	 */
	protected void sequence_Algorithme(ISerializationContext context, Algorithme semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Calcul returns Calcul
	 *
	 * Constraint:
	 *     Operation+=OperationScript
	 * </pre>
	 */
	protected void sequence_Calcul(ISerializationContext context, Calcul semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Catalogue returns Catalogue
	 *
	 * Constraint:
	 *     (name=ID algorithmes+=Algorithme*)
	 * </pre>
	 */
	protected void sequence_Catalogue(ISerializationContext context, Catalogue semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Colonne returns ColonneInput
	 *     ColonneInput returns ColonneInput
	 *
	 * Constraint:
	 *     name=ID
	 * </pre>
	 */
	protected void sequence_ColonneInput(ISerializationContext context, ColonneInput semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, TABPackage.Literals.COLONNE__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TABPackage.Literals.COLONNE__NAME));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getColonneInputAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Colonne returns ColonneOutput
	 *     ColonneOutput returns ColonneOutput
	 *
	 * Constraint:
	 *     (
	 *         (name=ID operations+=OperateurBinaire colonnes+=[Colonne|ID] colonnes+=[Colonne|ID]) | 
	 *         (name=ID operations+=OperateurUnaire colonnes+=[Colonne|ID])
	 *     )
	 * </pre>
	 */
	protected void sequence_ColonneOutput(ISerializationContext context, ColonneOutput semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Documentation returns Documentation
	 *
	 * Constraint:
	 *     texte=STRING
	 * </pre>
	 */
	protected void sequence_Documentation(ISerializationContext context, Documentation semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, TABPackage.Literals.DOCUMENTATION__TEXTE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TABPackage.Literals.DOCUMENTATION__TEXTE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getDocumentationAccess().getTexteSTRINGTerminalRuleCall_1_0(), semanticObject.getTexte());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     EntreeScript returns EntreeScript
	 *
	 * Constraint:
	 *     parametres+=Parametre+
	 * </pre>
	 */
	protected void sequence_EntreeScript(ISerializationContext context, EntreeScript semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Entree returns Entree
	 *
	 * Constraint:
	 *     parametres+=Parametre+
	 * </pre>
	 */
	protected void sequence_Entree(ISerializationContext context, Entree semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Operand returns Operand
	 *
	 * Constraint:
	 *     {Operand}
	 * </pre>
	 */
	protected void sequence_Operand(ISerializationContext context, Operand semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Operation returns OperateurBinaire
	 *     OperateurBinaire returns OperateurBinaire
	 *
	 * Constraint:
	 *     kind=OperationBinaireType
	 * </pre>
	 */
	protected void sequence_OperateurBinaire(ISerializationContext context, OperateurBinaire semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, TABPackage.Literals.OPERATEUR_BINAIRE__KIND) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TABPackage.Literals.OPERATEUR_BINAIRE__KIND));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getOperateurBinaireAccess().getKindOperationBinaireTypeEnumRuleCall_1_0(), semanticObject.getKind());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Operation returns OperateurUnaire
	 *     OperateurUnaire returns OperateurUnaire
	 *
	 * Constraint:
	 *     kind=OperationUnaireType
	 * </pre>
	 */
	protected void sequence_OperateurUnaire(ISerializationContext context, OperateurUnaire semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, TABPackage.Literals.OPERATEUR_UNAIRE__KIND) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TABPackage.Literals.OPERATEUR_UNAIRE__KIND));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getOperateurUnaireAccess().getKindOperationUnaireTypeEnumRuleCall_1_0(), semanticObject.getKind());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     OperationScript returns OperationBinaireScript
	 *     OperationBinaireScript returns OperationBinaireScript
	 *     Operand returns OperationBinaireScript
	 *
	 * Constraint:
	 *     (operation=OperateurBinaireType operand+=Operand operand+=Operand)
	 * </pre>
	 */
	protected void sequence_OperationBinaireScript(ISerializationContext context, OperationBinaireScript semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     OperationScript returns OperationUnaireScript
	 *     OperationUnaireScript returns OperationUnaireScript
	 *     Operand returns OperationUnaireScript
	 *
	 * Constraint:
	 *     (operation=OperateurUnaireType operands+=Operand)
	 * </pre>
	 */
	protected void sequence_OperationUnaireScript(ISerializationContext context, OperationUnaireScript semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Parametre returns Parametre
	 *
	 * Constraint:
	 *     (name=ID type=TypePrimitifPython)
	 * </pre>
	 */
	protected void sequence_Parametre(ISerializationContext context, Parametre semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, TABPackage.Literals.PARAMETRE__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TABPackage.Literals.PARAMETRE__NAME));
			if (transientValues.isValueTransient(semanticObject, TABPackage.Literals.PARAMETRE__TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TABPackage.Literals.PARAMETRE__TYPE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getParametreAccess().getNameIDTerminalRuleCall_0_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getParametreAccess().getTypeTypePrimitifPythonEnumRuleCall_2_0(), semanticObject.getType());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Ressource returns Ressource
	 *
	 * Constraint:
	 *     chemin=STRING
	 * </pre>
	 */
	protected void sequence_Ressource(ISerializationContext context, Ressource semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, TABPackage.Literals.RESSOURCE__CHEMIN) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TABPackage.Literals.RESSOURCE__CHEMIN));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getRessourceAccess().getCheminSTRINGTerminalRuleCall_1_0(), semanticObject.getChemin());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Script returns Script
	 *
	 * Constraint:
	 *     (name=ID entrees+=EntreeScript sorties+=SortieScript calculs+=Calcul)
	 * </pre>
	 */
	protected void sequence_Script(ISerializationContext context, Script semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     SortieScript returns SortieScript
	 *
	 * Constraint:
	 *     parametres+=Parametre+
	 * </pre>
	 */
	protected void sequence_SortieScript(ISerializationContext context, SortieScript semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Sortie returns Sortie
	 *
	 * Constraint:
	 *     parametres+=Parametre+
	 * </pre>
	 */
	protected void sequence_Sortie(ISerializationContext context, Sortie semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Table returns Table
	 *
	 * Constraint:
	 *     (name=ID colonnes+=Colonne*)
	 * </pre>
	 */
	protected void sequence_Table(ISerializationContext context, Table semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Tableur returns Tableur
	 *
	 * Constraint:
	 *     (name=ID tables+=Table* catalogue+=Catalogue* script+=Script*)
	 * </pre>
	 */
	protected void sequence_Tableur(ISerializationContext context, Tableur semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
}
