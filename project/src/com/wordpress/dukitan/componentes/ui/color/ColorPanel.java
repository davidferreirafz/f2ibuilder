/*****************************************************************************/
/* F2IBuilder      -  Gerador de Fontes Bitmap / Bitmap Font Generator       */
/* E-Mail          -  davidferreira.fz@gmail.com                             */
/* Site            -  http://code.google.com/p/f2ibuilder                    */
/* Blog            -  http://davidferreira-fz.blogspot.com                   */ 
/* ICQ: 21877381      MSN: davidaf@uol.com.br                                */
/* G.talk: davidferreira.fz@gmail.com                                        */
/* Copyright (C) 2006-2007  David de Almeida Ferreira                        */
/*****************************************************************************/
/*                                                                           */
/* Este arquivo � parte do programa F2IBuilder.                              */
/*                                                                           */
/* F2IBuilder � um software livre; voc� pode redistribui-lo e/ou             */
/* modifica-lo dentro dos termos da Licen�a P�blica Geral (GPL) GNU          */
/* como publicada pela Funda��o do Software Livre (FSF); na vers�o 2 da      */
/* Licen�a                                                                   */
/*                                                                           */
/*****************************************************************************/
/*                                                                           */
/* This file is part of F2IBuilder.                                          */
/*                                                                           */
/* F2IBuilder is free software; you can redistribute it and/or modify        */
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


public class ColorPanel extends JPanel implements IObservable
{
	private static final long serialVersionUID = 3411829393903616525L;
    private ColorPanelControl control;
    private List<Observer> listObserver;
    
	public ColorPanel()
	{
        listObserver = new ArrayList<Observer>();
        
		control = new ColorPanelControl();
		
		addMouseListener(control);
	}

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