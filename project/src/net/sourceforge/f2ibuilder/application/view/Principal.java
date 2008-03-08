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

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Rectangle;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

import net.sourceforge.f2ibuilder.application.controller.PrincipalActionFactory;
import net.sourceforge.f2ibuilder.application.controller.mediator.Colleague;
import net.sourceforge.f2ibuilder.application.controller.mediator.MediatorView;
import net.sourceforge.f2ibuilder.application.model.FontText;
import net.sourceforge.f2ibuilder.application.model.Options;
import net.sourceforge.f2ibuilder.application.view.image.FontImage;
import net.sourceforge.f2ibuilder.application.view.image.SurfacePanel;
import net.sourceforge.f2ibuilder.components.panel.ColorGroup;
import net.sourceforge.f2ibuilder.util.Constants;

import com.wordpress.dukitan.componentes.ui.combobox.ComboBox;
import com.wordpress.dukitan.componentes.ui.combobox.ComboFonte;

/**
 * Classe da tela Principal.
 * Gerada e mantida pelo plugin Visual Editor da IDE Eclipse.
 * 
 * @author David Ferreira - davidferreira.fz@gmail.com
 */
public class Principal extends JFrame
{

	private static final long serialVersionUID = -2624245426643411739L;
	
	private JPanel jPanel = null;
	private ComboFonte comboFonte = null;

	private SurfacePanel workspace = null;

	private JMenuBar jJMenuBar = null;

	private JMenu menuFile = null;

	private JMenu menuAjuda = null;

	private JMenuItem itemSaveImage = null;

	private JMenuItem itemSaveFontMetrics = null;
	
    private JMenuItem itemExportToXNA = null;

	private JToolBar toolBar = null;

	private JPanel jPanel1 = null;

	private ComboBox comboTamanho = null;

	private JPanel jPanel2 = null;

	private JPanel jPanel3 = null;

	private ColorGroup colorGroupo = null;

	private JToggleButton botaoNegrito = null;

	private JMenu menuConfiguracao = null;

	private JCheckBoxMenuItem menuItemShowGrid = null;

	private JMenu menuImageType = null;

	private JRadioButtonMenuItem itemImageTypePNG = null;

	private JRadioButtonMenuItem itemImageTypeBMP = null;

	private JMenu menuShadow = null;

	private JMenu menuShadowVertical = null;

	private JMenu menuShadowHorizontal = null;

	private JRadioButtonMenuItem radioShadowHorizontalNone = null;

	private JRadioButtonMenuItem radioShadowHorizontalLeft = null;

	private JRadioButtonMenuItem radioShadowHorizontalRight = null;

	private JRadioButtonMenuItem radioShadowVerticalNone = null;

	private JRadioButtonMenuItem radioShadowVerticalUp = null;

	private JRadioButtonMenuItem radioShadowVerticalDown = null;

	private JCheckBoxMenuItem menuItemUseMetric = null;

	private JMenu menuCharacterSet = null;

	private JRadioButtonMenuItem radioCharacterSetFull = null;

	private JRadioButtonMenuItem radioCharacterSetNumeric = null;

	private JMenuItem menuSobre = null;

	private JMenuItem menuWebSite = null;
	
	private JPanel jPanel4 = null;

	private ComboBox comboTexturaSize = null;

	private JMenuItem menuCreditos = null;

	private JCheckBoxMenuItem menuItemAntialias = null;

	private JMenuItem menuItemAdjustCharset = null;

	private JMenu menuAvancado = null;

	private JMenuItem menuItemAdjustMetrics = null;

	private JMenuItem menuItemMetricsLimit = null;

	private JScrollPane jScrollPane = null;

    private Options options;
    private FontText fontText;

    private JCheckBoxMenuItem menuItemUseAlpha;
    private MediatorView mediador;
	
	/**
	 * This is the default constructor
	 */
	public Principal() {
		super();
        getOptions();
		getFontText();
		
		mediador = MediatorView.getInstance();		
		Colleague.setMediator(mediador);
		
		initialize();
	}

