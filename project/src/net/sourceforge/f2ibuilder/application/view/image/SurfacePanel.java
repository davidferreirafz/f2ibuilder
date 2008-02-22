/*****************************************************************************/
/* F2IBuilder      -  Gerador de Fontes Bitmap / Bitmap Font Generator       */
/* E-Mail          -  davidferreira.fz@gmail.com                             */
/* Site            -  http://code.google.com/p/f2ibuilder                    */
/* Blog            -  http://davidferreira-fz.blogspot.com                   */ 
/* ICQ: 21877381      MSN: davidaf@uol.com.br                                */
/* G.talk: davidferreira.fz@gmail.com                                        */
/* Copyright (C) 2006-2008  David de Almeida Ferreira                        */
/*****************************************************************************/
/*                                                                           */
/* Este arquivo é parte do programa F2IBuilder.                              */
/*                                                                           */
/* F2IBuilder é um software livre; você pode redistribui-lo e/ou             */
/* modifica-lo dentro dos termos da Licença Pública Geral (GPL) GNU          */
/* como publicada pela Fundação do Software Livre (FSF); na versão 3 da      */
/* Licença                                                                   */
/*                                                                           */
/*****************************************************************************/
/*                                                                           */
/* This file is part of F2IBuilder.                                          */
/*                                                                           */
/* F2IBuilder is free software; you can redistribute it and/or modify        */
/* it under the terms of the GNU  Lesser General Public License (LGPL) as    */
/* published by the Free Software Foundation; either version 3 of the        */
/* License.                                                                  */
/*                                                                           */
/*****************************************************************************/
package net.sourceforge.f2ibuilder.application.view.image;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Scrollable;
import javax.swing.SwingConstants;

import net.sourceforge.f2ibuilder.application.model.FontText;
import net.sourceforge.f2ibuilder.application.model.Options;
import net.sourceforge.f2ibuilder.components.panel.ColorGroup;

import com.wordpress.dukitan.componentes.gof.observer.Observer;



public class SurfacePanel extends JPanel implements Scrollable, Observer, FontImage 
{
	private static final long serialVersionUID = -5855213845809007082L;
	private Image image;
    private Graphics imageGraphic;
    
	private FontText fontText;
	private ColorGroup colorGroup;
	private Options options;

	
	public SurfacePanel(FontText fontText, Options options, ColorGroup color)
    {
		super();
		this.fontText = fontText;
        this.options = options;		
        this.colorGroup = color;
        definirFonte();
        setDoubleBuffered(true);
        
        this.colorGroup.register(this);
        fontText.register(this);
        options.register(this);
	}	
	
	public RenderedImage getImage()
	{
	    return (RenderedImage) image;
	}
		
	private void drawBackground()
	{
		if (options.isImageTipoPNG()){
			Graphics2D g2 = (Graphics2D) imageGraphic;
			AlphaComposite ac =AlphaComposite.getInstance(AlphaComposite.SRC,1.0f);			
			g2.setComposite(ac);			
		} else {
			imageGraphic.setColor(colorGroup.getCorFundo());
			imageGraphic.fillRect(0,0,getSize().width, getSize().height);
		}
	}
	
	private void drawGrid()
	{
		if (options.isGrid()){
			int l=0; int c=0;

            Dimension posicao = getCharSpace();

			for (char i=0; i<256; i++){
				imageGraphic.setColor(new Color(0,150,0));
				imageGraphic.drawRect((c*posicao.width),(l*posicao.height),posicao.width,posicao.height);
				c++;
				if (c>15){
					c=0;
					l++;
				}
			}
		}
	}
	
	private void drawFont()
	{
		imageGraphic.setColor(colorGroup.getCorFonte());
		int l=0;  int c=0;		

        Dimension posicao = getCharSpace();

		int ajusteHorizontal = 0;
		if (options.getSombraHorizontal()<0){
			ajusteHorizontal=options.getSombraHorizontal()*(-1);
		}

		int ajusteVertical = 0;
		if (options.getSombraVertical()<0){
			ajusteVertical=options.getSombraVertical()*(-1);
		}

		if (!options.isMetrica()){
			ajusteHorizontal +=(posicao.width/2);
			ajusteVertical   +=(posicao.height/2) - (fontText.getDefaultCharDimension().height/2);			
		}
		
		for (char i=0; i<256; i++){
			
			if (!options.isMetrica()){
				imageGraphic.drawString(fontText.getCharacter(i),(c*posicao.width)+ajusteHorizontal-(fontText.getCharacterMetric(i)/2),(l*posicao.height)+ajusteVertical+fontText.getFontAscent());			
			} else {
				imageGraphic.drawString(fontText.getCharacter(i),(c*posicao.width)+ajusteHorizontal,(l*posicao.height)+ajusteVertical+fontText.getFontAscent());				
			}
			c++;
			if (c>15){
				c=0;
				l++;
			}
		}
	}
	
