package com.evkost.weatherapp.domain;

import java.time.LocalDate;

public interface FormattedDateStringUseCase {
    String invoke(LocalDate date);
}
