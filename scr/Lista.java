package scr;

/**
 * @author MAAG
 * Creación de interfaz para creación de listas
 */

public interface Lista<T>{

    void InsertAtStart(T value);

    void InsertAtEnd(T value);

    void Insert(T value, int index);

    T Delete(int index);

    T DeleteAtStart();

    T DeleteAtEnd();

    T Get(int index);

    boolean IsEmpty();
    
    int Count();

}