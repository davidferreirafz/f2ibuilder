/**
 * 
 */
package net.sourceforge.f2ibuilder.application.controller;

import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;

import net.sourceforge.f2ibuilder.application.controller.metrics.ResetMetrics;
import net.sourceforge.f2ibuilder.application.controller.metrics.SaveMetric;
import net.sourceforge.f2ibuilder.application.controller.metrics.SaveMetricLimit;
import net.sourceforge.f2ibuilder.application.controller.metrics.SelectMetric;
import net.sourceforge.f2ibuilder.application.model.FontText;

/**
 * 
 * Designer Pattern : DiS - StaticFactory
 * 
 * @author David Ferreira <davidferreira.fz@gmail.com>
 * 
 * Project: F2IBuilder
 * Date: 08/03/2008
 */
public class MetricsActionFactory extends ActionFactory
{
    /**
     * @param fontText
     * @param table
     * @return
     */
    public static ActionListener makeSaveMetric(FontText fontText, JTable table)
    {
        return new SaveMetric(fontText,table);
    }

    /**
     * @param fontText
     * @return
     */
    public static ActionListener makeResetMetrics(FontText fontText)
    {
        return new ResetMetrics(fontText);
    }

    /**
     * @param table
     * @param fontText
     * @param asciiLabel
     * @param formatLabel
     * @return
     */
    public static MouseListener makeSelectMetric(JTable table, FontText fontText, JLabel asciiLabel, JLabel formatLabel)
    {
        return new SelectMetric(table,fontText,asciiLabel,formatLabel);
    }

    /**
     * @param fontText
     * @param menorLimite
     * @param maiorLimite
     * @return
     */
    public static ActionListener makeSaveMetricLimit(FontText fontText, JTextField menorLimite, JTextField maiorLimite)
    {
        return new SaveMetricLimit(fontText,menorLimite,maiorLimite);
    }

}
