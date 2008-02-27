package net.sourceforge.f2ibuilder.application.controller.command;

import net.sourceforge.f2ibuilder.application.controller.generics.SelectComboboxCommand;
import net.sourceforge.f2ibuilder.application.model.FontText;
import net.sourceforge.f2ibuilder.application.model.Options;


public class SelectFontCommand extends SelectComboboxCommand
{   
    public SelectFontCommand(Options options, FontText fontText)
    {
        super(options,fontText);
    }

    @Override
    protected void action(String value)
    {
        fontText.setFontName(value);        
    }   
}
