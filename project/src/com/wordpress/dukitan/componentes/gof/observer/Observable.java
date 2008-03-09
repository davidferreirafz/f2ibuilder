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
 * Implementa��o de IObservable, est� classe notificar� as 
 * classes Observer sobre altera��es.
 *  
 * Design Pattern: GoF - Observer
 * 
 * @author David Ferreira - davidferreira.fz@gmail.com
 */
public class Observable implements IObservable
{
    private List<Observer> listObserver;
    private boolean autoCommit = true;
    
    public Observable()
    {
        listObserver = new ArrayList<Observer>();
    }
    
    /**
     * {@inheritDoc}
     */  
    public void register(Observer observer)
    {
        listObserver.add(observer);
    }
    
    /**
     * {@inheritDoc}
     */  
    public void desregister(Observer observer)
    {
        listObserver.remove(observer);
    }
    
    /**
     * Notifica os observadores sobre as altera��es de seu estado.
     * Este m�todo deve ser chamado pela classes que implementamente
     * Observable nos m�todos de altera��o de seus valores ou que forem
     * importantes.
     */
    protected void updateObserver()
    {
        //Se a auto notifica��o estiver ativa ela informa sua lista de observers
        if (autoCommit){
            if ((listObserver!=null)&&(!listObserver.isEmpty())){
                ListIterator<Observer> i= listObserver.listIterator(0);
            
                while (i.hasNext()){
                    i.next().update();
                }
            }
        }
    }

    /**
     * Configura o Observable para n�o notificar as altera��es.
     * � aplicado um esquema transacional para evitar que a notifica��o
     * sejam aplicada durante uma sequencia de modifica��es.
     */
    public void beginModify()
    {
        autoCommit = false;
    }
    
    /**
     * Configura o Observable para notificar qualquer modifica��o
     * aos Observers.
     * Executa imediatamente a notifica��o aos Observers 
     */
    public void endModify()
    {
        autoCommit = true;
        updateObserver();
    }    
}
