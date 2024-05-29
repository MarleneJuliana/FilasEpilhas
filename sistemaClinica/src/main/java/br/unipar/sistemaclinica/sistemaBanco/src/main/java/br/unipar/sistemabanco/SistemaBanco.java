/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.unipar.sistemabanco;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;
import javax.swing.JOptionPane;

public class SistemaBanco {
    private Queue<Cliente> filaPrioritaria = new LinkedList<>();
    private Queue<Cliente> filaNormal = new LinkedList<>();
    private int proximaSenha = 1;

    public static void main(String[] args) {
        SistemaBanco banco = new SistemaBanco();
        banco.menu();
    }

    public void menu() {
        int opcao;

        do {
            String[] options = {"Adicionar cliente", "Chamar próximo cliente", "Sair"};
            opcao = JOptionPane.showOptionDialog(
                null, 
                "Escolha uma opção:", 
                "Menu", 
                JOptionPane.DEFAULT_OPTION, 
                JOptionPane.INFORMATION_MESSAGE, 
                null, 
                options, 
                options[0]
            );

            switch (opcao) {
                case 0:
                    adicionarCliente();
                    break;
                case 1:
                    chamarProximoCliente();
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Encerrando o sistema.");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente.");
            }
        } while (opcao != 2);
    }

    private void adicionarCliente() {
        String nome = JOptionPane.showInputDialog("Digite o nome do cliente:");
        String dataNascimento = JOptionPane.showInputDialog("Digite a data de nascimento do cliente (no formato dd/MM/yyyy):");

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date data = sdf.parse(dataNascimento);

            Cliente cliente = new Cliente(proximaSenha++, nome, data);
            if (cliente.isPrioritario()) {
                filaPrioritaria.add(cliente);
            } else {
                filaNormal.add(cliente);
            }
            JOptionPane.showMessageDialog(null, "Cliente " + nome + " adicionado à fila com senha " + cliente.getSenha() + ".");
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Formato de data inválido. Use o formato dd/MM/yyyy. Tente novamente.");
        }
    }

    private void chamarProximoCliente() {
        if (!filaPrioritaria.isEmpty()) {
            atenderCliente(filaPrioritaria.poll());
        } else if (!filaNormal.isEmpty()) {
            atenderCliente(filaNormal.poll());
        } else {
            JOptionPane.showMessageDialog(null, "Não há clientes na fila.");
        }
    }

    private void atenderCliente(Cliente cliente) {
        JOptionPane.showMessageDialog(null, "Próximo cliente a ser atendido: " + cliente.getNome() + ", Senha: " + cliente.getSenha());
    }

}
