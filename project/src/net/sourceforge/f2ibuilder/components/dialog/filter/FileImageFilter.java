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
package net.sourceforge.f2ibuilder.components.dialog.filter;

import com.wordpress.dukitan.componentes.util.FileInfo;

/**
 * Classe para filtrar a exibi��o dos arquivos,
 * exibe apenas os arquivos PNG ou BMP de imagens.
 * 
 * @author David Ferreira 
 * @email davidferreira.fz@gmail.com
 *
 */
public class FileImageFilter extends DialogFileFilter
{
    /**
     * Verifica se o arquivo passado � aceito.
     * Obs.: Este m�todo implementa o Designer Pattern "GoF - Template Method".
     * 
     * @param info inst�ncia de FileInfo
     * @return true em caso de sucesso
     */
    protected boolean isAccept(FileInfo info)
    {
        return info.isImage();
    }
    
    @Override
    /**
     * Retorna o texto de exibi��o dos tipos aceitos.
     * @return tipos aceitos 
     */
	public String getDescription()
	{
	    return "PNG or BMP Files";
	}
}
