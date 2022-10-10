package com.baeldung;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.sse.OutboundSseEvent;
import javax.ws.rs.sse.Sse;
import javax.ws.rs.sse.SseBroadcaster;
import javax.ws.rs.sse.SseEventSink;

@Path("stock")
@ApplicationScoped
public class SseResource {

    @Inject
    private StockService stockService;

    private Sse sse;
    private SseBroadcaster sseBroadcaster;
    private OutboundSseEvent.Builder eventBuilder;

    @Context
    public void setSse(Sse sse) {
        this.sse = sse;
        this.eventBuilder = sse.newEventBuilder();
        this.sseBroadcaster = sse.newBroadcaster();
    }

    private volatile boolean running = true;

    @GET
    @Path("prices")
    @Produces("text/event-stream")
    public void getStockPrices(@Context SseEventSink sseEventSink,
                               @HeaderParam(HttpHeaders.LAST_EVENT_ID_HEADER) @DefaultValue("-1") int lastReceivedId) {
        int lastEventId = 1;
        if (lastReceivedId != -1) {
            lastEventId = ++lastReceivedId;
        }
        boolean running = true;
        while (running) {
            Stock stock = stockService.getNextTransaction(lastEventId);
            if (stock != null) {
                OutboundSseEvent sseEvent = eventBuilder
                        .name("stock")
                        .id(String.valueOf(lastEventId))
                        .mediaType(MediaType.APPLICATION_JSON_TYPE)
                        .data(Stock.class, stock)
                        .reconnectDelay(3000)
                        .comment("Price changed")
                        .build();
                sseEventSink.send(sseEvent);
                lastEventId++;
            }

            if (lastEventId % 5 == 0) {
                sseEventSink.close();
                break;
            }


            try {
                Thread.sleep(5 * 1000);
            } catch (InterruptedException ignored) {
            }

            running = lastEventId <= 2000;
        }
        sseEventSink.close();
    }

    @GET
    @Path("subscribe")
    @Produces(MediaType.SERVER_SENT_EVENTS)
    public void listen(@Context SseEventSink sseEventSink) {
        sseEventSink.send(sse.newEvent("Welcome!"));
        sseBroadcaster.register(sseEventSink);
        sseEventSink.send(sse.newEvent("You are registered!"));
    }

    @GET
    @Path("publish")
    public void broadcast() {
        Runnable runnable = () -> {
            int lastEventId = 0;
            boolean running = true;
            while (running) {
                lastEventId++;
                Stock stock = stockService.getNextTransaction(lastEventId);
                if (stock != null) {
                    OutboundSseEvent sseEvent = eventBuilder
                            .name("stock")
                            .id(String.valueOf(lastEventId))
                            .mediaType(MediaType.APPLICATION_JSON_TYPE)
                            .data(Stock.class, stock)
                            .reconnectDelay(3000)
                            .comment("Price changed")
                            .build();
                    sseBroadcaster.broadcast(sseEvent);
                }
                try {
                    Thread.sleep(5 * 1000);
                } catch (InterruptedException ignored) {
                }
                running = lastEventId <= 2000;
            }
        };
        new Thread(runnable).start();
    }

}
