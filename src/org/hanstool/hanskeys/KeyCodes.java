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

import java.awt.event.KeyEvent;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Has lists and constants of virtual KeyCodes
 * 
 * @author Wonko
 */
@SuppressWarnings({ "all" })
public class KeyCodes
{
	public static final Map<String, Integer>	StrToVkMap;
	public static final Map<Integer, String>	VkToStrMap;
	
	static
	{
		Map<String, Integer> m1 = new HashMap<String, Integer>(255);
		Map<Integer, String> m2 = new HashMap<Integer, String>(255);
		
		Field[] fields = KeyEvent.class.getDeclaredFields();
		
		for(Field f : fields)
		{
			if(f.getType() == int.class && f.getName().startsWith("VK_"))
			{
				try
				{
					String key = f.getName().substring(3);
					Integer value = f.getInt(null);
					m1.put(key, value);
					m2.put(value, key);
				}
				catch(IllegalArgumentException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				catch(IllegalAccessException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
		StrToVkMap = Collections.unmodifiableMap(m1);
		VkToStrMap = Collections.unmodifiableMap(m2);
	}
	
	/**
	 * Get stringRepresentation for a specific virtual KeyCode
	 * 
	 * @param iVk
	 *            KeyCode
	 * @return StringRepresentation
	 */
	public static String get(int iVk)
	{
		String result = VkToStrMap.get(iVk);
		if(result != null)
		{
			return result;
		}
		return "#" + Integer.toHexString(iVk);
	}
	
	/**
	 * Get virtual KeyCode for a specific Key-stringRepresentation or returns ab
	 * from #AB
	 * 
	 * @param sVk
	 *            StringRepresentation
	 * @return KeyCode
	 */
	public static Integer get(String sVk)
	{
		Integer result = StrToVkMap.get(sVk);
		if(result != null)
		{
			return result;
		}
		if(sVk.startsWith("#"))
		{
			return Integer.parseInt(sVk.substring(1), 16);
		}
		throw new IllegalArgumentException();
	}
	
}
