import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BankAccountTest {

    private BankAccount account;

    @BeforeEach
    void setUp() {
        account = new BankAccount();
    }

    @Test
    void saldoAwal_nol() {
        assertEquals(0.0, account.getBalance());
    }

    @Test
    void deposit_valid_saldoBertambah() {
        account.deposit(1000);
        assertEquals(1000.0, account.getBalance());
    }

    @Test
    void deposit_negatif_throwException() {
        assertThrows(IllegalArgumentException.class, () -> account.deposit(-100));
    }

    @Test
    void withdraw_valid_saldoBerkurang() {
        account.deposit(1000);
        account.withdraw(400);
        assertEquals(600.0, account.getBalance());
    }

    @Test
    void withdraw_semuaSaldo_saldoNol() {
        account.deposit(500);
        account.withdraw(500);
        assertEquals(0.0, account.getBalance());
    }

    @Test
    void withdraw_negatif_throwException() {
        account.deposit(1000);
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(-50));
    }

    @Test
    void withdraw_melebihiSaldo_throwException() {
        account.deposit(100);
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(200));
    }

    @Test
    void deposit_beberapaKali_saldoAkumulatif() {
        account.deposit(100);
        account.deposit(250);
        assertEquals(350.0, account.getBalance());
    }
}
