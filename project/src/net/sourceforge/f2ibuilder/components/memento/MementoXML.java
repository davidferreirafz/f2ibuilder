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
package net.sourceforge.f2ibuilder.components.memento;

import java.io.File;


import org.jdom.Element;

import com.wordpress.dukitan.componentes.xml.XMLFile;

/**
 * @author David Ferreira <davidferreira.fz@gmail.com>
 *
 * Project: F2IBuilder
 * Date: 12/04/2008
 *
 */
public class MementoXML
{  

    private File file;
    
    public MementoXML(File file)
    {
        this.file=file;
    }
        

    /**
     * Transforma o objeto passado em um arquivo XML
     * @param memento objeto a ser transformado em xml e salvo
     */
    public void toFile(PrincipalMemento memento)
    {
        XMLFile xml = new XMLFile(file);
               
        Element root = xml.createRoot("F2IBuilder");

        Element application = xml.createElement(root,"application");
        
        xml.createElement(application,"name","F2IBuilder");
        xml.createElement(application,"version","3.5");

        Element project = xml.createElement(root,"project"); 
        
        xml.createElement(project,"useMetrics",memento.isUseMetrics());
        xml.createElement(project,"useAlpha",memento.isUseAlpha());
        xml.createElement(project,"showGrid",memento.isShowGrid());
        xml.createElement(project,"antialias",memento.isAntialias());

        xml.createElement(project,"imageType",memento.getImageType());        

        Element color =  xml.createElement(project,"color");
        xml.createElement(color,"font",memento.getFontColor().getRGB());
        xml.createElement(color,"shadow",memento.getShadowColor().getRGB());
        xml.createElement(color,"background",memento.getBackgroundColor().getRGB());        

        Element style =  xml.createElement(project,"style");
        xml.createElement(style,"bold",memento.isBold());

        Element font =  xml.createElement(project,"font");
        xml.createElement(font,"name",memento.getFontName());
        xml.createElement(font,"size",memento.getFontSize());

        Element texture =  xml.createElement(project,"texture");
        xml.createElement(texture,"size",memento.getTexturaSize());
        
        Element shadow =  xml.createElement(project,"shadow");
        xml.createElement(shadow,"vertical",memento.getVerticalShadow());
        xml.createElement(shadow,"horizontal",memento.getHorizontalShadow());
        
        xml.save();
    }  

    
    /**
     * Transforma o arquivo XML em um objeto
     * @return retorna o objeto
     */
    public PrincipalMemento toMemento()
    {     
        PrincipalMemento memento = new PrincipalMemento();
        
        XMLFile xml = new XMLFile(file);
        xml.open();
        
        memento.setShowGrid(xml.getBoolean("project","showGrid"));
        memento.setUseAlpha(xml.getBoolean("project","useAlpha"));
        memento.setAntialias(xml.getBoolean("project","antialias"));
        memento.setUseMetrics(xml.getBoolean("project","useMetrics"));
        
        memento.setImageType(xml.getString("project", "imageType"));
        memento.setBold(xml.getBoolean("project","style", "bold"));
        
        memento.setTexturaSize(xml.getString("project","texture","size"));
        
        memento.setFontName(xml.getString("project","font","name"));
        memento.setFontSize(xml.getString("project","font","size"));
        
        memento.setHorizontalShadow(xml.getString("project","shadow","horizontal"));
        memento.setVerticalShadow(xml.getString("project","shadow","vertical"));
        
        memento.setBackgroundColor(xml.getInt("project","color","background"));
        memento.setFontColor(xml.getInt("project","color","font"));
        memento.setShadowColor(xml.getInt("project","color","shadow"));
                
        return memento;
    }
    
   
}
