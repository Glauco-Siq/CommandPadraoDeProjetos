package Invoker;
import java.util.Stack;
import Command.Command;

/*
    Objeto que invoca os comandos, gerenciando tambem o historico, decidindo quando
    executar, desfazer ou refazer uma ação.
 */

    public class GerenciadorDeAcoes {
        private Stack<Command> historicoUndo = new Stack<>();
        private Stack<Command> historicoRedo = new Stack<>();

        public void executar(Command comando) {
            comando.execute();
            historicoUndo.push(comando);
            historicoRedo.clear();
        }
        public void desfazer() {
            if (!historicoUndo.empty()) {
                Command comando = historicoUndo.pop();
                comando.undo();
                historicoRedo.push(comando);
                System.out.println("Ação desfeita.");
            } else {
                System.out.println("Não há mais ações para desfazer.");
            }
        }
        public void refazer() {
            if (!historicoRedo.empty()) {
                Command comando = historicoRedo.pop();
                comando.execute();
                historicoUndo.push(comando);
                System.out.println("Ação refeita.");
            } else {
                System.out.println("Não há mais ações para refazer.");
            }
        }
    }
