void main() {

    Scanner scanner = new Scanner(System.in);

    try {
        System.out.println("Enter a whole number to divide: ");
        int x = scanner.nextInt();

        System.out.println("Enter a whole number to divide by: ");
        int y = scanner.nextInt();

        int z = x / y;

        System.out.println("Result: " + z);
    }
    catch (ArithmeticException e){
        System.out.println("You can't divide by zero");
    }
    catch (InputMismatchException e){
        System.out.println("You can't divide by letters");
    }
    finally {
        scanner.close();
    }
}