	private FontText getFontText()
	{
	    if (fontText==null){
	        fontText = FontText.getInstance();
	    }
	    
	    return fontText;
	}
	
    private Options getOptions()
    {
        if (options==null){
            options = Options.getInstance();
        }
        
        return options;
    }	
	
	protected SurfacePanel getImagePanel()
	{
		return (SurfacePanel)getWorkspace();
	}
	
	/**
	 * This method initializes this
	 */
	private void initialize() {
		this.setSize(634, 300);
		this.setPreferredSize(new java.awt.Dimension(520,300));
		this.setJMenuBar(getJJMenuBar());
		this.setMinimumSize(new java.awt.Dimension(640,480));
		this.setContentPane(getJPanel());
		this.setComponentOrientation(java.awt.ComponentOrientation.LEFT_TO_RIGHT);
		this.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		this.setResizable(true);
		this.setTitle(Constants.TITULO);
		this.addWindowListener(PrincipalActionFactory.makeLoadApplication(getFontText(),getComboFonte(),getComboTamanho()));
	}

	/**
	 * This method initializes jPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel() {
		if (jPanel == null) {
			jPanel = new JPanel();
			jPanel.setLayout(new BorderLayout());
			jPanel.setComponentOrientation(java.awt.ComponentOrientation.LEFT_TO_RIGHT);
			jPanel.setPreferredSize(new java.awt.Dimension(512,512));
			jPanel.add(getToolBar(), java.awt.BorderLayout.NORTH);
			jPanel.add(getJScrollPane(),java.awt.BorderLayout.CENTER);
		}
		return jPanel;
	}

	/**
	 * This method initializes comboURL	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getComboFonte() {
		if (comboFonte == null) {
			comboFonte = new ComboFonte();
			comboFonte.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
			comboFonte.setEditable(false);
			comboFonte.setComponentOrientation(java.awt.ComponentOrientation.LEFT_TO_RIGHT);
			comboFonte.setName("comboFonte");
            comboFonte.addItemListener(PrincipalActionFactory.makeSelectFontCommand(getOptions(),getFontText()));			
		}
		return comboFonte;
	}

	/**
	 * This method initializes jPanel2	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getWorkspace()
	{
		if (workspace == null) {
			workspace = new SurfacePanel(getFontText(),getOptions(),(ColorGroup)getColorGrupo());
			workspace.setAutoscrolls(false);
			workspace.setLayout(new FlowLayout());
			workspace.setLayout(null);
			workspace.setBorder(BorderFactory.createEmptyBorder(2, 2, 0, 0));
			workspace.setName("workspace");
			workspace.setAlignmentX(0.0F);
			workspace.setAlignmentY(0.0F);
			workspace.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
			workspace.setBackground(Color.lightGray);
			workspace.setBounds(new Rectangle(0, 0, 0, 0));
		}
		
		return workspace;
	}

	/**
	 * This method initializes jJMenuBar	
	 * 	
	 * @return javax.swing.JMenuBar	
	 */
	private JMenuBar getJJMenuBar()
	{
		if (jJMenuBar == null) {
			jJMenuBar = new JMenuBar();
			jJMenuBar.setPreferredSize(new java.awt.Dimension(0,30));
			jJMenuBar.add(getMenuFile());
			jJMenuBar.add(getMenuConfiguracao());
			jJMenuBar.add(getMenuAjuda());
		}
		return jJMenuBar;
	}

