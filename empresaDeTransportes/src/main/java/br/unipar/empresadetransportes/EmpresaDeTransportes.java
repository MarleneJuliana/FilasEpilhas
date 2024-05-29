/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.unipar.empresadetransportes;
import javax.swing.JOptionPane;
import java.util.Stack;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author Marlene Juliana
 */
public class EmpresaDeTransportes {
    public static void main(String[] args) {
        Deposito deposito = new Deposito();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        int opcao = 0;

        do {
            String input = JOptionPane.showInputDialog(
                    null,
                    "Menu:\n1. Adicionar produto\n2. Listar produtos\n3. Retirar produto\n4. Sair\nEscolha uma opção:",
                    "Sistema de Depósito",
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
                        try {
                            int codProduto = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o código do produto:", "Adicionar Produto", JOptionPane.QUESTION_MESSAGE));
                            String descricao = JOptionPane.showInputDialog(null, "Digite a descrição do produto:", "Adicionar Produto", JOptionPane.QUESTION_MESSAGE);
                            String dataEntradaStr = JOptionPane.showInputDialog(null, "Digite a data de entrada (dd/MM/yyyy):", "Adicionar Produto", JOptionPane.QUESTION_MESSAGE);
                            Date dataEntrada = sdf.parse(dataEntradaStr);
                            String ufOrigem = JOptionPane.showInputDialog(null, "Digite a UF de origem:", "Adicionar Produto", JOptionPane.QUESTION_MESSAGE);
                            String ufDestino = JOptionPane.showInputDialog(null, "Digite a UF de destino:", "Adicionar Produto", JOptionPane.QUESTION_MESSAGE);

                            Produto produto = new Produto(codProduto, descricao, dataEntrada, ufOrigem, ufDestino);
                            deposito.adicionarProduto(produto);
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "Erro ao adicionar produto. Verifique os dados e tente novamente.");
                        }
                        break;
                    case 2:
                        deposito.listarProdutos();
                        break;
                    case 3:
                        deposito.retirarProduto();
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

