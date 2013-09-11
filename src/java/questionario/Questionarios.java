/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package questionario;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author francisco
 */
public class Questionarios implements Iterator<Opcao>, Iterable<Opcao> {

    private ArrayList<Questionario> questionarios;
    private Iterator<Questionario> itQuestionarios;
    private Questionario questionarioAtual;
    private Iterator<Opcao> itOpcoes = null;
    private Opcao opcaoAtual;
    private int respostasCertas;

    public Questionarios() {
        respostasCertas = 0;
        questionarios = new ArrayList<>();
        Questionario questionario = new Questionario();
        questionario.setPergunta("De que cor é o cavalo branco de napoleão?");
        questionario.getOpcoes().add(new Opcao("Branco", "branco"));
        questionario.getOpcoes().add(new Opcao("Preto", "preto"));
        questionario.getOpcoes().add(new Opcao("Amarelo", "amarelo"));
        questionario.setRespostaCerta("branco");
        questionarios.add(questionario);

        questionario = new Questionario();
        questionario.setPergunta("De que cor é a caixa negra de um avião");
        questionario.getOpcoes().add(new Opcao("Preta", "preta"));
        questionario.getOpcoes().add(new Opcao("Branca", "branca"));
        questionario.getOpcoes().add(new Opcao("Laranja", "laranja"));
        questionario.setRespostaCerta("laranja");
        questionarios.add(questionario);

        itQuestionarios = questionarios.iterator();
    }

    public boolean isTemMaisQuestionarios() {
        if (questionarios.size() == 0) {
            throw new RuntimeException("Sem perguntas o programa não funciona");
        }
        if (!itQuestionarios.hasNext()) {
            itQuestionarios = questionarios.iterator();
            respostasCertas = 0;
        }
        questionarioAtual = itQuestionarios.next();
        itOpcoes = questionarioAtual.getOpcoes().iterator();
        return true;
    }

    public Opcao getOpcaoAtual() {
        return opcaoAtual;
    }

    @Override
    public boolean hasNext() {
        return itOpcoes.hasNext();
    }

    @Override
    public Opcao next() {
        opcaoAtual = itOpcoes.next();
        return null;
    }

    @Override
    public void remove() {
    }

    @Override
    public Iterator<Opcao> iterator() {
        return itOpcoes;
    }

    public Questionario getQuestionarioAtual() {
        return questionarioAtual;
    }

    public boolean isUltimoQuestionario() {
        return !itQuestionarios.hasNext();
    }

    public boolean eRespostaCerta(String resposta) {
        respostasCertas++;
        return questionarioAtual.getRespostaCerta().equals(resposta);
    }
    
    public int getNumeroDeRespostasCertas(){
        return respostasCertas;
    }
    
    public int getPercentagem(){
        return respostasCertas*100/questionarios.size();
    }
    
    public int getTotalDeRespostas(){
        return questionarios.size();
    }
}
