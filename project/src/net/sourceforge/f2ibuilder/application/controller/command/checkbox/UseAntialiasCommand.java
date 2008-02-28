package net.sourceforge.f2ibuilder.application.controller.command.checkbox;

import javax.swing.JCheckBoxMenuItem;

import net.sourceforge.f2ibuilder.application.model.FontText;
import net.sourceforge.f2ibuilder.application.model.Options;


public class UseAntialiasCommand extends CheckBoxCommand
{   
    public UseAntialiasCommand(Options options, FontText fontText)
    {
        super(options,fontText);
    }

    @Override
    protected void action(JCheckBoxMenuItem checkbox)
    {
        options.setAntialias(checkbox.getState());
    }   
}
