/*
 * SwingHelper.java
 * This file is part of Portecle, a multipurpose keystore and certificate tool.
 *
 * Copyright © 2007 Ville Skyttä, ville.skytta@iki.fi
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301, USA.
 */

package net.sf.portecle.gui;

import java.awt.Window;
import java.lang.reflect.InvocationTargetException;

import javax.swing.SwingUtilities;

/**
 * Swing helper.
 */
public class SwingHelper
{
	/** Not needed. */
	private SwingHelper()
	{
	}

	/**
	 * Makes the given Window visible and waits for it to return.
	 * 
	 * @param window The window
	 */
	public static void showAndWait(final Window window)
	{
		if (SwingUtilities.isEventDispatchThread())
		{
			window.setVisible(true);
		}
		else
		{
			try
			{
				SwingUtilities.invokeAndWait(new Runnable()
				{
					public void run()
					{
						window.setVisible(true);
					}
				});
			}
			catch (InterruptedException e)
			{
				e.printStackTrace(); // TODO?
			}
			catch (InvocationTargetException e)
			{
				e.printStackTrace(); // TODO?
			}
		}
	}
}
