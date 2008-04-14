/*****************************************************************************/
/* DukItan         -  DukItan Software Components                            */
/* E-Mail          -  davidferreira.fz@gmail.com                             */
/* Site            -  http://davidferreirafz.wordpress.com                   */ 
/* ICQ: 21877381      MSN: davidaf@uol.com.br                                */
/* G.talk: davidferreira.fz@gmail.com                                        */
/* Copyright (C) 2008  David de Almeida Ferreira                             */
/*****************************************************************************/
/*                                                                           */
/* Este arquivo � parte do projeto DSC - DukItan Software Components         */
/*                                                                           */
/* DSC � um software livre; voc� pode redistribui-lo e/ou                    */
/* modifica-lo dentro dos termos da Licen�a P�blica Geral (GPL) GNU          */
/* como publicada pela Funda��o do Software Livre (FSF); na vers�o 2 da      */
/* Licen�a                                                                   */
/*                                                                           */
/*****************************************************************************/
/*                                                                           */
/* This file is part of project DSC - DukItan Software Components            */
/*                                                                           */
/* DSC is free software; you can redistribute it and/or modify               */
/* it under the terms of the GNU  Lesser General Public License (LGPL) as    */
/* published by the Free Software Foundation; either version 2 of the        */
/* License.                                                                  */
/*                                                                           */
/*****************************************************************************/
package com.wordpress.dukitan.componentes.xml;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

/**
 * @author David Ferreira <davidferreira.fz@gmail.com>
 *
 * Project: F2IBuilder
 * Date: 14/04/2008
 *
 */
public class XMLFile
{
    private Element elementoRaiz;
    private File file;
    Document document;
    
    /**
     * Construtor
     * @param file arquivo para ser manipulado
     */
    public XMLFile(File file)
    {
        this.file=file;
    }
    
    /**
     * Abre o arquivo
     */
    public void open()
    {
        SAXBuilder sax = new SAXBuilder();  
        
        try {
            document = sax.build(file);
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        elementoRaiz = document.getRootElement();  
    }
    
    /**
     * Salva em arquivo
     */
    public void save()
    {
        
        Format format = Format.getPrettyFormat().setEncoding("UTF-8");  

        XMLOutputter xout = new XMLOutputter(format);

        String text = xout.outputString(document);

        FileWriter writer;
        try {
            writer = new FileWriter(file);
            writer.write(text);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        } 
    } 
    
    /**
     * Cria o elemento raiz do xml
     * @param name nome do elemento raiz
     * @return retorna o elemento criado
     */
    public Element createRoot(String name)
    {
        elementoRaiz = new Element(name);
        
        document = new Document();  
        document.setRootElement(elementoRaiz);  
        
        return elementoRaiz;        
    }
    
    /**
     * Cria um elemento dentro de outro elemento
     * @param parent elemento pai
     * @param name nome do elemento a ser criado
     * @return retorna o elemento criado
     */
    public Element createElement(Element parent, String name)
    {
        Element element = new Element(name);
        parent.addContent(element);
        
        return element;
    }

    /**
     * Cria um elemento com atribui��o de seu valor
     * @param parente elemento pai
     * @param name nome do elemento a ser criado
     * @param value valor do elemento criado
     * @return retorna o elemento criado
     */
    public Element createElement(Element parente, String name, boolean value)
    {        
        return createElement(parente,name,String.valueOf(value));
    }
    
    /**
     * Cria um elemento com atribui��o de seu valor
     * @param parente elemento pai
     * @param name nome do elemento a ser criado
     * @param value valor do elemento criado
     * @return retorna o elemento criado
     */
    public Element createElement(Element parent, String name, int value)
    {        
        return createElement(parent,name,String.valueOf(value));
    }
    
    /**
     * Cria um elemento com atribui��o de seu valor
     * @param parente elemento pai
     * @param name nome do elemento a ser criado
     * @param value valor do elemento criado
     * @return retorna o elemento criado
     */
    public Element createElement(Element parent, String name, String value)
    {
        Element element = createElement(parent,name);
        setValue(element,value);
        
        return element; 
    }  

    /**
     * Atribui o valor ao elemento
     * @param element a ser atribuido o valor
     * @param value valor do elemento
     */
    public void setValue(Element element, boolean value)
    {
        setValue(element,String.valueOf(value));
    }

    /**
     * Atribui o valor ao elemento
     * @param element a ser atribuido o valor
     * @param value valor do elemento
     */
    public void setValue(Element element, int value)
    {
        setValue(element,String.valueOf(value));
    }  
    
    /**
     * Atribui o valor ao elemento
     * @param element a ser atribuido o valor
     * @param value valor do elemento
     */
    public void setValue(Element element, String value)
    {
        element.setText(value);
    }
    
    /**
     * Retorna o valor do elemento
     * @param parent elemento pai
     * @param tag elemento que deseja-se o valor
     * @return valor do elemento
     */
    public boolean getBoolean(String parent, String tag)
    {
        return Boolean.parseBoolean(getString(parent,tag));
    }
    
    /**
     * Retorna o valor do elemento
     * @param parent elemento pai
     * @param tag elemento que deseja-se o valor
     * @return valor do elemento
     */
    public int getInt(String parent, String tag)
    {
        return Integer.parseInt(getString(parent,tag));
    } 
    
    @SuppressWarnings("unchecked")
    /**
     * Retorna o valor do elemento
     * @param parent elemento pai
     * @param tag elemento que deseja-se o valor
     * @return valor do elemento
     */
    public String getString(String parent, String tag)
    {
        String value = "";
        
        List listaRaiz = elementoRaiz.getChildren(parent);
        Iterator itRaiz = listaRaiz.iterator();
        
        if(itRaiz.hasNext()){           
            Element  elemento = (Element)itRaiz.next();

            value = elemento.getChildText(tag);
        }

        return value;
    }
    
    /**
     * Retorna o valor do elemento
     * @param parent elemento pai
     * @param tag elemento que deseja-se o valor
     * @return valor do elemento
     */
    public boolean getBoolean(String parent, String tag, String atributo)
    {
        return Boolean.parseBoolean(getString(parent,tag,atributo));
    }
    
    /**
     * Retorna o valor do elemento
     * @param parent elemento pai
     * @param tag elemento que deseja-se o valor
     * @return valor do elemento
     */
    public int getInt(String parent, String tag, String atributo)
    {
        return Integer.parseInt(getString(parent,tag,atributo));
    }    
    
    @SuppressWarnings("unchecked")
    /**
     * Retorna o valor do elemento
     * @param parent elemento pai
     * @param tag elemento que deseja-se o valor
     * @return valor do elemento
     */
    public String getString(String parent, String tag, String atributo)
    {
        String value = "";
        
        List listaRaiz   = elementoRaiz.getChildren(parent);
        Iterator itRaiz  = listaRaiz.iterator();

        if(itRaiz.hasNext()){           
            Element  elemento = (Element)itRaiz.next();

            Element a = elemento.getChild(tag);

            value=a.getChildText(atributo);
        }

        return value;
    }     

}
