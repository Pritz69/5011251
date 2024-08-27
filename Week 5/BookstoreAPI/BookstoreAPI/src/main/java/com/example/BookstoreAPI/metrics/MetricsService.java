package com.example.BookstoreAPI.metrics;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Service;

@Service
public class MetricsService {

    public MetricsService(MeterRegistry meterRegistry) {
        meterRegistry.counter("custom.metric.book.requests").increment();
    }
}
