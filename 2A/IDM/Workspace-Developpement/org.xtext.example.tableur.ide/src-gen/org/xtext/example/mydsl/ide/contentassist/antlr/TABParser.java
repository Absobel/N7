/*
 * generated by Xtext 2.32.0
 */
package org.xtext.example.mydsl.ide.contentassist.antlr;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.Map;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ide.editor.contentassist.antlr.AbstractContentAssistParser;
import org.xtext.example.mydsl.ide.contentassist.antlr.internal.InternalTABParser;
import org.xtext.example.mydsl.services.TABGrammarAccess;

public class TABParser extends AbstractContentAssistParser {

	@Singleton
	public static final class NameMappings {
		
		private final Map<AbstractElement, String> mappings;
		
		@Inject
		public NameMappings(TABGrammarAccess grammarAccess) {
			ImmutableMap.Builder<AbstractElement, String> builder = ImmutableMap.builder();
			init(builder, grammarAccess);
			this.mappings = builder.build();
		}
		
		public String getRuleName(AbstractElement element) {
			return mappings.get(element);
		}
		
		private static void init(ImmutableMap.Builder<AbstractElement, String> builder, TABGrammarAccess grammarAccess) {
			builder.put(grammarAccess.getColonneAccess().getAlternatives(), "rule__Colonne__Alternatives");
			builder.put(grammarAccess.getOperationAccess().getAlternatives(), "rule__Operation__Alternatives");
			builder.put(grammarAccess.getColonneOutputAccess().getAlternatives(), "rule__ColonneOutput__Alternatives");
			builder.put(grammarAccess.getOperationScriptAccess().getAlternatives(), "rule__OperationScript__Alternatives");
			builder.put(grammarAccess.getOperandAccess().getAlternatives(), "rule__Operand__Alternatives");
			builder.put(grammarAccess.getOperationBinaireTypeAccess().getAlternatives(), "rule__OperationBinaireType__Alternatives");
			builder.put(grammarAccess.getTypePrimitifPythonAccess().getAlternatives(), "rule__TypePrimitifPython__Alternatives");
			builder.put(grammarAccess.getOperateurBinaireTypeAccess().getAlternatives(), "rule__OperateurBinaireType__Alternatives");
			builder.put(grammarAccess.getOperateurUnaireTypeAccess().getAlternatives(), "rule__OperateurUnaireType__Alternatives");
			builder.put(grammarAccess.getTableurAccess().getGroup(), "rule__Tableur__Group__0");
			builder.put(grammarAccess.getOperateurUnaireAccess().getGroup(), "rule__OperateurUnaire__Group__0");
			builder.put(grammarAccess.getOperateurBinaireAccess().getGroup(), "rule__OperateurBinaire__Group__0");
			builder.put(grammarAccess.getTableAccess().getGroup(), "rule__Table__Group__0");
			builder.put(grammarAccess.getColonneInputAccess().getGroup(), "rule__ColonneInput__Group__0");
			builder.put(grammarAccess.getColonneOutputAccess().getGroup_0(), "rule__ColonneOutput__Group_0__0");
			builder.put(grammarAccess.getColonneOutputAccess().getGroup_1(), "rule__ColonneOutput__Group_1__0");
			builder.put(grammarAccess.getCatalogueAccess().getGroup(), "rule__Catalogue__Group__0");
			builder.put(grammarAccess.getAlgorithmeAccess().getGroup(), "rule__Algorithme__Group__0");
			builder.put(grammarAccess.getEntreeAccess().getGroup(), "rule__Entree__Group__0");
			builder.put(grammarAccess.getSortieAccess().getGroup(), "rule__Sortie__Group__0");
			builder.put(grammarAccess.getParametreAccess().getGroup(), "rule__Parametre__Group__0");
			builder.put(grammarAccess.getDocumentationAccess().getGroup(), "rule__Documentation__Group__0");
			builder.put(grammarAccess.getRessourceAccess().getGroup(), "rule__Ressource__Group__0");
			builder.put(grammarAccess.getScriptAccess().getGroup(), "rule__Script__Group__0");
			builder.put(grammarAccess.getEntreeScriptAccess().getGroup(), "rule__EntreeScript__Group__0");
			builder.put(grammarAccess.getSortieScriptAccess().getGroup(), "rule__SortieScript__Group__0");
			builder.put(grammarAccess.getOperationUnaireScriptAccess().getGroup(), "rule__OperationUnaireScript__Group__0");
			builder.put(grammarAccess.getOperationBinaireScriptAccess().getGroup(), "rule__OperationBinaireScript__Group__0");
			builder.put(grammarAccess.getOperandAccess().getGroup_0(), "rule__Operand__Group_0__0");
			builder.put(grammarAccess.getOperandAccess().getGroup_1(), "rule__Operand__Group_1__0");
			builder.put(grammarAccess.getCalculAccess().getGroup(), "rule__Calcul__Group__0");
			builder.put(grammarAccess.getTableurAccess().getNameAssignment_1(), "rule__Tableur__NameAssignment_1");
			builder.put(grammarAccess.getTableurAccess().getTablesAssignment_3(), "rule__Tableur__TablesAssignment_3");
			builder.put(grammarAccess.getTableurAccess().getCatalogueAssignment_4(), "rule__Tableur__CatalogueAssignment_4");
			builder.put(grammarAccess.getTableurAccess().getScriptAssignment_5(), "rule__Tableur__ScriptAssignment_5");
			builder.put(grammarAccess.getOperateurUnaireAccess().getKindAssignment_1(), "rule__OperateurUnaire__KindAssignment_1");
			builder.put(grammarAccess.getOperateurBinaireAccess().getKindAssignment_1(), "rule__OperateurBinaire__KindAssignment_1");
			builder.put(grammarAccess.getTableAccess().getNameAssignment_1(), "rule__Table__NameAssignment_1");
			builder.put(grammarAccess.getTableAccess().getColonnesAssignment_3(), "rule__Table__ColonnesAssignment_3");
			builder.put(grammarAccess.getColonneInputAccess().getNameAssignment_1(), "rule__ColonneInput__NameAssignment_1");
			builder.put(grammarAccess.getColonneOutputAccess().getNameAssignment_0_1(), "rule__ColonneOutput__NameAssignment_0_1");
			builder.put(grammarAccess.getColonneOutputAccess().getOperationsAssignment_0_3(), "rule__ColonneOutput__OperationsAssignment_0_3");
			builder.put(grammarAccess.getColonneOutputAccess().getColonnesAssignment_0_4(), "rule__ColonneOutput__ColonnesAssignment_0_4");
			builder.put(grammarAccess.getColonneOutputAccess().getColonnesAssignment_0_5(), "rule__ColonneOutput__ColonnesAssignment_0_5");
			builder.put(grammarAccess.getColonneOutputAccess().getNameAssignment_1_1(), "rule__ColonneOutput__NameAssignment_1_1");
			builder.put(grammarAccess.getColonneOutputAccess().getOperationsAssignment_1_3(), "rule__ColonneOutput__OperationsAssignment_1_3");
			builder.put(grammarAccess.getColonneOutputAccess().getColonnesAssignment_1_4(), "rule__ColonneOutput__ColonnesAssignment_1_4");
			builder.put(grammarAccess.getCatalogueAccess().getNameAssignment_1(), "rule__Catalogue__NameAssignment_1");
			builder.put(grammarAccess.getCatalogueAccess().getAlgorithmesAssignment_3(), "rule__Catalogue__AlgorithmesAssignment_3");
			builder.put(grammarAccess.getAlgorithmeAccess().getNameAssignment_1(), "rule__Algorithme__NameAssignment_1");
			builder.put(grammarAccess.getAlgorithmeAccess().getEntreesAssignment_3(), "rule__Algorithme__EntreesAssignment_3");
			builder.put(grammarAccess.getAlgorithmeAccess().getSortiesAssignment_4(), "rule__Algorithme__SortiesAssignment_4");
			builder.put(grammarAccess.getAlgorithmeAccess().getDocumentationAssignment_5(), "rule__Algorithme__DocumentationAssignment_5");
			builder.put(grammarAccess.getAlgorithmeAccess().getRessourceAssignment_6(), "rule__Algorithme__RessourceAssignment_6");
			builder.put(grammarAccess.getEntreeAccess().getParametresAssignment_2(), "rule__Entree__ParametresAssignment_2");
			builder.put(grammarAccess.getSortieAccess().getParametresAssignment_2(), "rule__Sortie__ParametresAssignment_2");
			builder.put(grammarAccess.getParametreAccess().getNameAssignment_0(), "rule__Parametre__NameAssignment_0");
			builder.put(grammarAccess.getParametreAccess().getTypeAssignment_2(), "rule__Parametre__TypeAssignment_2");
			builder.put(grammarAccess.getDocumentationAccess().getTexteAssignment_1(), "rule__Documentation__TexteAssignment_1");
			builder.put(grammarAccess.getRessourceAccess().getCheminAssignment_1(), "rule__Ressource__CheminAssignment_1");
			builder.put(grammarAccess.getScriptAccess().getNameAssignment_1(), "rule__Script__NameAssignment_1");
			builder.put(grammarAccess.getScriptAccess().getEntreesAssignment_3(), "rule__Script__EntreesAssignment_3");
			builder.put(grammarAccess.getScriptAccess().getSortiesAssignment_4(), "rule__Script__SortiesAssignment_4");
			builder.put(grammarAccess.getScriptAccess().getCalculsAssignment_5(), "rule__Script__CalculsAssignment_5");
			builder.put(grammarAccess.getEntreeScriptAccess().getParametresAssignment_2(), "rule__EntreeScript__ParametresAssignment_2");
			builder.put(grammarAccess.getSortieScriptAccess().getParametresAssignment_2(), "rule__SortieScript__ParametresAssignment_2");
			builder.put(grammarAccess.getOperationUnaireScriptAccess().getOperationAssignment_0(), "rule__OperationUnaireScript__OperationAssignment_0");
			builder.put(grammarAccess.getOperationUnaireScriptAccess().getOperandsAssignment_2(), "rule__OperationUnaireScript__OperandsAssignment_2");
			builder.put(grammarAccess.getOperationBinaireScriptAccess().getOperationAssignment_0(), "rule__OperationBinaireScript__OperationAssignment_0");
			builder.put(grammarAccess.getOperationBinaireScriptAccess().getOperandAssignment_2(), "rule__OperationBinaireScript__OperandAssignment_2");
			builder.put(grammarAccess.getOperationBinaireScriptAccess().getOperandAssignment_4(), "rule__OperationBinaireScript__OperandAssignment_4");
			builder.put(grammarAccess.getCalculAccess().getOperationAssignment_2(), "rule__Calcul__OperationAssignment_2");
		}
	}
	
	@Inject
	private NameMappings nameMappings;

	@Inject
	private TABGrammarAccess grammarAccess;

	@Override
	protected InternalTABParser createParser() {
		InternalTABParser result = new InternalTABParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}

	@Override
	protected String getRuleName(AbstractElement element) {
		return nameMappings.getRuleName(element);
	}

	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}

	public TABGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(TABGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
	public NameMappings getNameMappings() {
		return nameMappings;
	}
	
	public void setNameMappings(NameMappings nameMappings) {
		this.nameMappings = nameMappings;
	}
}