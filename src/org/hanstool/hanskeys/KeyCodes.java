
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
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Has lists and constants of virtual KeyCodes
 * @author Wonko
 */
public class KeyCodes
{
	/**
	 * Get virtual KeyCode for a specific Key-stringRepresentation
	 * @param sVk StringRepresentation
	 * @return KeyCode
	 */
	public static Integer get(String sVk)
	{
		Integer result = getMapStrToVK().get(sVk);
		if (result != null)
		{
			return result;
		}
		return Integer.parseInt(sVk, 16);
	}

	//TODO ein map aus KeyEvent befüllen, andere aus 1ter

	/**
	 * Get stringRepresentation for a specific virtual KeyCode
	 * @param iVk KeyCode
	 * @return StringRepresentation
	 */
	public static String get(int iVk)
	{
		String result = getMapVKToStr().get(iVk);
		if (result != null)
		{
			return result;
		}
		return Integer.toHexString(iVk);
	}

	/**
	 * Maps KeyNames to their Keycodes
	 * @return the map
	 */
	public static Map<String, Integer> getMapStrToVK()
	{
		if (StrToVkMap == null)
		{
			StrToVkMap = populateKeyCodeList();
		}
		return StrToVkMap;
	}



	/**
	 * Maps Keycodes to their KeyNames
	 * @return the map
	 */
	public static Map<Integer, String> getMapVKToStr()
	{
		if (VkToStrMap == null)
		{
			VkToStrMap = populateKeyCodeList2();
		}
		return VkToStrMap;
	}

	private static Map<String, Integer> StrToVkMap;

	private static Map<Integer, String> VkToStrMap;


	private static Map<String, Integer> populateKeyCodeList()
	{
		Map<String, Integer> list = new HashMap<String, Integer>(364 - 212 + 2);
		Map<Integer,String> otherlist = getMapVKToStr();

		for (Integer vk : otherlist.keySet())
		{
			list.put(otherlist.get(vk), vk);
		}


		return list;
	}


