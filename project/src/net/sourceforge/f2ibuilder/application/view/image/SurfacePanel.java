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
package net.sourceforge.f2ibuilder.application.view.image;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;

import javax.swing.ImageIcon;

import net.sourceforge.f2ibuilder.application.model.FontText;
import net.sourceforge.f2ibuilder.application.model.Options;
import net.sourceforge.f2ibuilder.components.panel.ColorGroup;
import net.sourceforge.f2ibuilder.components.type.Counter;



public class SurfacePanel extends PanelModel implements FontImage 
{
	private static final long serialVersionUID = -5855213845809007082L;
	private Image image;
    private Graphics imageGraphic;
	
	public SurfacePanel(FontText fontText, Options options, ColorGroup colorGroup)
    {
		super(fontText,options,colorGroup);
	}	
	
    private void createImage()
    {
        setFont(fontText.getFont());
        prepareWorkArea();
    }

    
	public RenderedImage getImage()
	{
	    return (RenderedImage) image;
	}
		
	
	private void drawBackground()
	{
        options.backgroundStrategy().draw(imageGraphic,colorGroup.getCorFundo(),getSize());        
	}
	
	private void drawGrid()
	{
		if (options.isGrid()){
		    Counter count = new Counter(15);

            Dimension dimensao = getCharSpace();
            imageGraphic.setColor(new Color(0,150,0));
            
			for (char i=0; i<256; i++){

				imageGraphic.drawRect((count.column*dimensao.width),(count.line*dimensao.height),dimensao.width,dimensao.height);
				
				count.next();
			}
		}
	}
	
	private void drawFont()
	{
		imageGraphic.setColor(colorGroup.getCorFonte());
       
        Dimension ajuste = options.shadowStrategy().adjustFont();
        
        Dimension dimensao = getCharSpace();        

		ajuste = options.metricStrategy().adjust(ajuste, dimensao, fontText);
		
        drawText(dimensao,ajuste);
	}
	
	private void drawShadow()
	{
		if (options.shadowStrategy().isActive()){

            imageGraphic.setColor(colorGroup.getCorSombra());
            
            Dimension ajuste = options.shadowStrategy().adjustShadow();
            
            Dimension dimensao = getCharSpace();

	        ajuste = options.metricStrategy().adjust(ajuste, dimensao, fontText);			

	        drawText(dimensao,ajuste);
		}
	}
	
	private void drawText(Dimension dimensao, Dimension ajuste)
	{
        Counter count = new Counter(15);
        Point point = new Point();
        
        for (char i=0; i<256; i++){
            
            point = options.metricStrategy().position(count, dimensao, ajuste, fontText);
            
            imageGraphic.drawString(fontText.getCharacter(i), point.x, point.y);
            
            count.next();
        }     
	}


	
	private void prepareWorkArea()
	{
		Dimension dimensao = getWindowSize();
		
		BufferedImage buffer = new BufferedImage(dimensao.width, dimensao.height,options.backgroundStrategy().getColorChannel());
		image = new ImageIcon(buffer).getImage();

		imageGraphic = image.getGraphics();
		imageGraphic.setFont(getFont());

		options.antialiasStrategy().apply((Graphics2D) imageGraphic);
	}

	public void paint(Graphics g)
	{
		if (image!=null){
			super.paint(g);

			prepareWorkArea();
			drawBackground();
			drawShadow();
			drawFont();
			drawGrid();

			g.drawImage(image, 0, 1, colorGroup.getCorFundo(),this);
		}
	}

    @Override
    public void update()
    { 
        createImage();
        
        setPreferredSize(getWindowSize());
        setSize(getWindowSize());
        
        repaint();
    }

}
