/*****************************************************************************/
/* DukItan         -  DukItan Software Components                            */
/* E-Mail          -  davidferreira.fz@gmail.com                             */
/* Site            -  http://davidferreirafz.wordpress.com                   */ 
/* ICQ: 21877381      MSN: davidaf@uol.com.br                                */
/* G.talk: davidferreira.fz@gmail.com                                        */
/* Copyright (C) 2008  David de Almeida Ferreira                             */
/*****************************************************************************/
/*                                                                           */
/* Este arquivo é parte do projeto DSC - DukItan Software Components         */
/*                                                                           */
/* DSC é um software livre; você pode redistribui-lo e/ou                    */
/* modifica-lo dentro dos termos da Licença Pública Geral (GPL) GNU          */
/* como publicada pela Fundação do Software Livre (FSF); na versão 2 da      */
/* Licença                                                                   */
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
package com.wordpress.dukitan.componentes.ui.combobox;

import java.util.Iterator;
import java.util.List;

import javax.swing.JComboBox;

public class ComboBox extends JComboBox 
{
	private static final long serialVersionUID = -7872186258314692520L;

	
	
	public boolean existeItem(String novoItem)
	{
		boolean achou = false;
		String item = null;
		int total = getItemCount();

		for (int i=0; i<total; i++){
			item = getItemAt(i).toString();
			if (item.equalsIgnoreCase(novoItem)){
				achou = true;
			}
		}
		
		return achou;
	}
	
    public void addItem(Object item) 
    {
    	if ((item!=null)&&(existeItem(item.toString())==false)){
        	super.addItem(item);
    	}
    }
    
    @SuppressWarnings("unchecked")
    public void setItens(List lista)
    {
		Iterator i =lista.iterator();
		while(i.hasNext()){
			addItem((String) i.next());
		}
    }
}
