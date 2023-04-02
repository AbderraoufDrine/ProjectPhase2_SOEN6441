package com.example.assignment3.NewClass;

import java.util.ArrayList;

public class NewSet<T extends Identifiable> {

    private ArrayList<T> list;

    public NewSet(){
        this.list = new ArrayList<>();
    }

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

    public T delete(int id){
        for(T t: list){
            if(t.getId() == id){
                list.remove(t);
                return t;
            }
        }
        return null;
    }

    public boolean peek(int id){
        for(T t: list){
            if(t.getId() == id)
                return true;
        }
        return false;
    }

    public int size(){
        return list.size();
    }

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

    @Override
    public String toString() {
        return list.toString();
    }

    public void displayElements(){
        System.out.println(list);
    }
}
