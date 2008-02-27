package net.sourceforge.f2ibuilder.application.controller.command;

import net.sourceforge.f2ibuilder.application.controller.generics.SelectComboboxCommand;
import net.sourceforge.f2ibuilder.application.model.FontText;
import net.sourceforge.f2ibuilder.application.model.Options;


public class SelectTextureSizeCommand extends SelectComboboxCommand
{
    public SelectTextureSizeCommand(Options options, FontText fontText)
    {
        super(options,fontText);
    }

    @Override
    protected void action(String value)
    {
        int size = 0;
        
        if (!value.equalsIgnoreCase("auto")){
            size=Integer.parseInt(value);
        }           
        
        options.setTextureSize(size);
    }   
}
