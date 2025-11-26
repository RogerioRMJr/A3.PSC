package Model;

// Classe simples para tratar erros de validação
public class Mensagens extends Exception {
    
    public Mensagens(String msg) {
        super(msg);
    }
}