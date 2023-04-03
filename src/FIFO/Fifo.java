package FIFO;

public class Fifo {
    private Object[] elements;
    private int head;
    private int tail;
    private int size;
    private int maxSize;

    // Constructeur de la classe Fifo
    public Fifo(int maxSize) {
        if (maxSize <= 0) {
            throw new IllegalArgumentException("La taille maximale doit être supérieure à 0");
        }
        this.maxSize = maxSize;
        this.elements = new Object[maxSize];
        this.head = 0;
        this.tail = 0;
        this.size = 0;
    }

    // Méthode pour ajouter un élément à la file
    public void offer(Object element) {
        if (element == null) {
            throw new NullPointerException("Les éléments null ne sont pas autorisés");
        }
        if (size == maxSize) {
            throw new IllegalStateException("La file est pleine");
        }
        elements[tail] = element;
        tail = (tail + 1) % maxSize;
        size++;
    }

    // Méthode pour retirer un élément de la file
    public Object poll() {
        if (size == 0) {
            throw new IllegalStateException("La file est vide");
        }
        Object element = elements[head];
        elements[head] = null;
        head = (head + 1) % maxSize;
        size--;
        return element;
    }

    // Méthode pour obtenir la taille de la file
    public int size() {
        return size;
    }

    // Méthode pour vérifier si la file est vide
    public boolean isEmpty() {
        return size == 0;
    }

    // Méthode pour afficher la file
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < size; i++) {
            sb.append(elements[(head + i) % maxSize]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append(']');
        return sb.toString();
    }
}
