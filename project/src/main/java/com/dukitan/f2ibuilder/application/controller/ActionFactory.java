/**
 * 
 */
package com.dukitan.f2ibuilder.application.controller;

import java.awt.Window;
import java.awt.event.ActionListener;

import com.dukitan.f2ibuilder.application.controller.generics.CloseWindow;

/**
 * @author David Ferreira <davidferreira.fz@gmail.com>
 *
 * Project: F2IBuilder
 * Date: 08/03/2008
 *
 */
abstract public class ActionFactory
{
    public static ActionListener makeCloseWindow(Window window)
    {
        return new CloseWindow(window);
    }
}
