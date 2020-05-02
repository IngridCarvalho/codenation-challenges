package challenge;

public class CriptografiaCesariana implements Criptografia {

    final int NUM_SKIP = 3;

    @Override
    public String criptografar(String text) {
        return this.iterateTexto(text, "encrypt");
    }

    @Override
    public String descriptografar(String text) {
        return this.iterateTexto(text, "decrypt");
    }

    private String iterateTexto(String text, String type) {


        StringBuilder encrypt = new StringBuilder();

        this.validateText(text);
        text = text.toLowerCase();

        for(int i=0; i< text.length(); i++) {
            int letterValue = text.charAt(i);

            if (type == "encrypt") {
                encrypt.append(encryptLetter(letterValue));
            } else {
                encrypt.append(decryptLetter(letterValue));
            }
        }
        return encrypt.toString();
    }

    private char encryptLetter(int letter) {
        int letterResult;

        if (letter >= 97 && letter <= 119) {
            letterResult = letter + NUM_SKIP;
        } else if(letter >= 119 && letter <= 122) {
            letter = letter - 122;
            letterResult = 96 + (NUM_SKIP - letter);
        } else {
            letterResult = letter;
        }

        return (char) letterResult;
    }

    private char decryptLetter(int letter) {
        int letterResult;

        if (letter >= 100 && letter <= 122) {
           letterResult = letter - NUM_SKIP;
        } else if (letter >= 97 && letter <= 99) {
            letter = letter - 97;
            letterResult = 96 - (NUM_SKIP - letter);
        } else {
            letterResult = letter;
        }

        return (char) letterResult;
    }

    private void validateText(String text) {
        if (text == null) throw new NullPointerException("Text must not be null");
        if (text.isEmpty()) throw new IllegalArgumentException("Text must not be empty");
    }
}
