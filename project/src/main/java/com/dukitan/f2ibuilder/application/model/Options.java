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
package com.dukitan.f2ibuilder.application.model;

import com.dukitan.componentes.gof.observer.Observable;
import com.dukitan.f2ibuilder.application.view.image.draw.antialias.AntialiasEffect;
import com.dukitan.f2ibuilder.application.view.image.draw.antialias.AntialiasNone;
import com.dukitan.f2ibuilder.application.view.image.draw.antialias.AntialiasStrategy;
import com.dukitan.f2ibuilder.application.view.image.draw.background.BackgroundApha;
import com.dukitan.f2ibuilder.application.view.image.draw.background.BackgroundFill;
import com.dukitan.f2ibuilder.application.view.image.draw.background.BackgroundStrategy;
import com.dukitan.f2ibuilder.application.view.image.draw.metric.MetricEffect;
import com.dukitan.f2ibuilder.application.view.image.draw.metric.MetricNone;
import com.dukitan.f2ibuilder.application.view.image.draw.metric.MetricStrategy;
import com.dukitan.f2ibuilder.application.view.image.draw.shadow.ShadowEffect;
import com.dukitan.f2ibuilder.application.view.image.draw.shadow.ShadowStrategy;

/**
 * Classe com os dados relacionados as op��es para gera��o da imagem.
 * 
 * Designer Pattern: Observer, Singleton
 * 
 * @author David Ferreira - davidferreira.fz@gmail.com
 * 
 */
//Em futura vers�es o estado interno dessa classe ser� exportado para uma nova features
//que basicamente sera 'salvar projeto', talvez seja ideal aplicar o 
//Design Pattern GoF - Memento
public class Options extends Observable
{
    private boolean grid;
    @SuppressWarnings("unused")
    private boolean metrica;
    @SuppressWarnings("unused")
    private boolean antialias;
    private String  imagemTipo;
    private int     sombraVertical;
    private int     sombraHorizontal;
    private int     tamanhoTextura;
    private BackgroundStrategy backgroundStrategy;
    private AntialiasStrategy antialiasStrategy;
    private MetricStrategy metricStrategy;
    private ShadowStrategy shadowStrategy;

    static final public int IMAGE_TYPE_PNG = 0;
    static final public int IMAGE_TYPE_BMP = 1;
    
    static private Options instance;

    /**
     * Construtor privado para implementa��o do Singleton
     */
    private Options()
    {
        grid = false;
        tamanhoTextura = 0;
        
        setAlpha(true);        
        setImageType(IMAGE_TYPE_PNG);
        setAntialias(true);
        setMetrica(true);
        setSombraHorizontal(0);
        setSombraVertical(0);
    }
    
    public static Options getInstance()
    {
        if (instance==null){
            instance = new Options();
        }
        
        return instance;
    }  

    public void setAntialias(boolean antialias)
    {
        this.antialias = antialias;
        
        if (antialias){
            antialiasStrategy = new AntialiasEffect();
        } else {
            antialiasStrategy = new AntialiasNone();
        }
        
        updateObserver();
    }

    public boolean isGrid()
    {
        return grid;
    }

    public void setGrid(boolean grid)
    {
        this.grid = grid;
        
        updateObserver();
    }

    public void setMetrica(boolean metrica)
    {
        this.metrica = metrica;

        if (metrica){
            metricStrategy = new MetricEffect();
        } else {
            metricStrategy = new MetricNone();
        }
        
        updateObserver();
    }

    public String getImagemTipo()
    {
        return imagemTipo;
    }


    public void setImageType(int imageType)
    {
        switch (imageType){
            case 1:
                    this.imagemTipo = "bmp";
                break;
            case 0:
            default:
                    this.imagemTipo = "png";
                break;
        }
    }
    
    public void setAlpha(boolean value)
    {
        if (value){
            backgroundStrategy = new BackgroundApha();            
        }else {
            backgroundStrategy = new BackgroundFill();            
        }
    }

    public void setSombraHorizontal(int sombraHorizontal)
    {
        this.sombraHorizontal = sombraHorizontal;

        setSombra(sombraHorizontal, sombraVertical);        
    }

    private void setSombra(int horizontal, int vertical)
    {
        shadowStrategy = new ShadowEffect(horizontal,vertical);
        
        updateObserver();        
    }
 
    public void setSombraVertical(int sombraVertical)
    {
        this.sombraVertical = sombraVertical;
         
        setSombra(sombraHorizontal, sombraVertical);
    }

    public boolean isTexturaAuto()
    {
        boolean auto = false;
        if (tamanhoTextura == 0) {
            auto = true;
        }
        return auto;
    }

    public int getTamanhoTextura()
    {
        return tamanhoTextura;
    }

    public void setTextureSize(int tamanhoTextura)
    {
        this.tamanhoTextura = tamanhoTextura;
        
        updateObserver();
    }
    
    public BackgroundStrategy backgroundStrategy()
    {
        return backgroundStrategy;
    }
    
    public AntialiasStrategy antialiasStrategy()
    {
        return antialiasStrategy; 
    }

    public MetricStrategy metricStrategy()
    {    
        return metricStrategy;
    }

    public ShadowStrategy shadowStrategy()
    {
        return shadowStrategy;
    }
}