	private static Map<Integer, String> populateKeyCodeList2()
	{
		Map<Integer, String> list = new HashMap<Integer, String>(364 - 212 + 2);//zeilen nummern + etwas mehr platz
		// <editor-fold defaultstate="collapsed" desc="Fill Key Map">
		list.put(VK_MouseLeft, "MouseLeft");
		list.put(VK_MouseRight, "MouseRight");
		list.put(VK_Break, "Break");
		list.put(VK_MouseMiddle, "MouseMiddle");
		list.put(VK_Mouse4, "Mouse4");
		list.put(VK_Mouse5, "Mouse5");
		list.put(VK_BackSpace, "BackSpace");
		list.put(VK_Tab, "Tab");
		list.put(VK_Clear, "Clear");
		list.put(VK_Enter, "Enter");
		list.put(VK_Shift, "Shift");
		list.put(VK_Ctrl, "Ctrl");
		list.put(VK_Alt, "Alt");
		list.put(VK_Pause, "Pause");
		list.put(VK_CapsLock, "CapsLock");
		list.put(VK_Escape, "Escape");
		list.put(VK_Space, "Space");
		list.put(VK_PageUp, "PageUp");
		list.put(VK_PageDown, "PageDown");
		list.put(VK_End, "End");
		list.put(VK_Home, "Home");
		list.put(VK_ArrowLeft, "ArrowLeft");
		list.put(VK_ArrowUp, "ArrowUp");
		list.put(VK_ArrowRight, "ArrowRight");
		list.put(VK_ArrowDown, "ArrowDown");
		list.put(VK_Select, "Select");
		list.put(VK_Print, "Print");
		list.put(VK_Execute, "Execute");
		list.put(VK_PrintScreen, "PrintScreen");
		list.put(VK_Insert, "Insert");
		list.put(VK_Delete, "Delete");
		list.put(VK_Help, "Help");
		list.put(VK_0, "0");
		list.put(VK_1, "1");
		list.put(VK_2, "2");
		list.put(VK_3, "3");
		list.put(VK_4, "4");
		list.put(VK_5, "5");
		list.put(VK_6, "6");
		list.put(VK_7, "7");
		list.put(VK_8, "8");
		list.put(VK_9, "9");
		list.put(VK_A, "A");
		list.put(VK_B, "B");
		list.put(VK_C, "C");
		list.put(VK_D, "D");
		list.put(VK_E, "E");
		list.put(VK_F, "F");
		list.put(VK_G, "G");
		list.put(VK_H, "H");
		list.put(VK_I, "I");
		list.put(VK_J, "J");
		list.put(VK_K, "K");
		list.put(VK_L, "L");
		list.put(VK_M, "M");
		list.put(VK_N, "N");
		list.put(VK_O, "O");
		list.put(VK_P, "P");
		list.put(VK_Q, "Q");
		list.put(VK_R, "R");
		list.put(VK_S, "S");
		list.put(VK_T, "T");
		list.put(VK_U, "U");
		list.put(VK_V, "V");
		list.put(VK_W, "W");
		list.put(VK_X, "X");
		list.put(VK_Y, "Y");
		list.put(VK_Z, "Z");
		list.put(VK_LeftWindows, "LeftWindows");
		list.put(VK_RightWindows, "RightWindows");
		list.put(VK_Applications, "Applications");
		list.put(VK_Reset, "Reset");
		list.put(VK_ComputerSleep, "ComputerSleep");
		list.put(VK_NP0, "NP0");
		list.put(VK_NP1, "NP1");
		list.put(VK_NP2, "NP2");
		list.put(VK_NP3, "NP3");
		list.put(VK_NP4, "NP4");
		list.put(VK_NP5, "NP5");
		list.put(VK_NP6, "NP6");
		list.put(VK_NP7, "NP7");
		list.put(VK_NP8, "NP8");
		list.put(VK_NP9, "NP9");
		list.put(VK_NPMultiply, "NPMultiply");
		list.put(VK_NPAdd, "NPAdd");
		list.put(VK_NPSeparator, "NPSeparator");
		list.put(VK_NPSubtract, "NPSubtract");
		list.put(VK_NPDecimal, "NPDecimal");
		list.put(VK_NPDivide, "NPDivide");
		list.put(VK_F1, "F1");
		list.put(VK_F2, "F2");
		list.put(VK_F3, "F3");
		list.put(VK_F4, "F4");
		list.put(VK_F5, "F5");
		list.put(VK_F6, "F6");
		list.put(VK_F7, "F7");
		list.put(VK_F8, "F8");
		list.put(VK_F9, "F9");
		list.put(VK_F10, "F10");
		list.put(VK_F11, "F11");
		list.put(VK_F12, "F12");
		list.put(VK_F13, "F13");
		list.put(VK_F14, "F14");
		list.put(VK_F15, "F15");
		list.put(VK_F16, "F16");
		list.put(VK_F17, "F17");
		list.put(VK_F18, "F18");
		list.put(VK_F19, "F19");
		list.put(VK_F20, "F20");
		list.put(VK_F21, "F21");
		list.put(VK_F22, "F22");
		list.put(VK_F23, "F23");
		list.put(VK_F24, "F24");
		list.put(VK_NumLock, "NumLock");
		list.put(VK_CrollLock, "CrollLock");
		list.put(VK_ShiftLeft, "ShiftLeft");
		list.put(VK_ShiftRight, "ShiftRight");
		list.put(VK_CtrlLeft, "CtrlLeft");
		list.put(VK_CtrlRight, "CtrlRight");
		list.put(VK_AltLeft, "AltLeft");
		list.put(VK_AltRight, "AltRight");
		list.put(VK_BrowserBack, "BrowserBack");
		list.put(VK_BrowserForward, "BrowserForward");
		list.put(VK_BrowserRefresh, "BrowserRefresh");
		list.put(VK_BrowserStop, "BrowserStop");
		list.put(VK_BrowserSearch, "BrowserSearch");
		list.put(VK_BrowserFavorites, "BrowserFavorites");
		list.put(VK_BrowserStartAndHome, "BrowserStartAndHome");
		list.put(VK_VolumeMute, "VolumeMute");
		list.put(VK_VolumeDown, "VolumeDown");
		list.put(VK_VolumeUp, "VolumeUp");
		list.put(VK_MediaNext, "MediaNext");
		list.put(VK_MediaPrevious, "MediaPrevious");
		list.put(VK_MediaStop, "MediaStop");
		list.put(VK_MediaPlayPause, "MediaPlayPause");
		list.put(VK_StartMail, "StartMail");
		list.put(VK_SelectMedia, "SelectMedia");
		list.put(VK_StartApplication1, "StartApplication1");
		list.put(VK_StartApplication2, "StartApplication2");
		list.put(VK_SemiColon_Colon, ";");
		list.put(VK_Equals_plus, "=");
		list.put(VK_Comma_LessThan, ",");
		list.put(VK_Minus_Underscore, "-");
		list.put(VK_Dot_GraterThan, ".");
		list.put(VK_Slash_QuestionMark, "/");
		list.put(VK_Accent_Tilde, "`");
		list.put(VK_LBrack_LCurly, "[");
		list.put(VK_BackSlashPipe, "\\");
		list.put(VK_RBrack_RCurly, "]");
		list.put(VK_Quotes, "'");
		list.put(VK_Play, "Play");
		list.put(VK_Zoom, "Zoom");
		// </editor-fold>
		return list;
	}
	// <editor-fold defaultstate="collapsed" desc="VirtualKeyCodes">

