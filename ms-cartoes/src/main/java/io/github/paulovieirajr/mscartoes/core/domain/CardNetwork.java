package io.github.paulovieirajr.mscartoes.core.domain;

public enum CardNetwork {
    MASTERCARD("Mastercard"),
    VISA("Visa"),
    AMERICAN_EXPRESS("American Express");

    private final String name;

    CardNetwork(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
