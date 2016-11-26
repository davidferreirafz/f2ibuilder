/**
 * 
 */
package com.dukitan.f2ibuilder.application.controller;

import java.awt.Frame;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.WindowListener;

import javax.swing.JComboBox;

import com.dukitan.componentes.ui.combobox.ComboBox;
import com.dukitan.f2ibuilder.application.controller.command.button.BoldCommand;
import com.dukitan.f2ibuilder.application.controller.command.checkbox.ShowGridCommand;
import com.dukitan.f2ibuilder.application.controller.command.checkbox.UseAlphaCommand;
import com.dukitan.f2ibuilder.application.controller.command.checkbox.UseAntialiasCommand;
import com.dukitan.f2ibuilder.application.controller.command.checkbox.UseMetricsCommand;
import com.dukitan.f2ibuilder.application.controller.command.combobox.SelectFontCommand;
import com.dukitan.f2ibuilder.application.controller.command.combobox.SelectSizeCommand;
import com.dukitan.f2ibuilder.application.controller.command.combobox.SelectTextureSizeCommand;
import com.dukitan.f2ibuilder.application.controller.command.radio.SelectImageTypeCommand;
import com.dukitan.f2ibuilder.application.controller.command.radio.SelectShadowCommand;
import com.dukitan.f2ibuilder.application.controller.file.OpenFileProject;
import com.dukitan.f2ibuilder.application.controller.file.SaveFileImage;
import com.dukitan.f2ibuilder.application.controller.file.SaveFileMetrics;
import com.dukitan.f2ibuilder.application.controller.file.SaveFileProject;
import com.dukitan.f2ibuilder.application.controller.generics.OpenWebSite;
import com.dukitan.f2ibuilder.application.controller.open.LoadApplication;
import com.dukitan.f2ibuilder.application.controller.open.OpenJDialog;
import com.dukitan.f2ibuilder.application.controller.open.OpenJDialogObserver;
import com.dukitan.f2ibuilder.application.model.FontText;
import com.dukitan.f2ibuilder.application.model.Options;
import com.dukitan.f2ibuilder.application.view.About;
import com.dukitan.f2ibuilder.application.view.Credit;
import com.dukitan.f2ibuilder.application.view.charset.CharsetMap;
import com.dukitan.f2ibuilder.application.view.charset.CharsetPosition;
import com.dukitan.f2ibuilder.application.view.image.FontImage;
import com.dukitan.f2ibuilder.application.view.metrics.MetricsLimit;
import com.dukitan.f2ibuilder.application.view.metrics.MetricsMap;
import com.dukitan.f2ibuilder.components.memento.IMementoSupported;

/**
 * 
 * Designer Pattern : DiS - StaticFactory
 * 
 * @author David Ferreira <davidferreira.fz@gmail.com>
 * 
 * Project: F2IBuilder
 * Date: 08/03/2008
 *
 */
public class PrincipalActionFactory extends ActionFactory
{

    public static ActionListener makeOpenWebSite()
    {
        return new OpenWebSite();
    }

    /**
     * @param fontText
     * @param comboFonte
     * @param comboTamanho
     * @return
     */
    public static WindowListener makeLoadApplication(FontText fontText,
            JComboBox comboFonte, ComboBox comboTamanho)
    {
        return new LoadApplication(fontText,comboFonte,comboTamanho);
    }

    /**
     * @param options
     * @param fontText
     * @return
     */
    public static ItemListener makeSelectFontCommand(Options options,
            FontText fontText)
    {
        return new SelectFontCommand(options,fontText);
    }

    /**
     * @param options
     * @param fontImage
     * @return
     */
    public static ActionListener makeSaveFileImage(Options options,FontImage fontImage)
    {
        return new SaveFileImage(options,fontImage);
    }

    /**
     * @param fontText
     * @return
     */
    public static ActionListener makeSaveFileMetrics(FontText fontText)
    {
        return new SaveFileMetrics(fontText);
    }

    /**
     * 
     * @param form
     * @return
     */
    public static ActionListener makeSaveFileProject(IMementoSupported form)
    {
        return new SaveFileProject(form);
    }     

    /**
     * 
     * @param form
     * @return
     */
    public static ActionListener makeOpenFileProject(IMementoSupported form)
    {
        return new OpenFileProject(form);
    }   
    
    /**
     * @param options
     * @param fontText
     * @return
     */
    public static ItemListener makeSelectSizeCommand(Options options,
            FontText fontText)
    {
        return new SelectSizeCommand(options,fontText);
    }

    /**
     * @param options
     * @param fontText
     * @return
     */
    public static ItemListener makeBoldCommand(Options options,
            FontText fontText)
    {
        return new BoldCommand(options,fontText);
    }

    /**
     * @param options
     * @param fontText
     * @return
     */
    public static ItemListener makeShowGridCommand(Options options,
            FontText fontText)
    {
        return new ShowGridCommand(options,fontText);
    }

    /**
     * @param options
     * @param fontText
     * @return
     */
    public static ItemListener makeSelectImageTypeCommand(Options options,
            FontText fontText)
    {
        return new SelectImageTypeCommand(options,fontText);
    }

    /**
     * @param options
     * @param fontText
     * @return
     */
    public static ItemListener makeSelectShadowCommand(Options options,
            FontText fontText)
    {
        return new SelectShadowCommand(options,fontText);
    }

    /**
     * @param options
     * @param fontText
     * @return
     */
    public static ItemListener makeUseAlphaCommand(Options options,
            FontText fontText)  {
        return new UseAlphaCommand(options,fontText);
    }

    /**
     * @param options
     * @param fontText
     * @return
     */
    public static ItemListener makeSelectTextureSizeCommand(Options options,
            FontText fontText)
    {
        return new SelectTextureSizeCommand(options,fontText);
    }

    /**
     * @param options
     * @param fontText
     * @return
     */
    public static ItemListener makeUseAntialiasCommand(Options options,FontText fontText)
    {
        return new UseAntialiasCommand(options,fontText);
    }

    /**
     * @param options
     * @param fontText
     * @return
     */
    public static ItemListener makeUseMetricsCommand(Options options,
            FontText fontText)
    {
        return new UseMetricsCommand(options,fontText);
    }



    public static ActionListener makeOpenCharsetPosition(Frame frame,FontText fontText)
    {
        return new OpenJDialogObserver(new CharsetPosition(frame,fontText));
    }
    
    public static ActionListener makeOpenCharsetMap(Frame frame,FontText fontText)
    {
        return new OpenJDialogObserver(new CharsetMap(frame,fontText));
    }

    public static ActionListener makeOpenMetricsMap(Frame frame,FontText fontText)
    {
        return new OpenJDialogObserver(new MetricsMap(frame,fontText));
    }    

    public static ActionListener makeOpenMetricsLimit(Frame frame,FontText fontText)
    {
        return new OpenJDialogObserver(new MetricsLimit(frame,fontText));
    }

    public static ActionListener makeOpenAbout()
    {
        return new OpenJDialog(new About());
    }
    
    public static ActionListener makeOpenCredit()
    {
        return new OpenJDialog(new Credit());
    }

   
}
