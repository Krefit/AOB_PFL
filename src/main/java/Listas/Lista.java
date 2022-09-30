package Listas;

//definicao da classe List
public class Lista {

    private ListaNo primeiroNo;// Declara variavel de instancia com o nome de
    // PrimeiroN�
    private ListaNo ultimoNo;// Declara variavel de instancia com o nome de
    // UltimoN�
    private String nome; // String como 'lista' usada na impressao

    private ListaNo meioNo;

    private int tamanhoLista;

    // construtor cria List vazia com 'list' como o nome
    public Lista() {
        this("Lista");
        this.tamanhoLista = 0;
    }// fim do construtor sem argumentos List

    // construtor cria uma List vazia com um nome
    public Lista(String nomeDaLista) {
        nome = nomeDaLista;
        primeiroNo = ultimoNo = null;
        this.tamanhoLista = 0;
    }// fim do construtor de um argumento List
    // Insere Object na frente de List

    public void insereNoInicio(Object insertItem) {
        if (estaVazia()) { // first e lastNode referenciam o mesmo objeto
            primeiroNo = ultimoNo = new ListaNo(insertItem);
        } else {
            primeiroNo = new ListaNo(insertItem, primeiroNo);
        }// fim do m�todo insereNoInicio

        this.tamanhoLista++;
    }// fim do m�todo insereNoInicio

    // insere Object no fim de Lista
    public void insereNoFim(Object insertItem) {
        if (estaVazia()) {
            primeiroNo = ultimoNo = new ListaNo(insertItem);
        } else {
            ultimoNo = ultimoNo.proximoNo = new ListaNo(insertItem);
        }
        this.tamanhoLista++;
    }// fim do m�todo insereNoFim

    //Insere na posi��o informada
    public void insereNoMeio(Object insertItem, int posicao) {
        if (estaVazia()) {
            System.out.println("Posição não existe!");
            System.out.println("Lista vazia, inserindo na primeira posição");
            primeiroNo = ultimoNo = new ListaNo(insertItem);
        } else if (this.tamanhoLista < posicao) {
            System.out.println("Posição não existe");
            System.out.println("Inserindo na ultima posição");
            ultimoNo = ultimoNo.proximoNo = new ListaNo(insertItem);
        } else {
            int posiLista = 0;
            ListaNo auxiliar;
            ListaNo ondeEstou = primeiroNo;

            while (posicao < posiLista - 1) {
                ondeEstou = ondeEstou.proximoNo;
                posiLista++;
            }
            auxiliar = ondeEstou.proximoNo;
            ondeEstou.proximoNo = new ListaNo(insertItem);
            ondeEstou = ondeEstou.proximoNo;
            ondeEstou.proximoNo = auxiliar;

            tamanhoLista++;
        }
    }

    // remove o primeiro n� de List
    public Object removeNoInicio() throws EmptyListException {
        if (estaVazia()) {
            throw new EmptyListException(nome);
        }
        Object removedItem = primeiroNo.data; // recupera dados sendo removidos
        // atualiza refer�ncias primeiroNo e ultimoNo
        if (primeiroNo == ultimoNo) {
            primeiroNo = ultimoNo = null;
        } else {
            primeiroNo = primeiroNo.proximoNo;
        }
        this.tamanhoLista--;
        return removedItem;// retorna dados de n� removidas
    }// fim do m�todo removeNoFim

    public Object removeNoFim() throws EmptyListException {
        if (estaVazia()) {
            throw new EmptyListException(nome); //lan�a excess�o se List estiver vazia
        }

        Object removedItem = ultimoNo.data; //recupera dados sendo removidos

        //atualiza refer�ncias primeiroNo e ultimoNo
        if (primeiroNo == ultimoNo) {
            primeiroNo = ultimoNo = null;
        } else { //localiza o novo �ltimo n�
            ListaNo ondeEstou = primeiroNo;

            //faz loop enquanto n� atual n�o referencia lastNode
            while (ondeEstou.proximoNo != ultimoNo) {
                ondeEstou = ondeEstou.proximoNo;
            }

            ultimoNo = ondeEstou; //atual �	novo lastNode
            ondeEstou.proximoNo = null;
        }//fim do else

        this.tamanhoLista--;
        return removedItem; //retorna dados de n� removidos
    }//fim do m�todo removeNoFim

    public Object removeFromPosicao(int posicao) throws EmptyListException {
        if (estaVazia()) {
            throw new EmptyListException(nome); //lan�a excess�o se List estiver vazia
        }
        int posiLista = 0;
        ListaNo auxiliar;
        ListaNo ondeEstou = primeiroNo;

        while (posicao < posiLista - 2) {
            ondeEstou = ondeEstou.proximoNo;
            posiLista++;
        }

        auxiliar = ondeEstou.proximoNo;
        Object removedItem = auxiliar.data;

        auxiliar = auxiliar.proximoNo;
        ondeEstou.proximoNo = auxiliar;

        this.tamanhoLista--;

        return removedItem;
    }

    public Object removePorValor(Object elemento) throws EmptyListException{
        ListaNo ondeEstou = primeiroNo;
        ListaNo auxiliar;
        //faz loop enquanto n� atual n�o referencia lastNode
        while (ondeEstou.proximoNo.data != elemento) {
            ondeEstou = ondeEstou.proximoNo;
            if(ondeEstou.proximoNo == null)
                return null;
        }
        auxiliar = ondeEstou.proximoNo;
        ondeEstou.proximoNo = auxiliar.proximoNo;
        
        Object removedItem = auxiliar.data;
        
        return removedItem;
    }
    
    public boolean buscaElemento(Object elemento) {
        ListaNo ondeEstou = primeiroNo;

        //faz loop enquanto n� atual n�o referencia lastNode
        while (ondeEstou.data != elemento) {
            ondeEstou = ondeEstou.proximoNo;
            if(ondeEstou.proximoNo == null)
                return false;
        }

        return true;
    }

    // Determina se a lista estiver vazia
    public boolean estaVazia() {
        return primeiroNo == null; // retorna true se List estiver vazia
    }// fim do m�todo estaVazia
    // gera sa�da do conte�do de List

    public void print() {
        if (estaVazia()) {
            System.out.printf("Lista Vazia %s\n", nome);
            System.out.println(imprimeTamanho());
            return;
        }// fim do if

        System.out.printf("A lista %s �: ", nome);
        ListaNo ondeEstou = primeiroNo;
        // enquanto n�o estiver no fim da lista, gera sa�da dos dados do n�
        // atual
        while (ondeEstou != null) {
            System.out.printf("%s -> ", ondeEstou.data);
            ondeEstou = ondeEstou.proximoNo;
        }// fim do While
        System.out.printf("\n");
        System.out.println(imprimeTamanho());
    } // fim do m�todo print

    public String imprimeTamanho() {
        return "Tamanho da Lista: " + this.tamanhoLista;
    }
}// fim da classe List
