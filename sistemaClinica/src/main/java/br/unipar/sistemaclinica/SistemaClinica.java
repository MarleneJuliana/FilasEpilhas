/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.unipar.sistemaclinica;
import java.util.LinkedList;
import java.util.Queue;
import javax.swing.JOptionPane;
/**
 *
 * @author Marlene Juliana
 */


public class SistemaClinica {
    private static final int MAX_PATIENTS = 20; //Declaração de uma constante
    private Queue<Pacientes> filaPacientes = new LinkedList<>(); //Uma fila (Queue) que armazena os pacientes
    private int proximaSenha = 1;

    public static void main(String[] args) {
        SistemaClinica clinica = new SistemaClinica();
        clinica.menu();
    }
    //Exibe o menu das opções para adicionar pacientes, chamar o próximo paciente ou sair.
    public void menu() {
        int opcao;
        
        //garante que o bloco de código dentro dele seja executado pelo menos uma vez 
        do {
            String[] options = {"Adicionar paciente", "Chamar próximo paciente", "Sair"};
            opcao = JOptionPane.showOptionDialog( //'showOptionDialog' retorna um int q representa o botão clicado pelo usuário
                 null, "Escolha uma opção a seguir:", 
                "Menu Clinica", 
                JOptionPane.DEFAULT_OPTION, //especifica o tipo de opções, e não tera nenhuma opção adicional
                JOptionPane.INFORMATION_MESSAGE, null, //ícone a ser exibido na janela de diálogo. 
                options, //define os textos dos botões
                options[0]
            );

            switch (opcao) {
                case 0:
                    adicionarPaciente();
                    break;
                case 1:
                    chamarProximoPaciente();
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Encerrando o sistema.");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente.");
            }
        } while (opcao != 2);
    }

    private void adicionarPaciente() {
    //Verificar Capacidade da Fila
    if (filaPacientes.size() >= MAX_PATIENTS) {
        JOptionPane.showMessageDialog(null, "A fila está cheia. Não é possível adicionar mais pacientes hoje.");
        return;
    }

    String nome = JOptionPane.showInputDialog("Digite o nome do paciente:");
        //isEmpty verifica se a fila de pacientes está vazia
        if (nome != null && !nome.trim().isEmpty()) {
        // Verifica se o nome contém apenas letras
        if (nome.matches("[a-zA-Z\\s]+")) {
            Pacientes pacientes = new Pacientes(nome, proximaSenha++);
            filaPacientes.add(pacientes);
            JOptionPane.showMessageDialog(null, "Paciente " + nome + " adicionado à fila com a senha " + pacientes.getSenha() + ".");
        } else {
            JOptionPane.showMessageDialog(null, "Nome inválido. O nome deve conter apenas letras. Tente novamente.");
        }
        } else {
        JOptionPane.showMessageDialog(null, "Nome inválido. Tente novamente.");
        }
    }


    private void chamarProximoPaciente() {
        if (filaPacientes.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não há pacientes na fila.");
        } else {
            Pacientes proximoPaciente = filaPacientes.poll();
            JOptionPane.showMessageDialog(null, "Próximo paciente: " + proximoPaciente.getNome() + ", Senha: " + proximoPaciente.getSenha());
        }
    }
}
