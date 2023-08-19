package dev.mayaqq.uwufied;

import net.fabricmc.api.ClientModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Uwufied implements ClientModInitializer {

    public static final Logger LOGGER = LoggerFactory.getLogger("Uwufied");

    @Override
    public void onInitializeClient() {
        LOGGER.info("uwu");
    }
}
