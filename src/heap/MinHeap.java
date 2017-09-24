package heap;

public class MinHeap implements Heap<Integer> {

    private int[] dados;
    private int ultimo;

    public MinHeap(int tamanho) {
        int t = (int) ((Math.log(tamanho) / Math.log(2)) + 1);
        dados = new int[(int) Math.pow(2, t)];
        ultimo = -1;
    }

    @Override
    public void inserir(Integer obj) {

        int index = ultimo + 1;

        if (index < dados.length) {
            dados[index] = obj;
            ordena(index);
            ultimo += 1;
        }
    }

    @Override
    public Integer remover() {

        int indexPai = 0;  // indice do pai
        int indexLowerSon = 0; // indice do menor filho
        int indexLeftSon = 2 * indexPai + 1; // indice do filho da esquerda
        int indexRightSon = 2 * indexPai + 2; // indece do filho da direita

        if (ultimo == -1) {
            System.out.println("Heap Vazia");
        } else if (ultimo == 0) {
            dados[ultimo] = 0;
            ultimo = -1;
        } else {
            dados[indexPai] = dados[ultimo]; // raiz recebe o ultimo filha
            dados[ultimo] = 0; // ultima filha recebe 0
            ultimo--; // ultimo volta um dicide
            ordenaRemove(indexPai, indexLowerSon, indexLeftSon, indexRightSon);
        }

        return null;
    }

    private void ordenaRemove(int indexPai, int indexLowerSon, int indexLeftSon, int indexRightSon) {

        if (dados[indexLeftSon] > dados[indexRightSon] && dados[indexRightSon] != 0)
            indexLowerSon = indexRightSon;
        else
            indexLowerSon = indexLeftSon;

        while (indexLowerSon <= ultimo) {

            int aux = dados[indexPai];
            dados[indexPai] = dados[indexLowerSon];
            dados[indexLowerSon] = aux;

            indexPai = indexLowerSon;
            indexLeftSon = 2 * indexPai + 1;
            indexRightSon = 2 * indexPai + 2;

            if (dados[indexLeftSon] > dados[indexRightSon])
                indexLowerSon = indexRightSon;
            else
                indexLowerSon = indexLeftSon;

        }
    }


    @Override
    public void imprimir() {
        for (int i = 0; i <= ultimo; i++) {
            if (i != ultimo)
                System.out.printf("%d, ", dados[i]);
            else
                System.out.printf("%d. ", dados[i]);
        }
    }

    @Override
    public void imprimirIdentado() {


        if (ultimo == 0) {
            System.out.println(dados[0]);
        } else if (ultimo == 1) {
            System.out.printf("%d", dados[0]);
            System.out.printf("%n%d", dados[1]);
        } else {

            int index = 0;
            int alturaArvore = (int) (Math.log(ultimo) / Math.log(2)) + 2;

            for (int row = 0; row < (alturaArvore); row++) {
                for (int column = 0; column < Math.pow(2, row); column++) {
                    if (index <= ultimo) {
                        System.out.printf("%d ", dados[index]);
                        index++;
                    } else
                        break;
                }
                System.out.println();
            }
        }
    }

    private void ordena(int index) {

        while (index > 0) {

            int pai = (index - 1) / 2;

            if (dados[index] < dados[pai]) {

                int aux = dados[pai];
                dados[pai] = dados[index];
                dados[index] = aux;

                index = pai;

            } else {
                break;
            }

        }

    }
}