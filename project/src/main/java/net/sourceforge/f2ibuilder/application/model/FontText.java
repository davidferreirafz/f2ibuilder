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
package net.sourceforge.f2ibuilder.application.model;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JPanel;

import net.sourceforge.f2ibuilder.components.type.Limit;

import com.dukitan.componentes.gof.observer.Observable;

/**
 * Classe com os dados relacionados a fonte selecionada.
 * 
 * Designer Pattern: Observer, Singleton
 * 
 * @author David Ferreira - davidferreira.fz@gmail.com
 */
public class FontText extends Observable
{
    private String fontName;
    private int fontSize;
    private int fontStyle;
    private Font font;
    private JPanel panel;
    private Dimension dimensionDefault;
    private Limit limit;    
    private Dimension positionAdjust;
    
    private int[] workCharset;
    private int[] workMetrics;
    private int[] originalMetrics;

    
    private static FontText instance;
    
   
    /**
     * Inst�ncia de FontText
     * @return inst�ncia �nica de FontText
     */
    public static FontText getInstance()
    {
        if (instance == null){
            instance = new FontText();
        }
        
        return instance;
    }
    
    /**
     * Construtor privado para implementa��o do Singleton
     */
    private FontText()
    {
        workCharset = new int[256];
        workMetrics = new int[256];
        
        panel = new JPanel();
        fontName   = "Arial";
        fontStyle  = Font.PLAIN;
        fontSize = 14;        
        
        dimensionDefault = new Dimension();
        positionAdjust   = new Dimension(0,0);        
        limit = new Limit(0,dimensionDefault.width);
        
        resetCharset();        
    }
    
    /**
     * Configura uma nova fonte a ser usada.
     */
    public void make()
    {
        apllyNewFont();
        metricsDefault();
        applyMetricsLimit();
        
        updateObserver();
    }   
    
    /**
     * Cria a fonte a ser usada.
     */
    private void apllyNewFont()
    {
        font = new Font(fontName,fontStyle,fontSize);
        
        panel.setFont(font);
    }
    /**
     * Obtem as informa��es de m�trica da fonte.
     */
    private void metricsDefault()
    {
        originalMetrics=panel.getFontMetrics(font).getWidths();
        
        dimensionDefault.width=0;
        
        for (int i=0; i<256; i++){  
            if (originalMetrics[i]>dimensionDefault.width){
                dimensionDefault.width=originalMetrics[i];
            }
        }   
        
        dimensionDefault.height=panel.getFontMetrics(font).getHeight();
        
        if (dimensionDefault.height<=0){
            dimensionDefault.height=dimensionDefault.width;
        }
        
        limit.max=dimensionDefault.width;
    }
    /**
     * Aplica os limites das m�tricas
     */
    private void applyMetricsLimit()
    {
        workMetrics=originalMetrics.clone();
        
        for (int i=0; i<256; i++){              
            if (workMetrics[i]<limit.min){
                workMetrics[i]=limit.min;
            } else if (workMetrics[i]>limit.max){
                workMetrics[i]=limit.max;
            }
        }
        
        dimensionDefault.width=limit.max;
    }
    /**
     * Retonar as m�tricas para a defini��o default da fonte.
     */
    public void resetMetrics()
    {
        if (originalMetrics!=null){
            workMetrics=originalMetrics.clone();
            searchLimits();
        }

        updateObserver();
    }

