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

import net.sourceforge.f2ibuilder.application.controller.generics.CloseWindow;
import net.sourceforge.f2ibuilder.application.controller.metrics.ResetMetrics;
import net.sourceforge.f2ibuilder.application.controller.metrics.SaveMetricLimit;
import net.sourceforge.f2ibuilder.application.model.FontText;

import com.wordpress.dukitan.componentes.gof.observer.Observer;

public class MetricsLimit extends JDialog implements Observer{

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JButton jButton = null;

    private FontText tableChar = null;  //  @jve:decl-index=0:

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
	public MetricsLimit(Frame owner, FontText tableChar) {
        super(owner);
        this.tableChar = tableChar;
        initialize();        
        
        tableChar.register(this);            
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
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
//TODO: remover dependencia			
//			jButton.addActionListener((java.awt.event.ActionListener) ActionListener.getInstance());
			jButton.addActionListener(new SaveMetricLimit(tableChar,getMenorLimite(),getMaiorLimite()));
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
            jButton11.addActionListener(new ResetMetrics(tableChar));
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
			jButton2.addActionListener(new CloseWindow(this));
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

    @Override
    public void update()
    {
        menorLimite.setText(String.valueOf(tableChar.getMenorLargura()));
        maiorLimite.setText(String.valueOf(tableChar.getMaiorLargura()));
    }
}  //  @jve:decl-index=0:visual-constraint="10,10"
