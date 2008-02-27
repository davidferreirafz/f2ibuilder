package net.sourceforge.f2ibuilder.application.model;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JPanel;

import net.sourceforge.f2ibuilder.components.type.Limit;

import com.wordpress.dukitan.componentes.gof.observer.Observable;

public class FontText extends Observable
{
    private String fontName;
    private int fontSize;
    private int fontStyle;    
    private Font font;
    private JPanel panel;
    private Dimension dimensionDefault;
    private Limit limit;    
    
    private int[] workCharset;
    private int[] workMetrics;
    private int[] originalMetrics;

    
    private static FontText instance;
    
    
    public static FontText getInstance()
    {
        if (instance == null){
            instance = new FontText();
        }
        
        return instance;
    }
    
    private FontText()
    {
        workCharset = new int[256];
        workMetrics = new int[256];
        
        panel = new JPanel();
        fontName   = "Arial";
        fontStyle  = Font.PLAIN;
        fontSize = 14;        
        
        dimensionDefault = new Dimension();
        limit = new Limit(0,dimensionDefault.width);
        
        resetCharset();        
    }
    
    /**
     * Chamado externo, deve notificar mudanças
     */
    public void make()
    {
        apllyNewFont();
        metricsDefault();
        applyMetricsLimit();
        
        updateObserver();
    }   
    
    private void apllyNewFont()
    {
        font = new Font(fontName,fontStyle,fontSize);
        
        panel.setFont(font);
    }
    
    private void metricsDefault()
    {
        originalMetrics=panel.getFontMetrics(font).getWidths();
        
        dimensionDefault.width=0;
        
        for (int i=0; i<256; i++){  
            if (originalMetrics[i]>dimensionDefault.width){
                dimensionDefault.width=originalMetrics[i];
            }
        }   
        
        dimensionDefault.height=panel.getFontMetrics(font).getHeight();
        
        if (dimensionDefault.height<=0){
            dimensionDefault.height=dimensionDefault.width;
        }
        
        limit.max=dimensionDefault.width;
    }
    
    private void applyMetricsLimit()
    {
        workMetrics=originalMetrics.clone();
        
        for (int i=0; i<256; i++){              
            if (workMetrics[i]<limit.min){
                workMetrics[i]=limit.min;
            } else if (workMetrics[i]>limit.max){
                workMetrics[i]=limit.max;
            }
        }
        
        dimensionDefault.width=limit.max;
    }
    
    /**
     * Chamado externo, deve notificar mudanças
     */
    public void resetMetrics()
    {
        if (originalMetrics!=null){
            workMetrics=originalMetrics.clone();
            searchLimits();
        }

        updateObserver();
    }

    /**
     * Chamado externo, notificação por mudanças delegado para método
     * 'resetMetrics'
     */
    public void resetCharset()
    {
        for (int i=0; i<256; i++){
            workCharset[i]=i;
        }
        
        resetMetrics();
    }
    
    public String getCharacter(int i)
    {
        return String.valueOf((char)workCharset[i]);
    }
    
    public int getCharacterNumber(int i)
    {
        return workCharset[i];
    }
    
    public void setCharacter(int i,int valor)
    {       
        workCharset[i]=valor;
        workMetrics[i]=workMetrics[valor];
        
        updateObserver();
    }
    
    
    public void setCharacterMetric(int i,int valor)
    {
        workMetrics[i]=valor;
        searchLimits();
        
        updateObserver();       
    }
    
    public void setMetrics(int[] metricas)
    {
        originalMetrics=metricas;    
        searchLimits();
        applyMetricsLimit();        
        
        updateObserver();       
    }        
    /**
     * 
     * @param min
     * @param max
     * 
     * Chamado externo, deve notificar mudanças
     */
    public void setLimits(int min, int max)
    {
        limit.min = min;
        limit.max = max;
        
        applyMetricsLimit();
        updateObserver();
    }
    
     
    protected void searchLimits()
    {
        limit.max=0; limit.min=1000;
        
        for (int i=0; i<256; i++){
            if (workMetrics[i]>limit.max){
                limit.max=workMetrics[i];
            } else if (workMetrics[i]<limit.min){
                limit.min=workMetrics[i];
            }
        }
        
        dimensionDefault.width=limit.max;        
    }    
    
    public int getMaiorLargura() {
        return limit.max;
    }

    public int getMenorLargura() {
        return limit.min;
    }  
    
    public Font getFont()
    {
        return font;
    }

    /**
     * @param size
     * Chamada externo, notificação por mudanças delegado para
     * método 'make'
     */
    public void setFontSize(int size)
    {
        this.fontSize=size;
        
        make();
    }
    
    public int getFontSize()
    {
        return fontSize;
    }
    
    /**
     * 
     * @param fontName
     * Chamada externo, notificação por mudanças delegado para
     * método 'make'
     */
    public void setFontName(String fontName)
    {
        this.fontName=fontName;
        
        make();
    }
    public String getFontName()
    {
        return fontName;
    }
    
    public int getCharacterMetric(int i)
    {
        return workMetrics[i];
    }

    /**
     * 
     * @param value
     * Chamada externo, notificação por mudanças delegado para
     * método 'make'
     */
    public void setBold(boolean value)
    {
        if (value){
            fontStyle=Font.BOLD;
        } else {
            fontStyle=Font.PLAIN;
        }
        
        make();
    }    
    
    public Dimension getDefaultCharDimension()
    {
        return (Dimension) dimensionDefault.clone();
    }
    
    public int getFontAscent()
    {
        return panel.getFontMetrics(font).getAscent();
    }
    
    public String getDefaultID()
    {
        return getFontName()+"."+getFontSize();
    }
}
