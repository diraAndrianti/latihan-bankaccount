   public class BankAccount {
       private double balance;

       public void deposit(double amount) {
           if (amount < 0) {
               throw new IllegalArgumentException("Amount tidak boleh negatif");
           }
           balance += amount;
       }

       public void withdraw(double amount) {
           if (amount < 0) {
               throw new IllegalArgumentException("Amount tidak boleh negatif");
           }
           if (amount > balance) {
               throw new IllegalArgumentException("Saldo tidak mencukupi");
           }
           balance -= amount;
       }

       public double getBalance() {
           return balance;
       }
   }