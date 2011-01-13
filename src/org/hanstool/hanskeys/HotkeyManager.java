
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

import java.util.LinkedList;
import java.util.List;

/**
 *
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
		if (osName.matches("Windows.*"))
		{
			return new HotkeyManager_win();
		}
		else
		{
			throw new UnsupportedOperationException("not Implemented");
		}
	}


	public HotkeyManager()
	{
		this.hotkeys = new LinkedList<HotKey>();
	}


	/**
	 * Update is called after there is a change to the hotkeys.
	 * Is called synchronized on this.
	 * It would be polite to call notify on the hotkey if its changed
	 */
	protected abstract void update();

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

	protected final List<HotKey> hotkeys;


	/**
	 * Registers a hotkey. It is inserted in the WorkerThreads TodoQueue that will register it pretty soon.
	 * hk.notifyAll is called then
	 * @param hk
	 */
	public synchronized  void addHotKey(HotKey hk)
	{
		if (hotkeys.contains(hk))
		{
			throw new UnsupportedOperationException("Cant insert the same hotkey twice");
		}
		hotkeys.add(hk);
		update();
	}


	/**
	 * Removes a hotkey. It is inserted in the WorkerThreads TodoQueue that will Delete it pretty soon
	 */
	public synchronized void removeHotKey(HotKey hk)
	{
		if (hotkeys.contains(hk))
		{
			hk.setToBeDeleted(true);
			update();
		}
		else
		{
			throw new UnsupportedOperationException("Hotkey is not in the list");
		}
	}
	
}
