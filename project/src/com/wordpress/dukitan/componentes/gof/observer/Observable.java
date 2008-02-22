package com.wordpress.dukitan.componentes.gof.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;


/**
 * Design Pattern: GoF - Observer
 * 
 * @author david
 *
 */
public class Observable implements IObservable
{
    private List<Observer> listObserver;
    private boolean autocommit = true;
    
    public Observable()
    {
        listObserver = new ArrayList<Observer>();
    }
    
    public void register(Observer observer)
    {
        listObserver.add(observer);
    }
    
    public void desregister(Observer observer)
    {
        listObserver.remove(observer);
    }
    
    //TODO: Implementar Iterator tb
    protected void updateObserver()
    {
        if (autocommit){
            if ((listObserver!=null)&&(!listObserver.isEmpty())){
                ListIterator<Observer> i= listObserver.listIterator(0);
            
                while (i.hasNext()){
                    i.next().update();
                }
            }
        }
    }
    
    public void beginModify()
    {
        autocommit = false;
    }
    
    public void endModify()
    {
        autocommit = true;
        updateObserver();
    }    
}
