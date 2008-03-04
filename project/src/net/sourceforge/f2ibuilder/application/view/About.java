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
import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import net.sourceforge.f2ibuilder.application.controller.generics.CloseWindow;
import net.sourceforge.f2ibuilder.application.controller.generics.OpenWebSite;
import net.sourceforge.f2ibuilder.util.Constants;

import com.wordpress.dukitan.componentes.ui.image.ImagePanel;

public class About extends JDialog {

	private static final long serialVersionUID = 6054475434937524760L;
	private JButton jButton = null;
	private JPanel jPanel = null;
	private ImagePanel jPanel1 = null;
	private JPanel jPanel2 = null;
	private JLabel jLabel7 = null;
	private JPanel jPanel3 = null;
	private JLabel jLabel8 = null;
	private JPanel jPanel4 = null;
	private JLabel jLabel9 = null;
	private JPanel jPanel5 = null;
	private JLabel jLabel10 = null;
	private JPanel jPanel6 = null;
	private JLabel jLabel = null;
	private JPanel jPanel7 = null;
	private JLabel jLabel1 = null;
	

	
	/**
	 * This is the default constructor
	 */
	public About() {    
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(396, 452);
		this.setContentPane(getJPanel());
		this.setResizable(false);
		this.setAlwaysOnTop(true);
		this.setTitle("About :: F2IBuidler - Font To Image Builder");
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
			jButton.setBounds(new java.awt.Rectangle(135,375,121,28));
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
			jPanel.add(getJPanel1(), null);
			jPanel.add(getJButton(), null);
			jPanel.add(getJPanel2(), null);
			jPanel.add(getJPanel3(), null);
			jPanel.add(getJPanel4(), null);
			jPanel.add(getJPanel5(), null);
			jPanel.add(getJPanel6(), null);
			jPanel.add(getJPanel7(), null);
			
		}
		return jPanel;
	}

	/**
	 * This method initializes jPanel1	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel1() {
		if (jPanel1 == null) {
			jPanel1 = new ImagePanel();
			jPanel1.setBounds(new java.awt.Rectangle(15,15,151,106));
			jPanel1.loadImage(".//resource/david_ferreira.jpg");
		}
		return jPanel1;
	}

	/**
	 * This method initializes jPanel2	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel2() {
		if (jPanel2 == null) {
			jLabel7 = new JLabel();
			jLabel7.setText("  David de Almeida Ferreira");
			jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
			jLabel7.setName("jLabel7");
			jPanel2 = new JPanel();
			jPanel2.setLayout(new CardLayout());
			jPanel2.setBounds(new java.awt.Rectangle(180,15,196,37));
			jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Author", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, null));
			jPanel2.add(jLabel7, jLabel7.getName());
		}
		return jPanel2;
	}

	/**
	 * This method initializes jPanel3	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel3() {
		if (jPanel3 == null) {
			jLabel8 = new JLabel();
			jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
			jLabel8.setText("  davidferreira.fz@gmail.com");
			jLabel8.setName("jLabel8");
			jPanel3 = new JPanel();
			jPanel3.setLayout(new CardLayout());
			jPanel3.setBounds(new java.awt.Rectangle(180,75,196,46));
			jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "E-Mail / G.Talk", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12), new java.awt.Color(51,51,51)));
			jPanel3.add(jLabel8, jLabel8.getName());
		}
		return jPanel3;
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
			jLabel9.setName("jLabel8");
			jLabel9.addMouseListener(new OpenWebSite());
			jPanel4 = new JPanel();
			jPanel4.setLayout(new CardLayout());
			jPanel4.setBounds(new java.awt.Rectangle(15,195,361,46));
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
			jLabel10 = new JLabel();
			jLabel10.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
			jLabel10.setText("  21877381 / davidaf@uol.com.br");
			jLabel10.setName("jLabel8");
			jPanel5 = new JPanel();
			jPanel5.setLayout(new CardLayout());
			jPanel5.setBounds(new java.awt.Rectangle(15,135,361,46));
			jPanel5.setBorder(BorderFactory.createTitledBorder(null, "ICQ / MSN", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
			jPanel5.add(jLabel10, jLabel10.getName());
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
			jLabel.setText(Constants.VERSAO_EXPLICITA);
			jLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
			jLabel.setName("jLabel6");
			jPanel6 = new JPanel();
			jPanel6.setLayout(new CardLayout());
			jPanel6.setBounds(new java.awt.Rectangle(15,255,361,46));
			jPanel6.setBorder(BorderFactory.createTitledBorder(null, "Info", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
			jPanel6.add(jLabel, jLabel.getName());
		}
		return jPanel6;
	}

	/**
	 * This method initializes jPanel7	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel7() {
		if (jPanel7 == null) {
			jLabel1 = new JLabel();
			jLabel1.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
			jLabel1.setText("Fortaleza - Ceará - Brasil");
			jLabel1.setName("jLabel6");
			jPanel7 = new JPanel();
			jPanel7.setLayout(new CardLayout());
			jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Made in", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12), new java.awt.Color(51,51,51)));
			jPanel7.setName("jPanel7");
			jPanel7.setBounds(new java.awt.Rectangle(15,315,361,42));
			jPanel7.add(jLabel1, jLabel1.getName());
		}
		return jPanel7;
	}

}  //  @jve:decl-index=0:visual-constraint="12,0"
