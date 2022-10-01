/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Listas;

import Listas.Lista;
import java.util.Scanner;

/**
 *
 * @author gusta
 */
public class Atividade {

    public static void main(String[] args) throws EmptyListException {
        int valorInsereir;
        int saida = 1;
        
        
        
        while (saida != 0) {
            saida = menu();
            switch (saida) {
                case 1:
                    Fila fila = new Fila();
                    interacaoFila(1, fila);
                    break;
                case 2:
                    Pilha pilha = new Pilha();
                    interacaoPilha(1,pilha);
                case 3:
                    Lista lista = new Lista();
                    interacaoLista(1,lista);
                default:
                    throw new AssertionError();
            }
        }
    }

    public static int menu() {
        System.out.println("Escolha a operação a ser realizada:");
        System.out.println("1 - Criar fila");
        System.out.println("2 - Criar pilha");
        System.out.println("3 - Criar lista");
        System.out.println("0 - Sair");

        Scanner sc = new Scanner(System.in);
        int menuEscolha = sc.nextInt();
        return menuEscolha;
    }

    private static void interacaoFila(int parametro, Fila fila) throws EmptyListException {
        Scanner sc = new Scanner(System.in);
        int menu;
        int valorInserir;
        if (fila.estaVazia()) {
            System.out.println("Fila ainda está vazia!");
            System.out.println("Inserir novo elemento");
            valorInserir = sc.nextInt();
            fila.enfileira(valorInserir);
            fimMenuFila(fila);

        } else if (parametro == 1) {
            System.out.println("Inserir novo elemento:");
            valorInserir = sc.nextInt();
            fila.enfileira(valorInserir);
            fimMenuFila(fila);

        } else if (parametro == 2) {
            System.out.println("Desenfilerando fila!");
            fila.desenfileira();
            fimMenuFila(fila);
        }
    }

    private static void fimMenuFila(Fila fila) throws EmptyListException {
        Scanner sc = new Scanner(System.in);
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("Fila atual:");
        fila.print();

        System.out.println("1 - Inserir novo elemento na fila");
        System.out.println("2 - Remover elemento da fila");
        System.out.println("0 - Sair");

        int menu = sc.nextInt();
        switch (menu) {
            case 1:
                interacaoFila(1, fila);
                break;
            case 2:
                interacaoFila(2, fila);
                break;
            case 0:
                break;
            default:
                throw new AssertionError();
        }
    }

    private static void interacaoPilha(int i, Pilha pilha) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private static void interacaoLista(int parametro, Lista lista) throws EmptyListException {
        Scanner sc = new Scanner(System.in);
        int menu;
        int valorInserir;
        if (lista.estaVazia()) {
            System.out.println("Fila ainda está vazia!");
            System.out.println("Inserir novo elemento");
            valorInserir = sc.nextInt();
            lista.insereNoInicio(valorInserir);
            fimMenuLista(lista);

        } else if (parametro == 1) {
            System.out.println("Inserir novo elemento:");
            valorInserir = sc.nextInt();
            lista.insereNoInicio(valorInserir);
            fimMenuLista(lista);

        } else if (parametro == 2) {
            System.out.println("Removendo elemento no inicio da lista!");
            lista.removeNoInicio();
            fimMenuLista(lista);
        }else if (parametro == 3){
            int posicao;
            System.out.println("Inserir novo elemento:");
            valorInserir = sc.nextInt();
            System.out.println("Posição do novo elemento");
            posicao = sc.nextInt();
            lista.insereNoMeio(valorInserir,posicao);
            fimMenuLista(lista);
        }else if (parametro == 4){
            int posicao;
            System.out.println("Posição do elemento que deseja remover");
            posicao = sc.nextInt();
            lista.removeFromPosicao(posicao);
            fimMenuLista(lista);
        }else if (parametro == 5){
            System.out.println("Inserir novo elemento:");
            valorInserir = sc.nextInt();
            lista.insereNoFim(valorInserir);
            fimMenuLista(lista);
        }else if (parametro == 6){
            System.out.println("Removendo elemento no fim da lista!");
            lista.removeNoFim();
            fimMenuLista(lista);
        }         
    }

    private static void fimMenuLista(Lista lista) throws EmptyListException {
        Scanner sc = new Scanner(System.in);
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("Fila atual:");
        lista.print();

        System.out.println("1 - Inserir novo elemento no inicio da lista");
        System.out.println("2 - Remover elemento no inicio da lista");
        System.out.println("3 - Insere no meio da lista");
        System.out.println("4 - Remove no meio da lista");
        System.out.println("5 - Insere no fim da lista");
        System.out.println("6 - Remove no fim da lista");
        System.out.println("0 - Sair");

        int menu = sc.nextInt();
        switch (menu) {
            case 1:
                interacaoLista(1, lista);//inserir no inicio
                break;
            case 2:
                interacaoLista(2, lista);//remove no inicio
                break;
            case 3:
                interacaoLista(3, lista);
                break;
            case 4:
                interacaoLista(4, lista);
                break;
            case 5:
                interacaoLista(5, lista);
                break;
            case 6:
                interacaoLista(6, lista);
                break;
            case 0:
                break;
            default:
                throw new AssertionError();
        }
    }
}
