module de.noisruker.logger {
    requires java.logging;
    requires de.noisruker.event;

    exports de.noisruker.logger.events;
    exports de.noisruker.logger;
}