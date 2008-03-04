/*****************************************************************************/
/* F2IBuilder      -  Font to Image Builder                                  */
/* E-Mail          -  davidferreira.fz@gmail.com                             */
/* Site            -  http://f2ibuilder.sourceforge.net                      */
/* Blog            -  http://davidferreirafz.wordpress.com                   */ 
/* ICQ: 21877381      MSN: davidaf@uol.com.br                                */
/* G.talk: davidferreira.fz@gmail.com                                        */
/* Copyright (C) 2006-2008  David de Almeida Ferreira                        */
/*****************************************************************************/
/*                                                                           */
/* Este arquivo é parte do programa F2IBuilder.                              */
/*                                                                           */
/* F2IBuilder é um software livre; você pode redistribui-lo e/ou             */
/* modifica-lo dentro dos termos da Licença Pública Geral (GPL) GNU          */
/* como publicada pela Fundação do Software Livre (FSF); na versão 2 da      */
/* Licença                                                                   */
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
package net.sourceforge.f2ibuilder.application.controller.generics;

import javax.swing.JTable;

import net.sourceforge.f2ibuilder.application.controller.generics.base.FontTextAction;
import net.sourceforge.f2ibuilder.application.model.FontText;


public abstract class SaveItemTable extends FontTextAction
{
    protected JTable table;
    
    public SaveItemTable(FontText fontText, JTable table)
    {
        super(fontText);
        this.table = table;
    }

    @Override
    final protected void action()
    {
        int caracter=0;
        
        fontText.beginModify();
        
        for (int l=0; l<16; l++){
            for (int c=0;c<16;c++){               
                Object o = table.getModel().getValueAt(l,c);
                
                if (o!=null){
                    int valor = Integer.parseInt((String) o);
                    
                    setValue(caracter,valor);
                }
                caracter++;
            }
        }
        
        fontText.endModify();
    }

    abstract protected void setValue(int caracter, int value);
}
