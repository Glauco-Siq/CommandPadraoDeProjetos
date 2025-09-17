package Command;

/* Contrato que define a ação de executar e desfazer
*/

public interface Command {
    public void execute ();
    public void undo ();
}
