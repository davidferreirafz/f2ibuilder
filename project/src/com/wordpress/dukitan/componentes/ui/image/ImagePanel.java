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
package com.wordpress.dukitan.componentes.ui.image;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


/**
 * Classe para exibi��o de uma imagem dentro de um JPanel (Swing)
 * Esta classe foi desenvolvida baseando na classe PicturePanel de
 * Daniel F. Martins <daniel_tritone@terra.com.br>
 * 
 * @author David de A. Ferreira <davidferreira@uol.com.br>
 * @version 1.0
 */
public class ImagePanel extends JPanel 
{
	private static final long serialVersionUID = -5855213845809007082L;
	private Image image;

	public void loadImage(String path)
	{
		this.image = new ImageIcon(path).getImage();

		/* Redimensiona a imagem */
		this.image = this.image.getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH);
	}
	
	public void paintComponent(Graphics g) 
	{
		super.paintComponent(g);
		
		if (this.image != null){
			g.drawImage(image, 0, 0, this);
		}
	}	
	
}
