import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
class ToyShop {
    private List<Toy> toys;
    private List<Toy> prizeToys;

    public ToyShop() {
        toys = new ArrayList<>();
        prizeToys = new ArrayList<>();
    }

    public void addNewToy(int id, String name, int quantity, int dropFrequency) {
        Toy toy = new Toy(id, name, quantity, dropFrequency);
        toys.add(toy);
    }

    public void changeDropFrequency(int toyId, int newFrequency) {
        for (Toy toy : toys) {
            if (toy.getId() == toyId) {
                toy.setDropFrequency(newFrequency);
                break;
            }
        }
    }

    public void drawToy() {
        Random random = new Random();
        int totalFrequency = toys.stream().mapToInt(Toy::getDropFrequency).sum();
        int randomNumber = random.nextInt(totalFrequency);
        int cumulativeFrequency = 0;

        for (Toy toy : toys) {
            cumulativeFrequency += toy.getDropFrequency();
            if (randomNumber < cumulativeFrequency) {
                if (toy.getQuantity() > 0) {
                    prizeToys.add(toy);
                    toy.setQuantity(toy.getQuantity() - 1);
                    System.out.println("Congratulations! You've won a " + toy.getName());
                } else {
                    System.out.println("Sorry, this toy is out of stock.");
                }
                break;
            }
        }
    }

    public void getPrizeToy() {
        if (!prizeToys.isEmpty()) {
            Toy prizeToy = prizeToys.remove(0);
            try {
                FileWriter writer = new FileWriter("prize_toys.txt", true);
                writer.write("ID: " + prizeToy.getId() + ", Name: " + prizeToy.getName() + "\n");
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("No prize toys available.");
        }
    }

    public void displayToys() {
        System.out.println("Available Toys:");
        for (Toy toy : toys) {
            System.out.println("ID: " + toy.getId() + ", Name: " + toy.getName() + ", Quantity: " + toy.getQuantity() + ", Drop Frequency: " + toy.getDropFrequency() + "%");
        }
    }

    public void changeToyDropFrequency(int toyId, int newFrequency) {
        for (Toy toy : toys) {
            if (toy.getId() == toyId) {
                toy.setDropFrequency(newFrequency);
                break;
            }
        }
    }
}