	public static final int VK_MouseLeft = 0x01;

	public static final int VK_MouseRight = 0x02;

	public static final int VK_Break = 0x03;

	public static final int VK_MouseMiddle = 0x04;

	public static final int VK_Mouse4 = 0x05;

	public static final int VK_Mouse5 = 0x06;

	public static final int VK_BackSpace = 0x08;

	public static final int VK_Tab = 0x09;

	public static final int VK_Clear = 0x0C;

	public static final int VK_Enter = 0x0A;

	public static final int VK_Shift = 0x10;

	public static final int VK_Ctrl = 0x11;

	public static final int VK_Alt = 0x12;

	public static final int VK_Pause = 0x13;

	public static final int VK_CapsLock = 0x14;

	public static final int VK_Escape = 0x1B;

	public static final int VK_Space = 0x20;

	public static final int VK_PageUp = 0x21;

	public static final int VK_PageDown = 0x22;

	public static final int VK_End = 0x23;

	public static final int VK_Home = 0x24;

	public static final int VK_ArrowLeft = 0x25;

	public static final int VK_ArrowUp = 0x26;

	public static final int VK_ArrowRight = 0x27;

	public static final int VK_ArrowDown = 0x28;

	public static final int VK_Select = 0x29;

	public static final int VK_Print = 0x2A;

	public static final int VK_Execute = 0x2B;

	public static final int VK_PrintScreen = 0x2C;

	public static final int VK_Insert = 0x2D;

	public static final int VK_Delete = 0x2E;

	public static final int VK_Help = 0x2F;

	public static final int VK_0 = 0x30;

	public static final int VK_1 = 0x31;

	public static final int VK_2 = 0x32;

	public static final int VK_3 = 0x33;

	public static final int VK_4 = 0x34;

	public static final int VK_5 = 0x35;

	public static final int VK_6 = 0x36;

	public static final int VK_7 = 0x37;

	public static final int VK_8 = 0x38;

	public static final int VK_9 = 0x39;

	public static final int VK_A = 0x41;

	public static final int VK_B = 0x42;

	public static final int VK_C = 0x43;

	public static final int VK_D = 0x44;

	public static final int VK_E = 0x45;

	public static final int VK_F = 0x46;

	public static final int VK_G = 0x47;

	public static final int VK_H = 0x48;

	public static final int VK_I = 0x49;

	public static final int VK_J = 0x4A;

	public static final int VK_K = 0x4B;

	public static final int VK_L = 0x4C;

	public static final int VK_M = 0x4D;

	public static final int VK_N = 0x4E;

	public static final int VK_O = 0x4F;

	public static final int VK_P = 0x50;

	public static final int VK_Q = 0x51;

	public static final int VK_R = 0x52;

	public static final int VK_S = 0x53;

	public static final int VK_T = 0x54;

	public static final int VK_U = 0x55;

	public static final int VK_V = 0x56;

	public static final int VK_W = 0x57;

	public static final int VK_X = 0x58;

	public static final int VK_Y = 0x59;

	public static final int VK_Z = 0x5A;

	public static final int VK_LeftWindows = 0x5B;

	public static final int VK_RightWindows = 0x5C;

	public static final int VK_Applications = 0x5D;

