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


    private Stack<Produto>[] pilhasProduto;

    public Deposito() {
        pilhasProduto = new Stack[5]; //Um array de pilhas (Stack) que armazenará os produtos
        for (int i = 0; i < 5; i++) {
            pilhasProduto[i] = new Stack<>();
        }
    }

    public void adicionarProduto(int indicePilha, Produto produto) {
        if (indicePilha < 0 || indicePilha >= 5) {
            JOptionPane.showMessageDialog(null, "Índice de pilha inválido.");
            return;
        }

        if (pilhasProduto[indicePilha].size() < 10) {
            pilhasProduto[indicePilha].push(produto); //PUSH: insere um elemento no topo da pilha se não estiver cheio
            JOptionPane.showMessageDialog(null, "Produto adicionado à pilha " + (indicePilha + 1) + ":\n" + produto);
        } else {
            JOptionPane.showMessageDialog(null, "A pilha " + (indicePilha + 1) + " está cheia. Não é possível adicionar mais produtos.");
        }
        listarProdutos();
    }

    public void listarProdutos() {
        StringBuilder estadoPilhas = new StringBuilder(); //Usei um StringBuilder para montar uma string que representa o estado de cada pilha.
        for (int i = 0; i < 5; i++) {
            estadoPilhas.append("Pilha ").append(i + 1).append(":\n");
            if (pilhasProduto[i].isEmpty()) {
                estadoPilhas.append("  Vazia\n");
            } else {
                for (Produto produto : pilhasProduto[i]) {
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

        if (pilhasProduto[indicePilha].isEmpty()) {
            JOptionPane.showMessageDialog(null, "A pilha " + (indicePilha + 1) + " está vazia. Nenhum produto para retirar.");
        } else {
            Produto produtoRemovido = pilhasProduto[indicePilha].pop(); //POP: remove um elemento no topo da pilha;
            JOptionPane.showMessageDialog(null, "Produto retirado da pilha " + (indicePilha + 1) + ":\n" + produtoRemovido);
        }
        listarProdutos();
    }
}
