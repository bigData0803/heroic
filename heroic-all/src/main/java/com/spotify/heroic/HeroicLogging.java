package com.spotify.heroic;

public class HeroicLogging {
    /**
     * Initialize all Netty logging consistently.
     * <p>
     * Netty decided it was a good idea to build their own logging framework. From this follows that
     * every time netty has been shaded, it needs to be initialized independently to properly
     * redirect all logging to SLF4j.
     */
    public static void configureNetty() {
        com.spotify.heroic.bigtable.netty.util.internal.logging.InternalLoggerFactory
            .setDefaultFactory(
            new com.spotify.heroic.bigtable.netty.util.internal.logging.Slf4JLoggerFactory());

        com.datastax.shaded.netty.util.internal.logging.InternalLoggerFactory.setDefaultFactory(
            new com.datastax.shaded.netty.util.internal.logging.Slf4JLoggerFactory());

        io.netty.util.internal.logging.InternalLoggerFactory.setDefaultFactory(
            new io.netty.util.internal.logging.Slf4JLoggerFactory());

        org.elasticsearch.common.netty.logging.InternalLoggerFactory.setDefaultFactory(
            new org.elasticsearch.common.netty.logging.Slf4JLoggerFactory());
    }
}
