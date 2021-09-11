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

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

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

        sb.append("[").append(LocalDateTime.now().format(dateTimeFormatter)).append("] [").append(record.getLevel())
                .append(" | ").append(record.getSourceClassName()).append("] ").append(record.getMessage()).append("\n");

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