    /**
     * Retorna os caracteres para defini��o default da tabelas ascii.
     */
    public void resetCharset()
    {
        for (int i=0; i<256; i++){
            workCharset[i]=i;
        }
        
        resetMetrics();
    }
    /**
     * Restaura o posicionamento de caracteres.
     */
    public void resetCharsetPosition()
    {
        setPositionAdjust(0,0);
    }    
    /**
     * Pega o caracter correspondente ao indice da tabela de caracteres passado.
     * @param i indice na tabela de caracteres
     * @return retorna a Letra correspondente
     */
    public String getCharacter(int i)
    {
        return String.valueOf((char)workCharset[i]);
    }
    /**
     * Pega o c�digo ascii do caracter correspondente ao indice da tabela de caracteres passado.
     * @param i indice na tabela de caracteres
     * @return retorna o c�digo ascii do caracter correspondente
     */
    public int getCharacterNumber(int i)
    {
        return workCharset[i];
    }
    /**
     * Define outro caracter na tabela
     * @param i indice na tabela de caracteres
     * @param valor c�digo ascii do caracter
     */
    public void setCharacter(int i,int valor)
    {       
        workCharset[i]=valor;
        workMetrics[i]=workMetrics[valor];
        
        updateObserver();
    }
    /**
     * Define a m�trica para um caracter.
     * @param i indice na tabela de caracteres
     * @param valor da largura do caracter
     */    
    public void setCharacterMetric(int i,int valor)
    {
        workMetrics[i]=valor;
        searchLimits();
        
        updateObserver();       
    }
    /**
     * Define as m�tricas para todos os caracteres
     * @param metricas array com as m�tricas de todos os caracteres
     */
    public void setMetrics(int[] metricas)
    {
        originalMetrics=metricas;    
        searchLimits();
        applyMetricsLimit();        
        
        updateObserver();       
    }        

    /**
     * Configura os novos limites das m�tricas.
     * @param min largura m�nima para os caracteres
     * @param max largura m�xima para os caracteres
     */
    public void setLimits(int min, int max)
    {
    	if ((min<0)||(max<=0)){
            searchLimits();
    	} else {
    		limit.min = min;
    		limit.max = max;		
    	}
        
        applyMetricsLimit();
        updateObserver();
    }
    
    /**
     * Configura os novos limites das m�tricas.
     * @param min largura m�nima para os caracteres
     * @param max largura m�xima para os caracteres
     */
    public void setPositionAdjust(int largura, int altura)
    {
        positionAdjust.width=largura;
        positionAdjust.height=altura;        
        
        for (int i=0; i<256; i++){              
            workMetrics[i]=originalMetrics[i]+largura;
        }
        
        updateObserver();
    }    
    
    /**
     * Procura pelos limites default.
     */
    protected void searchLimits()
    {
        limit.max=0; limit.min=1000;
        
        for (int i=0; i<256; i++){
            if (workMetrics[i]>limit.max){
                limit.max=workMetrics[i];
            } else if (workMetrics[i]<limit.min){
                limit.min=workMetrics[i];
            }
        }
        
        dimensionDefault.width=limit.max;        
    }    
    
    public int getMaiorLargura() {
        return limit.max;
    }

    public int getMenorLargura() {
        return limit.min;
    }  
    
    public Font getFont()
    {
        return font;
    }

    public void setFontSize(int size)
    {
        this.fontSize=size;
        
        make();
    }
    
    public int getFontSize()
    {
        return fontSize;
    }
    
    public void setFontName(String fontName)
    {
        this.fontName=fontName;
        
        make();
    }
    public String getFontName()
    {
        return fontName;
    }
    /**
     * Retorna a largura do caracter
     * @param i indice na tabela de caracteres
     * @return largura do caracter
     */
    public int getCharacterMetric(int i)
    {
        return workMetrics[i];
    }
    /**
     * Configura o Estilo da Fonte, se � negrito ou n�o
     * @param value true para utilizar negrito
     */
    public void setBold(boolean value)
    {
        if (value){
            fontStyle=Font.BOLD;
        } else {
            fontStyle=Font.PLAIN;
        }
        
        make();
    }    
    /**
     * Retorna a dimens�o default(M�xima) do caracter.
     * @return dimensao do caracter 
     */
    public Dimension getDefaultCharDimension()
    {
        return (Dimension) dimensionDefault.clone();
    }
    /**
     * Retorna a distancia entre o ponto que se deseja desenhar (virtual)
     * e o ponto que de fato a fonte � desenhada.
     * @return distancia
     */   
    public int getFontAscent()
    {
        return panel.getFontMetrics(font).getAscent();
    }
    /**
     * Retorna o Ajuste da posi��o.
     * @return dimensao do ajuste na posi��o 
     */
    public Dimension getPositionAdjust()
    {
        return positionAdjust;
    }
    /**
     * Retorna o nome da fonte mais a informa��o de seu tamanho
     * @return FonteName+"."+FontSize
     */
    public String getDefaultID()
    {
        return getFontName()+"."+getFontSize();
    }
}
