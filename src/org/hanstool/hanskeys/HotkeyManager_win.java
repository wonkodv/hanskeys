
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

import java.util.Iterator;

import com.sun.jna.*;
import com.sun.jna.win32.*;
import com.sun.jna.platform.win32.*;
import com.sun.jna.platform.win32.WinDef.*;
import com.sun.jna.platform.win32.WinUser.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The Windows Implementaion.
 * There is an Extra listener thread that registers the hotkeys calling user32.dll RegisterHotKey
 * and in a loop calls PeekMessage until Interupted using HotkeyManager.stop();
 * @author Wonko
 */
class HotkeyManager_win extends HotkeyManager implements Runnable
{

	private Thread theThread;
	private boolean updated = false;


	protected HotkeyManager_win()
	{
		super();
	}


	/**
	 * Starts the Listener Thread
	 */
	public void start()
	{
		if (theThread == null)
		{
			theThread = new Thread(this, "HotkeyWorker");
			theThread.start();
		}
	}


	/**
	 * Interupts the WorkerThread ad waits for it to die
	 * @throws InterruptedException
	 */
	public void stop() throws InterruptedException
	{
		if (theThread == null)
		{
			return;
		}

		theThread.interrupt();
		theThread.join();
		theThread = null;
	}


	@Override
	protected void update()
	{
		updated = true;
	}

	// http://msdn.microsoft.com/en-us/library/ms646309%28v=vs.85%29.aspx
	private final int MOD_ALT = 0x0001;
	private final int MOD_CONTROL = 0x0002;
	private final int MOD_SHIFT = 0x0004;
	private final int MOD_WIN = 0x0008;
	private final int MOD_NOREPEAT = 0x4000;


	public void run()
	{
		System.out.println("HKWorker Start");
		while (!Thread.interrupted())
		{
			try
			{
				if (updated)
				{
					synchronized (this)
					{
						updated = false;
						for (Iterator<HotKey> it = hotkeys.iterator(); it.hasNext();)
						{
							HotKey hk = it.next();
							synchronized (hk)
							{
								if (hk.isToBeDeleted())
								{
									hk.setError(!unRegisterHotkey(hk));
									hk.notifyAll();
									it.remove();
								}
								else if (!hk.isRegistered())
								{
									registerHotkey(hk);
									hk.notifyAll();
								}
							}
						}
					}
				}

				int hotKeyId;
				MSG msg = new MSG();
				while (User32.INSTANCE.PeekMessage(msg, null, 0, 0, 1))
				{
					hotKeyId = msg.wParam.intValue();
					if (hotKeyId != 0)
					{
						for (Iterator<HotKey> it = hotkeys.iterator(); it.hasNext();)
						{
							HotKey hk = it.next();
							if (hk.getId() == hotKeyId)
							{
								hk.onHotkeyPress();
							}
						}
					}
				}
			}
			catch (Exception t)
			{
				t.printStackTrace();
			}
			try
			{
				Thread.sleep(50);
			}
			catch (InterruptedException ex)
			{
				break;
			}
		}
		theThread = null;
		System.out.println("HKWorker Stop");
	}


	private boolean unRegisterHotkey(HotKey hk)
	{
		boolean b = User32_ext.I.UnregisterHotKey(null, hk.getId());
		if (b)
		{
			hk.setRegistered(false);
			hk.setToBeDeleted(false);
		}
		return b;
	}


	private boolean registerHotkey(HotKey hk)
	{
		int modifier = 0;

		if (hk.isAlt())
		{
			modifier |= MOD_ALT;
		}
		if (hk.isControl())
		{
			modifier |= MOD_CONTROL;
		}
		if (hk.isShift())
		{
			modifier |= MOD_SHIFT;
		}
		if (hk.isWin())
		{
			modifier |= MOD_WIN;
		}
		if (hk.isNoRepeat())
		{
			modifier |= MOD_NOREPEAT;
		}

		hk.setId(hotkeyIndex++);
		boolean b = User32_ext.I.RegisterHotKey(null, hk.getId(), modifier, hk.getKeyCode());
		if (b)
		{
			hk.setRegistered(true);
		}
		return b;
	}

	private int hotkeyIndex = 1;

	public interface User32_ext extends StdCallLibrary
	{

		User32_ext I = (User32_ext) Native.loadLibrary("User32", User32_ext.class);
		/* BOOL WINAPI RegisterHotKey(
		__in_opt  HWND hWnd,
		__in      int id,
		__in      UINT fsModifiers,
		__in      UINT vk
		);
		 */


		boolean RegisterHotKey(HWND hWnd, int id, int fsModifiers, int vk);

		/*
		BOOL WINAPI UnregisterHotKey(
		__in_opt  HWND hWnd,
		__in      int id
		);
		 */

		boolean UnregisterHotKey(HWND hWnd, int id);

		public final int WM_HOTKEY = 0x0312;

		/*BOOL WINAPI PeekMessage(
		__out     LPMSG lpMsg,
		__in_opt  HWND hWnd,
		__in      UINT wMsgFilterMin,
		__in      UINT wMsgFilterMax,
		__in      UINT wRemoveMsg
		);
		 */
		//boolean PeekMessage(MSG msg, HWND hwnd, int i, int i1, int i2);
	}
}
