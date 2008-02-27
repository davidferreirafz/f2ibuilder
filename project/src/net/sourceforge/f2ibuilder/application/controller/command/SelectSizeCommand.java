package net.sourceforge.f2ibuilder.application.controller.command;

import net.sourceforge.f2ibuilder.application.controller.generics.SelectComboboxCommand;
import net.sourceforge.f2ibuilder.application.model.FontText;
import net.sourceforge.f2ibuilder.application.model.Options;


public class SelectSizeCommand extends SelectComboboxCommand
{
    public SelectSizeCommand(Options options, FontText fontText)
    {
        super(options,fontText);
    }

    @Override
    protected void action(String value)
    {
        if (!value.equals("")){
            int size = Integer.parseInt(value); 
            fontText.setFontSize(size);
        }
    }   
}
