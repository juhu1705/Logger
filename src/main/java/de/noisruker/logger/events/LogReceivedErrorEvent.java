/*
 * Logger
 * LogReceivedErrorEvent.java
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

package de.noisruker.logger.events;

import java.util.logging.LogRecord;

/**
 * An error LogMessage. This is a log message fired when an error LogMessage is received by the log
 */
public class LogReceivedErrorEvent extends LogReceivedMessageEvent {

    /**
     * Creates a new error log event with its log record and the ready for print formatted message
     *
     * @param record The log messages record
     * @param formattedMessage The ready for print formatted log message
     */
    public LogReceivedErrorEvent(LogRecord record, String formattedMessage) {
        super("error log event", record, formattedMessage);
    }

    /**
     * @return The stacktrace of the error
     */
    @SuppressWarnings("unused")
    public Throwable getThrown() {
        return super.getRecord().getThrown();
    }

}
