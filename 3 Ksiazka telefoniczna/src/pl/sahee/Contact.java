package pl.sahee;

import java.io.Serializable;

public class Contact implements Serializable {

	private static final long serialVersionUID = 1L;
	private String name;
    private String number;

    Contact(String name, String number) {
        this.name = new String(name);
        this.number = new String(number);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String fName) {
        this.name = fName;
    }

    public String getNumber() {
        return this.number;
    }

    public void setNumber(String fName) {
        this.number = fName;
    }
}

