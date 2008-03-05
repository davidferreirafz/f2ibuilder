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
package net.sourceforge.f2ibuilder.application.view;

import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

import net.sourceforge.f2ibuilder.application.controller.generics.CloseWindow;
import net.sourceforge.f2ibuilder.application.controller.generics.OpenWebSite;
import net.sourceforge.f2ibuilder.util.Constants;

import com.wordpress.dukitan.componentes.ui.image.ImagePanel;

/**
 * Classe da tela Credit.
 * Gerada e mantida pelo plugin Visual Editor da IDE Eclipse.
 * 
 * @author David Ferreira 
 * @email davidferreira.fz@gmail.com
 *
 */
public class Credit extends JDialog {

	private static final long serialVersionUID = 6054475434937524760L;
	private JButton jButton = null;
	private JPanel jPanel = null;
	private JPanel jPanel4 = null;
	private JPanel jPanel5 = null;
	private JPanel jPanel6 = null;
	private JLabel jLabel = null;
	private JLabel jLabel9 = null;	
	private JTextArea jTextArea = null;
	private ImagePanel imagePanel = null;
	
    
	/**
	 * This is the default constructor
	 */
	public Credit() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(409, 396);
		this.setContentPane(getJPanel());
		this.setResizable(false);
		this.setAlwaysOnTop(true);
		this.setTitle("About :: Credits");
		Dimension dim = getToolkit().getScreenSize(); 		
		int x = (int) (dim.getWidth()  - getSize().getWidth() )/2;
		int y = (int) (dim.getHeight() - getSize().getHeight())/2;
		this.setLocation(x,y);
	}

	/**
	 * This method initializes jButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setText("Ok");
			jButton.setBounds(new java.awt.Rectangle(135,315,136,28));
			jButton.addActionListener(new CloseWindow(this));
		}
		return jButton;
	}

	/**
	 * This method initializes jPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel() {
		if (jPanel == null) {
			jPanel = new JPanel();
			jPanel.setLayout(null);
			jPanel.add(getJButton(), null);
			jPanel.add(getJPanel4(), null);
			jPanel.add(getJPanel5(), null);
			jPanel.add(getJPanel6(), null);
			jPanel.add(getImagePanel(), null);
			
		}
		return jPanel;
	}

	/**
	 * This method initializes jPanel4	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel4() {
		if (jPanel4 == null) {
			jLabel9 = new JLabel();
			jLabel9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
			jLabel9.setText("  "+Constants.WEB_SITE);
			jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
			jLabel9.setName("jLabel8");
			jLabel9.addMouseListener(new OpenWebSite());
			jPanel4 = new JPanel();
			jPanel4.setLayout(new CardLayout());
			jPanel4.setBounds(new java.awt.Rectangle(105,60,286,46));
			jPanel4.setBorder(BorderFactory.createTitledBorder(null, "Site", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
			jPanel4.add(jLabel9, jLabel9.getName());
		}
		return jPanel4;
	}

	/**
	 * This method initializes jPanel5	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel5() {
		if (jPanel5 == null) {		
			jPanel5 = new JPanel();
			jPanel5.setLayout(new CardLayout());
			jPanel5.setBounds(new java.awt.Rectangle(15,105,376,196));
			jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thanks", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12), new java.awt.Color(51,51,51)));
			jPanel5.add(getJTextArea(), getJTextArea().getName());
		}
		return jPanel5;
	}

	/**
	 * This method initializes jPanel6	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel6() {
		if (jPanel6 == null) {
			jLabel = new JLabel();
			jLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
			jLabel.setText(Constants.TITULO+" - "+Constants.GPL);
			jLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
			jLabel.setName("jLabel6");
			jPanel6 = new JPanel();
			jPanel6.setLayout(new CardLayout());
			jPanel6.setBounds(new java.awt.Rectangle(105,15,286,46));
			jPanel6.setBorder(BorderFactory.createTitledBorder(null, "Info", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
			jPanel6.add(jLabel, jLabel.getName());
		}
		return jPanel6;
	}

	/**
	 * This method initializes jTextArea	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getJTextArea() {
		if (jTextArea == null) {
			jTextArea = new JTextArea();
			jTextArea.setName("jTextArea");
			jTextArea.setEditable(false);
			jTextArea.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
			jTextArea.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.lightGray,1));
			jTextArea.setLineWrap(true);
			StringBuffer texto = new StringBuffer();
			texto.append("Alexandre Ribeiro de Sá <alexandreribeirodesa at msn.com>\n");
			texto.append("Alysson Bandeira <alyssonbandeira at gmail.com>\n");
			texto.append("Christiano Milfont <cmilfont at gmail.com>\n");
			texto.append("David G. Maziero <dgmdavid at bol.com.br>\n");
			jTextArea.setText(texto.toString());
		}
		return jTextArea;
	}

	/**
	 * This method initializes imagePanel	
	 * 	
	 * @return br.org.codigolivre.pjmoo.f2ibuilder.ui.componente.ImagePanel	
	 */
	private ImagePanel getImagePanel() {
		if (imagePanel == null) {
			imagePanel = new ImagePanel();
			imagePanel.setBounds(new java.awt.Rectangle(15,14,76,77));
			imagePanel.loadImage(".//resource/dukitan.png");			
		}
		return imagePanel;
	}

}  //  @jve:decl-index=0:visual-constraint="12,0"
