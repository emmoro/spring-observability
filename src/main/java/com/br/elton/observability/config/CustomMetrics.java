package com.br.elton.observability.config;

import io.micrometer.core.instrument.*;
import io.micrometer.core.instrument.binder.MeterBinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

@Component
public class CustomMetrics implements MeterBinder {

    private final static String SYSTEM = "app_observability";

    @Autowired
    private MeterRegistry meterRegistry;

    @Override
    public void bindTo(MeterRegistry registry) {
        Gauge.builder("generic_metric", this, value -> obterQuantidadeFilmesComprados())
                .description("generic_metric_total")
                .tags(Tags.of(Tag.of("data", LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")))))
                .baseUnit(SYSTEM)
                .register(registry);
    }

    public void insertCustomMetrics(String descriptionMetric, String detailedDescription) {
        Counter.builder(descriptionMetric)
                .description(detailedDescription)
                .tag("date", LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")))
                .register(meterRegistry)
                .increment(1);
    }

    public Integer obterQuantidadeFilmesComprados() {
        return new Random().nextInt(8);
    }

}
