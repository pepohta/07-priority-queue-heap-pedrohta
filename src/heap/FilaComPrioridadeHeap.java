package heap;

public class FilaComPrioridadeHeap<T extends Comparable<T>> {
    private final T[] elementos;
    private int tamanho;

    @SuppressWarnings("unchecked")
    public FilaComPrioridadeHeap(int capacidade) {
        elementos = (T[]) new Comparable[capacidade];
        tamanho = 0;
    }

    public void enfileirar(T elemento) {
        if (estaCheia()) {
            throw new RuntimeException("Fila cheia");
        }

        elementos[tamanho] = elemento;
        sobeHeap(tamanho);
        tamanho++;
    }

    public T desenfileirar() {
        if (estaVazia()) {
            throw new RuntimeException("Fila vazia");
        }

        T removido = elementos[0];

        tamanho--;
        elementos[0] = elementos[tamanho];
        elementos[tamanho] = null;

        if (!estaVazia()) {
            desceHeap(0);
        }

        return removido;
    }

    private void sobeHeap(int indice) {
        while (indice > 0) {
            int pai = (indice - 1) / 2;

            if (elementos[indice].compareTo(elementos[pai]) <= 0) {
                break;
            }

            trocar(indice, pai);
            indice = pai;
        }
    }

    private void desceHeap(int indice) {
        while (true) {
            int esquerdo = 2 * indice + 1;
            int direito = 2 * indice + 2;
            int maior = indice;

            if (esquerdo < tamanho && elementos[esquerdo].compareTo(elementos[maior]) > 0) {
                maior = esquerdo;
            }

            if (direito < tamanho && elementos[direito].compareTo(elementos[maior]) > 0) {
                maior = direito;
            }

            if (maior == indice) {
                break;
            }

            trocar(indice, maior);
            indice = maior;
        }
    }

    private void trocar(int i, int j) {
        T temp = elementos[i];
        elementos[i] = elementos[j];
        elementos[j] = temp;
    }

    public boolean estaVazia() {
        return tamanho == 0;
    }

    public boolean estaCheia() {
        return tamanho == elementos.length;
    }

    public int tamanho() {
        return tamanho;
    }

    public String estadoInternoHeap() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < tamanho; i++) {
            sb.append(elementos[i]);

            if (i < tamanho - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}