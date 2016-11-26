/*****************************************************************************/
/* F2IBuilder      -  Font to Image Builder                                  */
/* E-Mail          -  davidferreira.fz@gmail.com                             */
/* Site            -  http://f2ibuilder.dukitan.com                          */
/* Blog            -  http://fztech.dukitan.com                              */ 
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
package net.sourceforge.f2ibuilder.application.controller.mediator;

import java.util.HashMap;

import javax.swing.AbstractButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JRadioButtonMenuItem;


public class MediatorView implements IMediatorView
{
    public static MediatorView instance;
    
    private HashMap<String,AbstractButton> table;
    
    
    private MediatorView()
    {
        table = new HashMap<String,AbstractButton>();
    }
    
    static public MediatorView getInstance()
    {
        if (instance==null){
            instance = new MediatorView();
        }
        return instance;
    }

    public void register(String name, AbstractButton component)
    {
        table.put(name, component);
    }
    
    protected AbstractButton get(String key)
    {
        if (table.containsKey(key)){
            return table.get(key);
        } else {
            return null;
        }
    }
    


    public void selectedUseAlpha(boolean value)
    {
        JRadioButtonMenuItem radioItemBMP = (JRadioButtonMenuItem) get("radioImageTypeBMP");
        JRadioButtonMenuItem radioItemPNG = (JRadioButtonMenuItem) get("radioImageTypePNG");        

        if (value){
            radioItemBMP.setEnabled(false);
            radioItemPNG.setSelected(true);
        } else {
            radioItemBMP.setEnabled(true);
        }
    }
    
   
    public void selectedImageTypeBMP(boolean value)
    {
        JCheckBoxMenuItem checkUseAlpha = (JCheckBoxMenuItem) get("menuItemUseAlpha");

        if (value){
            checkUseAlpha.setState(false);
            checkUseAlpha.setEnabled(false);
        } else {
            checkUseAlpha.setEnabled(true);
        }
    }


    public void selectedUseMetrics(boolean value)
    {
        AbstractButton itemSaveFontMetrics = get("itemSaveFontMetrics");

        if (value){
            itemSaveFontMetrics.setEnabled(true);
        } else {
            itemSaveFontMetrics.setEnabled(false);
        }
    }
}
