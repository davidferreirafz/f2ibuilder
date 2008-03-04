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
package net.sourceforge.f2ibuilder.application.view.image;

import java.awt.Dimension;

import net.sourceforge.f2ibuilder.application.model.FontText;
import net.sourceforge.f2ibuilder.application.model.Options;
import net.sourceforge.f2ibuilder.components.panel.ColorGroup;

import com.wordpress.dukitan.componentes.gof.observer.Observer;



public abstract class PanelModel extends JPanelScrolling implements Observer
{   
    protected FontText fontText;
	protected ColorGroup colorGroup;
	protected Options options;

	
	public PanelModel(FontText fontText, Options options, ColorGroup colorGroup)
    {
		super();
		this.fontText   = fontText;
        this.options    = options;		
        this.colorGroup = colorGroup;
        
        this.colorGroup.register(this);
        this.fontText.register(this);
        this.options.register(this);
	}	

    protected Dimension getCharSpace()
    {
        Dimension dimensao;

        if (options.isTexturaAuto()) {
            dimensao = fontText.getDefaultCharDimension();
        } else {
            dimensao = getWindowSize();

            dimensao.width  = dimensao.width / 16;
            dimensao.height = dimensao.height / 16;
        }

        return dimensao;
    } 

    @Override 
    protected Dimension getWindowSize()
    {    
        Dimension dimensao = new Dimension();

        switch (options.getTamanhoTextura()) {
            case 0:
                dimensao = fontText.getDefaultCharDimension();
                
                dimensao.width *=16;
                dimensao.height*=16;
            break;
            default:
                dimensao.width  = options.getTamanhoTextura();
                dimensao.height = options.getTamanhoTextura();
            break;
        }

        return dimensao;
    }     
    
    
}