	/**
	 * This method initializes File	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getMenuFile()
	{
		if (menuFile == null) {
			menuFile = new JMenu();
			menuFile.setText("File");
			menuFile.add(getItemSaveImage());
			menuFile.add(getItemSaveFontMetrics());
            menuFile.addSeparator();
            menuFile.add(getItemExportToXNA());
		}
		return menuFile;
	}

	/**
	 * This method initializes menuSobre	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getMenuAjuda()
	{
		if (menuAjuda == null) {
			menuAjuda = new JMenu();
			menuAjuda.setText("Help");
			menuAjuda.add(getMenuSobre());
			menuAjuda.addSeparator();			
			menuAjuda.add(getMenuCreditos());
			menuAjuda.addSeparator();
			menuAjuda.add(getMenuWebSite());
		}
		return menuAjuda;
	}

	/**
	 * This method initializes itemSaveImage	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getItemSaveImage()
	{
		if (itemSaveImage == null) {
			itemSaveImage = new JMenuItem();
			itemSaveImage.setText("Save Image...");
			itemSaveImage.setName("SaveImage");		
			itemSaveImage.addActionListener(PrincipalActionFactory.makeSaveFileImage(getOptions(),(FontImage) getWorkspace()));
		}
		return itemSaveImage;
	}

	/**
	 * This method initializes itemSaveFontMetrics	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getItemSaveFontMetrics()
	{
		if (itemSaveFontMetrics == null) {
			itemSaveFontMetrics = new JMenuItem();
			itemSaveFontMetrics.setText("Save Font Metrics...");
			itemSaveFontMetrics.setName("SaveFontMetrics");			
			itemSaveFontMetrics.addActionListener(PrincipalActionFactory.makeSaveFileMetrics(getFontText()));
            mediador.register("itemSaveFontMetrics", itemSaveFontMetrics);			
		}
		return itemSaveFontMetrics;
	}

	private JMenuItem getItemExportToXNA()
	{
        if (itemExportToXNA == null) {
            itemExportToXNA = new JMenuItem();
            itemExportToXNA.setText("Export to XNA...");
            itemExportToXNA.setName("ExportToXNA");        
            itemExportToXNA.setEnabled(false);
            //itemExportToXNA.addActionListener(new SaveFileMetrics(getFontText()));           
        }
        return itemExportToXNA;
	}
	
	/**
	 * This method initializes toolBar	
	 * 	
	 * @return javax.swing.JToolBar	
	 */
	private JToolBar getToolBar()
	{
		if (toolBar == null) {
			toolBar = new JToolBar();
			toolBar.setFloatable(false);
			toolBar.setComponentOrientation(java.awt.ComponentOrientation.LEFT_TO_RIGHT);
			toolBar.setPreferredSize(new java.awt.Dimension(37,60));
			toolBar.add(getJPanel1());
			toolBar.add(getJPanel2());
			toolBar.add(getJPanel3());
			toolBar.add(getJPanel4());
			toolBar.add(getColorGrupo());
		}
		return toolBar;
	}

	/**
	 * This method initializes jPanel1	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel1()
	{
		if (jPanel1 == null) {
			GridLayout gridLayout1 = new GridLayout();
			gridLayout1.setRows(1);
			jPanel1 = new JPanel();
			jPanel1.setLayout(gridLayout1);
			jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Font", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12), java.awt.Color.black));
			jPanel1.add(getComboFonte(), null);
		}
		return jPanel1;
	}

	/**
	 * This method initializes comboBox	
	 * 	
	 * @return br.org.codigolivre.fanad.vpu.ui.componente.ComboBox	
	 */
	private ComboBox getComboTamanho()
	{
		if (comboTamanho == null) {
			comboTamanho = new ComboBox();
			comboTamanho.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			comboTamanho.setEditable(true);
			comboTamanho.setName("comboTamanho");
			comboTamanho.setMaximumSize(new java.awt.Dimension(60,60));
			comboTamanho.setCursor(new Cursor(Cursor.HAND_CURSOR));
			comboTamanho.addItem("8"); 		comboTamanho.addItem("9");
			comboTamanho.addItem("10");  	comboTamanho.addItem("12");
			comboTamanho.addItem("14");		comboTamanho.addItem("16");
			comboTamanho.addItem("18");		comboTamanho.addItem("20");			
			comboTamanho.addItem("24");     comboTamanho.addItem("24");		
			comboTamanho.addItem("26");		comboTamanho.addItem("28");	
			comboTamanho.addItem("30");		comboTamanho.addItem("32");
			comboTamanho.addItem("34");		comboTamanho.addItem("36");
			comboTamanho.addItem("38");		comboTamanho.addItem("40");
			comboTamanho.addItem("42");		comboTamanho.addItem("44");
			comboTamanho.addItemListener(PrincipalActionFactory.makeSelectSizeCommand(getOptions(),getFontText()));			
		}
		return comboTamanho;
	}

