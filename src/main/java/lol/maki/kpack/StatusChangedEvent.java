package lol.maki.kpack;

public record StatusChangedEvent(AlertType alertType, String kind, String namespace, String name) {
}
