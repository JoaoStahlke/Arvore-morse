class NodeMorse {
    char letra;
    NodeMorse esquerda;  // ponto (.)
    NodeMorse direita;   // traço (-)

    public NodeMorse(char letra) {
        this.letra = letra;
        this.esquerda = null;
        this.direita = null;
    }
}