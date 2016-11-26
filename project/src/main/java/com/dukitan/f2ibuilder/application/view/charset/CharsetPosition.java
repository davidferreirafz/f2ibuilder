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
package com.dukitan.f2ibuilder.application.view.charset;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Rectangle;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import com.dukitan.componentes.gof.observer.Observer;
import com.dukitan.f2ibuilder.application.controller.CharsetActionFactory;
import com.dukitan.f2ibuilder.application.model.FontText;

/**
 * Classe da tela MetricsLimit.
 * Gerada e mantida pelo plugin Visual Editor da IDE Eclipse.
 * 
 * Designer Pattern: GoF - Observer
 * Implementa mecanismo para receber as notifica��es de mudan�as.
 * 
 * @author David Ferreira - davidferreira.fz@gmail.com
 */
public class CharsetPosition extends JDialog implements Observer{

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JButton jButton = null;

    private FontText fontText = null;  //  @jve:decl-index=0:

	private JButton jButton2 = null;

	private JButton jButton11 = null;

	private JPanel jPanelWidth = null;

	private JPanel jPanelHeight = null;

	private JTextField ajusteLargura = null;

	private JTextField ajusteAltura = null;

	private JPanel jPanel2 = null;

	/**
	 * @param owner
	 */
	public CharsetPosition(Frame owner, FontText fontText) {
        super(owner);
        this.fontText = fontText;
        initialize();        
        
        fontText.register(this);            
	}

	/**
	 * This method initializes this
	 */
	private void initialize() {
		this.setSize(280, 200);
		this.setContentPane(getJContentPane());
		this.setResizable(false);
		this.setAlwaysOnTop(true);
		this.setTitle("Adjust Charset Position");
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
			jContentPane.add(getJButton(), null);
			jContentPane.add(getJButton2(), null);
			jContentPane.add(getJButton11(), null);
			jContentPane.add(getJPanel2(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setBounds(new Rectangle(15, 105, 85, 25));
			jButton.setText("Apply");
			jButton.addActionListener(CharsetActionFactory.makeSaveCharsetPosition(fontText,getAjusteLargura(),getAjusteAltura()));
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
            jButton11.setBounds(new Rectangle(15, 135, 85, 25));
            jButton11.setText("Reset");
            jButton11.addActionListener(CharsetActionFactory.makeResetCharsetPosition(fontText));
        }
        return jButton11;
    }

	/**
	 * This method initializes jButton2	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton2() {
		if (jButton2 == null) {
			jButton2 = new JButton();
			jButton2.setBounds(new Rectangle(180, 135, 85, 25));
			jButton2.setText("Close");
			jButton2.setActionCommand("Fechar");
			jButton2.addActionListener(CharsetActionFactory.makeCloseWindow(this));
		}
		return jButton2;
	}



	/**
	 * This method initializes jPanelMenor	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanelLargura() {
		if (jPanelWidth == null) {
			jPanelWidth = new JPanel();
			jPanelWidth.setLayout(new CardLayout());	
			jPanelWidth.setBorder(BorderFactory.createTitledBorder(null, "Width (right)", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
			jPanelWidth.setBounds(new Rectangle(15, 15, 110, 50));
			jPanelWidth.add(getAjusteLargura(), getAjusteLargura().getName());
		}
		return jPanelWidth;
	}

	/**
	 * This method initializes jPanelMaior	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanelAltura() {
		if (jPanelHeight == null) {
			jPanelHeight = new JPanel();
			jPanelHeight.setLayout(new CardLayout());
			jPanelHeight.setBorder(BorderFactory.createTitledBorder(null, "Height (upper)", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
			jPanelHeight.setBounds(new Rectangle(150, 15, 110, 50));
			jPanelHeight.add(getAjusteAltura(), getAjusteAltura().getName());
		}
		return jPanelHeight;
	}

	/**
	 * This method initializes menorLimite	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getAjusteLargura() {
		if (ajusteLargura == null) {
			ajusteLargura = new JTextField();
			ajusteLargura.setName("ajusteLargura");
		}
		return ajusteLargura;
	}

	/**
	 * This method initializes maiorLimite	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getAjusteAltura() {
		if (ajusteAltura == null) {
			ajusteAltura = new JTextField();
			ajusteAltura.setName("ajusteAltura");
		}
		return ajusteAltura;
	}

	/**
	 * This method initializes jPanel2	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel2() {
		if (jPanel2 == null) {
			jPanel2 = new JPanel();
			jPanel2.setLayout(null);
			jPanel2.setBounds(new Rectangle(0, 0, 271, 91));
			jPanel2.add(getJPanelLargura(), null);
			jPanel2.add(getJPanelAltura(), null);
		}
		return jPanel2;
	}


    /**
     * Implementa��o da notifica��o de mudan�as nos objetos Observable.
     * 
     * @see Observer
     */
    public void update()
    {
        ajusteLargura.setText(String.valueOf(fontText.getPositionAdjust().width));
        ajusteAltura.setText(String.valueOf(fontText.getPositionAdjust().height));
    }
}  //  @jve:decl-index=0:visual-constraint="10,10"
