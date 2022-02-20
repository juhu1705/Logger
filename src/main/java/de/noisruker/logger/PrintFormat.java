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
 * The print format is important to calculate the loggers extra information.
 * A higher value means more information to be written to the formatted logs message.
 */
public enum PrintFormat {
	ONLY_MESSAGE(0), TIME(1), LEVEL(2), CLASS_SHORT(3), LOGGER(4), CLASS(5), ALL(100);

	/**
	 * The logging level for the print format. For higher numbers more explanations where added to the log
	 */
	private final int level;

	/**
	 * A new enum type print format with its level
	 * @param level The level of the print format
	 */
	PrintFormat(int level) {
		this.level = level;
	}

	/**
	 * @return The level of the print format
	 */
	public int getLevel() {
		return this.level;
	}
}
