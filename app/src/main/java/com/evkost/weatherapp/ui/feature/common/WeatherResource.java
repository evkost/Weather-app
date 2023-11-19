package com.evkost.weatherapp.ui.feature.common;

public class WeatherResource {
    private int messageId;

    private int iconId;

    private int backgroundId;

    public WeatherResource(int messageId, int iconId, int backgroundId) {
        this.messageId = messageId;
        this.iconId = iconId;
        this.backgroundId = backgroundId;
    }

    public int getMessageId() {
        return messageId;
    }

    public int getIconId() {
        return iconId;
    }

    public int getBackgroundId() {
        return backgroundId;
    }
}
