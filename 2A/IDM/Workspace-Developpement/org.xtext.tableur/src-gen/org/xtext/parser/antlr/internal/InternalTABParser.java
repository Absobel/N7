package org.xtext.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'tableur'", "'{'", "'}'", "'table'", "'colonneInput'", "'colonneOutput'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int RULE_INT=5;
    public static final int T__11=11;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;

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
    // InternalTAB.g:64:1: entryRuleTableur returns [EObject current=null] : iv_ruleTableur= ruleTableur EOF ;
    public final EObject entryRuleTableur() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTableur = null;


        try {
            // InternalTAB.g:64:48: (iv_ruleTableur= ruleTableur EOF )
            // InternalTAB.g:65:2: iv_ruleTableur= ruleTableur EOF
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
    // InternalTAB.g:71:1: ruleTableur returns [EObject current=null] : (otherlv_0= 'tableur' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_tables_3_0= ruleTable ) )* otherlv_4= '}' ) ;
    public final EObject ruleTableur() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_tables_3_0 = null;



        	enterRule();

        try {
            // InternalTAB.g:77:2: ( (otherlv_0= 'tableur' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_tables_3_0= ruleTable ) )* otherlv_4= '}' ) )
            // InternalTAB.g:78:2: (otherlv_0= 'tableur' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_tables_3_0= ruleTable ) )* otherlv_4= '}' )
            {
            // InternalTAB.g:78:2: (otherlv_0= 'tableur' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_tables_3_0= ruleTable ) )* otherlv_4= '}' )
            // InternalTAB.g:79:3: otherlv_0= 'tableur' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_tables_3_0= ruleTable ) )* otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,11,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getTableurAccess().getTableurKeyword_0());
            		
            // InternalTAB.g:83:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalTAB.g:84:4: (lv_name_1_0= RULE_ID )
            {
            // InternalTAB.g:84:4: (lv_name_1_0= RULE_ID )
            // InternalTAB.g:85:5: lv_name_1_0= RULE_ID
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
            		
            // InternalTAB.g:105:3: ( (lv_tables_3_0= ruleTable ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==14) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalTAB.g:106:4: (lv_tables_3_0= ruleTable )
            	    {
            	    // InternalTAB.g:106:4: (lv_tables_3_0= ruleTable )
            	    // InternalTAB.g:107:5: lv_tables_3_0= ruleTable
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

            otherlv_4=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getTableurAccess().getRightCurlyBracketKeyword_4());
            		

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
    // InternalTAB.g:132:1: entryRuleColonne returns [EObject current=null] : iv_ruleColonne= ruleColonne EOF ;
    public final EObject entryRuleColonne() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleColonne = null;


        try {
            // InternalTAB.g:132:48: (iv_ruleColonne= ruleColonne EOF )
            // InternalTAB.g:133:2: iv_ruleColonne= ruleColonne EOF
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
    // InternalTAB.g:139:1: ruleColonne returns [EObject current=null] : (this_ColonneInput_0= ruleColonneInput | this_ColonneOutput_1= ruleColonneOutput ) ;
    public final EObject ruleColonne() throws RecognitionException {
        EObject current = null;

        EObject this_ColonneInput_0 = null;

        EObject this_ColonneOutput_1 = null;



        	enterRule();

        try {
            // InternalTAB.g:145:2: ( (this_ColonneInput_0= ruleColonneInput | this_ColonneOutput_1= ruleColonneOutput ) )
            // InternalTAB.g:146:2: (this_ColonneInput_0= ruleColonneInput | this_ColonneOutput_1= ruleColonneOutput )
            {
            // InternalTAB.g:146:2: (this_ColonneInput_0= ruleColonneInput | this_ColonneOutput_1= ruleColonneOutput )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==15) ) {
                alt2=1;
            }
            else if ( (LA2_0==16) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalTAB.g:147:3: this_ColonneInput_0= ruleColonneInput
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
                    // InternalTAB.g:156:3: this_ColonneOutput_1= ruleColonneOutput
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


    // $ANTLR start "entryRuleTable"
    // InternalTAB.g:168:1: entryRuleTable returns [EObject current=null] : iv_ruleTable= ruleTable EOF ;
    public final EObject entryRuleTable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTable = null;


        try {
            // InternalTAB.g:168:46: (iv_ruleTable= ruleTable EOF )
            // InternalTAB.g:169:2: iv_ruleTable= ruleTable EOF
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
    // InternalTAB.g:175:1: ruleTable returns [EObject current=null] : (otherlv_0= 'table' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_colonnes_3_0= ruleColonne ) )* otherlv_4= '}' ) ;
    public final EObject ruleTable() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_colonnes_3_0 = null;



        	enterRule();

        try {
            // InternalTAB.g:181:2: ( (otherlv_0= 'table' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_colonnes_3_0= ruleColonne ) )* otherlv_4= '}' ) )
            // InternalTAB.g:182:2: (otherlv_0= 'table' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_colonnes_3_0= ruleColonne ) )* otherlv_4= '}' )
            {
            // InternalTAB.g:182:2: (otherlv_0= 'table' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_colonnes_3_0= ruleColonne ) )* otherlv_4= '}' )
            // InternalTAB.g:183:3: otherlv_0= 'table' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_colonnes_3_0= ruleColonne ) )* otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,14,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getTableAccess().getTableKeyword_0());
            		
            // InternalTAB.g:187:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalTAB.g:188:4: (lv_name_1_0= RULE_ID )
            {
            // InternalTAB.g:188:4: (lv_name_1_0= RULE_ID )
            // InternalTAB.g:189:5: lv_name_1_0= RULE_ID
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

            otherlv_2=(Token)match(input,12,FOLLOW_6); 

            			newLeafNode(otherlv_2, grammarAccess.getTableAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalTAB.g:209:3: ( (lv_colonnes_3_0= ruleColonne ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>=15 && LA3_0<=16)) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalTAB.g:210:4: (lv_colonnes_3_0= ruleColonne )
            	    {
            	    // InternalTAB.g:210:4: (lv_colonnes_3_0= ruleColonne )
            	    // InternalTAB.g:211:5: lv_colonnes_3_0= ruleColonne
            	    {

            	    					newCompositeNode(grammarAccess.getTableAccess().getColonnesColonneParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_6);
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
    // InternalTAB.g:236:1: entryRuleColonneInput returns [EObject current=null] : iv_ruleColonneInput= ruleColonneInput EOF ;
    public final EObject entryRuleColonneInput() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleColonneInput = null;


        try {
            // InternalTAB.g:236:53: (iv_ruleColonneInput= ruleColonneInput EOF )
            // InternalTAB.g:237:2: iv_ruleColonneInput= ruleColonneInput EOF
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
    // InternalTAB.g:243:1: ruleColonneInput returns [EObject current=null] : (otherlv_0= 'colonneInput' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleColonneInput() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;


        	enterRule();

        try {
            // InternalTAB.g:249:2: ( (otherlv_0= 'colonneInput' ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalTAB.g:250:2: (otherlv_0= 'colonneInput' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalTAB.g:250:2: (otherlv_0= 'colonneInput' ( (lv_name_1_0= RULE_ID ) ) )
            // InternalTAB.g:251:3: otherlv_0= 'colonneInput' ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,15,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getColonneInputAccess().getColonneInputKeyword_0());
            		
            // InternalTAB.g:255:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalTAB.g:256:4: (lv_name_1_0= RULE_ID )
            {
            // InternalTAB.g:256:4: (lv_name_1_0= RULE_ID )
            // InternalTAB.g:257:5: lv_name_1_0= RULE_ID
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
    // InternalTAB.g:277:1: entryRuleColonneOutput returns [EObject current=null] : iv_ruleColonneOutput= ruleColonneOutput EOF ;
    public final EObject entryRuleColonneOutput() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleColonneOutput = null;


        try {
            // InternalTAB.g:277:54: (iv_ruleColonneOutput= ruleColonneOutput EOF )
            // InternalTAB.g:278:2: iv_ruleColonneOutput= ruleColonneOutput EOF
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
    // InternalTAB.g:284:1: ruleColonneOutput returns [EObject current=null] : (otherlv_0= 'colonneOutput' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleColonneOutput() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;


        	enterRule();

        try {
            // InternalTAB.g:290:2: ( (otherlv_0= 'colonneOutput' ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalTAB.g:291:2: (otherlv_0= 'colonneOutput' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalTAB.g:291:2: (otherlv_0= 'colonneOutput' ( (lv_name_1_0= RULE_ID ) ) )
            // InternalTAB.g:292:3: otherlv_0= 'colonneOutput' ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,16,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getColonneOutputAccess().getColonneOutputKeyword_0());
            		
            // InternalTAB.g:296:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalTAB.g:297:4: (lv_name_1_0= RULE_ID )
            {
            // InternalTAB.g:297:4: (lv_name_1_0= RULE_ID )
            // InternalTAB.g:298:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(lv_name_1_0, grammarAccess.getColonneOutputAccess().getNameIDTerminalRuleCall_1_0());
            				

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

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x000000000001A000L});

}