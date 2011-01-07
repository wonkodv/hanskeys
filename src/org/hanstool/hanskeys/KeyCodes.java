/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.hanstool.hanskeys;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Wonko
 */
public class KeyCodes
{

	public static Integer get(String sVk)
	{
		Integer result = getMapStrToVK().get(sVk);
		if (result != null)
		{
			return result;
		}
		return Integer.parseInt(sVk, 16);
	}


	public static String get(int iVk)
	{
		String result = getMapVKToStr().get(iVk);
		if (result != null)
		{
			return result;
		}
		return Integer.toHexString(iVk);
	}


	public static Map<String, Integer> getMapStrToVK()
	{
		if (StrToVkMap == null)
		{
			StrToVkMap = populateKeyCodeList();
		}
		return StrToVkMap;
	}


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
		Map<String, Integer> list = new HashMap<String, Integer>(364 - 212 + 2);//zeilen nummern + etwas mehr platz
		// <editor-fold defaultstate="collapsed" desc="Fill Key Map">
		list.put("MouseLeft", 0x01);
		list.put("MouseRight", 0x02);
		list.put("Break", 0x03);
		list.put("MouseMiddle", 0x04);
		list.put("Mouse4", 0x05);
		list.put("Mouse5", 0x06);
		list.put("BackSpace", 0x08);
		list.put("Tab", 0x09);
		list.put("Clear", 0x0C);
		list.put("Enter", 0x0D);
		list.put("Shift", 0x10);
		list.put("Ctrl", 0x11);
		list.put("Alt", 0x12);
		list.put("Pause", 0x13);
		list.put("CapsLock", 0x14);
		list.put("Escape", 0x1B);
		list.put("SpaceBAr", 0x20);
		list.put("PageUp", 0x21);
		list.put("PageDown", 0x22);
		list.put("End", 0x23);
		list.put("Home", 0x24);
		list.put("ArrowLeft", 0x25);
		list.put("ArrowUp", 0x26);
		list.put("ArrowRight", 0x27);
		list.put("ArrowDown", 0x28);
		list.put("Select", 0x29);
		list.put("Print", 0x2A);
		list.put("Execute", 0x2B);
		list.put("PrintScreen", 0x2C);
		list.put("Insert", 0x2D);
		list.put("Delete", 0x2E);
		list.put("Help", 0x2F);
		list.put("0", 0x30);
		list.put("1", 0x31);
		list.put("2", 0x32);
		list.put("3", 0x33);
		list.put("4", 0x34);
		list.put("5", 0x35);
		list.put("6", 0x36);
		list.put("7", 0x37);
		list.put("8", 0x38);
		list.put("9", 0x39);
		list.put("A", 0x41);
		list.put("B", 0x42);
		list.put("C", 0x43);
		list.put("D", 0x44);
		list.put("E", 0x45);
		list.put("F", 0x46);
		list.put("G", 0x47);
		list.put("H", 0x48);
		list.put("I", 0x49);
		list.put("J", 0x4A);
		list.put("K", 0x4B);
		list.put("L", 0x4C);
		list.put("M", 0x4D);
		list.put("N", 0x4E);
		list.put("O", 0x4F);
		list.put("P", 0x50);
		list.put("Q", 0x51);
		list.put("R", 0x52);
		list.put("S", 0x53);
		list.put("T", 0x54);
		list.put("U", 0x55);
		list.put("V", 0x56);
		list.put("W", 0x57);
		list.put("X", 0x58);
		list.put("Y", 0x59);
		list.put("Z", 0x5A);
		list.put("LeftWindows", 0x5B);
		list.put("RightWindows", 0x5C);
		list.put("Applications", 0x5D);
		list.put("Reset", 0x5E);
		list.put("ComputerSleep", 0x5F);
		list.put("NP0", 0x60);
		list.put("NP1", 0x61);
		list.put("NP2", 0x62);
		list.put("NP3", 0x63);
		list.put("NP4", 0x64);
		list.put("NP5", 0x65);
		list.put("NP6", 0x66);
		list.put("NP7", 0x67);
		list.put("NP8", 0x68);
		list.put("NP9", 0x69);
		list.put("NPMultiply", 0x6A);
		list.put("NPAdd", 0x6B);
		list.put("NPSeparator", 0x6C);
		list.put("NPSubtract", 0x6D);
		list.put("NPDecimal", 0x6E);
		list.put("NPDivide", 0x6F);
		list.put("F1", 0x70);
		list.put("F2", 0x71);
		list.put("F3", 0x72);
		list.put("F4", 0x73);
		list.put("F5", 0x74);
		list.put("F6", 0x75);
		list.put("F7", 0x76);
		list.put("F8", 0x77);
		list.put("F9", 0x78);
		list.put("F10", 0x79);
		list.put("F11", 0x7A);
		list.put("F12", 0x7B);
		list.put("F13", 0x7C);
		list.put("F14", 0x7D);
		list.put("F15", 0x7E);
		list.put("F16", 0x7F);
		list.put("F17", 0x80);
		list.put("F18", 0x81);
		list.put("F19", 0x82);
		list.put("F20", 0x83);
		list.put("F21", 0x84);
		list.put("F22", 0x85);
		list.put("F23", 0x86);
		list.put("F24", 0x87);
		list.put("NumLock", 0x90);
		list.put("CrollLock", 0x91);
		list.put("ShiftLeft", 0xA0);
		list.put("ShiftRight", 0xA1);
		list.put("CtrlLeft", 0xA2);
		list.put("CtrlRight", 0xA3);
		list.put("AltLeft", 0xA4);
		list.put("AltRight", 0xA5);
		list.put("BrowserBack", 0xA6);
		list.put("BrowserForward", 0xA7);
		list.put("BrowserRefresh", 0xA8);
		list.put("BrowserStop", 0xA9);
		list.put("BrowserSearch", 0xAA);
		list.put("BrowserFavorites", 0xAB);
		list.put("BrowserStartAndHome", 0xAC);
		list.put("VolumeMute", 0xAD);
		list.put("VolumeDown", 0xAE);
		list.put("VolumeUp", 0xAF);
		list.put("MediaNext", 0xB0);
		list.put("MediaPrevious", 0xB1);
		list.put("MediaStop", 0xB2);
		list.put("MediaPlayPause", 0xB3);
		list.put("StartMail", 0xB4);
		list.put("SelectMedia", 0xB5);
		list.put("StartApplication1", 0xB6);
		list.put("StartApplication2", 0xB7);
		list.put(";:", 0xBA);
		list.put("=+", 0xBB);
		list.put(",<", 0xBC);
		list.put("-_", 0xBD);
		list.put(".>", 0xBE);
		list.put("/?", 0xBF);
		list.put("`~", 0xC0);
		list.put("[{", 0xDB);
		list.put("\\|", 0xDC);
		list.put("]}", 0xDD);
		list.put("'\"", 0xDE);
		list.put("Play", 0xFA);
		list.put("Zoom", 0xFB);
		// </editor-fold>
		return list;
	}


	private static Map<Integer, String> populateKeyCodeList2()
	{
		Map<Integer, String> list = new HashMap<Integer, String>(364 - 212 + 2);//zeilen nummern + etwas mehr platz
		// <editor-fold defaultstate="collapsed" desc="Fill Key Map">
		list.put(0x01, "MouseLeft");
		list.put(0x02, "MouseRight");
		list.put(0x03, "Break");
		list.put(0x04, "MouseMiddle");
		list.put(0x05, "Mouse4");
		list.put(0x06, "Mouse5");
		list.put(0x08, "BackSpace");
		list.put(0x09, "Tab");
		list.put(0x0C, "Clear");
		list.put(0x0D, "Enter");
		list.put(0x10, "Shift");
		list.put(0x11, "Ctrl");
		list.put(0x12, "Alt");
		list.put(0x13, "Pause");
		list.put(0x14, "CapsLock");
		list.put(0x1B, "Escape");
		list.put(0x20, "SpaceBAr");
		list.put(0x21, "PageUp");
		list.put(0x22, "PageDown");
		list.put(0x23, "End");
		list.put(0x24, "Home");
		list.put(0x25, "ArrowLeft");
		list.put(0x26, "ArrowUp");
		list.put(0x27, "ArrowRight");
		list.put(0x28, "ArrowDown");
		list.put(0x29, "Select");
		list.put(0x2A, "Print");
		list.put(0x2B, "Execute");
		list.put(0x2C, "PrintScreen");
		list.put(0x2D, "Insert");
		list.put(0x2E, "Delete");
		list.put(0x2F, "Help");
		list.put(0x30, "0");
		list.put(0x31, "1");
		list.put(0x32, "2");
		list.put(0x33, "3");
		list.put(0x34, "4");
		list.put(0x35, "5");
		list.put(0x36, "6");
		list.put(0x37, "7");
		list.put(0x38, "8");
		list.put(0x39, "9");
		list.put(0x41, "A");
		list.put(0x42, "B");
		list.put(0x43, "C");
		list.put(0x44, "D");
		list.put(0x45, "E");
		list.put(0x46, "F");
		list.put(0x47, "G");
		list.put(0x48, "H");
		list.put(0x49, "I");
		list.put(0x4A, "J");
		list.put(0x4B, "K");
		list.put(0x4C, "L");
		list.put(0x4D, "M");
		list.put(0x4E, "N");
		list.put(0x4F, "O");
		list.put(0x50, "P");
		list.put(0x51, "Q");
		list.put(0x52, "R");
		list.put(0x53, "S");
		list.put(0x54, "T");
		list.put(0x55, "U");
		list.put(0x56, "V");
		list.put(0x57, "W");
		list.put(0x58, "X");
		list.put(0x59, "Y");
		list.put(0x5A, "Z");
		list.put(0x5B, "LeftWindows");
		list.put(0x5C, "RightWindows");
		list.put(0x5D, "Applications");
		list.put(0x5E, "Reset");
		list.put(0x5F, "ComputerSleep");
		list.put(0x60, "NP0");
		list.put(0x61, "NP1");
		list.put(0x62, "NP2");
		list.put(0x63, "NP3");
		list.put(0x64, "NP4");
		list.put(0x65, "NP5");
		list.put(0x66, "NP6");
		list.put(0x67, "NP7");
		list.put(0x68, "NP8");
		list.put(0x69, "NP9");
		list.put(0x6A, "NPMultiply");
		list.put(0x6B, "NPAdd");
		list.put(0x6C, "NPSeparator");
		list.put(0x6D, "NPSubtract");
		list.put(0x6E, "NPDecimal");
		list.put(0x6F, "NPDivide");
		list.put(0x70, "F1");
		list.put(0x71, "F2");
		list.put(0x72, "F3");
		list.put(0x73, "F4");
		list.put(0x74, "F5");
		list.put(0x75, "F6");
		list.put(0x76, "F7");
		list.put(0x77, "F8");
		list.put(0x78, "F9");
		list.put(0x79, "F10");
		list.put(0x7A, "F11");
		list.put(0x7B, "F12");
		list.put(0x7C, "F13");
		list.put(0x7D, "F14");
		list.put(0x7E, "F15");
		list.put(0x7F, "F16");
		list.put(0x80, "F17");
		list.put(0x81, "F18");
		list.put(0x82, "F19");
		list.put(0x83, "F20");
		list.put(0x84, "F21");
		list.put(0x85, "F22");
		list.put(0x86, "F23");
		list.put(0x87, "F24");
		list.put(0x90, "NumLock");
		list.put(0x91, "CrollLock");
		list.put(0xA0, "ShiftLeft");
		list.put(0xA1, "ShiftRight");
		list.put(0xA2, "CtrlLeft");
		list.put(0xA3, "CtrlRight");
		list.put(0xA4, "AltLeft");
		list.put(0xA5, "AltRight");
		list.put(0xA6, "BrowserBack");
		list.put(0xA7, "BrowserForward");
		list.put(0xA8, "BrowserRefresh");
		list.put(0xA9, "BrowserStop");
		list.put(0xAA, "BrowserSearch");
		list.put(0xAB, "BrowserFavorites");
		list.put(0xAC, "BrowserStartAndHome");
		list.put(0xAD, "VolumeMute");
		list.put(0xAE, "VolumeDown");
		list.put(0xAF, "VolumeUp");
		list.put(0xB0, "MediaNext");
		list.put(0xB1, "MediaPrevious");
		list.put(0xB2, "MediaStop");
		list.put(0xB3, "MediaPlayPause");
		list.put(0xB4, "StartMail");
		list.put(0xB5, "SelectMedia");
		list.put(0xB6, "StartApplication1");
		list.put(0xB7, "StartApplication2");
		list.put(0xBA, ";:");
		list.put(0xBB, "=+");
		list.put(0xBC, ",<");
		list.put(0xBD, "-_");
		list.put(0xBE, ".>");
		list.put(0xBF, "/?");
		list.put(0xC0, "`~");
		list.put(0xDB, "[{");
		list.put(0xDC, "\\|");
		list.put(0xDD, "]}");
		list.put(0xDE, "'\"");
		list.put(0xFA, "Play");
		list.put(0xFB, "Zoom");
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

	public static final int VK_Enter = 0x0D;

	public static final int VK_Shift = 0x10;

	public static final int VK_Ctrl = 0x11;

	public static final int VK_Alt = 0x12;

	public static final int VK_Pause = 0x13;

	public static final int VK_CapsLock = 0x14;

	public static final int VK_Escape = 0x1B;

	public static final int VK_SpaceBAr = 0x20;

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

	public static final int VK_Play = 0xFA;

	public static final int VK_Zoom = 0xFB;

	// </editor-fold>
}
