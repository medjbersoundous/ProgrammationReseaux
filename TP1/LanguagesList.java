import java.util.ArrayList;
public class LanguagesList {
    public static void main(String[] args) {
        ArrayList<String> languages = new ArrayList<>();
        languages.add("PHP");
        languages.add("Java");
        languages.add("C++");
        languages.add("Python");
        System.out.println("Collection initiale:");
        System.out.println(languages);
        System.out.println("Parcours avec boucle for:");
        for (int i = 0; i < languages.size(); i++) {
            System.out.println("Élément " + i + ": " + languages.get(i));
        }
        languages.add(0, "Pascal");
        System.out.println("Après insertion de Pascal en première position:");
        System.out.println(languages);
        String troisiemeElement = languages.get(2);
        System.out.println(" Le troisième élément est: " + troisiemeElement);
        languages.set(2, "COBOL");
        System.out.println("Après mise à jour du troisième élément:");
        System.out.println(languages);
        languages.remove(2);
        System.out.println(" Après suppression du troisième élément:");
        System.out.println(languages);
    }
}
