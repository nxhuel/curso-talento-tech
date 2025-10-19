import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static List<Article> articles = new ArrayList<>();
    public static int idCounter = 1;

    public static int generateId() {
        return idCounter++;
    }


    public static void createArticle() {
        scanner.nextLine();
        Article savedArticle = new Article();

        System.out.println("Ingrese el nombre del articulo: ");
        String name = scanner.nextLine();

        System.out.println("Ingrese la descripción del articulo: ");
        String description = scanner.nextLine();

        savedArticle.setId(generateId());
        savedArticle.setName(name);
        savedArticle.setDescription(description);
        articles.add(savedArticle);
        System.out.println("Artículo creado con éxito ✅");

    }

    public static void findAllArticles() {
        if (articles.isEmpty()) {
            System.out.println("No hay articulos disponibles");
            return;
        }

        System.out.println("=== Lista de Articulos ===");
        for (Article article : articles) {
            System.out.println(article.getId() + ". " + article.getName() + " - " + article.getDescription());
        }
    }

    public static void findArticleById() {
        System.out.println("Ingrese el ID del articulo a buscar: ");
        int requestId = scanner.nextInt();
        scanner.nextLine();

        Article found = findById(requestId);

        if (found == null) {
            System.out.println("No existe artículo con ese ID");
        } else {
            System.out.println("➡ " + found.getName() + " - " + found.getDescription());
        }
    }

    public static void updateArticleById() {
        System.out.println("Ingrese el ID del articulo para actualizar: ");
        int requestId = scanner.nextInt();
        scanner.nextLine();

        Article found = findById(requestId);
        if (found == null) {
            System.out.println("No existe artículo con ese ID");
            return;
        }

        System.out.println("Ingrese el nuevo nombre del articulo " + found.getName() + ": ");
        String name = scanner.nextLine();

        System.out.println("Ingrese la nueva descripción del articulo" + found.getDescription() + ": ");
        String description = scanner.nextLine();

        found.setName(name);
        found.setDescription(description);

        System.out.println("Artículo actualizado con éxito");
    }

    public static void deleteArticleById() {
        System.out.println("Ingrese el ID del articulo para eliminar: ");
        int requestId = scanner.nextInt();
        scanner.nextLine();

        Article found = findById(requestId);
        if (found == null) {
            System.out.println("No existe artículo con ese ID");
            return;
        }

        articles.remove(found);
        System.out.println("Artículo eliminado con éxito ️");
    }

    private static Article findById(int id) {
        for (Article article : articles) {
            if (article.getId() == id) {
                return article;
            }
        }
        return null;
    }

    public static void main(String[] args) {
//        Datos de prueba
        Article article1 = new Article(generateId(), "Messi", "Historia del 10");
        Article article2 = new Article(generateId(), "La NASA", "Misterios de la nasa");
        Article article3 = new Article(generateId(), "IA", "La innovacion que ofrece la IA");
        Article article4 = new Article(generateId(), "Casos Policiales", "Top 10 novelas policiaes");

        articles.add(article1);
        articles.add(article2);
        articles.add(article3);
        articles.add(article4);
//        Sistema
        int option;
        System.out.println("Bienvenido a la gestión de articulos");

        do {
            System.out.println("\n=== Menú de Artículos ===");
            System.out.println("1. Crear artículo");
            System.out.println("2. Listar artículos");
            System.out.println("3. Ver artículo");
            System.out.println("4. Editar artículo");
            System.out.println("5. Eliminar artículo");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            option = scanner.nextInt();

            switch (option) {
                case 1 -> createArticle();
                case 2 -> findAllArticles();
                case 3 -> findArticleById();
                case 4 -> updateArticleById();
                case 5 -> deleteArticleById();
                case 6 -> System.out.println("Gracias por visitarnos");
                default -> System.out.println("Opción inválida");
            }
        } while (option != 6);
    }
}