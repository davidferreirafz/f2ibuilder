/**
 * 
 */
package net.sourceforge.f2ibuilder.application.controller;

import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import net.sourceforge.f2ibuilder.application.controller.charset.ResetCharset;
import net.sourceforge.f2ibuilder.application.controller.charset.ResetCharsetPosition;
import net.sourceforge.f2ibuilder.application.controller.charset.SaveCharset;
import net.sourceforge.f2ibuilder.application.controller.charset.SaveCharsetPosition;
import net.sourceforge.f2ibuilder.application.controller.charset.SelectChar;
import net.sourceforge.f2ibuilder.application.model.FontText;

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
public class CharsetActionFactory extends ActionFactory
{
    /**
     * 
     * @param fontText
     * @return
     */
    static public ActionListener makeResetCharset(FontText fontText)
    {
       return new ResetCharset(fontText);
    }

    /**
     * @param fontText
     * @param table
     * @return
     */
    public static ActionListener makeSaveCharset(FontText fontText, JTable table)
    {
        return new SaveCharset(fontText,table);
    }

    /**
     * @param table
     * @param asciiLabel
     * @param formatLabel
     * @param fontText
     * @return
     */
    public static MouseListener makeSelectChar(JTable table, JLabel asciiLabel, JLabel formatLabel, FontText fontText)
    {
        return new SelectChar(table,asciiLabel,formatLabel,fontText);
    }
    
    /**
     * @param fontText
     * @return
     */
    public static ActionListener makeResetCharsetPosition(FontText fontText)
    {
        return new ResetCharsetPosition(fontText);
    }    
    /**
     * @param fontText
     * @param table
     * @return
     */
    public static ActionListener makeSaveCharsetPosition(FontText fontText, JTextField menorLimite, JTextField maiorLimite)
    {
        return new SaveCharsetPosition(fontText,menorLimite,maiorLimite);
    }
}
