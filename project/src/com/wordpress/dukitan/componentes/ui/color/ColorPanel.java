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
package com.wordpress.dukitan.componentes.ui.color;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import javax.swing.JPanel;

import com.wordpress.dukitan.componentes.gof.observer.IObservable;
import com.wordpress.dukitan.componentes.gof.observer.Observer;

/**
 * Classe para Criar um painel para sele��o de cores
 *  
 * Design Pattern: GoF - Observer
 * 
 * @author David Ferreira 
 * @email davidferreira.fz@gmail.com
 */
public class ColorPanel extends JPanel implements IObservable
{
	private static final long serialVersionUID = 3411829393903616525L;
    private ColorPanelControl control;
    private List<Observer> listObserver;
   
    /**
     * Construtor
     */
	public ColorPanel()
	{
        listObserver = new ArrayList<Observer>();
        
		control = new ColorPanelControl();
		
		addMouseListener(control);
	}

	/**
	 * T�tulo da Janela de Dialog para sele��o de cores
	 * @param titulo
	 */
    public void setTitulo(String titulo)
    {
    	control.setTitle(titulo);
    }

    @Override
    public void desregister(Observer observer)
    {
        listObserver.remove(observer);
    }

    @Override
    public void register(Observer observer)
    {
        listObserver.add(observer);
    }
    
    @Override
    public void setBackground(Color bg)
    {
        super.setBackground(bg);
        updateObserver();
    }
    
    /**
     * Notifica os Observers
     */
    protected void updateObserver()
    {
        if ((listObserver!=null)&&(!listObserver.isEmpty())){
            ListIterator<Observer> i= listObserver.listIterator(0);
        
            while (i.hasNext()){
                i.next().update();
            }
        }
    }    

}
