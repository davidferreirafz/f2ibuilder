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
package net.sourceforge.f2ibuilder.components.dialog.filter;

import com.wordpress.dukitan.componentes.util.FileInfo;

/**
 * Classe para filtrar a exibição dos arquivos,
 * exibe apenas os arquivos PNG ou BMP de imagens.
 * 
 * @author David Ferreira 
 * @email davidferreira.fz@gmail.com
 *
 */
public class FileImageFilter extends DialogFileFilter
{
    /**
     * Verifica se o arquivo passado é aceito.
     * Obs.: Este método implementa o Designer Pattern "GoF - Template Method".
     * 
     * @param info instância de FileInfo
     * @return true em caso de sucesso
     */
    protected boolean isAccept(FileInfo info)
    {
        return info.isImage();
    }
    
    @Override
    /**
     * Retorna o texto de exibição dos tipos aceitos.
     * @return tipos aceitos 
     */
	public String getDescription()
	{
	    return "PNG or BMP Files";
	}
}
