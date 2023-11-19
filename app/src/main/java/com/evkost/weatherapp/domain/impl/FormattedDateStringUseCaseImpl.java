package com.evkost.weatherapp.domain.impl;

import com.evkost.weatherapp.domain.FormattedDateStringUseCase;

import java.time.LocalDate;

import javax.inject.Inject;

public class FormattedDateStringUseCaseImpl implements FormattedDateStringUseCase {
    @Inject
    public FormattedDateStringUseCaseImpl() {}

    @Override
    public String invoke(LocalDate date) {
        return date.toString();
    }
}