	/**
	 * This method initializes jPanel2	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel2()
	{
		if (jPanel2 == null) {
			GridLayout gridLayout = new GridLayout();
			gridLayout.setRows(1);
			jPanel2 = new JPanel();
			jPanel2.setLayout(gridLayout);
			jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Size", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12), java.awt.Color.black));
			jPanel2.add(getComboTamanho(), null);
		}
		return jPanel2;
	}

	/**
	 * This method initializes jPanel3	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel3()
	{
		if (jPanel3 == null) {
			jPanel3 = new JPanel();
			jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Style", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12), null));
			jPanel3.setSize(new java.awt.Dimension(80,56));
			jPanel3.setPreferredSize(new java.awt.Dimension(60,62));
			jPanel3.add(getBotaoNegrito(), null);
		}
		return jPanel3;
	}

	/**
	 * This method initializes jPanel4	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getColorGrupo() {
		if (colorGroupo == null) {
			colorGroupo = new ColorGroup();
		}
		return colorGroupo;
	}

	/**
	 * This method initializes botaoNegrito	
	 * 	
	 * @return javax.swing.JToggleButton	
	 */
	private JToggleButton getBotaoNegrito() {
		if (botaoNegrito == null) {
			botaoNegrito = new JToggleButton();
			botaoNegrito.setText("Bold");
            botaoNegrito.addItemListener(PrincipalActionFactory.makeBoldCommand(getOptions(),getFontText()));
		}
		return botaoNegrito;
	}

	/**
	 * This method initializes menuConfiguracao	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getMenuConfiguracao() {
		if (menuConfiguracao == null) {
			menuConfiguracao = new JMenu();
			menuConfiguracao.setText("Option");
			menuConfiguracao.add(getMenuImageType());
			menuConfiguracao.add(getMenuShadow());
			menuConfiguracao.add(getMenuCharacterSet());			
			menuConfiguracao.addSeparator();
			menuConfiguracao.add(getMenuItemUseMetric());
			menuConfiguracao.addSeparator();
            menuConfiguracao.add(getMenuItemUseAlpha());
            menuConfiguracao.addSeparator();           
			menuConfiguracao.add(getMenuItemAntialias());
			menuConfiguracao.addSeparator();
			menuConfiguracao.add(getMenuItemShowGrid());			
			menuConfiguracao.addSeparator();
			menuConfiguracao.add(getMenuAvancado());
		}
		return menuConfiguracao;
	}

	/**
	 * This method initializes jCheckBoxMenuItem	
	 * 	
	 * @return javax.swing.JCheckBoxMenuItem	
	 */
	private JCheckBoxMenuItem getMenuItemShowGrid() {
		if (menuItemShowGrid == null) {
			menuItemShowGrid = new JCheckBoxMenuItem();
			menuItemShowGrid.setText("Show Grid");
			menuItemShowGrid.setName("Grid");			
			menuItemShowGrid.addItemListener(PrincipalActionFactory.makeShowGridCommand(getOptions(),getFontText()));
		}
		return menuItemShowGrid;
	}

