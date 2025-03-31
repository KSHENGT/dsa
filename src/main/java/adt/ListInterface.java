package adt;


public interface ListInterface<T> {

  public boolean add(T newEntry);

  public boolean add(int newPosition, T newEntry);

  public T remove(int givenPosition);

  public boolean replace(int givenPosition, T newEntry);

  public T getEntry(int givenPosition);

  public boolean contains(T anEntry);
  
  public T getFront();
  
  public void clear();

  public int getNumberOfEntries();

  public boolean isEmpty();

  public boolean isFull();
}
