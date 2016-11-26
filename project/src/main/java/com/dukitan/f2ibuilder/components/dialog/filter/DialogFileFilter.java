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
package com.dukitan.f2ibuilder.components.dialog.filter;

import java.io.File;

import javax.swing.filechooser.FileFilter;

import com.dukitan.componentes.util.FileInfo;

/**
 * Classe de filtros, permite filtras os tipos de arquivos aceitos.
 * 
 * Designer Pattern: GoF - Template Method
 * 
 * @author David Ferreira - davidferreira.fz@gmail.com
 */
public abstract class DialogFileFilter extends FileFilter
{
    /**
     * Verifica se o tipo de arquivo passado � v�lido pelo filtro.
     * 
     * @param file Arquivo
     * @return true em caso de sucesso
     */
	final public boolean accept(File file)
	{
	 	if (file.isDirectory()) {
            return true;
        }
	 	
        FileInfo fileInfo = new FileInfo(file);
        
        return isAccept(fileInfo);
	}

    /**
     * Verifica se o arquivo passado � aceito.
     * Obs.: Este m�todo implementa o Designer Pattern "GoF - Template Method".
     * 
     * @param info inst�ncia de FileInfo
     * @return true em caso de sucesso
     */	
	protected abstract boolean isAccept(FileInfo info);
}
