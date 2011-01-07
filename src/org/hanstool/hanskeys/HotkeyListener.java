/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.hanstool.hanskeys;

/**
 * Listener for Hotkeys
 * @author Wonko
 */
public interface HotkeyListener
{

	/**
	 * Called when the hotkey is pressed
	 */
	public void onHotkeyPress(HotKey hk);

}
