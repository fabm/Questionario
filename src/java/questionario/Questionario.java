package questionario;

import java.util.ArrayList;

public class Questionario {
    private ArrayList<Opcao> opcoes = new ArrayList<>();
    private String respostaCerta;
    private String pergunta;

    public String getRespostaCerta() {
        return respostaCerta;
    }

    public void setRespostaCerta(String respostaCerta) {
        this.respostaCerta = respostaCerta;
    }

    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }
   
    
    public ArrayList<Opcao> getOpcoes() {
        return opcoes;
    }
    
}
