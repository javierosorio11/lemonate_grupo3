package views.vo.enums;

public enum WarehouseEnum {

    wp1("PERÚ"),
    bw1("COLOMBIA"),
    dge("COSTA RICA"),
    uru("PANAMÁ");

    private String displayMessage;

    /**
     * Constructor
     *
     * @param displayMessage texto a mostrar
     */
    private WarehouseEnum(String displayMessage) {
        this.displayMessage = displayMessage;
    }

    public String getDisplayMessage() {
        return displayMessage;
    }

}