	/**
	 * This method initializes menuImageType	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getMenuImageType() {
		if (menuImageType == null) {
			menuImageType = new JMenu();
			menuImageType.setText("Image Type");
			ButtonGroup grupo = new ButtonGroup();
			grupo.add(getItemImageTypePNG());
			grupo.add(getItemImageTypeBMP());
			menuImageType.add(getItemImageTypePNG());
			menuImageType.add(getItemImageTypeBMP());

		}
		return menuImageType;
	}

	/**
	 * This method initializes itemImageTypePNG	
	 * 	
	 * @return javax.swing.JRadioButtonMenuItem	
	 */
	private JRadioButtonMenuItem getItemImageTypePNG() {
		if (itemImageTypePNG == null) {
			itemImageTypePNG = new JRadioButtonMenuItem();
			itemImageTypePNG.setText("PNG");
			itemImageTypePNG.setName("PNG");
			itemImageTypePNG.setSelected(true);
			itemImageTypePNG.addItemListener(PrincipalActionFactory.makeSelectImageTypeCommand(getOptions(),getFontText()));
            mediador.register("itemImageTypePNG", itemImageTypePNG);			
		}
		return itemImageTypePNG;
	}

	/**
	 * This method initializes itemImageTypeBMP	
	 * 	
	 * @return javax.swing.JRadioButtonMenuItem	
	 */
	private JRadioButtonMenuItem getItemImageTypeBMP() {
		if (itemImageTypeBMP == null) {
			itemImageTypeBMP = new JRadioButtonMenuItem();
			itemImageTypeBMP.setText("BMP");
			itemImageTypeBMP.setName("BMP");
			itemImageTypeBMP.setEnabled(false);
            itemImageTypeBMP.addItemListener(PrincipalActionFactory.makeSelectImageTypeCommand(getOptions(),getFontText()));
            mediador.register("itemImageTypeBMP", itemImageTypeBMP);       
		}
		return itemImageTypeBMP;
	}

	/**
	 * This method initializes menuShadow	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getMenuShadow() {
		if (menuShadow == null) {
			menuShadow = new JMenu();
			menuShadow.setText("Shadow");
			menuShadow.add(getMenuShadowVertical());
			menuShadow.add(getMenuShadowHorizontal());
		}
		return menuShadow;
	}

	/**
	 * This method initializes menuShadowVertical	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getMenuShadowVertical() {
		if (menuShadowVertical == null) {
			menuShadowVertical = new JMenu();
			menuShadowVertical.setText("Vertical");
			ButtonGroup grupo = new ButtonGroup();
			grupo.add(getRadioShadowVerticalNone());
			grupo.add(getRadioShadowVerticalUp());
			grupo.add(getRadioShadowVerticalDown());				
			menuShadowVertical.add(getRadioShadowVerticalNone());
			menuShadowVertical.add(getRadioShadowVerticalUp());
			menuShadowVertical.add(getRadioShadowVerticalDown());
		}
		return menuShadowVertical;
	}

	/**
	 * This method initializes menuShadowHorizontal	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getMenuShadowHorizontal() {
		if (menuShadowHorizontal == null) {
			menuShadowHorizontal = new JMenu();
			menuShadowHorizontal.setText("Horizontal");
			ButtonGroup grupo = new ButtonGroup();
			grupo.add(getRadioShadowHorizontalNone());
			grupo.add(getRadioShadowHorizontalLeft());
			grupo.add(getRadioShadowHorizontalRight());			
			menuShadowHorizontal.add(getRadioShadowHorizontalNone());
			menuShadowHorizontal.add(getRadioShadowHorizontalLeft());
			menuShadowHorizontal.add(getRadioShadowHorizontalRight());
		}
		return menuShadowHorizontal;
	}

	/**
	 * This method initializes radioShadowHorizontalNone	
	 * 	
	 * @return javax.swing.JRadioButtonMenuItem	
	 */
	private JRadioButtonMenuItem getRadioShadowHorizontalNone() {
		if (radioShadowHorizontalNone == null) {
			radioShadowHorizontalNone = new JRadioButtonMenuItem();
			radioShadowHorizontalNone.setText("None");
			radioShadowHorizontalNone.setName("HorizontalNone");			
			radioShadowHorizontalNone.setSelected(true);
			radioShadowHorizontalNone.addItemListener(PrincipalActionFactory.makeSelectShadowCommand(getOptions(),getFontText()));			
		}
		return radioShadowHorizontalNone;
	}

