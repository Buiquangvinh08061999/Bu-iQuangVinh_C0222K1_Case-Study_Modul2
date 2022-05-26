package vn.vb.accessory.shop.model;



public enum Role {

    ADMIN("ADMIN"),
    USER("USER");

    private String value;

    private Role(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public static Role parseRole(String value) {
        Role[] values = values();
        for (Role str : values) {
            if (str.value.equals(value))
                return str;
        }
        throw new IllegalArgumentException("invalid");

    }


    }



