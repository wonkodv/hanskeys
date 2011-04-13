/*
 * HansKeys
 * Global Hotkeys for java on All Plattforms(coming soon).
 * http://hanskeys.sourceforge.net/
 *
 * required Libraries:
 * jna.jat		https://jna.dev.java.net/
 * platform.jar	https://jna.dev.java.net/
 *
 *
 */
package org.hanstool.hanskeys;

/**
 * Listener for Hotkeys
 * 
 * @author Wonko
 */
public interface HotkeyListener
{
	
	/**
	 * Called when the hotkey is pressed
	 * 
	 * @param hk
	 */
	public void onHotkeyPress(HotKey hk);
	
}
