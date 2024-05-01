package DesignPattern.BuilderPattern;

public class NutritionFacts {

    public static void main(String[] args) {
        NutritionFacts cocaCola = new NutritionFacts.
                NutritionFactsBuilder(240, 8).
                calories(100).
                sodium(35).
                carbohydrate(27).
                build();
    }

    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;

    // The static nested Builder class is necessary
    public static class NutritionFactsBuilder {
        // Required parameters
        private final int servingSize;
        private final int servings;

        // Optional parameters - initialized to default values
        private int calories = 0;
        private int fat = 0;
        private int carbohydrate = 0;
        private int sodium = 0;

        public NutritionFactsBuilder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }

        public NutritionFactsBuilder calories(int val) {
            calories = val; return this;
        }

        public NutritionFactsBuilder fat(int val) {
            fat = val; return this;
        }

        public NutritionFactsBuilder carbohydrate(int val) {
            carbohydrate = val; return this;
        }

        public NutritionFactsBuilder sodium(int val) {
            sodium = val; return this;
        }

        public NutritionFacts build() {
            return new NutritionFacts(this);
        }
    }

    private NutritionFacts(NutritionFactsBuilder NutritionFactsBuilder) {
        servingSize = NutritionFactsBuilder.servingSize;
        servings = NutritionFactsBuilder.servings;
        calories = NutritionFactsBuilder.calories;
        fat = NutritionFactsBuilder.fat;
        sodium = NutritionFactsBuilder.sodium;
        carbohydrate = NutritionFactsBuilder.carbohydrate;
    }

}