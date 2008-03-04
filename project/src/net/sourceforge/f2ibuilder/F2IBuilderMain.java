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
package net.sourceforge.f2ibuilder;

import java.awt.Dimension;

import javax.swing.JOptionPane;

import net.sourceforge.f2ibuilder.application.view.Principal;




public class F2IBuilderMain {

	protected Principal janela = null;


	
	public void criarJanela()
	{
		janela = new Principal();
		Dimension dim = janela.getToolkit().getScreenSize();      
		int x = (int) (dim.getWidth()  - janela.getSize().getWidth() )/2;
		int y = (int) (dim.getHeight() - janela.getSize().getHeight())/2;
		janela.setLocation(x,y);
		janela.setVisible(true);
	}
	
	public static void main(String[] args) 
	{
		try {
			F2IBuilderMain executar = new F2IBuilderMain();
			executar.criarJanela();
		} catch (Exception e){
			 JOptionPane.showMessageDialog(null,"F2IBuilder: "+e.getMessage());
		}
	}

}
