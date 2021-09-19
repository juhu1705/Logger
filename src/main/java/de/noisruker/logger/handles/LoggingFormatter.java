/*
 * Logger
 * LoggingFormatter.java
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

/*
 * Logger
 * LoggingFormatter.java
 * Copyright © 2021 Niklas Elsbrock (Team Noisruker)
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

package de.noisruker.logger.handles;

import de.noisruker.logger.PrintFormat;
import de.noisruker.logger.Settings;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

import static java.time.LocalDateTime.now;
import static de.noisruker.logger.PrintFormat.*;

/**
 * Formatter für den {@link LoggingHandler}
 *
 * @author Niklas
 */
public class LoggingFormatter extends Formatter {

    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    @Override
    public String format(LogRecord record) {
        StringBuilder sb = new StringBuilder();

        String[] className = record.getSourceClassName().split("\\.");

        PrintFormat format = Settings.PRINT_FORMAT;

        if (format.getLevel() >= TIME.getLevel())
            sb.append("[").append(now().format(dateTimeFormatter)).append("] ");
        if ((format.getLevel() >= LEVEL.getLevel() && (format.getLevel() < CLASS_SHORT.getLevel() || format.getLevel() >= CLASS.getLevel())))
            sb.append("[").append(record.getLevel()).append("] ");
        if (format.getLevel() >= CLASS.getLevel())
            sb.append("[").append(Thread.currentThread().getName()).append(":").append(className[className.length - 1])
                    .append(":").append(record.getSourceMethodName()).append("] ");
        if (format.getLevel() >= LOGGER.getLevel()) {
            if (record.getLoggerName() != null)
                sb.append("[").append(record.getLoggerName()).append("] ");
        }
        if(format.getLevel() < CLASS.getLevel() && format.getLevel() >= CLASS_SHORT.getLevel()) {
            sb.append(" [").append(record.getLevel()).append(" | ").append(className[className.length - 1]).append("] ");
        }

        if (format.getLevel() >= ONLY_MESSAGE.getLevel())
            sb.append(record.getMessage());
        sb.append("\n");

        Throwable thrown = record.getThrown();
        if (thrown != null) {
            sb.append(thrown);
            sb.append("\n");

            for (StackTraceElement ste : thrown.getStackTrace()) {
                sb.append("    at ");
                sb.append(ste);
                sb.append("\n");
            }
        }

        return sb.toString();
    }

}
