/*
 * Logger
 * Logger.java
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

import de.noisruker.logger.handles.FileLoggingHandler;
import de.noisruker.logger.handles.LoggingFormatter;
import de.noisruker.logger.handles.LoggingHandler;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Paths;
import java.util.logging.Handler;
import java.util.logging.Level;

/**
 * Here you can find the Logger
 */
public class Logger {

    /**
     * The Logger to log to, if you want to use this project
     */
    public static final java.util.logging.Logger LOGGER;

    static {
        String home = Paths.get(Settings.HOME_FOLDER, Settings.PROGRAMM_FOLDER).toString();
        LOGGER = java.util.logging.Logger.getLogger(Settings.LOGGER_NAME);
        LOGGER.setUseParentHandlers(false);
        Handler handler = new LoggingHandler();

        if (!Files.exists(FileSystems.getDefault().getPath(home), LinkOption.NOFOLLOW_LINKS))
            new File(home).mkdir();
        try {
            Handler file = new FileLoggingHandler(Paths.get(home, Settings.LOGGER_NAME + ".log").toString());
            file.setFormatter(new LoggingFormatter());
            file.setLevel(Level.ALL);
            LOGGER.addHandler(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        handler.setFormatter(new LoggingFormatter());
        handler.setLevel(Level.ALL);
        LOGGER.addHandler(handler);
        LOGGER.setLevel(Level.ALL);
    }

}
