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
package com.dukitan.f2ibuilder.components.type;

/**
 * Classe para representar um contador em estilo matriz, 
 * que retorna o indice em formato de vetor.
 * 
 * @author David Ferreira - davidferreira.fz@gmail.com
 */
public class Counter
{
    //Coluna da contagem.
    private int column;
    //Linha da contagem.
    private int line;
    //Contar at�
    private int maxCount;
    //Variavel contador interno
    private int i;
    
    /**
     * Construtor
     * @param maxCount o valor m�ximo da contagem
     */    
    public Counter(int maxCount)
    {
        this.maxCount = maxCount;    
        reset();
    }
    
    /**
     * Constutor
     * @param line quantidade total de linhas
     * @param column quantidade total de colunas
     */
    public Counter(int line, int column)
    {
        this(line*column);
    }

    private void reset()
    {
        this.column=0;
        this.line=0;      
        i=0;
    }
    
    /**
     * Retorna o indice
     * @return indice
     */
    public int getIndice()
    {
        return i;
    }
    
    @Override
    public String toString()
    {
        return  "Counter ("+line+","+column+"):"+i;
    }

    /**
     * Efetua a contagem
     * @return true enquanto estiver contando
     */
    public boolean next()
    {
        i++;
        
        if (i<maxCount){
            return true;
        } else {
            i=maxCount;
            return false;
        }
    }
    
    /**
     * Retorna o indice da coluna, simulando uma contagem em uma matriz
     * @return indice da coluna
     */
    public int column()
    {    
        column = i % 16;
        
        return column;
    }
    
    /**
     * Retorna o indice da line, simulando uma contagem em uma matriz 
     * @return indice da coluna
     */
    public int line()
    {
        line = (i / 16);
        
        return line;
    }

}
