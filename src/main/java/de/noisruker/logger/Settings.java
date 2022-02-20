/*
 * Event Manager
 * IEventListener.java
 * Copyright © 2021 Fabius Mettner (Team Noisruker)
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
 * The settings for the Logger
 * <p>
 * HOME_FOLDER, PROGRAMM_FOLDER and LOGGER_NAME must be set before the Logger is called the first time, elsewhere changes take no effect
 */
public class Settings {

    /**
     * The users home-folder to create the programm cash folder inside
     */
    public static String HOME_FOLDER;
    /**
     * The name of the programm folder to save the log
     */
    public static String PROGRAMM_FOLDER;
    /**
     * The name the log file should have
     */
    public static String LOGGER_NAME;

    /**
     * The format messages are print to the logger
     */
    public static PrintFormat PRINT_FORMAT;

    static {
        PROGRAMM_FOLDER = "/.NoisrukerLogger/";
        HOME_FOLDER = System.getProperty("user.home");
        LOGGER_NAME = "logging";
        PRINT_FORMAT = PrintFormat.LOGGER;
    }

}