	/**
	 * This method initializes radioShadowHorizontalLeft	
	 * 	
	 * @return javax.swing.JRadioButtonMenuItem	
	 */
	private JRadioButtonMenuItem getRadioShadowHorizontalLeft() {
		if (radioShadowHorizontalLeft == null) {
			radioShadowHorizontalLeft = new JRadioButtonMenuItem();
			radioShadowHorizontalLeft.setText("Left");
			radioShadowHorizontalLeft.setName("HorizontalLeft");			
            radioShadowHorizontalLeft.addItemListener(PrincipalActionFactory.makeSelectShadowCommand(getOptions(),getFontText()));			
		}
		return radioShadowHorizontalLeft;
	}

	/**
	 * This method initializes radioShadowHorizontalRight	
	 * 	
	 * @return javax.swing.JRadioButtonMenuItem	
	 */
	private JRadioButtonMenuItem getRadioShadowHorizontalRight() {
		if (radioShadowHorizontalRight == null) {
			radioShadowHorizontalRight = new JRadioButtonMenuItem();
			radioShadowHorizontalRight.setText("Right");
			radioShadowHorizontalRight.setName("HorizontalRight");	
            radioShadowHorizontalRight.addItemListener(PrincipalActionFactory.makeSelectShadowCommand(getOptions(),getFontText()));			
		}
		return radioShadowHorizontalRight;
	}

	/**
	 * This method initializes jRadioButtonMenuItem5	
	 * 	
	 * @return javax.swing.JRadioButtonMenuItem	
	 */
	private JRadioButtonMenuItem getRadioShadowVerticalNone() {
		if (radioShadowVerticalNone == null) {
			radioShadowVerticalNone = new JRadioButtonMenuItem();
			radioShadowVerticalNone.setText("None");
			radioShadowVerticalNone.setName("VerticalNone");			
			radioShadowVerticalNone.setSelected(true);
            radioShadowVerticalNone.addItemListener(PrincipalActionFactory.makeSelectShadowCommand(getOptions(),getFontText()));			
		}
		return radioShadowVerticalNone;
	}

	/**
	 * This method initializes jRadioButtonMenuItem6	
	 * 	
	 * @return javax.swing.JRadioButtonMenuItem	
	 */
	private JRadioButtonMenuItem getRadioShadowVerticalUp() {
		if (radioShadowVerticalUp == null) {
			radioShadowVerticalUp = new JRadioButtonMenuItem();
			radioShadowVerticalUp.setText("Up");
			radioShadowVerticalUp.setName("VerticalUp");			
            radioShadowVerticalUp.addItemListener(PrincipalActionFactory.makeSelectShadowCommand(getOptions(),getFontText()));			
		}
		return radioShadowVerticalUp;
	}

	/**
	 * This method initializes jRadioButtonMenuItem7	
	 * 	
	 * @return javax.swing.JRadioButtonMenuItem	
	 */
	private JRadioButtonMenuItem getRadioShadowVerticalDown() {
		if (radioShadowVerticalDown == null) {
			radioShadowVerticalDown = new JRadioButtonMenuItem();
			radioShadowVerticalDown.setText("Down");
			radioShadowVerticalDown.setName("VerticalDown");			
            radioShadowVerticalDown.addItemListener(PrincipalActionFactory.makeSelectShadowCommand(getOptions(),getFontText()));			
		}
		return radioShadowVerticalDown;
	}

	/**
	 * This method initializes jCheckBoxMenuItem1	
	 * 	
	 * @return javax.swing.JCheckBoxMenuItem	
	 */
	private JCheckBoxMenuItem getMenuItemUseMetric() {
		if (menuItemUseMetric == null) {
			menuItemUseMetric = new JCheckBoxMenuItem();
			menuItemUseMetric.setText("Use Metrics");
			menuItemUseMetric.setSelected(true);
			menuItemUseMetric.setName("UseMetrics");
			menuItemUseMetric.addItemListener(PrincipalActionFactory.makeUseMetricsCommand(getOptions(),getFontText()));
            mediador.register("menuItemUseMetric", menuItemUseMetric);			
		}
		return menuItemUseMetric;
	}

