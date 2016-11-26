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
package net.sourceforge.f2ibuilder.components.panel;

import java.awt.Color;

import javax.swing.JPanel;

import com.dukitan.componentes.gof.observer.Observer;
import com.dukitan.componentes.ui.color.ColorPanel;

/**
 * Agrupamento de ColorPanel, é usado para montar a exibição das três
 * caixas de cores, as quais representam:
 *  Cor de Fundo, Cor da Fonte e Cor da Sombra
 * 
 * @author David Ferreira - davidferreira.fz@gmail.com
 */
public class ColorGroup extends JPanel
{
	private static final long serialVersionUID = 9172638517131619642L;
	
	private ColorPanel panelFontColor;
	private ColorPanel panelFontShadowColor;
	private ColorPanel panelBackgroundColor;

	/**
	 * Construtor
	 */
	public ColorGroup()
	{
		setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Color", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12), null));		
		add(getPanelFontColor(), null);
		add(getPanelFontShadowColor(), null);
		add(getPanelBackgroundColor(), null);
	}	
	/**
	 * Registra os paineis de cores no Observer
	 * @param observer instância da classe Observer
	 */
	public void register(Observer observer)
	{
	    panelFontColor.register(observer);
	    panelFontShadowColor.register(observer);
	    panelBackgroundColor.register(observer);
	}	
	/**
	 * Retorna a cor de fundo
	 * @return cor de fundo
	 */
	public Color getCorFundo()
	{
		return panelBackgroundColor.getBackground();
	}
    public void setCorFundo(Color color)
    {
        panelBackgroundColor.setBackground(color);
    }
    
	/**
	 * Retorna a cor da sombra da fonte
	 * @return cor da sombra
	 */
	public Color getCorSombra()
	{
		return panelFontShadowColor.getBackground();
	}	
    public void setCorSombra(Color color)
    {
        panelFontShadowColor.setBackground(color);
    }
    
	/**
	 * Retorna a cor da fonte
	 * @return cor da fonte
	 */
	public Color getCorFonte()
	{
		return panelFontColor.getBackground();
	}	
	
	public void setCorFonte(Color color)
	{
	    panelFontColor.setBackground(color);
	}
	
	
	/**
	 * Inicializa o painel de cor da fonte
	 * @return JPanel
	 */
	private JPanel getPanelFontColor()
	{
		if (panelFontColor == null) {
			panelFontColor = new ColorPanel();
			panelFontColor.setBackground(java.awt.Color.white);
			panelFontColor.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
			panelFontColor.setToolTipText("Font Color");
			panelFontColor.setTitulo("Choose Font Color");
		}
		return panelFontColor;		
	}
	/**
     * Inicializa o painel de cor da sombra da fonte  
	 * @return JPanel
	 */
	private JPanel getPanelFontShadowColor() {
		if (panelFontShadowColor == null) {
			panelFontShadowColor = new ColorPanel();
			panelFontShadowColor.setBackground(java.awt.Color.DARK_GRAY);
			panelFontShadowColor.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
			panelFontShadowColor.setToolTipText("Shadow Color");
			panelFontShadowColor.setTitulo("Choose Shadow Color");
		}
		return panelFontShadowColor;
	}
	/**
     * Inicializa o painel de cor de fundo 
	 * @return JPanel
	 */
	private JPanel getPanelBackgroundColor() {
		if (panelBackgroundColor == null) {
			panelBackgroundColor = new ColorPanel();
			panelBackgroundColor.setBackground(java.awt.Color.black);
			panelBackgroundColor.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
			panelBackgroundColor.setToolTipText("Background Color");
			panelBackgroundColor.setTitulo("Choose Background Color");		
		}
		return panelBackgroundColor;
	}
}