	private void drawShadow()
	{
		if ((options.getSombraHorizontal()!=0)||(options.getSombraVertical()!=0)){

	        Dimension posicao = getCharSpace();
	        
			int ajusteHorizontal = options.getSombraHorizontal();
			if (options.getSombraHorizontal()<0){
				ajusteHorizontal=0;
			}
			
			int ajusteVertical = options.getSombraVertical();
			if (options.getSombraVertical()<0){
				ajusteVertical=0;
			}
			
			if (!options.isMetrica()){
				ajusteHorizontal +=(posicao.width/2);
				ajusteVertical   +=(posicao.height/2) - (fontText.getDefaultCharDimension().height/2);				
			}
			
			imageGraphic.setColor(colorGroup.getCorSombra());
			int l=0;  int c=0;		
			
			for (char i=0; i<256; i++){
				if (!options.isMetrica()){				
					imageGraphic.drawString(fontText.getCharacter(i),(c*posicao.width)+ajusteHorizontal-(fontText.getCharacterMetric(i)/2),(l*posicao.height)+ajusteVertical+fontText.getFontAscent());					
				} else {
					imageGraphic.drawString(fontText.getCharacter(i),(c*posicao.width)+ajusteHorizontal,(l*posicao.height)+ajusteVertical+fontText.getFontAscent());
				}
				c++;
				if (c>15){
					c=0;
					l++;
				}
			}			
		}
	}

	public void createImage()
	{
		definirFonte();
		prepareWorkArea();
	}
	
	protected void prepareWorkArea()
	{
		Dimension dimensao = getImageSize();
        
		//Padrão é usar RGB
		int canalCor = BufferedImage.TYPE_INT_RGB;
		//Caso a imagem seja PNG, usar RGB com Alpha
		if (options.isImageTipoPNG()){
			canalCor=BufferedImage.TYPE_INT_ARGB;
		}
		
		BufferedImage buffer = new BufferedImage(dimensao.width, dimensao.height,canalCor);
		image = new ImageIcon(buffer).getImage();

		imageGraphic = image.getGraphics();
		imageGraphic.setFont(getFont());

		//Aplicando Antialiasing
		Graphics2D g2 = (Graphics2D) imageGraphic;
		
		if (options.isAntialias()){
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
			g2.setRenderingHint(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);
		}
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
			
			int x=0;	
			g.drawImage(image, x, 1, colorGroup.getCorFundo(),this);
		}
	}

	public void definirFonte()
	{
	    setFont(fontText.getFont());
	}
	
	public Dimension getPreferredScrollableViewportSize()
	{
		return getImageSize();
	}

	public boolean getScrollableTracksViewportHeight()
	{
		return false;
	}

	public boolean getScrollableTracksViewportWidth()
	{
		return false;
	}

	public int getScrollableBlockIncrement(Rectangle visibleRect, int orientation, int direction)
	{
		return getScrollableUnitIncrement(visibleRect, orientation, direction)*4;
	}
	
	public int getScrollableUnitIncrement(Rectangle visibleRect, int orientation, int direction)
	{
		int retorno=0;
		
		Dimension d=getImageSize();
		
		if (orientation==SwingConstants.VERTICAL) {
			retorno=d.height/16;
		} else {
			retorno=d.width/16;			
		}

		return retorno;
	}

    @Override
    public void update()
    { 
        createImage();
        setPreferredSize(getImageSize());
        setSize(getImageSize());
        repaint();
    }

    
    private Dimension getCharSpace()
    {
        Dimension dimensao;

        if (options.isTexturaAuto()) {
            dimensao = fontText.getDefaultCharDimension();
        } else {
            dimensao = getImageSize();

            dimensao.width  = dimensao.width / 16;
            dimensao.height = dimensao.height / 16;
        }

        return dimensao;
    } 
    
    private Dimension getImageSize()
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
