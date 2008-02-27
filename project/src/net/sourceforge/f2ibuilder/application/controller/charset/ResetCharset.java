package net.sourceforge.f2ibuilder.application.controller.charset;

import net.sourceforge.f2ibuilder.application.controller.generics.FontTextAction;
import net.sourceforge.f2ibuilder.application.model.FontText;


public class ResetCharset extends FontTextAction
{
    public ResetCharset(FontText tableChar)
    {
        super(tableChar);        
    }

    @Override
    protected void action()
    {
        fontText.resetCharset();
    }
    

}
