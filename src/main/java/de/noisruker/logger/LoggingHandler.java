/*
 * Logger
 * LoggingHandler.java
 * Copyright © 2021 Niklas Elsbrock, Fabius Mettner (Team Noisruker)
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

import de.noisruker.event.EventManager;
import de.noisruker.logger.events.LogReceivedErrorEvent;
import de.noisruker.logger.events.LogReceivedMessageEvent;

import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;

/**
 * Handler für Logging-API
 *
 * @author Niklas, Fabius
 */
public class LoggingHandler extends Handler {

    @Override
    public void publish(LogRecord record) {
        String output = this.getFormatter().format(record);

        if (record.getLevel().intValue() >= Level.WARNING.intValue()) {
            System.err.print(output);

            EventManager.getInstance().triggerEvent(new LogReceivedErrorEvent(record, output));
        } else {
            System.out.print(output);

            EventManager.getInstance().triggerEvent(new LogReceivedMessageEvent(record, output));
        }
    }

    @Override
    public synchronized void flush() {

    }

    @Override
    public synchronized void close() throws SecurityException {

    }

}