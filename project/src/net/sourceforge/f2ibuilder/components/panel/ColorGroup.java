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
package net.sourceforge.f2ibuilder.components.panel;

import java.awt.Color;

import javax.swing.JPanel;

import com.wordpress.dukitan.componentes.gof.observer.Observer;
import com.wordpress.dukitan.componentes.ui.color.ColorPanel;


public class ColorGroup extends JPanel {

	private static final long serialVersionUID = 9172638517131619642L;
	private ColorPanel painelFonte;
	private ColorPanel painelSombra;
	private ColorPanel painelFundo;
	
	public ColorGroup()
	{
		setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Color", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12), null));		
		add(getPainelFonte(), null);
		add(getPainelSombra(), null);
		add(getPainelFundo(), null);
	}
	
	public void register(Observer observer)
	{
	    painelFonte.register(observer);
	    painelSombra.register(observer);
	    painelFundo.register(observer);
	}
	
	public Color getCorFundo()
	{
		return painelFundo.getBackground();
	}
	public Color getCorSombra()
	{
		return painelSombra.getBackground();
	}	
	public Color getCorFonte()
	{
		return painelFonte.getBackground();
	}	
	private JPanel getPainelFonte()
	{
		if (painelFonte == null) {
			painelFonte = new ColorPanel();
			painelFonte.setBackground(java.awt.Color.white);
			painelFonte.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
			painelFonte.setToolTipText("Font Color");
			painelFonte.setTitulo("Choose Font Color");
		}
		return painelFonte;		
	}
	
	private JPanel getPainelSombra() {
		if (painelSombra == null) {
			painelSombra = new ColorPanel();
			painelSombra.setBackground(java.awt.Color.DARK_GRAY);
			painelSombra.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
			painelSombra.setToolTipText("Shadow Color");
			painelSombra.setTitulo("Choose Shadow Color");
		}
		return painelSombra;
	}

	private JPanel getPainelFundo() {
		if (painelFundo == null) {
			painelFundo = new ColorPanel();
			painelFundo.setBackground(java.awt.Color.black);
			painelFundo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
			painelFundo.setToolTipText("Background Color");
			painelFundo.setTitulo("Choose Background Color");		
		}
		return painelFundo;
	}

	

}
