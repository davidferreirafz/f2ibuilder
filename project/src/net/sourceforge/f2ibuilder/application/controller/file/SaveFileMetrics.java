package net.sourceforge.f2ibuilder.application.controller.file;

import java.awt.Component;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import net.sourceforge.f2ibuilder.application.controller.generics.SaveFile;
import net.sourceforge.f2ibuilder.application.model.FontText;
import net.sourceforge.f2ibuilder.components.dialog.FileDialog;

public class SaveFileMetrics extends SaveFile
{
    private FontText fontText;
    
    public SaveFileMetrics(FontText fontText)
    {
        this.fontText=fontText;
    }

    @Override
    protected void action(Component component)
    {
        BufferedWriter out;        
        FileDialog fd = FileDialog.getInstance();            
        
        if(fd.showSaveDialogMetric(component)){
            
            String filename = fd.getFilePathMetric();
            
            try {
                char v[] = new char[256];           

                for (int i=0; i<256; i++)
                {
                    v[i]=(char) fontText.getCharacterMetric(i);
                }

                if (!filename.endsWith("dat")){
                    filename+=".dat";
                }

                out = new BufferedWriter(new FileWriter(filename));
                out.write(v);
                out.close();
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
    }

}
