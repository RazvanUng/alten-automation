package utils;

//pentru a prelua variabile de sistem ca la config.properties
//nu folosim ca nu putem umbla la variabile de sistem
// ! Trebuie sa dam restrt la Intellij pentru a putea sa le citeasca corect
public class SystemVariableReader {

    public static String BROWSER = System.getenv("DEFAULT_BROWSER");
    public static String ENV = System.getenv("CURRENT_ENV");




}
