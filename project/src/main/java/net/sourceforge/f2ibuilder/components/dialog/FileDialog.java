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
package net.sourceforge.f2ibuilder.components.dialog;

import java.awt.Component;
import java.io.File;

import javax.swing.JFileChooser;

import net.sourceforge.f2ibuilder.components.dialog.filter.FileImageFilter;
import net.sourceforge.f2ibuilder.components.dialog.filter.FileMetricFilter;
import net.sourceforge.f2ibuilder.components.dialog.filter.FileProjectFilter;

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
	private JFileChooser dialogProject;
	
	//Caminhos dos arquivos
	private String imageFilePath;
	private String metricFilePath;
    private String projectFilePath;	
	
	/**
	 * Construtor privado para implementa��o do Singleton
	 */
	private FileDialog()
	{
		dialogImagem   = new JFileChooser();
		dialogMetrica  = new JFileChooser();
		dialogProject  = new JFileChooser();
		
		imageFilePath   = "";
		metricFilePath  = "";		
		projectFilePath = "";
	
		dialogImagem.setFileFilter(new FileImageFilter());
		dialogMetrica.setFileFilter(new FileMetricFilter());
		dialogProject.setFileFilter(new FileProjectFilter());		
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
    /**
     * @param component
     * @return
     */
    public boolean showSaveDialogProject(Component component)
    {
        int codeOption = dialogProject.showSaveDialog(component);
        boolean ok = false;
        
        if (codeOption == JFileChooser.APPROVE_OPTION) {
            File file = dialogProject.getSelectedFile();
            
            projectFilePath=file.getAbsolutePath();

            ok=true;
        }
        
        return ok;
    }
    
    public boolean showOpenDialogProject(Component component)
    {
        int codeOption = dialogProject.showOpenDialog(component);
        boolean ok = false;
        
        if (codeOption == JFileChooser.APPROVE_OPTION) {
            File file = dialogProject.getSelectedFile();
            
            projectFilePath=file.getAbsolutePath();

            ok=true;
        }
        
        return ok;
    }    
    /**
     * @return
     */
    public String getFilePathProject()
    {
        return projectFilePath;
    }
}
