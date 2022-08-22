package escola;

public class Email {

    public Email(String endereco) {
        if (endereco == null || !endereco.matches("^[a-zA-Z0-9._]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
            throw new IllegalArgumentException("E-mail invalido!");
        }
        this.endereco = endereco;
    }

    private String endereco;

    public String getEndereco() {
        return endereco;
    }
}
