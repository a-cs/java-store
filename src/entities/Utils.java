package entities;

public class Utils {
    public static boolean isValid(String name) {
        if (name != null && !name.equals(""))
            return true;
        return false;
    }

    public boolean isUnique(String name) {
        return false;
    }

    public boolean isUnique(String name, Brand brand) {
        return false;
    }
}
