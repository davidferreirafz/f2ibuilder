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
package net.sourceforge.f2ibuilder.application.view.metrics;

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

import net.sourceforge.f2ibuilder.application.controller.MetricsActionFactory;
import net.sourceforge.f2ibuilder.application.model.FontText;

import com.wordpress.dukitan.componentes.gof.observer.Observer;

/**
 * Classe da tela MetricsLimit.
 * Gerada e mantida pelo plugin Visual Editor da IDE Eclipse.
 * 
 * Designer Pattern: GoF - Observer
 * Implementa mecanismo para receber as notifica��es de mudan�as.
 * 
 * @author David Ferreira - davidferreira.fz@gmail.com
 */
public class MetricsLimit extends JDialog implements Observer{

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JButton jButton = null;

    private FontText fontText = null;  //  @jve:decl-index=0:

	private JButton jButton2 = null;

	private JButton jButton11 = null;

	private JPanel jPanelMenor = null;

	private JPanel jPanelMaior = null;

	private JTextField menorLimite = null;

	private JTextField maiorLimite = null;

	private JPanel jPanel2 = null;

	/**
	 * @param owner
	 */
	public MetricsLimit(Frame owner, FontText fontText) {
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
		this.setTitle("Adjust Metrics Limit");
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
			jButton.addActionListener(MetricsActionFactory.makeSaveMetricLimit(fontText,getMenorLimite(),getMaiorLimite()));
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
            jButton11.addActionListener(MetricsActionFactory.makeResetMetrics(fontText));
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
			jButton2.addActionListener(MetricsActionFactory.makeCloseWindow(this));
		}
		return jButton2;
	}



	/**
	 * This method initializes jPanelMenor	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanelMenor() {
		if (jPanelMenor == null) {
			jPanelMenor = new JPanel();
			jPanelMenor.setLayout(new CardLayout());	
			jPanelMenor.setBorder(BorderFactory.createTitledBorder(null, "Lesser Limit", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
			jPanelMenor.setBounds(new Rectangle(15, 15, 110, 50));
			jPanelMenor.add(getMenorLimite(), getMenorLimite().getName());
		}
		return jPanelMenor;
	}

	/**
	 * This method initializes jPanelMaior	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanelMaior() {
		if (jPanelMaior == null) {
			jPanelMaior = new JPanel();
			jPanelMaior.setLayout(new CardLayout());
			jPanelMaior.setBorder(BorderFactory.createTitledBorder(null, "Bigger Limit", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
			jPanelMaior.setBounds(new Rectangle(150, 15, 110, 50));
			jPanelMaior.add(getMaiorLimite(), getMaiorLimite().getName());
		}
		return jPanelMaior;
	}

	/**
	 * This method initializes menorLimite	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getMenorLimite() {
		if (menorLimite == null) {
			menorLimite = new JTextField();
			menorLimite.setName("menorLimite");
		}
		return menorLimite;
	}

	/**
	 * This method initializes maiorLimite	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getMaiorLimite() {
		if (maiorLimite == null) {
			maiorLimite = new JTextField();
			maiorLimite.setName("maiorLimite");
		}
		return maiorLimite;
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
			jPanel2.add(getJPanelMenor(), null);
			jPanel2.add(getJPanelMaior(), null);
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
        menorLimite.setText(String.valueOf(fontText.getMenorLargura()));
        maiorLimite.setText(String.valueOf(fontText.getMaiorLargura()));
    }
}  //  @jve:decl-index=0:visual-constraint="10,10"
