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
 * @author Wonko
 */
public abstract class HotkeyManager
{

	/**
	 * @return the right HotkeyManager for the System
	 */
	public static HotkeyManager getHotkeyManager()
	{
		String osName = System.getProperty("os.name");
		if(osName.matches("Windows.*"))
		{
			return new HotkeyManager_win();
		}
		return new HotkeyManager_null();

	}

	/**
	 * Registers a hotkey. It might take a little while. As soon as the hotkey
	 * is active, hk ist notified.
	 *
	 * @param hk
	 */
	public abstract void addHotKey(HotKey hk);
	
	/**
	 * Unregisters a hotkey. It might take a little while. As soon as the hotkey
	 * is deactivated, hk ist notified.
	 *
	 * @param hk
	 */
	public abstract void removeHotKey(HotKey hk);

	/**
	 * Start Listening for Hotkeys
	 */
	public abstract void start();

	/**
	 * Stop Listening for Hotkeys
	 *
	 * @throws InterruptedException
	 */
	public abstract void stop() throws InterruptedException;

	/**
	 * Update is called after there is a change to the hotkeys. Is called
	 * synchronized on this. It would be polite to call notify on the hotkey if
	 * its changed
	 */
	protected abstract void update();

}
