package org.xtext.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.xtext.services.TABGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalTABParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'Tableur'", "'{'", "'}'", "'Operation'", "'Table'", "'ColonneInput'", "'ColonneOutput'", "'Catalogue'", "'Algorithme'", "'Entrees'", "'Sorties'", "':'", "'Documentation'", "'Ressource'", "'Oppose'", "'Addition'", "'Soustraction'", "'Multiplication'", "'Division'", "'int'", "'float'", "'str'", "'bool'", "'list'"
    };
    public static final int RULE_STRING=5;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__33=33;
    public static final int T__12=12;
    public static final int T__34=34;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=6;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators


        public InternalTABParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalTABParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalTABParser.tokenNames; }
    public String getGrammarFileName() { return "InternalTAB.g"; }



     	private TABGrammarAccess grammarAccess;

        public InternalTABParser(TokenStream input, TABGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Tableur";
       	}

       	@Override
       	protected TABGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleTableur"
    // InternalTAB.g:65:1: entryRuleTableur returns [EObject current=null] : iv_ruleTableur= ruleTableur EOF ;
    public final EObject entryRuleTableur() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTableur = null;


        try {
            // InternalTAB.g:65:48: (iv_ruleTableur= ruleTableur EOF )
            // InternalTAB.g:66:2: iv_ruleTableur= ruleTableur EOF
            {
             newCompositeNode(grammarAccess.getTableurRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTableur=ruleTableur();

            state._fsp--;

             current =iv_ruleTableur; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTableur"


    // $ANTLR start "ruleTableur"
    // InternalTAB.g:72:1: ruleTableur returns [EObject current=null] : (otherlv_0= 'Tableur' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_tables_3_0= ruleTable ) )* ( (lv_Catalogue_4_0= ruleCatalogue ) ) otherlv_5= '}' ) ;
    public final EObject ruleTableur() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_5=null;
        EObject lv_tables_3_0 = null;

        EObject lv_Catalogue_4_0 = null;



        	enterRule();

        try {
            // InternalTAB.g:78:2: ( (otherlv_0= 'Tableur' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_tables_3_0= ruleTable ) )* ( (lv_Catalogue_4_0= ruleCatalogue ) ) otherlv_5= '}' ) )
            // InternalTAB.g:79:2: (otherlv_0= 'Tableur' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_tables_3_0= ruleTable ) )* ( (lv_Catalogue_4_0= ruleCatalogue ) ) otherlv_5= '}' )
            {
            // InternalTAB.g:79:2: (otherlv_0= 'Tableur' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_tables_3_0= ruleTable ) )* ( (lv_Catalogue_4_0= ruleCatalogue ) ) otherlv_5= '}' )
            // InternalTAB.g:80:3: otherlv_0= 'Tableur' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_tables_3_0= ruleTable ) )* ( (lv_Catalogue_4_0= ruleCatalogue ) ) otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,11,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getTableurAccess().getTableurKeyword_0());
            		
            // InternalTAB.g:84:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalTAB.g:85:4: (lv_name_1_0= RULE_ID )
            {
            // InternalTAB.g:85:4: (lv_name_1_0= RULE_ID )
            // InternalTAB.g:86:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_4); 

            					newLeafNode(lv_name_1_0, grammarAccess.getTableurAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTableurRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_5); 

            			newLeafNode(otherlv_2, grammarAccess.getTableurAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalTAB.g:106:3: ( (lv_tables_3_0= ruleTable ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==15) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalTAB.g:107:4: (lv_tables_3_0= ruleTable )
            	    {
            	    // InternalTAB.g:107:4: (lv_tables_3_0= ruleTable )
            	    // InternalTAB.g:108:5: lv_tables_3_0= ruleTable
            	    {

            	    					newCompositeNode(grammarAccess.getTableurAccess().getTablesTableParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_5);
            	    lv_tables_3_0=ruleTable();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getTableurRule());
            	    					}
            	    					add(
            	    						current,
            	    						"tables",
            	    						lv_tables_3_0,
            	    						"org.xtext.TAB.Table");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // InternalTAB.g:125:3: ( (lv_Catalogue_4_0= ruleCatalogue ) )
            // InternalTAB.g:126:4: (lv_Catalogue_4_0= ruleCatalogue )
            {
            // InternalTAB.g:126:4: (lv_Catalogue_4_0= ruleCatalogue )
            // InternalTAB.g:127:5: lv_Catalogue_4_0= ruleCatalogue
            {

            					newCompositeNode(grammarAccess.getTableurAccess().getCatalogueCatalogueParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_6);
            lv_Catalogue_4_0=ruleCatalogue();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTableurRule());
            					}
            					add(
            						current,
            						"Catalogue",
            						lv_Catalogue_4_0,
            						"org.xtext.TAB.Catalogue");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getTableurAccess().getRightCurlyBracketKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTableur"


    // $ANTLR start "entryRuleColonne"
    // InternalTAB.g:152:1: entryRuleColonne returns [EObject current=null] : iv_ruleColonne= ruleColonne EOF ;
    public final EObject entryRuleColonne() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleColonne = null;


        try {
            // InternalTAB.g:152:48: (iv_ruleColonne= ruleColonne EOF )
            // InternalTAB.g:153:2: iv_ruleColonne= ruleColonne EOF
            {
             newCompositeNode(grammarAccess.getColonneRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleColonne=ruleColonne();

            state._fsp--;

             current =iv_ruleColonne; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleColonne"


    // $ANTLR start "ruleColonne"
    // InternalTAB.g:159:1: ruleColonne returns [EObject current=null] : (this_ColonneInput_0= ruleColonneInput | this_ColonneOutput_1= ruleColonneOutput ) ;
    public final EObject ruleColonne() throws RecognitionException {
        EObject current = null;

        EObject this_ColonneInput_0 = null;

        EObject this_ColonneOutput_1 = null;



        	enterRule();

        try {
            // InternalTAB.g:165:2: ( (this_ColonneInput_0= ruleColonneInput | this_ColonneOutput_1= ruleColonneOutput ) )
            // InternalTAB.g:166:2: (this_ColonneInput_0= ruleColonneInput | this_ColonneOutput_1= ruleColonneOutput )
            {
            // InternalTAB.g:166:2: (this_ColonneInput_0= ruleColonneInput | this_ColonneOutput_1= ruleColonneOutput )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==16) ) {
                alt2=1;
            }
            else if ( (LA2_0==17) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalTAB.g:167:3: this_ColonneInput_0= ruleColonneInput
                    {

                    			newCompositeNode(grammarAccess.getColonneAccess().getColonneInputParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_ColonneInput_0=ruleColonneInput();

                    state._fsp--;


                    			current = this_ColonneInput_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalTAB.g:176:3: this_ColonneOutput_1= ruleColonneOutput
                    {

                    			newCompositeNode(grammarAccess.getColonneAccess().getColonneOutputParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_ColonneOutput_1=ruleColonneOutput();

                    state._fsp--;


                    			current = this_ColonneOutput_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleColonne"


    // $ANTLR start "entryRuleOperationUnaire"
    // InternalTAB.g:188:1: entryRuleOperationUnaire returns [EObject current=null] : iv_ruleOperationUnaire= ruleOperationUnaire EOF ;
    public final EObject entryRuleOperationUnaire() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperationUnaire = null;


        try {
            // InternalTAB.g:188:56: (iv_ruleOperationUnaire= ruleOperationUnaire EOF )
            // InternalTAB.g:189:2: iv_ruleOperationUnaire= ruleOperationUnaire EOF
            {
             newCompositeNode(grammarAccess.getOperationUnaireRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOperationUnaire=ruleOperationUnaire();

            state._fsp--;

             current =iv_ruleOperationUnaire; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOperationUnaire"


    // $ANTLR start "ruleOperationUnaire"
    // InternalTAB.g:195:1: ruleOperationUnaire returns [EObject current=null] : (otherlv_0= 'Operation' ( (lv_kind_1_0= ruleOperationUnaireType ) ) ) ;
    public final EObject ruleOperationUnaire() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Enumerator lv_kind_1_0 = null;



        	enterRule();

        try {
            // InternalTAB.g:201:2: ( (otherlv_0= 'Operation' ( (lv_kind_1_0= ruleOperationUnaireType ) ) ) )
            // InternalTAB.g:202:2: (otherlv_0= 'Operation' ( (lv_kind_1_0= ruleOperationUnaireType ) ) )
            {
            // InternalTAB.g:202:2: (otherlv_0= 'Operation' ( (lv_kind_1_0= ruleOperationUnaireType ) ) )
            // InternalTAB.g:203:3: otherlv_0= 'Operation' ( (lv_kind_1_0= ruleOperationUnaireType ) )
            {
            otherlv_0=(Token)match(input,14,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getOperationUnaireAccess().getOperationKeyword_0());
            		
            // InternalTAB.g:207:3: ( (lv_kind_1_0= ruleOperationUnaireType ) )
            // InternalTAB.g:208:4: (lv_kind_1_0= ruleOperationUnaireType )
            {
            // InternalTAB.g:208:4: (lv_kind_1_0= ruleOperationUnaireType )
            // InternalTAB.g:209:5: lv_kind_1_0= ruleOperationUnaireType
            {

            					newCompositeNode(grammarAccess.getOperationUnaireAccess().getKindOperationUnaireTypeEnumRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_kind_1_0=ruleOperationUnaireType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getOperationUnaireRule());
            					}
            					set(
            						current,
            						"kind",
            						lv_kind_1_0,
            						"org.xtext.TAB.OperationUnaireType");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOperationUnaire"


    // $ANTLR start "entryRuleOperationBinaire"
    // InternalTAB.g:230:1: entryRuleOperationBinaire returns [EObject current=null] : iv_ruleOperationBinaire= ruleOperationBinaire EOF ;
    public final EObject entryRuleOperationBinaire() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperationBinaire = null;


        try {
            // InternalTAB.g:230:57: (iv_ruleOperationBinaire= ruleOperationBinaire EOF )
            // InternalTAB.g:231:2: iv_ruleOperationBinaire= ruleOperationBinaire EOF
            {
             newCompositeNode(grammarAccess.getOperationBinaireRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOperationBinaire=ruleOperationBinaire();

            state._fsp--;

             current =iv_ruleOperationBinaire; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOperationBinaire"


    // $ANTLR start "ruleOperationBinaire"
    // InternalTAB.g:237:1: ruleOperationBinaire returns [EObject current=null] : (otherlv_0= 'Operation' ( (lv_kind_1_0= ruleOperationBinaireType ) ) ) ;
    public final EObject ruleOperationBinaire() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Enumerator lv_kind_1_0 = null;



        	enterRule();

        try {
            // InternalTAB.g:243:2: ( (otherlv_0= 'Operation' ( (lv_kind_1_0= ruleOperationBinaireType ) ) ) )
            // InternalTAB.g:244:2: (otherlv_0= 'Operation' ( (lv_kind_1_0= ruleOperationBinaireType ) ) )
            {
            // InternalTAB.g:244:2: (otherlv_0= 'Operation' ( (lv_kind_1_0= ruleOperationBinaireType ) ) )
            // InternalTAB.g:245:3: otherlv_0= 'Operation' ( (lv_kind_1_0= ruleOperationBinaireType ) )
            {
            otherlv_0=(Token)match(input,14,FOLLOW_8); 

            			newLeafNode(otherlv_0, grammarAccess.getOperationBinaireAccess().getOperationKeyword_0());
            		
            // InternalTAB.g:249:3: ( (lv_kind_1_0= ruleOperationBinaireType ) )
            // InternalTAB.g:250:4: (lv_kind_1_0= ruleOperationBinaireType )
            {
            // InternalTAB.g:250:4: (lv_kind_1_0= ruleOperationBinaireType )
            // InternalTAB.g:251:5: lv_kind_1_0= ruleOperationBinaireType
            {

            					newCompositeNode(grammarAccess.getOperationBinaireAccess().getKindOperationBinaireTypeEnumRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_kind_1_0=ruleOperationBinaireType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getOperationBinaireRule());
            					}
            					set(
            						current,
            						"kind",
            						lv_kind_1_0,
            						"org.xtext.TAB.OperationBinaireType");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOperationBinaire"


    // $ANTLR start "entryRuleTable"
    // InternalTAB.g:272:1: entryRuleTable returns [EObject current=null] : iv_ruleTable= ruleTable EOF ;
    public final EObject entryRuleTable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTable = null;


        try {
            // InternalTAB.g:272:46: (iv_ruleTable= ruleTable EOF )
            // InternalTAB.g:273:2: iv_ruleTable= ruleTable EOF
            {
             newCompositeNode(grammarAccess.getTableRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTable=ruleTable();

            state._fsp--;

             current =iv_ruleTable; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTable"


    // $ANTLR start "ruleTable"
    // InternalTAB.g:279:1: ruleTable returns [EObject current=null] : (otherlv_0= 'Table' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_colonnes_3_0= ruleColonne ) )* otherlv_4= '}' ) ;
    public final EObject ruleTable() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_colonnes_3_0 = null;



        	enterRule();

        try {
            // InternalTAB.g:285:2: ( (otherlv_0= 'Table' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_colonnes_3_0= ruleColonne ) )* otherlv_4= '}' ) )
            // InternalTAB.g:286:2: (otherlv_0= 'Table' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_colonnes_3_0= ruleColonne ) )* otherlv_4= '}' )
            {
            // InternalTAB.g:286:2: (otherlv_0= 'Table' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_colonnes_3_0= ruleColonne ) )* otherlv_4= '}' )
            // InternalTAB.g:287:3: otherlv_0= 'Table' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_colonnes_3_0= ruleColonne ) )* otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,15,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getTableAccess().getTableKeyword_0());
            		
            // InternalTAB.g:291:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalTAB.g:292:4: (lv_name_1_0= RULE_ID )
            {
            // InternalTAB.g:292:4: (lv_name_1_0= RULE_ID )
            // InternalTAB.g:293:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_4); 

            					newLeafNode(lv_name_1_0, grammarAccess.getTableAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTableRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_9); 

            			newLeafNode(otherlv_2, grammarAccess.getTableAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalTAB.g:313:3: ( (lv_colonnes_3_0= ruleColonne ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>=16 && LA3_0<=17)) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalTAB.g:314:4: (lv_colonnes_3_0= ruleColonne )
            	    {
            	    // InternalTAB.g:314:4: (lv_colonnes_3_0= ruleColonne )
            	    // InternalTAB.g:315:5: lv_colonnes_3_0= ruleColonne
            	    {

            	    					newCompositeNode(grammarAccess.getTableAccess().getColonnesColonneParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_9);
            	    lv_colonnes_3_0=ruleColonne();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getTableRule());
            	    					}
            	    					add(
            	    						current,
            	    						"colonnes",
            	    						lv_colonnes_3_0,
            	    						"org.xtext.TAB.Colonne");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            otherlv_4=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getTableAccess().getRightCurlyBracketKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTable"


    // $ANTLR start "entryRuleColonneInput"
    // InternalTAB.g:340:1: entryRuleColonneInput returns [EObject current=null] : iv_ruleColonneInput= ruleColonneInput EOF ;
    public final EObject entryRuleColonneInput() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleColonneInput = null;


        try {
            // InternalTAB.g:340:53: (iv_ruleColonneInput= ruleColonneInput EOF )
            // InternalTAB.g:341:2: iv_ruleColonneInput= ruleColonneInput EOF
            {
             newCompositeNode(grammarAccess.getColonneInputRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleColonneInput=ruleColonneInput();

            state._fsp--;

             current =iv_ruleColonneInput; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleColonneInput"


    // $ANTLR start "ruleColonneInput"
    // InternalTAB.g:347:1: ruleColonneInput returns [EObject current=null] : (otherlv_0= 'ColonneInput' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleColonneInput() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;


        	enterRule();

        try {
            // InternalTAB.g:353:2: ( (otherlv_0= 'ColonneInput' ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalTAB.g:354:2: (otherlv_0= 'ColonneInput' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalTAB.g:354:2: (otherlv_0= 'ColonneInput' ( (lv_name_1_0= RULE_ID ) ) )
            // InternalTAB.g:355:3: otherlv_0= 'ColonneInput' ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,16,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getColonneInputAccess().getColonneInputKeyword_0());
            		
            // InternalTAB.g:359:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalTAB.g:360:4: (lv_name_1_0= RULE_ID )
            {
            // InternalTAB.g:360:4: (lv_name_1_0= RULE_ID )
            // InternalTAB.g:361:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(lv_name_1_0, grammarAccess.getColonneInputAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getColonneInputRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleColonneInput"


    // $ANTLR start "entryRuleColonneOutput"
    // InternalTAB.g:381:1: entryRuleColonneOutput returns [EObject current=null] : iv_ruleColonneOutput= ruleColonneOutput EOF ;
    public final EObject entryRuleColonneOutput() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleColonneOutput = null;


        try {
            // InternalTAB.g:381:54: (iv_ruleColonneOutput= ruleColonneOutput EOF )
            // InternalTAB.g:382:2: iv_ruleColonneOutput= ruleColonneOutput EOF
            {
             newCompositeNode(grammarAccess.getColonneOutputRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleColonneOutput=ruleColonneOutput();

            state._fsp--;

             current =iv_ruleColonneOutput; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleColonneOutput"


    // $ANTLR start "ruleColonneOutput"
    // InternalTAB.g:388:1: ruleColonneOutput returns [EObject current=null] : ( (otherlv_0= 'ColonneOutput' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_operations_3_0= ruleOperationBinaire ) ) ( (otherlv_4= RULE_ID ) ) ( (otherlv_5= RULE_ID ) ) otherlv_6= '}' ) | (otherlv_7= 'ColonneOutput' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_operations_10_0= ruleOperationUnaire ) ) ( (otherlv_11= RULE_ID ) ) otherlv_12= '}' ) ) ;
    public final EObject ruleColonneOutput() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token lv_name_8_0=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        EObject lv_operations_3_0 = null;

        EObject lv_operations_10_0 = null;



        	enterRule();

        try {
            // InternalTAB.g:394:2: ( ( (otherlv_0= 'ColonneOutput' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_operations_3_0= ruleOperationBinaire ) ) ( (otherlv_4= RULE_ID ) ) ( (otherlv_5= RULE_ID ) ) otherlv_6= '}' ) | (otherlv_7= 'ColonneOutput' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_operations_10_0= ruleOperationUnaire ) ) ( (otherlv_11= RULE_ID ) ) otherlv_12= '}' ) ) )
            // InternalTAB.g:395:2: ( (otherlv_0= 'ColonneOutput' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_operations_3_0= ruleOperationBinaire ) ) ( (otherlv_4= RULE_ID ) ) ( (otherlv_5= RULE_ID ) ) otherlv_6= '}' ) | (otherlv_7= 'ColonneOutput' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_operations_10_0= ruleOperationUnaire ) ) ( (otherlv_11= RULE_ID ) ) otherlv_12= '}' ) )
            {
            // InternalTAB.g:395:2: ( (otherlv_0= 'ColonneOutput' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_operations_3_0= ruleOperationBinaire ) ) ( (otherlv_4= RULE_ID ) ) ( (otherlv_5= RULE_ID ) ) otherlv_6= '}' ) | (otherlv_7= 'ColonneOutput' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_operations_10_0= ruleOperationUnaire ) ) ( (otherlv_11= RULE_ID ) ) otherlv_12= '}' ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==17) ) {
                int LA4_1 = input.LA(2);

                if ( (LA4_1==RULE_ID) ) {
                    int LA4_2 = input.LA(3);

                    if ( (LA4_2==12) ) {
                        int LA4_3 = input.LA(4);

                        if ( (LA4_3==14) ) {
                            int LA4_4 = input.LA(5);

                            if ( ((LA4_4>=26 && LA4_4<=29)) ) {
                                alt4=1;
                            }
                            else if ( (LA4_4==25) ) {
                                alt4=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 4, 4, input);

                                throw nvae;
                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 4, 3, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 4, 2, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // InternalTAB.g:396:3: (otherlv_0= 'ColonneOutput' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_operations_3_0= ruleOperationBinaire ) ) ( (otherlv_4= RULE_ID ) ) ( (otherlv_5= RULE_ID ) ) otherlv_6= '}' )
                    {
                    // InternalTAB.g:396:3: (otherlv_0= 'ColonneOutput' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_operations_3_0= ruleOperationBinaire ) ) ( (otherlv_4= RULE_ID ) ) ( (otherlv_5= RULE_ID ) ) otherlv_6= '}' )
                    // InternalTAB.g:397:4: otherlv_0= 'ColonneOutput' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_operations_3_0= ruleOperationBinaire ) ) ( (otherlv_4= RULE_ID ) ) ( (otherlv_5= RULE_ID ) ) otherlv_6= '}'
                    {
                    otherlv_0=(Token)match(input,17,FOLLOW_3); 

                    				newLeafNode(otherlv_0, grammarAccess.getColonneOutputAccess().getColonneOutputKeyword_0_0());
                    			
                    // InternalTAB.g:401:4: ( (lv_name_1_0= RULE_ID ) )
                    // InternalTAB.g:402:5: (lv_name_1_0= RULE_ID )
                    {
                    // InternalTAB.g:402:5: (lv_name_1_0= RULE_ID )
                    // InternalTAB.g:403:6: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_4); 

                    						newLeafNode(lv_name_1_0, grammarAccess.getColonneOutputAccess().getNameIDTerminalRuleCall_0_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getColonneOutputRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"name",
                    							lv_name_1_0,
                    							"org.eclipse.xtext.common.Terminals.ID");
                    					

                    }


                    }

                    otherlv_2=(Token)match(input,12,FOLLOW_10); 

                    				newLeafNode(otherlv_2, grammarAccess.getColonneOutputAccess().getLeftCurlyBracketKeyword_0_2());
                    			
                    // InternalTAB.g:423:4: ( (lv_operations_3_0= ruleOperationBinaire ) )
                    // InternalTAB.g:424:5: (lv_operations_3_0= ruleOperationBinaire )
                    {
                    // InternalTAB.g:424:5: (lv_operations_3_0= ruleOperationBinaire )
                    // InternalTAB.g:425:6: lv_operations_3_0= ruleOperationBinaire
                    {

                    						newCompositeNode(grammarAccess.getColonneOutputAccess().getOperationsOperationBinaireParserRuleCall_0_3_0());
                    					
                    pushFollow(FOLLOW_3);
                    lv_operations_3_0=ruleOperationBinaire();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getColonneOutputRule());
                    						}
                    						add(
                    							current,
                    							"operations",
                    							lv_operations_3_0,
                    							"org.xtext.TAB.OperationBinaire");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalTAB.g:442:4: ( (otherlv_4= RULE_ID ) )
                    // InternalTAB.g:443:5: (otherlv_4= RULE_ID )
                    {
                    // InternalTAB.g:443:5: (otherlv_4= RULE_ID )
                    // InternalTAB.g:444:6: otherlv_4= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getColonneOutputRule());
                    						}
                    					
                    otherlv_4=(Token)match(input,RULE_ID,FOLLOW_3); 

                    						newLeafNode(otherlv_4, grammarAccess.getColonneOutputAccess().getColonnesColonneCrossReference_0_4_0());
                    					

                    }


                    }

                    // InternalTAB.g:455:4: ( (otherlv_5= RULE_ID ) )
                    // InternalTAB.g:456:5: (otherlv_5= RULE_ID )
                    {
                    // InternalTAB.g:456:5: (otherlv_5= RULE_ID )
                    // InternalTAB.g:457:6: otherlv_5= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getColonneOutputRule());
                    						}
                    					
                    otherlv_5=(Token)match(input,RULE_ID,FOLLOW_6); 

                    						newLeafNode(otherlv_5, grammarAccess.getColonneOutputAccess().getColonnesColonneCrossReference_0_5_0());
                    					

                    }


                    }

                    otherlv_6=(Token)match(input,13,FOLLOW_2); 

                    				newLeafNode(otherlv_6, grammarAccess.getColonneOutputAccess().getRightCurlyBracketKeyword_0_6());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalTAB.g:474:3: (otherlv_7= 'ColonneOutput' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_operations_10_0= ruleOperationUnaire ) ) ( (otherlv_11= RULE_ID ) ) otherlv_12= '}' )
                    {
                    // InternalTAB.g:474:3: (otherlv_7= 'ColonneOutput' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_operations_10_0= ruleOperationUnaire ) ) ( (otherlv_11= RULE_ID ) ) otherlv_12= '}' )
                    // InternalTAB.g:475:4: otherlv_7= 'ColonneOutput' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_operations_10_0= ruleOperationUnaire ) ) ( (otherlv_11= RULE_ID ) ) otherlv_12= '}'
                    {
                    otherlv_7=(Token)match(input,17,FOLLOW_3); 

                    				newLeafNode(otherlv_7, grammarAccess.getColonneOutputAccess().getColonneOutputKeyword_1_0());
                    			
                    // InternalTAB.g:479:4: ( (lv_name_8_0= RULE_ID ) )
                    // InternalTAB.g:480:5: (lv_name_8_0= RULE_ID )
                    {
                    // InternalTAB.g:480:5: (lv_name_8_0= RULE_ID )
                    // InternalTAB.g:481:6: lv_name_8_0= RULE_ID
                    {
                    lv_name_8_0=(Token)match(input,RULE_ID,FOLLOW_4); 

                    						newLeafNode(lv_name_8_0, grammarAccess.getColonneOutputAccess().getNameIDTerminalRuleCall_1_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getColonneOutputRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"name",
                    							lv_name_8_0,
                    							"org.eclipse.xtext.common.Terminals.ID");
                    					

                    }


                    }

                    otherlv_9=(Token)match(input,12,FOLLOW_10); 

                    				newLeafNode(otherlv_9, grammarAccess.getColonneOutputAccess().getLeftCurlyBracketKeyword_1_2());
                    			
                    // InternalTAB.g:501:4: ( (lv_operations_10_0= ruleOperationUnaire ) )
                    // InternalTAB.g:502:5: (lv_operations_10_0= ruleOperationUnaire )
                    {
                    // InternalTAB.g:502:5: (lv_operations_10_0= ruleOperationUnaire )
                    // InternalTAB.g:503:6: lv_operations_10_0= ruleOperationUnaire
                    {

                    						newCompositeNode(grammarAccess.getColonneOutputAccess().getOperationsOperationUnaireParserRuleCall_1_3_0());
                    					
                    pushFollow(FOLLOW_3);
                    lv_operations_10_0=ruleOperationUnaire();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getColonneOutputRule());
                    						}
                    						add(
                    							current,
                    							"operations",
                    							lv_operations_10_0,
                    							"org.xtext.TAB.OperationUnaire");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalTAB.g:520:4: ( (otherlv_11= RULE_ID ) )
                    // InternalTAB.g:521:5: (otherlv_11= RULE_ID )
                    {
                    // InternalTAB.g:521:5: (otherlv_11= RULE_ID )
                    // InternalTAB.g:522:6: otherlv_11= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getColonneOutputRule());
                    						}
                    					
                    otherlv_11=(Token)match(input,RULE_ID,FOLLOW_6); 

                    						newLeafNode(otherlv_11, grammarAccess.getColonneOutputAccess().getColonnesColonneCrossReference_1_4_0());
                    					

                    }


                    }

                    otherlv_12=(Token)match(input,13,FOLLOW_2); 

                    				newLeafNode(otherlv_12, grammarAccess.getColonneOutputAccess().getRightCurlyBracketKeyword_1_5());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleColonneOutput"


    // $ANTLR start "entryRuleCatalogue"
    // InternalTAB.g:542:1: entryRuleCatalogue returns [EObject current=null] : iv_ruleCatalogue= ruleCatalogue EOF ;
    public final EObject entryRuleCatalogue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCatalogue = null;


        try {
            // InternalTAB.g:542:50: (iv_ruleCatalogue= ruleCatalogue EOF )
            // InternalTAB.g:543:2: iv_ruleCatalogue= ruleCatalogue EOF
            {
             newCompositeNode(grammarAccess.getCatalogueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCatalogue=ruleCatalogue();

            state._fsp--;

             current =iv_ruleCatalogue; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCatalogue"


    // $ANTLR start "ruleCatalogue"
    // InternalTAB.g:549:1: ruleCatalogue returns [EObject current=null] : (otherlv_0= 'Catalogue' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_algorithmes_3_0= ruleAlgorithme ) )* otherlv_4= '}' ) ;
    public final EObject ruleCatalogue() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_algorithmes_3_0 = null;



        	enterRule();

        try {
            // InternalTAB.g:555:2: ( (otherlv_0= 'Catalogue' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_algorithmes_3_0= ruleAlgorithme ) )* otherlv_4= '}' ) )
            // InternalTAB.g:556:2: (otherlv_0= 'Catalogue' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_algorithmes_3_0= ruleAlgorithme ) )* otherlv_4= '}' )
            {
            // InternalTAB.g:556:2: (otherlv_0= 'Catalogue' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_algorithmes_3_0= ruleAlgorithme ) )* otherlv_4= '}' )
            // InternalTAB.g:557:3: otherlv_0= 'Catalogue' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_algorithmes_3_0= ruleAlgorithme ) )* otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,18,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getCatalogueAccess().getCatalogueKeyword_0());
            		
            // InternalTAB.g:561:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalTAB.g:562:4: (lv_name_1_0= RULE_ID )
            {
            // InternalTAB.g:562:4: (lv_name_1_0= RULE_ID )
            // InternalTAB.g:563:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_4); 

            					newLeafNode(lv_name_1_0, grammarAccess.getCatalogueAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getCatalogueRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_11); 

            			newLeafNode(otherlv_2, grammarAccess.getCatalogueAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalTAB.g:583:3: ( (lv_algorithmes_3_0= ruleAlgorithme ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==19) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalTAB.g:584:4: (lv_algorithmes_3_0= ruleAlgorithme )
            	    {
            	    // InternalTAB.g:584:4: (lv_algorithmes_3_0= ruleAlgorithme )
            	    // InternalTAB.g:585:5: lv_algorithmes_3_0= ruleAlgorithme
            	    {

            	    					newCompositeNode(grammarAccess.getCatalogueAccess().getAlgorithmesAlgorithmeParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_11);
            	    lv_algorithmes_3_0=ruleAlgorithme();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getCatalogueRule());
            	    					}
            	    					add(
            	    						current,
            	    						"algorithmes",
            	    						lv_algorithmes_3_0,
            	    						"org.xtext.TAB.Algorithme");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            otherlv_4=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getCatalogueAccess().getRightCurlyBracketKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCatalogue"


    // $ANTLR start "entryRuleAlgorithme"
    // InternalTAB.g:610:1: entryRuleAlgorithme returns [EObject current=null] : iv_ruleAlgorithme= ruleAlgorithme EOF ;
    public final EObject entryRuleAlgorithme() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAlgorithme = null;


        try {
            // InternalTAB.g:610:51: (iv_ruleAlgorithme= ruleAlgorithme EOF )
            // InternalTAB.g:611:2: iv_ruleAlgorithme= ruleAlgorithme EOF
            {
             newCompositeNode(grammarAccess.getAlgorithmeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAlgorithme=ruleAlgorithme();

            state._fsp--;

             current =iv_ruleAlgorithme; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAlgorithme"


    // $ANTLR start "ruleAlgorithme"
    // InternalTAB.g:617:1: ruleAlgorithme returns [EObject current=null] : (otherlv_0= 'Algorithme' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_entrees_3_0= ruleEntree ) )* ( (lv_sorties_4_0= ruleSortie ) )* ( (lv_documentation_5_0= ruleDocumentation ) )* ( (lv_ressource_6_0= ruleRessource ) )* otherlv_7= '}' ) ;
    public final EObject ruleAlgorithme() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_7=null;
        EObject lv_entrees_3_0 = null;

        EObject lv_sorties_4_0 = null;

        EObject lv_documentation_5_0 = null;

        EObject lv_ressource_6_0 = null;



        	enterRule();

        try {
            // InternalTAB.g:623:2: ( (otherlv_0= 'Algorithme' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_entrees_3_0= ruleEntree ) )* ( (lv_sorties_4_0= ruleSortie ) )* ( (lv_documentation_5_0= ruleDocumentation ) )* ( (lv_ressource_6_0= ruleRessource ) )* otherlv_7= '}' ) )
            // InternalTAB.g:624:2: (otherlv_0= 'Algorithme' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_entrees_3_0= ruleEntree ) )* ( (lv_sorties_4_0= ruleSortie ) )* ( (lv_documentation_5_0= ruleDocumentation ) )* ( (lv_ressource_6_0= ruleRessource ) )* otherlv_7= '}' )
            {
            // InternalTAB.g:624:2: (otherlv_0= 'Algorithme' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_entrees_3_0= ruleEntree ) )* ( (lv_sorties_4_0= ruleSortie ) )* ( (lv_documentation_5_0= ruleDocumentation ) )* ( (lv_ressource_6_0= ruleRessource ) )* otherlv_7= '}' )
            // InternalTAB.g:625:3: otherlv_0= 'Algorithme' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_entrees_3_0= ruleEntree ) )* ( (lv_sorties_4_0= ruleSortie ) )* ( (lv_documentation_5_0= ruleDocumentation ) )* ( (lv_ressource_6_0= ruleRessource ) )* otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,19,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getAlgorithmeAccess().getAlgorithmeKeyword_0());
            		
            // InternalTAB.g:629:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalTAB.g:630:4: (lv_name_1_0= RULE_ID )
            {
            // InternalTAB.g:630:4: (lv_name_1_0= RULE_ID )
            // InternalTAB.g:631:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_4); 

            					newLeafNode(lv_name_1_0, grammarAccess.getAlgorithmeAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAlgorithmeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_12); 

            			newLeafNode(otherlv_2, grammarAccess.getAlgorithmeAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalTAB.g:651:3: ( (lv_entrees_3_0= ruleEntree ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==20) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalTAB.g:652:4: (lv_entrees_3_0= ruleEntree )
            	    {
            	    // InternalTAB.g:652:4: (lv_entrees_3_0= ruleEntree )
            	    // InternalTAB.g:653:5: lv_entrees_3_0= ruleEntree
            	    {

            	    					newCompositeNode(grammarAccess.getAlgorithmeAccess().getEntreesEntreeParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_12);
            	    lv_entrees_3_0=ruleEntree();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getAlgorithmeRule());
            	    					}
            	    					add(
            	    						current,
            	    						"entrees",
            	    						lv_entrees_3_0,
            	    						"org.xtext.TAB.Entree");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            // InternalTAB.g:670:3: ( (lv_sorties_4_0= ruleSortie ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==21) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalTAB.g:671:4: (lv_sorties_4_0= ruleSortie )
            	    {
            	    // InternalTAB.g:671:4: (lv_sorties_4_0= ruleSortie )
            	    // InternalTAB.g:672:5: lv_sorties_4_0= ruleSortie
            	    {

            	    					newCompositeNode(grammarAccess.getAlgorithmeAccess().getSortiesSortieParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_13);
            	    lv_sorties_4_0=ruleSortie();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getAlgorithmeRule());
            	    					}
            	    					add(
            	    						current,
            	    						"sorties",
            	    						lv_sorties_4_0,
            	    						"org.xtext.TAB.Sortie");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            // InternalTAB.g:689:3: ( (lv_documentation_5_0= ruleDocumentation ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==23) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalTAB.g:690:4: (lv_documentation_5_0= ruleDocumentation )
            	    {
            	    // InternalTAB.g:690:4: (lv_documentation_5_0= ruleDocumentation )
            	    // InternalTAB.g:691:5: lv_documentation_5_0= ruleDocumentation
            	    {

            	    					newCompositeNode(grammarAccess.getAlgorithmeAccess().getDocumentationDocumentationParserRuleCall_5_0());
            	    				
            	    pushFollow(FOLLOW_14);
            	    lv_documentation_5_0=ruleDocumentation();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getAlgorithmeRule());
            	    					}
            	    					add(
            	    						current,
            	    						"documentation",
            	    						lv_documentation_5_0,
            	    						"org.xtext.TAB.Documentation");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            // InternalTAB.g:708:3: ( (lv_ressource_6_0= ruleRessource ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==24) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalTAB.g:709:4: (lv_ressource_6_0= ruleRessource )
            	    {
            	    // InternalTAB.g:709:4: (lv_ressource_6_0= ruleRessource )
            	    // InternalTAB.g:710:5: lv_ressource_6_0= ruleRessource
            	    {

            	    					newCompositeNode(grammarAccess.getAlgorithmeAccess().getRessourceRessourceParserRuleCall_6_0());
            	    				
            	    pushFollow(FOLLOW_15);
            	    lv_ressource_6_0=ruleRessource();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getAlgorithmeRule());
            	    					}
            	    					add(
            	    						current,
            	    						"ressource",
            	    						lv_ressource_6_0,
            	    						"org.xtext.TAB.Ressource");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            otherlv_7=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getAlgorithmeAccess().getRightCurlyBracketKeyword_7());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAlgorithme"


    // $ANTLR start "entryRuleEntree"
    // InternalTAB.g:735:1: entryRuleEntree returns [EObject current=null] : iv_ruleEntree= ruleEntree EOF ;
    public final EObject entryRuleEntree() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntree = null;


        try {
            // InternalTAB.g:735:47: (iv_ruleEntree= ruleEntree EOF )
            // InternalTAB.g:736:2: iv_ruleEntree= ruleEntree EOF
            {
             newCompositeNode(grammarAccess.getEntreeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEntree=ruleEntree();

            state._fsp--;

             current =iv_ruleEntree; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEntree"


    // $ANTLR start "ruleEntree"
    // InternalTAB.g:742:1: ruleEntree returns [EObject current=null] : (otherlv_0= 'Entrees' otherlv_1= '{' ( (lv_parametres_2_0= ruleParametre ) )* otherlv_3= '}' ) ;
    public final EObject ruleEntree() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_parametres_2_0 = null;



        	enterRule();

        try {
            // InternalTAB.g:748:2: ( (otherlv_0= 'Entrees' otherlv_1= '{' ( (lv_parametres_2_0= ruleParametre ) )* otherlv_3= '}' ) )
            // InternalTAB.g:749:2: (otherlv_0= 'Entrees' otherlv_1= '{' ( (lv_parametres_2_0= ruleParametre ) )* otherlv_3= '}' )
            {
            // InternalTAB.g:749:2: (otherlv_0= 'Entrees' otherlv_1= '{' ( (lv_parametres_2_0= ruleParametre ) )* otherlv_3= '}' )
            // InternalTAB.g:750:3: otherlv_0= 'Entrees' otherlv_1= '{' ( (lv_parametres_2_0= ruleParametre ) )* otherlv_3= '}'
            {
            otherlv_0=(Token)match(input,20,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getEntreeAccess().getEntreesKeyword_0());
            		
            otherlv_1=(Token)match(input,12,FOLLOW_16); 

            			newLeafNode(otherlv_1, grammarAccess.getEntreeAccess().getLeftCurlyBracketKeyword_1());
            		
            // InternalTAB.g:758:3: ( (lv_parametres_2_0= ruleParametre ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==RULE_ID) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalTAB.g:759:4: (lv_parametres_2_0= ruleParametre )
            	    {
            	    // InternalTAB.g:759:4: (lv_parametres_2_0= ruleParametre )
            	    // InternalTAB.g:760:5: lv_parametres_2_0= ruleParametre
            	    {

            	    					newCompositeNode(grammarAccess.getEntreeAccess().getParametresParametreParserRuleCall_2_0());
            	    				
            	    pushFollow(FOLLOW_16);
            	    lv_parametres_2_0=ruleParametre();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getEntreeRule());
            	    					}
            	    					add(
            	    						current,
            	    						"parametres",
            	    						lv_parametres_2_0,
            	    						"org.xtext.TAB.Parametre");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            otherlv_3=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getEntreeAccess().getRightCurlyBracketKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEntree"


    // $ANTLR start "entryRuleSortie"
    // InternalTAB.g:785:1: entryRuleSortie returns [EObject current=null] : iv_ruleSortie= ruleSortie EOF ;
    public final EObject entryRuleSortie() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSortie = null;


        try {
            // InternalTAB.g:785:47: (iv_ruleSortie= ruleSortie EOF )
            // InternalTAB.g:786:2: iv_ruleSortie= ruleSortie EOF
            {
             newCompositeNode(grammarAccess.getSortieRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSortie=ruleSortie();

            state._fsp--;

             current =iv_ruleSortie; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSortie"


    // $ANTLR start "ruleSortie"
    // InternalTAB.g:792:1: ruleSortie returns [EObject current=null] : (otherlv_0= 'Sorties' otherlv_1= '{' ( (lv_parametres_2_0= ruleParametre ) )* otherlv_3= '}' ) ;
    public final EObject ruleSortie() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_parametres_2_0 = null;



        	enterRule();

        try {
            // InternalTAB.g:798:2: ( (otherlv_0= 'Sorties' otherlv_1= '{' ( (lv_parametres_2_0= ruleParametre ) )* otherlv_3= '}' ) )
            // InternalTAB.g:799:2: (otherlv_0= 'Sorties' otherlv_1= '{' ( (lv_parametres_2_0= ruleParametre ) )* otherlv_3= '}' )
            {
            // InternalTAB.g:799:2: (otherlv_0= 'Sorties' otherlv_1= '{' ( (lv_parametres_2_0= ruleParametre ) )* otherlv_3= '}' )
            // InternalTAB.g:800:3: otherlv_0= 'Sorties' otherlv_1= '{' ( (lv_parametres_2_0= ruleParametre ) )* otherlv_3= '}'
            {
            otherlv_0=(Token)match(input,21,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getSortieAccess().getSortiesKeyword_0());
            		
            otherlv_1=(Token)match(input,12,FOLLOW_16); 

            			newLeafNode(otherlv_1, grammarAccess.getSortieAccess().getLeftCurlyBracketKeyword_1());
            		
            // InternalTAB.g:808:3: ( (lv_parametres_2_0= ruleParametre ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==RULE_ID) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalTAB.g:809:4: (lv_parametres_2_0= ruleParametre )
            	    {
            	    // InternalTAB.g:809:4: (lv_parametres_2_0= ruleParametre )
            	    // InternalTAB.g:810:5: lv_parametres_2_0= ruleParametre
            	    {

            	    					newCompositeNode(grammarAccess.getSortieAccess().getParametresParametreParserRuleCall_2_0());
            	    				
            	    pushFollow(FOLLOW_16);
            	    lv_parametres_2_0=ruleParametre();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getSortieRule());
            	    					}
            	    					add(
            	    						current,
            	    						"parametres",
            	    						lv_parametres_2_0,
            	    						"org.xtext.TAB.Parametre");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            otherlv_3=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getSortieAccess().getRightCurlyBracketKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSortie"


    // $ANTLR start "entryRuleParametre"
    // InternalTAB.g:835:1: entryRuleParametre returns [EObject current=null] : iv_ruleParametre= ruleParametre EOF ;
    public final EObject entryRuleParametre() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParametre = null;


        try {
            // InternalTAB.g:835:50: (iv_ruleParametre= ruleParametre EOF )
            // InternalTAB.g:836:2: iv_ruleParametre= ruleParametre EOF
            {
             newCompositeNode(grammarAccess.getParametreRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleParametre=ruleParametre();

            state._fsp--;

             current =iv_ruleParametre; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParametre"


    // $ANTLR start "ruleParametre"
    // InternalTAB.g:842:1: ruleParametre returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_type_2_0= ruleTypePrimitifPython ) ) ) ;
    public final EObject ruleParametre() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Enumerator lv_type_2_0 = null;



        	enterRule();

        try {
            // InternalTAB.g:848:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_type_2_0= ruleTypePrimitifPython ) ) ) )
            // InternalTAB.g:849:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_type_2_0= ruleTypePrimitifPython ) ) )
            {
            // InternalTAB.g:849:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_type_2_0= ruleTypePrimitifPython ) ) )
            // InternalTAB.g:850:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_type_2_0= ruleTypePrimitifPython ) )
            {
            // InternalTAB.g:850:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalTAB.g:851:4: (lv_name_0_0= RULE_ID )
            {
            // InternalTAB.g:851:4: (lv_name_0_0= RULE_ID )
            // InternalTAB.g:852:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_17); 

            					newLeafNode(lv_name_0_0, grammarAccess.getParametreAccess().getNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getParametreRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_1=(Token)match(input,22,FOLLOW_18); 

            			newLeafNode(otherlv_1, grammarAccess.getParametreAccess().getColonKeyword_1());
            		
            // InternalTAB.g:872:3: ( (lv_type_2_0= ruleTypePrimitifPython ) )
            // InternalTAB.g:873:4: (lv_type_2_0= ruleTypePrimitifPython )
            {
            // InternalTAB.g:873:4: (lv_type_2_0= ruleTypePrimitifPython )
            // InternalTAB.g:874:5: lv_type_2_0= ruleTypePrimitifPython
            {

            					newCompositeNode(grammarAccess.getParametreAccess().getTypeTypePrimitifPythonEnumRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_type_2_0=ruleTypePrimitifPython();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getParametreRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_2_0,
            						"org.xtext.TAB.TypePrimitifPython");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParametre"


    // $ANTLR start "entryRuleDocumentation"
    // InternalTAB.g:895:1: entryRuleDocumentation returns [EObject current=null] : iv_ruleDocumentation= ruleDocumentation EOF ;
    public final EObject entryRuleDocumentation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDocumentation = null;


        try {
            // InternalTAB.g:895:54: (iv_ruleDocumentation= ruleDocumentation EOF )
            // InternalTAB.g:896:2: iv_ruleDocumentation= ruleDocumentation EOF
            {
             newCompositeNode(grammarAccess.getDocumentationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDocumentation=ruleDocumentation();

            state._fsp--;

             current =iv_ruleDocumentation; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDocumentation"


    // $ANTLR start "ruleDocumentation"
    // InternalTAB.g:902:1: ruleDocumentation returns [EObject current=null] : (otherlv_0= 'Documentation' ( (lv_texte_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleDocumentation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_texte_1_0=null;


        	enterRule();

        try {
            // InternalTAB.g:908:2: ( (otherlv_0= 'Documentation' ( (lv_texte_1_0= RULE_STRING ) ) ) )
            // InternalTAB.g:909:2: (otherlv_0= 'Documentation' ( (lv_texte_1_0= RULE_STRING ) ) )
            {
            // InternalTAB.g:909:2: (otherlv_0= 'Documentation' ( (lv_texte_1_0= RULE_STRING ) ) )
            // InternalTAB.g:910:3: otherlv_0= 'Documentation' ( (lv_texte_1_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,23,FOLLOW_19); 

            			newLeafNode(otherlv_0, grammarAccess.getDocumentationAccess().getDocumentationKeyword_0());
            		
            // InternalTAB.g:914:3: ( (lv_texte_1_0= RULE_STRING ) )
            // InternalTAB.g:915:4: (lv_texte_1_0= RULE_STRING )
            {
            // InternalTAB.g:915:4: (lv_texte_1_0= RULE_STRING )
            // InternalTAB.g:916:5: lv_texte_1_0= RULE_STRING
            {
            lv_texte_1_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            					newLeafNode(lv_texte_1_0, grammarAccess.getDocumentationAccess().getTexteSTRINGTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDocumentationRule());
            					}
            					setWithLastConsumed(
            						current,
            						"texte",
            						lv_texte_1_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDocumentation"


    // $ANTLR start "entryRuleRessource"
    // InternalTAB.g:936:1: entryRuleRessource returns [EObject current=null] : iv_ruleRessource= ruleRessource EOF ;
    public final EObject entryRuleRessource() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRessource = null;


        try {
            // InternalTAB.g:936:50: (iv_ruleRessource= ruleRessource EOF )
            // InternalTAB.g:937:2: iv_ruleRessource= ruleRessource EOF
            {
             newCompositeNode(grammarAccess.getRessourceRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRessource=ruleRessource();

            state._fsp--;

             current =iv_ruleRessource; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRessource"


    // $ANTLR start "ruleRessource"
    // InternalTAB.g:943:1: ruleRessource returns [EObject current=null] : (otherlv_0= 'Ressource' ( (lv_chemin_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleRessource() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_chemin_1_0=null;


        	enterRule();

        try {
            // InternalTAB.g:949:2: ( (otherlv_0= 'Ressource' ( (lv_chemin_1_0= RULE_STRING ) ) ) )
            // InternalTAB.g:950:2: (otherlv_0= 'Ressource' ( (lv_chemin_1_0= RULE_STRING ) ) )
            {
            // InternalTAB.g:950:2: (otherlv_0= 'Ressource' ( (lv_chemin_1_0= RULE_STRING ) ) )
            // InternalTAB.g:951:3: otherlv_0= 'Ressource' ( (lv_chemin_1_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,24,FOLLOW_19); 

            			newLeafNode(otherlv_0, grammarAccess.getRessourceAccess().getRessourceKeyword_0());
            		
            // InternalTAB.g:955:3: ( (lv_chemin_1_0= RULE_STRING ) )
            // InternalTAB.g:956:4: (lv_chemin_1_0= RULE_STRING )
            {
            // InternalTAB.g:956:4: (lv_chemin_1_0= RULE_STRING )
            // InternalTAB.g:957:5: lv_chemin_1_0= RULE_STRING
            {
            lv_chemin_1_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            					newLeafNode(lv_chemin_1_0, grammarAccess.getRessourceAccess().getCheminSTRINGTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getRessourceRule());
            					}
            					setWithLastConsumed(
            						current,
            						"chemin",
            						lv_chemin_1_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRessource"


    // $ANTLR start "ruleOperationUnaireType"
    // InternalTAB.g:977:1: ruleOperationUnaireType returns [Enumerator current=null] : (enumLiteral_0= 'Oppose' ) ;
    public final Enumerator ruleOperationUnaireType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;


        	enterRule();

        try {
            // InternalTAB.g:983:2: ( (enumLiteral_0= 'Oppose' ) )
            // InternalTAB.g:984:2: (enumLiteral_0= 'Oppose' )
            {
            // InternalTAB.g:984:2: (enumLiteral_0= 'Oppose' )
            // InternalTAB.g:985:3: enumLiteral_0= 'Oppose'
            {
            enumLiteral_0=(Token)match(input,25,FOLLOW_2); 

            			current = grammarAccess.getOperationUnaireTypeAccess().getOpposeEnumLiteralDeclaration().getEnumLiteral().getInstance();
            			newLeafNode(enumLiteral_0, grammarAccess.getOperationUnaireTypeAccess().getOpposeEnumLiteralDeclaration());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOperationUnaireType"


    // $ANTLR start "ruleOperationBinaireType"
    // InternalTAB.g:994:1: ruleOperationBinaireType returns [Enumerator current=null] : ( (enumLiteral_0= 'Addition' ) | (enumLiteral_1= 'Soustraction' ) | (enumLiteral_2= 'Multiplication' ) | (enumLiteral_3= 'Division' ) ) ;
    public final Enumerator ruleOperationBinaireType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;


        	enterRule();

        try {
            // InternalTAB.g:1000:2: ( ( (enumLiteral_0= 'Addition' ) | (enumLiteral_1= 'Soustraction' ) | (enumLiteral_2= 'Multiplication' ) | (enumLiteral_3= 'Division' ) ) )
            // InternalTAB.g:1001:2: ( (enumLiteral_0= 'Addition' ) | (enumLiteral_1= 'Soustraction' ) | (enumLiteral_2= 'Multiplication' ) | (enumLiteral_3= 'Division' ) )
            {
            // InternalTAB.g:1001:2: ( (enumLiteral_0= 'Addition' ) | (enumLiteral_1= 'Soustraction' ) | (enumLiteral_2= 'Multiplication' ) | (enumLiteral_3= 'Division' ) )
            int alt12=4;
            switch ( input.LA(1) ) {
            case 26:
                {
                alt12=1;
                }
                break;
            case 27:
                {
                alt12=2;
                }
                break;
            case 28:
                {
                alt12=3;
                }
                break;
            case 29:
                {
                alt12=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // InternalTAB.g:1002:3: (enumLiteral_0= 'Addition' )
                    {
                    // InternalTAB.g:1002:3: (enumLiteral_0= 'Addition' )
                    // InternalTAB.g:1003:4: enumLiteral_0= 'Addition'
                    {
                    enumLiteral_0=(Token)match(input,26,FOLLOW_2); 

                    				current = grammarAccess.getOperationBinaireTypeAccess().getAdditionEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getOperationBinaireTypeAccess().getAdditionEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalTAB.g:1010:3: (enumLiteral_1= 'Soustraction' )
                    {
                    // InternalTAB.g:1010:3: (enumLiteral_1= 'Soustraction' )
                    // InternalTAB.g:1011:4: enumLiteral_1= 'Soustraction'
                    {
                    enumLiteral_1=(Token)match(input,27,FOLLOW_2); 

                    				current = grammarAccess.getOperationBinaireTypeAccess().getSoustractionEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getOperationBinaireTypeAccess().getSoustractionEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalTAB.g:1018:3: (enumLiteral_2= 'Multiplication' )
                    {
                    // InternalTAB.g:1018:3: (enumLiteral_2= 'Multiplication' )
                    // InternalTAB.g:1019:4: enumLiteral_2= 'Multiplication'
                    {
                    enumLiteral_2=(Token)match(input,28,FOLLOW_2); 

                    				current = grammarAccess.getOperationBinaireTypeAccess().getMultiplicationEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getOperationBinaireTypeAccess().getMultiplicationEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalTAB.g:1026:3: (enumLiteral_3= 'Division' )
                    {
                    // InternalTAB.g:1026:3: (enumLiteral_3= 'Division' )
                    // InternalTAB.g:1027:4: enumLiteral_3= 'Division'
                    {
                    enumLiteral_3=(Token)match(input,29,FOLLOW_2); 

                    				current = grammarAccess.getOperationBinaireTypeAccess().getDivisionEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getOperationBinaireTypeAccess().getDivisionEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOperationBinaireType"


    // $ANTLR start "ruleTypePrimitifPython"
    // InternalTAB.g:1037:1: ruleTypePrimitifPython returns [Enumerator current=null] : ( (enumLiteral_0= 'int' ) | (enumLiteral_1= 'float' ) | (enumLiteral_2= 'str' ) | (enumLiteral_3= 'bool' ) | (enumLiteral_4= 'list' ) ) ;
    public final Enumerator ruleTypePrimitifPython() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;


        	enterRule();

        try {
            // InternalTAB.g:1043:2: ( ( (enumLiteral_0= 'int' ) | (enumLiteral_1= 'float' ) | (enumLiteral_2= 'str' ) | (enumLiteral_3= 'bool' ) | (enumLiteral_4= 'list' ) ) )
            // InternalTAB.g:1044:2: ( (enumLiteral_0= 'int' ) | (enumLiteral_1= 'float' ) | (enumLiteral_2= 'str' ) | (enumLiteral_3= 'bool' ) | (enumLiteral_4= 'list' ) )
            {
            // InternalTAB.g:1044:2: ( (enumLiteral_0= 'int' ) | (enumLiteral_1= 'float' ) | (enumLiteral_2= 'str' ) | (enumLiteral_3= 'bool' ) | (enumLiteral_4= 'list' ) )
            int alt13=5;
            switch ( input.LA(1) ) {
            case 30:
                {
                alt13=1;
                }
                break;
            case 31:
                {
                alt13=2;
                }
                break;
            case 32:
                {
                alt13=3;
                }
                break;
            case 33:
                {
                alt13=4;
                }
                break;
            case 34:
                {
                alt13=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }

            switch (alt13) {
                case 1 :
                    // InternalTAB.g:1045:3: (enumLiteral_0= 'int' )
                    {
                    // InternalTAB.g:1045:3: (enumLiteral_0= 'int' )
                    // InternalTAB.g:1046:4: enumLiteral_0= 'int'
                    {
                    enumLiteral_0=(Token)match(input,30,FOLLOW_2); 

                    				current = grammarAccess.getTypePrimitifPythonAccess().getIntEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getTypePrimitifPythonAccess().getIntEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalTAB.g:1053:3: (enumLiteral_1= 'float' )
                    {
                    // InternalTAB.g:1053:3: (enumLiteral_1= 'float' )
                    // InternalTAB.g:1054:4: enumLiteral_1= 'float'
                    {
                    enumLiteral_1=(Token)match(input,31,FOLLOW_2); 

                    				current = grammarAccess.getTypePrimitifPythonAccess().getFloatEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getTypePrimitifPythonAccess().getFloatEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalTAB.g:1061:3: (enumLiteral_2= 'str' )
                    {
                    // InternalTAB.g:1061:3: (enumLiteral_2= 'str' )
                    // InternalTAB.g:1062:4: enumLiteral_2= 'str'
                    {
                    enumLiteral_2=(Token)match(input,32,FOLLOW_2); 

                    				current = grammarAccess.getTypePrimitifPythonAccess().getStrEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getTypePrimitifPythonAccess().getStrEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalTAB.g:1069:3: (enumLiteral_3= 'bool' )
                    {
                    // InternalTAB.g:1069:3: (enumLiteral_3= 'bool' )
                    // InternalTAB.g:1070:4: enumLiteral_3= 'bool'
                    {
                    enumLiteral_3=(Token)match(input,33,FOLLOW_2); 

                    				current = grammarAccess.getTypePrimitifPythonAccess().getBoolEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getTypePrimitifPythonAccess().getBoolEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalTAB.g:1077:3: (enumLiteral_4= 'list' )
                    {
                    // InternalTAB.g:1077:3: (enumLiteral_4= 'list' )
                    // InternalTAB.g:1078:4: enumLiteral_4= 'list'
                    {
                    enumLiteral_4=(Token)match(input,34,FOLLOW_2); 

                    				current = grammarAccess.getTypePrimitifPythonAccess().getListEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getTypePrimitifPythonAccess().getListEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTypePrimitifPython"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000048000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x000000003C000000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000032000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000082000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000001B02000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000001A02000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000001802000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000001002000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000002010L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x00000007C0000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000000020L});

}