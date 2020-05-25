package homework3;

public interface Dequeue<E> extends Queue<E> {
    boolean insertLeft(E value);
    boolean insertRight(E value);

    E removeLeft();
    E removeRight();
}
