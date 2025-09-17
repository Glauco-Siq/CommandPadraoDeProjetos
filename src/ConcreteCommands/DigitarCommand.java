package ConcreteCommands;
import Receiver.EditorDeTexto;
import Command.Command;

/* Empacota a ação especifica, referenciando o editorDeTexto(receiver)
*/

public class DigitarCommand implements Command {
    private EditorDeTexto editor;
    private String textoDigitado;
    public DigitarCommand(EditorDeTexto editor, String textoDigitado) {
        this.editor = editor;
        this.textoDigitado = textoDigitado;
    }
    @Override
    public void execute() {
        editor.adicionarTexto(textoDigitado);
    }
    @Override
    public void undo() {
        editor.apagarUltimosCaracteres(textoDigitado.length());
    }
}

