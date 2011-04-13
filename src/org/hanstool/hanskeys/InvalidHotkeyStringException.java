/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.hanstool.hanskeys;

/**
 * @author Wonko
 */
public class InvalidHotkeyStringException extends Exception
{
	
	/**
	 * Creates a new instance of <code>InvalidHotkeyStringException</code>
	 * without detail message.
	 */
	public InvalidHotkeyStringException()
	{
		super();
	}
	
	/**
	 * Constructs an instance of <code>InvalidHotkeyStringException</code> with
	 * the specified detail message.
	 * 
	 * @param msg
	 *            the detail message.
	 */
	public InvalidHotkeyStringException(String msg)
	{
		super(msg);
	}
}
