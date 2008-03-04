/*****************************************************************************/
/* DukItan         -  DukItan Software Components                            */
/* E-Mail          -  davidferreira.fz@gmail.com                             */
/* Site            -  http://davidferreirafz.wordpress.com                   */ 
/* ICQ: 21877381      MSN: davidaf@uol.com.br                                */
/* G.talk: davidferreira.fz@gmail.com                                        */
/* Copyright (C) 2008  David de Almeida Ferreira                             */
/*****************************************************************************/
/*                                                                           */
/* Este arquivo � parte do projeto DSC - DukItan Software Components         */
/*                                                                           */
/* DSC � um software livre; voc� pode redistribui-lo e/ou                    */
/* modifica-lo dentro dos termos da Licen�a P�blica Geral (GPL) GNU          */
/* como publicada pela Funda��o do Software Livre (FSF); na vers�o 2 da      */
/* Licen�a                                                                   */
/*                                                                           */
/*****************************************************************************/
/*                                                                           */
/* This file is part of project DSC - DukItan Software Components            */
/*                                                                           */
/* DSC is free software; you can redistribute it and/or modify               */
/* it under the terms of the GNU  Lesser General Public License (LGPL) as    */
/* published by the Free Software Foundation; either version 2 of the        */
/* License.                                                                  */
/*                                                                           */
/*****************************************************************************/
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
