package ConcreteCommands;
import Command.Command;
import Receiver.EditorDeTexto;

public class ApagarCommand implements Command {
    private EditorDeTexto editor;
    private int numeroCaracteresApagados;
    private String textoApagado;

    public ApagarCommand(EditorDeTexto editor, int numeroCaracteresApagados) {
        this.editor = editor;
        this.numeroCaracteresApagados = numeroCaracteresApagados;
    }

    @Override
    public void execute() {
        int tamanhoAtual = editor.getTexto().length();
        if (tamanhoAtual >= numeroCaracteresApagados) {
            this.textoApagado = editor.getTexto().substring(tamanhoAtual - numeroCaracteresApagados, tamanhoAtual);
        } else {
            this.textoApagado = editor.getTexto().toString();
        }

        editor.apagarUltimosCaracteres(numeroCaracteresApagados);
    }

    @Override
    public void undo() {
        editor.adicionarTexto(textoApagado);
    }
}

