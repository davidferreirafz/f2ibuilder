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
package net.sourceforge.f2ibuilder.components.memento;

import java.awt.Color;


/**
 * Definição da classe memento, a qual manterá o estado do objeto application.view.Principal 
 * para salvar e recuperar os dados de um projeto
 *  
 * Design Pattern: GoF - Memento
 * 
 * @author David Ferreira - davidferreira.fz@gmail.com
 * 
 * Project: F2IBuilder
 * Date: 11/04/2008 
 */
public class ProjectMemento
{
    private boolean useMetrics;
    private boolean useAlpha;
    private boolean antialias;
    private boolean showGrid;
    
    private boolean bold;
    private String fontSize;
    private String fontName;
    private String texturaSize;
    private int fontPositionWidth;
    private int fontPositionHeight;    
    
    private int fontColor;
    private int shadowColor;
    private int backgroundColor;

    private String horizontalShadow;
    private String verticalShadow;
    
    private String imageType;
    
    public ProjectMemento()
    {
    }

    public boolean isBold()
    {
        return bold;
    }


    public void setBold(boolean bold)
    {
        this.bold = bold;
    }

    public boolean isUseMetrics()
    {
        return useMetrics;
    }


    public void setUseMetrics(boolean useMetrics)
    {
        this.useMetrics = useMetrics;
    }


    public boolean isUseAlpha()
    {
        return useAlpha;
    }


    public void setUseAlpha(boolean useAlpha)
    {
        this.useAlpha = useAlpha;
    }


    public boolean isAntialias()
    {
        return antialias;
    }


    public void setAntialias(boolean antialias)
    {
        this.antialias = antialias;
    }


    public boolean isShowGrid()
    {
        return showGrid;
    }


    public void setShowGrid(boolean showGrid)
    {
        this.showGrid = showGrid;
    }


    public String getFontSize()
    {
        return fontSize;
    }


    public void setFontSize(String fontSize)
    {
        this.fontSize = fontSize;
    }


    public String getFontName()
    {
        return fontName;
    }


    public void setFontName(String fontName)
    {
        this.fontName = fontName;
    }


    public String getTexturaSize()
    {
        return texturaSize;
    }


    public void setTexturaSize(String texturaSize)
    {
        this.texturaSize = texturaSize;
    }


    public Color getFontColor()
    {
        return new Color(fontColor);
    }


    public void setFontColor(int fontColor)
    {
        this.fontColor = fontColor;
    }


    public Color getShadowColor()
    {
        return new Color(shadowColor);
    }


    public void setShadowColor(int shadowColor)
    {
        this.shadowColor = shadowColor;
    }


    public Color getBackgroundColor()
    {
        return new Color(backgroundColor);
    }


    public void setBackgroundColor(int backgroundColor)
    {
        this.backgroundColor = backgroundColor;
    }


    public String getHorizontalShadow()
    {
        return horizontalShadow;
    }


    public void setHorizontalShadow(String horizontalShadow)
    {
        this.horizontalShadow = horizontalShadow;
    }


    public String getVerticalShadow()
    {
        return verticalShadow;
    }


    public void setVerticalShadow(String verticalShadow)
    {
        this.verticalShadow = verticalShadow;
    }


    public String getImageType()
    {
        return imageType;
    }


    public void setImageType(String imageType)
    {
        this.imageType = imageType;
    }

    public int getFontPositionWidth()
    {
        return fontPositionWidth;
    }

    public void setFontPositionWidth(int fontPositionWidth)
    {
        this.fontPositionWidth = fontPositionWidth;
    }

    public int getFontPositionHeight()
    {
        return fontPositionHeight;
    }

    public void setFontPositionHeight(int fontPositionHeight)
    {
        this.fontPositionHeight = fontPositionHeight;
    }



    
}
