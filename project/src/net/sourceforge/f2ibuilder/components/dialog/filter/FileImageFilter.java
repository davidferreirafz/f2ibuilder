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
package net.sourceforge.f2ibuilder.components.dialog.filter;

import java.io.File;

import javax.swing.filechooser.FileFilter;

import com.wordpress.dukitan.componentes.util.FileInfo;

public class FileImageFilter extends FileFilter
{
	public boolean accept(File f)
	{
	 	if (f.isDirectory()) {
            return true;
        }
	 	
        FileInfo fi = new FileInfo(f);
        
        return fi.isImage();
	}
    
	public String getDescription()
	{
	    return "PNG or BMP Files";
	}



}
