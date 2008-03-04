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
package net.sourceforge.f2ibuilder.components.dialog;

import java.awt.Component;
import java.io.File;

import javax.swing.JFileChooser;

import net.sourceforge.f2ibuilder.components.dialog.filter.FileImageFilter;
import net.sourceforge.f2ibuilder.components.dialog.filter.FileMetricFilter;




public class FileDialog
{
	static private FileDialog instance;
	
	private JFileChooser dialogImagem;
	private JFileChooser dialogMetrica;	
	private String caminhoImagem;
	private String caminhoMetrica;
	
	private FileDialog()
	{
		dialogImagem   = new JFileChooser();
		dialogMetrica  = new JFileChooser();	
		caminhoImagem  = "";
		caminhoMetrica = "";
		
	
		dialogImagem.setFileFilter(new FileImageFilter());
		dialogMetrica.setFileFilter(new FileMetricFilter());
	}
	
	static public FileDialog getInstance()
	{
		if (instance==null){
			instance = new FileDialog();
		}
		return instance;
	}
	
	public boolean showSaveDialogImage(Component componente)
	{
		int retorno = dialogImagem.showSaveDialog(componente);
		boolean ok = false;
		
		if (retorno == JFileChooser.APPROVE_OPTION) {
			File file = dialogImagem.getSelectedFile();
			caminhoImagem=file.getAbsolutePath();
			dialogMetrica.setCurrentDirectory(dialogImagem.getCurrentDirectory());
			ok=true;
		}
		return ok;		
	}
	
	public String getFilePathImage()
	{
		return caminhoImagem;
	}
	
	public boolean showSaveDialogMetric(Component componente)
	{
		int returnVal = dialogMetrica.showSaveDialog(componente);
		boolean ok = false;
		
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = dialogMetrica.getSelectedFile();
			caminhoMetrica=file.getAbsolutePath();
			dialogImagem.setCurrentDirectory(dialogMetrica.getCurrentDirectory());			
			ok=true;
		}
		return ok;
	}
	
	public String getFilePathMetric()
	{
		return caminhoMetrica;
	}
}
