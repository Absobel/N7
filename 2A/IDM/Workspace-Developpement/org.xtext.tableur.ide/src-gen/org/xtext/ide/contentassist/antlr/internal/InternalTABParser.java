package org.xtext.ide.contentassist.antlr.internal;

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.DFA;
import org.xtext.services.TABGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalTABParser extends AbstractInternalContentAssistParser {
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

    	public void setGrammarAccess(TABGrammarAccess grammarAccess) {
    		this.grammarAccess = grammarAccess;
    	}

    	@Override
    	protected Grammar getGrammar() {
    		return grammarAccess.getGrammar();
    	}

    	@Override
    	protected String getValueForTokenName(String tokenName) {
    		return tokenName;
    	}



    // $ANTLR start "entryRuleTableur"
    // InternalTAB.g:53:1: entryRuleTableur : ruleTableur EOF ;
    public final void entryRuleTableur() throws RecognitionException {
        try {
            // InternalTAB.g:54:1: ( ruleTableur EOF )
            // InternalTAB.g:55:1: ruleTableur EOF
            {
             before(grammarAccess.getTableurRule()); 
            pushFollow(FOLLOW_1);
            ruleTableur();

            state._fsp--;

             after(grammarAccess.getTableurRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTableur"


    // $ANTLR start "ruleTableur"
    // InternalTAB.g:62:1: ruleTableur : ( ( rule__Tableur__Group__0 ) ) ;
    public final void ruleTableur() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTAB.g:66:2: ( ( ( rule__Tableur__Group__0 ) ) )
            // InternalTAB.g:67:2: ( ( rule__Tableur__Group__0 ) )
            {
            // InternalTAB.g:67:2: ( ( rule__Tableur__Group__0 ) )
            // InternalTAB.g:68:3: ( rule__Tableur__Group__0 )
            {
             before(grammarAccess.getTableurAccess().getGroup()); 
            // InternalTAB.g:69:3: ( rule__Tableur__Group__0 )
            // InternalTAB.g:69:4: rule__Tableur__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Tableur__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTableurAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTableur"


    // $ANTLR start "entryRuleColonne"
    // InternalTAB.g:78:1: entryRuleColonne : ruleColonne EOF ;
    public final void entryRuleColonne() throws RecognitionException {
        try {
            // InternalTAB.g:79:1: ( ruleColonne EOF )
            // InternalTAB.g:80:1: ruleColonne EOF
            {
             before(grammarAccess.getColonneRule()); 
            pushFollow(FOLLOW_1);
            ruleColonne();

            state._fsp--;

             after(grammarAccess.getColonneRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleColonne"


    // $ANTLR start "ruleColonne"
    // InternalTAB.g:87:1: ruleColonne : ( ( rule__Colonne__Alternatives ) ) ;
    public final void ruleColonne() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTAB.g:91:2: ( ( ( rule__Colonne__Alternatives ) ) )
            // InternalTAB.g:92:2: ( ( rule__Colonne__Alternatives ) )
            {
            // InternalTAB.g:92:2: ( ( rule__Colonne__Alternatives ) )
            // InternalTAB.g:93:3: ( rule__Colonne__Alternatives )
            {
             before(grammarAccess.getColonneAccess().getAlternatives()); 
            // InternalTAB.g:94:3: ( rule__Colonne__Alternatives )
            // InternalTAB.g:94:4: rule__Colonne__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Colonne__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getColonneAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleColonne"


    // $ANTLR start "entryRuleTable"
    // InternalTAB.g:103:1: entryRuleTable : ruleTable EOF ;
    public final void entryRuleTable() throws RecognitionException {
        try {
            // InternalTAB.g:104:1: ( ruleTable EOF )
            // InternalTAB.g:105:1: ruleTable EOF
            {
             before(grammarAccess.getTableRule()); 
            pushFollow(FOLLOW_1);
            ruleTable();

            state._fsp--;

             after(grammarAccess.getTableRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTable"


    // $ANTLR start "ruleTable"
    // InternalTAB.g:112:1: ruleTable : ( ( rule__Table__Group__0 ) ) ;
    public final void ruleTable() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTAB.g:116:2: ( ( ( rule__Table__Group__0 ) ) )
            // InternalTAB.g:117:2: ( ( rule__Table__Group__0 ) )
            {
            // InternalTAB.g:117:2: ( ( rule__Table__Group__0 ) )
            // InternalTAB.g:118:3: ( rule__Table__Group__0 )
            {
             before(grammarAccess.getTableAccess().getGroup()); 
            // InternalTAB.g:119:3: ( rule__Table__Group__0 )
            // InternalTAB.g:119:4: rule__Table__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Table__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTableAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTable"


    // $ANTLR start "entryRuleColonneInput"
    // InternalTAB.g:128:1: entryRuleColonneInput : ruleColonneInput EOF ;
    public final void entryRuleColonneInput() throws RecognitionException {
        try {
            // InternalTAB.g:129:1: ( ruleColonneInput EOF )
            // InternalTAB.g:130:1: ruleColonneInput EOF
            {
             before(grammarAccess.getColonneInputRule()); 
            pushFollow(FOLLOW_1);
            ruleColonneInput();

            state._fsp--;

             after(grammarAccess.getColonneInputRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleColonneInput"


    // $ANTLR start "ruleColonneInput"
    // InternalTAB.g:137:1: ruleColonneInput : ( ( rule__ColonneInput__Group__0 ) ) ;
    public final void ruleColonneInput() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTAB.g:141:2: ( ( ( rule__ColonneInput__Group__0 ) ) )
            // InternalTAB.g:142:2: ( ( rule__ColonneInput__Group__0 ) )
            {
            // InternalTAB.g:142:2: ( ( rule__ColonneInput__Group__0 ) )
            // InternalTAB.g:143:3: ( rule__ColonneInput__Group__0 )
            {
             before(grammarAccess.getColonneInputAccess().getGroup()); 
            // InternalTAB.g:144:3: ( rule__ColonneInput__Group__0 )
            // InternalTAB.g:144:4: rule__ColonneInput__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ColonneInput__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getColonneInputAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleColonneInput"


    // $ANTLR start "entryRuleColonneOutput"
    // InternalTAB.g:153:1: entryRuleColonneOutput : ruleColonneOutput EOF ;
    public final void entryRuleColonneOutput() throws RecognitionException {
        try {
            // InternalTAB.g:154:1: ( ruleColonneOutput EOF )
            // InternalTAB.g:155:1: ruleColonneOutput EOF
            {
             before(grammarAccess.getColonneOutputRule()); 
            pushFollow(FOLLOW_1);
            ruleColonneOutput();

            state._fsp--;

             after(grammarAccess.getColonneOutputRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleColonneOutput"


    // $ANTLR start "ruleColonneOutput"
    // InternalTAB.g:162:1: ruleColonneOutput : ( ( rule__ColonneOutput__Group__0 ) ) ;
    public final void ruleColonneOutput() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTAB.g:166:2: ( ( ( rule__ColonneOutput__Group__0 ) ) )
            // InternalTAB.g:167:2: ( ( rule__ColonneOutput__Group__0 ) )
            {
            // InternalTAB.g:167:2: ( ( rule__ColonneOutput__Group__0 ) )
            // InternalTAB.g:168:3: ( rule__ColonneOutput__Group__0 )
            {
             before(grammarAccess.getColonneOutputAccess().getGroup()); 
            // InternalTAB.g:169:3: ( rule__ColonneOutput__Group__0 )
            // InternalTAB.g:169:4: rule__ColonneOutput__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ColonneOutput__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getColonneOutputAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleColonneOutput"


    // $ANTLR start "rule__Colonne__Alternatives"
    // InternalTAB.g:177:1: rule__Colonne__Alternatives : ( ( ruleColonneInput ) | ( ruleColonneOutput ) );
    public final void rule__Colonne__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTAB.g:181:1: ( ( ruleColonneInput ) | ( ruleColonneOutput ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==15) ) {
                alt1=1;
            }
            else if ( (LA1_0==16) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // InternalTAB.g:182:2: ( ruleColonneInput )
                    {
                    // InternalTAB.g:182:2: ( ruleColonneInput )
                    // InternalTAB.g:183:3: ruleColonneInput
                    {
                     before(grammarAccess.getColonneAccess().getColonneInputParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleColonneInput();

                    state._fsp--;

                     after(grammarAccess.getColonneAccess().getColonneInputParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalTAB.g:188:2: ( ruleColonneOutput )
                    {
                    // InternalTAB.g:188:2: ( ruleColonneOutput )
                    // InternalTAB.g:189:3: ruleColonneOutput
                    {
                     before(grammarAccess.getColonneAccess().getColonneOutputParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleColonneOutput();

                    state._fsp--;

                     after(grammarAccess.getColonneAccess().getColonneOutputParserRuleCall_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Colonne__Alternatives"


    // $ANTLR start "rule__Tableur__Group__0"
    // InternalTAB.g:198:1: rule__Tableur__Group__0 : rule__Tableur__Group__0__Impl rule__Tableur__Group__1 ;
    public final void rule__Tableur__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTAB.g:202:1: ( rule__Tableur__Group__0__Impl rule__Tableur__Group__1 )
            // InternalTAB.g:203:2: rule__Tableur__Group__0__Impl rule__Tableur__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__Tableur__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Tableur__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Tableur__Group__0"


    // $ANTLR start "rule__Tableur__Group__0__Impl"
    // InternalTAB.g:210:1: rule__Tableur__Group__0__Impl : ( 'tableur' ) ;
    public final void rule__Tableur__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTAB.g:214:1: ( ( 'tableur' ) )
            // InternalTAB.g:215:1: ( 'tableur' )
            {
            // InternalTAB.g:215:1: ( 'tableur' )
            // InternalTAB.g:216:2: 'tableur'
            {
             before(grammarAccess.getTableurAccess().getTableurKeyword_0()); 
            match(input,11,FOLLOW_2); 
             after(grammarAccess.getTableurAccess().getTableurKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Tableur__Group__0__Impl"


    // $ANTLR start "rule__Tableur__Group__1"
    // InternalTAB.g:225:1: rule__Tableur__Group__1 : rule__Tableur__Group__1__Impl rule__Tableur__Group__2 ;
    public final void rule__Tableur__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTAB.g:229:1: ( rule__Tableur__Group__1__Impl rule__Tableur__Group__2 )
            // InternalTAB.g:230:2: rule__Tableur__Group__1__Impl rule__Tableur__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__Tableur__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Tableur__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Tableur__Group__1"


    // $ANTLR start "rule__Tableur__Group__1__Impl"
    // InternalTAB.g:237:1: rule__Tableur__Group__1__Impl : ( ( rule__Tableur__NameAssignment_1 ) ) ;
    public final void rule__Tableur__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTAB.g:241:1: ( ( ( rule__Tableur__NameAssignment_1 ) ) )
            // InternalTAB.g:242:1: ( ( rule__Tableur__NameAssignment_1 ) )
            {
            // InternalTAB.g:242:1: ( ( rule__Tableur__NameAssignment_1 ) )
            // InternalTAB.g:243:2: ( rule__Tableur__NameAssignment_1 )
            {
             before(grammarAccess.getTableurAccess().getNameAssignment_1()); 
            // InternalTAB.g:244:2: ( rule__Tableur__NameAssignment_1 )
            // InternalTAB.g:244:3: rule__Tableur__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Tableur__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getTableurAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Tableur__Group__1__Impl"


    // $ANTLR start "rule__Tableur__Group__2"
    // InternalTAB.g:252:1: rule__Tableur__Group__2 : rule__Tableur__Group__2__Impl rule__Tableur__Group__3 ;
    public final void rule__Tableur__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTAB.g:256:1: ( rule__Tableur__Group__2__Impl rule__Tableur__Group__3 )
            // InternalTAB.g:257:2: rule__Tableur__Group__2__Impl rule__Tableur__Group__3
            {
            pushFollow(FOLLOW_5);
            rule__Tableur__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Tableur__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Tableur__Group__2"


    // $ANTLR start "rule__Tableur__Group__2__Impl"
    // InternalTAB.g:264:1: rule__Tableur__Group__2__Impl : ( '{' ) ;
    public final void rule__Tableur__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTAB.g:268:1: ( ( '{' ) )
            // InternalTAB.g:269:1: ( '{' )
            {
            // InternalTAB.g:269:1: ( '{' )
            // InternalTAB.g:270:2: '{'
            {
             before(grammarAccess.getTableurAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,12,FOLLOW_2); 
             after(grammarAccess.getTableurAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Tableur__Group__2__Impl"


    // $ANTLR start "rule__Tableur__Group__3"
    // InternalTAB.g:279:1: rule__Tableur__Group__3 : rule__Tableur__Group__3__Impl rule__Tableur__Group__4 ;
    public final void rule__Tableur__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTAB.g:283:1: ( rule__Tableur__Group__3__Impl rule__Tableur__Group__4 )
            // InternalTAB.g:284:2: rule__Tableur__Group__3__Impl rule__Tableur__Group__4
            {
            pushFollow(FOLLOW_5);
            rule__Tableur__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Tableur__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Tableur__Group__3"


    // $ANTLR start "rule__Tableur__Group__3__Impl"
    // InternalTAB.g:291:1: rule__Tableur__Group__3__Impl : ( ( rule__Tableur__TablesAssignment_3 )* ) ;
    public final void rule__Tableur__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTAB.g:295:1: ( ( ( rule__Tableur__TablesAssignment_3 )* ) )
            // InternalTAB.g:296:1: ( ( rule__Tableur__TablesAssignment_3 )* )
            {
            // InternalTAB.g:296:1: ( ( rule__Tableur__TablesAssignment_3 )* )
            // InternalTAB.g:297:2: ( rule__Tableur__TablesAssignment_3 )*
            {
             before(grammarAccess.getTableurAccess().getTablesAssignment_3()); 
            // InternalTAB.g:298:2: ( rule__Tableur__TablesAssignment_3 )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==14) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalTAB.g:298:3: rule__Tableur__TablesAssignment_3
            	    {
            	    pushFollow(FOLLOW_6);
            	    rule__Tableur__TablesAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

             after(grammarAccess.getTableurAccess().getTablesAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Tableur__Group__3__Impl"


    // $ANTLR start "rule__Tableur__Group__4"
    // InternalTAB.g:306:1: rule__Tableur__Group__4 : rule__Tableur__Group__4__Impl ;
    public final void rule__Tableur__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTAB.g:310:1: ( rule__Tableur__Group__4__Impl )
            // InternalTAB.g:311:2: rule__Tableur__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Tableur__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Tableur__Group__4"


    // $ANTLR start "rule__Tableur__Group__4__Impl"
    // InternalTAB.g:317:1: rule__Tableur__Group__4__Impl : ( '}' ) ;
    public final void rule__Tableur__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTAB.g:321:1: ( ( '}' ) )
            // InternalTAB.g:322:1: ( '}' )
            {
            // InternalTAB.g:322:1: ( '}' )
            // InternalTAB.g:323:2: '}'
            {
             before(grammarAccess.getTableurAccess().getRightCurlyBracketKeyword_4()); 
            match(input,13,FOLLOW_2); 
             after(grammarAccess.getTableurAccess().getRightCurlyBracketKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Tableur__Group__4__Impl"


    // $ANTLR start "rule__Table__Group__0"
    // InternalTAB.g:333:1: rule__Table__Group__0 : rule__Table__Group__0__Impl rule__Table__Group__1 ;
    public final void rule__Table__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTAB.g:337:1: ( rule__Table__Group__0__Impl rule__Table__Group__1 )
            // InternalTAB.g:338:2: rule__Table__Group__0__Impl rule__Table__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__Table__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Table__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Table__Group__0"


    // $ANTLR start "rule__Table__Group__0__Impl"
    // InternalTAB.g:345:1: rule__Table__Group__0__Impl : ( 'table' ) ;
    public final void rule__Table__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTAB.g:349:1: ( ( 'table' ) )
            // InternalTAB.g:350:1: ( 'table' )
            {
            // InternalTAB.g:350:1: ( 'table' )
            // InternalTAB.g:351:2: 'table'
            {
             before(grammarAccess.getTableAccess().getTableKeyword_0()); 
            match(input,14,FOLLOW_2); 
             after(grammarAccess.getTableAccess().getTableKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Table__Group__0__Impl"


    // $ANTLR start "rule__Table__Group__1"
    // InternalTAB.g:360:1: rule__Table__Group__1 : rule__Table__Group__1__Impl rule__Table__Group__2 ;
    public final void rule__Table__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTAB.g:364:1: ( rule__Table__Group__1__Impl rule__Table__Group__2 )
            // InternalTAB.g:365:2: rule__Table__Group__1__Impl rule__Table__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__Table__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Table__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Table__Group__1"


    // $ANTLR start "rule__Table__Group__1__Impl"
    // InternalTAB.g:372:1: rule__Table__Group__1__Impl : ( ( rule__Table__NameAssignment_1 ) ) ;
    public final void rule__Table__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTAB.g:376:1: ( ( ( rule__Table__NameAssignment_1 ) ) )
            // InternalTAB.g:377:1: ( ( rule__Table__NameAssignment_1 ) )
            {
            // InternalTAB.g:377:1: ( ( rule__Table__NameAssignment_1 ) )
            // InternalTAB.g:378:2: ( rule__Table__NameAssignment_1 )
            {
             before(grammarAccess.getTableAccess().getNameAssignment_1()); 
            // InternalTAB.g:379:2: ( rule__Table__NameAssignment_1 )
            // InternalTAB.g:379:3: rule__Table__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Table__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getTableAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Table__Group__1__Impl"


    // $ANTLR start "rule__Table__Group__2"
    // InternalTAB.g:387:1: rule__Table__Group__2 : rule__Table__Group__2__Impl rule__Table__Group__3 ;
    public final void rule__Table__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTAB.g:391:1: ( rule__Table__Group__2__Impl rule__Table__Group__3 )
            // InternalTAB.g:392:2: rule__Table__Group__2__Impl rule__Table__Group__3
            {
            pushFollow(FOLLOW_7);
            rule__Table__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Table__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Table__Group__2"


    // $ANTLR start "rule__Table__Group__2__Impl"
    // InternalTAB.g:399:1: rule__Table__Group__2__Impl : ( '{' ) ;
    public final void rule__Table__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTAB.g:403:1: ( ( '{' ) )
            // InternalTAB.g:404:1: ( '{' )
            {
            // InternalTAB.g:404:1: ( '{' )
            // InternalTAB.g:405:2: '{'
            {
             before(grammarAccess.getTableAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,12,FOLLOW_2); 
             after(grammarAccess.getTableAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Table__Group__2__Impl"


    // $ANTLR start "rule__Table__Group__3"
    // InternalTAB.g:414:1: rule__Table__Group__3 : rule__Table__Group__3__Impl rule__Table__Group__4 ;
    public final void rule__Table__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTAB.g:418:1: ( rule__Table__Group__3__Impl rule__Table__Group__4 )
            // InternalTAB.g:419:2: rule__Table__Group__3__Impl rule__Table__Group__4
            {
            pushFollow(FOLLOW_7);
            rule__Table__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Table__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Table__Group__3"


    // $ANTLR start "rule__Table__Group__3__Impl"
    // InternalTAB.g:426:1: rule__Table__Group__3__Impl : ( ( rule__Table__ColonnesAssignment_3 )* ) ;
    public final void rule__Table__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTAB.g:430:1: ( ( ( rule__Table__ColonnesAssignment_3 )* ) )
            // InternalTAB.g:431:1: ( ( rule__Table__ColonnesAssignment_3 )* )
            {
            // InternalTAB.g:431:1: ( ( rule__Table__ColonnesAssignment_3 )* )
            // InternalTAB.g:432:2: ( rule__Table__ColonnesAssignment_3 )*
            {
             before(grammarAccess.getTableAccess().getColonnesAssignment_3()); 
            // InternalTAB.g:433:2: ( rule__Table__ColonnesAssignment_3 )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>=15 && LA3_0<=16)) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalTAB.g:433:3: rule__Table__ColonnesAssignment_3
            	    {
            	    pushFollow(FOLLOW_8);
            	    rule__Table__ColonnesAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

             after(grammarAccess.getTableAccess().getColonnesAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Table__Group__3__Impl"


    // $ANTLR start "rule__Table__Group__4"
    // InternalTAB.g:441:1: rule__Table__Group__4 : rule__Table__Group__4__Impl ;
    public final void rule__Table__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTAB.g:445:1: ( rule__Table__Group__4__Impl )
            // InternalTAB.g:446:2: rule__Table__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Table__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Table__Group__4"


    // $ANTLR start "rule__Table__Group__4__Impl"
    // InternalTAB.g:452:1: rule__Table__Group__4__Impl : ( '}' ) ;
    public final void rule__Table__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTAB.g:456:1: ( ( '}' ) )
            // InternalTAB.g:457:1: ( '}' )
            {
            // InternalTAB.g:457:1: ( '}' )
            // InternalTAB.g:458:2: '}'
            {
             before(grammarAccess.getTableAccess().getRightCurlyBracketKeyword_4()); 
            match(input,13,FOLLOW_2); 
             after(grammarAccess.getTableAccess().getRightCurlyBracketKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Table__Group__4__Impl"


    // $ANTLR start "rule__ColonneInput__Group__0"
    // InternalTAB.g:468:1: rule__ColonneInput__Group__0 : rule__ColonneInput__Group__0__Impl rule__ColonneInput__Group__1 ;
    public final void rule__ColonneInput__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTAB.g:472:1: ( rule__ColonneInput__Group__0__Impl rule__ColonneInput__Group__1 )
            // InternalTAB.g:473:2: rule__ColonneInput__Group__0__Impl rule__ColonneInput__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__ColonneInput__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ColonneInput__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ColonneInput__Group__0"


    // $ANTLR start "rule__ColonneInput__Group__0__Impl"
    // InternalTAB.g:480:1: rule__ColonneInput__Group__0__Impl : ( 'colonneInput' ) ;
    public final void rule__ColonneInput__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTAB.g:484:1: ( ( 'colonneInput' ) )
            // InternalTAB.g:485:1: ( 'colonneInput' )
            {
            // InternalTAB.g:485:1: ( 'colonneInput' )
            // InternalTAB.g:486:2: 'colonneInput'
            {
             before(grammarAccess.getColonneInputAccess().getColonneInputKeyword_0()); 
            match(input,15,FOLLOW_2); 
             after(grammarAccess.getColonneInputAccess().getColonneInputKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ColonneInput__Group__0__Impl"


    // $ANTLR start "rule__ColonneInput__Group__1"
    // InternalTAB.g:495:1: rule__ColonneInput__Group__1 : rule__ColonneInput__Group__1__Impl ;
    public final void rule__ColonneInput__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTAB.g:499:1: ( rule__ColonneInput__Group__1__Impl )
            // InternalTAB.g:500:2: rule__ColonneInput__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ColonneInput__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ColonneInput__Group__1"


    // $ANTLR start "rule__ColonneInput__Group__1__Impl"
    // InternalTAB.g:506:1: rule__ColonneInput__Group__1__Impl : ( ( rule__ColonneInput__NameAssignment_1 ) ) ;
    public final void rule__ColonneInput__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTAB.g:510:1: ( ( ( rule__ColonneInput__NameAssignment_1 ) ) )
            // InternalTAB.g:511:1: ( ( rule__ColonneInput__NameAssignment_1 ) )
            {
            // InternalTAB.g:511:1: ( ( rule__ColonneInput__NameAssignment_1 ) )
            // InternalTAB.g:512:2: ( rule__ColonneInput__NameAssignment_1 )
            {
             before(grammarAccess.getColonneInputAccess().getNameAssignment_1()); 
            // InternalTAB.g:513:2: ( rule__ColonneInput__NameAssignment_1 )
            // InternalTAB.g:513:3: rule__ColonneInput__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__ColonneInput__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getColonneInputAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ColonneInput__Group__1__Impl"


    // $ANTLR start "rule__ColonneOutput__Group__0"
    // InternalTAB.g:522:1: rule__ColonneOutput__Group__0 : rule__ColonneOutput__Group__0__Impl rule__ColonneOutput__Group__1 ;
    public final void rule__ColonneOutput__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTAB.g:526:1: ( rule__ColonneOutput__Group__0__Impl rule__ColonneOutput__Group__1 )
            // InternalTAB.g:527:2: rule__ColonneOutput__Group__0__Impl rule__ColonneOutput__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__ColonneOutput__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ColonneOutput__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ColonneOutput__Group__0"


    // $ANTLR start "rule__ColonneOutput__Group__0__Impl"
    // InternalTAB.g:534:1: rule__ColonneOutput__Group__0__Impl : ( 'colonneOutput' ) ;
    public final void rule__ColonneOutput__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTAB.g:538:1: ( ( 'colonneOutput' ) )
            // InternalTAB.g:539:1: ( 'colonneOutput' )
            {
            // InternalTAB.g:539:1: ( 'colonneOutput' )
            // InternalTAB.g:540:2: 'colonneOutput'
            {
             before(grammarAccess.getColonneOutputAccess().getColonneOutputKeyword_0()); 
            match(input,16,FOLLOW_2); 
             after(grammarAccess.getColonneOutputAccess().getColonneOutputKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ColonneOutput__Group__0__Impl"


    // $ANTLR start "rule__ColonneOutput__Group__1"
    // InternalTAB.g:549:1: rule__ColonneOutput__Group__1 : rule__ColonneOutput__Group__1__Impl ;
    public final void rule__ColonneOutput__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTAB.g:553:1: ( rule__ColonneOutput__Group__1__Impl )
            // InternalTAB.g:554:2: rule__ColonneOutput__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ColonneOutput__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ColonneOutput__Group__1"


    // $ANTLR start "rule__ColonneOutput__Group__1__Impl"
    // InternalTAB.g:560:1: rule__ColonneOutput__Group__1__Impl : ( ( rule__ColonneOutput__NameAssignment_1 ) ) ;
    public final void rule__ColonneOutput__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTAB.g:564:1: ( ( ( rule__ColonneOutput__NameAssignment_1 ) ) )
            // InternalTAB.g:565:1: ( ( rule__ColonneOutput__NameAssignment_1 ) )
            {
            // InternalTAB.g:565:1: ( ( rule__ColonneOutput__NameAssignment_1 ) )
            // InternalTAB.g:566:2: ( rule__ColonneOutput__NameAssignment_1 )
            {
             before(grammarAccess.getColonneOutputAccess().getNameAssignment_1()); 
            // InternalTAB.g:567:2: ( rule__ColonneOutput__NameAssignment_1 )
            // InternalTAB.g:567:3: rule__ColonneOutput__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__ColonneOutput__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getColonneOutputAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ColonneOutput__Group__1__Impl"


    // $ANTLR start "rule__Tableur__NameAssignment_1"
    // InternalTAB.g:576:1: rule__Tableur__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Tableur__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTAB.g:580:1: ( ( RULE_ID ) )
            // InternalTAB.g:581:2: ( RULE_ID )
            {
            // InternalTAB.g:581:2: ( RULE_ID )
            // InternalTAB.g:582:3: RULE_ID
            {
             before(grammarAccess.getTableurAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getTableurAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Tableur__NameAssignment_1"


    // $ANTLR start "rule__Tableur__TablesAssignment_3"
    // InternalTAB.g:591:1: rule__Tableur__TablesAssignment_3 : ( ruleTable ) ;
    public final void rule__Tableur__TablesAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTAB.g:595:1: ( ( ruleTable ) )
            // InternalTAB.g:596:2: ( ruleTable )
            {
            // InternalTAB.g:596:2: ( ruleTable )
            // InternalTAB.g:597:3: ruleTable
            {
             before(grammarAccess.getTableurAccess().getTablesTableParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleTable();

            state._fsp--;

             after(grammarAccess.getTableurAccess().getTablesTableParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Tableur__TablesAssignment_3"


    // $ANTLR start "rule__Table__NameAssignment_1"
    // InternalTAB.g:606:1: rule__Table__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Table__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTAB.g:610:1: ( ( RULE_ID ) )
            // InternalTAB.g:611:2: ( RULE_ID )
            {
            // InternalTAB.g:611:2: ( RULE_ID )
            // InternalTAB.g:612:3: RULE_ID
            {
             before(grammarAccess.getTableAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getTableAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Table__NameAssignment_1"


    // $ANTLR start "rule__Table__ColonnesAssignment_3"
    // InternalTAB.g:621:1: rule__Table__ColonnesAssignment_3 : ( ruleColonne ) ;
    public final void rule__Table__ColonnesAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTAB.g:625:1: ( ( ruleColonne ) )
            // InternalTAB.g:626:2: ( ruleColonne )
            {
            // InternalTAB.g:626:2: ( ruleColonne )
            // InternalTAB.g:627:3: ruleColonne
            {
             before(grammarAccess.getTableAccess().getColonnesColonneParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleColonne();

            state._fsp--;

             after(grammarAccess.getTableAccess().getColonnesColonneParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Table__ColonnesAssignment_3"


    // $ANTLR start "rule__ColonneInput__NameAssignment_1"
    // InternalTAB.g:636:1: rule__ColonneInput__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__ColonneInput__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTAB.g:640:1: ( ( RULE_ID ) )
            // InternalTAB.g:641:2: ( RULE_ID )
            {
            // InternalTAB.g:641:2: ( RULE_ID )
            // InternalTAB.g:642:3: RULE_ID
            {
             before(grammarAccess.getColonneInputAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getColonneInputAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ColonneInput__NameAssignment_1"


    // $ANTLR start "rule__ColonneOutput__NameAssignment_1"
    // InternalTAB.g:651:1: rule__ColonneOutput__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__ColonneOutput__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTAB.g:655:1: ( ( RULE_ID ) )
            // InternalTAB.g:656:2: ( RULE_ID )
            {
            // InternalTAB.g:656:2: ( RULE_ID )
            // InternalTAB.g:657:3: RULE_ID
            {
             before(grammarAccess.getColonneOutputAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getColonneOutputAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ColonneOutput__NameAssignment_1"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x000000000001A000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000018002L});

}