/*
 * Logger
 * LogReceivedMessageEvent.java
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

import de.noisruker.event.events.Event;

import java.util.logging.LogRecord;

/**
 * A LogMessage send to the event Manager when the log received a message
 *
 * @author Fabius Mettner
 */
public class LogReceivedMessageEvent extends Event {

    private final LogRecord record;
    private final String formattedMessage;

    protected LogReceivedMessageEvent(String name, LogRecord record, String formattedMessage) {
        super(name);
        this.record = record;
        this.formattedMessage = formattedMessage;
    }

    public LogReceivedMessageEvent(LogRecord record, String formattedMessage) {
        this("LogEvent", record,formattedMessage);
    }

    /**
     * @return The unformatted log message
     */
    public String getRawMessage() {
        return this.record.getMessage();
    }

    /**
     * @return The message that was formatted by the LoggingFormatter
     */
    public String getConsoleMessage() {
        return this.formattedMessage;
    }

    /**
     * @return The log messages record, with all important information
     */
    public LogRecord getRecord() {
        return this.record;
    }

}
