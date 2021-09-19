/*
 * Logger
 * PrintFormat.java
 * Copyright © 2021 Fabius Mettner
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <https://www.gnu.org/licenses/>.
 */

package de.noisruker.logger;

/**
 * Das Print Format ist wichtig für die Logger Klasse und bestimmt die
 * angegebenen zusatzinformationen. Je kleiner der Wert, desto weniger
 * zusatzinformationen werden mitgegeben.
 * 
 * @author Juhu1705
 * @category Log
 */
public enum PrintFormat {
	ONLY_MESSAGE(0), TIME(1), LEVEL(2), CLASS_SHORT(3), LOGGER(4), CLASS(5), ALL(100);

	private int level;

	PrintFormat(int level) {
		this.level = level;
	}

	public int getLevel() {
		return this.level;
	}
}