    /**
     * This method initializes jCheckBoxMenuItem1   
     *  
     * @return javax.swing.JCheckBoxMenuItem    
     */
    private JCheckBoxMenuItem getMenuItemUseAlpha() {
        if (menuItemUseAlpha == null) {
            menuItemUseAlpha = new JCheckBoxMenuItem();
            menuItemUseAlpha.setText("Use Alpha");
            menuItemUseAlpha.setSelected(true);
            menuItemUseAlpha.setName("UseAlpha");
            menuItemUseAlpha.addItemListener(PrincipalActionFactory.makeUseAlphaCommand(getOptions(),getFontText()));
            mediador.register("menuItemUseAlpha", menuItemUseAlpha);            
        }
        return menuItemUseAlpha;
    }
    
	/**
	 * This method initializes menuCharacterSet	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getMenuCharacterSet() {
		if (menuCharacterSet == null) {
			menuCharacterSet = new JMenu();
			menuCharacterSet.setText("Character Set");
			menuCharacterSet.add(getRadioCharacterSetFull());
			menuCharacterSet.add(getRadioCharacterSetNumeric());
		}
		return menuCharacterSet;
	}

	/**
	 * This method initializes radioCharacterSetFull	
	 * 	
	 * @return javax.swing.JRadioButtonMenuItem	
	 */
	private JRadioButtonMenuItem getRadioCharacterSetFull() {
		if (radioCharacterSetFull == null) {
			radioCharacterSetFull = new JRadioButtonMenuItem();
			radioCharacterSetFull.setSelected(true);
			radioCharacterSetFull.setText("Full");
		}
		return radioCharacterSetFull;
	}

	/**
	 * This method initializes radioCharacterSetNumeric	
	 * 	
	 * @return javax.swing.JRadioButtonMenuItem	
	 */
	private JRadioButtonMenuItem getRadioCharacterSetNumeric() {
		if (radioCharacterSetNumeric == null) {
			radioCharacterSetNumeric = new JRadioButtonMenuItem();
			radioCharacterSetNumeric.setText("Numeric");
			radioCharacterSetNumeric.setEnabled(false);
		}
		return radioCharacterSetNumeric;
	}

	/**
	 * This method initializes jMenuItem2	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getMenuSobre() {
		if (menuSobre == null) {
			menuSobre = new JMenuItem();
			menuSobre.setText("About");
			menuSobre.addActionListener(PrincipalActionFactory.makeOpenAbout());			
		}
		return menuSobre;
	}

	/**
	 * This method initializes jMenuItem3	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getMenuWebSite() {
		if (menuWebSite == null) {
			menuWebSite = new JMenuItem();
			menuWebSite.setName("website");
			menuWebSite.setText("Go to WebSite");
			menuWebSite.addActionListener(PrincipalActionFactory.makeOpenWebSite());			
		}
		return menuWebSite;
	}

	/**
	 * This method initializes jPanel4	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel4() {
		if (jPanel4 == null) {
			GridLayout gridLayout2 = new GridLayout();
			gridLayout2.setRows(1);
			jPanel4 = new JPanel();
			jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Texture Size", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12), java.awt.Color.black));
			jPanel4.setSize(new java.awt.Dimension(90,56));
			jPanel4.setPreferredSize(new java.awt.Dimension(80,51));
			jPanel4.setLayout(gridLayout2);
			jPanel4.add(getComboTexturaSize(), null);
		}
		return jPanel4;
	}

	/**
	 * This method initializes comboBox	
	 * 	
	 * @return br.org.codigolivre.pjmoo.f2ibuilder.ui.componente.ComboBox	
	 */
	private ComboBox getComboTexturaSize() {
		if (comboTexturaSize == null) {
			comboTexturaSize = new ComboBox();
			comboTexturaSize.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			comboTexturaSize.setName("comboTexturaSize");
			comboTexturaSize.setMaximumSize(new Dimension(60, 60));
			comboTexturaSize.setEditable(false);
			comboTexturaSize.setCursor(new Cursor(Cursor.HAND_CURSOR));
			comboTexturaSize.addItem("Auto"); 		
			comboTexturaSize.addItem("128"); comboTexturaSize.addItem("256");
			comboTexturaSize.addItem("512"); comboTexturaSize.addItem("1024");
			comboTexturaSize.addItemListener(PrincipalActionFactory.makeSelectTextureSizeCommand(getOptions(),getFontText()));			
		}
		return comboTexturaSize;
	}

