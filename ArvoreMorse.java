class ArvoreMorse {
    private NodeMorse raiz;
    public ArvoreMorse() {
        // Inicializa a árvore com um nó raiz vazio
        raiz = new NodeMorse('\0'); //caractere nulo
        inicializarArvore();
    }
    private void inicializarArvore() {
        // Inserção das letras do alfabeto com seus códigos Morse
        inserirCaractere('E', ".");
        inserirCaractere('T', "-");
        inserirCaractere('I', "..");
        inserirCaractere('A', ".-");
        inserirCaractere('N', "-.");
        inserirCaractere('M', "--");
        inserirCaractere('S', "...");
        inserirCaractere('U', "..-");
        inserirCaractere('R', ".-.");
        inserirCaractere('W', ".--");
        inserirCaractere('D', "-..");
        inserirCaractere('K', "-.-");
        inserirCaractere('G', "--.");
        inserirCaractere('O', "---");
        inserirCaractere('H', "....");
        inserirCaractere('V', "...-");
        inserirCaractere('F', "..-.");
        inserirCaractere('L', ".-..");
        inserirCaractere('P', ".--.");
        inserirCaractere('J', ".---");
        inserirCaractere('B', "-...");
        inserirCaractere('X', "-..-");
        inserirCaractere('C', "-.-.");
        inserirCaractere('Y', "-.--");
        inserirCaractere('Z', "--..");
        inserirCaractere('Q', "--.-");
    }

    public void inserirCaractere(char letra, String codigoMorse) {
        NodeMorse atual = raiz;

        for (char c : codigoMorse.toCharArray()) {
            if (c == '.') {
                if (atual.esquerda == null) {
                    atual.esquerda = new NodeMorse('\0');
                }
                atual = atual.esquerda;
            } else if (c == '-') {
                if (atual.direita == null) {
                    atual.direita = new NodeMorse('\0');
                }
                atual = atual.direita;
            }
        }
        atual.letra = letra;
    }

    public String decodificarMensagem(String mensagemMorse) {
        StringBuilder mensagemDecodificada = new StringBuilder();
        String[] palavras = mensagemMorse.split(" ");

        for (String palavra : palavras) {
            if (!palavra.isEmpty()) {
                char caractereDecodificado = decodificarCaractere(palavra);
                mensagemDecodificada.append(caractereDecodificado);
            }
        }

        return mensagemDecodificada.toString();
    }

    private char decodificarCaractere(String codigoMorse) {
        NodeMorse atual = raiz;

        for (char c : codigoMorse.toCharArray()) {
            if (c == '.') {
                atual = atual.esquerda;
            } else if (c == '-') {
                atual = atual.direita;
            }

            if (atual == null) {
                return '?';
            }
        }

        return atual.letra;
    }

    public void imprimirArvore() {
        imprimirArvoreRecursivo(raiz, "", true);
    }

    private void imprimirArvoreRecursivo(NodeMorse no, String prefixo, boolean isDireita) {
        if (no == null) return;

        System.out.println(prefixo + (isDireita ? "├── " : "└── ") +
                (no.letra == '\0' ? "*" : no.letra));

        imprimirArvoreRecursivo(no.direita, prefixo + (isDireita ? "│   " : "    "), true);
        imprimirArvoreRecursivo(no.esquerda, prefixo + (isDireita ? "│   " : "    "), false);
    }
    public boolean isCodigoMorseValido(String codigo) {
        // Verifica se a string está vazia
        if (codigo.trim().isEmpty()) {
            return false;
        }
        // Divide a mensagem em caracteres individuais
        String[] caracteres = codigo.split(" ");

        for (String caractere : caracteres) {
            // Verifica se cada caractere contém apenas pontos e traços
            if (!caractere.matches("^[.-]+$")) {
                return false;
            }

            // Verifica se existe um caminho válido na árvore para este código
            if (!existeCaminhoValido(caractere)) {
                return false;
            }
        }
        return true;
    }

    private boolean existeCaminhoValido(String codigo) {
        NodeMorse atual = raiz;

        for (char c : codigo.toCharArray()) {
            if (c == '.') {
                atual = atual.esquerda;
            } else if (c == '-') {
                atual = atual.direita;
            }

            if (atual == null) {
                return false;
            }
        }

        return atual.letra != '\0'; // Verifica se é um nó válido (tem caractere)
    }
}