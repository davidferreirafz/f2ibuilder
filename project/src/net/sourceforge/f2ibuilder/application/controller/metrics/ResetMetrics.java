package net.sourceforge.f2ibuilder.application.controller.metrics;

import net.sourceforge.f2ibuilder.application.controller.generics.FontTextAction;
import net.sourceforge.f2ibuilder.application.model.FontText;


public class ResetMetrics extends FontTextAction
{
    
    public ResetMetrics(FontText tableChar)
    {
        super(tableChar);        
    }

    @Override
    protected void action()
    {
        fontText.resetMetrics();
    }
    

}
