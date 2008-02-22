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
package net.sourceforge.f2ibuilder.application.model;

import com.wordpress.dukitan.componentes.gof.observer.Observable;

public class Options extends Observable
{
    private boolean grid;
    private boolean metrica;
    private boolean antialias;
    private String  imagemTipo;
    private int     sombraVertical;
    private int     sombraHorizontal;
    private int     tamanhoTextura;

    static public int IMAGE_TYPE_PNG = 0;
    static public int IMAGE_TYPE_BMP = 1;    
    
    static private Options instance;

    
    private Options()
    {
        metrica    = true;
        antialias  = true;
        grid       = false;
        imagemTipo = "png";
        sombraVertical   = 0;
        sombraHorizontal = 0;
        tamanhoTextura   = 0;
    }
    
    public static Options getInstance()
    {
        if (instance==null){
            instance = new Options();
        }
        
        return instance;
    }  

    public boolean isAntialias()
    {
        return antialias;
    }

    /**
     * 
     * @param antialias
     * Chamada externa, deve notificar mudanças
     */
    public void setAntialias(boolean antialias)
    {
        this.antialias = antialias;
        
        updateObserver();
    }

    public boolean isGrid()
    {
        return grid;
    }

    /**
     * 
     * @param grid
     * Chamada externa, deve notificar mudanças
     */
    public void setGrid(boolean grid)
    {
        this.grid = grid;
        
        updateObserver();
    }

    public boolean isMetrica()
    {
        return metrica;
    }

    /**
     * 
     * @param metrica
     * Chamada externa, deve notificar mudanças
     */
    public void setMetrica(boolean metrica)
    {
        this.metrica = metrica;
        
        updateObserver();
    }

    public String getImagemTipo()
    {
        return imagemTipo;
    }

    /**
     * 
     * @param imageType
     */
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

    public boolean isImageTipoPNG()
    {
        return imagemTipo.equalsIgnoreCase("png");
    }

    public int getSombraHorizontal()
    {
        return sombraHorizontal;
    }
    /**
     * 
     * @param sombraHorizontal
     * Chamada externa, deve notificar mudanças
     */
    public void setSombraHorizontal(int sombraHorizontal)
    {
        this.sombraHorizontal = sombraHorizontal;
        
        updateObserver();
    }

    public int getSombraVertical()
    {
        return sombraVertical;
    }

    /**
     * 
     * @param sombraVertical
     * Chamada externa, deve notificar mudanças
     */
    public void setSombraVertical(int sombraVertical)
    {
        this.sombraVertical = sombraVertical;
        
        updateObserver();
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

    /**
     * 
     * @param tamanhoTextura
     * Chamada externa, deve notificar mudanças
     */
    public void setTextureSize(int tamanhoTextura)
    {
        this.tamanhoTextura = tamanhoTextura;
        
        updateObserver();
    }
}
