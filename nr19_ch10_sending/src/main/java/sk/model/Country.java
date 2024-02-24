package sk.model;

public class Country {
    private String name;
    private int population;

    //static factory method
    public static Country of(String name, int population) {
        Country country = new Country();
        country.setName(name);
        country.setPopulation(population);
        return country;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getName() {
        return this.name;
    }

    public int getPopulation() {
        return this.population;
    }
}
