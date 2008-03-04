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
package net.sourceforge.f2ibuilder.components.type;

/**
 * Classe para representar um contador em estilo matriz, 
 * que retorna o indice em formato de vetor.
 * 
 * @author David Ferreira 
 * @email davidferreira.fz@gmail.com
 *
 */
public class Counter
{
    /**
     * Coluna da contagem.
     */
    public int column;
    /**
     * Linha da contagem.
     */
    public int line;
    
    //Total de colunas
    private int maxColumn;
    //Total de linhas
    private int maxLine;
    
    /**
     * Construtor
     * @param maxLine informa o total de linhas
     * @param maxColumn informa o total de colunas
     */    
    public Counter(int maxColumn)
    {
        this.column=0;
        this.line=0;      
        this.maxColumn = maxColumn;
//        this.maxLine = maxLine;         
    }

    /**
     * Retorna o indice
     * @return
     */
    public int getIndice()
    {
        return line*column;
    }
    
    @Override
    public String toString()
    {
        return  "Counter ("+line+","+column+")";
    }
    
    /**
     * Avança o contador
     */
    public void next()
    {
        column++;
        
        //Se a coluna for maior que a coluna máxima
        if (column>maxColumn){
            //retorna para a primeira coluna
            column=0;
            //e passa para a próxima linha
            line++;
        }
    }

}
