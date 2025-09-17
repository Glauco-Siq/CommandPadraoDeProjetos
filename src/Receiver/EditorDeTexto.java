package Receiver;
/* Contem a logica de negocio real e o estado do sistema (texto).
   Recebe ordens para executar a acao
*/
public class EditorDeTexto {
    private StringBuilder texto = new StringBuilder();
    public void adicionarTexto(String texto) {
        this.texto.append(texto);
        System.out.println("Texto atual: " + this.texto);
    }
    public void apagarUltimosCaracteres(int numeroDeCaracteres) {
        int tamanhoAtual = this.texto.length();
        if (tamanhoAtual >= numeroDeCaracteres) {
            this.texto.delete(tamanhoAtual - numeroDeCaracteres, tamanhoAtual);
            System.out.println("Texto atual: " + this.texto);
        } else {System.out.println("Não há caracteres suficientes para apagar.");}
    } public StringBuilder getTexto() {
        return texto;
    }
}

