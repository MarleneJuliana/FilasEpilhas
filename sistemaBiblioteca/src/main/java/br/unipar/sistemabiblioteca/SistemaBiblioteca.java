/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.unipar.sistemabiblioteca;
import javax.swing.JOptionPane;
import java.util.Stack;
/**
 * @author Marlene Juliana
 */
public class SistemaBiblioteca {

    private Stack<String> pilhaLivros;

    public SistemaBiblioteca() {
        pilhaLivros = new Stack<>();
    }
    //método para adicionar o livro a pilha
    public void adicionarLivro(String livro) {
        pilhaLivros.push(livro);
        JOptionPane.showMessageDialog(null, "Livro \"" + livro + "\" adicionado à pilha.");      
    }
    //método para listar os livros da pilha
    public void listarLivros() {
        if (pilhaLivros.isEmpty()) {
            JOptionPane.showMessageDialog(null,"A pilha de livros está vazia.");
        }else {
            StringBuilder livros = new StringBuilder("Livros na pilha:\n");
            for (String livro : pilhaLivros) {
                livros.append(livro).append("\n");
            }
            JOptionPane.showMessageDialog(null, livros.toString());
        }
    }
    //método para retirar o livro da pilha
    public void retirarLivro() {
        if (pilhaLivros.isEmpty()) {
            JOptionPane.showMessageDialog(null,"A pilha de livros está vazia. Nenhum livro para retirar.");
        } else {
            String livroRemovido = pilhaLivros.pop();
            JOptionPane.showMessageDialog(null,"Livro \"" + livroRemovido + "\" removido da pilha.");
        }
    }

    public static void main(String[] args) {
        SistemaBiblioteca biblioteca = new SistemaBiblioteca();
        int opcao = 0;

        do {
            String input = JOptionPane.showInputDialog(
                    null,
                    "Menu:\n1. Adicionar livro\n2. Listar livros\n3. Retirar livro\n4. Sair\nEscolha uma opção:",
                    "Sistema Biblioteca",
                    JOptionPane.QUESTION_MESSAGE
            );
            if (input == null) {
                opcao = 4; // Caso o usuário cancele ou feche o diálogo, saímos do loop
            } else {
                try {
                    opcao = Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente.");
                    continue;
                }

            switch (opcao) {
                    case 1:
                        String livro = JOptionPane.showInputDialog(
                                null,
                                "Digite o nome do livro:",
                                "Adicionar Livro",
                                JOptionPane.QUESTION_MESSAGE
                        );
                        if (livro != null && !livro.trim().isEmpty()) {
                            biblioteca.adicionarLivro(livro.trim());
                        } else {
                            JOptionPane.showMessageDialog(null, "Nome do livro inválido.");
                        }
                        break;
                case 2:
                        biblioteca.listarLivros();
                        break;
                    case 3:
                        biblioteca.retirarLivro();
                        break;
                    case 4:
                        JOptionPane.showMessageDialog(null, "Saindo...");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente.");
                }
            }
        } while (opcao != 4);
    }
}
