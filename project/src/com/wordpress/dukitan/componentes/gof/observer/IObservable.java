package com.wordpress.dukitan.componentes.gof.observer;

/**
 * Design Pattern: GoF - Observer
 * 
 * @author david
 *
 */
public interface IObservable
{
    public void register(Observer observer);
    
    public void desregister(Observer observer);

}
