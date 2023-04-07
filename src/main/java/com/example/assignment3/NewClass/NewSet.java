package com.example.assignment3.NewClass;

import java.util.ArrayList;

/**
 * This class is the model for The new Implemented Set
 *
 */
public class NewSet<T extends Identifiable> {

    /**
     * ArrayList for storing the data
     *
     */
    private ArrayList<T> list;

    /**
     * Default Constructor
     */
    public NewSet(){
        this.list = new ArrayList<>();
    }

    /**
     * @return weather an object has
     * been added to the new set
     */
    public boolean add(T element){
        boolean flag = true;
        for( T t: list) {
            if (t.getId() == element.getId()) {
                flag = false;
                break;
            }
        }

        if(flag)
            list.add(element);

        return flag;
    }

    /**
     * @return the object
     * that has been deleted
     */
    public T delete(int id){
        for(T t: list){
            if(t.getId() == id){
                list.remove(t);
                return t;
            }
        }
        return null;
    }

    /**
     * @return weather
     * there exist and an object with the
     * given ID
     */
    public boolean peek(int id){
        for(T t: list){
            if(t.getId() == id)
                return true;
        }
        return false;
    }

    /**
     * @return the size
     * of the elements in the set
     */
    public int size(){
        return list.size();
    }

    /**
     * @return weather 2 sets are equal
     */
    public boolean equals(NewSet<T> set) {
        if(set == null)
            return false;
        if(size() != set.size())
            return false;
        for(T t: list)
            if(!set.peek(t.getId()))
                return false;
        return true;
    }

    /**
     * @return the contents of the list
     */
    @Override
    public String toString() {
        return list.toString();
    }

    /**
     * This method displays the content of
     * the list
     */

    public void displayElements(){
        System.out.println(list);
    }
}
