package Controller.Factory;

import View.Factory.Linux;
import View.Factory.Mac;
import View.Factory.Windows;

public class Factory {

    public OperatingSystem getOs(String OsType) {
        if (OsType.equalsIgnoreCase("Linux")) {
            return new Linux();
        } else if (OsType.equalsIgnoreCase("MacOS")) {
            return new Mac();
        } else if (OsType.equalsIgnoreCase("Windows")) {
            return new Windows();
        }

        return null;
    }
}