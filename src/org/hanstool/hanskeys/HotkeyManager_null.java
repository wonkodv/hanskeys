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
 * Implementation that does nothing
 */
class HotkeyManager_null extends HotkeyManager
{
	protected HotkeyManager_null()
	{
		super();
	}
	
	@Override
	public void start()
	{
	}
	
	@Override
	public void stop() throws InterruptedException
	{
	}
	
	@Override
	protected void update()
	{
	}
	
	@Override
	public void addHotKey(HotKey hk)
	{
		notifyHK(hk);
	}
	
	@Override
	public void removeHotKey(HotKey hk)
	{
		notifyHK(hk);
	}

	private void notifyHK(final HotKey hk)
	{
		new Thread() {
			@Override
			public void run()
			{
				synchronized(hk)
				{
					hk.notify();
				}
			}
		}.start();
	}
}
