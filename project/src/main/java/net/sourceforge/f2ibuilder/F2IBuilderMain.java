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
package net.sourceforge.f2ibuilder;

import java.awt.Dimension;
import javax.swing.JOptionPane;
import net.sourceforge.f2ibuilder.application.view.Principal;

/**
 * Classe para iniciar a aplica��o F2IBuilder
 * 
 * @author David Ferreira - davidferreira.fz@gmail.com
 */
public class F2IBuilderMain
{
    protected Principal janela = null;

    /**
     * Cria janela e a centraliza.
     */
    public void criarJanela()
    {
        janela = new Principal();
        Dimension dim = janela.getToolkit().getScreenSize();
        int x = (int) (dim.getWidth() - janela.getSize().getWidth()) / 2;
        int y = (int) (dim.getHeight() - janela.getSize().getHeight()) / 2;
        janela.setLocation(x, y);
        janela.setVisible(true);
    }

    /**
     * Entry point da aplica��o
     * 
     * @param args
     */
    public static void main(String[] args)
    {
        try {
            F2IBuilderMain executar = new F2IBuilderMain();
            executar.criarJanela();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "F2IBuilder: " + e.getMessage());
        }
    }

}
