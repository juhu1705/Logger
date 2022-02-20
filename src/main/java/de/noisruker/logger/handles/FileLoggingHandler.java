/*
 * Logger
 * FileLoggingHandler.java
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
 * FileLoggingHandler.java
 * Copyright © 2021 Niklas Elsbrock (Team Noisruker)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package de.noisruker.logger.handles;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

/**
 * Handler for the Logging-API
 *
 * @author Niklas
 */
public class FileLoggingHandler extends Handler {

    /**
     * The file printer to print to
     */
    private final PrintWriter writer;

    /**
     * Creates a logging handler that writes to the given file
     * @param file The file to write the log into
     * @throws IOException If accessing the file failed
     */
    public FileLoggingHandler(String file) throws IOException {
        this.writer = new PrintWriter(file, StandardCharsets.UTF_8);
    }

    @Override
    public void publish(LogRecord record) {
        String output = this.getFormatter().format(record);

        this.writer.print(output);
    }

    @Override
    public synchronized void flush() {
        this.writer.flush();
    }

    @Override
    public synchronized void close() throws SecurityException {
        this.writer.close();
    }

}
