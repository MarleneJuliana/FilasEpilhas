/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.empresadetransportes;

import java.util.Stack;
import javax.swing.JOptionPane;

/**
 *
 * @author Marlene Juliana
 */
public class Deposito {

    private Stack<Produto> pilhaDeProdutos;

    public Deposito() {
        pilhaDeProdutos = new Stack<>();
    }

    public void adicionarProduto(Produto produto) {
        if (pilhaDeProdutos.size() < 10) {
            pilhaDeProdutos.push(produto);
            JOptionPane.showMessageDialog(null, "Produto adicionado à pilha:\n" + produto);
        } else {
            JOptionPane.showMessageDialog(null, "A pilha de produtos está cheia. Não é possível adicionar mais produtos.");
        }
        listarProdutos();
    }

    public void listarProdutos() {
        if (pilhaDeProdutos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "A pilha de produtos está vazia.");
        } else {
            StringBuilder produtos = new StringBuilder("Produtos na pilha:\n");
            for (Produto produto : pilhaDeProdutos) {
                produtos.append(produto).append("\n");
            }
            JOptionPane.showMessageDialog(null, produtos.toString());
        }
    }

    public void retirarProduto() {
        if (pilhaDeProdutos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "A pilha de produtos está vazia. Nenhum produto para retirar.");
        } else {
            Produto produtoRemovido = pilhaDeProdutos.pop();
            JOptionPane.showMessageDialog(null, "Produto retirado da pilha:\n" + produtoRemovido);
        }
        listarProdutos();
    }
  
}
