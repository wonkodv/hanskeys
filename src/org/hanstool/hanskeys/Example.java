
package org.hanstool.hanskeys;

import java.awt.event.KeyEvent;
import java.io.IOException;

/**
 *
 * @author Wonko
 */
public class Example
{

	public static void main(String[] argv) throws InterruptedException, IOException, InvalidHotkeyStringException
	{
		System.out.println("main start");

		HotkeyListener listener = new SomeHotKeyListener();
		HotKey F6 = new HotKey("Ctrl + F6", false, listener);

		HotKey F4 = new HotKey(KeyCodes.VK_F4, true, false, false, false, false, listener);

		HotkeyManager hm = HotkeyManager.getHotkeyManager();

		hm.addHotKey(F6);
		hm.addHotKey(F4);

		hm.start();
		Thread.sleep(5000);
		hm.removeHotKey(F4);
		System.out.println("removed F4");
		Thread.sleep(5000);
		hm.removeHotKey(F6);
		System.out.println("removed F6");
		synchronized (F4)
		{
			hm.addHotKey(F4);
			F4.wait();
			System.out.println("added f4 [[" + F4);

		}
		Thread.sleep(5000);
		hm.stop();

		System.out.println("main Over");
	}

	static class SomeHotKeyListener implements HotkeyListener
	{

		public void onHotkeyPress(HotKey hk)
		{

			System.out.println("Hotkey Pressed [" + hk + "]");
		}

	}
}
