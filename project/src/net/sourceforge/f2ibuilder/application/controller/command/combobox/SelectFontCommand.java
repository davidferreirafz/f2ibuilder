package net.sourceforge.f2ibuilder.application.controller.command.combobox;

import net.sourceforge.f2ibuilder.application.model.FontText;
import net.sourceforge.f2ibuilder.application.model.Options;


public class SelectFontCommand extends ComboboxCommand
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
