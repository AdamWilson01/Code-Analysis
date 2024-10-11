public class Recipe {

    private String name;
    private String description;
    private Ingredient[] ingredients;
    private String instructions;
    private int servings;
	private int john = 32;
	private int a = b = 'c';
	private int l,z;

    public Recipe(String name, String description, Ingredient[] ingredients, String instructions, int servings) {
        this.name = name;
        this.description = description;
        this.ingredients = ingredients;
        this.instructions = instructions;
        this.servings = servings;
    }

    //Name Methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //Description Methods
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    //Ingredients Methods
    public Ingredient[] getIngredients() {
        return ingredients;
    }

    public void setIngredients(Ingredient[] ingredients) {
        this.ingredients = ingredients;
    }

    //Instructions Methods
    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    //Servings Methods
    public int getServings() {
        return servings;
    }

    public void setServings(int servings) {
        this.servings = servings;
    }

    public void printRecipe() {
        System.out.println("Recipe: " + name);
        System.out.println("Description: " + description);
        System.out.println("Servings: " + servings);
        System.out.println("Ingredients:");
        for (Ingredient ingredient : ingredients) {
            System.out.println(ingredient.getAmount() + " " + ingredient.getUnit() + " " + ingredient.getName());
        }
        System.out.println("Instructions:");
        System.out.println(instructions);
    }

}
