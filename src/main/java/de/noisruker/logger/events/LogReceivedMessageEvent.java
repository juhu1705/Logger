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
 */
public class LogReceivedMessageEvent extends Event<Void> {

    /**
     * The record of this log message
     */
    private final LogRecord record;
    /**
     * The formatted message ready for printing
     */
    private final String formattedMessage;

    /**
     * Creates a new Log Event including the events name. This is for calls by children classes
     * @param name The events name
     * @param record The record from the log message
     * @param formattedMessage The ready for print formatted log message
     */
    protected LogReceivedMessageEvent(String name, LogRecord record, String formattedMessage) {
        super(name);
        this.record = record;
        this.formattedMessage = formattedMessage;
    }

    /**
     * Creates a new message log event with the given record and the formatted message
     * @param record The record of the log message
     * @param formattedMessage The ready for print formatted log message
     */
    public LogReceivedMessageEvent(LogRecord record, String formattedMessage) {
        this("message log event", record,formattedMessage);
    }

    /**
     * @return The unformatted log message
     */
    @SuppressWarnings("unused")
    public String getRawMessage() {
        return this.record.getMessage();
    }

    /**
     * @return The message that was formatted by the LoggingFormatter
     */
    @SuppressWarnings("unused")
    public String getConsoleMessage() {
        return this.formattedMessage;
    }

    /**
     * @return The log messages record, with all important information
     */
    @SuppressWarnings("unused")
    public LogRecord getRecord() {
        return this.record;
    }

}
