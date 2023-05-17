public class PizzaCalculator {
    //Declare constants
    public static final int NUM_SLICES_PER_PEOPLE = 3;
    public static final int NUM_SLICES_PER_PIZZA = 8;

    public static void main(String[] args)
    {
        //The user enters 4 arguments [Other pizzas people] [Vegetarians] [Gluten free people] [Vegetarians + Gluten Free]
        if(args.length == 4)
        {
            try
            {
                //Declare Variables
                //0 is others
                //1 is vegetarians
                //2 is the number of gluten-free people
                //3 is the number of vegetarian and gluten-free combined
                int[] numPizzas = new int[4];
                int totalPizzas = 0;
                int numPeople = 0;
                //Get the inputs
                for(int i = 0; i < 4; i++)
                {
                    numPizzas[i] = CalculateNumPizzas(Integer.parseInt(args[i])); //Calculate num pizzas for each people by dietary needs
                    totalPizzas += numPizzas[i]; //Add number of pizzas
                    numPeople += Integer.parseInt(args[i]); //Add number of people
                }
                //Print the statements
                System.out.println(numPeople + " are in the pizza party");
                System.out.println(args[0] + " people can have any other pizza flavours");
                System.out.println(args[1] + " people need vegetarian pizzas");
                System.out.println(args[2] + " people need gluten free pizzas");
                System.out.println(args[3] + " people need vegetarian and gluten free combined pizzas");
                System.out.println(totalPizzas + " pizzas to order.");
                System.out.println(numPizzas[0] + " are other flavours like Hawaiian");
                System.out.println(numPizzas[1] + " pizzas needed to be vegetarian");
                System.out.println(numPizzas[2] + " pizzas needed to be gluten free");
                System.out.println(numPizzas[3] + " pizzas needed to be vegetarian and gluten free");
            }
            catch (Exception e)
            {
                System.err.println("Please enter integers only");
            }
        }
        else
        {
            System.err.println("Please enter 4 arguments to run the pizza calculator");
        }
    }

    //This method calculates the number of pizzas to order for each number of people by dietary needs
    //Lets assume that everyone needs 3 slices
    //Assume there are 8 slices of pizza
    public static int CalculateNumPizzas(int numPeople)
    {
        //Retrieve the modulo
        int modulo = (numPeople * NUM_SLICES_PER_PEOPLE) % NUM_SLICES_PER_PIZZA;
        //Retrieve numPizzas
        int numPizzas = numPeople * NUM_SLICES_PER_PEOPLE / NUM_SLICES_PER_PIZZA;
        //If modulo is 0, perfect. If not then order another pizza there will be leftovers
        return (modulo == 0 ? numPizzas : numPizzas + 1);
    }
}
