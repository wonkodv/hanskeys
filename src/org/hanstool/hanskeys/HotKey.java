
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

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Wonko
 */
public class HotKey
{

	private final int keyCode;

	private final boolean alt;

	private final boolean control;

	private final boolean shift;

	private final boolean win;

	private final boolean noRepeat;

	private boolean registered;

	private boolean toBeDeleted;

	private boolean error;

	private int id;

	private final List<HotkeyListener> listeners;


	/**
	 *
	 * @param keyCode
	 * @param alt
	 * @param control
	 * @param shift
	 * @param win
	 * @param noRepeat Windows Only. See MSDN RegisterHotkey
	 * @param listeners
	 */
	public HotKey(int keyCode, boolean control, boolean alt, boolean shift, boolean win, boolean noRepeat, HotkeyListener... listeners)
	{
		this.keyCode = keyCode;
		this.alt = alt;
		this.control = control;
		this.shift = shift;
		this.win = win;
		this.noRepeat = noRepeat;
		error = false;
		this.listeners = new LinkedList<HotkeyListener>(Arrays.asList(listeners));
	}


	/**
	 * Creates a new Hotkey from a StringRepresentation
	 * @param hotkey	String in Form of Ctrl + Alt + Del Use Only names From KeyCodes.VkToStrMap
	 * @param noRepeat Windows Only(i guess). See MSDN RegisterHotkey
	 * @param listeners
	 * @throws InvalidHotkeyStringException if the String was bad
	 */
	public HotKey(String hotkey, boolean noRepeat, HotkeyListener... listeners) throws InvalidHotkeyStringException
	{

		String[] pices = hotkey.split("[ +]+");
		if (pices.length == 0)
		{
			throw new InvalidHotkeyStringException("Hotkey must not be empty");
		}

		Integer vk = KeyCodes.getMapStrToVK().get(pices[pices.length - 1]);

		if (vk != null)
		{

			boolean alt = false, ctrl = false, shift = false, win = false;
			for (int i = 0; i < pices.length - 1; i++)
			{
				if (pices[i].equalsIgnoreCase("Ctrl"))
				{
					ctrl = true;
				}
				else if (pices[i].equalsIgnoreCase("Alt"))
				{
					alt = true;
				}
				else if (pices[i].equalsIgnoreCase("Shift"))
				{
					shift = true;
				}
				else if (pices[i].equalsIgnoreCase("Win"))
				{
					win = true;
				}
				else
				{
					throw new InvalidHotkeyStringException("No Valid Hotkey Modifier :" + pices[i]);
				}

			}
			this.keyCode = vk;
			this.alt = alt;
			this.control = ctrl;
			this.shift = shift;
			this.win = win;
			this.noRepeat = noRepeat;
			this.listeners = new LinkedList<HotkeyListener>(Arrays.asList(listeners));

		}
		else
		{
			throw new InvalidHotkeyStringException("Hotkey VirtualKeyCode not Found:" + pices[pices.length - 1]);
		}
	}


	public void onHotkeyPress()
	{
		for (Iterator<HotkeyListener> it = listeners.iterator(); it.hasNext();)
		{
			HotkeyListener hotkeyListener = it.next();

			hotkeyListener.onHotkeyPress(this);
		}
	}


	/**
	 * @return the HotkeyString as in Ctrl + Alt + Delete
	 */
	public String getHotkeyString()
	{
		return (isControl() ? "Ctrl + " : "") + (isAlt() ? "Alt + " : "") + (isShift() ? "Shift + " : "") + (isWin() ? "Win + " : "") + KeyCodes.get(getKeyCode());
	}


	/**
	 * retruns a StringRepresentation including Status
	 * @return the HotkeyString as in [F8] Registered
	 */
	public String toString()
	{
		return "[" + getHotkeyString() + "]" + (isRegistered() ? " Registered" : "") + (isToBeDeleted() ? " toBeDeleted" : "") + (isError() ? " E R R O R" : "");
	}

	


	// <editor-fold defaultstate="collapsed" desc="Getters">
	/**
	 * @return the keyCode
	 */
	public int getKeyCode()
	{
		return keyCode;
	}


	/**
	 * @return the alt
	 */
	public boolean isAlt()
	{
		return alt;
	}


	/**
	 * @return the control
	 */
	public boolean isControl()
	{
		return control;
	}


	/**
	 * @return the shift
	 */
	public boolean isShift()
	{
		return shift;
	}


	/**
	 * @return the win
	 */
	public boolean isWin()
	{
		return win;
	}


	/**
	 * @return the noRepeat
	 */
	public boolean isNoRepeat()
	{
		return noRepeat;
	}


	/**
	 * @return the listeners
	 */
	public List<HotkeyListener> getListeners()
	{
		return listeners;
	}


	/**
	 * @return the registered
	 */
	public boolean isRegistered()
	{
		return registered;
	}


	/**
	 * @param registered the registered to set
	 */
	protected void setRegistered(boolean registered)
	{
		this.registered = registered;
	}


	/**
	 * @return the OS identifier for the hotkey
	 */
	public int getId()
	{
		return id;
	}


	/**
	 * @param id the id to set
	 */
	protected void setId(int id)
	{
		this.id = id;
	}


	/**
	 * @return the toBeDeleted
	 */
	public boolean isToBeDeleted()
	{
		return toBeDeleted;
	}


	/**
	 * @param toBeDeleted the toBeDeleted to set
	 */
	protected void setToBeDeleted(boolean toBeDeleted)
	{
		this.toBeDeleted = toBeDeleted;
	}


	/**
	 * @return the error
	 */
	public boolean isError()
	{
		return error;
	}


	/**
	 * @param error the error to set
	 */
	protected void setError(boolean error)
	{
		this.error = error;
	}
	// </editor-fold>
}
