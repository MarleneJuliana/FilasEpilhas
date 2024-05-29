/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.empresatransporte;

import java.util.Stack;
import javax.swing.JOptionPane;

/**
 *
 * @author Marlene Juliana
 */
public class Deposito {


    private Stack<Produto>[] pilhasDeProdutos;

    public Deposito() {
        pilhasDeProdutos = new Stack[5];
        for (int i = 0; i < 5; i++) {
            pilhasDeProdutos[i] = new Stack<>();
        }
    }

    public void adicionarProduto(int indicePilha, Produto produto) {
        if (indicePilha < 0 || indicePilha >= 5) {
            JOptionPane.showMessageDialog(null, "Índice de pilha inválido.");
            return;
        }

        if (pilhasDeProdutos[indicePilha].size() < 10) {
            pilhasDeProdutos[indicePilha].push(produto);
            JOptionPane.showMessageDialog(null, "Produto adicionado à pilha " + (indicePilha + 1) + ":\n" + produto);
        } else {
            JOptionPane.showMessageDialog(null, "A pilha " + (indicePilha + 1) + " está cheia. Não é possível adicionar mais produtos.");
        }
        listarProdutos();
    }

    public void listarProdutos() {
        StringBuilder estadoPilhas = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            estadoPilhas.append("Pilha ").append(i + 1).append(":\n");
            if (pilhasDeProdutos[i].isEmpty()) {
                estadoPilhas.append("  Vazia\n");
            } else {
                for (Produto produto : pilhasDeProdutos[i]) {
                    estadoPilhas.append("  ").append(produto).append("\n");
                }
            }
            estadoPilhas.append("\n");
        }
        JOptionPane.showMessageDialog(null, estadoPilhas.toString());
    }

    public void retirarProduto(int indicePilha) {
        if (indicePilha < 0 || indicePilha >= 5) {
            JOptionPane.showMessageDialog(null, "Índice de pilha inválido.");
            return;
        }

        if (pilhasDeProdutos[indicePilha].isEmpty()) {
            JOptionPane.showMessageDialog(null, "A pilha " + (indicePilha + 1) + " está vazia. Nenhum produto para retirar.");
        } else {
            Produto produtoRemovido = pilhasDeProdutos[indicePilha].pop();
            JOptionPane.showMessageDialog(null, "Produto retirado da pilha " + (indicePilha + 1) + ":\n" + produtoRemovido);
        }
        listarProdutos();
    }
}
