/**
 * 
 */
package net.sourceforge.f2ibuilder.components.memento;

/**
 * @author David Ferreira <davidferreira.fz@gmail.com>
 *
 * Project: F2IBuilder
 * Date: 14/04/2008
 *
 */
public interface IMementoSupported
{
    /**
     * Suporte para recupera��o de um estado anterior
     * 
     * Suporte ao design pattern: GoF - Memento
     * 
     * @param memento objeto com o estado anterior
     */
    public void setMemento(ProjectMemento memento);
    
    /**
     * Implementa��o do suporte para a externaliza��o do estado da classe, sem expor
     * seus valores para manipula��o de outras classes.
     * 
     * Suporte ao design pattern: GoF - Memento
     */
    public ProjectMemento createMemento();
}