	/**
	 * This method initializes jMenuItem4	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getMenuCreditos() {
		if (menuCreditos == null) {
			menuCreditos = new JMenuItem();
			menuCreditos.setText("Credits");
			menuCreditos.setName("Creditos");	
			menuCreditos.addActionListener(PrincipalActionFactory.makeOpenCredit());
		}
		return menuCreditos;
	}

	/**
	 * This method initializes jCheckBoxMenuItem2	
	 * 	
	 * @return javax.swing.JCheckBoxMenuItem	
	 */
	private JCheckBoxMenuItem getMenuItemAntialias() {
		if (menuItemAntialias == null) {
			menuItemAntialias = new JCheckBoxMenuItem();
			menuItemAntialias.setName("Antialias");
			menuItemAntialias.setText("Antialias");
			menuItemAntialias.setSelected(true);
			menuItemAntialias.addItemListener(PrincipalActionFactory.makeUseAntialiasCommand(getOptions(),getFontText()));		
		}
		return menuItemAntialias;
	}

	/**
	 * This method initializes menuItemAdjustCharset	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getMenuItemAdjustCharset() {
		if (menuItemAdjustCharset == null) {
			menuItemAdjustCharset = new JMenuItem();
			menuItemAdjustCharset.setText("Adjust Charset Map");
			menuItemAdjustCharset.addActionListener(PrincipalActionFactory.makeOpenCharsetMap(null,getFontText()));
		}
		return menuItemAdjustCharset;
	}

	/**
	 * This method initializes menuAvancado	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getMenuAvancado() {
		if (menuAvancado == null) {
			menuAvancado = new JMenu();
			menuAvancado.setText("Advanced");
			menuAvancado.add(getMenuItemAdjustCharset());
			menuAvancado.add(getMenuItemAdjustMetrics());
			menuAvancado.add(getMenuItemMetricsLimit());
		}
		return menuAvancado;
	}

	/**
	 * This method initializes menuItemAdjustMetrics	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getMenuItemAdjustMetrics() {
		if (menuItemAdjustMetrics == null) {
			menuItemAdjustMetrics = new JMenuItem();
			menuItemAdjustMetrics.setActionCommand("Adjust Metrics Map");
			menuItemAdjustMetrics.setText("Adjust Metrics Map");
			menuItemAdjustMetrics.addActionListener(PrincipalActionFactory.makeOpenMetricsMap(null,getFontText()));
		}
		return menuItemAdjustMetrics;
	}

	/**
	 * This method initializes menuItemMetricsLimit	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getMenuItemMetricsLimit() {
		if (menuItemMetricsLimit == null) {
			menuItemMetricsLimit = new JMenuItem();
			menuItemMetricsLimit.setActionCommand("Adjust Metrics Limit");
			menuItemMetricsLimit.setText("Adjust Metrics Limit");			
			menuItemMetricsLimit.addActionListener(PrincipalActionFactory.makeOpenMetricsLimit(null,getFontText()));
		}
		return menuItemMetricsLimit;
	}
	
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
			jScrollPane.setBorder(null);
			jScrollPane.setViewportView(getWorkspace());
		}
		return jScrollPane;
	}
	
}  //  @jve:decl-index=0:visual-constraint="-35,-24"