	public static final int VK_Reset = 0x5E;

	public static final int VK_ComputerSleep = 0x5F;

	public static final int VK_NP0 = 0x60;

	public static final int VK_NP1 = 0x61;

	public static final int VK_NP2 = 0x62;

	public static final int VK_NP3 = 0x63;

	public static final int VK_NP4 = 0x64;

	public static final int VK_NP5 = 0x65;

	public static final int VK_NP6 = 0x66;

	public static final int VK_NP7 = 0x67;

	public static final int VK_NP8 = 0x68;

	public static final int VK_NP9 = 0x69;

	public static final int VK_NPMultiply = 0x6A;

	public static final int VK_NPAdd = 0x6B;

	public static final int VK_NPSeparator = 0x6C;

	public static final int VK_NPSubtract = 0x6D;

	public static final int VK_NPDecimal = 0x6E;

	public static final int VK_NPDivide = 0x6F;

	public static final int VK_F1 = 0x70;

	public static final int VK_F2 = 0x71;

	public static final int VK_F3 = 0x72;

	public static final int VK_F4 = 0x73;

	public static final int VK_F5 = 0x74;

	public static final int VK_F6 = 0x75;

	public static final int VK_F7 = 0x76;

	public static final int VK_F8 = 0x77;

	public static final int VK_F9 = 0x78;

	public static final int VK_F10 = 0x79;

	public static final int VK_F11 = 0x7A;

	public static final int VK_F12 = 0x7B;

	public static final int VK_F13 = 0x7C;

	public static final int VK_F14 = 0x7D;

	public static final int VK_F15 = 0x7E;

	public static final int VK_F16 = 0x7F;

	public static final int VK_F17 = 0x80;

	public static final int VK_F18 = 0x81;

	public static final int VK_F19 = 0x82;

	public static final int VK_F20 = 0x83;

	public static final int VK_F21 = 0x84;

	public static final int VK_F22 = 0x85;

	public static final int VK_F23 = 0x86;

	public static final int VK_F24 = 0x87;

	public static final int VK_NumLock = 0x90;

	public static final int VK_CrollLock = 0x91;

	public static final int VK_ShiftLeft = 0xA0;

	public static final int VK_ShiftRight = 0xA1;

	public static final int VK_CtrlLeft = 0xA2;

	public static final int VK_CtrlRight = 0xA3;

	public static final int VK_AltLeft = 0xA4;

	public static final int VK_AltRight = 0xA5;

	public static final int VK_BrowserBack = 0xA6;

	public static final int VK_BrowserForward = 0xA7;

	public static final int VK_BrowserRefresh = 0xA8;

	public static final int VK_BrowserStop = 0xA9;

	public static final int VK_BrowserSearch = 0xAA;

	public static final int VK_BrowserFavorites = 0xAB;

	public static final int VK_BrowserStartAndHome = 0xAC;

	public static final int VK_VolumeMute = 0xAD;

	public static final int VK_VolumeDown = 0xAE;

	public static final int VK_VolumeUp = 0xAF;

	public static final int VK_MediaNext = 0xB0;

	public static final int VK_MediaPrevious = 0xB1;

	public static final int VK_MediaStop = 0xB2;

	public static final int VK_MediaPlayPause = 0xB3;

	public static final int VK_StartMail = 0xB4;

	public static final int VK_SelectMedia = 0xB5;

	public static final int VK_StartApplication1 = 0xB6;

	public static final int VK_StartApplication2 = 0xB7;


	public static final int VK_SemiColon_Colon = 0xBA;

	public static final int VK_Equals_plus = 0xBB;

	public static final int VK_Comma_LessThan = 0xBC;

	public static final int VK_Minus_Underscore = 0xBD;

	public static final int VK_Dot_GraterThan = 0xBE;

	public static final int VK_Slash_QuestionMark = 0xBF;

	public static final int VK_Accent_Tilde = 0xC0;


	public static final int VK_LBrack_LCurly = 0xDB;


	public static final int VK_BackSlashPipe = 0xDC;

	public static final int VK_RBrack_RCurly = 0xDD;

	public static final int VK_Quotes = 0xDE;
	
	public static final int VK_Play = 0xFA;

	public static final int VK_Zoom = 0xFB;

	// </editor-fold>
}
