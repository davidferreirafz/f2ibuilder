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
package com.dukitan.f2ibuilder.application.view.metrics;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Rectangle;

import javax.swing.BorderFactory;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.basic.BasicPanelUI;
import javax.swing.table.DefaultTableModel;

import com.dukitan.componentes.gof.observer.Observer;
import com.dukitan.f2ibuilder.application.controller.MetricsActionFactory;
import com.dukitan.f2ibuilder.application.model.FontText;

/**
 * Classe da tela MetricsMap.
 * Gerada e mantida pelo plugin Visual Editor da IDE Eclipse.
 * 
 * Designer Pattern: GoF - Observer
 * Implementa mecanismo para receber as notifica��es de mudan�as.
 * 
 * @author David Ferreira - davidferreira.fz@gmail.com
 */
public class MetricsMap extends JDialog implements Observer{

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JPanel Charset = null;

	private JButton jButton = null;

	private JTable jTable = null;
	
    private FontText fontText = null;  //  @jve:decl-index=0:

	private JButton jButton2 = null;

	private JPanel panelPreview = null;

	private JLabel asciiLabel = null;

	private JButton jButton11 = null;

	private JPanel panelPreviewFormatado = null;

	private JLabel formatLabel = null;

	/**
	 * @param owner
	 */
	public MetricsMap(Frame owner, FontText fontText) {
        super(owner);
        this.fontText = fontText;
		initialize();
		
		fontText.register(this);
	}

	/**
	 * This method initializes this
	 */
	private void initialize() {
		this.setSize(479, 395);
		this.setContentPane(getJContentPane());
		this.setResizable(false);
		this.setAlwaysOnTop(true);
		this.setTitle("Adjust Metrics Map");
		Dimension dim = getToolkit().getScreenSize(); 		
		int x = (int) (dim.getWidth()  - getSize().getWidth() )/2;
		int y = (int) (dim.getHeight() - getSize().getHeight())/2;
		this.setLocation(x,y);	
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getCharset(), null);
			jContentPane.add(getJButton(), null);
			jContentPane.add(getJButton2(), null);
			jContentPane.add(getPanelPreview(), null);
			jContentPane.add(getJButton11(), null);
			jContentPane.add(getPanelPreviewFormatado(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes Charset	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getCharset() {
		if (Charset == null) {
			Charset = new JPanel();
			Charset.setLayout(new CardLayout());
			Charset.setBounds(new Rectangle(7, 12, 459, 283));
			Charset.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			Charset.setCursor(new Cursor(Cursor.HAND_CURSOR));
			Charset.setMaximumSize(new Dimension(400, 400));
			Charset.setMinimumSize(new Dimension(400, 400));
			Charset.setPreferredSize(new Dimension(400, 400));
			Charset.setUI(new BasicPanelUI());
			Charset.setBorder(BorderFactory.createTitledBorder(null, "Metrics Map", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
			Charset.setVerifyInputWhenFocusTarget(false);
			Charset.add(getJTable(), getJTable().getName());
		}
		return Charset;
	}

	/**
	 * This method initializes jButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setBounds(new Rectangle(10, 305, 85, 25));
			jButton.setText("Apply");
			jButton.addActionListener(MetricsActionFactory.makeSaveMetric(fontText,getJTable()));
		}
		return jButton;
	}

    /**
     * This method initializes jButton11    
     *  
     * @return javax.swing.JButton  
     */
    private JButton getJButton11() {
        if (jButton11 == null) {
            jButton11 = new JButton();
            jButton11.setBounds(new Rectangle(100, 305, 85, 25));
            jButton11.setText("Reset");
            jButton11.addActionListener(MetricsActionFactory.makeResetMetrics(fontText));
        }
        return jButton11;
    }	
	
	/**
	 * This method initializes jTable	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getJTable() {
		if (jTable == null) {
			DefaultTableModel defaultTableModel = new DefaultTableModel();
			defaultTableModel.setColumnCount(16);
			defaultTableModel.setNumRows(16);
			jTable = new JTable();
			jTable.setCellSelectionEnabled(true);
			jTable.setSelectionModel(new DefaultListSelectionModel());
			jTable.setName("jTable");
			jTable.setModel(defaultTableModel);
			jTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
			jTable.addMouseListener(MetricsActionFactory.makeSelectMetric(jTable,fontText,getAsciiLabel(),getFormatLabel()));
		}
		
		return jTable;
	}


	/**
	 * This method initializes jButton2	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton2() {
		if (jButton2 == null) {
			jButton2 = new JButton();
			jButton2.setBounds(new Rectangle(216, 305, 85, 25));
			jButton2.setText("Close");
			jButton2.setActionCommand("Fechar");
			jButton2.addActionListener(MetricsActionFactory.makeCloseWindow(this));
		}
		return jButton2;
	}

	/**
	 * This method initializes Preview	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPanelPreview() {
		if (panelPreview == null) {
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.gridx = 0;
			gridBagConstraints.gridy = 0;
			panelPreview = new JPanel();
			panelPreview.setLayout(new GridBagLayout());
			panelPreview.setBounds(new Rectangle(317, 300, 66, 55));
			panelPreview.setFont(new Font("Dialog", Font.BOLD, 18));
			panelPreview.setBorder(BorderFactory.createTitledBorder(null, "ASCII", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
			panelPreview.add(getAsciiLabel(), gridBagConstraints);
		}
		return panelPreview;
	}



	/**
	 * This method initializes panelPreviewFormatado	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPanelPreviewFormatado() {
		if (panelPreviewFormatado == null) {
			TitledBorder titledBorder = BorderFactory.createTitledBorder(null, "Preview", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51));
			titledBorder.setBorder(null);
			titledBorder.setTitle("Preview");
			GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
			gridBagConstraints11.gridx = 1;
			gridBagConstraints11.gridy = 0;
			panelPreviewFormatado = new JPanel();
			panelPreviewFormatado.setLayout(new GridBagLayout());
			panelPreviewFormatado.setBounds(new Rectangle(390, 300, 65, 55));
			panelPreviewFormatado.setFont(new Font("Dialog", Font.BOLD, 18));
			panelPreviewFormatado.setBorder(titledBorder);
			panelPreviewFormatado.add(getFormatLabel(), gridBagConstraints11);
		}
		return panelPreviewFormatado;
	}

    private JLabel getAsciiLabel()
    {
        if (asciiLabel == null){
            asciiLabel = new JLabel();
            asciiLabel.setText("-");
            asciiLabel.setFont(new Font("Dialog", Font.BOLD, 18));
        }
        return asciiLabel;
    }
    
    private JLabel getFormatLabel()
    {
        if (formatLabel == null){
            formatLabel = new JLabel();
            formatLabel.setEnabled(true);
            formatLabel.setText("-");
            formatLabel.setFont(new Font("Dialog", Font.BOLD, 18));
        }
        
        return formatLabel;
    }
    

    /**
     * Implementa��o da notifica��o de mudan�as nos objetos Observable.
     * 
     * @see Observer
     */
    public void update()
    {
        int caracter=0;
        for (int l=0; l<16; l++){
            for (int c=0;c<16;c++){
                String o = String.valueOf(fontText.getCharacterMetric(caracter));
                jTable.getModel().setValueAt(o,l, c);
                caracter++;             
            }
        }
    }
}  //  @jve:decl-index=0:visual-constraint="10,10"
