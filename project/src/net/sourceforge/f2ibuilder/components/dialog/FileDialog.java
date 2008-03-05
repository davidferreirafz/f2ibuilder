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
package net.sourceforge.f2ibuilder.components.dialog;

import java.awt.Component;
import java.io.File;

import javax.swing.JFileChooser;

import net.sourceforge.f2ibuilder.components.dialog.filter.FileImageFilter;
import net.sourceforge.f2ibuilder.components.dialog.filter.FileMetricFilter;

/**
 * Caixa de Dialogo para salvar os arquivos.
 * Esta classe suporte as op��es de salvar a imagem e a m�trica das fontes.
 * 
 * Designer Pattern: Singleton
 * 
 * @author David Ferreira - davidferreira.fz@gmail.com
 */
public class FileDialog
{
    //inst�ncia �nica da classe
	static private FileDialog instance;
	
	//Caixas de dialogo para salvar
	private JFileChooser dialogImagem;
	private JFileChooser dialogMetrica;
	//Caminhos dos arquivos
	private String imageFilePath;
	private String metricFilePath;
	
	/**
	 * Construtor privado para implementa��o do Singleton
	 */
	private FileDialog()
	{
		dialogImagem   = new JFileChooser();
		dialogMetrica  = new JFileChooser();	
		imageFilePath  = "";
		metricFilePath = "";		
	
		dialogImagem.setFileFilter(new FileImageFilter());
		dialogMetrica.setFileFilter(new FileMetricFilter());
	}
	/**
	 * Retorna a inst�ncia de FileDialog.
	 * @return inst�ncia de FileDialog
	 */
	static public FileDialog getInstance()
	{
		if (instance==null){
			instance = new FileDialog();
		}
		return instance;
	}
	/**
	 * Exibe a caixa de dialogo para salvar a imagem.
	 * @param componente 
	 * @return true em caso de sucesso
	 */
	public boolean showSaveDialogImage(Component componente)
	{
		int codeOption = dialogImagem.showSaveDialog(componente);
		boolean ok = false;
		
		if (codeOption == JFileChooser.APPROVE_OPTION) {
			File file = dialogImagem.getSelectedFile();
			
			imageFilePath=file.getAbsolutePath();
			
			dialogMetrica.setCurrentDirectory(dialogImagem.getCurrentDirectory());
			ok=true;
		}
		
		return ok;		
	}
	/**
	 * Retorna o caminho da imagem 
     * @return caminho do arquivo
	 */
	public String getFilePathImage()
	{
		return imageFilePath;
	}
	
	/**
     * Exibe a caixa de dialogo para salvar a imagem.
	 * @param componente
     * @return true em caso de sucesso
	 */
	public boolean showSaveDialogMetric(Component componente)
	{
		int codeOption = dialogMetrica.showSaveDialog(componente);
		boolean ok = false;
		
		if (codeOption == JFileChooser.APPROVE_OPTION) {
			File file = dialogMetrica.getSelectedFile();
			
			metricFilePath=file.getAbsolutePath();
			
			dialogImagem.setCurrentDirectory(dialogMetrica.getCurrentDirectory());			
			ok=true;
		}
		
		return ok;
	}
    /**
     * Retorna o caminho do arquivo de m�tricas.
     * @return caminho do arquivo
     */
	public String getFilePathMetric()
	{
		return metricFilePath;
	}
}
